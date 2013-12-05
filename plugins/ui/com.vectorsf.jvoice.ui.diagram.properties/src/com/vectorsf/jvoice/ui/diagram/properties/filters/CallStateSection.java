package com.vectorsf.jvoice.ui.diagram.properties.filters;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.vectorsf.jvoice.model.operations.CallState;
import com.vectorsf.jvoice.model.operations.ParameterizedState;

public class CallStateSection extends ParametrizableStateSection {

	private LabelAndText bean;
	private LabelAndText method;

	public CallStateSection() {
	}

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage atabbedPropertySheetPage) {
		super.createControls(parent, atabbedPropertySheetPage);

		bean = createLabelAndText("Bean", "", null, -1);
		bean.text.setEnabled(false);

		method = createLabelAndText("Method", "", null, -1);
		method.text.setEnabled(false);
	}

	@Override
	public void refresh() {
		super.refresh();
		if (((CallState) state).getBean() != null) {
			bean.text.setText(((CallState) state).getBean().getNameBean());
			if (((CallState) state).getMethodName() != null) {
				method.text.setText(((CallState) state).getMethodName());
			} else {
				method.text.setText("");
			}
		} else {
			bean.text.setText("");
			method.text.setText("");
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
}
