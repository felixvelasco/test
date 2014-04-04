package com.vectorsf.jvoice.diagram.core.updater;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.apache.maven.model.Model;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.model.io.xpp3.MavenXpp3Writer;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.vectorsf.jvoice.core.project.AbstractJVoiceNature;
import com.vectorsf.jvoice.core.project.JVoiceApplicationConfigurator;
import com.vectorsf.jvoice.core.project.JVoiceApplicationNature;
import com.vectorsf.jvoice.core.project.JVoiceModuleNature;
import com.vectorsf.jvoice.diagram.core.Activator;

/**
 * Actualiza los proyectos que no tienen la última versión del producto.
 */
public class IVRUpdater extends AbstractHandler {
	private static final String XPATH_FRAMEWORK_VERSION = "//dependency[groupId/text() = 'com.vectorsf' and artifactId/text() = 'jvoiceframework-flow']/version/text()";
	private static final String XPATH_COMPILER_VERSION = "//plugin[groupId/text() = 'com.vectorsf.jvoice' and artifactId/text() = 'dsl-builder']/version/text()";
	private static final String XPATH_APPLICATION_COMPILER_VERSION = "//plugin[groupId/text() = 'com.vectorsf.jvoice' and artifactId/text() = 'application-builder']/version/text()";
	private static final String XPATH_LOGGER_VERSION = "//dependency[groupId/text() = 'com.vectorsf' and artifactId/text() = 'jvoiceframework-isban-logger']/version/text()";

	private static final String IVR_PLATFORM_TEXT = "# Target IVR Platform. Possible values are: VXI, MPS and HTML.\nivrPlatform = MPS\n";
	private static final String TTS_ENGINE_TEXT = "# Target TTS engine.\nttsEngine = Nuance\n";
	private static final String ASR_ENGINE_TEXT = "# Target ASR engine.\nasrEngine = Nuance\n";

	private String frameworkVersion = AbstractJVoiceNature.JVOICE_FRAMEWORK_VERSION;
	private String compilerVersion = AbstractJVoiceNature.JVOICE_COMPILER_VERSION;
	private StringBuffer changedProjectsText;

	public DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		domFactory.setNamespaceAware(false);

