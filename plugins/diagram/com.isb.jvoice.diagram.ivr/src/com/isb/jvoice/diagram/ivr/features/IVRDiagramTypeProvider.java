package com.isb.jvoice.diagram.ivr.features;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;

import com.isb.jvoice.diagram.ivr.features.IVRFeatureProvider;
import com.isb.jvoice.diagram.ivr.features.IVRToolBehaviourProvider;


public class IVRDiagramTypeProvider extends AbstractDiagramTypeProvider
{

	public static final String IVR_DIAGRAM_TYPE_PROVIDER_ID = "jvoice.ivr.features"; //$NON-NLS-1$

	private IToolBehaviorProvider toolBehaviorProvider;
	
	public IVRDiagramTypeProvider() 
	{
		super();
		setFeatureProvider(new IVRFeatureProvider(this));
	}
	
    @Override

    public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() 
    {

        if (toolBehaviorProvider == null) {

        	toolBehaviorProvider =

                new IVRToolBehaviourProvider(this);

        }
        
        return new IToolBehaviorProvider[] {toolBehaviorProvider};

    }
    
}
