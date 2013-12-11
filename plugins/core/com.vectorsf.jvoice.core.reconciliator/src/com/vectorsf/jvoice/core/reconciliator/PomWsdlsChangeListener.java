/**
 * 
 */
package com.vectorsf.jvoice.core.reconciliator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
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
				//Si se da de alta un WSDL
				IFile target= getAddFile(child, null);
				if(target!=null){
					String name =target.getName();
					if(name.substring(name.lastIndexOf(".")+1).equals("wsdl")){
						IProject iproject = target.getProject();					
						ConfigurationPomWSDL configurate = new ConfigurationPomWSDL();
						configurate.modifyPom(iproject, target);
					}
				}	
				
				//Si se ha dado de baja un WSDL o carpeta que lo contiene
				IResource resource = getDeleteFile(child, null);
				if(resource!=null){					
					try {
						checkFolderFileWSDL(resource);
					} catch (CoreException e1) {
						e1.printStackTrace();
					}					
				
				}
								
			}
						
		}
		
	}

	private IFile getAddFile(IResourceDelta child, IFile file) {
		IFile filename = null;
		 for (IResourceDelta element : child.getAffectedChildren()) {
			if(element.getKind()==IResourceDelta.ADDED){
				if(element.getResource() instanceof IFile){
					file= (IFile)element.getResource();	
					filename = file;
						break;
				}
			}
			filename = getAddFile(element, file);
		}
		return filename;	
	}
	
	private IResource getDeleteFile(IResourceDelta child, IResource file) {
		IResource filename = null;
		 for (IResourceDelta element : child.getAffectedChildren()) {
			if(element.getKind()==IResourceDelta.REMOVED){
				if(element.getResource() instanceof IFile){
					file= (IResource)element.getResource();	
					filename = file;
						break;
				}
			}
			filename = getDeleteFile(element, file);
		}
		return filename;	
	}
	
	/**
	 * @param resources
	 * @throws CoreException
	 */
	protected void checkFolderFileWSDL(final IResource resource)
			throws CoreException {
		String name = resource.getName();
		DeletePomWSDL deletewsdl = new DeletePomWSDL();
			if (resource instanceof IFolder) {
				IFolder folder = (IFolder) resource;
				try {
					for (IResource childfile : folder.members()) {
						String extension = childfile.getName().substring(
								childfile.getName().lastIndexOf(".") + 1);
						if ("wsdl".equalsIgnoreCase(extension)) {
							deletewsdl.deleteFileWsdl(resource,
									(IFile) childfile, "folder");
							break;
						}
					}
				} catch (CoreException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}else if (resource instanceof IFile) {
				IFile file = (IFile) resource;
				String extension = name.substring(name.lastIndexOf(".") + 1);
				if ("wsdl".equalsIgnoreCase(extension)) {
					deletewsdl.deleteFileWsdl(resource, file, "file");
				}

			}
	}

}
