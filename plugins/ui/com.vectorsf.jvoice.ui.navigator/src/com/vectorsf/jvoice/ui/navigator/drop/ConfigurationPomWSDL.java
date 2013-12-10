package com.vectorsf.jvoice.ui.navigator.drop;

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

import com.vectorsf.jvoice.core.project.JVoiceModuleNature;

public class ConfigurationPomWSDL {
	private static final String POM_XML = "/pom.xml";
	private static final String WSIMPORT = "jaxws-maven-plugin";

	public void initial(IProject iproject, IFile target) {
		modifyPom(iproject, target);
	}

	private void modifyPom(final IProject iproject, final IFile target) {
		try {
			MavenXpp3Reader reader = new MavenXpp3Reader();
			Model mm = null;
			File pomFile = new File(iproject.getLocationURI().getPath(),
					POM_XML);

			if (!pomContainsLine(pomFile, WSIMPORT)) {
				mm = reader.read(new FileInputStream(pomFile));

				addBuildToModel(mm, iproject.getName(), target);

				MavenXpp3Writer writer = new MavenXpp3Writer();
				writer.write(new FileOutputStream(pomFile), mm);
			} else {
				mm = reader.read(new FileInputStream(pomFile));

				addFilewsdlToModel(mm, target);

				MavenXpp3Writer writer = new MavenXpp3Writer();
				writer.write(new FileOutputStream(pomFile), mm);
			}
		} catch (IOException | XmlPullParserException e) {
			e.printStackTrace();
		}
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
					conf.getChild(3).addChild(wsdlFile);
				}
			}
		}

	}

	private void addBuildToModel(Model mm, String moduleName, IFile target) {

		String paquete = JVoiceModuleNature
				.getDefaultWSDLPackageName(moduleName);

		Plugin dsl_builder = new Plugin();
		dsl_builder.setGroupId("org.codehaus.mojo");
		dsl_builder.setArtifactId("jaxws-maven-plugin");
		dsl_builder.setVersion("1.9");
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

	private boolean pomContainsLine(File pomFile, CharSequence in_line)
			throws FileNotFoundException {
		Scanner fileScanner = new Scanner(pomFile);
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
