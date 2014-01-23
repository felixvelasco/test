package com.vectorsf.jvoice.diagram.core.editor;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.DiagramEditor;

public class JVoiceDiagramEditor extends DiagramEditor {

	private TransactionalEditingDomain domain;

	public JVoiceDiagramEditor() {
		super();
	}

	public JVoiceDiagramEditor(TransactionalEditingDomain domain) {
		super();
		this.domain = domain;
	}

	@Override
	protected DiagramBehavior createDiagramBehavior() {
		return new JVoiceDiagramBehavior(this, domain);
	}
}
