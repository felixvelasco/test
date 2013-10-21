package com.vectorsf.jvoice.ui.diagram.properties.editting;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.ConnectionDecorator;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.FreeFormConnection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.PictogramLink;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.ILinkService;
import org.eclipse.graphiti.services.IPeService;
import org.eclipse.jface.viewers.TableViewer;

import com.vectorsf.jvoice.model.operations.Case;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.SwitchState;
import com.vectorsf.jvoice.model.operations.Transition;

class RenameTransitionCommand extends RecordingCommand {
 	private final SwitchState switchState;
	private String eventName;
	private Case cas;
	private final TableViewer viewer;
	

	public RenameTransitionCommand(TransactionalEditingDomain domain,
			 SwitchState switchState,Case cas, String eventName,TableViewer viewer) {
		super(domain);
		this.switchState = switchState;
		this.cas = cas;
		this.eventName = eventName;
		this.viewer = viewer;
	}

	protected void doExecute() {
		String caseEventName =  cas.getEventName();
		cas.setEventName(eventName);
		viewer.update(cas, null);
		List<Transition> transitions = switchState.getOutgoingTransitions(); 
		
		for(Transition tran: transitions){
			if (tran.getEventName().equals(caseEventName)){


				Diagram diagram = (Diagram) tran.eResource().getContents().get(0);
				List<Connection> connections = diagram.getConnections();
				for(Connection con:connections){

					List<ConnectionDecorator> connDecorators = con.getConnectionDecorators();
					for(ConnectionDecorator connDecorator:connDecorators){

						if( connDecorator.getLink()!=null && connDecorator.getGraphicsAlgorithm() instanceof Text){
							List<EObject> bos = connDecorator.getLink().getBusinessObjects();
							for(EObject eo: bos){
								if (eo instanceof Case){
									Case ca=(Case) eo;
									if (ca.getEventName().equals(eventName)){
										Text text =(Text) connDecorator.getGraphicsAlgorithm();
										text.setValue(eventName);

									}
								}
							}
						}
					}


				}
				tran.setEventName(eventName);

			}
		}


	}
}