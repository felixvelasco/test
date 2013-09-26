package com.vectorsf.jvoice.diagram.core.pattern.states;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.IDirectEditingContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.mm.algorithms.GraphicsAlgorithm;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.mm.pictograms.Shape;
import org.eclipse.graphiti.pattern.id.IdLayoutContext;
import org.eclipse.graphiti.pattern.id.IdUpdateContext;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IPredefinedRenderingStyle;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.dialogs.PatternFilter;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.diagram.core.pattern.StatePredefinedColoredAreas;
import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.base.JVProject;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.InputState;
import com.vectorsf.jvoice.model.operations.OperationsFactory;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;

public class InputStatePattern extends StatePattern implements
		ISelectionStatusValidator {

	private static int MIN_WIDTH = 120;
	private static int MIN_HEIGHT = 60;
	private static String ID_INPUT_PREFIX = "inputState_";
	private static String ID_OUTER_RECTANGLE = ID_INPUT_PREFIX
			+ "outerRectangle";
	private static String ID_MAIN_RECTANGLE = ID_INPUT_PREFIX + "mainRectangle";

	@Override
	protected PictogramElement doAdd(IAddContext context) {
		Diagram targetDiagram = (Diagram) context.getTargetContainer();
		InputState addedDomainObject = (InputState) context.getNewObject();
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();

		// Outer container (invisible)
		ContainerShape outerContainerShape = peCreateService
				.createContainerShape(targetDiagram, true);
		Rectangle outerRectangle = gaService
				.createInvisibleRectangle(outerContainerShape);
		setId(outerRectangle, ID_OUTER_RECTANGLE);
		gaService.setLocationAndSize(outerRectangle, context.getX(),
				context.getY(), Math.max(MIN_WIDTH, context.getWidth()),
				Math.max(MIN_HEIGHT, context.getHeight()));

		// Main contents area
		RoundedRectangle mainRectangle = gaService.createRoundedRectangle(
				outerRectangle, 25, 25);
		setId(mainRectangle, ID_MAIN_RECTANGLE);
		mainRectangle.setFilled(true);
		gaService
				.setRenderingStyle(
						mainRectangle,
						StatePredefinedColoredAreas
								.getAdaptedGradientColoredAreas(IPredefinedRenderingStyle.SILVER_WHITE_GLOSS_ID));

		// File name
		Shape shape = peCreateService.createShape(outerContainerShape, false);
		Text text = gaService.createText(shape, addedDomainObject.getName());
		setId(text, ID_NAME_TEXT);
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);

		peCreateService.createChopboxAnchor(outerContainerShape);

		link(outerContainerShape, addedDomainObject);
		link(shape, addedDomainObject);

		return outerContainerShape;
	}

	@Override
	protected boolean layout(IdLayoutContext context, String id) {
		boolean changesDone = false;

		Rectangle outerRectangle = (Rectangle) context
				.getRootPictogramElement().getGraphicsAlgorithm();

		if (id.equals(ID_MAIN_RECTANGLE) || id.equals(ID_NAME_TEXT)) {
			GraphicsAlgorithm ga = context.getGraphicsAlgorithm();
			if (ga.getWidth() != outerRectangle.getWidth()
					|| ga.getHeight() != outerRectangle.getHeight()) {
				Graphiti.getGaService().setLocationAndSize(ga, 0, 0,
						outerRectangle.getWidth(), outerRectangle.getHeight());
				changesDone = true;
			}
		}

		return changesDone;
	}

	@Override
	public Object[] create(ICreateContext context) {

		Shell shell = new Shell();

		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
				shell,
				new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE)),
				new AdapterFactoryContentProvider(new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE))) {
			@Override
			protected org.eclipse.jface.viewers.TreeViewer doCreateTreeViewer(
					org.eclipse.swt.widgets.Composite parent, int style) {
				PatternFilter filter = new PatternFilter();
				FilteredTree filteredTree = new FilteredTree(parent, style,
						filter, true);
				return filteredTree.getViewer();

			};
		};
		dialog.setAllowMultiple(false);
		dialog.setValidator(this);
		ViewerFilter vfilter = new ViewerFilter() {
			@Override
			public boolean select(Viewer viewer, Object parentElement,
					Object element) {
				if (element instanceof JVProject
						|| element instanceof JVPackage) {
					return true;
				}
				if (element instanceof VoiceDsl) {
					if (((VoiceDsl) element).getDslType().equals("inputname")) {
						return true;
					}
				}

				return false;
			}

		};

		dialog.addFilter(vfilter);
		dialog.setTitle("Input Selection");
		dialog.setMessage("Select an input:");
		dialog.setInput(BaseModel.getInstance().getModel());
		dialog.open();

		Object[] results = dialog.getResult();
		String inputStateName = null;
		VoiceDsl result = null;
		if (results != null && results[0] instanceof VoiceDsl) {
			result = (VoiceDsl) results[0];
			inputStateName = result.getName();
		} else {
			throw new OperationCanceledException();
		}

		InputState inputState = OperationsFactory.eINSTANCE.createInputState();
		inputState.setName(inputStateName);
		inputState.setLocution(result);
		// inputState.setLocution(result);

		Flow flow = (Flow) getBusinessObjectForPictogramElement(getDiagram());
		flow.getStates().add(inputState);

		addGraphicalRepresentation(context, inputState);

		return new Object[] { inputState };
	}

	@Override
	public String getCreateName() {
		return "Input";
	}

	@Override
	protected IReason updateNeeded(IdUpdateContext context, String id) {
		if (id.equals(ID_NAME_TEXT)) {
			InputState is = (InputState) getBusinessObjectForPictogramElement(context
					.getPictogramElement());
			Text text = (Text) context.getGraphicsAlgorithm();
			if (!text.getValue().equals(is.getName())) {
				return Reason.createTrueReason();
			}
		}
		return Reason.createFalseReason();
	}

	@Override
	protected boolean update(IdUpdateContext context, String id) {
		if (id.equals(ID_NAME_TEXT)) {
			InputState ss = (InputState) getBusinessObjectForPictogramElement(context
					.getPictogramElement());
			Text text = (Text) context.getGraphicsAlgorithm();
			text.setValue(ss.getName());
			return true;
		}
		return false;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return mainBusinessObject instanceof InputState;
	}

	@Override
	protected void setValue(String value, IDirectEditingContext context,
			String id) {
		if (id.equals(ID_NAME_TEXT)) {
			InputState ss = (InputState) getBusinessObjectForPictogramElement(context
					.getPictogramElement());
			ss.setName(value);
			updatePictogramElement(context.getPictogramElement());
		}
	}

	@Override
	public boolean canCreate(ICreateContext context) {
		return context.getTargetContainer() instanceof Diagram;
	}

	@Override
	public IStatus validate(Object[] selection) {
		if (selection.length > 0) {
			if (selection[0] instanceof VoiceDsl) {
				VoiceDsl voiceDsl = (VoiceDsl) selection[0];
				if (voiceDsl.getDslType().equals("inputname")) {
					return Status.OK_STATUS;
				} else {
					return new Status(IStatus.ERROR,
							"com.vectorsf.jvoice.diagram.core",
							"Select an input");
				}
			} else {
				return new Status(IStatus.ERROR,
						"com.vectorsf.jvoice.diagram.core", "Select an input");
			}
		} else {
			return new Status(IStatus.ERROR,
					"com.vectorsf.jvoice.diagram.core", "Select an input");
		}
	}

}
