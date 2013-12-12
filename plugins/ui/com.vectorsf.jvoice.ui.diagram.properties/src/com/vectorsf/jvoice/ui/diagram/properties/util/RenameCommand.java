package com.vectorsf.jvoice.ui.diagram.properties.util;

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
	private String newValue;

	public RenameCommand(TransactionalEditingDomain domain, PictogramElement pe, State bimElement, String newValue,
			IFeatureProvider fp) {
		super(domain);
		this.pe = pe;
		this.bimElement = bimElement;
		this.newValue = newValue;
		this.fp = fp;
	}

	@Override
	protected void doExecute() {

		bimElement.setName(newValue);

		fp.updateIfPossibleAndNeeded(new UpdateContext(pe));
	}
}