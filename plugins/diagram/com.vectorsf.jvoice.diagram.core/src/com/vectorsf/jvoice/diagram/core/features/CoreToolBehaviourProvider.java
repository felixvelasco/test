package com.vectorsf.jvoice.diagram.core.features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.IDirectEditingFeature;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.context.IDoubleClickContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.palette.IPaletteCompartmentEntry;
import org.eclipse.graphiti.tb.ConnectionSelectionInfoImpl;
import org.eclipse.graphiti.tb.ContextButtonEntry;
import org.eclipse.graphiti.tb.ContextEntryHelper;
import org.eclipse.graphiti.tb.ContextMenuEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IConnectionSelectionInfo;
import org.eclipse.graphiti.tb.IContextButtonEntry;
import org.eclipse.graphiti.tb.IContextButtonPadData;
import org.eclipse.graphiti.tb.IContextMenuEntry;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import com.vectorsf.jvoice.diagram.core.pattern.note.CreateRelationFromPad;
import com.vectorsf.jvoice.diagram.core.pattern.note.RelationPattern;
import com.vectorsf.jvoice.diagram.core.pattern.states.OpenEditorFeature;
import com.vectorsf.jvoice.diagram.core.pattern.transition.CreateTransitionFromPad;
import com.vectorsf.jvoice.diagram.core.pattern.transition.TransitionCallFlowPattern;
import com.vectorsf.jvoice.diagram.core.pattern.transition.TransitionMenuPattern;
import com.vectorsf.jvoice.diagram.core.pattern.transition.TransitionPattern;
import com.vectorsf.jvoice.diagram.core.pattern.transition.TransitionSwitchPattern;
import com.vectorsf.jvoice.model.operations.CallFlowState;
import com.vectorsf.jvoice.model.operations.Case;
import com.vectorsf.jvoice.model.operations.CustomState;
import com.vectorsf.jvoice.model.operations.FinalState;
import com.vectorsf.jvoice.model.operations.InputState;
import com.vectorsf.jvoice.model.operations.MenuState;
import com.vectorsf.jvoice.model.operations.Note;
import com.vectorsf.jvoice.model.operations.PromptState;
import com.vectorsf.jvoice.model.operations.RecordState;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.SwitchState;
import com.vectorsf.jvoice.model.operations.impl.NoteImpl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Output;
import com.vectorsf.jvoice.prompt.model.voiceDsl.Outputs;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;

public class CoreToolBehaviourProvider extends DefaultToolBehaviorProvider {

	public static final String PAD_CONTEXT_MENU_ENTRY = "padContextMenuEntry"; //$NON-NLS-1$
	public static final String PAD_CONTEXT_SUB_MENU_ENTRY = "padContextSubMenuEntry"; //$NON-NLS-1$
	public static final String CONTEXT_MENU_ENTRY = "contextMenuEntry"; //$NON-NLS-1$

	public CoreToolBehaviourProvider(IDiagramTypeProvider diagramTypeProvider) {
		super(diagramTypeProvider);
	}

	@Override
	public boolean isShowGuides() {
		return true;
	}

	@Override
	public IPaletteCompartmentEntry[] getPalette() {
		List<IPaletteCompartmentEntry> ret = new ArrayList<IPaletteCompartmentEntry>();

		IPaletteCompartmentEntry[] superCompartments = super.getPalette();

		Collections.addAll(ret, superCompartments);
		ret.remove(0); // Quitamos las conexiones

		return ret.toArray(new IPaletteCompartmentEntry[ret.size()]);
	}

	@Override
	public Object getToolTip(GraphicsAlgorithm ga) {
		if (ga instanceof Text) {
			return ((Text) ga).getValue();
		} else {
			return super.getToolTip(ga);
		}
	}

	@Override
	public IContextMenuEntry[] getContextMenu(ICustomContext context) {
		// create a sub-menu for all custom features
		ContextMenuEntry subMenu = new ContextMenuEntry(null, context);
		subMenu.setText(null);
		// display sub-menu hierarchical or flat
		subMenu.setSubmenu(true);

		// create a menu-entry in the sub-menu for each custom feature
		context.putProperty(CONTEXT_MENU_ENTRY, true);
		ICustomFeature[] customFeatures = getFeatureProvider().getCustomFeatures(context);
		for (int i = 0; i < customFeatures.length; i++) {
			ICustomFeature customFeature = customFeatures[i];
			if (customFeature.isAvailable(context)) {
				ContextMenuEntry menuEntry = new ContextMenuEntry(customFeature, context);
				subMenu.add(menuEntry);
			}
		}

		return new IContextMenuEntry[] { subMenu };

	}

	@Override
	public IConnectionSelectionInfo getSelectionInfoForConnection(Connection connection) {
		IColorConstant lineColor = new ColorConstant("191c26"); //$NON-NLS-1$
		IConnectionSelectionInfo si = new ConnectionSelectionInfoImpl();
		si.setColor(lineColor);
		si.setHoverColor(lineColor);
		si.setHoverColorParentSelected(lineColor);
		si.setLineStyle(connection.getGraphicsAlgorithm().getLineStyle());
		return si;
	}

