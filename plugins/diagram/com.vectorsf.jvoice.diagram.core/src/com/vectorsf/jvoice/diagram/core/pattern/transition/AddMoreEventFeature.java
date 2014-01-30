package com.vectorsf.jvoice.diagram.core.pattern.transition;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.AnchorContainer;
import org.eclipse.graphiti.mm.pictograms.FixPointAnchor;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.PlatformUI;

import com.vectorsf.jvoice.diagram.core.features.CoreImageProvider;
import com.vectorsf.jvoice.diagram.core.pattern.transition.EventsDialog.ButtonInfo;
import com.vectorsf.jvoice.model.operations.State;

public class AddMoreEventFeature extends AbstractCustomFeature {

	private boolean hasDoneChanges = true;

	public AddMoreEventFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		PictogramElement pe = context.getPictogramElements()[0];
		Object bo = getBusinessObjectForPictogramElement(pe);

		return true;
	}

	@Override
	public String getName() {
		return Messages.AddMoreEventFeature_moreEvents;
	}

	@Override
	public String getDescription() {
		return Messages.AddMoreEventFeature_dialogTitle;
	}

	@Override
	public String getImageId() {
		return CoreImageProvider.IMG_MORE_EVENTS_DIALOG;
	}

	@Override
	public void execute(ICustomContext context) {
		PictogramElement pe = context.getPictogramElements()[0];
		Object bo = getBusinessObjectForPictogramElement(pe);

		List<ButtonInfo> stateEvents = new ArrayList<ButtonInfo>();

		if (!(bo instanceof State)) {
			return;
		}

		State state = (State) bo;
		EList<String> events = state.getEvents();

		// Creamos los botones del diálogo
		for (String event : events) {
			// Como el icono a mostrar en el dialogo siempre ser� el asociado al "on",
			// el imageId es el evento m�s el sufijo de on.
			Image image = GraphitiUi.getImageService().getImageForId(
					getDiagramBehavior().getDiagramContainer().getDiagramTypeProvider().getProviderId(),
					event + CoreImageProvider.IMG_EVENT_ON_EXT);

			stateEvents.add(new ButtonInfo(event, image, state.getFireableEvents().contains(event), !isEventUsed(pe,
					event)));
		}

		EventsDialog dialog = new EventsDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				Messages.AddMoreEventFeature_newEvent, stateEvents);
		if (dialog.open() == IDialogConstants.CANCEL_ID) {
			hasDoneChanges = false;
			return;
		}

		String[] values = dialog.getValues();
		state.getFireableEvents().clear();
		for (String event : values) {
			state.getFireableEvents().add(event);
		}

		updatePictogramElement(pe);

	}

	private boolean isEventUsed(PictogramElement pe, String eventName) {
		for (Anchor anchor : ((AnchorContainer) pe).getAnchors()) {
			if (!(anchor instanceof FixPointAnchor)) {
				continue;
			}

			GraphicsAlgorithm ga = anchor.getGraphicsAlgorithm();
			String anchorName = "";
			if (ga instanceof Text) {
				anchorName = ((Text) ga).getValue();
			} else {
				anchorName = ((org.eclipse.graphiti.mm.algorithms.Image) ga).getId();
			}
			if (anchorName.equals(eventName) && !anchor.getOutgoingConnections().isEmpty()) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean hasDoneChanges() {
		return hasDoneChanges;
	}

}
