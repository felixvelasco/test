package com.vectorsf.jvoice.ui.diagram.properties.section.helper;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import com.vectorsf.jvoice.model.operations.ComponentBean;
import com.vectorsf.jvoice.model.operations.OperationsPackage;
import com.vectorsf.jvoice.ui.diagram.properties.section.SimpleStateSection;

/*
 * Solo en el caso de que se trata de un execute se cambian los valores del nombre del bean y el metodo la
 * que hacen referencia.
 */

public class ExecuteDialogListener implements SelectionListener {

	private EStructuralFeature feature;
	private SimpleStateSection simpleStateSection;
	private IObjectChooser chooser;

	public ExecuteDialogListener(SimpleStateSection simpleStateSection, EStructuralFeature feature,
			IObjectChooser chooser) {
		this.simpleStateSection = simpleStateSection;
		this.feature = feature;
		this.chooser = chooser;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		EObject bo = (EObject) simpleStateSection.getDiagramTypeProvider().getFeatureProvider()
				.getBusinessObjectForPictogramElement(simpleStateSection.getSelectedPictogramElement());
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);
		Object[] newValue = (Object[]) chooser.getValue(bo, editingDomain);
		Object oldValue = null;
		IMethod methodResult = (IMethod) newValue[0];
		ComponentBean componentBean = (ComponentBean) newValue[1];

		oldValue = bo.eGet(feature);

		// Comprobamos el nombre
		String nameMethod = methodResult.getElementName();
		if (nameMethod != null && oldValue != nameMethod) {
			// // Se cambia el nombre del metodo
			editingDomain.getCommandStack().execute(SetCommand.create(editingDomain, bo, feature, nameMethod));
		}
		// Se comprueba el bean
		EReference feature2 = OperationsPackage.eINSTANCE.getCallState_Bean();
		oldValue = bo.eGet(feature2);
		if (componentBean != null && oldValue != componentBean) {
			// Se cambia el nombre del bean al que pertenece el metodo.
			editingDomain.getCommandStack().execute(SetCommand.create(editingDomain, bo, feature2, componentBean));
		}

		simpleStateSection.refresh();
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
	}

}