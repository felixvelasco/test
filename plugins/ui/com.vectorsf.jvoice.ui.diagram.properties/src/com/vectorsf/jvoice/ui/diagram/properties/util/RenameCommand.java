package com.vectorsf.jvoice.ui.diagram.properties.filters;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;

import com.vectorsf.jvoice.model.operations.State;

public final class RenameCommand extends RecordingCommand {
	private final PictogramElement pe;
	private final State bimElement;
	private IFeatureProvider fp;
	private String newName;

	public RenameCommand(TransactionalEditingDomain domain,
			PictogramElement pe, State bimElement, String newName, IFeatureProvider fp) {
		super(domain);
		this.pe = pe;
		this.bimElement = bimElement;
		this.newName = newName;
		this.fp = fp;
	}

	protected void doExecute() {
		bimElement.setName(newName);
		fp.updateIfPossibleAndNeeded(new UpdateContext(pe));
	}
}