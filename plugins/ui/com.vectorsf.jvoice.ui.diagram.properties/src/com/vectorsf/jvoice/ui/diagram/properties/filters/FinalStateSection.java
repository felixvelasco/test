package com.vectorsf.jvoice.ui.diagram.properties.filters;

import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import com.vectorsf.jvoice.model.operations.FinalState;
import com.vectorsf.jvoice.model.operations.OperationsPackage;

public class FinalStateSection extends StateSection {

	private Text expressionText;
	private FocusListener expressionListener;

	public FinalStateSection() {
	}

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		super.createControls(parent, tabbedPropertySheetPage);
		createExpressionText(getWidgetFactory());
	}

	protected void createExpressionText(TabbedPropertySheetWidgetFactory factory) {
		// Nombre del elemento
		expressionText = factory.createText(composite, "");
		FormData data = new FormData();
		data.left = new FormAttachment(nameText, 0, SWT.LEFT);
		data.right = new FormAttachment(nameText, -120, SWT.RIGHT);
		data.top = new FormAttachment(nameText, 10);
		expressionText.setLayoutData(data);

		expressionListener = new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				Object bo = getDiagramTypeProvider().getFeatureProvider().getBusinessObjectForPictogramElement(
						getSelectedPictogramElement());
				TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);
				editingDomain.getCommandStack()
						.execute(
								SetCommand.create(editingDomain, bo,
										OperationsPackage.eINSTANCE.getFinalState_ReturnExpression(),
										expressionText.getText()));
			}

			@Override
			public void focusGained(FocusEvent e) {

			}
		};

		CLabel labelExpression = factory.createCLabel(composite, "Expression:");
		data = new FormData();
		data.left = new FormAttachment(0, 0);
		data.right = new FormAttachment(expressionText, -HSPACE);
		data.top = new FormAttachment(expressionText, 0, SWT.CENTER);
		labelExpression.setLayoutData(data);
	}

	@Override
	protected void removelistener(Object bo) {
		super.removelistener(bo);
		expressionText.removeFocusListener(expressionListener);
	}

	@Override
	public void refresh() {
		super.refresh();
		FinalState state = (FinalState) getDiagramTypeProvider().getFeatureProvider()
				.getBusinessObjectForPictogramElement(getSelectedPictogramElement());

		expressionText.setText(state.getReturnExpression());
		expressionText.addFocusListener(expressionListener);
	}
}
