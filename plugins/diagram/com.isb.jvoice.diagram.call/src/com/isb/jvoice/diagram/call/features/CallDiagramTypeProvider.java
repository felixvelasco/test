package com.isb.jvoice.diagram.call.features;

import org.eclipse.graphiti.dt.AbstractDiagramTypeProvider;
import org.eclipse.graphiti.tb.IToolBehaviorProvider;


public class CallDiagramTypeProvider extends AbstractDiagramTypeProvider
{

	public static final String IVR_DIAGRAM_TYPE_PROVIDER_ID = "jvoice.ivr.features"; //$NON-NLS-1$

	private IToolBehaviorProvider toolBehaviorProvider;
	
	public CallDiagramTypeProvider() 
	{
		super();
		setFeatureProvider(new CallFeatureProvider(this));
	}
	
    @Override

    public IToolBehaviorProvider[] getAvailableToolBehaviorProviders() 
    {

        if (toolBehaviorProvider == null) {

        	toolBehaviorProvider =

                new CallToolBehaviourProvider(this);

        }
        
        return new IToolBehaviorProvider[] {toolBehaviorProvider};

    }
    
}
