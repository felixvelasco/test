package com.vectorsf.jvoice.ui.navigator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.ui.navigator.ILinkHelper;
import org.eclipse.ui.part.FileEditorInput;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.model.base.JVBean;

public class LinkHelper implements ILinkHelper {
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.ILinkHelper#findSelection(org.eclipse.ui.IEditorInput)
	 */
	@Override
	public IStructuredSelection findSelection(IEditorInput anInput) {
		IFile file = ResourceUtil.getFile(anInput);
		if (file != null) {
			ResourceSet resourceSet = BaseModel.getInstance().getResourceSet();
			URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			Resource eResource = resourceSet.getResource(uri, false);

			if (eResource != null) {
				for (EObject e : eResource.getContents()) {
					if (e instanceof JVBean) {
						return new StructuredSelection(e);
					}
				}
			}
		}
		return StructuredSelection.EMPTY;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.navigator.ILinkHelper#activateEditor(org.eclipse.ui.IWorkbenchPage,
	 * org.eclipse.jface.viewers.IStructuredSelection)
	 */
	@Override
	public void activateEditor(IWorkbenchPage aPage, IStructuredSelection aSelection) {
		if (aSelection == null || aSelection.isEmpty()) {
			return;
		}
		if (aSelection.getFirstElement() instanceof JVBean) {

			IFile file = (IFile) Platform.getAdapterManager().getAdapter(aSelection.getFirstElement(), IFile.class);
			if (file != null) {
				IEditorInput fileInput = new FileEditorInput(file);
				IEditorPart editor = null;
				if ((editor = aPage.findEditor(fileInput)) != null) {
					aPage.bringToTop(editor);
				}
			}
		}

	}

}
