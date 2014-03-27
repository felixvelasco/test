package com.vectorsf.jvoice.ui.diagram.properties.filters;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.vectorsf.jvoice.model.operations.CallState;
import com.vectorsf.jvoice.model.operations.ComponentBean;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.OperationsPackage;
import com.vectorsf.jvoice.model.operations.ParameterizedState;
import com.vectorsf.jvoice.ui.diagram.properties.section.ExecuteChooser;
import com.vectorsf.jvoice.ui.diagram.properties.section.helper.LabelAndText;

public class CallStateSection extends ParametrizableStateSection {

	private LabelAndText labelTextBean;
	private LabelAndText labelTextMethod;
	private Label returnLabel;
	private CCombo combo;
	private IFeatureProvider fp;

	public CallStateSection() {
	}

	protected final class ChangeComboListener implements SelectionListener {
		private final CCombo combo;

		private ChangeComboListener(CallStateSection callStateSection, CCombo combo) {
			this.combo = combo;
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			Object bo = getDiagramTypeProvider().getFeatureProvider().getBusinessObjectForPictogramElement(
					getSelectedPictogramElement());
			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(bo);
			editingDomain.getCommandStack().execute(getCommand(bo, editingDomain));
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
		}

		private Command getCommand(Object bo, TransactionalEditingDomain editingDomain) {

			for (ComponentBean cb : ((Flow) state.eContainer()).getBeans()) {
				if (cb.getName().equals(combo.getText())) {
					return SetCommand.create(editingDomain, bo,
							OperationsPackage.eINSTANCE.getCallState_ReferencedBean(), cb);
				}
			}

			return null;
		}
	}

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage atabbedPropertySheetPage) {
		super.createControls(parent, atabbedPropertySheetPage);

		labelTextBean = createLabelAndText("Bean", "", null, -1);
		labelTextBean.text.setEnabled(false);

		labelTextMethod = createLabelTextAndButton("Method:", "",
				OperationsPackage.eINSTANCE.getExecutableState_MethodName(), new ExecuteChooser());
	}

	@Override
	public void refresh() {
		super.refresh();
		if (returnLabel != null) {
			returnLabel.dispose();
		}
		if (combo != null) {
			combo.dispose();
		}
		returnLabel = factory.createLabel(composite, "Return");
		returnLabel.setLayoutData(new GridData());

		// Nombre del elemento
		combo = factory.createCCombo(composite);
		GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		combo.setLayoutData(layoutData);
		combo.addSelectionListener(new ChangeComboListener(this, combo));

		combo.removeAll();
		combo.add("");
		state = (ParameterizedState) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(
				getSelectedPictogramElement());
		if (state != null) {
			if (((CallState) state).getBean() != null) {
				/*
				 * Se cambia el nombre que aparece ((CallState) state).getBean().getNameBean() ya que era incorrecto y
				 * se pone el nombre del Component.
				 */
				labelTextBean.text.setText(((CallState) state).getBean().getName());
				if (((CallState) state).getMethodName() != null) {
					labelTextMethod.text.setText(((CallState) state).getMethodName());
					// cargamos combo con los beans que se puedan relacionar

					loadCombo((CallState) state);
				} else {
					labelTextMethod.text.setText("");
				}
			} else {
				labelTextBean.text.setText("");
				labelTextMethod.text.setText("");
			}
		}

		composite.layout(true, true);
	}

	private void loadCombo(CallState state) {
		Flow flujo = (Flow) state.eContainer();
		IProject project = ResourcesPlugin.getWorkspace().getRoot()
				.findMember(EcoreUtil.getURI(flujo).toPlatformString(true)).getProject();
		IJavaProject jProject = JavaCore.create(project);
		IType type;
		String metodoBuscado = null;
		try {
			type = jProject.findType(state.getBean().getFqdn());
			if (type == null) {
				return;
			}

			IMethod[] methods = type.getMethods();
			for (IMethod method : methods) {
				if (method.getElementName().equals(state.getMethodName())) {
					if (method.getReturnType().length() > 1) {
						metodoBuscado = method.getReturnType().substring(1, method.getReturnType().length() - 1);
					} else {
						metodoBuscado = method.getReturnType();
					}
					for (ComponentBean bean : flujo.getBeans()) {
						String clase = bean.getFqdn().substring(bean.getFqdn().lastIndexOf(".") + 1,
								bean.getFqdn().length());
						if (clase.equals(metodoBuscado)) {
							combo.add(bean.getName());
						}
					}
					break;
				}
			}

			if (state.getReferencedBean() != null) {
				for (int i = 0; i < combo.getItems().length; i++) {
					String texto = combo.getItems()[i];
					if (texto.equals(state.getReferencedBean().getName())) {
						combo.select(i);
						break;
					}
				}
			}
		} catch (JavaModelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected String[] getParameterNames(ParameterizedState state) {
		CallState callState = (CallState) state;
		String[] parameterNames = {};
		if (callState.getBean() != null) {
			try {
				IProject project = ResourcesPlugin.getWorkspace().getRoot()
						.findMember(EcoreUtil.getURI(callState).toPlatformString(true)).getProject();
				IJavaProject jProject = JavaCore.create(project);

				IType type = jProject.findType(callState.getBean().getFqdn());
				if (type == null) {
					return parameterNames;
				}

				IMethod[] methods = type.getMethods();
				for (IMethod method : methods) {
					if (method.getElementName().equals(callState.getMethodName())) {
						parameterNames = method.getParameterNames();
					}

				}

			} catch (JavaModelException e) {
				e.printStackTrace();
			}
		}
		return parameterNames;
	}

	public IFeatureProvider obtenerFeatureProvider() {
		return fp;
	}
}
