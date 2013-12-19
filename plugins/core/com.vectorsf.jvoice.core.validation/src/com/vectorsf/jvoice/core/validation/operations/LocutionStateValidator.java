package com.vectorsf.jvoice.core.validation.operations;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.vectorsf.jvoice.model.operations.LocutionState;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;

public class LocutionStateValidator {

	private OperationsValidator operationsValidator;

	public LocutionStateValidator(OperationsValidator operationsValidator) {
		this.operationsValidator = operationsValidator;
	}

	public boolean validate_LocutionState_checkGrammars(LocutionState lstate) {

		return true;
	}

	public boolean validate_LocutionState_checkOutcomingsLocution(LocutionState lstate) {

		return true;
	}

	public boolean validate_LocutionState_checkDslsLocutionState(LocutionState lstate) {
		if (lstate.getLocution() == null) {
			operationsValidator.error(lstate, "Locution State " + lstate.getName() + " has not a dsl associated.");
		} else {
			File rawFile = getFileLocution(lstate);

			String name = rawFile.getName().substring(0, rawFile.getName().indexOf("."));
			File file = new File(rawFile.getParent(), name + ".resources/" + lstate.getLocution().getName()
					+ ".voiceDsl");

			if (!file.exists()) {
				operationsValidator.error(lstate, "Locution " + lstate.getLocution() + " does not exist.");
			}

		}

		return true;
	}

	public boolean validate_LocutionState_checkNameDslLocutionState(LocutionState lstate) {

		File rawFile = getFileLocution(lstate);

		String name = rawFile.getName().substring(0, rawFile.getName().indexOf("."));
		File file = new File(rawFile.getParent(), name + ".resources");
		File[] listfile = file.listFiles();
		for (File file2 : listfile) {
			String nameFile = file2.getName().substring(0, file2.getName().indexOf("."));
			String extension = file2.getName().substring(file2.getName().indexOf("."));
			if (extension.equals(".voiceDsl")) {
				ResourceSetImpl resourceSetImpl = new ResourceSetImpl();
				Resource emfRes = null;
				try {
					emfRes = resourceSetImpl.getResource(URI.createFileURI(file2.getCanonicalPath()), true);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try {
					emfRes.load(null);
					for (EObject obj : emfRes.getContents()) {
						if (obj instanceof VoiceDsl) {
							String nameVoice = ((VoiceDsl) obj).getName();
							if (!nameVoice.equals(nameFile)) {
								operationsValidator.error(lstate, "Name of Locution " + nameVoice
										+ " is not the same than the name of the file " + nameFile + ".");
							}
						}
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return true;
	}

	/**
	 * @param lstate
	 * @return
	 */
	protected File getFileLocution(LocutionState lstate) {
		URI uri = lstate.eResource().getURI();

		File rawFile = null;
		if (uri.isPlatformResource()) {
			IPath rawPath = ResourcesPlugin.getWorkspace().getRoot().findMember(uri.toPlatformString(true))
					.getRawLocation();

			rawFile = rawPath.toFile();
		} else {
			rawFile = new File(uri.toFileString());
		}
		return rawFile;
	}

}
