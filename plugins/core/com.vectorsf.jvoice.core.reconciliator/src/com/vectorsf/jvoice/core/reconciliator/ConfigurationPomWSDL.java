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
			
					mm = reader.read(pomFile.getContents());

					addFilewsdlToModel(mm, target);

					MavenXpp3Writer writer = new MavenXpp3Writer();
					ByteArrayOutputStream baos = new ByteArrayOutputStream();
					writer.write(baos, mm);
					pomFile.setContents(
							new ByteArrayInputStream(baos.toByteArray()), true,
							true, null);

			} catch (IOException | XmlPullParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Status.OK_STATUS;

		}

	}

	private static final String POM_XML = "/pom.xml";
	private static final String WSCXF = "cxf-codegen-plugin";

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
			if (plugin.getArtifactId().equals(WSCXF)) {
				PluginExecution confi = plugin.getExecutions().get(0);
				Xpp3Dom conf = (Xpp3Dom) confi.getConfiguration();
				if (conf != null) {
					Xpp3Dom wsdlOption = new Xpp3Dom("wsdlOption");
					Xpp3Dom wsdlLocation = new Xpp3Dom("wsdlLocation");
					String nameTar = target.getName();
					wsdlLocation.setValue("http://localhost/wsdl/" + nameTar);
					Xpp3Dom wsdl = new Xpp3Dom("wsdl");
					String nameWsdl = nameTar
							.substring(0, nameTar.indexOf(".")) + "/" + nameTar;
					wsdl.setValue("${wsdlRoot}/" + nameWsdl);
					wsdlOption.addChild(wsdlLocation);
					wsdlOption.addChild(wsdl);
					conf.getChild("wsdlOptions").addChild(wsdlOption);
				}
			}
		}
	}
}
