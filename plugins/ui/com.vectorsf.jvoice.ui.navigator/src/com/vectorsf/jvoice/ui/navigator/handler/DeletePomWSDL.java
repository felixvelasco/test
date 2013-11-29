package com.vectorsf.jvoice.ui.navigator.handler;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.maven.model.Model;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.core.resources.IProject;

public class DeletePomWSDL {

	private static final String POM_XML = "/pom.xml";
	private static final String WSIMPORT = "jaxws-maven-plugin";

	public void modifyPom(final IProject iproject) {
		try {
			MavenXpp3Reader reader = new MavenXpp3Reader();
			Model mm = null;

			File pomFile = new File(iproject.getLocationURI().getPath(),
					POM_XML);

			if (pomContainsLine(pomFile, WSIMPORT)) {
				mm = reader.read(new FileInputStream(pomFile));

				RemoveBuildToModel(mm);

				MavenXpp3Writer writer = new MavenXpp3Writer();
				writer.write(new FileOutputStream(pomFile), mm);

			}
		} catch (IOException | XmlPullParserException e) {
			e.printStackTrace();
		}
	}

	private void RemoveBuildToModel(Model mm) {

		List<Plugin> plugins = mm.getBuild().getPlugins();
		int index = plugins.size();
		for (int i = 0; i < index; i++) {
			Plugin plugin = plugins.get(i);
			if (plugin.getArtifactId().equals("jaxws-maven-plugin")) {
				plugins.remove(i);
				// Se comenta este codigo porque ahora va a existir un unico
				// plugin
				// PluginExecution confi = plugin.getExecutions().get(0);
				// Xpp3Dom conf = (Xpp3Dom) confi.getConfiguration();
				// if (conf != null) {
				// if (conf.getChild(1).getChild(0).getValue().equals(name)) {
				// /*
				// * Quitamos el plugin de la posicion que nos interesa,
				// * ya que no se puede usar el removeplugin debido a que
				// * el borrado lo realiza del listado con la
				// * concatenacion del groupID y el artifactId, y en
				// * nuestro caso no nos vale, ya que coinciden y borraria
				// * el primero que encuentre.
				// */
				// plugins.remove(i);
				// break;
				// }
				// }
			}
		}
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
