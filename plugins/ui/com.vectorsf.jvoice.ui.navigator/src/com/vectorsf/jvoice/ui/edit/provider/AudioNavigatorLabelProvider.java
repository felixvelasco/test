package com.vectorsf.jvoice.ui.edit.provider;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;

public class AudioNavigatorLabelProvider implements ILabelProvider {
	AdapterFactoryLabelProvider aflp;

	public AudioNavigatorLabelProvider() {
		ComposedAdapterFactory factorylabel = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		aflp = new AdapterFactoryLabelProvider(factorylabel);

	}

	@Override
	public void addListener(ILabelProviderListener listener) {
		aflp.addListener(listener);
	}

	@Override
	public void dispose() {
		aflp.dispose();

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return aflp.isLabelProperty(element, property);
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		aflp.removeListener(listener);

	}

	@Override
	public Image getImage(Object element) {

		return aflp.getImage(element);
	}

	@Override
	public String getText(Object element) {
		if (element instanceof IFile) {
			return ((IFile) element).getName();
		} else if (element instanceof IFolder) {
			return ((IFolder) element).getName();
		}
		return null;
	}

}
