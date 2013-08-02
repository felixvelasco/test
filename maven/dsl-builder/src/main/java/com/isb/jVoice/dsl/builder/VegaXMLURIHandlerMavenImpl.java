package com.isb.jVoice.dsl.builder;

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
import org.apache.maven.project.MavenProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLResource.URIHandler;

public class VegaXMLURIHandlerMavenImpl implements URIHandler {

	private static final String JAR = "jar";
	private static final String SEPARATOR2 = "\\";
	private static final String GUION = "-";
	private static final String FLUJOS = "flujos";
	private static final String VEGA_URI = "vega:";
	private static final String SEPARATOR = "/";
	private static final String DOT = ".";
	private static final String JAR_FILE = "jar:file:/";
	private static final String ARCHIVE_SEPARATOR = "!/";
	private static final String FRAGMENT0 = "#/";
	private URI baseUri;
	MavenProject mavenProject;

	public void setBaseURI(URI uri) {
		this.baseUri = uri;
	}

	public void setMavenProject(MavenProject project) {
		mavenProject = project;
	}

	public URI deresolve(URI uri) {
		URI vegaURI = null;
		String sScheme = uri.scheme();
		if (JAR.equals(sScheme)) {
			vegaURI = getURIJar(uri);
		}
		return vegaURI;
	}

	public URI resolve(URI uri) {
		URI vegaURI = null;
		if (uri.toString().startsWith(VEGA_URI)) {
			String uriPath = uri.path();
			if (uriPath != null) {
				String fileNameToSearch = uriPath.substring(uriPath
						.lastIndexOf(SEPARATOR) + 1);
				vegaURI = searchURIs(uri, vegaURI, fileNameToSearch);
			}
		}
		if (vegaURI != null) {
			return vegaURI;
		} else {
			return uri.resolve(baseUri);
		}
	}


	private URI searchURIs(URI uri, URI vegaURI, String fileNameToSearch) {
		List<Artifact> lArti = getProjectArtifacts();
		String sFullPathSearch = null;
		for (int i = 0; i < lArti.size() && sFullPathSearch == null; i++) {
			Artifact artifacti = lArti.get(i);
			if (artifacti.getArtifactId().equals(uri.authority())) {
				File artifactJarFile = artifacti.getFile();
				// dependency file
				if (artifactJarFile != null && artifactJarFile.isFile()) {
					vegaURI = findInJarDependency(vegaURI, sFullPathSearch,
							artifacti, fileNameToSearch, artifactJarFile);
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

	private List<Artifact> getProjectArtifacts() {
		Set<Artifact> unorderedArtifacts = mavenProject
				.getDependencyArtifacts();

		unorderedArtifacts.add(mavenProject.getArtifact());
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
		sProjectName = sProjectName.substring(0, sProjectName.indexOf(GUION));
		boolean bFlujos = false;
		String sFlujos = null;
		for (String segment : segList) {
			if (bFlujos) {
				if (segment.contains(DOT)) {
					sFlujos += segment.substring(0, segment.indexOf(DOT));
				} else {
					sFlujos += segment + DOT;
				}
			} else if (FLUJOS.equals(segment)) {
				bFlujos = true;
				sFlujos = FLUJOS + SEPARATOR;
			}
		}
		if (sProjectName != null && sFlujos != null) {
			return URI.createURI(VEGA_URI + SEPARATOR + SEPARATOR
					+ sProjectName + SEPARATOR + sFlujos + FRAGMENT0);
		} else {
			return null;
		}
	}
}