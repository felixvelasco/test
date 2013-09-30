/*******************************************************************************
 * <copyright>
 *
 * Copyright (c) 2005, 2010 SAP AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    SAP AG - initial API, implementation and documentation
 *    Bug 336488 - DiagramEditor API
 *
 * </copyright>
 *
 *******************************************************************************/
package com.vectorsf.jvoice.diagram.core.diagram;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.graphiti.ui.editor.DiagramEditor;
import org.eclipse.graphiti.ui.editor.DiagramEditorInput;
import org.eclipse.graphiti.ui.services.GraphitiUi;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.base.JVProject;

/**
 * The Class CreateDiagramWizard.
 */
public class CreateDiagramJVoice extends BasicNewResourceWizard {

	private static final String PAGE_NAME_DIAGRAM_NAME = "JVoice Diagram Name";
	private static final String WIZARD_WINDOW_TITLE = "New JVoice Diagram";

	private Diagram diagram;
	DiagramNameWizardPage pageName;

	@Override
	public void addPages() {
		super.addPages();
		pageName = new DiagramNameWizardPage(PAGE_NAME_DIAGRAM_NAME);
		pageName.setSelection(getSelection().getFirstElement());
		addPage(pageName);
	}

	@Override
	public boolean canFinish() {
		return super.canFinish();
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection currentSelection) {
		super.init(workbench, currentSelection);
		setWindowTitle(WIZARD_WINDOW_TITLE);
	}

	@Override
	public boolean performFinish() {

		final String diagramName = ((DiagramNameWizardPage) getPage(PAGE_NAME_DIAGRAM_NAME))
				.getText();

		IProject project = null;
		IFolder diagramFolder = null;

		Object element = pageName.getSelection();

		if (element instanceof JVProject) {
			project = (IProject) Platform.getAdapterManager().getAdapter(
					element, IProject.class);
		} else if (element instanceof JVPackage) {
			diagramFolder = (IFolder) Platform.getAdapterManager().getAdapter(
					element, IFolder.class);
			project = diagramFolder.getProject();
		}
		// if (element instanceof IProject) {
		// project = (IProject) element;
		// } else if (element instanceof IFolder) {
		// diagramFolder = (IFolder) element;
		// project = diagramFolder.getProject();
		// } else if (element instanceof JVProject) {
		// project = (IProject) Platform.getAdapterManager().getAdapter(
		// element, IProject.class);
		// } else if (element instanceof JVPackage) {
		// diagramFolder = (IFolder) Platform.getAdapterManager().getAdapter(
		// element, IFolder.class);
		// project = diagramFolder.getProject();
		// } else if (element instanceof IPackageFragmentRoot) {
		// IPackageFragmentRoot prueba = (IPackageFragmentRoot) element;
		// diagramFolder = (IFolder) prueba.getResource();
		// project = diagramFolder.getProject();
		// }

		if (project == null || !project.isAccessible()) {
			String error = "No Project Found";
			IStatus status = new Status(IStatus.ERROR, "1", error);
			ErrorDialog.openError(getShell(), error, null, status);
			return false;
		}

		Diagram diagram = Graphiti.getPeCreateService().createDiagram(
				"jVoiceDiagram", diagramName, true);

		String editorID = DiagramEditor.DIAGRAM_EDITOR_ID;
		String editorExtension = "jvflow"; //$NON-NLS-1$
		String diagramTypeProviderId = GraphitiUi.getExtensionManager()
				.getDiagramTypeProviderId("jVoiceDiagram");
		String namingConventionID = diagramTypeProviderId + ".editor"; //$NON-NLS-1$
		IEditorDescriptor specificEditor = PlatformUI.getWorkbench()
				.getEditorRegistry().findEditor(namingConventionID);

		// If there is a specific editor get the file extension
		if (specificEditor != null) {
			editorID = namingConventionID;
			IExtensionRegistry extensionRegistry = Platform
					.getExtensionRegistry();
			IExtensionPoint extensionPoint = extensionRegistry
					.getExtensionPoint("org.eclipse.ui.editors"); //$NON-NLS-1$
			IExtension[] extensions = extensionPoint.getExtensions();
			for (IExtension ext : extensions) {
				IConfigurationElement[] configurationElements = ext
						.getConfigurationElements();
				for (IConfigurationElement ce : configurationElements) {
					String id = ce.getAttribute("id"); //$NON-NLS-1$
					if (editorID.equals(id)) {
						String fileExt = ce.getAttribute("extensions"); //$NON-NLS-1$
						if (fileExt != null) {
							editorExtension = fileExt;
							break;
						}
					}

				}
			}
		}

		IFile diagramFile = diagramFolder != null ? diagramFolder
				.getFile(diagramName + "." + editorExtension) : project
				.getFile(diagramName + "." + editorExtension); //$NON-NLS-1$
		URI uri = URI.createPlatformResourceURI(diagramFile.getFullPath()
				.toString(), true);

		FileService.createEmfFileForDiagram(uri, diagram, diagramName);
		String providerId = GraphitiUi.getExtensionManager()
				.getDiagramTypeProviderId(diagram.getDiagramTypeId());
		DiagramEditorInput editorInput = new DiagramEditorInput(
				EcoreUtil.getURI(diagram), providerId);

		try {
			PlatformUI.getWorkbench().getActiveWorkbenchWindow()
					.getActivePage().openEditor(editorInput, editorID);
		} catch (PartInitException e) {
			String error = "error open editor";
			IStatus status = new Status(IStatus.ERROR, "0", error, e);
			ErrorDialog.openError(getShell(), error, null, status);
			return false;
		}

		return true;
	}

	public Diagram getDiagram() {
		return diagram;
	}
}
