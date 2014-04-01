package com.vectorsf.jvoice.ui.diagram.properties.section.helper;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.ui.edit.validators.ValidatorExecuteBean;

/*
 * Clase donde se selecciona el metodo al que queremos cambiar.
 * Se muestra el dialogo con los bean y sus metodos.
 * Una vez elegido el nuevo metodo al que se quiere referenciar 
 * se vuelve al dialogListener para continuar la ejecucion con
 * el valor selecionado como nuevo valor
 */

public class ItMethodChooser implements IObjectChooser {

	@Override
	public Object getValue(EObject bo, TransactionalEditingDomain editingDomain) {
		Shell activeShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		ElementListSelectionDialog dialog = new ElementListSelectionDialog(activeShell, new JavaElementLabelProvider());

		dialog.setHelpAvailable(false);
		dialog.setValidator(new ValidatorExecuteBean());

		dialog.setTitle("Method Selection");
		dialog.setMessage("Select a method:");

		Flow flow = (Flow) bo.eContainer();

		dialog.setElements(getMethods(flow));

		dialog.open();

		switch (dialog.getReturnCode()) {
		case Dialog.OK:
			Object[] results = dialog.getResult();
			if (results == null) {
				return null;
			}
			IMethod selectedMethod = (IMethod) results[0];
			return selectedMethod.getElementName();

		case Dialog.CANCEL:
			throw new OperationCanceledException();
		default:
			break;
		}

		return null;
	}

	private Object[] getMethods(Flow flow) {
		URI uri = EcoreUtil.getURI(flow);
		IProject project = ResourcesPlugin.getWorkspace().getRoot().findMember(uri.toPlatformString(true)).getProject();
		IJavaProject jProject = JavaCore.create(project);
		IType type;
		try {
			type = jProject.findType(flow.getHelperClass());
			IMethod[] methods = type.getMethods();
			List<IMethod> lPublicMethods = new ArrayList<IMethod>();
			for (IMethod iMethod : methods) {
				if (Flags.isPublic(iMethod.getFlags())) {
					lPublicMethods.add(iMethod);
				}
			}
			return lPublicMethods.toArray();
		} catch (JavaModelException | NullPointerException e) {
			return new Object[0];
		}
	}

}