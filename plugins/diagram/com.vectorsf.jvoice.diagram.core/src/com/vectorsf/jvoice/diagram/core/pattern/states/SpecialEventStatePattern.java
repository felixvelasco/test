package com.vectorsf.jvoice.diagram.core.pattern.states;

import java.util.*;

import org.eclipse.emf.common.util.*;
import org.eclipse.graphiti.mm.algorithms.*;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.*;
import org.eclipse.graphiti.pattern.id.IdLayoutContext;
import org.eclipse.graphiti.services.Graphiti;

import com.vectorsf.jvoice.diagram.core.features.CoreImageProvider;
import com.vectorsf.jvoice.model.operations.*;

public class SpecialEventStatePattern extends SimpleStatePattern 
{
	public int cont;


	/**
	 * Sobreescribe el método porque los eventos del estado Switch son los eventos de los Cases asociados. 
	 */
	@Override
	public EList<String> getFireableEvents(State state)
	{
		EList<String> caseEventNames = new BasicEList<String>();
		for (Case c : ((SwitchState) state).getCase())
		{
			caseEventNames.add(c.getEventName());
		}
		
		return caseEventNames;
	}

	@Override
	protected boolean layout(IdLayoutContext context, String id)
	{
		boolean changesDone = false;

		GraphicsAlgorithm gaOuter = context.getRootPictogramElement().getGraphicsAlgorithm();
		if (id.equals(ID_MAIN_FIGURE))
		{
			updateFireableEvents(context);
			changesDone = true;
		}

		// Cambiamos el tamaño del rectángulo superior y la posición del icono
		// del menú
		if (id.equals(ID_TOP_RECTANGLE))
		{
			State state = (State) getBusinessObjectForPictogramElement(context.getRootPictogramElement());
			if (getStateWith(state) > MAIN_RECTANGLE_WIDTH)
			{
				changeTopRectangleWidth(context, getStateWith(state));
			}
			else
			{
				changeTopRectangleWidth(context, MAIN_RECTANGLE_WIDTH);
			}
			changesDone = true;
		}

		return changesDone;
	}
	
	public int getStateWith(State state)
	{
		int numLetters = 0;
		for (String string : getFireableEvents(state))
		{
			numLetters += string.length();
		}
		
		return numLetters * 7;
	}
	
	public Point getAnchorLocation(int point, PictogramElement pe, Anchor anchor)
	{
		int x = point * 26;

		GraphicsAlgorithm ga = anchor.getGraphicsAlgorithm();
		if (ga instanceof Text)
		{
			x = cont;
			cont += ((Text) ga).getValue().length() * 7;
		}

		int y = pe.getGraphicsAlgorithm().getHeight() - 16 - 10;

		return Graphiti.getGaCreateService().createPoint(x, y);
	}
	
	/**
	 * Actualiza la barra de eventos que puede disparar el estado.
	 */
	public void updateFireableEvents(IdLayoutContext context)
	{
		GraphicsAlgorithm ga = context.getGraphicsAlgorithm();

		State state = (State) getBusinessObjectForPictogramElement(ga.getPictogramElement());

		// Ajustamos el tamaño del estado
		if (getStateWith(state) > MAIN_RECTANGLE_WIDTH)
		{
			Graphiti.getGaService().setLocationAndSize(ga, ga.getX(), ga.getY(),
				getStateWith(state), ga.getHeight());
		}
		else
		{
			Graphiti.getGaService().setLocationAndSize(ga, ga.getX(), ga.getY(), MAIN_RECTANGLE_WIDTH, ga.getHeight());
		}

		// Borra los anchors del tipo FixPointAnchor que no tienen transiciones
		// de salida
		List<Anchor> anchorsToDelete = new ArrayList<Anchor>();
		List<String> existingAnchors = new ArrayList<String>();
		PictogramElement rootPe = context.getRootPictogramElement();

		for (Anchor anchor : ((AnchorContainer) rootPe).getAnchors())
		{
			if (!(anchor instanceof FixPointAnchor))
				continue;
			if (anchor.getOutgoingConnections().isEmpty())
				anchorsToDelete.add(anchor);
			else
				existingAnchors.add(((Image) anchor.getGraphicsAlgorithm()).getId());
		}

		for (Anchor anchor : anchorsToDelete)
		{
			Graphiti.getPeService().deletePictogramElement(anchor);
		}

		// Creamos el anchor y su imagen asociada
		for (String event : getFireableEvents(state))
		{
			// No creamos los anchors que ya existen
			if (existingAnchors.contains(event))
			{
				continue;
			}

			FixPointAnchor anchor = Graphiti.getPeCreateService().createFixPointAnchor((AnchorContainer) rootPe);

			// Creamos la imagen o el texto del evento dentro del anchor
			Text text = gaService.createText(anchor, event);
			gaService.setLocationAndSize(text, 0, 0, event.length() * 7, IMAGE_SIZE);
			Graphiti.getPeService().setPropertyValue(anchor, "TOOLTIP", event);
		}

		// Reordenamos los anchors
		cont = 0;
		for (Anchor anchor : ((AnchorContainer) rootPe).getAnchors())
		{
			if (anchor instanceof FixPointAnchor)
			{
				((FixPointAnchor) anchor).setLocation(getAnchorLocation(cont++, rootPe, anchor));
			}
		}
	}
	
	@Override
	protected String getStateImageId()
	{
		return "";
	}
}
