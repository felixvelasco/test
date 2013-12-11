package com.vectorsf.jvoice.diagram.core.editor;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;

import com.vectorsf.jvoice.diagram.core.features.CoreToolBehaviourProvider;
import com.vectorsf.jvoice.model.operations.Flow;

public class JVoiceValidationListener extends ResourceSetListenerImpl {

	private DiagramBehavior diagramBehavior;

	public JVoiceValidationListener(DiagramBehavior diagramBehavior) {
		this.diagramBehavior = diagramBehavior;
	}

	@Override
	public boolean isPostcommitOnly() {
		return true;
	}

	@Override
	public void resourceSetChanged(ResourceSetChangeEvent event) {
		validate();
	}

	public void validate() {
		Flow flow = getFlow();

		if (flow != null) {
			Diagnostic diagnostic = Diagnostician.INSTANCE.validate(flow);
			setDiagnostic(diagnostic);
		}
	}

	private void setDiagnostic(Diagnostic diagnostic) {
		IToolBehaviorProvider tbp = diagramBehavior.getDiagramTypeProvider().getCurrentToolBehaviorProvider();

		if (tbp instanceof CoreToolBehaviourProvider) {
			((CoreToolBehaviourProvider) tbp).setDiagnostic(diagnostic);
		}
	}

	private Flow getFlow() {
		Diagram diagram = diagramBehavior.getDiagramTypeProvider().getDiagram();
		Object bo = diagramBehavior.getDiagramTypeProvider().getFeatureProvider()
				.getBusinessObjectForPictogramElement(diagram);
		if (bo instanceof Flow) {
			return (Flow) bo;
		}

		return null;
	}
}
