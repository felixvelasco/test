package com.vectorsf.jvoice.ui.navigator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.mapping.ResourceMapping;
import org.eclipse.core.runtime.IAdapterFactory;

import com.vectorsf.jvoice.model.base.JVProject;

@SuppressWarnings("rawtypes")
public class AdapterProject implements IAdapterFactory {

	private static final Class[] ADAPTER_TYPES = new Class[] { IProject.class, ResourceMapping.class };

	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		if (adaptableObject instanceof JVProject) {

			if (adapterType == IProject.class || adapterType == IResource.class) {
				return adaptarElemento(adaptableObject);
			} else if (adapterType == ResourceMapping.class) {
				@SuppressWarnings("restriction")
				final ResourceMapping simpleResourceMapping = new org.eclipse.core.internal.resources.mapping.SimpleResourceMapping(
						adaptarElemento(adaptableObject));
				return simpleResourceMapping;
			}
		}
		return null;
	}

	private IProject adaptarElemento(Object adaptableObject) {
		JVProject proyecto = (JVProject) adaptableObject;
		return ResourcesPlugin.getWorkspace().getRoot().getProject(proyecto.getName());
	}

	@Override
	public Class[] getAdapterList() {
		return ADAPTER_TYPES;
	}

}
