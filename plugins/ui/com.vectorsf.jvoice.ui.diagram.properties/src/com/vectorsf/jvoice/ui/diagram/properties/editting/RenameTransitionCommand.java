package com.vectorsf.jvoice.ui.diagram.properties.editting;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.*;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.impl.UpdateContext;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.*;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.jface.viewers.TableViewer;

import com.vectorsf.jvoice.model.operations.*;

class RenameTransitionCommand extends RecordingCommand {
	private final SwitchState switchState;
	private String eventName;
	private Case cas;
	private final TableViewer viewer;
	private IFeatureProvider fp;

	public RenameTransitionCommand(TransactionalEditingDomain domain, SwitchState switchState, Case cas,
			String eventName, TableViewer viewer, IFeatureProvider fp) {
		super(domain);
		this.switchState = switchState;
		this.cas = cas;
		this.eventName = eventName;
		this.viewer = viewer;
		this.fp = fp;
	}

	@Override
	protected void doExecute() {
		String caseEventName = cas.getEventName();
		cas.setEventName(eventName);
		viewer.update(cas, null);
		List<Transition> transitions = switchState.getOutgoingTransitions();

		for (Transition tran : transitions) {
			if (tran.getEventName().equals(caseEventName)) {

				Diagram diagram = (Diagram) tran.eResource().getContents().get(0);
				List<Connection> connections = diagram.getConnections();
				for (Connection con : connections) {

					List<ConnectionDecorator> connDecorators = con.getConnectionDecorators();
					for (ConnectionDecorator connDecorator : connDecorators) {

						if (connDecorator.getLink() != null && connDecorator.getGraphicsAlgorithm() instanceof Text) {
							List<EObject> bos = connDecorator.getLink().getBusinessObjects();
							for (EObject eo : bos) {
								if (eo instanceof Case) {
									Case ca = (Case) eo;
									if (ca.getEventName().equals(eventName)) {
										Text text = (Text) connDecorator.getGraphicsAlgorithm();
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

		Diagram diagram = (Diagram) cas.eResource().getContents().get(0);
		List<PictogramElement> pictogramElements = Graphiti.getLinkService().getPictogramElements(diagram, switchState);
		EList<Shape> children = diagram.getChildren();
		for (PictogramElement pictogramElement : children) {
			System.out.println("==>" + pictogramElement);
		}
		fp.updateIfPossibleAndNeeded(new UpdateContext(pictogramElements.get(0)));

	}
}