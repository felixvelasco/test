package com.vectorsf.jvoice.diagram.core.pattern.states;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.graphiti.features.IReason;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.impl.Reason;
import org.eclipse.graphiti.pattern.id.IdUpdateContext;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.diagram.core.features.CoreImageProvider;
import com.vectorsf.jvoice.model.base.JVProject;
import com.vectorsf.jvoice.model.operations.CallFlowState;
import com.vectorsf.jvoice.model.operations.FinalState;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.OperationsFactory;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.ui.edit.dialogs.DialogSubFlow;
import com.vectorsf.jvoice.ui.edit.filters.FilterDialogSubFlow;
import com.vectorsf.jvoice.ui.edit.provider.JVBeanContentProvider;
import com.vectorsf.jvoice.ui.edit.validators.ValidatorSubFlow;
import com.vectorsf.jvoice.ui.wizard.create.CreateDiagramJVoice;

public class CallFlowStatePattern extends SpecialEventStatePattern implements ISelectionStatusValidator {
	private static final String CALL_FLOW = "SubFlow";
	int cont = 0;

	@Override
	public Object[] create(ICreateContext context) {

		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		JVBeanContentProvider callFlowContentProvider = new JVBeanContentProvider(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		DialogSubFlow dialog = new DialogSubFlow(shell, new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE)), callFlowContentProvider);

		dialog.setAllowMultiple(false);
		dialog.setHelpAvailable(false);
		dialog.setIsButtonCreatevailable(true);
		dialog.setValidator(new ValidatorSubFlow());

		dialog.addFilter(new FilterDialogSubFlow());
		dialog.setTitle("Flow Selection");
		dialog.setMessage("Select a flow:");

		Flow flow = (Flow) getBusinessObjectForPictogramElement(getDiagram());
		URI res = flow.eResource().getURI();
		String projectName = res.segment(1);
		JVProject project = BaseModel.getInstance().getModel().getProject(projectName);
		if (project != null) {
			List<JVProject> proj = project.getReferencedProjects();
			dialog.setInput(proj);

			dialog.open();

			Flow result = null;
			String callFlowName = null;
			switch (dialog.getReturnCode()) {
			case Dialog.OK:
				Object[] results = dialog.getResult();

				result = (Flow) results[0];
				callFlowName = result.getName();

				break;
			case IDialogConstants.PROCEED_ID:
				IFile file = (IFile) Platform.getAdapterManager().getAdapter(flow, IFile.class);

				IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
				IProject projectRoot = root.getProject(projectName);

				IFolder folder = projectRoot.getFolder(file.getParent().getProjectRelativePath());
				CreateDiagramJVoice newWizard = new CreateDiagramJVoice(folder);
				WizardDialog wizardDialog = new WizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
						.getShell(), newWizard);

				if (wizardDialog.open() == Window.OK) {
					result = newWizard.getReturnFlow();
					callFlowName = result.getName();
				} else {
					throw new OperationCanceledException();
				}
			case Dialog.CANCEL:
				throw new OperationCanceledException();
			default:
				break;
			}

			if (callFlowName != null) {
				URI flowURI = EcoreUtil.getURI(result);
				result = (Flow) flow.eResource().getResourceSet().getEObject(flowURI, true);

				CallFlowState callFlowState = OperationsFactory.eINSTANCE.createCallFlowState();
				callFlowState.setName(getValidStateName(flow, callFlowName));
				callFlowState.setSubflow(result);

				for (int i = 0; i < result.getParameters().size(); i++) {
					callFlowState.getParameters().add("");
				}

				flow.getStates().add(callFlowState);
				addGraphicalRepresentation(context, callFlowState);

				return new Object[] { callFlowState };
			}
		}
		return null;
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
				return new Status(IStatus.ERROR, "com.vectorsf.jvoice.diagram.core", "Select a flow");
			} else {
				return Status.OK_STATUS;
			}
		} else {
			return new Status(IStatus.ERROR, "com.vectorsf.jvoice.diagram.core", "Select a flow");
		}
	}

	@Override
	public String getCreateImageId() {
		return CoreImageProvider.IMG_PALETTE_SUBFLOW;
	}

	@Override
	public String getCreateLargeImageId() {
		return CoreImageProvider.IMG_LARGE_PALETTE_SUBFLOW;
	}

	@Override
	protected String getStateImageId() {
		return CoreImageProvider.IMG_STATE_SUBFLOW;
	}

	/**
	 * Sobreescribe el método porque los eventos del estado CallFlow son los estados finales del flujo llamado.
	 */
	@Override
	public EList<String> getFireableEvents(State state) {
		EList<String> stateNames = new BasicEList<String>();
		for (State s : ((CallFlowState) state).getSubflow().getStates()) {
			if (s instanceof FinalState) {
				stateNames.add(s.getName());
			}
		}

		return stateNames;
	}

	@Override
	protected IReason updateNeeded(IdUpdateContext context, String id) {
		if (id.equals(ID_NAME_TEXT)) {
			// Obtenemos los nombres de los estados finales del flujo llamado
			CallFlowState state = (CallFlowState) getBusinessObjectForPictogramElement(context
					.getRootPictogramElement());
			Set<String> finalStateNames = new HashSet<String>();
			for (State s : state.getSubflow().getStates()) {
				if (s instanceof FinalState) {
					finalStateNames.add(s.getName());
				}
			}

			Set<String> anchorNames = SimpleStatePattern.getAnchorNames(context);
			anchorNames.removeAll(state.getFireableEvents());
			if (!finalStateNames.equals(anchorNames)) {
				return Reason
						.createTrueReason("The final states of the referred diagram have changed, please update the state");
			}
		}

		return super.updateNeeded(context, id);
	}

}
