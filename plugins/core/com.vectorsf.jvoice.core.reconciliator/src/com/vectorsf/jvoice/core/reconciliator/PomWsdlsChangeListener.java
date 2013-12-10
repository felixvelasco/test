/**
 * 
 */
package com.vectorsf.jvoice.core.reconciliator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;


public class PomWsdlsChangeListener implements IResourceChangeListener {

	/* (non-Javadoc)
	 * @see org.eclipse.core.resources.IResourceChangeListener#resourceChanged(org.eclipse.core.resources.IResourceChangeEvent)
	 */
	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		
		if (event.getDelta() == null) {
			return;
		}

		for (IResourceDelta child : event.getDelta().getAffectedChildren()) {
			if(event.getDelta().getKind()==IResourceDelta.CHANGED){
				IFile target= getAffectedFile(child, null);
				if(target!=null){
					String name =target.getName();
					if(name.substring(name.lastIndexOf(".")+1).equals("wsdl")){
						IProject iproject = target.getProject();					
						ConfigurationPomWSDL configurate = new ConfigurationPomWSDL();
						configurate.initial(iproject, target);
					}
				}				
				
			}
						
		}
		
	}

	private IFile getAffectedFile(IResourceDelta child, IFile file) {
		IFile filename = null;
		 for (IResourceDelta element : child.getAffectedChildren()) {
			if(element.getKind()==IResourceDelta.ADDED || element.getKind()==IResourceDelta.REMOVED){
				if(element.getResource() instanceof IFile){
					file= (IFile)element.getResource();	
					filename = file;
						break;
				}
			}
			filename = getAffectedFile(element, file);
		}
		return filename;	
	}

}
