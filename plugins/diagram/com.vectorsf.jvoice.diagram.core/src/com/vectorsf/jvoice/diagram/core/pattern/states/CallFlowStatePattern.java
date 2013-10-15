package com.vectorsf.jvoice.diagram.core.pattern.states;

import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.algorithms.RoundedRectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
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
import com.vectorsf.jvoice.model.operations.CallFlowState;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.OperationsFactory;

public class CallFlowStatePattern extends StatePattern implements
		ISelectionStatusValidator {

	private static final String CALL_FLOW = "SubFlow";
	private static int MIN_WIDTH = 120;
	private static int MIN_HEIGHT = 60;

	@Override
	protected PictogramElement doAdd(IAddContext context) {
		CallFlowState addedDomainObject = (CallFlowState) context
				.getNewObject();
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();

		ContainerShape outerContainerShape = peCreateService
				.createContainerShape(getDiagram(), true);

		RoundedRectangle mainRectangle = gaService.createRoundedRectangle(
				outerContainerShape, 25, 25);
		setId(mainRectangle, ID_MAIN_FIGURE);
		// mainRectangle.setFilled(true);
		gaService
				.setRenderingStyle(
						mainRectangle,
						StatePredefinedColoredAreas
								.getAdaptedGradientColoredAreas(IPredefinedRenderingStyle.COPPER_WHITE_GLOSS_ID));
		gaService.setLocationAndSize(mainRectangle, context.getX(),
				context.getY(), Math.max(MIN_WIDTH, context.getWidth()),
				Math.max(MIN_HEIGHT, context.getHeight()));

		Text text = gaService.createText(mainRectangle,
				addedDomainObject.getName());
		setId(text, ID_NAME_TEXT);
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);

		peCreateService.createChopboxAnchor(outerContainerShape);

		link(outerContainerShape, addedDomainObject);

		return outerContainerShape;

	}

	@Override
	public Object[] create(ICreateContext context) {

		Shell shell = new Shell();

		JVBeanContentProvider callFlowContentProvider = new JVBeanContentProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
				shell,
				new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE)),
				callFlowContentProvider) {

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
						|| element instanceof JVPackage
						|| element instanceof Flow) {
					return true;
				}
				return false;
			}
		};

		dialog.addFilter(vfilter);
		dialog.setTitle("Flow Selection");
		dialog.setMessage("Select a flow:");

		Flow flow = (Flow) getBusinessObjectForPictogramElement(getDiagram());
		URI res = flow.eResource().getURI();
		String projectName = res.segment(1);
		JVProject project = BaseModel.getInstance().getModel()
				.getProject(projectName);
		List<JVProject> proj = project.getReferencedProjects();
		dialog.setInput(proj);

		dialog.open();

		Object[] results = dialog.getResult();
		String callFlowName = null;
		Flow result = null;

		if (results != null && results[0] instanceof Flow) {
			result = (Flow) results[0];
			callFlowName = result.getName();

		} else {
			throw new OperationCanceledException();
		}
		Resource eResource = result.eResource();
		URI flowURI = eResource.getURI().appendFragment(
				eResource.getURIFragment(result));
		result = (Flow) flow.eResource().getResourceSet()
				.getEObject(flowURI, true);

		CallFlowState callFlowState = OperationsFactory.eINSTANCE
				.createCallFlowState();

		callFlowState.setName(callFlowName);
		callFlowState.setSubflow(result);

		flow.getStates().add(callFlowState);

		addGraphicalRepresentation(context, callFlowState);

		return new Object[] { callFlowState };
	}

	@Override
	public String getCreateName() {
		return CALL_FLOW;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return mainBusinessObject instanceof CallFlowState;
	}

	@Override
	public IStatus validate(Object[] selection) {
		if (selection.length > 0) {
			if (!(selection[0] instanceof Flow)) {
				return new Status(IStatus.ERROR,
						"com.vectorsf.jvoice.diagram.core", "Select a flow");
			} else {
				return Status.OK_STATUS;
			}
		} else {
			return new Status(IStatus.ERROR,
					"com.vectorsf.jvoice.diagram.core", "Select a flow");
		}
	}
}
