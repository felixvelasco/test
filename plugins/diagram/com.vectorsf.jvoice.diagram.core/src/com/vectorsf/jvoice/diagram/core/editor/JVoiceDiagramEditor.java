package com.vectorsf.jvoice.diagram.core.editor;

import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.DiagramEditor;

public class JVoiceDiagramEditor extends DiagramEditor {

	@Override
	protected DiagramBehavior createDiagramBehavior() {
		return new JVoiceDiagramBehavior(this);
	}
}
