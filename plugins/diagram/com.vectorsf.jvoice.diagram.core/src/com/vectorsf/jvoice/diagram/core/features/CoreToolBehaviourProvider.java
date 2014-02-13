package com.vectorsf.jvoice.diagram.core.features;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.graphiti.dt.IDiagramTypeProvider;
import org.eclipse.graphiti.features.ICreateConnectionFeature;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.context.IDoubleClickContext;
import org.eclipse.graphiti.features.context.IPictogramElementContext;
import org.eclipse.graphiti.features.context.ISingleClickContext;
import org.eclipse.graphiti.features.custom.ICustomFeature;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Image;
import org.eclipse.graphiti.mm.algorithms.Polyline;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.LineStyle;
import org.eclipse.graphiti.mm.pictograms.Connection;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.palette.IPaletteCompartmentEntry;
import org.eclipse.graphiti.platform.IPlatformImageConstants;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.tb.ConnectionSelectionInfoImpl;
import org.eclipse.graphiti.tb.ContextButtonEntry;
import org.eclipse.graphiti.tb.ContextEntryHelper;
import org.eclipse.graphiti.tb.ContextMenuEntry;
import org.eclipse.graphiti.tb.DefaultToolBehaviorProvider;
import org.eclipse.graphiti.tb.IConnectionSelectionInfo;
import org.eclipse.graphiti.tb.IContextButtonEntry;
import org.eclipse.graphiti.tb.IContextButtonPadData;
import org.eclipse.graphiti.tb.IContextMenuEntry;
import org.eclipse.graphiti.tb.IDecorator;
import org.eclipse.graphiti.tb.IShapeSelectionInfo;
import org.eclipse.graphiti.tb.ImageDecorator;
import org.eclipse.graphiti.tb.ShapeSelectionInfoImpl;
import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

import com.vectorsf.jvoice.diagram.core.features.editing.FinalStateHangToggleFeature;
import com.vectorsf.jvoice.diagram.core.pattern.note.CreateRelationFromPad;
import com.vectorsf.jvoice.diagram.core.pattern.note.RelationPattern;
import com.vectorsf.jvoice.diagram.core.pattern.transition.AddMoreEventFeature;
import com.vectorsf.jvoice.model.operations.CallFlowState;
import com.vectorsf.jvoice.model.operations.CallState;
import com.vectorsf.jvoice.model.operations.CustomState;
import com.vectorsf.jvoice.model.operations.FinalState;
import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.LocutionState;
import com.vectorsf.jvoice.model.operations.MenuState;
import com.vectorsf.jvoice.model.operations.Note;
import com.vectorsf.jvoice.model.operations.SwitchState;

public class CoreToolBehaviourProvider extends DefaultToolBehaviorProvider {

	private static final int LINE_SELECTION_WIDTH = 15;
	public static final String PAD_CONTEXT_MENU_ENTRY = "padContextMenuEntry"; //$NON-NLS-1$
	public static final String PAD_CONTEXT_SUB_MENU_ENTRY = "padContextSubMenuEntry"; //$NON-NLS-1$
	public static final String CONTEXT_MENU_ENTRY = "contextMenuEntry"; //$NON-NLS-1$
	public static final IColorConstant SELECTION_COLOR = new ColorConstant("01c2e5");
	private Diagnostic diagnostic;

	public CoreToolBehaviourProvider(IDiagramTypeProvider diagramTypeProvider) {
		super(diagramTypeProvider);
	}

	@Override
	public boolean isShowGuides() {
		return true;
	}

	@Override
	public boolean isShowSelectionTool() {
		return false;
	}

	@Override
	public boolean isShowMarqueeTool() {
		return false;
	}

	@Override
	public int getLineSelectionWidth(Polyline polyline) {
		return LINE_SELECTION_WIDTH;
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
			String tooltip = Graphiti.getPeService().getPropertyValue(ga.getPictogramElement(), "TOOLTIP");
			if (tooltip != null) {
				return tooltip;
			}
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

		Object bo = getFeatureProvider().getBusinessObjectForPictogramElement(pe);
		// update button
		if ((bo instanceof MenuState || bo instanceof CallFlowState) && (identifiers & CONTEXT_BUTTON_UPDATE) != 0) {
			IContextButtonEntry updateButton = ContextEntryHelper.createDefaultUpdateContextButton(
					getFeatureProvider(), pe);
			if (updateButton != null) {
				data.getGenericContextButtons().add(updateButton);
			}
		}

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

		if (bo instanceof Note) {
			ICreateConnectionFeature feature = new CreateRelationFromPad(getFeatureProvider(), new RelationPattern(
					getFeatureProvider()));
			button.setText(feature.getCreateName());
			button.setDescription(feature.getCreateDescription());
			button.setIconId(feature.getCreateImageId());
			button.addDragAndDropFeature(feature);

			data.getDomainSpecificContextButtons().add(button);
		} else if (bo instanceof InitialState) {
			return null;
		}

		return data;
	}

	@Override
	public IShapeSelectionInfo getSelectionInfoForShape(Shape shape) {
		IShapeSelectionInfo si = new ShapeSelectionInfoImpl();
		si.setColor(SELECTION_COLOR);
		si.setLineStyle(LineStyle.DASH);
		return si;

	}

	@Override
	public ICustomFeature getDoubleClickFeature(IDoubleClickContext context) {
		Object bo = getFeatureProvider().getBusinessObjectForPictogramElement(context.getInnerPictogramElement());

		// Al hacer doble click en el icono del menú sacamos el diálogo de
		// eventos
		GraphicsAlgorithm ga = context.getInnerGraphicsAlgorithm();
		if (ga instanceof Image && ((Image) ga).getId().equals(CoreImageProvider.IMG_DROPDOWN)
				&& !(bo instanceof CallFlowState) && !(bo instanceof SwitchState)) {
			return new AddMoreEventFeature(getFeatureProvider());
		}

		if (bo instanceof CallFlowState || bo instanceof LocutionState || bo instanceof CustomState
				|| bo instanceof CallState) {

			return new OpenEditorFeature(getFeatureProvider());
		}

		return super.getDoubleClickFeature(context);
	}

	@Override
	public IDecorator[] getDecorators(PictogramElement pe) {
		Object bo = getFeatureProvider().getBusinessObjectForPictogramElement(pe);

		Diagnostic diagnostic = getDiagnostic(bo);
		if (diagnostic.getSeverity() == Diagnostic.ERROR) {
			ImageDecorator imageDecorator = new ImageDecorator(IPlatformImageConstants.IMG_ECLIPSE_ERROR_TSK);
			imageDecorator.setMessage(diagnostic.getMessage());
			return new IDecorator[] { imageDecorator };
		} else if (diagnostic.getSeverity() == Diagnostic.WARNING) {
			ImageDecorator imageDecorator = new ImageDecorator(IPlatformImageConstants.IMG_ECLIPSE_WARNING_TSK);
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
			Object bo = getFeatureProvider().getBusinessObjectForPictogramElement(pe);

			if (bo instanceof FinalState) {
				return new FinalStateHangToggleFeature(getFeatureProvider());
			}
		}

		return super.getSingleClickFeature(context);
	}
}
