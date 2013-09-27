package com.vectorsf.jvoice.diagram.core.editor;

import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;
import org.eclipse.graphiti.ui.editor.IDiagramContainerUI;

import com.vectorsf.jvoice.core.uri.VegaXMLURIHandlerImpl;

public class JVoiceDiagramBehavior extends DiagramBehavior {

	public JVoiceDiagramBehavior(IDiagramContainerUI diagramContainer) {
		super(diagramContainer);
	}

	@Override
	protected void editingDomainInitialized() {
		super.editingDomainInitialized();
		getResourceSet().getLoadOptions().put(XMLResource.OPTION_URI_HANDLER,
				new VegaXMLURIHandlerImpl());

	}
}
