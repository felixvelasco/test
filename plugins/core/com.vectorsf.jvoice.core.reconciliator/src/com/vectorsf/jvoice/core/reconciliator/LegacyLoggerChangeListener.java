package com.vectorsf.jvoice.core.reconciliator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.vectorsf.jvoice.model.base.JVApplication;
import com.vectorsf.jvoice.model.base.JVProject;

public class LegacyLoggerChangeListener implements IResourceChangeListener {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.core.resources.IResourceChangeListener#resourceChanged(org
	 * .eclipse.core.resources.IResourceChangeEvent)
	 */
	@Override
	public void resourceChanged(IResourceChangeEvent event) {

		//Obtenemos los proyectos que han cambiado
		IResourceDelta[] affectedChildren = event.getDelta().getAffectedChildren(IResourceDelta.CHANGED);
		
		//Por cada proyecto que ha cambiado, comprobamos si ha cambiado el .projectInformation (que es donde se guarda la información que buscamos chequear si ha cambiado)
		for (IResourceDelta delta : affectedChildren) {
			processDelta(delta);
		}
	}

	private void processDelta(IResourceDelta delta) {
		
		//Comprobamos si entre los ficheros que han cambiado para este proyecto se encuentra el .projectInformation
		IResourceDelta piDelta = delta.findMember(new Path(".projectInformation"));

		if (piDelta != null) {
			//Si ha cambiado el .projectInformation obtenemos el JVProject
			IFile file = (IFile) piDelta.getResource();
			URI resourceURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);			
			ResourceSet rset = new ResourceSetImpl();
			Resource resource = rset.getResource(resourceURI, true);
			JVProject project = (JVProject) resource.getContents().get(0);
			
			//Comprobamos que el proyecto donde ha cambiado el .projectInformation sea de aplicación, ya que en el módulo no se puede setear si usa el legacy logger
			if (project instanceof JVApplication){
				JVApplication application = (JVApplication) project;
				LegacyLoggerPomHandler legacyLoggerPomHandler = new LegacyLoggerPomHandler();
				//Si legacyLogger es true, se añade la dependencia del legacyLogger si no la tenía ya.
				if (application.isLegacyLogger()){
					legacyLoggerPomHandler.addLegacyLoggerDep2Pom(file.getProject());
					//Si legacyLogger es false, se borra la dependencia del legacyLogger si la tenía ya.
				} else {
					legacyLoggerPomHandler.removeLegacyLoggerDep2Pom(file.getProject());
				}
			}
		}
	}

}
