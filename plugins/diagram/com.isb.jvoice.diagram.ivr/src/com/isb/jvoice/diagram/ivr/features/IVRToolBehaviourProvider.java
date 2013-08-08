package com.isb.jvoice.diagram.ivr.features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDoubleClickContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.palette.IPaletteCompartmentEntry;
import org.eclipse.graphiti.tb.ContextMenuEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IContextMenuEntry;
import org.eclipse.graphiti.tb.IDecorator;
import org.eclipse.graphiti.tb.ISelectionInfo;
import org.eclipse.graphiti.tb.SelectionInfoImpl;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

public class IVRToolBehaviourProvider extends DefaultToolBehaviorProvider
{

	public static final String PAD_CONTEXT_MENU_ENTRY = "padContextMenuEntry"; //$NON-NLS-1$
	public static final String PAD_CONTEXT_SUB_MENU_ENTRY = "padContextSubMenuEntry"; //$NON-NLS-1$
	public static final String CONTEXT_MENU_ENTRY = "contextMenuEntry"; //$NON-NLS-1$
	
	public IVRToolBehaviourProvider(IDiagramTypeProvider diagramTypeProvider) {
		super(diagramTypeProvider);
	}
	@Override
	public boolean isShowGuides() {
		return true;
	}
	
	
	@Override
	public IPaletteCompartmentEntry[] getPalette() 
	{
		List<IPaletteCompartmentEntry> ret = new ArrayList<IPaletteCompartmentEntry>();

		IPaletteCompartmentEntry[] superCompartments = super.getPalette();

		Collections.addAll(ret, superCompartments);
		ret.remove(0); // Quitamos las conexiones

		return ret.toArray(new IPaletteCompartmentEntry[ret.size()]);
	}
	
	@Override
	public ICustomFeature getDoubleClickFeature(IDoubleClickContext context) 
	{
		PictogramElement pe = context.getInnerPictogramElement();
		Object bo = getFeatureProvider().getBusinessObjectForPictogramElement(pe);

		return super.getDoubleClickFeature(context);
	}



	@Override
	public String getToolTip(GraphicsAlgorithm ga) {
		return ((Text) ga).getValue();
	}
	
	@Override
	public IContextMenuEntry[] getContextMenu(ICustomContext context) {
		// create a sub-menu for all custom features
		ContextMenuEntry subMenu = new ContextMenuEntry(null, context);
		subMenu.setText(null); //$NON-NLS-1$
		// display sub-menu hierarchical or flat
		subMenu.setSubmenu(false);

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

	public IDecorator[] getDecorators(PictogramElement pe) {
		return super.getDecorators(pe);
	}
	
	@Override
	public ISelectionInfo getSelectionInfoForConnection(Connection connection) {
		IColorConstant lineColor = new ColorConstant("191c26"); //$NON-NLS-1$
		ISelectionInfo si = new SelectionInfoImpl(lineColor , lineColor,
				lineColor, connection.getGraphicsAlgorithm().getLineStyle());
		return si;
	}
}
