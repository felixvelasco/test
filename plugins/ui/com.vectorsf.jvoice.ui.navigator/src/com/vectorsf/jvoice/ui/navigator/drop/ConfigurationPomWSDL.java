package com.vectorsf.jvoice.ui.navigator.drop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.maven.model.Model;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;

public class ConfigurationPomWSDL {
	private static final String POM_XML = "/pom.xml";
	private static final String WSCXF = "cxf-codegen-plugin";

	public void initial(IProject iproject, IFile target) {
		modifyPom(iproject, target);
	}

	private void modifyPom(final IProject iproject, final IFile target) {
		try {
			MavenXpp3Reader reader = new MavenXpp3Reader();
			Model mm = null;
			File pomFile = new File(iproject.getLocationURI().getPath(),
					POM_XML);
			mm = reader.read(new FileInputStream(pomFile));

			addFilewsdlToModel(mm, target);

			MavenXpp3Writer writer = new MavenXpp3Writer();
			writer.write(new FileOutputStream(pomFile), mm);
		} catch (IOException | XmlPullParserException e) {
			e.printStackTrace();
		}
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
