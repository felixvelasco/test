package com.vectorsf.jvoice.ui.diagram.properties.filters;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.platform.GFPropertySection;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
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
import com.vectorsf.jvoice.model.operations.CallState;
import com.vectorsf.jvoice.model.operations.OperationsPackage;

public class CallStateSection extends GFPropertySection {

	private final class UpdatingFocusListener implements FocusListener {
		private final EStructuralFeature feature;
		private final LabelAndText ret;
		private final int index;

		private UpdatingFocusListener(EStructuralFeature feature,
				LabelAndText ret, int index) {
			this.feature = feature;
			this.ret = ret;
			this.index = index;
		}

		@Override
		public void focusLost(FocusEvent e) {
			Object bo = getDiagramTypeProvider().getFeatureProvider()
					.getBusinessObjectForPictogramElement(
							getSelectedPictogramElement());
			TransactionalEditingDomain editingDomain = TransactionUtil
					.getEditingDomain(bo);
			editingDomain.getCommandStack().execute(
					getCommand(bo, editingDomain));
		}

		private Command getCommand(Object bo,
				TransactionalEditingDomain editingDomain) {
			CompoundCommand cc = new CompoundCommand();
			cc.append(SetCommand.create(editingDomain, bo, feature,
					ret.text.getText(), index));
			cc.append(new RecordingCommand(editingDomain) {

				@Override
				protected void doExecute() {
					getDiagramTypeProvider().getFeatureProvider()
							.updateIfPossibleAndNeeded(
									new UpdateContext(
											getSelectedPictogramElement()));
				}
			});
			return cc;
		}

		@Override
		public void focusGained(FocusEvent e) {

		}
	}

	public class LabelAndText {
		public final Label label;
		public final Text text;

		public LabelAndText(Label label, Text text) {
			this.label = label;
			this.text = text;
		}
	}

	private TabbedPropertySheetWidgetFactory factory;
	private Composite composite;

	private LabelAndText nameText;
	private List<LabelAndText> callParameters = new ArrayList<>();

	public CallStateSection() {
	}

	@Override
	public void createControls(Composite parent,
			TabbedPropertySheetPage tabbedPropertySheetPage) {
		factory = tabbedPropertySheetPage.getWidgetFactory();
		composite = factory.createPlainComposite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));

		nameText = createLabelAndText("Name:", "",
				BasePackage.eINSTANCE.getNamedElement_Name(),
				CommandParameter.NO_INDEX);
	}

	protected LabelAndText createLabelAndText(String labelText, String value,
			final EStructuralFeature feature, final int index) {
		Label label = factory.createLabel(composite, labelText);
		label.setLayoutData(new GridData());

		// Nombre del elemento
		Text text = factory.createText(composite, value);
		GridData layoutData = new GridData();
		layoutData.grabExcessHorizontalSpace = true;
		text.setLayoutData(layoutData);

		final LabelAndText ret = new LabelAndText(label, text);

		text.addFocusListener(new UpdatingFocusListener(feature, ret, index));

		return ret;
	}

	/**
	 * @param index
	 * @param factory
	 * @param composite
	 */
	protected LabelAndText drawParameter(String name, String value, int index) {
		return createLabelAndText(name + ":", value,
				OperationsPackage.eINSTANCE.getParameterizedState_Parameters(),
				index);

	}

	@Override
	public void refresh() {
		super.refresh();

		PictogramElement pe = getSelectedPictogramElement();

		CallState call = (CallState) Graphiti.getLinkService()
				.getBusinessObjectForLinkedPictogramElement(
						getSelectedPictogramElement());

		nameText.text.setText(call.getName());
		IProject project = ResourcesPlugin.getWorkspace().getRoot()
				.findMember(EcoreUtil.getURI(pe).toPlatformString(true))
				.getProject();
		IJavaProject jProject = JavaCore.create(project);
		String[] parameterNames = {};
		try {
			IType type = jProject.findType(call.getBean().getFqdn());

			IMethod[] methods = type.getMethods();
			for (IMethod method : methods) {
				if (method.getElementName().equals(call.getMethodName())) {
					parameterNames = method.getParameterNames();
				}

			}

		} catch (JavaModelException e) {
			e.printStackTrace();
		}

		for (LabelAndText callp : callParameters) {
			callp.label.dispose();
			callp.text.dispose();
		}
		callParameters.clear();
		if (call.getParameters() != null) {

			List<String> parametersValues = call.getParameters();
			for (int i = 0; i < parametersValues.size(); i++) {
				String paramValue = parametersValues.get(i);
				callParameters.add(drawParameter(parameterNames[i], paramValue,
						i));
			}
		}
		composite.layout(true, true);
	}

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
}
