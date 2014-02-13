package com.vectorsf.jvoice.diagram.core.updater;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

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
import com.vectorsf.jvoice.core.project.JVoiceApplicationNature;
import com.vectorsf.jvoice.core.project.JVoiceModuleNature;
import com.vectorsf.jvoice.diagram.core.Activator;

/**
 * Actualiza el pom de los proyectos que no tienen la última versión del producto.
 */
public class IVRUpdater extends AbstractHandler {
	private static final String XPATH_FRAMEWORK_VERSION = "//dependency[groupId/text() = 'com.vectorsf' and artifactId/text() = 'jvoiceframework-flow']/version/text()";
	private static final String XPATH_COMPILER_VERSION = "//plugin[groupId/text() = 'com.vectorsf.jvoice' and artifactId/text() = 'dsl-builder']/version/text()";
	private static final String XPATH_APPLICATION_COMPILER_VERSION = "//plugin[groupId/text() = 'com.vectorsf.jvoice' and artifactId/text() = 'application-builder']/version/text()";
	private static final String XPATH_LOGGER_VERSION = "//dependency[groupId/text() = 'com.vectorsf' and artifactId/text() = 'jvoiceframework-isban-logger']/version/text()";

	public DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
	private String frameworkVersion = AbstractJVoiceNature.JVOICE_FRAMEWORK_VERSION;
	private String compilerVersion = AbstractJVoiceNature.JVOICE_COMPILER_VERSION;

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
			updatePomFile(dialog.getResult());
		}

		return null;
	}

	/**
	 * Actualizamos el nodo dependency/version del pom de los proyectos pasados.
	 */
	private void updatePomFile(Object[] selectedProjects) {
		StringBuffer changedProjectsText = new StringBuffer();

		try {
			for (Object project : selectedProjects) {
				// Quitamos la versión (viene en formato "nombreProyecto (version)")
				String prjName = project.toString().split(" ")[0];

				IProject prj = ResourcesPlugin.getWorkspace().getRoot().getProject(prjName);
				if (!prj.hasNature(JVoiceModuleNature.NATURE_ID) && !prj.hasNature(JVoiceApplicationNature.NATURE_ID)) {
					continue;
				}

				File file = new File(prj.getFile("pom.xml").getLocation().toOSString());
				Document doc = domFactory.newDocumentBuilder().parse(file);

				// Actualizamos el nodo de la versión del framework de los módulos
				Node node = getNode(doc, prjName, XPATH_FRAMEWORK_VERSION, 0);
				updateNode(node, prjName, frameworkVersion, changedProjectsText);

				// Actualizamos el primer nodo de la versión del compilador de los módulos
				node = getNode(doc, prjName, XPATH_COMPILER_VERSION, 0);
				updateNode(node, prjName, compilerVersion, changedProjectsText);

				// Actualizamos el segundo nodo de la versión del compilador de los módulos
				node = getNode(doc, prjName, XPATH_COMPILER_VERSION, 1);
				updateNode(node, prjName, compilerVersion, changedProjectsText);

				// Actualizamos el nodo de la versión del logger de los módulos
				node = getNode(doc, prjName, XPATH_LOGGER_VERSION, 0);
				updateNode(node, prjName, frameworkVersion, changedProjectsText);

				// Actualizamos el nodo de la versión del compilador de las aplicaciones
				node = getNode(doc, prjName, XPATH_APPLICATION_COMPILER_VERSION, 0);
				updateNode(node, prjName, compilerVersion, changedProjectsText);

				// Grabamos el fichero
				Transformer transformer = TransformerFactory.newInstance().newTransformer();
				transformer.transform(new DOMSource(doc), new StreamResult(file));
			}
		} catch (Exception e) {
			log("IVRUpdater.updatePomFile(): " + e);
			return;
		}

		if (changedProjectsText.length() > 0) {
			MessageDialog.openInformation(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
					"Proyectos actualizados", changedProjectsText.toString());
		}
	}

	/**
	 * Buscamos los proyectos que hay que actualizar para mostrarlos en el diÃ¡logo.
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
	 * Devuelve el nodo que indica la expresión pasada
	 */
	private Node getNode(Document doc, String prjName, String xpathExpression, int itemNumber) throws Exception {
		XPathExpression expr = XPathFactory.newInstance().newXPath().compile(xpathExpression);

		NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);

		if (nodes.getLength() > itemNumber) {
			return nodes.item(itemNumber);
		} else {
			log("No se encuentran en '" + prjName + "' nodos del tipo '" + xpathExpression);
		}

		return null;
	}

	private void updateNode(Node node, String prjName, String newVersion, StringBuffer changedProjects) {
		if (node == null) {
			System.err.println("No se ha encontrado el nodo versión del framework en '" + prjName + "'");
			return;
		}

		try {
			String oldVersion = node.getNodeValue();
			Node artifactIdNode = ((Element) node.getParentNode().getParentNode()).getElementsByTagName("artifactId")
					.item(0);

			if (!oldVersion.equals(newVersion)) {
				changedProjects.append(prjName + ": Versión actualizada de '"
						+ artifactIdNode.getFirstChild().getNodeValue() + "' de '" + oldVersion + "'  a  '"
						+ newVersion + "'\n");
				node.setNodeValue(newVersion);
			}
		} catch (Exception e) {
			changedProjects.append(prjName + " actualizado a " + newVersion);
			System.err.println("IVRUpdater.updateNode(): " + e);
		}
	}

	private void log(String text) {
		System.err.println(text);
		Activator.getLogger().log(IStatus.WARNING, "Actualizador de versiones: " + text);
	}
}