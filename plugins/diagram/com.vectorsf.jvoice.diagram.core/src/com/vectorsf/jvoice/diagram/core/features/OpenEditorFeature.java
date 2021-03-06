package com.vectorsf.jvoice.diagram.core.features;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.ICustomContext;
import org.eclipse.graphiti.features.custom.AbstractCustomFeature;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;

import com.isb.bks.ivr.voice.dsl.ui.internal.VoiceDslActivator;
import com.vectorsf.jvoice.model.operations.CallFlowState;
import com.vectorsf.jvoice.model.operations.CallState;
import com.vectorsf.jvoice.model.operations.ComponentBean;
import com.vectorsf.jvoice.model.operations.CustomState;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.LocutionState;

public class OpenEditorFeature extends AbstractCustomFeature {

	public OpenEditorFeature(IFeatureProvider fp) {
		super(fp);
	}

	@Override
	public void execute(ICustomContext context) {
		Object businessObject = getFeatureProvider().getBusinessObjectForPictogramElement(
				context.getInnerPictogramElement());

		EObject eObject = null;
		if (businessObject instanceof CallFlowState) {
			CallFlowState callFlowState = (CallFlowState) businessObject;
			eObject = callFlowState.getSubflow();
		} else if (businessObject instanceof LocutionState) {
			LocutionState locutionState = (LocutionState) businessObject;
			eObject = locutionState.getLocution();
		} else if (businessObject instanceof CustomState) {
			CustomState customState = (CustomState) businessObject;
			eObject = customState;
		} else if (businessObject instanceof CallState) {
			CallState callState = (CallState) businessObject;
			eObject = callState;
		}

		if (eObject != null) {
			openContainerFile(eObject);
		}

	}

	private void openContainerFile(EObject eObject) {
		URI locutionUri = EcoreUtil.getURI(eObject);
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

		String fileString = locutionUri.toPlatformString(true);
		if (eObject instanceof CustomState) {
			fileString = fileString.replace(".jvflow", ".resources").concat("/")
					.concat(((CustomState) eObject).getPath());
		}

		try {
			if (eObject instanceof CallState) {
				CallState callstate = (CallState) eObject;
				ComponentBean componente = callstate.getBean();
				Flow flujo = (Flow) componente.eContainer();
				IFile fileFlow = (IFile) Platform.getAdapterManager().getAdapter(flujo, IFile.class);

				IProject project = fileFlow.getProject();

				IJavaProject javaProject = JavaCore.create(project);
				IType type = javaProject.findType(componente.getFqdn());
				if (type != null) {
					fileString = type.getResource().getFullPath().toString();
				}
			}

			if (fileString != null) {
				IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(fileString));

				IWorkspace workspace = ResourcesPlugin.getWorkspace();
				IWorkspaceRoot root = workspace.getRoot();
				if (root.getFile(file.getFullPath()).exists()) {
					IDE.openEditor(page, file);
				}
			} else {
				URIEditorInput input = new URIEditorInput(locutionUri);
				if (eObject instanceof Flow) {
					IDE.openEditor(page, input, "org.eclipse.graphiti.ui.editor.DiagramEditorJVoice");
				} else if (eObject instanceof LocutionState) { // Locution
					IURIEditorOpener instance = VoiceDslActivator.getInstance()
							.getInjector(VoiceDslActivator.COM_ISB_BKS_IVR_VOICE_DSL_VOICEDSL)
							.getInstance(IURIEditorOpener.class);
					instance.open(locutionUri, false);
				} else if (eObject instanceof CustomState) {
					String uri = locutionUri.path().substring(9).replace(".jvflow", ".resources").concat("/")
							.concat(((CustomState) eObject).getPath());
					IFile filecustom = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri));
					IDE.openEditor(page, filecustom);
				}
			}
		} catch (PartInitException | JavaModelException e) {
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
