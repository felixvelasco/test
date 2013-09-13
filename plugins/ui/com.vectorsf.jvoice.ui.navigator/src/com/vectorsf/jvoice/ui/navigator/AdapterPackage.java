package com.vectorsf.jvoice.ui.navigator;

import org.eclipse.core.internal.resources.mapping.SimpleResourceMapping;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.mapping.ResourceMapping;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.vectorsf.jvoice.model.base.JVPackage;

@SuppressWarnings("restriction")
public class AdapterPackage implements IAdapterFactory {

	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {

		if (adaptableObject instanceof JVPackage){
			
			if(adapterType == IFolder.class){
				return adaptarElemento (adaptableObject);
				
			}else if(adapterType == ResourceMapping.class){
				return new SimpleResourceMapping(adaptarElemento (adaptableObject));
			
			}else if(adapterType == IResource.class){
				return (IResource) adaptarElemento (adaptableObject);
			}
		}
		return null;
	}
	
	private IFolder adaptarElemento (Object adaptableObject){
		JVPackage pck = (JVPackage) adaptableObject;
		String relName = pck.getName().replace( '.', IPath.SEPARATOR);
		IPath path = new Path(IPath.SEPARATOR + pck.getOwnerProject().getName()).append("main/resources/jv").append(relName);
		return ResourcesPlugin.getWorkspace().getRoot().getFolder(path);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class[] getAdapterList() {
		// TODO Auto-generated method stub
		return new Class[] {JVPackage.class, IFolder.class, ResourceMapping.class, IResource.class};
	}

}
