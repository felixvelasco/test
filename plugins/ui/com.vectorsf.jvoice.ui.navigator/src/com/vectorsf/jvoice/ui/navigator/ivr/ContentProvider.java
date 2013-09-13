package com.vectorsf.jvoice.ui.navigator.ivr;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.vectorsf.jvoice.model.base.JVProject;

public class ContentProvider implements ITreeContentProvider {
	
	AdapterFactoryContentProvider afcp;
	public ContentProvider() {
		ComposedAdapterFactory factory = new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		afcp = new  AdapterFactoryContentProvider(factory);
	}

	@Override
	public void dispose() {
		afcp.dispose();
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		afcp.inputChanged(viewer, oldInput, newInput);
	}

	@Override
	public Object[] getElements(Object inputElement) {		
		return afcp.getElements(inputElement);
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof JVProject)
		{
			List<Object> children = new ArrayList<>();
			Collections.addAll(children, afcp.getChildren(parentElement));

//			try {
//				for(int i=0; i<jProject.getRawClasspath().length; i++){
//					IClasspathEntry miclase = jProject.getRawClasspath()[i];
//					children.add(miclase);
//				}
//				//children.add(jProject.getRawClasspath());
//			} catch (JavaModelException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			return children.toArray();
		} else
		return afcp.getChildren(parentElement);
	}

	@Override
	public Object getParent(Object element) {	
		return afcp.getParent(element);
	}

	@Override
	public boolean hasChildren(Object element) {
		return afcp.hasChildren(element) || true;
	}
	

}
