package com.isb.jVoice.dsl.builder;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.project.MavenProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLResource.URIHandler;

public class VegaXMLURIHandlerMavenImpl implements URIHandler {

	private static final String EXTENSION_JVFLOW = ".jvflow";
	private static final String EXTENSION_VOICEDSL = ".voiceDsl";
	private static final String SEPARATOR2 = "\\";
	private static final String VEGA_URI = "vega:";
	private static final String SEPARATOR = "/";
	private static final String JV = "jv";
	private static final String INI_FRAGMENT = "#";
	private static final String ARCHIVE_FILE = "archive:";
	
	private URI baseUri;
	private MavenProject mavenProject;
	private ClassLoader mclassLoader;

	public void setBaseURI(URI uri) {
		this.baseUri = uri;
	}
	
	public VegaXMLURIHandlerMavenImpl(MavenProject project, ClassLoader classLoader)
	{
		mavenProject = project;
		mclassLoader=classLoader;
	}

	public URI deresolve(URI uri) {
		return uri.deresolve(baseUri);
	}


	public URI resolve(URI vegaURI) {
		URI uri_ = null;
		if (vegaURI.toString().startsWith(VEGA_URI)) {
			String uriPath = vegaURI.path();
			if (uriPath != null) {
				uri_ = searchURIs(vegaURI);
			}
		}
		if (uri_ != null) {
			return uri_;
		} else {
			return vegaURI.resolve(baseUri);
		}
	}


	private URI searchURIs(URI vegaURI) {
		List<Artifact> lArti = getProjectArtifacts();
		String sFullPathSearch = null;
		URI uri_=null;
		for (int i = 0; i < lArti.size() && sFullPathSearch == null; i++) {
			Artifact artifacti = lArti.get(i);
			if (artifacti.getArtifactId().equals(vegaURI.authority())) 
			{				
				String path = vegaURI.path();
				URL resource = mclassLoader.getResource(JV+path+EXTENSION_JVFLOW);
				URL resourceD = mclassLoader.getResource(JV+path+EXTENSION_VOICEDSL);
				if (resource==null)
				{
					resource=resourceD;
				}
				if (resource!=null)
				{
					String sUri=null;
					if (resource.getFile().contains("jar!"))
					{
						sUri = ARCHIVE_FILE +new File(resource.getFile()).getPath()+ INI_FRAGMENT
							+ vegaURI.fragment();
					}
					else
					{
						sUri =resource+ INI_FRAGMENT + vegaURI.fragment();
					}
					uri_=URI.createURI(sUri.replace(SEPARATOR2, SEPARATOR));
					if (uri_ != null) {
						break;
					}
				}
			}
		}
		return uri_;
	}

	private List<Artifact> getProjectArtifacts() {
		@SuppressWarnings("unchecked")
		Set<Artifact> dependencyArtifacts = mavenProject
				.getDependencyArtifacts();
		Set<Artifact> unorderedArtifacts = dependencyArtifacts;

		unorderedArtifacts.add(mavenProject.getArtifact());
		List<Artifact> orderedArtifacts = new ArrayList<Artifact>(
				unorderedArtifacts.size());
		for (Artifact artifact : unorderedArtifacts) {
			orderedArtifacts.add(artifact);
		}
		return orderedArtifacts;
	}
}