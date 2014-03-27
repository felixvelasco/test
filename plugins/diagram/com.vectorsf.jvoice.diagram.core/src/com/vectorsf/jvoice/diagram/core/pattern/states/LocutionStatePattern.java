package com.vectorsf.jvoice.diagram.core.pattern.states;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.graphiti.features.context.IAddContext;
import org.eclipse.graphiti.features.context.ICreateContext;
import org.eclipse.graphiti.features.context.impl.AddContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.window.Window;
import org.eclipse.ui.PlatformUI;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.diagram.core.features.CoreImageProvider;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.LocutionState;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;
import com.vectorsf.jvoice.ui.wizard.PicWizardDialog;
import com.vectorsf.jvoice.ui.wizard.create.CreateDefinitionWizard;
import com.vectorsf.jvoice.ui.wizard.create.DefinitionHelper;

public abstract class LocutionStatePattern extends SimpleStatePattern {

	private boolean textual;
	private URI resultURI;
	private IMethod resultMethod;

	public LocutionStatePattern() {
		super();
	}

	@Override
	public final Object[] create(ICreateContext context) {
		Flow flow = (Flow) getBusinessObjectForPictogramElement(getDiagram());

		if (createLocution(flow)) {
			LocutionState state = createMainState();
			state.setTextual(textual);

			if (textual) {
				IResource resourceFile = getResourceFile(flow, resultURI);
				ResourceSet resourceSet = BaseModel.getInstance().getResourceSet();
				Resource resource = resourceSet.getResource(resultURI, false);
				if (resource == null) {
					resource = resourceSet.getResource(resultURI, true);
				} else if (resourceFile != null && resource.getTimeStamp() < resourceFile.getLocalTimeStamp()) {
					resource.unload();
					resource = resourceSet.getResource(resultURI, true);
				}

				VoiceDsl result = (VoiceDsl) resource.getContents().get(0);

				state.setName(getValidStateName(flow, result.getName()));
				state.setLocution(result);
			} else {
				state.getFireableEvents().add("ok");

				try {
					int length = resultMethod.getParameters().length;
					for (int i = 0; i < length; i++) {
						state.getParameters().add("");
					}
				} catch (JavaModelException e) {
					e.printStackTrace();
				}
				state.setName(getValidStateName(flow, resultMethod.getElementName()));
				state.setMethodName(resultMethod.getElementName());
			}

			flow.getStates().add(state);

			addGraphicalRepresentation(context, state);

			return new Object[] { state };
		} else {
			throw new OperationCanceledException();
		}
	}

	private IResource getResourceFile(Flow flow, URI locationUri) {
		IFile flowFile = (IFile) Platform.getAdapterManager().getAdapter(flow, IFile.class);
		IPath resourcesPath = flowFile.getFullPath().removeFileExtension().addFileExtension("resources");
		IFolder resourcesFolder = (IFolder) ResourcesPlugin.getWorkspace().getRoot().findMember(resourcesPath);
		IResource resourceFile = null;
		try {
			for (IResource file : resourcesFolder.members()) {
				if (locationUri != null) {
					if (file.getName().equals(locationUri.lastSegment())) {
						resourceFile = file;
						break;
					}
				}
			}
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return resourceFile;
	}

	@Override
	protected PictogramElement doAdd(IAddContext context) {

		if (context.getNewObject() instanceof VoiceDsl) {
			// Obtenemos el dsl que se ha arrastrado al editor
			VoiceDsl dsl = (VoiceDsl) context.getNewObject();
			String dslName = dsl.getName();

			// Obtenemos el flujo al que se ha arrastrado.
			Flow flow = (Flow) getBusinessObjectForPictogramElement(getDiagram());

			// Creamos el estado a partir del dsl
			LocutionState state = createMainState();
			state.setName(getValidStateName(flow, dslName));
			state.setLocution(dsl);

			// A�adimos al flujo el estado creado.
			flow.getStates().add(state);

			// El padre necesita un estado en el contexto, as� que creamos un nuevo contexto y le seteamos el estado.
			AddContext newContext = new AddContext(context, state);

			return super.doAdd(newContext);
		} else {
			return super.doAdd(context);
		}
	}

	@Override
	protected boolean hasSubImageDecorator(State state) {
		return !((LocutionState) state).isTextual();
	}

	@Override
	protected String getSubStateImageId(State state) {
		return CoreImageProvider.IMG_STATE_PROGRAMMABLE_DECORATOR;
	}

	protected boolean isDslFromTargetFlow(VoiceDsl dsl) {
		// Obtenemos el flujo al que se ha arrastrado el dsl.
		Flow flow = (Flow) getBusinessObjectForPictogramElement(getDiagram());

		// Obtenemos el flujo al que pertenece el dsl arrastrado.
		IFile file = (IFile) Platform.getAdapterManager().getAdapter(dsl, IFile.class);
		String dslFlow = file.getParent().getName().substring(0, file.getParent().getName().indexOf(".resources"));

		// Comparamos que sean el mismo flujo.
		return dslFlow.equals(flow.getName());
	}

	private boolean createLocution(Flow flow) {
		CreateDefinitionWizard newWizard = new CreateDefinitionWizard(flow, getMainType());
		PicWizardDialog wizardDialog = new PicWizardDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getShell(), newWizard);

		if (wizardDialog.open() == Window.OK) {
			textual = newWizard.isTextual();
			if (textual) {
				resultURI = newWizard.getURI();
			} else {
				resultMethod = newWizard.getMethod();
			}
			return true;
		} else {
			return false;
		}

	}

	protected abstract LocutionState createMainState();

	protected abstract String getTitle();

	protected abstract String getDescription();

	protected abstract DefinitionHelper getMainType();

}
