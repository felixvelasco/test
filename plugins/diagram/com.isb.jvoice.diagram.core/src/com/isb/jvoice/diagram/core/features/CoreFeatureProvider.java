package com.isb.jvoice.diagram.core.features;


import java.util.ArrayList;
import java.util.List;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.IAddFeature;
import org.eclipse.graphiti.features.ICopyFeature;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.ICreateFeature;
import org.eclipse.graphiti.features.IDeleteFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.IFeature;
import org.eclipse.graphiti.features.ILayoutFeature;
import org.eclipse.graphiti.features.IMoveAnchorFeature;
import org.eclipse.graphiti.features.IMoveShapeFeature;
import org.eclipse.graphiti.features.IPasteFeature;
import org.eclipse.graphiti.features.IReconnectionFeature;
import org.eclipse.graphiti.features.IRemoveFeature;
import org.eclipse.graphiti.features.IResizeShapeFeature;
import org.eclipse.graphiti.features.IUpdateFeature;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICopyContext;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.ILayoutContext;
import org.eclipse.graphiti.features.context.IMoveAnchorContext;
import org.eclipse.graphiti.features.context.IMoveShapeContext;
import org.eclipse.graphiti.features.context.IPasteContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.context.IReconnectionContext;
import org.eclipse.graphiti.features.context.IRemoveContext;
import org.eclipse.graphiti.features.context.IResizeShapeContext;
import org.eclipse.graphiti.features.context.IUpdateContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.features.DefaultFeatureProvider;

import com.isb.jvoice.diagram.core.features.editing.CreateConditionalFeature;
import com.isb.jvoice.diagram.core.features.editing.CreateEndFeature;
import com.isb.jvoice.diagram.core.features.editing.CreateInitialFeature;
import com.isb.jvoice.diagram.core.features.editing.CreateSubFlowFeature;





public class CoreFeatureProvider extends DefaultFeatureProvider{


	public CoreFeatureProvider(IDiagramTypeProvider dtp) 
	{
		super(dtp);
	}
	
	@Override
	public IAddFeature getAddFeature(IAddContext context) 
	{

		return super.getAddFeature(context);
	}
	
	@Override
	public ICopyFeature getCopyFeature(ICopyContext context) {
		return null;
	}
	
	@Override
	public IPasteFeature getPasteFeature(IPasteContext context) {
		return null;
	}
	
	@Override
	public ICreateFeature[] getCreateFeatures() 
	{
		return new ICreateFeature[] {};
	}
	
	@Override
	public ICreateConnectionFeature[] getCreateConnectionFeatures() 
	{
		return new ICreateConnectionFeature[] {};
	}
	
	@Override
	public IDirectEditingFeature getDirectEditingFeature(IDirectEditingContext context) 
	{
		Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());
		return null;
	}
	
	@Override
	public IUpdateFeature getUpdateFeature(IUpdateContext context) 
	{
		PictogramElement pictogramElement = context.getPictogramElement();
		
		return null;
	}
	
	@Override
	public IResizeShapeFeature getResizeShapeFeature(IResizeShapeContext context) {
		return null;
	}
	
	@Override
	public IFeature[] getDragAndDropFeatures(IPictogramElementContext context) {
		return null;
	}
	
	@Override
	public IMoveAnchorFeature getMoveAnchorFeature(IMoveAnchorContext context) {
		return null;
	}
		
	  @Override
	  public ICustomFeature[] getCustomFeatures(ICustomContext context) 
	  {
		  List<ICustomFeature> retList = new ArrayList<ICustomFeature>();
		  retList.add (new CreateConditionalFeature(this));
		  retList.add (new CreateEndFeature(this));
		  retList.add (new CreateInitialFeature(this));
		  retList.add (new CreateSubFlowFeature(this));

		  return retList.toArray(new ICustomFeature[retList.size()]);
	  }

	@Override
	public IRemoveFeature getRemoveFeature(IRemoveContext context) {
		return null;
	}
	
	@Override
	public IDeleteFeature getDeleteFeature(IDeleteContext context) {
		Object bo = getBusinessObjectForPictogramElement(context.getPictogramElement());

		return null;
	}
	
	@Override
	public IReconnectionFeature getReconnectionFeature(IReconnectionContext context) 
	{
		return null;
	}
	
	@Override
	public IMoveShapeFeature getMoveShapeFeature(IMoveShapeContext context) 
	{
		return null;
	}
	
	@Override
	public ILayoutFeature getLayoutFeature(ILayoutContext context) {

		return super.getLayoutFeature(context);
	}

}
