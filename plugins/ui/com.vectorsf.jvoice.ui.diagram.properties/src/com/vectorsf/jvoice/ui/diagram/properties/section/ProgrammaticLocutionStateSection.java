package com.vectorsf.jvoice.ui.diagram.properties.section;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.LocutionState;
import com.vectorsf.jvoice.model.operations.OperationsPackage;
import com.vectorsf.jvoice.model.operations.ParameterizedState;
import com.vectorsf.jvoice.ui.diagram.properties.section.helper.IObjectChooser;
import com.vectorsf.jvoice.ui.diagram.properties.section.helper.ItMethodChooser;
import com.vectorsf.jvoice.ui.diagram.properties.section.helper.LabelAndText;

public class ProgrammaticLocutionStateSection extends ParametrizableStateSection {

	private LabelAndText labelTextMethod;
	private IFeatureProvider fp;

	public ProgrammaticLocutionStateSection() {
	}

	@Override
	public void doCreateControls(Composite parent, TabbedPropertySheetPage atabbedPropertySheetPage) {
		labelTextMethod = createLabelTextAndButton("Method:", "",
				OperationsPackage.eINSTANCE.getExecutableState_MethodName(), new ItMethodChooser());

	}

	@Override
	public void refresh() {
		super.refresh();

		state = (ParameterizedState) Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(
				getSelectedPictogramElement());
		if (state != null) {
			LocutionState locutionState = (LocutionState) state;
			if (locutionState.getMethodName() != null) {
				labelTextMethod.text.setText(locutionState.getMethodName());
			} else {
				labelTextMethod.text.setText("");
			}
		}
	}

	@Override
	protected String[] getParameterNames(ParameterizedState state) {
		LocutionState locutionState = (LocutionState) state;
		String[] parameterNames = {};
		try {
			IProject project = ResourcesPlugin.getWorkspace().getRoot()
					.findMember(EcoreUtil.getURI(locutionState).toPlatformString(true)).getProject();
			IJavaProject jProject = JavaCore.create(project);

			IType type = jProject.findType(((Flow) locutionState.eContainer()).getHelperClass());
			if (type == null) {
				return parameterNames;
			}

			IMethod[] methods = type.getMethods();
			for (IMethod method : methods) {
				if (method.getElementName().equals(locutionState.getMethodName())) {
					parameterNames = method.getParameterNames();
				}
			}

		} catch (JavaModelException e) {
			e.printStackTrace();
		}

		return parameterNames;
	}

	@Override
	protected SelectionListener createListener(EStructuralFeature feature, IObjectChooser chooser) {
		// if (feature == OperationsPackage.eINSTANCE.getExecutableState_MethodName()) {
		// return new ExecuteDialogListener(this, feature, chooser);
		// } else {
		return super.createListener(feature, chooser);
		// }
	}

	public IFeatureProvider obtenerFeatureProvider() {
		return fp;
	}
}
