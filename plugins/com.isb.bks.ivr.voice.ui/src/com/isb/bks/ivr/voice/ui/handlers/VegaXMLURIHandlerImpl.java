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
import org.apache.maven.artifact.resolver.filter.ScopeArtifactFilter;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLResource.URIHandler;
import org.eclipse.m2e.core.MavenPlugin;
import org.eclipse.m2e.core.project.IMavenProjectFacade;

public class VegaXMLURIHandlerImpl implements URIHandler {

	private URI baseUri;
	private IFile file;

	@Override
	public void setBaseURI(URI uri) {
		this.baseUri = uri;
	}

	@Override
	public URI deresolve(URI uri) {
		System.out.print("Deresolve ");
		System.out.println(uri);
		return uri.deresolve(baseUri);
	}
		@Override
	public URI resolve(URI uri) {
		System.out.println("Resolve " + uri + " contra " + baseUri);
		URI vegaURI = null;
		if (uri.toString().startsWith("vega:")) {
			String uriPath = uri.path();
			String fileNameToSearch = uriPath.substring(uriPath
					.lastIndexOf("/") + 1);

			IMavenProjectFacade project = MavenPlugin.getMavenProjectRegistry()
					.getProject(file.getProject());

			vegaURI = searchURIs(uri, vegaURI, fileNameToSearch, project);
		}
		if (vegaURI != null) {
			return vegaURI;
		} else {
			return uri.resolve(baseUri);
		}
	}

		private URI searchURIs(URI uri, URI vegaURI, String fileNameToSearch,
				IMavenProjectFacade project) {
			List<Artifact> lArti = getProjectArtifacts(project);
			String sFullPathSearch = null;
			for (int i = 0; i < lArti.size() && sFullPathSearch==null; i++) 
			{
				Artifact artifacti=lArti.get(i);
				if (artifacti.getArtifactId().equals(uri.authority())) {
					List<File> lFiles = filterToResolvedJars(lArti);
					try {
						
						for (File file2 : lFiles) {
							sFullPathSearch = findFullPath(fileNameToSearch,
									sFullPathSearch, file2);

						}
						if (sFullPathSearch != null) {
							vegaURI= URI.createURI("jar:"+artifacti.getFile()+"!/"+sFullPathSearch);
							System.out.println("Resolve vega-->  " + vegaURI);
						}
						else
						{
							System.out.println("URI no resuelta");
						}

					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			return vegaURI;
		}

		private String findFullPath(String fileNameToSearch,
				String sFullPathSearch, File file2)
				throws FileNotFoundException, IOException {
			ZipInputStream zip = new ZipInputStream(
					new FileInputStream(file2));
			ZipEntry ze = null;
			while ((ze = zip.getNextEntry()) != null) {
				String entryName = ze.getName();
				int index = entryName.lastIndexOf(".");
				if (index != -1) {
					entryName = entryName.substring(0, index);
					String entryNameDots = entryName.replace("/", ".");
					if (entryNameDots.endsWith(fileNameToSearch)) 
					{
						sFullPathSearch = entryName;
					}

				}

			}
			zip.close();
			return sFullPathSearch;
		}
		private List<Artifact> getProjectArtifacts(
				IMavenProjectFacade mavenProjectFacade) 
		{

			Set<Artifact> unorderedArtifacts = mavenProjectFacade.getMavenProject()
					.getArtifacts();	
			List<Artifact> orderedArtifacts = new ArrayList<Artifact>(
					unorderedArtifacts.size());
			for (Artifact artifact : unorderedArtifacts) {
				orderedArtifacts.add(artifact);
			}
			return orderedArtifacts;
		}

		private List<File> filterToResolvedJars(List<Artifact> artifacts) {
			List<File> resolvedJarArtifacts = new ArrayList<File>();
			ScopeArtifactFilter filter = new ScopeArtifactFilter(
					Artifact.SCOPE_COMPILE_PLUS_RUNTIME);

			for (Artifact artifact : artifacts) {
				if (!artifact.isResolved())
					continue;
				if (artifact.getArtifactHandler() == null
						|| !"jar".equalsIgnoreCase(artifact.getArtifactHandler()
								.getExtension()))
					continue;
				if (!filter.include(artifact))
					continue;

				File artifactJarFile = artifact.getFile();
				if (!artifactJarFile.isFile())
					continue;

				resolvedJarArtifacts.add(artifactJarFile);
			}

			return resolvedJarArtifacts;
		}

		public void setFile(IFile file2) {
			this.file = file2;
		}
}