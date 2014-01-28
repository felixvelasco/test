package com.vectorsf.jvoice.diagram.core.pattern.states;

import java.util.*;

import org.eclipse.core.runtime.*;
import org.eclipse.emf.common.util.*;
import org.eclipse.graphiti.features.context.*;
import org.eclipse.graphiti.mm.algorithms.*;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.*;
import org.eclipse.graphiti.pattern.id.IdLayoutContext;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;

import com.vectorsf.jvoice.diagram.core.features.CoreImageProvider;
import com.vectorsf.jvoice.model.operations.*;

public class SwitchStatePattern extends SpecialEventStatePattern implements ISelectionStatusValidator
{
	private static final String SWITCH = "Switch";
	int cont = 0;

	@Override
	public Object[] create(ICreateContext context)
	{
		Flow flow = (Flow) getBusinessObjectForPictogramElement(getDiagram());
		SwitchState ss = OperationsFactory.eINSTANCE.createSwitchState();
		ss.setName(SWITCH);
		flow.getStates().add(ss);

		addGraphicalRepresentation(context, ss);

		return new Object[] { ss };
	}

	@Override
	public String getCreateName()
	{
		return SWITCH;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject)
	{
		return mainBusinessObject instanceof SwitchState;
	}

	@Override
	public IStatus validate(Object[] selection)
	{
		if (selection.length > 0)
		{
			if (!(selection[0] instanceof Flow))
			{
				return new Status(IStatus.ERROR, "com.vectorsf.jvoice.diagram.core", "Select a flow");
			}
			else
			{
				return Status.OK_STATUS;
			}
		}
		else
		{
			return new Status(IStatus.ERROR, "com.vectorsf.jvoice.diagram.core", "Select a flow");
		}
	}

	@Override
	public String getCreateImageId()
	{
		return CoreImageProvider.IMG_PALETTE_SWITCH;
	}

	@Override
	public String getCreateLargeImageId()
	{
		return CoreImageProvider.IMG_LARGE_PALETTE_SWITCH;
	}

	@Override
	protected String getStateImageId()
	{
		return CoreImageProvider.IMG_STATE_SWITCH;
	}

	@Override
	protected PictogramElement doAdd(IAddContext context)
	{
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

}
