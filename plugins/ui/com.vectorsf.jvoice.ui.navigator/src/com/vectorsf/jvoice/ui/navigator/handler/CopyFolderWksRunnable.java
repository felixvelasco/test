package com.vectorsf.jvoice.ui.navigator.handler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.ICompilationUnit;

import com.vectorsf.jvoice.core.operation.helper.FlowService;
import com.vectorsf.jvoice.model.operations.Flow;

class CopyFolderWksRunnable implements IWorkspaceRunnable {

	private final IFolder originalFolder;
	private IPath targetFolderPath;

	protected CopyFolderWksRunnable(IFolder originalFolder, IPath folderPath) {
		this.originalFolder = originalFolder;
		this.targetFolderPath = folderPath;
	}

	@Override
	public void run(IProgressMonitor monitor) throws CoreException {

		IFolder targetFolder = ResourcesPlugin.getWorkspace().getRoot().getFolder(targetFolderPath);
		recursivelyCreate(targetFolder.getParent());

		originalFolder.copy(targetFolderPath, true, null);

		for (IFile flowFile : findFlows(targetFolder)) {
			Flow originalFlow = getOriginalFlow(flowFile, originalFolder);
			ICompilationUnit helperCompilationUnit = FlowService.getHelperICU(originalFlow);
			FlowService.updateFlowHelper(flowFile, helperCompilationUnit, monitor);
		}
	}

	protected Collection<IFile> findFlows(IFolder targetFolder) throws CoreException {
		List<IFile> ret = new ArrayList<>();

		for (IResource member : targetFolder.members()) {
			if (member instanceof IFile && ((IFile) member).getFileExtension().equals("jvflow")) {
				ret.add((IFile) member);
			} else if (member instanceof IFolder) {
				ret.addAll(findFlows((IFolder) member));
			}
		}

		return ret;
	}

	private void recursivelyCreate(IContainer container) throws CoreException {
		if (container.exists()) {
			return;
		}

		IContainer parent = container.getParent();
		if (!parent.exists()) {
			recursivelyCreate(parent);
		}

		if (container instanceof IFolder) {
			((IFolder) container).create(true, true, null);
		}
	}

	private Flow getOriginalFlow(IFile file, IFolder folder) {
		IFile originalFile = folder.getFile(file.getName());
		ResourceSet rSet = new ResourceSetImpl();
		URI uri = URI.createPlatformResourceURI(originalFile.getFullPath().toString(), true).appendFragment("/1");
		Flow flow = (Flow) rSet.getEObject(uri, true);

		return flow;
	}
}