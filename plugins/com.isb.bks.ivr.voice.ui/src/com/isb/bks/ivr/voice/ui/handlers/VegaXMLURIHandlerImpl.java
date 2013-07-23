package com.isb.bks.ivr.voice.ui.handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.maven.artifact.Artifact;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLResource.URIHandler;
import org.eclipse.m2e.core.MavenPlugin;
import org.eclipse.m2e.core.project.IMavenProjectFacade;

public class VegaXMLURIHandlerImpl implements URIHandler {

	private static final String JAR = "jar";
	private static final String SEPARATOR2 = "\\";
	private static final String GUION = "-";
	private static final String FLUJOS = "flujos";
	private static final String RESOURCE = "resource";
	private static final String PLATFORM = "platform";
	private static final String EMPTY = "";
	private static final String VEGA_URI = "vega:";
	private static final String SEPARATOR = "/";
	private static final String DOT = ".";
	private static final String PLATFORM_RESOURCE = "platform:/resource";
	private static final String JAR_FILE = "jar:file:/";
	private static final String ARCHIVE_SEPARATOR = "!/";
	private static final String FRAGMENT0 = "#/";
	private URI baseUri;
	private IFile file;

	@Override
	public void setBaseURI(URI uri) {
		this.baseUri = uri;
	}

	@Override
	public URI deresolve(URI uri) {
		URI vegaURI=null;
		String sScheme = uri.scheme();
		if (PLATFORM.equals(sScheme))
		{
			vegaURI = getURIPlatform(uri);
		}
		else if (JAR.equals(sScheme))
		{
			vegaURI = getURIJar(uri);
		}
		
		return vegaURI;
	}


	@Override
	public URI resolve(URI uri) {
		URI vegaURI = null;
		if (uri.toString().startsWith(VEGA_URI)) {
			String uriPath = uri.path();
			if (uriPath!=null)
			{
				String fileNameToSearch = uriPath.substring(uriPath
						.lastIndexOf(SEPARATOR) + 1);
				IMavenProjectFacade project = MavenPlugin.getMavenProjectRegistry()
					.getProject(file.getProject());
				vegaURI = searchURIs(uri, vegaURI, fileNameToSearch, project);
			}
		}
		if (vegaURI != null) {
			return vegaURI;
		} else {
			return uri.resolve(baseUri);
		}
	}

	public void setFile(IFile file2) {
		this.file = file2;
	}

