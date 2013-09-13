package com.vectorsf.jvoice.ui.navigator;


import java.awt.Container;

import org.eclipse.core.internal.resources.mapping.SimpleResourceMapping;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.mapping.ResourceMapping;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.emf.ecore.resource.Resource;

import com.vectorsf.jvoice.model.base.JVProject;

public class AdapterProject implements IAdapterFactory {

	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adaptableObject instanceof JVProject) {
			
			if(adapterType == IProject.class){

					JVProject proyecto = (JVProject)adaptableObject;
					return ResourcesPlugin.getWorkspace().getRoot().getProject(proyecto.getName());
					
				}else if(adapterType == ResourceMapping.class){

					JVProject proyecto = (JVProject)adaptableObject;
					
					IProject prueba = ResourcesPlugin.getWorkspace().getRoot().getProject(proyecto.getName());
					
					return new SimpleResourceMapping(prueba);
				
				}else if(adapterType == IResource.class){
					
					JVProject proyecto = (JVProject)adaptableObject;
					
					return (IResource) ResourcesPlugin.getWorkspace().getRoot().getProject(proyecto.getName());
					
				}
				
			}
		return null;
	}

	@Override
	public Class[] getAdapterList() {
		// TODO Auto-generated method stub
		return new Class [] { JVProject.class, IProject.class, ResourceMapping.class};
	}

}
