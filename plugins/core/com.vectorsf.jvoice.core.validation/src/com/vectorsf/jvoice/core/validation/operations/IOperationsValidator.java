package com.vectorsf.jvoice.core.validation.operations;

import com.vectorsf.jvoice.core.validation.PolymorphicValidator;

public interface IOperationsValidator extends PolymorphicValidator {

	public abstract FlowValidator getFlowValidator();

	public abstract StateValidator getStateValidator();

	public abstract LocutionStateValidator getLocutionStateValidator();

	public abstract CallStateValidator getCallStateValidator();

	public abstract CustomStateValidator getCustomStateValidator();

	public abstract InitialStateValidator getInitialStateValidator();

	public abstract CallFlowStateValidator getCallFlowStateValidator();

	public abstract FinalStateValidator getFinalStateValidator();

	public abstract SwitchStateValidator getSwitchStateValidator();

	public abstract NoteValidator getNoteValidator();

	public abstract MenuStateValidator getMenuStateValidator();

	public abstract ComponentBeanValidator getComponentBeanValidator();

}