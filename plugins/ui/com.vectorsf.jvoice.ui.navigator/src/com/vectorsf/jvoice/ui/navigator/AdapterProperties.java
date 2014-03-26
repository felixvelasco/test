package com.vectorsf.jvoice.ui.navigator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.mapping.ResourceMapping;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.model.base.Configuration;
import com.vectorsf.jvoice.model.base.JVProject;

@SuppressWarnings("rawtypes")
public class AdapterProperties implements IAdapterFactory {

	private static final Class[] ADAPTER_TYPES = new Class[] { IFile.class,
			ResourceMapping.class, IResource.class, };

	private final static IPath PROPERTIES_PATH = new Path(
			BaseModel.PROPERTIES_PATH);
	public static final String PROPERTY = "properties";

	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {

		if (adaptableObject instanceof Configuration) {

			if (adapterType == IFile.class || adapterType == IResource.class) {
				return adaptarElemento(adaptableObject);

			} else if (adapterType == ResourceMapping.class) {
				IFile file = adaptarElemento(adaptableObject);
				if (file != null) {
					@SuppressWarnings("restriction")
					final ResourceMapping simpleResourceMapping = new org.eclipse.core.internal.resources.mapping.SimpleResourceMapping(
							file);
					return simpleResourceMapping;
				}
			}
		}
		return null;
	}

	private IFile adaptarElemento(Object adaptableObject) {
		Configuration confi = (Configuration) adaptableObject;
		IPath path = getpath(confi);

		if (path != null) {
			return ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		} else {
			return null;
		}
	}

	private IPath getpath(Configuration confi) {

		if (confi.eContainer() != null) {
			JVProject modulo = (JVProject) confi.eContainer();
			return new Path("/" + modulo.getName()).append(PROPERTIES_PATH)
					.append(confi.getName()).addFileExtension(PROPERTY);
		} else {
			return null;
		}

	}

	@Override
	public Class[] getAdapterList() {
		return ADAPTER_TYPES;
	}

}
