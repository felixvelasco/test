package com.vectorsf.jvoice.diagram.core.features;

import java.util.*;

import org.eclipse.emf.common.util.*;
import org.eclipse.gef.SnapToGrid;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.*;
import org.eclipse.graphiti.features.context.*;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.algorithms.*;
import org.eclipse.graphiti.mm.pictograms.*;
import org.eclipse.graphiti.palette.IPaletteCompartmentEntry;
import org.eclipse.graphiti.platform.IPlatformImageConstants;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.tb.*;
import org.eclipse.graphiti.util.*;

import com.vectorsf.jvoice.diagram.core.features.editing.FinalStateHangToggleFeature;
import com.vectorsf.jvoice.diagram.core.pattern.note.*;
import com.vectorsf.jvoice.diagram.core.pattern.transition.*;
import com.vectorsf.jvoice.model.operations.*;
import com.vectorsf.jvoice.model.operations.impl.*;
import com.vectorsf.jvoice.prompt.model.voiceDsl.*;

public class CoreToolBehaviourProvider extends DefaultToolBehaviorProvider {

    public static final String PAD_CONTEXT_MENU_ENTRY = "padContextMenuEntry"; //$NON-NLS-1$
    public static final String PAD_CONTEXT_SUB_MENU_ENTRY = "padContextSubMenuEntry"; //$NON-NLS-1$
    public static final String CONTEXT_MENU_ENTRY = "contextMenuEntry"; //$NON-NLS-1$
    private Diagnostic diagnostic;

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
	    String tooltip = Graphiti.getPeService().getPropertyValue(
		    ga.getPictogramElement(), "TOOLTIP");
	    if (tooltip != null)
		return tooltip;
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
	ICustomFeature[] customFeatures = getFeatureProvider()
		.getCustomFeatures(context);
	for (int i = 0; i < customFeatures.length; i++) {
	    ICustomFeature customFeature = customFeatures[i];
	    if (customFeature.isAvailable(context)) {
		ContextMenuEntry menuEntry = new ContextMenuEntry(
			customFeature, context);
		subMenu.add(menuEntry);
	    }
	}

