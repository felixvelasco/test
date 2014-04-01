package com.vectorsf.jvoice.ui.diagram.properties.section.helper;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.widgets.Text;

import com.vectorsf.jvoice.ui.diagram.properties.section.SimpleStateSection;

public class UpdatingFocusListener implements FocusListener {

	private final SimpleStateSection simpleStateSection;
	private final EStructuralFeature feature;
	private final Text text;
	private final int index;

	public UpdatingFocusListener(SimpleStateSection simpleStateSection, EStructuralFeature feature, Text text, int index) {
		this.simpleStateSection = simpleStateSection;
		this.feature = feature;
		this.text = text;
		this.index = index;
	}

	@Override
	public void focusLost(FocusEvent e) {
		Object bo = simpleStateSection.getDiagramTypeProvider().getFeatureProvider()
				.getBusinessObjectForPictogramElement(simpleStateSection.getSelectedPictogramElement());
		TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);
		editingDomain.getCommandStack().execute(getCommand(bo, editingDomain));
	}

	private Command getCommand(Object bo, TransactionalEditingDomain editingDomain) {
		EObject eobj = (EObject) bo;
		String newValue = text.getText();
		String oldValue;
		if (index == CommandParameter.NO_INDEX) {
			oldValue = (String) eobj.eGet(feature);
		} else {
			List<?> list = (List<?>) eobj.eGet(feature);
			if (list.size() > index) {
				oldValue = (String) list.get(index);
			} else {
				oldValue = null;
			}
		}
		if (newValue.equals(oldValue) || newValue.isEmpty() && oldValue == null) {
			return UnexecutableCommand.INSTANCE;
		}

		CompoundCommand cc = new CompoundCommand();
		if (feature.isMany()) {
			List<?> list = (List<?>) eobj.eGet(feature);
			if (index + 1 > list.size()) {
				for (int i = index; list.size() < i; i--) {
					// Añadimos tantos parámetros vacíos como haga falta
					cc.append(AddCommand.create(editingDomain, bo, feature, Collections.singleton("")));
				}
				cc.append(AddCommand.create(editingDomain, bo, feature, Collections.singleton(newValue)));
			} else {
				cc.append(SetCommand.create(editingDomain, bo, feature, newValue, index));
			}
		} else {
			cc.append(SetCommand.create(editingDomain, bo, feature, newValue, index));
		}

		cc.append(new RecordingCommand(editingDomain) {

			@Override
			protected void doExecute() {
				simpleStateSection
						.getDiagramTypeProvider()
						.getFeatureProvider()
						.updateIfPossibleAndNeeded(
								new UpdateContext(UpdatingFocusListener.this.simpleStateSection
										.getSelectedPictogramElement()));
			}
		});
		return cc;
	}

	@Override
	public void focusGained(FocusEvent e) {

	}
}