package com.vectorsf.jvoice.ui.diagram.properties.filters;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import com.vectorsf.jvoice.model.base.BasePackage;
import com.vectorsf.jvoice.model.operations.OperationsPackage;
import com.vectorsf.jvoice.model.operations.ParameterizedState;

public abstract class ParametrizableStateSection extends GFPropertySection {

	protected final class UpdatingFocusListener implements FocusListener {
		private final EStructuralFeature feature;
		private final Text text;
		private final int index;

		private UpdatingFocusListener(EStructuralFeature feature, Text text, int index) {
			this.feature = feature;
			this.text = text;
			this.index = index;
		}

		@Override
		public void focusLost(FocusEvent e) {
			Object bo = getDiagramTypeProvider().getFeatureProvider().getBusinessObjectForPictogramElement(
					getSelectedPictogramElement());
			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);
			editingDomain.getCommandStack().execute(getCommand(bo, editingDomain));
		}

		private Command getCommand(Object bo, TransactionalEditingDomain editingDomain) {
			CompoundCommand cc = new CompoundCommand();
			cc.append(SetCommand.create(editingDomain, bo, feature, text.getText(), index));
			cc.append(new RecordingCommand(editingDomain) {

				@Override
				protected void doExecute() {
					getDiagramTypeProvider().getFeatureProvider().updateIfPossibleAndNeeded(
							new UpdateContext(getSelectedPictogramElement()));
				}
			});
			return cc;
		}

		@Override
		public void focusGained(FocusEvent e) {

		}
	}

	protected class LabelAndText {
		public final Label label;
		public final Text text;

		public LabelAndText(Label label, Text text) {
			this.label = label;
			this.text = text;
		}
	}

	protected TabbedPropertySheetWidgetFactory factory;
	protected Composite composite;
	protected ParameterizedState state;

	protected LabelAndText nameText;
	private List<LabelAndText> callParameters = new ArrayList<>();

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		factory = tabbedPropertySheetPage.getWidgetFactory();
		composite = factory.createPlainComposite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));

		nameText = createLabelAndText("Name:", "", BasePackage.eINSTANCE.getNamedElement_Name(),
				CommandParameter.NO_INDEX);
	}

	protected LabelAndText createLabelAndText(String labelText, String value, final EStructuralFeature feature,
			final int index) {
		Label label = factory.createLabel(composite, labelText);
		label.setLayoutData(new GridData());

		// Nombre del elemento
		Text text = factory.createText(composite, value);
		GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		text.setLayoutData(layoutData);
		text.addFocusListener(new UpdatingFocusListener(feature, text, index));

		return new LabelAndText(label, text);
	}

	/**
	 * @param index
	 * @param factory
	 * @param composite
	 */
	protected LabelAndText drawParameter(String name, String value, int index) {
		return createLabelAndText(name + ":", value, OperationsPackage.eINSTANCE.getParameterizedState_Parameters(),
				index);

	}

	@Override
	public void refresh() {
		super.refresh();

		state = (ParameterizedState) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(
				getSelectedPictogramElement());
		if (state != null) {
			nameText.text.setText(state.getName());

			String[] parameterNames = getParameterNames(state);

			for (LabelAndText callp : callParameters) {
				callp.label.dispose();
				callp.text.dispose();
			}
			callParameters.clear();
			if (state.getParameters() != null) {

				List<String> parametersValues = state.getParameters();
				for (int i = 0; i < parametersValues.size(); i++) {
					String paramValue = parametersValues.get(i);
					if (parameterNames.length != 0 && i < parameterNames.length) {
						callParameters.add(drawParameter(parameterNames[i], paramValue, i));
					}

				}
			}
			composite.layout(true, true);
		}
	}

	protected abstract String[] getParameterNames(ParameterizedState state);

	@Override
	public void dispose() {
		super.dispose();
		nameText.text.dispose();
		nameText.label.dispose();
		for (LabelAndText callp : callParameters) {
			callp.label.dispose();
			callp.text.dispose();
		}
		callParameters.clear();
	}

	@Override
	public boolean shouldUseExtraSpace() {
		return true;
	}

}
