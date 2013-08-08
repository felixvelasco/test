package com.isb.jvoice.diagram.ivr.features.editing;

import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;



public class CreateInputFeature extends AbstractCustomFeature {


	public CreateInputFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canExecute(ICustomContext context) 
	{
		return true;
	}

	@Override
	public void execute(ICustomContext context) {
	}

	@Override
	public String getName() {
		return "CreateViewFeature";
	}

	@Override
	public boolean hasDoneChanges() {
		return false;
	}
}
