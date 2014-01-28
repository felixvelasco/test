package com.vectorsf.jvoice.diagram.core.pattern.states;

import java.util.*;

import org.eclipse.core.resources.*;
import org.eclipse.core.runtime.*;
import org.eclipse.emf.common.util.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.mm.algorithms.*;
import org.eclipse.graphiti.mm.algorithms.styles.Point;
import org.eclipse.graphiti.mm.pictograms.*;
import org.eclipse.graphiti.pattern.id.IdLayoutContext;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.jface.dialogs.*;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.diagram.core.features.CoreImageProvider;
import com.vectorsf.jvoice.model.base.JVProject;
import com.vectorsf.jvoice.model.operations.*;
import com.vectorsf.jvoice.ui.edit.dialogs.DialogSubFlow;
import com.vectorsf.jvoice.ui.edit.filters.FilterDialogSubFlow;
import com.vectorsf.jvoice.ui.edit.provider.JVBeanContentProvider;
import com.vectorsf.jvoice.ui.edit.validators.ValidatorSubFlow;
import com.vectorsf.jvoice.ui.wizard.create.CreateDiagramJVoice;

public class CallFlowStatePattern extends SimpleStatePattern implements ISelectionStatusValidator
{
	private static final String CALL_FLOW = "SubFlow";
	int cont = 0;

