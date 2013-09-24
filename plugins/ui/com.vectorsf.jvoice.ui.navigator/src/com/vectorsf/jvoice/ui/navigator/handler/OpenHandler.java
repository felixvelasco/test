package com.vectorsf.jvoice.ui.navigator.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import com.vectorsf.jvoice.model.base.JVBean;

public class OpenHandler extends AbstractHandler {

	private URI diagramUri;
	private DiagramEditorInput input;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if (currentSelection instanceof IStructuredSelection) {
			IStructuredSelection sel = (IStructuredSelection) currentSelection;

			for (Object o : sel.toArray()) {
				if (o instanceof JVBean) {

					diagramUri = EcoreUtil.getURI((JVBean) o).appendFragment(
							"/0"); //$NON-NLS-1$

					input = new DiagramEditorInput(diagramUri, GraphitiUi
							.getExtensionManager().getDiagramTypeProviderId(
									"jVoiceDiagram"));

					IWorkbenchPage page = PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getActivePage();

					try {

						page.openEditor(input, DiagramEditor.DIAGRAM_EDITOR_ID);

					} catch (PartInitException e) {

						e.printStackTrace();
					}

				}

			}

		}
		return null;
	}

}
