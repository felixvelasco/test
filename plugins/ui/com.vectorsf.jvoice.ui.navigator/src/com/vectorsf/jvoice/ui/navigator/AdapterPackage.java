package com.vectorsf.jvoice.ui.navigator;

import org.eclipse.core.internal.resources.mapping.SimpleResourceMapping;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.mapping.ResourceMapping;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.base.JVProject;

public class AdapterPackage implements IAdapterFactory {

	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {

			
			if (adaptableObject instanceof JVPackage){

			JVPackage pck = (JVPackage) adaptableObject;

			String relName = pck.getName().replace( '.', IPath.SEPARATOR);

			IPath path = new Path(IPath.SEPARATOR + pck.getOwnerProject().getName()).append("main/resources/jv").append(relName);

			return ResourcesPlugin.getWorkspace().getRoot().getFolder(path);

			}else if(adapterType == ResourceMapping.class){

				JVPackage pck = (JVPackage) adaptableObject;

				String relName = pck.getName().replace( '.', IPath.SEPARATOR);

				IPath path = new Path(IPath.SEPARATOR + pck.getOwnerProject().getName()).append("main/resources/jv").append(relName);
				
				IFolder carpeta = ResourcesPlugin.getWorkspace().getRoot().getFolder(path);
				
				return new SimpleResourceMapping(carpeta);
			
			}else if(adapterType == IResource.class){
				
				JVPackage pck = (JVPackage) adaptableObject;

				String relName = pck.getName().replace( '.', IPath.SEPARATOR);

				IPath path = new Path(IPath.SEPARATOR + pck.getOwnerProject().getName()).append("main/resources/jv").append(relName);
				
				return (IResource) ResourcesPlugin.getWorkspace().getRoot().getFolder(path);
				
			}

		return null;
	}

	@Override
	public Class[] getAdapterList() {
		// TODO Auto-generated method stub
		return new Class[] {JVPackage.class, IFolder.class};
	}

}
