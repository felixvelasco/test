package com.vectorsf.jvoice.ui.navigator;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.mapping.ResourceMapping;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.vectorsf.jvoice.model.base.JVPackage;

@SuppressWarnings("rawtypes")
public class AdapterPackage implements IAdapterFactory {

	private static final Class[] ADAPTER_TYPES = new Class[] { IFolder.class, ResourceMapping.class, IResource.class };

	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {

		if (adaptableObject instanceof JVPackage) {

			if (adapterType == IFolder.class || adapterType == IResource.class) {
				if (verificaPadre(adaptableObject)) {
					return adaptarElemento(adaptableObject);
				} else {
					return null;
				}

			} else if (adapterType == ResourceMapping.class) {
				if (verificaPadre(adaptableObject)) {
					@SuppressWarnings("restriction")
					final ResourceMapping simpleResourceMapping = new org.eclipse.core.internal.resources.mapping.SimpleResourceMapping(
							adaptarElemento(adaptableObject));
					return simpleResourceMapping;
				} else {
					return null;
				}

			}
		}
		return null;
	}

	private IFolder adaptarElemento(Object adaptableObject) {
		JVPackage pck = (JVPackage) adaptableObject;
		String relName = pck.getName().replace('.', IPath.SEPARATOR);
		IPath path = new Path(IPath.SEPARATOR + pck.getOwnerModule().getName()).append("src/main/resources/jv").append(
				relName);
		return ResourcesPlugin.getWorkspace().getRoot().getFolder(path);
	}

	@Override
	public Class[] getAdapterList() {
		return ADAPTER_TYPES;
	}

	private boolean verificaPadre(Object adaptableObject) {
		JVPackage pck = (JVPackage) adaptableObject;
		if (pck.getOwnerModule() != null) {
			return true;
		} else {
			return false;
		}
	}

}
