package com.vectorsf.jvoice.ui.widgets;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;

import com.vectorsf.jvoice.model.base.BasePackage;
import com.vectorsf.jvoice.model.base.EventHandler;
import com.vectorsf.jvoice.model.base.JVApplication;
import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVModule;
import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.base.JVProject;
import com.vectorsf.jvoice.model.operations.Flow;

public class ProjectEditorTableViewerEditableColumnBuilder extends TableViewerReferenceEditableColumnBuilder {

	@Override
	protected boolean isEditable(EStructuralFeature eStructuralFeature) {
		return eStructuralFeature.equals(BasePackage.eINSTANCE.getEventHandler_Handler());
	}

	@Override
	protected String getLabel(EObject eObject) {
		if (eObject instanceof Flow) {
			Flow flow = (Flow) eObject;
			return flow.getOwnerPackage().getName() + "." + flow.getName();
		}
		return super.getLabel(eObject);
	}

	@Override
	protected List<EObject> collectCandidates(Object object, EReference feature) {
		EventHandler handler = (EventHandler) object;

		JVProject project = (JVProject) handler.eContainer();
		List<EObject> flows = collectCandidates(project);
		return flows;
	}

	private List<EObject> collectCandidates(JVProject project) {
		List<EObject> flows = new ArrayList<>();

		if (project instanceof JVModule) {
			for (JVPackage pck : ((JVModule) project).getPackages()) {
				for (JVBean bean : pck.getBeans()) {
					if (bean instanceof Flow) {
						flows.add(bean);
					}
				}
			}
		} else if (project instanceof JVApplication) {
			for (JVProject prj : project.getReferencedProjects()) {
				flows.addAll(collectCandidates(prj));
			}
		}
		return flows;
	}
}
