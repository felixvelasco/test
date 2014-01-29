package com.vectorsf.jvoice.ui.diagram.properties.section.helper;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import com.vectorsf.jvoice.ui.diagram.properties.section.SimpleStateSection;

public class DialogListener implements SelectionListener {

	private EStructuralFeature feature;
	private SimpleStateSection simpleStateSection;
	private IObjectChooser chooser;

	public DialogListener(SimpleStateSection simpleStateSection, EStructuralFeature feature, IObjectChooser chooser) {
		this.simpleStateSection = simpleStateSection;
		this.feature = feature;
		this.chooser = chooser;
	}

	@Override
	public void widgetSelected(SelectionEvent e) {
		EObject bo = (EObject) simpleStateSection.getDiagramTypeProvider().getFeatureProvider()
				.getBusinessObjectForPictogramElement(simpleStateSection.getSelectedPictogramElement());
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);
		Object newValue = chooser.getValue(bo, editingDomain);
		Object oldValue = bo.eGet(feature);

		if (newValue != null && oldValue != newValue) {
			editingDomain.getCommandStack().execute(SetCommand.create(editingDomain, bo, feature, newValue));
		}
		simpleStateSection.refresh();
	}

	@Override
	public void widgetDefaultSelected(SelectionEvent e) {
	}

}