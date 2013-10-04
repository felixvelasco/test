package com.isb.jVoice.dsl.builder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.project.MavenProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLResource.URIHandler;

public class VegaXMLURIHandlerMavenImpl implements URIHandler {

	private static final String EXTENSION_JVFLOW = ".jvflow";
	private static final String JAR = "jar";
	private static final String SEPARATOR2 = "\\";
	private static final String VEGA_URI = "vega:";
	private static final String SEPARATOR = "/";
	private static final String DOT = ".";
	private static final String JAR_FILE = "jar:";
	private static final String FRAGMENT0 = "#/1";
	private static final String JV = "jv";
	private URI baseUri;
	MavenProject mavenProject;

	public void setBaseURI(URI uri) {
		this.baseUri = uri;
	}
	
	public VegaXMLURIHandlerMavenImpl(MavenProject project)
	{
		mavenProject = project;
	}

	public URI deresolve(URI uri) {
		URI vegaURI = null;
		String sScheme = uri.scheme();
		if (JAR.equals(sScheme)) {
			vegaURI = getURIJar(uri);
		}
		if (vegaURI != null) {
			return vegaURI;
		} else {
			return uri.deresolve(baseUri);
		}
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
				File artifactJarFile = new File (Thread.currentThread().getContextClassLoader().getResource(vegaURI.path().substring(1,vegaURI.path().length())+EXTENSION_JVFLOW).getFile());
				String urijar = JAR_FILE+artifactJarFile.getPath()+FRAGMENT0;
				uri_=URI.createURI(urijar.replace(SEPARATOR2, SEPARATOR));
				if (uri_ != null) {
					break;
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

	private URI getURIJar(URI uri) 
	{
		String[] segList= uri.segments();	
		String sAuthority = uri.authority();
		String sProjectName=sAuthority.substring(sAuthority.lastIndexOf(SEPARATOR)+1,sAuthority.indexOf("-"));
		
		boolean bFinJV_PATH = false;
		String sFlujos="";
		for (String segment : segList) 
		{			
			if(bFinJV_PATH)
			{
				if (segment.contains(DOT))
				{
					sFlujos+=segment.substring(0, segment.indexOf(DOT));
				}
				else
				{
					sFlujos+=segment+SEPARATOR;
				}					
			}
			else if ((JV).equals(segment))
			{
				sFlujos+=segment+SEPARATOR;
				bFinJV_PATH=true;
			}
			else
			{
				// malformed URI
				sProjectName=null;
				break;
			}
		}
		if (sProjectName!=null && !sFlujos.equals(""))
		{
			return URI.createURI(VEGA_URI + SEPARATOR + SEPARATOR + sProjectName+ SEPARATOR + sFlujos + FRAGMENT0);
		}
		else
		{
			return null;
		}

		
	}
}