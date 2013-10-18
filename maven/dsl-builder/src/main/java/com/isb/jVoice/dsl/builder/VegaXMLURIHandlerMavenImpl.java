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
	private static final String JAR = "jar";
	private static final String FILE = "file";
	private static final String SEPARATOR2 = "\\";
	private static final String VEGA_URI = "vega:";
	private static final String SEPARATOR = "/";
	private static final String DOT = ".";
	private static final String JAR_FILE = "jar:";
	private static final String JV = "jv";
	private static final String INI_FRAGMENT = "#";

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
		URI vegaURI = null;
		String sScheme = uri.scheme();
		if (JAR.equals(sScheme)) {
			vegaURI = getURIJar(uri);
		}
		else if (FILE.equals(sScheme))
		{
			vegaURI = getURIFile(uri);
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
						sUri = JAR_FILE+new File(resource.getFile()).getPath()+ INI_FRAGMENT
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

	
	private URI getURIFile(URI uri) {
		String[] segList= uri.segments();	
		String path = uri.path();
		String subpath =path.substring(0, path.indexOf("/target"));
		String sProjectName=subpath.substring(subpath.lastIndexOf("/")+1);
		
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
				bFinJV_PATH=true;
			}
		}
		if (sProjectName!=null && !sFlujos.equals(""))
		{
			return URI.createURI(VEGA_URI + SEPARATOR + SEPARATOR + sProjectName+ SEPARATOR + sFlujos + INI_FRAGMENT
					+ uri.fragment());
		}
		else
		{
			return null;
		}

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
			return URI.createURI(VEGA_URI + SEPARATOR + SEPARATOR + sProjectName+ SEPARATOR + sFlujos + INI_FRAGMENT
					+ uri.fragment());
		}
		else
		{
			return null;
		}

		
	}
}