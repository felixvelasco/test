package com.vectorsf.jvoice.diagram.core.features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.palette.IPaletteCompartmentEntry;
import org.eclipse.graphiti.tb.ConnectionSelectionInfoImpl;
import org.eclipse.graphiti.tb.ContextButtonEntry;
import org.eclipse.graphiti.tb.ContextMenuEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IConnectionSelectionInfo;
import org.eclipse.graphiti.tb.IContextButtonPadData;
import org.eclipse.graphiti.tb.IContextMenuEntry;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import com.vectorsf.jvoice.diagram.core.pattern.CreateTransitionFromPad;
import com.vectorsf.jvoice.diagram.core.pattern.TransitionPattern;
import com.vectorsf.jvoice.model.operations.FinalState;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.SwitchState;

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
		subMenu.setSubmenu(false);

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
	public IContextButtonPadData getContextButtonPad(
			IPictogramElementContext context) {
		IContextButtonPadData data = super.getContextButtonPad(context);
		PictogramElement pe = context.getPictogramElement();
		Object bo = getFeatureProvider().getBusinessObjectForPictogramElement(
				pe);

		State sta = (State) bo;
		if (!(sta instanceof FinalState)) {
			ContextButtonEntry button = new ContextButtonEntry(null, context);
			ICreateConnectionFeature feature = null;
			if (sta instanceof SwitchState) {

				feature = new CreateTransitionFromPad(getFeatureProvider(),
						new TransitionSwitchPattern(getFeatureProvider()));
			} else {
				feature = new CreateTransitionFromPad(getFeatureProvider(),
						new TransitionPattern(getFeatureProvider()));
			}
			button.setText(feature.getCreateName());
			button.setDescription(feature.getCreateDescription());
			button.setIconId(getImageFor(sta, feature));
			button.addDragAndDropFeature(feature);

			data.getDomainSpecificContextButtons().add(button);
		}

		return data;
	}

	private String getImageFor(State state, ICreateConnectionFeature feature) {

		return feature.getCreateImageId();
	}
}
