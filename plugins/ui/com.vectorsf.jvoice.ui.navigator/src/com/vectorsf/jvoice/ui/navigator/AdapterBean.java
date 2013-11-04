package com.vectorsf.jvoice.ui.navigator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.mapping.ResourceMapping;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.vectorsf.jvoice.model.base.JVBean;

@SuppressWarnings("rawtypes")
public class AdapterBean implements IAdapterFactory {

	private static final Class[] ADAPTER_TYPES = new Class[] { IFile.class,
			ResourceMapping.class, IResource.class };

	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {

		if (adaptableObject instanceof JVBean) {

			if (adapterType == IFile.class || adapterType == IResource.class) {
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

	private IFile adaptarElemento(Object adaptableObject) {
		JVBean bean = (JVBean) adaptableObject;
		if (bean.eResource() != null) {
			IPath path = new Path(bean.eResource().getURI()
					.toPlatformString(true));
			return ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		} else {
			return null;
		}
	}

	@Override
	public Class[] getAdapterList() {
		return ADAPTER_TYPES;
	}

}
