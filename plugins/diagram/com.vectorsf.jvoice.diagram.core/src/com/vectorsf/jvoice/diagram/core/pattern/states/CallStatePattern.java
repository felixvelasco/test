package com.vectorsf.jvoice.diagram.core.pattern.states;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.vectorsf.jvoice.diagram.core.features.CoreImageProvider;
import com.vectorsf.jvoice.model.operations.CallState;
import com.vectorsf.jvoice.model.operations.ComponentBean;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.OperationsFactory;
import com.vectorsf.jvoice.ui.edit.dialogs.DialogExecuteBean;
import com.vectorsf.jvoice.ui.edit.filters.FilterDialogExecuteBean;
import com.vectorsf.jvoice.ui.edit.provider.MethodsBeanContentProvider;
import com.vectorsf.jvoice.ui.edit.provider.MethodsBeanLabelProvider;
import com.vectorsf.jvoice.ui.edit.validators.ValidatorExecuteBean;

public class CallStatePattern extends SimpleStatePattern {

	private static final String CALL = "Execution";

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

			try {
				for (int i = 0; i < methodResult.getParameters().length; i++) {
					cs.getParameters().add("");
				}
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
			cs.setMethodName(methodResult.getElementName());
			for (ComponentBean componentBean : lb) {
				if (containsMethod(componentBean, methodResult)) {
					cs.setBean(componentBean);
				}
			}

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

	@Override
	public String getCreateImageId() {
		return CoreImageProvider.IMG_PALETTE_EXECUTION;
	}

	@Override
	protected String getStateImageId() {
		return CoreImageProvider.IMG_STATE_EXECUTION;
	}

	private boolean containsMethod(ComponentBean inCompBean, IMethod inMethod) {
		URI uri = EcoreUtil.getURI(inCompBean);
		IProject project = ResourcesPlugin.getWorkspace().getRoot().findMember(uri.toPlatformString(true)).getProject();
		IJavaProject jProject = JavaCore.create(project);
		IType type;
		try {
			type = jProject.findType(inCompBean.getFqdn());
			IMethod[] methods = type.getMethods();
			for (IMethod iMethod : methods) {
				if (Flags.isPublic(iMethod.getFlags())) {
					if (inMethod.equals(iMethod)) {
						return true;
					}
				}
			}

		} catch (JavaModelException e) {

		}
		return false;
	}
}
