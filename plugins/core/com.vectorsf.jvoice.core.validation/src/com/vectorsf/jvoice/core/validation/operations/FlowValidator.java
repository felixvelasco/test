package com.vectorsf.jvoice.core.validation.operations;

import java.io.File;
import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;

import com.vectorsf.jvoice.model.operations.ComponentBean;
import com.vectorsf.jvoice.model.operations.FinalState;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.State;

public class FlowValidator {

	private OperationsValidator operationsValidator;
	private final String PATH = "src/main/java";

	public FlowValidator(OperationsValidator operationsValidator) {
		this.operationsValidator = operationsValidator;
	}

	public boolean validate_Flow_oneInitialState(Flow flow) {
		int initialCount = 0;
		for (State state : flow.getStates()) {
			if (state instanceof InitialState) {
				initialCount++;
			}
		}
		if (initialCount == 0) {
			operationsValidator.error(flow, "No initial state found");

		} else if (initialCount > 1) {
			operationsValidator.error(flow, "Too many initial states found");
		}
		return true;
	}

	public boolean validate_Flow_someFinalState(Flow flow) {
		for (State state : flow.getStates()) {
			if (state instanceof FinalState) {
				return true;
			}
		}
		operationsValidator.error(flow, "No final state found");
		return true;
	}

	public boolean validate_Flow_distintNameParameter(Flow flow) {

		return true;
	}

	public boolean validate_Flow_exitsbeans(Flow flow) {

		List<ComponentBean> beans = flow.getBeans();
		URI uri = flow.eResource().getURI();

		File rawFile = null;
		if (uri.isPlatformResource()) {
			IPath rawPath = ResourcesPlugin.getWorkspace().getRoot().findMember(uri.toPlatformString(true))
					.getRawLocation();

			rawFile = rawPath.toFile();
		} else {
			rawFile = new File(uri.toFileString());
		}
		File projectFile = findProjectFile(rawFile);

		String classbean;
		for (ComponentBean bean : beans) {
			classbean = bean.getFqdn();
			File folder = new File(projectFile, PATH);
			File filepack = new File(folder, classbean.replace(".", "/").concat(".java"));

			if (!filepack.exists()) {
				operationsValidator.error(flow, "Bean class" + classbean + " not found");
			}
		}

		return true;
	}

	private File findProjectFile(File file) {
		if (file == null) {
			return null;
		}
		if (new File(file, "src/main/resources").exists()) {
			return file;
		}
		return findProjectFile(file.getParentFile());
	}
}
