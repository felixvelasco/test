package com.vectorsf.jvoice.ui.navigator;


import org.eclipse.core.internal.resources.mapping.SimpleResourceMapping;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.mapping.ResourceMapping;
import org.eclipse.core.runtime.IAdapterFactory;

import com.vectorsf.jvoice.model.base.JVProject;

@SuppressWarnings("restriction")
public class AdapterProject implements IAdapterFactory {

	@SuppressWarnings("rawtypes")
	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adaptableObject instanceof JVProject) {
			
			if(adapterType == IProject.class){

					return adaptarElemento (adaptableObject);
					
				}else if(adapterType == ResourceMapping.class){
					
					return new SimpleResourceMapping(adaptarElemento (adaptableObject));
				
				}else if(adapterType == IResource.class){
					
					return (IResource) adaptarElemento (adaptableObject);
					
				}
				
			}
		return null;
	}
	
	private IProject adaptarElemento (Object adaptableObject){
		JVProject proyecto = (JVProject)adaptableObject;
		return ResourcesPlugin.getWorkspace().getRoot().getProject(proyecto.getName());
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class[] getAdapterList() {
		// TODO Auto-generated method stub
		return new Class [] { JVProject.class, IProject.class, ResourceMapping.class};
	}

}
