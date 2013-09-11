package com.vectorsf.jvoice.ui.navigator.ivr;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

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
		return afcp.getChildren(parentElement);
	}

	@Override
	public Object getParent(Object element) {	
		return afcp.getParent(element);
	}

	@Override
	public boolean hasChildren(Object element) {
		return afcp.hasChildren(element);
	}
	

}
