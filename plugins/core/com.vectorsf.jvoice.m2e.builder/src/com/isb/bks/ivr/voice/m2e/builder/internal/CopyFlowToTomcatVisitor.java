package com.isb.bks.ivr.voice.m2e.builder.internal;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;

import com.google.common.io.Files;
import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.core.uri.VegaXMLURIHandlerImpl;

/**
 * Copia el flujo generado para Spring al directorio donde lo va a buscar Tomcat. Para que funcione bien
 * sólo debe haber definido un único servidor y sólo puede haber una aplicación abierta en el workspace.
 */
public class CopyFlowToTomcatVisitor implements IResourceDeltaVisitor {

	private final static IPath pkgPath = new Path(BaseModel.JV_PATH);
	ResourceSet rset = new ResourceSetImpl();

	public CopyFlowToTomcatVisitor() {
		rset.getLoadOptions().put(XMLResource.OPTION_URI_HANDLER, new VegaXMLURIHandlerImpl());
	}

	@Override
	public boolean visit(IResourceDelta delta) throws CoreException {
		IResource resource = delta.getResource();
		// Sólo tenemos en cuenta cambios en "src/main/resources/jv"
		if (!isValidFolder(resource) || resource.getType() != IResource.FILE
				|| delta.getKind() != IResourceDelta.CHANGED) {
			return true;
		}

		IFile modifiedFile = (IFile) resource;
		IPath packagePath = modifiedFile.getFullPath().removeFirstSegments(1).makeRelativeTo(pkgPath);

		String packageName = packagePath.toString().substring(0, packagePath.toString().lastIndexOf("/"));
		String flowName = modifiedFile.getFullPath().removeFileExtension().lastSegment();

		if (modifiedFile.getFileExtension().equals("voiceDsl")) {
			// Llega un packageName del tipo "a/b/c/F2.resources"
			packageName = packageName.substring(0, packageName.lastIndexOf("/"));

			// El fichero dsl está en una carpeta del tipo "src\main\resources\jv\p\F1.resources"
			String resourcesFolder = modifiedFile.getParent().getFullPath().lastSegment();
			flowName = resourcesFolder.substring(0, resourcesFolder.lastIndexOf("."));
		}

		// Obtenemos el fichero generado para Spring WebFlow
		IFolder folder = modifiedFile.getProject().getFolder("target/jVoice/" + packageName);
		IFile generatedFlowFile = folder.getFile(flowName + ".xml");

		copyFlowToTomcatFolder(generatedFlowFile, packageName, flowName);

		return true;
	}

	/**
	 * Copia el fichero pasado al directorio
	 * .metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\appp\WEB-INF\flows\paquete\flujo
	 */
	private void copyFlowToTomcatFolder(IFile flowFile, String packageName, String flowName) {
		try {
			String appName = getAppName();
			if (appName == null) {
				log("No se ha encontrado ninguna aplicación en el workspace");
				return;
			}

			File tomcatFolder = new File(Platform.getLocation().toOSString()
					+ "/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/" + appName + "/WEB-INF/flows/"
					+ packageName + "/" + flowName + "/" + flowName + "-flow.xml");

			if (tomcatFolder.exists()) {
				Files.copy(flowFile.getLocation().toFile(), tomcatFolder);
				log("Copiado '" + flowFile + "' a '" + tomcatFolder + "'");
			} else {
				log("No existe: la carpeta '" + tomcatFolder + "'");
			}
		} catch (Exception e) {
			System.err.println("CopyFlowToTomcatVisitor.copyFlowToTomcatFolder(): " + e);
		}
	}

	/**
	 * Devuelve la primera aplicación que encuentre en el workspace.
	 */
	private String getAppName() throws CoreException {
		for (IProject prj : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
			if (prj.hasNature("com.vectorsf.jvoice.core.project.jVoiceApplicationNature")) {
				return prj.getName();
			}
		}

		return null;
	}

	/**
	 * Sólo tenemos en cuenta cambios en "src/main/resources/jv".
	 */
	private boolean isValidFolder(IResource resource) {
		if (pkgPath.isPrefixOf(resource.getProjectRelativePath()) && !pkgPath.equals(resource.getProjectRelativePath())) {
			return true;
		} else {
			return false;
		}
	}

	private void log(String text) {
		System.err.println("CopyFlowToTomcatVisitor: " + text);
	}

}
