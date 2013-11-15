package com.vectorsf.jvoice.ui.project.editor;

import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.parsley.binding.AbstractControlFactory;
import org.eclipse.emf.parsley.binding.ControlObservablePair;
import org.eclipse.emf.parsley.binding.FormControlFactory;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

import com.vectorsf.jvoice.model.base.BasePackage;
import com.vectorsf.jvoice.model.base.JVProject;

public class ProjectEditorFormControlFactory extends FormControlFactory {

	protected ControlObservablePair control_NamedElement_description(EStructuralFeature feature) {
		ControlObservablePair retValAndTargetPair = new ControlObservablePair();
		Text t = createText(parent, "", SWT.BORDER | SWT.MULTI);
		t.setEditable(!readonly);

		List<?> proposals = null;
		if (!readonly) {
			proposals = createProposals(feature);
		}

		addContentProposalAdapter(t, proposals);
		retValAndTargetPair.setControl(t);
		retValAndTargetPair.setObservableValue(SWTObservables.observeText(t, SWT.Modify));

		return retValAndTargetPair;
	}

	@Override
	protected void registerUndo(Control control) {
		super.registerUndo(control);

		Object data = control.getData(AbstractControlFactory.ESTRUCTURALFEATURE_KEY);
		Object eObject = control.getData(AbstractControlFactory.EOBJECT_KEY);
		if (data instanceof EStructuralFeature) {
			EStructuralFeature feature = (EStructuralFeature) data;
			if (feature.equals(BasePackage.eINSTANCE.getNamedElement_Description())) {
				control.setLayoutData(new GridData(GridData.FILL_BOTH));
			} else if (feature.equals(BasePackage.eINSTANCE.getNamedElement_Name()) && eObject instanceof JVProject
					&& control instanceof Text) {
				((Text) control).setEditable(false);
			}

		}
		;
	}
}
