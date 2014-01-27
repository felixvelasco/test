package com.vectorsf.jvoice.ui.diagram.properties.section;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetWidgetFactory;

import com.vectorsf.jvoice.model.base.BasePackage;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.ui.diagram.properties.section.helper.DialogListener;
import com.vectorsf.jvoice.ui.diagram.properties.section.helper.IObjectChooser;
import com.vectorsf.jvoice.ui.diagram.properties.section.helper.LabelAndText;
import com.vectorsf.jvoice.ui.diagram.properties.section.helper.UpdatingFocusListener;

public abstract class SimpleStateSection extends GFPropertySection {

	protected TabbedPropertySheetWidgetFactory factory;
	protected Composite composite;
	protected LabelAndText nameText;
	protected State state;

	public SimpleStateSection() {
		super();
	}

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage tabbedPropertySheetPage) {
		factory = tabbedPropertySheetPage.getWidgetFactory();
		composite = factory.createPlainComposite(parent, SWT.NONE);
		GridLayout layout = new GridLayout(3, false);
		layout.marginTop = 10;
		layout.marginBottom = 10;
		layout.verticalSpacing = 15;
		layout.horizontalSpacing = 10;
		composite.setLayout(layout);

		nameText = createLabelAndText("Name:", "", BasePackage.eINSTANCE.getNamedElement_Name(),
				CommandParameter.NO_INDEX);
	}

	protected LabelAndText createLabelAndText(String labelText, String value, final EStructuralFeature feature,
			final int index) {
		Label label = factory.createLabel(composite, labelText);
		label.setLayoutData(new GridData());

		Text text = factory.createText(composite, value);
		GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		layoutData.horizontalSpan = 2;
		text.setLayoutData(layoutData);
		text.addFocusListener(new UpdatingFocusListener(this, feature, text, index));

		return new LabelAndText(label, text, null);
	}

	protected LabelAndText createLabelTextAndButton(String labelText, String value, EStructuralFeature feature,
			IObjectChooser chooser) {
		Label label = factory.createLabel(composite, labelText);
		label.setLayoutData(new GridData());

		Text text = factory.createText(composite, value);
		GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		text.setLayoutData(layoutData);
		text.setEditable(false);
		text.setEnabled(false);

		Button button = factory.createButton(composite, "...", SWT.PUSH);
		button.setLayoutData(new GridData());
		button.addSelectionListener(new DialogListener(this, feature, chooser));

		return new LabelAndText(label, text, button);
	}

	@Override
	public void refresh() {
		super.refresh();
		state = (State) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(
				getSelectedPictogramElement());

		if (state != null) {
			nameText.text.setText(state.getName());
		}

	}

	@Override
	public void dispose() {
		super.dispose();
		nameText.text.dispose();
		nameText.label.dispose();
	}

	@Override
	public boolean shouldUseExtraSpace() {
		return true;
	}

	@Override
	public IDiagramTypeProvider getDiagramTypeProvider() {
		return super.getDiagramTypeProvider();
	}

	@Override
	public PictogramElement getSelectedPictogramElement() {
		return super.getSelectedPictogramElement();
	}
}