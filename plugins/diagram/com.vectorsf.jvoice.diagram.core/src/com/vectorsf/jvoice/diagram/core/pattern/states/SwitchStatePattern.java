package com.vectorsf.jvoice.diagram.core.pattern.states;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Image;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.FixPointAnchor;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.pattern.id.IdUpdateContext;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;

import com.vectorsf.jvoice.diagram.core.features.CoreImageProvider;
import com.vectorsf.jvoice.model.operations.Case;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.OperationsFactory;
import com.vectorsf.jvoice.model.operations.SwitchState;

public class SwitchStatePattern extends SpecialEventStatePattern implements ISelectionStatusValidator {
	private static final String SWITCH = "Switch";
	int cont = 0;

	@Override
	public Object[] create(ICreateContext context) {
		Flow flow = (Flow) getBusinessObjectForPictogramElement(getDiagram());
		SwitchState ss = OperationsFactory.eINSTANCE.createSwitchState();
		ss.setName(SWITCH);
		flow.getStates().add(ss);

		addGraphicalRepresentation(context, ss);

		return new Object[] { ss };
	}

	@Override
	public String getCreateName() {
		return SWITCH;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return mainBusinessObject instanceof SwitchState;
	}

	@Override
	public IStatus validate(Object[] selection) {
		if (selection.length > 0) {
			if (!(selection[0] instanceof Flow)) {
				return new Status(IStatus.ERROR, "com.vectorsf.jvoice.diagram.core", "Select a flow");
			} else {
				return Status.OK_STATUS;
			}
		} else {
			return new Status(IStatus.ERROR, "com.vectorsf.jvoice.diagram.core", "Select a flow");
		}
	}

	@Override
	public String getCreateImageId() {
		return CoreImageProvider.IMG_PALETTE_SWITCH;
	}

	@Override
	public String getCreateLargeImageId() {
		return CoreImageProvider.IMG_LARGE_PALETTE_SWITCH;
	}

	@Override
	protected String getStateImageId() {
		return CoreImageProvider.IMG_STATE_SWITCH;
	}

	@Override
	protected PictogramElement doAdd(IAddContext context) {
		SwitchState addedDomainObject = (SwitchState) context.getNewObject();
		Case caseDefault = OperationsFactory.eINSTANCE.createCase();

		// Se comprueba de que exista un estado default por si estamos copiando un switch.
		Boolean nohaydefault = false;
		EList<Case> listCase = addedDomainObject.getCase();
		for (Case cases : listCase) {
			if (cases.getEventName().equals("default")) {
				nohaydefault = true;
				break;
			}
		}
		if (!nohaydefault) {
			caseDefault.setEventName("default");
			addedDomainObject.getCase().add(caseDefault);
		}

		return super.doAdd(context);
	}

	@Override
	protected IReason updateNeeded(IdUpdateContext context, String id) {
		if (id.equals(ID_NAME_TEXT)) {
			// Obtenemos los nombres de los casos
			SwitchState state = (SwitchState) getBusinessObjectForPictogramElement(context.getRootPictogramElement());
			Set<String> caseNames = new HashSet<String>();
			for (Case c : state.getCase()) {
				caseNames.add(c.getEventName());
			}

			// Obtenemos los nombres de los anchors
			Set<String> anchorNames = new HashSet<String>();
			PictogramElement pe = context.getRootPictogramElement();
			for (Anchor anchor : ((AnchorContainer) pe).getAnchors()) {
				if (!(anchor instanceof FixPointAnchor)) {
					continue;
				}
				GraphicsAlgorithm ga = anchor.getGraphicsAlgorithm();
				if (ga instanceof Image) {
					anchorNames.add(((Image) ga).getId());
				} else {
					anchorNames.add(((Text) ga).getValue());
				}
			}

			// Si se modificann los Eventnames de los casos o se
			// añaden o se borran casos hay que actualizar el estado.
			if (!caseNames.equals(anchorNames)) {
				return Reason.createTrueReason();
			}
		}

		return super.updateNeeded(context, id);
	}

	// @Override
	// protected boolean update(IdUpdateContext context, String id) {
	// if (id.equals(ID_NAME_TEXT)) {
	// State ss = (State) getBusinessObjectForPictogramElement(context.getRootPictogramElement());
	// return false;
	// }
	//
	// return false;
	// }
}