	private URI searchURIs(URI uri, URI vegaURI, String fileNameToSearch,
			IMavenProjectFacade project) {
		List<Artifact> lArti = getProjectArtifacts(project);		
		String sFullPathSearch = null;
		for (int i = 0; i < lArti.size() && sFullPathSearch == null; i++) {
			Artifact artifacti = lArti.get(i);
			if (artifacti.getArtifactId().equals(uri.authority())) {
				File artifactJarFile = artifacti.getFile();
				// jar file
				if (artifactJarFile != null && artifactJarFile.isFile()) {
					vegaURI = findInJarDependency(vegaURI, sFullPathSearch,
							artifacti, fileNameToSearch, artifactJarFile);
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

	private URI findInJarDependency(URI vegaURI, String sFullPathSearch,
			Artifact artifacti, String fileNameToSearch, File artifactJarFile) {
		try {
			sFullPathSearch = findFullPath(fileNameToSearch, sFullPathSearch,
					artifactJarFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (sFullPathSearch != null) {
			vegaURI = URI.createURI(JAR_FILE + artifacti.getFile()
					+ ARCHIVE_SEPARATOR + sFullPathSearch + FRAGMENT0);
		}
		return vegaURI;
	}

	private URI findInExistingProject(URI uri, String fileNameToSearch) {
		URI vegaURI;
		IResource resourceBaseURI = getBaseURIResource();
		vegaURI = getVegaURI(fileNameToSearch, resourceBaseURI, uri.authority());
		return vegaURI;
	}

	private IResource getBaseURIResource() {
		IWorkspace ws = ResourcesPlugin.getWorkspace();
		URI uriG = baseUri.trimFragment();
		// remove "platform:..." from uri
		if (uriG.isPlatform()) {
			uriG = URI.createURI(uriG.toPlatformString(true));
		}
		IResource resource = ws.getRoot().findMember(uriG.toString());
		return resource;
	}

	private URI getVegaURI(String fileNameToSearch, IResource resourceBaseURI,
			String projectName) {
		URI vegaURI = null;
		if (resourceBaseURI != null) {
			IProject project = resourceBaseURI.getProject();
			IResource resource = null;
			try {
				IProject[] lProjects = project.getReferencedProjects();
				
				
				IProject projectI =project;
				resource = searchProject(fileNameToSearch, projectName,
						resource, projectI);
				int nIndex=0;
				while(resource==null && nIndex < lProjects.length)
				{					
					
					projectI=lProjects[nIndex];
					resource = searchProject(fileNameToSearch, projectName,
							resource, projectI);					
					nIndex++;					
				}
				
			} catch (CoreException e) {
				e.printStackTrace();
			}
			if (resource != null) {
				vegaURI = URI.createURI(PLATFORM_RESOURCE
						+ resource.getFullPath().toString() + FRAGMENT0);
			}
		}
		return vegaURI;
	}

	private IResource searchProject(String fileNameToSearch,
			String projectName, IResource resource, IProject projectDependency) {
		if (projectName.equals(projectDependency.getName())) {
			List<IResource> fileList = findAllFilesInProjectWithName(
					projectDependency, fileNameToSearch);
			if (fileList.size() > 0) {
				resource = fileList.get(0);
			}
		}
		return resource;
	}

	private List<IResource> findAllFilesInProjectWithName(IProject project,
			String sNameToFind) {
		List<IResource> allCFiles = recursiveFindAllFiles(project, sNameToFind,
				EMPTY);
		return allCFiles;
	}

	private List<IResource> recursiveFindAllFiles(IContainer container,
			String sNameToFind, String sCurrentPath) {
		List<IResource> resources = new ArrayList<>();
		try {
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
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return resources;
	}

	private String findFullPath(String fileNameToSearch,
			String sFullPathSearch, File file2) throws FileNotFoundException,
			IOException {
		ZipInputStream zip = new ZipInputStream(new FileInputStream(file2));
		ZipEntry ze = null;
		while ((ze = zip.getNextEntry()) != null) {
			String entryName = ze.getName();
			int index = entryName.lastIndexOf(DOT);
			if (index != -1) {
				String entryNameDots = entryName.substring(0, index).replace(
						SEPARATOR, DOT);
				if (entryNameDots.endsWith(fileNameToSearch)) {
					sFullPathSearch = entryName;
					break;
				}

			}

		}
		zip.close();
		return sFullPathSearch;
	}

	private List<Artifact> getProjectArtifacts(
			IMavenProjectFacade mavenProjectFacade) {
		Set<Artifact> unorderedArtifacts = mavenProjectFacade.getMavenProject()
				.getArtifacts();
		unorderedArtifacts.add(mavenProjectFacade.getMavenProject().getArtifact());
		List<Artifact> orderedArtifacts = new ArrayList<Artifact>(
				unorderedArtifacts.size());
		for (Artifact artifact : unorderedArtifacts) {
			orderedArtifacts.add(artifact);
		}
		return orderedArtifacts;
	}
	private URI getURIJar(URI uri) {
		String[] segList= uri.segments();	
		String sAuthority = uri.authority();
		String sProjectName=sAuthority.substring(sAuthority.lastIndexOf(SEPARATOR2)+1);
		sProjectName=sProjectName.substring(0, sProjectName.indexOf(GUION));
		boolean bFlujos = false;
		String sFlujos=null;
		for (String segment : segList) 
		{
			if(bFlujos)
			{
				if (segment.contains(DOT))
				{
					sFlujos+=segment.substring(0, segment.indexOf(DOT));
				}
				else
				{
					sFlujos+=segment+DOT;
				}					
			}
			else if (FLUJOS.equals(segment))
			{
				bFlujos=true;
				sFlujos=FLUJOS+SEPARATOR;
			}
		}
		if (sProjectName!=null && sFlujos!=null)
		{
			return URI.createURI(VEGA_URI + SEPARATOR + SEPARATOR + sProjectName+ SEPARATOR + sFlujos + FRAGMENT0);
		}
		else
		{
			return null;
		}
	}

	private URI getURIPlatform(URI uri) {
		String[] segList= uri.segments();			
		boolean bProjectName = false;
		String sProjectName=null;
		boolean bFlujos = false;
		String sFlujos=null;
		for (String segment : segList) 
		{
			if (bProjectName)
			{
				sProjectName=segment;
				bProjectName=false;
			}
			else if(bFlujos)
			{
				if (segment.contains(DOT))
				{
					sFlujos+=segment.substring(0, segment.indexOf(DOT));
				}
				else
				{
					sFlujos+=segment+DOT;
				}					
			}
			if (RESOURCE.equals(segment))
			{
				bProjectName=true;
			}
			else if (FLUJOS.equals(segment))
			{
				bFlujos=true;
				sFlujos=FLUJOS+SEPARATOR;
			}
		}
		if (sProjectName!=null && sFlujos!=null)
		{
			return URI.createURI(VEGA_URI + SEPARATOR + SEPARATOR + sProjectName+ SEPARATOR + sFlujos + FRAGMENT0);
		}
		else
		{
			return null;
		}
	}

}