package com.vectorsf.jvoice.ui.navigator;

import org.eclipse.core.internal.resources.mapping.SimpleResourceMapping;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.resources.mapping.ResourceMapping;
import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.base.JVProject;

public class AdapterBean implements IAdapterFactory {

	@Override
	public Object getAdapter(Object adaptableObject, Class adapterType) {
		
		if (adaptableObject instanceof JVBean){

			JVBean bean = (JVBean) adaptableObject;
			
			String relName = bean.getName();

			IPath path = new Path(IPath.SEPARATOR + bean.getOwnerPackage().getOwnerProject().getName()).append("main/resources/jv").append(bean.getOwnerPackage().getName()).append(relName);
	

			return ResourcesPlugin.getWorkspace().getRoot().getFile(path);

			}else if(adapterType == ResourceMapping.class){

				JVBean bean = (JVBean) adaptableObject;
				
				String relName = bean.getName();

				IPath path = new Path(IPath.SEPARATOR + bean.getOwnerPackage().getOwnerProject().getName()).append("main/resources/jv").append(bean.getOwnerPackage().getName()).append(relName);

				IFile fichero = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
				
				return new SimpleResourceMapping(fichero);
			
			}else if(adapterType == IResource.class){
				
				JVBean bean = (JVBean) adaptableObject;
				
				String relName = bean.getName();

				IPath path = new Path(IPath.SEPARATOR + bean.getOwnerPackage().getOwnerProject().getName()).append("main/resources/jv").append(bean.getOwnerPackage().getName()).append(relName);

				
				return (IResource) ResourcesPlugin.getWorkspace().getRoot().getFile(path);
				
			}

		return null;
	}

	@Override
	public Class[] getAdapterList() {
		// TODO Auto-generated method stub
		return new Class [] { JVBean.class, IFile.class };
	}

}
