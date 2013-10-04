package com.vectorsf.jvoice.core.uri;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.maven.artifact.Artifact;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLResource.URIHandler;
import org.eclipse.m2e.core.MavenPlugin;
import org.eclipse.m2e.core.project.IMavenProjectFacade;

import com.vectorsf.jvoice.base.model.service.BaseModel;

public class VegaXMLURIHandlerImpl implements URIHandler {

	private static final String JAR = "jar";
	private static final String SEPARATOR2 = "\\";
	private static final String GUION = "-";
	private static final String RESOURCE = "resource";
	private static final String PLATFORM = "platform";
	private static final String EMPTY = "";
	private static final String VEGA_URI = "vega:";
	private static final String SEPARATOR = "/";
	private static final String DOT = ".";
	private static final String PLATFORM_RESOURCE = "platform:/resource";
	private static final String JAR_FILE = "jar:file:/";
	private static final String ARCHIVE_SEPARATOR = "!/";
	private static final String FRAGMENT0 = "#/1";
	private static final String JV = "jv";
	private URI baseUri;
	private IMavenProjectFacade mproject = null;

	@Override
	public void setBaseURI(URI uri) {
		this.baseUri = uri;
	}

	@Override
	public URI resolve(URI vegaURI) {
		if (mproject == null) {
			searchMavenProject();
		}

		URI uri = null;
		if (mproject.getMavenProject() != null
				&& vegaURI.toString().startsWith(VEGA_URI)) {
			String uriPath = vegaURI.path();
			if (uriPath != null) {
				String fileNameToSearch = uriPath.substring(uriPath
						.lastIndexOf(SEPARATOR) + 1);
				try {
					uri = searchURIs(vegaURI, uri, fileNameToSearch, mproject);
				} catch (IOException | CoreException e) {
					throw new RuntimeException(e);
				}
			}
		}
		if (uri != null) {
			return uri;
		} else {
			return vegaURI.resolve(baseUri);
		}
	}

	@Override
	public URI deresolve(URI uri) {
		if (mproject == null) {
			searchMavenProject();
		}
		URI vegaURI = null;
		if (mproject.getMavenProject() != null) {
			String sScheme = uri.scheme();
			if (PLATFORM.equals(sScheme)) {
				vegaURI = getURIPlatform(uri);
			} else if (JAR.equals(sScheme)) {
				vegaURI = getURIJar(uri);
			}
		}
		if (vegaURI != null) {
			return vegaURI;
		} else {
			return uri.deresolve(baseUri);
		}
	}

	private void searchMavenProject() {
		IWorkspace ws = ResourcesPlugin.getWorkspace();
		URI uriG = baseUri.trimFragment();
		if (uriG.isPlatform()) {
			uriG = URI.createURI(uriG.toPlatformString(true));
		}
		IResource resource = ws.getRoot().findMember(uriG.toString());
		mproject = MavenPlugin.getMavenProjectRegistry().getProject(
				resource.getProject());
	}

	private URI searchURIs(URI uri, URI vegaURI, String fileNameToSearch,
			IMavenProjectFacade project) throws IOException, CoreException {
		List<Artifact> lArti = getProjectArtifacts(project);
		for (int i = 0; i < lArti.size(); i++) {
			Artifact artifacti = lArti.get(i);
			if (artifacti.getArtifactId().equals(uri.authority())) {
				File artifactJarFile = artifacti.getFile();
				// jar file
				if (artifactJarFile != null && artifactJarFile.isFile()) {
					vegaURI = findInJarDependency(vegaURI, artifacti,
							fileNameToSearch, artifactJarFile);
				}
				// existing project
				else {
					vegaURI = findInExistingProject(uri, fileNameToSearch);
				}
				if (vegaURI != null) {
					break;
				}
			}
		}
		return vegaURI;
	}

	private URI findInJarDependency(URI vegaURI, Artifact artifacti,
			String fileNameToSearch, File artifactJarFile) throws IOException {
		String sFullPathSearch = findFullPath(fileNameToSearch, artifactJarFile);
		if (sFullPathSearch != null) {
			vegaURI = URI.createURI(JAR_FILE + artifacti.getFile()
					+ ARCHIVE_SEPARATOR + sFullPathSearch + FRAGMENT0);
		}
		return vegaURI;
	}

	private URI findInExistingProject(URI uri, String fileNameToSearch)
			throws CoreException {
		URI vegaURI;
		IResource resourceBaseURI = getBaseURIResource();
		vegaURI = getVegaURI(fileNameToSearch, resourceBaseURI, uri.authority());
		return vegaURI;
	}

	private IResource getBaseURIResource() {
		IWorkspace ws = ResourcesPlugin.getWorkspace();
		URI uriG = baseUri.trimFragment();
		if (uriG.isPlatform()) {
			uriG = URI.createURI(uriG.toPlatformString(true));
		}
		IResource resource = ws.getRoot().findMember(uriG.toString());
		return resource;
	}

	private URI getVegaURI(String fileNameToSearch, IResource resourceBaseURI,
			String projectName) throws CoreException {
		URI vegaURI = null;
		if (resourceBaseURI != null) {
			IProject project = resourceBaseURI.getProject();
			IResource resource = null;

			resource = searchProject(fileNameToSearch, projectName, project);
			if (resource == null) {
				IProject[] lProjects = project.getReferencedProjects();
				for (IProject prj : lProjects) {
					resource = searchProject(fileNameToSearch, projectName, prj);
				}
			}

			if (resource != null) {
				vegaURI = URI.createURI(PLATFORM_RESOURCE
						+ resource.getFullPath().toString() + FRAGMENT0);
			}
		}
		return vegaURI;
	}

