package com.vectorsf.jvoice.core.reconciliator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.maven.model.Model;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;


public class DeletePomWSDL {

	private static final String POM_XML = "/pom.xml";
	private static final String WSCXF = "cxf-codegen-plugin";

	/**
	 * @param iResource
	 * @param name
	 * @param deletewsdl
	 */
	protected void deleteFileWsdl(IResource iResource, IFile file, String type) {


		String name = file.getName();
		modifyPom(iResource.getProject(), name);

	}

	public void modifyPom(final IProject iproject,
			final String namefile) {
		final MavenXpp3Reader reader = new MavenXpp3Reader();
		

		final IFile pomFile = (IFile) iproject.findMember(POM_XML);
		
		ModifyPomDelete modifyPomJob = new ModifyPomDelete(namefile, reader, pomFile);
		modifyPomJob.schedule();
	}

	private final class ModifyPomDelete extends WorkspaceJob {
		
		private final MavenXpp3Reader reader;
		private final IFile pomFile;
		private final String namefile;
		
		private ModifyPomDelete( String namefile,
				MavenXpp3Reader reader, IFile pomFile) {
			super("");
			this.reader = reader;
			this.pomFile = pomFile;
			this.namefile = namefile;
			setRule(pomFile);
		}
		
		@Override
		public IStatus runInWorkspace(IProgressMonitor monitor)
				throws CoreException {
			Model mm = null;
			try {
				if (pomContainsLine(pomFile, WSCXF)) {
					try {
						mm = reader.read(pomFile.getContents());
					} catch (IOException e) {
						e.printStackTrace();
					} catch (XmlPullParserException e) {
						e.printStackTrace();
					}

					RemoveLineModel(mm, namefile);

					MavenXpp3Writer writer = new MavenXpp3Writer();
					ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
					try {
						writer.write(baos, mm);
					} catch (IOException e) {
						e.printStackTrace();
					}
					pomFile.setContents(new ByteArrayInputStream(baos.toByteArray()), true, true, null);

}
			} catch (FileNotFoundException e) {					
				e.printStackTrace();
			}
			return Status.OK_STATUS;

		}
		
	}

	private void RemoveLineModel(Model mm, String namefile) {
		List<Plugin> plugins = mm.getBuild().getPlugins();
		int index = plugins.size();
		for (int i = 0; i < index; i++) {
			Plugin plugin = plugins.get(i);
			if (plugin.getArtifactId().equals(WSCXF)) {
				PluginExecution confi = plugin.getExecutions().get(0);
				Xpp3Dom conf = (Xpp3Dom) confi.getConfiguration();
				if (conf != null) {
					Xpp3Dom childWO = conf.getChild("wsdlOptions");
					int children = childWO.getChildren().length;
					for (int l = 0; l < children; l++) {
						if (childWO.getChild(l).getChild("wsdl").getValue()
								.contains(namefile)) {
							childWO.removeChild(l);
							break;
						}
					}

				}
			}
		}

	}


	private boolean pomContainsLine(IFile pomFile, CharSequence in_line)
			throws FileNotFoundException, CoreException {
		Scanner fileScanner = new Scanner(pomFile.getContents());
		boolean bExits = false;
		while (fileScanner.hasNextLine() && !bExits) {
			String line = fileScanner.nextLine();
			if (line.contains(in_line)) {
				bExits = true;
			}
		}
		fileScanner.close();
		return bExits;
	}
	
	
}
	