	@Override
	public Object[] create(ICreateContext context)
	{

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
		if (project != null)
		{
			List<JVProject> proj = project.getReferencedProjects();
			dialog.setInput(proj);

			dialog.open();

			Flow result = null;
			String callFlowName = null;
			switch (dialog.getReturnCode())
			{
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

				if (wizardDialog.open() == Window.OK)
				{
					result = newWizard.getReturnFlow();
					callFlowName = result.getName();
				}
				else
				{
					throw new OperationCanceledException();
				}
			case Dialog.CANCEL:
				throw new OperationCanceledException();
			default:
				break;
			}

			if (callFlowName != null)
			{
				URI flowURI = EcoreUtil.getURI(result);
				result = (Flow) flow.eResource().getResourceSet().getEObject(flowURI, true);

				CallFlowState callFlowState = OperationsFactory.eINSTANCE.createCallFlowState();
				callFlowState.setName(callFlowName);
				callFlowState.setSubflow(result);

				for (int i = 0; i < result.getParameters().size(); i++)
				{
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
	public String getCreateName()
	{
		return CALL_FLOW;
	}

	@Override
	public boolean isMainBusinessObjectApplicable(Object mainBusinessObject)
	{
		return mainBusinessObject instanceof CallFlowState;
	}

	@Override
	public IStatus validate(Object[] selection)
	{
		if (selection.length > 0)
		{
			if (!(selection[0] instanceof Flow))
			{
				return new Status(IStatus.ERROR, "com.vectorsf.jvoice.diagram.core", "Select a flow");
			}
			else
			{
				return Status.OK_STATUS;
			}
		}
		else
		{
			return new Status(IStatus.ERROR, "com.vectorsf.jvoice.diagram.core", "Select a flow");
		}
	}

	@Override
	public String getCreateImageId()
	{
		return CoreImageProvider.IMG_PALETTE_SUBFLOW;
	}

	@Override
	public String getCreateLargeImageId()
	{
		return CoreImageProvider.IMG_LARGE_PALETTE_SUBFLOW;
	}

	@Override
	protected String getStateImageId()
	{
		return CoreImageProvider.IMG_STATE_SUBFLOW;
	}

	/**
	 * Actualiza la barra de eventos que puede disparar el estado.
	 */
	public void updateFireableEvents(IdLayoutContext context)
	{
		GraphicsAlgorithm ga = context.getGraphicsAlgorithm();

		State state = (State) getBusinessObjectForPictogramElement(ga.getPictogramElement());

		// Ajustamos el tamaño del estado
		if (getStateWith(state) > MAIN_RECTANGLE_WIDTH)
		{
			Graphiti.getGaService().setLocationAndSize(ga, ga.getX(), ga.getY(),
				getStateWith(state), ga.getHeight());
		}
		else
		{
			Graphiti.getGaService().setLocationAndSize(ga, ga.getX(), ga.getY(), MAIN_RECTANGLE_WIDTH, ga.getHeight());
		}

		// Borra los anchors del tipo FixPointAnchor que no tienen transiciones
		// de salida
		List<Anchor> anchorsToDelete = new ArrayList<Anchor>();
		List<String> existingAnchors = new ArrayList<String>();
		PictogramElement rootPe = context.getRootPictogramElement();

		for (Anchor anchor : ((AnchorContainer) rootPe).getAnchors())
		{
			if (!(anchor instanceof FixPointAnchor))
				continue;
			if (anchor.getOutgoingConnections().isEmpty())
				anchorsToDelete.add(anchor);
			else
				existingAnchors.add(((Image) anchor.getGraphicsAlgorithm()).getId());
		}

		for (Anchor anchor : anchorsToDelete)
		{
			Graphiti.getPeService().deletePictogramElement(anchor);
		}

		// Creamos el anchor y su imagen asociada
		for (String event : getFireableEvents(state))
		{
			// No creamos los anchors que ya existen
			if (existingAnchors.contains(event))
			{
				continue;
			}

			FixPointAnchor anchor = Graphiti.getPeCreateService().createFixPointAnchor((AnchorContainer) rootPe);

			// Creamos la imagen o el texto del evento dentro del anchor
			Text text = gaService.createText(anchor, event);
			gaService.setLocationAndSize(text, 0, 0, event.length() * 7, IMAGE_SIZE);
			Graphiti.getPeService().setPropertyValue(anchor, "TOOLTIP", event);
		}

		// Reordenamos los anchors
		cont = 0;
		for (Anchor anchor : ((AnchorContainer) rootPe).getAnchors())
		{
			if (anchor instanceof FixPointAnchor)
			{
				((FixPointAnchor) anchor).setLocation(getAnchorLocation(cont++, rootPe, anchor));
			}
		}
	}

	private int getStateWith(State state)
	{
		int numLetters = 0;
		for (String string : getFireableEvents(state))
		{
			numLetters += string.length();
		}
		
		return numLetters * 7;
	}

	public Point getAnchorLocation(int point, PictogramElement pe, Anchor anchor)
	{
		int x = point * 26;

		GraphicsAlgorithm ga = anchor.getGraphicsAlgorithm();
		if (ga instanceof Text)
		{
			x = cont;
			cont += ((Text) ga).getValue().length() * 7;
		}

		int y = pe.getGraphicsAlgorithm().getHeight() - 16 - 10;

		return Graphiti.getGaCreateService().createPoint(x, y);
	}

	/**
	 * Sobreescribe el método porque los eventos del estado CallFlow son los estados finales del flujo llamado. 
	 */
	@Override
	public EList<String> getFireableEvents(State state)
	{
		EList<String> stateNames = new BasicEList<String>();
		for (State s : ((CallFlowState) state).getSubflow().getStates())
		{
			if (s instanceof FinalState)
			{
				stateNames.add(s.getName());
			}
		}
		
		return stateNames;
	}

	@Override
	protected boolean layout(IdLayoutContext context, String id)
	{
		boolean changesDone = false;

		GraphicsAlgorithm gaOuter = context.getRootPictogramElement().getGraphicsAlgorithm();
		if (id.equals(ID_MAIN_FIGURE))
		{
			updateFireableEvents(context);
			changesDone = true;
		}

		// Cambiamos el tamaño del rectángulo superior y la posición del icono
		// del menú
		if (id.equals(ID_TOP_RECTANGLE))
		{
			State state = (State) getBusinessObjectForPictogramElement(context.getRootPictogramElement());
			if (getStateWith(state) > MAIN_RECTANGLE_WIDTH)
			{
				changeTopRectangleWidth(context, getStateWith(state));
			}
			else
			{
				changeTopRectangleWidth(context, MAIN_RECTANGLE_WIDTH);
			}
			changesDone = true;
		}

		return changesDone;
	}

}