	private IResource searchProject(String fileNameToSearch,
			String projectName, IProject projectDependency)
			throws CoreException {
		IResource resource = null;
		if (projectName.equals(projectDependency.getName())) {
			List<IResource> fileList = findAllFilesInProjectWithName(
					projectDependency, fileNameToSearch);
			if (fileList.size() > 0) {
				for (IResource iResource : fileList) {
					if (iResource.getProjectRelativePath().toString()
							.contains(BaseModel.JV_PATH)) {
						resource = iResource;
						break;
					}
				}

			}
		}
		return resource;
	}

	private List<IResource> findAllFilesInProjectWithName(IProject project,
			String sNameToFind) throws CoreException {
		List<IResource> allCFiles = recursiveFindAllFiles(project, sNameToFind,
				EMPTY);
		return allCFiles;
	}

	private List<IResource> recursiveFindAllFiles(IContainer container,
			String sNameToFind, String sCurrentPath) throws CoreException {
		List<IResource> resources = new ArrayList<>();
		for (IResource iR : container.members()) {
			switch (iR.getType()) {
			case IResource.FILE:
				String fName = iR.getName();
				int index = fName.lastIndexOf(DOT);
				if (index != -1) {
					fName = fName.substring(0, index);
				}
				if ((sCurrentPath + DOT + fName).endsWith(sNameToFind)) {
					resources.add(iR);
				}
				break;
			case IResource.FOLDER:
				resources.addAll(recursiveFindAllFiles((IContainer) iR,
						sNameToFind, sCurrentPath + DOT + iR.getName()));
				break;
			}
		}
		return resources;
	}

	private String findFullPath(String fileNameToSearch, File file)
			throws IOException {
		ZipInputStream zip = new ZipInputStream(new FileInputStream(file));
		ZipEntry ze = null;
		String ret = null;
		while ((ze = zip.getNextEntry()) != null) {
			String entryName = ze.getName();
			int index = entryName.lastIndexOf(DOT);
			if (index != -1) {
				String entryNameDots = entryName.substring(0, index).replace(
						SEPARATOR, DOT);
				if (entryNameDots.endsWith(fileNameToSearch)) {
					ret = entryName;
					break;
				}
			}
		}
		zip.close();
		return ret;
	}

	private List<Artifact> getProjectArtifacts(
			IMavenProjectFacade mavenProjectFacade) {
		Set<Artifact> unorderedArtifacts = mavenProjectFacade.getMavenProject()
				.getArtifacts();
		unorderedArtifacts.add(mavenProjectFacade.getMavenProject()
				.getArtifact());
		List<Artifact> orderedArtifacts = new ArrayList<Artifact>(
				unorderedArtifacts.size());
		for (Artifact artifact : unorderedArtifacts) {
			orderedArtifacts.add(artifact);
		}
		return orderedArtifacts;
	}

	private URI getURIJar(URI uri) {
		String[] segList = uri.segments();
		String sAuthority = uri.authority();
		String sProjectName = sAuthority.substring(sAuthority
				.lastIndexOf(SEPARATOR2) + 1);
		boolean bFinJV_PATH = false;
		sProjectName = sProjectName.substring(0, sProjectName.indexOf(GUION));
		StringBuilder flujos = new StringBuilder();
		for (String segment : segList) {
			if (bFinJV_PATH) {
				if (segment.contains(DOT)) {
					flujos.append(segment.substring(0, segment.indexOf(DOT)));
				} else {
					flujos.append(segment).append(SEPARATOR);
				}
			} else if (JV.equals(segment)) {
				flujos.append(segment).append(SEPARATOR);
				bFinJV_PATH = true;
			} else {
				// malformed URI
				sProjectName = null;
				break;
			}
		}
		if (sProjectName != null && flujos.length() > 0) {
			return URI.createURI(VEGA_URI + SEPARATOR + SEPARATOR
					+ sProjectName + SEPARATOR + flujos + FRAGMENT0);
		} else {
			return null;
		}
	}

	private URI getURIPlatform(URI uri) {
		String[] segList = uri.segments();
		boolean bProjectName = false;
		String sProjectName = null;
		boolean bFinJV_PATH = false;
		StringBuilder flujos = new StringBuilder();
		List<String> lJV_PATH = null;
		int index_LJV_PATH = 0;
		for (String segment : segList) {
			if (bProjectName) {
				sProjectName = segment;
				bProjectName = false;
			} else if (bFinJV_PATH) {
				if (segment.contains(DOT)) {
					flujos.append(segment.substring(0, segment.indexOf(DOT)));
				} else {
					flujos.append(segment).append(SEPARATOR);
				}
			} else if (RESOURCE.equals(segment)) {
				bProjectName = true;
				lJV_PATH = divideJVPATHInSegments();
			} else if (lJV_PATH.get(index_LJV_PATH).equals(segment)) {
				flujos.append(segment).append(SEPARATOR);
				index_LJV_PATH++;
				if (index_LJV_PATH == lJV_PATH.size()) {
					bFinJV_PATH = true;
				}
			}
		}
		if (sProjectName != null && flujos.length() > 0) {
			return URI.createURI(VEGA_URI + SEPARATOR + SEPARATOR
					+ sProjectName + SEPARATOR + flujos + FRAGMENT0);
		} else {
			return null;
		}
	}

	private List<String> divideJVPATHInSegments() {
		String sJV_PATH = BaseModel.JV_PATH;
		StringTokenizer stJV = new StringTokenizer(sJV_PATH, SEPARATOR);
		List<String> alJV = new ArrayList<String>();
		while (stJV.hasMoreTokens()) {
			alJV.add(stJV.nextToken());
		}
		return alJV;
	}

}