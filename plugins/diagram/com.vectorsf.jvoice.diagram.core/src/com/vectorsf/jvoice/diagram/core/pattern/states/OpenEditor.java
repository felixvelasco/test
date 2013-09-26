package com.vectorsf.jvoice.diagram.core.pattern.states;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import com.vectorsf.jvoice.model.operations.CallFlowState;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.InputState;
import com.vectorsf.jvoice.model.operations.MenuState;
import com.vectorsf.jvoice.model.operations.PromptState;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;

public class OpenEditor extends AbstractCustomFeature {

	public OpenEditor(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public void execute(ICustomContext context) {

		if (getFeatureProvider().getBusinessObjectForPictogramElement(
				context.getInnerPictogramElement()) instanceof CallFlowState) {

			CallFlowState callFlowState = (CallFlowState) getFeatureProvider()
					.getBusinessObjectForPictogramElement(
							context.getInnerPictogramElement());

			Flow flow = callFlowState.getSubflow();

			URI diagramUri = EcoreUtil.getURI(flow).appendFragment("/0");

			DiagramEditorInput input = new DiagramEditorInput(diagramUri,
					GraphitiUi.getExtensionManager().getDiagramTypeProviderId(
							"jVoiceDiagram"));
			IWorkbenchPage page = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage();

			try {
				page.openEditor(input, DiagramEditor.DIAGRAM_EDITOR_ID);
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		}

		else if (getFeatureProvider().getBusinessObjectForPictogramElement(
				context.getInnerPictogramElement()) instanceof InputState) {
			InputState inputState = (InputState) getFeatureProvider()
					.getBusinessObjectForPictogramElement(
							context.getInnerPictogramElement());
			VoiceDsl locution = inputState.getLocution();

			URI locutionUri = EcoreUtil.getURI(locution);

			IWorkbenchPage page = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage();

			String fileString = URI.decode(locutionUri.path().substring(9));
			IFile file = ResourcesPlugin.getWorkspace().getRoot()
					.getFile(new Path(fileString));

			try {
				IDE.openEditor(page, file);
			} catch (PartInitException e) {

			}

		} else if (getFeatureProvider().getBusinessObjectForPictogramElement(
				context.getInnerPictogramElement()) instanceof MenuState) {
			MenuState menuState = (MenuState) getFeatureProvider()
					.getBusinessObjectForPictogramElement(
							context.getInnerPictogramElement());
			VoiceDsl locution = menuState.getLocution();
			URI locutionUri = EcoreUtil.getURI(locution);
			IWorkbenchPage page = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage();

			String fileString = URI.decode(locutionUri.path().substring(9));
			IFile file = ResourcesPlugin.getWorkspace().getRoot()
					.getFile(new Path(fileString));

			try {
				IDE.openEditor(page, file);
			} catch (PartInitException e) {

			}

		} else if (getFeatureProvider().getBusinessObjectForPictogramElement(
				context.getInnerPictogramElement()) instanceof PromptState) {
			PromptState promptState = (PromptState) getFeatureProvider()
					.getBusinessObjectForPictogramElement(
							context.getInnerPictogramElement());
			VoiceDsl locution = promptState.getLocution();
			URI locutionUri = EcoreUtil.getURI(locution);
			IWorkbenchPage page = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage();

			String fileString = URI.decode(locutionUri.path().substring(9));
			IFile file = ResourcesPlugin.getWorkspace().getRoot()
					.getFile(new Path(fileString));

			try {
				IDE.openEditor(page, file);
			} catch (PartInitException e) {

			}

		}

	}

	@Override
	public boolean hasDoneChanges() {
		return false;
	}

	@Override
	public boolean canExecute(ICustomContext context) {
		return true;
	}
}