	@Override
	protected void setGenericContextButtons(IContextButtonPadData data, PictogramElement pe, int identifiers) {
		data.getGenericContextButtons().clear();

		// update button
		if ((identifiers & CONTEXT_BUTTON_UPDATE) != 0) {
			IContextButtonEntry updateButton = ContextEntryHelper.createDefaultUpdateContextButton(
					getFeatureProvider(), pe);
			if (updateButton != null) {
				data.getGenericContextButtons().add(updateButton);
			}
		}

		// remove button
		// Se elimina el remove para que no se muestre en los elementos del
		// diagrama.

		// delete button
		if ((identifiers & CONTEXT_BUTTON_DELETE) != 0) {
			IContextButtonEntry deleteButton = ContextEntryHelper.createDefaultDeleteContextButton(
					getFeatureProvider(), pe);
			if (deleteButton != null) {
				data.getGenericContextButtons().add(deleteButton);
			}
		}
	}

	@Override
	public IContextButtonPadData getContextButtonPad(IPictogramElementContext context) {
		IContextButtonPadData data = super.getContextButtonPad(context);
		PictogramElement pe = context.getPictogramElement();
		Object bo = getFeatureProvider().getBusinessObjectForPictogramElement(pe);
		ContextButtonEntry button = new ContextButtonEntry(null, context);
		if (bo instanceof State) {
			State sta = (State) bo;
			if (!(sta instanceof FinalState)) {
				ICreateConnectionFeature feature = null;
				if (sta instanceof SwitchState) {
					SwitchState switchState = (SwitchState) sta;
					List<Case> cases = switchState.getCase();
					if (cases != null) {
						ContextButtonEntry menuButton = new ContextButtonEntry(null, context);
						menuButton.setText("Transition");

						for (Case cas : cases) {
							feature = new CreateTransitionFromPad(getFeatureProvider(), new TransitionSwitchPattern(
									cas, getFeatureProvider()));
							menuButton.setIconId(getImageFor(sta, feature));
							menuButton.addDragAndDropFeature(feature);
						}
						data.getDomainSpecificContextButtons().add(menuButton);
					}

				} else if (sta instanceof MenuState) {
					MenuState menuState = (MenuState) sta;
					List<Output> outputs = new ArrayList<Output>();
					VoiceDsl locution = menuState.getLocution();
					if (locution != null) {
						Outputs locutionOutputs = menuState.getLocution().getOutputs();
						if (locutionOutputs != null) {
							outputs = locutionOutputs.getOutput();
							ContextButtonEntry menuButton = new ContextButtonEntry(null, context);
							menuButton.setText("Transition");

							for (Output output : outputs) {
								feature = new CreateTransitionFromPad(getFeatureProvider(), new TransitionMenuPattern(
										output, getFeatureProvider()));
								menuButton.setIconId(getImageFor(sta, feature));
								menuButton.addDragAndDropFeature(feature);
							}
							data.getDomainSpecificContextButtons().add(menuButton);
						}
					}

				} else if (sta instanceof CallFlowState) {
					CallFlowState callFlowState = (CallFlowState) sta;
					List<State> states = callFlowState.getSubflow().getStates();

					if (states != null) {

						ContextButtonEntry menuButton = new ContextButtonEntry(null, context);
						menuButton.setText("Transition");

						for (State state : states) {
							if (state instanceof FinalState) {
								feature = new CreateTransitionFromPad(getFeatureProvider(),
										new TransitionCallFlowPattern(state, getFeatureProvider()));
								menuButton.setIconId(getImageFor(sta, feature));
								menuButton.addDragAndDropFeature(feature);
							}
						}
						if (menuButton.getIconId() != null) {
							data.getDomainSpecificContextButtons().add(menuButton);
						}
					}

				} else if (sta instanceof CustomState) {
					CustomState customState = (CustomState) sta;
					if (customState.getOutgoingTransitions().isEmpty()) {
						ContextButtonEntry menuButton = new ContextButtonEntry(null, context);
						menuButton.setText("Transition");
						feature = new CreateTransitionFromPad(getFeatureProvider(), new TransitionCallFlowPattern(
								customState, getFeatureProvider()));
						menuButton.setIconId(getImageFor(sta, feature));
						menuButton.addDragAndDropFeature(feature);
						data.getDomainSpecificContextButtons().add(menuButton);
					}
				} else {
					feature = new CreateTransitionFromPad(getFeatureProvider(), new TransitionPattern(
							getFeatureProvider()));
					button.setText(feature.getCreateName());
					button.setDescription(feature.getCreateDescription());
					button.setIconId(getImageFor(sta, feature));
					button.addDragAndDropFeature(feature);

					data.getDomainSpecificContextButtons().add(button);
				}

			}

		} else if (bo instanceof NoteImpl) {
			Note note = (Note) bo;
			ICreateConnectionFeature feature = null;
			feature = new CreateRelationFromPad(getFeatureProvider(), new RelationPattern(getFeatureProvider()));
			button.setText(feature.getCreateName());
			button.setDescription(feature.getCreateDescription());
			button.setIconId(feature.getCreateImageId());
			button.addDragAndDropFeature(feature);

			data.getDomainSpecificContextButtons().add(button);

		}

		return data;
	}

	private String getImageFor(State state, ICreateConnectionFeature feature) {

		return feature.getCreateImageId();
	}

	public IDirectEditingFeature getDirectEditingFeature(IDirectEditingContext context) {
		return null;
	}

	@Override
	public ICustomFeature getDoubleClickFeature(IDoubleClickContext context) {
		Object bo = getFeatureProvider().getBusinessObjectForPictogramElement(context.getInnerPictogramElement());

		if (bo instanceof CallFlowState || bo instanceof InputState || bo instanceof MenuState
				|| bo instanceof PromptState || bo instanceof CustomState || bo instanceof RecordState) {

			return new OpenEditorFeature(getFeatureProvider());
		}

		return super.getDoubleClickFeature(context);
	}
}
