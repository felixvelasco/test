package com.vectorsf.jvoice.ui.navigator.handler;

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
import org.eclipse.emf.ecore.EObject;
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

			if (root.getFile(targetPath).exists()) {

				String newName = getNewName(target,
						"CopyOf " + miBean.getName());
				targetPath = targetRes.getFullPath().append(newName);

				/*
				 * JOptionPane.showMessageDialog(null,
				 * "The file name already exists in the package. It has generated a file named "
				 * + newName.toString());
				 */

			}

			try {
				miBean.copy(targetPath, true, null);
			} catch (CoreException e) {
				e.printStackTrace();
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
		// El clipboard no debe estar vacío
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

	private String getNewName(JVPackage beanPackage, String name) {
		for (EObject o : beanPackage.eContents()) {
			if (o instanceof JVBean) {
				String navName = ((JVBean) o).getName();
				if (navName != null && navName.equals(name)) {
					// Se vuelve a llamar a sí mismo para comprobar que el
					// nombre creado tampoco existe.
					return getNewName(beanPackage, "CopyOf " + name);
				}
			}
		}
		return name;
	}
}
