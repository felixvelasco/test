package com.vectorsf.jvoice.core.validation.operations;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;

import com.vectorsf.jvoice.model.operations.CallFlowState;
import com.vectorsf.jvoice.model.operations.FinalState;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.Transition;

public class CallFlowStateValidator {
	private OperationsValidator operationsValidator;

	public CallFlowStateValidator(OperationsValidator operationsValidator) {
		this.operationsValidator = operationsValidator;
	}

	public boolean validate_CallFlowState_checkSubflowState(CallFlowState state) {

		if (state.getSubflow() == null) {
			operationsValidator.error(state, "State " + state.getName() + " has no subflow defined.");
		} else {
			URI uri = state.getSubflow().eResource().getURI();
			File rawFile = null;
			if (uri.isPlatformResource()) {
				IPath rawPath = ResourcesPlugin.getWorkspace().getRoot().findMember(uri.toPlatformString(true))
						.getRawLocation();

				rawFile = rawPath.toFile();
			} else {
				rawFile = new File(uri.toFileString());
			}
			if (!rawFile.exists()) {
				operationsValidator
						.error(state, "State " + state.getName() + " has a subflow defined that not exists.");
			}
		}

		return true;
	}

	public boolean validate_CallFlowState_outcomingSubflowState(CallFlowState state) {
		List<String> finalStatesNames = new ArrayList<String>();
		for (State subflowStates : state.getSubflow().getStates()) {
			if (subflowStates instanceof FinalState) {
				finalStatesNames.add(subflowStates.getName());
			}
		}

		for (Transition t : state.getOutgoingTransitions()) {
			if (!finalStatesNames.contains(t.getEventName())) {
				operationsValidator.warning(state,
						"State " + state.getName() + " has final state \"" + t.getEventName() + "\" in subflow");
			}
		}

		for (String f : finalStatesNames) {
			boolean contains = false;
			for (Transition t : state.getOutgoingTransitions()) {
				if (f.equals(t.getEventName())) {
					contains = true;
					break;
				}
			}
			if (!contains) {
				operationsValidator.error(state, "State " + state.getName() + " has no transition for event \"" + f
						+ "\" defined in subflow.");
			}
		}

		return true;
	}
}
