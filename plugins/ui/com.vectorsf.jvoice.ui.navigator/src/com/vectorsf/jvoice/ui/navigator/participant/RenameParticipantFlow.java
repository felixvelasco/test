package com.vectorsf.jvoice.ui.navigator.participant;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.ltk.core.refactoring.Change;
import org.eclipse.ltk.core.refactoring.CompositeChange;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.CheckConditionsContext;
import org.eclipse.ltk.core.refactoring.participants.RefactoringArguments;
import org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor;
import org.eclipse.ltk.core.refactoring.participants.RenameArguments;
import org.eclipse.ltk.core.refactoring.participants.RenameParticipant;
import org.eclipse.ltk.core.refactoring.resource.RenameResourceChange;

public class RenameParticipantFlow extends RenameParticipant {

	private IFile flujo;
	private static String extension = "jvflow";
	private String fNewName;
	private IPath pathRecursos;

	public RenameParticipantFlow() {
	}

	@Override
	protected boolean initialize(Object element) {
		flujo = (IFile) element;
		if (flujo.getFileExtension().equals(extension)) {
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean initialize(RefactoringProcessor processor, Object element,
			RefactoringArguments arguments) {
		fNewName = ((RenameArguments) arguments).getNewName();

		return super.initialize(processor, element, arguments);
	}

	@Override
	public String getName() {
		if (fNewName != null) {
			return fNewName;
		}
		return null;
	}

	@Override
	public RefactoringStatus checkConditions(IProgressMonitor pm,
			CheckConditionsContext context) throws OperationCanceledException {

		IPath pathPaqueteResources = new Path(flujo.getName().replace(
				".jvflow", ".resources"));
		IFolder folderRecursos = flujo.getParent().getFolder(
				pathPaqueteResources);
		pathRecursos = folderRecursos.getFullPath();
		if (!folderRecursos.exists()) {
			return RefactoringStatus.createErrorStatus("Resources not found");
		}
		return new RefactoringStatus();
	}

	@Override
	public Change createChange(IProgressMonitor pm) throws CoreException,
			OperationCanceledException {

		CompositeChange result = new CompositeChange("Change Resources"); //$NON-NLS-1$
		// result.add(new RenameResourceChange(flujo.getFullPath(), fNewName));
		result.add(new RenameResourceChange(pathRecursos, fNewName.replace(
				".jvflow", ".resources")));
		return result;
	}

}