		String[] projects = getProjectsToUpdate();
		if (projects.length == 0) {
			MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
					"Actualizador", "Todos los proyectos están actualizados\n\nVersión del framework: "
							+ frameworkVersion + "\nVersión del compilador: " + compilerVersion);
			return null;
		}

		ListSelectionDialog dialog = new ListSelectionDialog(new Shell(), projects, new ArrayContentProvider(),
				new LabelProvider(), "Proyectos que no tienen la versión " + frameworkVersion);
		dialog.setTitle("Actualizador de proyectos");

		if (dialog.open() == Dialog.OK) {
			updateProjects(dialog.getResult());
		}

		return null;
	}

	private void updateProjects(Object[] selectedProjects) {
		changedProjectsText = new StringBuffer();

		updatePomFile(selectedProjects);
		updateJvoicePropsFile(selectedProjects);

		if (changedProjectsText.length() > 0) {
			MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
					"Proyectos actualizados", changedProjectsText.toString());
		}

	}

	/**
	 * Actualizamos el nodo dependency/version del pom de los proyectos pasados.
	 */
	private void updatePomFile(Object[] selectedProjects) {

		try {
			for (Object project : selectedProjects) {
				// Quitamos la versión (viene en formato "nombreProyecto (version)")
				String prjName = project.toString().split(" ")[0];

				IProject prj = ResourcesPlugin.getWorkspace().getRoot().getProject(prjName);
				if (!prj.hasNature(JVoiceModuleNature.NATURE_ID) && !prj.hasNature(JVoiceApplicationNature.NATURE_ID)) {
					continue;
				}

				File pom = new File(prj.getFile("pom.xml").getLocation().toOSString());
				if (!pom.exists()) {
					log("No existe el fichero pom.xml en el proyecto " + prjName);
					return;
				}

				if (prj.hasNature(JVoiceApplicationNature.NATURE_ID)) {
					addMavenCleanPlugin(pom, prjName);
				}

				updateDependencyVersion(pom, prjName);
			}
		} catch (Exception e) {
			log("IVRUpdater.updatePomFile(): " + e);
			return;
		}

	}

	/**
	 * 
	 * Añade al pom del proyecto de aplicación el maven-clean-plugin si no lo tiene.
	 * 
	 */
	private void addMavenCleanPlugin(File pom, String prjName) {
		try {
			// Creamos el modelo de Maven a partir del pom.xml
			MavenXpp3Reader reader = new MavenXpp3Reader();
			Model model = reader.read(new FileInputStream(pom));

			// Si no tiene el maven-clean-plugin lo añadimos al modelo y escribimos el pom.xml a partir de este.
			if (!hasMavenCleanPlugin(model)) {
				model.getBuild().addPlugin(JVoiceApplicationConfigurator.getMavenCleanPlugin());

				changedProjectsText.append(prjName + ": Añadido maven-clean-plugin al pom.xml.\n");

				MavenXpp3Writer writer = new MavenXpp3Writer();
				writer.write(new FileOutputStream(pom), model);
			}

		} catch (Exception e) {
			log("IVRUpdater.addMavenCleanPlugin(): " + e);
			return;
		}

	}

	/**
	 * Actualizamos el nodo dependency/version del pom del proyecto pasado.
	 */
	private void updateDependencyVersion(File pom, String prjName) {

		try {
			Document doc = domFactory.newDocumentBuilder().parse(pom);

			// Actualizamos el nodo de la versión del framework de los módulos
			Node node = getNode(doc, prjName, XPATH_FRAMEWORK_VERSION, 0);
			updateNode(node, prjName, frameworkVersion);

			// Actualizamos el primer nodo de la versión del compilador de los módulos
			node = getNode(doc, prjName, XPATH_COMPILER_VERSION, 0);
			updateNode(node, prjName, compilerVersion);

			// Actualizamos el segundo nodo de la versión del compilador de los módulos
			node = getNode(doc, prjName, XPATH_COMPILER_VERSION, 1);
			updateNode(node, prjName, compilerVersion);

			// Actualizamos el nodo de la versión del logger de los módulos
			node = getNode(doc, prjName, XPATH_LOGGER_VERSION, 0);
			updateNode(node, prjName, frameworkVersion);

			// Actualizamos el nodo de la versión del compilador de las aplicaciones
			node = getNode(doc, prjName, XPATH_APPLICATION_COMPILER_VERSION, 0);
			updateNode(node, prjName, compilerVersion);

			// Grabamos el fichero
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(new DOMSource(doc), new StreamResult(pom));

		} catch (Exception e) {
			log("IVRUpdater.updateDependencyVersion(): " + e);
			return;
		}

	}

	private boolean hasMavenCleanPlugin(Model model) {

		List<Plugin> plugins = model.getBuild().getPlugins();

		int plugsSize = plugins.size();
		// Comprobamos si ya existe el maven-clean-plugin
		for (int i = 0; i < plugsSize; i++) {
			if ("maven-clean-plugin".equals(plugins.get(i).getArtifactId())) {
				// Ya existe el maven-clean-plugin
				return true;
			}
		}
		return false;
	}

	/**
	 * Actualizamos el fichero jvoiceframework.properties con nuevas claves.
	 */
	private void updateJvoicePropsFile(Object[] selectedProjects) {

		try {
			for (Object project : selectedProjects) {
				// Quitamos la versión (viene en formato "nombreProyecto (version)")
				String prjName = project.toString().split(" ")[0];

				IProject prj = ResourcesPlugin.getWorkspace().getRoot().getProject(prjName);

				// Solo las aplicaciones tienen el fichero que queremos actualizar.
				if (!prj.hasNature(JVoiceApplicationNature.NATURE_ID)) {
					continue;
				}

				File file = new File(prj
						.getFile(
								JVoiceApplicationConfigurator.PROPERTIES_FOLDER + "/"
										+ JVoiceApplicationConfigurator.PROPERTIES_FILENAME).getLocation().toOSString());
				if (!file.exists()) {
					log("No existe el fichero " + JVoiceApplicationConfigurator.PROPERTIES_FILENAME
							+ " en la aplicación " + prjName);
					return;
				}

				// Cargamos el archivo como un properties
				Properties prop = new Properties();
				prop.load(new FileInputStream(file));

				// Por cada nueva propiedad, comprobamos si existe y si no la incluimos en el fichero.
				if (!prop.containsKey("ivrPlatform")) {
					addKey(file, prjName, "ivrPlatform", IVR_PLATFORM_TEXT);
				}

				if (!prop.containsKey("ttsEngine")) {
					addKey(file, prjName, "ttsEngine", TTS_ENGINE_TEXT);
				}

				if (!prop.containsKey("asrEngine")) {
					addKey(file, prjName, "asrEngine", ASR_ENGINE_TEXT);
				}

			}
		} catch (Exception e) {
			log("IVRUpdater.updateJvoicePropsFile(): " + e);
			return;
		}

	}

	/**
	 * Añade al fichero la nueva clave.
	 */
	private void addKey(File file, String prjName, String key, String text) {
		try {
			// Escribimos el texto en el fichero.
			FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(text);
			bw.close();
		} catch (IOException e) {
			log("IVRUpdater.addKey(): " + e);
			return;
		}
		changedProjectsText.append(prjName + ": Añadida clave '" + key + "' al fichero "
				+ JVoiceApplicationConfigurator.PROPERTIES_FILENAME + ".\n");
		return;
	}

	/**
	 * Buscamos los proyectos que hay que actualizar para mostrarlos en el diálogo.
	 */
	private String[] getProjectsToUpdate() {
		List<String> projects = new ArrayList<String>();

		try {
			for (IProject prj : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
				if (!prj.isAccessible() || !prj.hasNature(JVoiceModuleNature.NATURE_ID)
						&& !prj.hasNature(JVoiceApplicationNature.NATURE_ID)) {
					continue;
				}

				InputStream pomFileInputStream = prj.getFile("pom.xml").getContents();
				Document doc = domFactory.newDocumentBuilder().parse(pomFileInputStream);

				// Buscamos la versión del compilador en las aplicaciones
				Node versioNode = getNode(doc, prj.getName(), XPATH_FRAMEWORK_VERSION, 0);
				if (versioNode != null && !frameworkVersion.equals(versioNode.getNodeValue())) {
					projects.add(prj.getName() + " (" + versioNode.getNodeValue() + ")");
					continue;
				}

				// Buscamos la versión del compilador en los módulos
				versioNode = getNode(doc, prj.getName(), XPATH_COMPILER_VERSION, 0);
				if (versioNode != null && !compilerVersion.equals(versioNode.getNodeValue())) {
					projects.add(prj.getName() + " (" + versioNode.getNodeValue() + ")");
					continue;
				}

				// Buscamos la versión del compilador en las aplicaciones
				versioNode = getNode(doc, prj.getName(), XPATH_APPLICATION_COMPILER_VERSION, 0);
				if (versioNode != null && !compilerVersion.equals(versioNode.getNodeValue())) {
					projects.add(prj.getName() + " (" + versioNode.getNodeValue() + ")");
					continue;
				}

				// Buscamos la versión del logger en los módulos
				versioNode = getNode(doc, prj.getName(), XPATH_LOGGER_VERSION, 0);
				if (versioNode != null && !frameworkVersion.equals(versioNode.getNodeValue())) {
					projects.add(prj.getName() + " (" + versioNode.getNodeValue() + ")");
				}
			}
		} catch (Exception e) {
			log("IVRUpdater.getProjectsToUpdate(): " + e);
		}

		return projects.toArray(new String[0]);
	}

	/**
	 * Devuelve el nodo número "itemNumber" que indica la expresión XPath pasada.
	 */
	private Node getNode(Document doc, String prjName, String xpathExpression, int itemNumber) throws Exception {
		XPathExpression expr = XPathFactory.newInstance().newXPath().compile(xpathExpression);

		NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

		if (nodes.getLength() > itemNumber) {
			return nodes.item(itemNumber);
		} else {
			System.err.println("No se encuentran en '" + prjName + "' nodos del tipo '" + xpathExpression);
		}

		return null;
	}

	private void updateNode(Node node, String prjName, String newVersion) {
		if (node == null) {
			System.err.println("No se ha encontrado el nodo versión del framework en '" + prjName + "'");
			return;
		}

		try {
			String oldVersion = node.getNodeValue();
			Node artifactIdNode = ((Element) node.getParentNode().getParentNode()).getElementsByTagName("artifactId")
					.item(0);

			if (!oldVersion.equals(newVersion)) {
				changedProjectsText.append(prjName + ": Versión actualizada de '"
						+ artifactIdNode.getFirstChild().getNodeValue() + "' de '" + oldVersion + "'  a  '"
						+ newVersion + "'\n");
				node.setNodeValue(newVersion);
			}
		} catch (Exception e) {
			changedProjectsText.append(prjName + " actualizado a " + newVersion);
			System.err.println("IVRUpdater.updateNode(): " + e);
		}
	}

	private void log(String text) {
		System.err.println(text);
		Activator.getLogger().log(IStatus.WARNING, "Actualizador de versiones: " + text);
	}
}
