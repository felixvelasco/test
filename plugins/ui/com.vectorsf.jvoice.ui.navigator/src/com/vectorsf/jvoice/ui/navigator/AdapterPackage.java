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

	private static final Class[] ADAPTER_TYPES = new Class[] { IFolder.class,
			ResourceMapping.class, IResource.class };

	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {

		if (adaptableObject instanceof JVPackage) {

			if (adapterType == IFolder.class || adapterType == IResource.class) {
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

	private IFolder adaptarElemento(Object adaptableObject) {
		JVPackage pck = (JVPackage) adaptableObject;
		String relName = pck.getName().replace('.', IPath.SEPARATOR);
		IPath path = new Path(IPath.SEPARATOR + pck.getOwnerProject().getName())
				.append("src/main/resources/jv").append(relName);
		return ResourcesPlugin.getWorkspace().getRoot().getFolder(path);
	}

	@Override
	public Class[] getAdapterList() {
		return ADAPTER_TYPES;
	}

}
