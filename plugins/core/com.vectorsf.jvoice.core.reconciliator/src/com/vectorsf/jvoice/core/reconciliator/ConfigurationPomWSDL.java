package com.vectorsf.jvoice.core.reconciliator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.vectorsf.jvoice.core.project.JVoiceModuleNature;

public class ConfigurationPomWSDL {
	public final class ModifyPomJob extends WorkspaceJob {
		private final IProject iproject;
		private final MavenXpp3Reader reader;
		private final IFile pomFile;
		private final IFile target;

		private ModifyPomJob(IProject iproject, MavenXpp3Reader reader,
				IFile pomFile, IFile target) {
			super("");
			this.iproject = iproject;
			this.reader = reader;
			this.pomFile = pomFile;
			this.target = target;
			setRule(pomFile);
		}

		@Override
		public IStatus runInWorkspace(IProgressMonitor monitor)
				throws CoreException {
			Model mm = null;
			try {
				if (!pomContainsLine(pomFile, WSIMPORT)) {
					try {
						mm = reader.read(pomFile.getContents());
					} catch (IOException | XmlPullParserException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					addBuildToModel(mm, iproject.getName(), target);

					MavenXpp3Writer writer = new MavenXpp3Writer();
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					writer.write(baos, mm);
					pomFile.setContents(
							new ByteArrayInputStream(baos.toByteArray()), true,
							true, null);
				} else {
					mm = reader.read(pomFile.getContents());

					addFilewsdlToModel(mm, target);

					MavenXpp3Writer writer = new MavenXpp3Writer();
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					writer.write(baos, mm);
					pomFile.setContents(
							new ByteArrayInputStream(baos.toByteArray()), true,
							true, null);

				}
			} catch (IOException | XmlPullParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Status.OK_STATUS;

		}

	}

	private static final String POM_XML = "/pom.xml";
	private static final String WSIMPORT = "jaxws-maven-plugin";

	protected void modifyPom(final IProject iproject, final IFile target) {
		final MavenXpp3Reader reader = new MavenXpp3Reader();

		final IFile pomFile = (IFile) iproject.findMember(POM_XML);

		ModifyPomJob modifyPomJob = new ModifyPomJob(iproject, reader, pomFile,
				target);
		modifyPomJob.schedule();
	}

	private void addFilewsdlToModel(Model mm, IFile target) {
		List<Plugin> plugins = mm.getBuild().getPlugins();
		int index = plugins.size();
		for (int i = 0; i < index; i++) {
			Plugin plugin = plugins.get(i);
			if (plugin.getArtifactId().equals("jaxws-maven-plugin")) {
				PluginExecution confi = plugin.getExecutions().get(0);
				Xpp3Dom conf = (Xpp3Dom) confi.getConfiguration();
				if (conf != null) {
					Xpp3Dom wsdlFile = new Xpp3Dom("wsdlFile");
					wsdlFile.setValue(target.getParent().getName() + "/"
							+ target.getName());
					conf.getChild("wsdlFiles").addChild(wsdlFile);
				}
			}
		}

	}

	private void addBuildToModel(Model mm, String moduleName, IFile target) {

		String paquete = JVoiceModuleNature
				.getDefaultWSDLPackageName(moduleName);

		Plugin dsl_builder = new Plugin();
		dsl_builder.setGroupId("org.jvnet.jax-ws-commons");
		dsl_builder.setArtifactId("jaxws-maven-plugin");
		dsl_builder.setVersion("2.3");
		PluginExecution pexecution = new PluginExecution();
		pexecution.addGoal("wsimport");

		Xpp3Dom configuration = new Xpp3Dom("configuration");

		Xpp3Dom wsdlDirectory = new Xpp3Dom("wsdlDirectory");
		wsdlDirectory.setValue("src/main/resources/META-INF/wsdl");
		configuration.addChild(wsdlDirectory);

		Xpp3Dom wsdlLocation = new Xpp3Dom("wsdlLocation");
		wsdlLocation.setValue("http://" + paquete + ".*");
		configuration.addChild(wsdlLocation);

		Xpp3Dom sourceDestDir = new Xpp3Dom("sourceDestDir");
		sourceDestDir.setValue("src/generated-sources/wsimport");
		configuration.addChild(sourceDestDir);

		Xpp3Dom wsdlFiles = new Xpp3Dom("wsdlFiles");
		Xpp3Dom wsdlFile = new Xpp3Dom("wsdlFile");
		wsdlFile.setValue(target.getParent().getName() + "/" + target.getName());
		wsdlFiles.addChild(wsdlFile);
		pexecution.setConfiguration(wsdlFiles);

		configuration.addChild(wsdlFiles);

		Xpp3Dom keep = new Xpp3Dom("keep");
		keep.setValue("true");
		configuration.addChild(keep);

		pexecution.setConfiguration(configuration);

		dsl_builder.addExecution(pexecution);
		mm.getBuild().addPlugin(dsl_builder);

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
