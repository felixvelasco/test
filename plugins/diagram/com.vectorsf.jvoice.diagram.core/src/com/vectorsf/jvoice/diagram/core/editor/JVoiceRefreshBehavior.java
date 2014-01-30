package com.vectorsf.jvoice.diagram.core.editor;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.ui.editor.DefaultRefreshBehavior;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;

public class JVoiceRefreshBehavior extends DefaultRefreshBehavior {

	public JVoiceRefreshBehavior(DiagramBehavior diagramBehavior) {
		super(diagramBehavior);
	}

	/**
	 * Refresca los estados al arrancar el editor.
	 */
	@Override
	protected void autoUpdate() {
		IDiagramTypeProvider diagramTypeProvider = diagramBehavior.getDiagramTypeProvider();

		IFeatureProvider fp = diagramTypeProvider.getFeatureProvider();
		Diagram diagram = diagramTypeProvider.getDiagram();

		for (Shape shape : diagram.getChildren()) {
			fp.updateIfPossible(new UpdateContext(shape));
		}

		refresh();
	}

}
