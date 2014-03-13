package com.vectorsf.jvoice.ui.diagram.properties.section;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.vectorsf.jvoice.model.operations.ComponentBean;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.ui.diagram.properties.section.helper.IObjectChooser;
import com.vectorsf.jvoice.ui.edit.dialogs.DialogExecuteBean;
import com.vectorsf.jvoice.ui.edit.filters.FilterDialogExecuteBean;
import com.vectorsf.jvoice.ui.edit.provider.MethodsBeanContentProvider;
import com.vectorsf.jvoice.ui.edit.provider.MethodsBeanLabelProvider;
import com.vectorsf.jvoice.ui.edit.validators.ValidatorExecuteBean;

/*
 * Clase donde se selecciona el metodo al que queremos cambiar.
 * Se muestra el dialogo con los bean y sus metodos.
 * Una vez elegido el nuevo metodo al que se quiere referenciar 
 * se vuelve al dialogListener para continuar la ejecucion con
 * el valor selecionado como nuevo valor
 */

public class ExecuteChooser implements IObjectChooser {

	@Override
	public Object getValue(EObject bo, TransactionalEditingDomain editingDomain) {
		Shell activeShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		MethodsBeanContentProvider methotdBeanContentProvider = new MethodsBeanContentProvider(adapterFactory);
		MethodsBeanLabelProvider labelProviderMB = new MethodsBeanLabelProvider();

		DialogExecuteBean dialog = new DialogExecuteBean(activeShell, labelProviderMB, methotdBeanContentProvider);

		dialog.setAllowMultiple(false);
		dialog.setHelpAvailable(false);
		dialog.setValidator(new ValidatorExecuteBean());

		dialog.addFilter(new FilterDialogExecuteBean());
		dialog.setTitle("Bean Selection");
		dialog.setMessage("Select a method:");

		Flow flow = (Flow) bo.eContainer();
		EList<ComponentBean> lb = flow.getBeans();

		dialog.setInput(lb);

		dialog.open();

		switch (dialog.getReturnCode()) {
		case Dialog.OK:
			Object[] results = dialog.getResult();

			return results;
		case Dialog.CANCEL:
			throw new OperationCanceledException();
		default:
			break;
		}

		return null;
	}

}