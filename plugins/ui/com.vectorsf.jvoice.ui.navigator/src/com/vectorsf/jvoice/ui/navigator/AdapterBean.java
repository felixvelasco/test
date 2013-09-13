package com.vectorsf.jvoice.ui.navigator;

import org.eclipse.core.internal.resources.mapping.SimpleResourceMapping;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.mapping.ResourceMapping;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.vectorsf.jvoice.model.base.JVBean;

@SuppressWarnings("restriction")
public class AdapterBean implements IAdapterFactory {

	@SuppressWarnings({ "rawtypes" })
	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		
		if (adaptableObject instanceof JVBean){
			
			if(adapterType == ResourceMapping.class){
				return adaptarElemento (adaptableObject);
			}else if(adapterType == ResourceMapping.class){
				return new SimpleResourceMapping(adaptarElemento (adaptableObject));
			}else if(adapterType == IResource.class){
				return (IResource) adaptarElemento (adaptableObject);
			}
		}
		return null;
	}
	
	private IFile adaptarElemento (Object adaptableObject){
		JVBean bean = (JVBean) adaptableObject;
		String relName = bean.getName();
		IPath path = new Path(IPath.SEPARATOR + bean.getOwnerPackage().getOwnerProject().getName()).append("main/resources/jv").append(bean.getOwnerPackage().getName()).append(relName);
		return ResourcesPlugin.getWorkspace().getRoot().getFile(path);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Class[] getAdapterList() {
		// TODO Auto-generated method stub
		return new Class [] { JVBean.class, IFile.class, ResourceMapping.class, IResource.class };
	}

}
