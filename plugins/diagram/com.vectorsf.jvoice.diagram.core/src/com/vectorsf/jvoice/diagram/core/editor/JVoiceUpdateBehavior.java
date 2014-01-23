package com.vectorsf.jvoice.diagram.core.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.IWorkspaceCommandStack;
import org.eclipse.graphiti.ui.editor.DefaultUpdateBehavior;

public class JVoiceUpdateBehavior extends DefaultUpdateBehavior {

	private JVoiceDiagramBehavior jvoiceDiagramBehavior;
	private TransactionalEditingDomain domain;

	public JVoiceUpdateBehavior(JVoiceDiagramBehavior diagramBehavior, TransactionalEditingDomain domain) {
		super(diagramBehavior);
		this.jvoiceDiagramBehavior = diagramBehavior;
		this.domain = domain;
	}

	@Override
	protected void handleChangedResources() {
		if (!diagramBehavior.getDiagramContainer().isDirty()) {
			reloadResources(getEditingDomain().getResourceSet().getResources());
		} else {
			// Let's reload everything but the diagram
			List<Resource> resources = new ArrayList<>(getEditingDomain().getResourceSet().getResources());
			resources.remove(0);
			reloadResources(resources);
		}
	}

	@Override
	protected void createEditingDomain() {
		if (domain == null) {
			super.createEditingDomain();
		} else {
			initializeEditingDomain(domain);
		}
	}

	protected void reloadResources(List<Resource> resources) {
		IUndoContext undoContext = ((IWorkspaceCommandStack) getEditingDomain().getCommandStack())
				.getDefaultUndoContext();
		getOperationHistory().dispose(undoContext, true, true, true);

		// Disable adapters temporarily.
		jvoiceDiagramBehavior.disableAdapters();

		try {
			// We unload our resources such that refreshEditorContent does a
			// complete diagram refresh.
			for (Resource resource : resources) {
				resource.unload();
			}
			diagramBehavior.refreshContent();
		} finally {
			// Re-enable adapters again
			jvoiceDiagramBehavior.enableAdapters();
		}
	}

	private IOperationHistory getOperationHistory() {
		IOperationHistory history = null;
		TransactionalEditingDomain domain = getEditingDomain();
		if (domain != null) {
			IWorkspaceCommandStack commandStack = (IWorkspaceCommandStack) domain.getCommandStack();
			if (commandStack != null) {
				history = commandStack.getOperationHistory();
			}
		}
		return history;
	}

}
