package com.vectorsf.jvoice.diagram.core.pattern.states;

import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.algorithms.Rectangle;
import org.eclipse.graphiti.mm.algorithms.Text;
import org.eclipse.graphiti.mm.algorithms.styles.Orientation;
import org.eclipse.graphiti.mm.pictograms.ContainerShape;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.services.IGaService;
import org.eclipse.graphiti.services.IPeCreateService;
import org.eclipse.graphiti.util.IPredefinedRenderingStyle;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.vectorsf.jvoice.diagram.core.pattern.StatePredefinedColoredAreas;
import com.vectorsf.jvoice.model.operations.CallState;
import com.vectorsf.jvoice.model.operations.ComponentBean;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.OperationsFactory;
import com.vectorsf.jvoice.ui.edit.dialogs.DialogExecuteBean;
import com.vectorsf.jvoice.ui.edit.filters.FilterDialogExecuteBean;
import com.vectorsf.jvoice.ui.edit.provider.MethodsBeanContentProvider;
import com.vectorsf.jvoice.ui.edit.provider.MethodsBeanLabelProvider;
import com.vectorsf.jvoice.ui.edit.validators.ValidatorExecuteBean;

public class CallStatePattern extends StatePattern {

	private static final String CALL = "Call";
	private static int MIN_WIDTH = 120;
	private static int MIN_HEIGHT = 60;

	@Override
	protected PictogramElement doAdd(IAddContext context) {

		CallState addedDomainObject = (CallState) context.getNewObject();
		IPeCreateService peCreateService = Graphiti.getPeCreateService();
		IGaService gaService = Graphiti.getGaService();

		ContainerShape outerContainerShape = peCreateService.createContainerShape(getDiagram(), true);

		Rectangle mainRectangle = gaService.createRectangle(outerContainerShape);
		setId(mainRectangle, ID_MAIN_FIGURE);
		mainRectangle.setFilled(true);
		gaService.setRenderingStyle(mainRectangle, StatePredefinedColoredAreas
				.getAdaptedGradientColoredAreas(IPredefinedRenderingStyle.BLUE_WHITE_GLOSS_ID));
		gaService.setLocationAndSize(mainRectangle, context.getX(), context.getY(),
				Math.max(MIN_WIDTH, context.getWidth()), Math.max(MIN_HEIGHT, context.getHeight()));

		Text text = gaService.createText(mainRectangle, addedDomainObject.getName());
		setId(text, ID_NAME_TEXT);
		text.setHorizontalAlignment(Orientation.ALIGNMENT_CENTER);
		text.setVerticalAlignment(Orientation.ALIGNMENT_CENTER);

		peCreateService.createChopboxAnchor(outerContainerShape);

		link(outerContainerShape, addedDomainObject);

		return outerContainerShape;

	}

	@Override
	public Object[] create(ICreateContext context) {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE);
		MethodsBeanContentProvider methotdBeanContentProvider = new MethodsBeanContentProvider(adapterFactory);
		MethodsBeanLabelProvider labelProviderMB = new MethodsBeanLabelProvider();
		DialogExecuteBean dialog = new DialogExecuteBean(shell, labelProviderMB, methotdBeanContentProvider);

		dialog.setAllowMultiple(false);
		dialog.setHelpAvailable(false);
		dialog.setValidator(new ValidatorExecuteBean());

		dialog.addFilter(new FilterDialogExecuteBean());
		dialog.setTitle("Bean Selection");
		dialog.setMessage("Select a method:");

		Flow flow = (Flow) getBusinessObjectForPictogramElement(getDiagram());

		EList<ComponentBean> lb = flow.getBeans();
		dialog.setInput(lb);
		dialog.open();
		IMethod methodResult = null;

		switch (dialog.getReturnCode()) {
		case Dialog.OK:
			Object[] results = dialog.getResult();

			methodResult = (IMethod) results[0];
			break;
		case Dialog.CANCEL:
			throw new OperationCanceledException();
		default:
			break;
		}
		if (methodResult != null) {
			CallState cs = OperationsFactory.eINSTANCE.createCallState();
			cs.setName(methodResult.getElementName());
			cs.setDescription(methodResult.getElementName());
			flow = (Flow) getBusinessObjectForPictogramElement(getDiagram());
			flow.getStates().add(cs);

			addGraphicalRepresentation(context, cs);
			return new Object[] { cs };
		}
		return null;
	}

	@Override
	public String getCreateName() {
		return CALL;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject) {
		return mainBusinessObject instanceof CallState;
	}

}
