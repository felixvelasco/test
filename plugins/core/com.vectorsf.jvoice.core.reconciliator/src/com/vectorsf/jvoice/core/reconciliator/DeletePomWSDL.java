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
	private static final String WSIMPORT = "jaxws-maven-plugin";
	private static final String EMPTY = "empty";
	private static final String TYPE = "folder";
	private IFolder folder;

	/**
	 * @param iResource
	 * @param name
	 * @param deletewsdl
	 */
	protected void deleteFileWsdl(IResource iResource, IFile file, String type) {
		// Obtenemos la carpeta wsdl para comprobar si esta
		// vacia
		String name = file.getName();
		if (!type.equals(TYPE)) {
			folder = (IFolder) iResource.getParent().getParent();
		} else {
			folder = (IFolder) file.getParent();
		}

		try {
			if ((folder.members().length == 1
					&& folder.getFolder(name.substring(0, name.indexOf("."))).exists())|| folder.members().length == 0) {
				modifyPom(iResource.getProject(), "empty", name);
	
			} else {
				String namefile = file.getParent().getName() + "/" + name;
				modifyPom(iResource.getProject(), "full", namefile);			
				//Se comprueba que no existen carpetas vacias, sin wsdl, pueden tener schemas. En caso de que existan las carpetas pero esten vacias se elimmina el plugin
				boolean vacio = fullOrEmpty(iResource, name);	
				
				if(vacio){
					modifyPom(iResource.getProject(), "empty", name);
				}

			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
	}

	public void modifyPom(final IProject iproject, final String empty,
			final String namefile) {
		final MavenXpp3Reader reader = new MavenXpp3Reader();
		

		final IFile pomFile = (IFile) iproject.findMember(POM_XML);
		
		ModifyPomDelete modifyPomJob = new ModifyPomDelete(empty, namefile, reader, pomFile);
		modifyPomJob.schedule();
	}

	private final class ModifyPomDelete extends WorkspaceJob {
		
		private final  String empty;
		private final MavenXpp3Reader reader;
		private final IFile pomFile;
		private final String namefile;
		
		private ModifyPomDelete(String empty,  String namefile,
				MavenXpp3Reader reader, IFile pomFile) {
			super("");
			this.empty = empty;
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
				if (pomContainsLine(pomFile, WSIMPORT)) {
					try {
						mm = reader.read(pomFile.getContents());
					} catch (IOException e) {
						e.printStackTrace();
					} catch (XmlPullParserException e) {
						e.printStackTrace();
					}

					if (empty.equals(EMPTY)) {
						RemoveBuildToModel(mm);
					} else {
						RemoveLineModel(mm, namefile);
					}

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
			if (plugin.getArtifactId().equals("jaxws-maven-plugin")) {
				PluginExecution confi = plugin.getExecutions().get(0);
				Xpp3Dom conf = (Xpp3Dom) confi.getConfiguration();
				if (conf != null) {
					int children = conf.getChild(3).getChildren().length;
					for (int l = 0; l < children; l++) {
						if (conf.getChild(3).getChild(l).getValue()
								.equals(namefile)) {
							conf.getChild(3).removeChild(l);
							break;
						}
					}

				}
			}
		}

	}

	private void RemoveBuildToModel(Model mm) {

		List<Plugin> plugins = mm.getBuild().getPlugins();
		int index = plugins.size();
		for (int i = 0; i < index; i++) {
			Plugin plugin = plugins.get(i);
			if (plugin.getArtifactId().equals("jaxws-maven-plugin")) {
				plugins.remove(i);
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
	
	/**
	 * @param iResource
	 * @param name
	 * @return
	 * @throws CoreException
	 */
	protected boolean fullOrEmpty(IResource iResource, String name)
			throws CoreException {
		boolean vacio =false;
		for (IResource member : folder.members()) {
			IFolder folderwsdl= (IFolder)member;
			if(folderwsdl.members().length==0){
				vacio = true;				
			}else{
				for (IResource element : folderwsdl.members()) {
					if(element instanceof IFile){
						String extension = element.getName().substring(element.getName().lastIndexOf(".")+1);
						if(!extension.equalsIgnoreCase("wsdl")){
							modifyPom(iResource.getProject(), "empty", name);	
							vacio = false;
							break;
						}
					}
				}
				vacio = false;
				break;
			}											
		}
		return vacio;
	}
	
}
	