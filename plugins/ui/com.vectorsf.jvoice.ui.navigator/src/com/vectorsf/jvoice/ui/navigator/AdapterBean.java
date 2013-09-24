package com.vectorsf.jvoice.ui.navigator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.mapping.ResourceMapping;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.ecore.resource.Resource;

import com.vectorsf.jvoice.model.base.JVBean;

@SuppressWarnings("rawtypes")
public class AdapterBean implements IAdapterFactory {

	private static final Class[] ADAPTER_TYPES = new Class[] { IFile.class, ResourceMapping.class, IResource.class };

	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {

		if (adaptableObject instanceof JVBean) {

			if (adapterType == IFile.class || adapterType == IResource.class) {
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

	private IFile adaptarElemento(Object adaptableObject) {
		JVBean bean = (JVBean) adaptableObject;
		Resource res = bean.eResource();

		IPath path = new Path(res.getURI().toPlatformString(true));
		System.out.println(path);
		return ResourcesPlugin.getWorkspace().getRoot().getFile(path);
	}

	@Override
	public Class[] getAdapterList() {
		return ADAPTER_TYPES;
	}

	private boolean verificaPadre(Object adaptableObject) {
		JVBean bean = (JVBean) adaptableObject;
		if (bean.getOwnerPackage() != null) {
			return true;
		} else {
			return false;
		}
	}

}
