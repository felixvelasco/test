package com.vectorsf.jvoice.core.validation.operations;

import java.io.File;
import java.util.List;

import com.vectorsf.jvoice.model.operations.CallState;
import com.vectorsf.jvoice.model.operations.ComponentBean;
import com.vectorsf.jvoice.model.operations.FinalState;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.State;

public class FlowValidator {

	private IOperationsValidator operationsValidator;
	private final String PATH = "src/main/java";

	public FlowValidator(IOperationsValidator operationsValidator) {
		this.operationsValidator = operationsValidator;
	}

	public boolean validate_Flow_distintNameState(Flow flow) {
		if (flow.getStates().size() > 1) {
			for (int i = 0; i < flow.getStates().size() - 1; i++) {
				String state1 = flow.getStates().get(i).getName();
				for (int j = i + 1; j < flow.getStates().size(); j++) {
					String state2 = flow.getStates().get(j).getName();

					if (state1.equals(state2)) {
						operationsValidator.error(flow, "Duplicate state \"" + state1 + "\" in flow " + flow.getName());
					}
				}
			}
		}
		return true;
	}

	public boolean validate_Flow_exitsBeanInExecute(Flow flow) {
		for (State state : flow.getStates()) {
			if (state instanceof CallState) {
				File rawFile = ValidatorUtils.getFile(state);
				File projectFile = ValidatorUtils.findProjectFile(rawFile);

				String classbean;
				if (((CallState) state).getBean() != null) {
					classbean = ((CallState) state).getBean().getFqdn();
					File folder = new File(projectFile, PATH);
					File filepack = new File(folder, classbean.replace(".", "/").concat(".java"));

					if (!filepack.exists()) {
						operationsValidator.error(flow, "In flow  \"" + flow.getName() + "\""
								+ " not exits bean in state \"" + state.getName() + "\"");
					}
				}
			}
		}
		return true;
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
		if (flow.getParameters().size() > 1) {
			for (int i = 0; i < flow.getParameters().size() - 1; i++) {
				String param1 = flow.getParameters().get(i);
				for (int j = i + 1; j < flow.getParameters().size(); j++) {
					String param2 = flow.getParameters().get(j);

					if (param1.equals(param2)) {
						operationsValidator.error(flow,
								"Duplicate parameter \"" + param1 + "\" in flow " + flow.getName());
					}
				}
			}
		}
		return true;
	}

	public boolean validate_Flow_exitsbeans(Flow flow) {

		List<ComponentBean> beans = flow.getBeans();
		// URI uri = flow.eResource().getURI();

		File rawFile = ValidatorUtils.getFile(flow);
		File projectFile = ValidatorUtils.findProjectFile(rawFile);

		String classbean;
		for (ComponentBean bean : beans) {
			classbean = bean.getFqdn();
			File folder = new File(projectFile, PATH);
			File filepack = new File(folder, classbean.replace(".", "/").concat(".java"));

			if (!filepack.exists()) {
				operationsValidator.error(flow, "Bean class " + classbean + " not found");
			}
		}
		return true;
	}

	public boolean validate_Flow_distintNameScopedBean(Flow flow) {
		if (flow.getBeans().size() > 1) {
			for (int i = 0; i < flow.getBeans().size() - 1; i++) {
				ComponentBean bean1 = flow.getBeans().get(i);
				for (int j = i + 1; j < flow.getBeans().size(); j++) {
					ComponentBean bean2 = flow.getBeans().get(j);

					if (bean2.getName().equals(bean1.getName())) {
						operationsValidator.error(flow,
								"Duplicate bean \"" + bean1.getName() + "\" in flow " + flow.getName());
					}
				}
			}
		}
		return true;
	}

	public boolean validate_Flow_checkNameParameter(Flow flow) {
		if (flow.getParameters().size() > 0) {
			for (int i = 0; i < flow.getParameters().size(); i++) {
				String name = flow.getParameters().get(i);

				char initial = name.charAt(0);
				if (!Character.isJavaIdentifierStart(initial)) {
					operationsValidator.error(flow, "Name of parameter " + name + " starts with an invalid character.");
				}

				for (int l = 1; l < name.length(); l++) {
					char letter = name.charAt(l);
					if (!Character.isJavaIdentifierPart(letter)) {
						operationsValidator.error(flow, "Name of  parameter " + name
								+ " contains the invalid character '" + letter + "'.");
						break;
					}

				}
			}
		}
		return true;
	}
}
