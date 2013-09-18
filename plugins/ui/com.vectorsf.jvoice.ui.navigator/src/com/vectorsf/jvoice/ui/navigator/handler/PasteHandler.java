package com.vectorsf.jvoice.ui.navigator.handler;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.widgets.Display;

import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVPackage;

public class PasteHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		JVPackage target = getValidTarget(((IEvaluationContext) event
				.getApplicationContext()).getDefaultVariable());
		if (target == null) {
			return null;
		}

		List<JVBean> beans = getJVBeanFromClipboard();
		if (beans == null) {
			return null;
		}
		for (JVBean bean : beans) {
			IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
			IFile miBean = (IFile) Platform.getAdapterManager().getAdapter(
					bean, IFile.class);

			IResource targetRes = (IResource) Platform.getAdapterManager()
					.getAdapter(target, IResource.class);
			IPath targetPath = targetRes.getFullPath().append(miBean.getName());
			boolean renamed = false;
			if (root.getFile(targetPath).exists()) {
				renamed = true;
				String newName = getNewName(
						target,
						"CopyOf "
								+ miBean.getName().substring(0,
										miBean.getName().lastIndexOf('.')));
				targetPath = targetRes.getFullPath().append(
						newName + "." + targetPath.getFileExtension()); //$NON-NLS-1$
			}

			try {
				miBean.copy(targetPath, true, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}

			if (renamed) {
				renameBean(targetPath);
			}
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	private JVPackage getValidTarget(Object target) {
		if (!(target instanceof Collection<?>)
				|| ((Collection<Object>) target).size() != 1) {
			return null;
		}

		Object o = ((Collection<Object>) target).iterator().next();
		return o instanceof JVPackage ? (JVPackage) o : null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<JVBean> getJVBeanFromClipboard() {
		// El clipboard no debe estar vac�o
		Clipboard clip = new Clipboard(Display.getCurrent());
		Object contents = clip
				.getContents(LocalSelectionTransfer.getTransfer());
		if (contents == null) {
			return null;
		}

		// Todos los elementos deben ser navegaciones
		List toPaste = ((IStructuredSelection) contents).toList();
		for (Object o : toPaste) {
			if (!(o instanceof JVBean)) {
				return null;
			}
		}
		return toPaste;
	}

	private void renameBean(IPath targetPath) {
		String newName = targetPath.lastSegment();
		newName = newName.substring(0, newName.lastIndexOf('.'));
		ResourceSetImpl resourceSetImpl = new ResourceSetImpl();
		Resource emfRes = resourceSetImpl.createResource(URI
				.createPlatformResourceURI(targetPath.toString(), true));
		try {
			emfRes.load(null);

			for (EObject obj : emfRes.getContents()) {
				if (obj instanceof JVBean) {
					JVBean bean = (JVBean) obj;
					bean.setId(newName);
					bean.setName(newName);
				}
			}
			emfRes.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getNewName(JVPackage beanPackage, String name) {
		for (EObject o : beanPackage.eContents()) {
			if (o instanceof JVBean) {
				String navName = ((JVBean) o).getName();
				if (navName != null && navName.equals(name)) {
					// Se vuelve a llamar a s� mismo para comprobar que el
					// nombre creado tampoco existe.
					return getNewName(beanPackage, "CopyOf " + name);
				}
			}
		}
		return name;
	}
}