	return new IContextMenuEntry[] { subMenu };

    }

    @Override
    public IConnectionSelectionInfo getSelectionInfoForConnection(
	    Connection connection) {
	IColorConstant lineColor = new ColorConstant("191c26"); //$NON-NLS-1$
	IConnectionSelectionInfo si = new ConnectionSelectionInfoImpl();
	si.setColor(lineColor);
	si.setHoverColor(lineColor);
	si.setHoverColorParentSelected(lineColor);
	si.setLineStyle(connection.getGraphicsAlgorithm().getLineStyle());
	return si;
    }

    @Override
    protected void setGenericContextButtons(IContextButtonPadData data,
	    PictogramElement pe, int identifiers) {
	data.getGenericContextButtons().clear();

	// delete button
	if ((identifiers & CONTEXT_BUTTON_DELETE) != 0) {
	    IContextButtonEntry deleteButton = ContextEntryHelper
		    .createDefaultDeleteContextButton(getFeatureProvider(), pe);
	    if (deleteButton != null) {
		data.getGenericContextButtons().add(deleteButton);
	    }
	}
    }

    @Override
    public IContextButtonPadData getContextButtonPad(
	    IPictogramElementContext context) {
	IContextButtonPadData data = super.getContextButtonPad(context);
	PictogramElement pe = context.getPictogramElement();
	Object bo = getFeatureProvider().getBusinessObjectForPictogramElement(
		pe);
	ContextButtonEntry button = new ContextButtonEntry(null, context);
	if (bo instanceof State) {
	    State sta = (State) bo;

	    ICreateConnectionFeature feature = null;

	    if (sta instanceof SwitchState) {
		SwitchState switchState = (SwitchState) sta;
		List<Case> cases = switchState.getCase();
		if (cases != null) {
		    ContextButtonEntry menuButton = new ContextButtonEntry(
			    null, context);
		    menuButton.setText("Transition");

		    for (Case cas : cases) {
			feature = new CreateTransitionFromPad(
				getFeatureProvider(),
				new TransitionSwitchPattern(cas,
					getFeatureProvider()));
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
		    Outputs locutionOutputs = menuState.getLocution()
			    .getOutputs();
		    if (locutionOutputs != null) {
			outputs = locutionOutputs.getOutput();
			ContextButtonEntry menuButton = new ContextButtonEntry(
				null, context);
			menuButton.setText("Transition");

			for (Output output : outputs) {
			    feature = new CreateTransitionFromPad(
				    getFeatureProvider(),
				    new TransitionMenuPattern(output,
					    getFeatureProvider()));
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

		    ContextButtonEntry menuButton = new ContextButtonEntry(
			    null, context);
		    menuButton.setText("Transition");

		    for (State state : states) {
			if (state instanceof FinalState) {
			    feature = new CreateTransitionFromPad(
				    getFeatureProvider(),
				    new TransitionCallFlowPattern(state,
					    getFeatureProvider()));
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
		    ContextButtonEntry menuButton = new ContextButtonEntry(
			    null, context);
		    menuButton.setText("Transition");
		    feature = new CreateTransitionFromPad(getFeatureProvider(),
			    new TransitionCallFlowPattern(customState,
				    getFeatureProvider()));
		    menuButton.setIconId(getImageFor(sta, feature));
		    menuButton.addDragAndDropFeature(feature);
		    data.getDomainSpecificContextButtons().add(menuButton);
		}
	    } else if (sta instanceof InitialState) {
		return null;
	    } else if (!(sta instanceof FinalState)) {
		feature = new CreateTransitionFromPad(getFeatureProvider(),
			new TransitionPattern(getFeatureProvider()));
		button.setText(feature.getCreateName());
		button.setDescription(feature.getCreateDescription());
		button.setIconId(getImageFor(sta, feature));
		button.addDragAndDropFeature(feature);

		data.getDomainSpecificContextButtons().add(button);
	    }

	} else if (bo instanceof Note) {
	    Note note = (Note) bo;
	    ICreateConnectionFeature feature = null;
	    feature = new CreateRelationFromPad(getFeatureProvider(),
		    new RelationPattern(getFeatureProvider()));
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

    public IDirectEditingFeature getDirectEditingFeature(
	    IDirectEditingContext context) {
	return null;
    }

    @Override
    public ICustomFeature getDoubleClickFeature(IDoubleClickContext context) {
	Object bo = getFeatureProvider().getBusinessObjectForPictogramElement(
		context.getInnerPictogramElement());

	// Al hacer doble click en el icono del menú sacamos el diálogo de
	// eventos
	GraphicsAlgorithm ga = context.getInnerGraphicsAlgorithm();
	if (ga instanceof Image
		&& ((Image) ga).getId().equals("icon_deco_dropdown")
		&& (bo instanceof CallFlowStateImpl
			|| bo instanceof MenuStateImpl || bo instanceof SwitchStateImpl)) {
	    PictogramElement pe = context.getInnerPictogramElement();
	    return new AddMoreEventFeature(getFeatureProvider());
	}

	if (bo instanceof CallFlowState || bo instanceof LocutionState
		|| bo instanceof CustomState || bo instanceof CallState) {

	    return new OpenEditorFeature(getFeatureProvider());
	}

	return super.getDoubleClickFeature(context);
    }

    @Override
    public IDecorator[] getDecorators(PictogramElement pe) {
	Object bo = getFeatureProvider().getBusinessObjectForPictogramElement(
		pe);

	Diagnostic diagnostic = getDiagnostic(bo);
	if (diagnostic.getSeverity() == Diagnostic.ERROR) {
	    ImageDecorator imageDecorator = new ImageDecorator(
		    IPlatformImageConstants.IMG_ECLIPSE_ERROR_TSK);
	    imageDecorator.setMessage(diagnostic.getMessage());
	    return new IDecorator[] { imageDecorator };
	} else if (diagnostic.getSeverity() == Diagnostic.WARNING) {
	    ImageDecorator imageDecorator = new ImageDecorator(
		    IPlatformImageConstants.IMG_ECLIPSE_WARNING_TSK);
	    imageDecorator.setMessage(diagnostic.getMessage());
	    return new IDecorator[] { imageDecorator };
	} else {
	    return super.getDecorators(pe);
	}
    }

    private Diagnostic getDiagnostic(Object bo) {
	Diagnostic ret = new BasicDiagnostic();
	if (diagnostic != null) {
	    for (Diagnostic diag : diagnostic.getChildren()) {
		if (diag.getData().contains(bo)) {
		    if (diag.getSeverity() > ret.getSeverity()) {
			ret = diag;
		    }
		}
	    }
	}
	return ret;
    }

    public void setDiagnostic(Diagnostic diagnostic) {
	this.diagnostic = diagnostic;
    }

    @Override
    public ICustomFeature getSingleClickFeature(ISingleClickContext context) {
	if (context.getInnerGraphicsAlgorithm() instanceof Image) {
	    PictogramElement pe = context.getInnerPictogramElement();
	    Object bo = getFeatureProvider()
		    .getBusinessObjectForPictogramElement(pe);

	    if (bo instanceof FinalState) {
		return new FinalStateHangToggleFeature(getFeatureProvider());
	    }
	}

	return super.getSingleClickFeature(context);
    }
}
