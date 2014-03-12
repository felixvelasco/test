package com.vectorsf.jvoice.core.validation.operations;

import com.vectorsf.jvoice.core.validation.AbstractPolymorphicValidator;

public class OperationsValidator extends AbstractPolymorphicValidator implements IOperationsValidator {

	private FlowValidator flowValidator;
	private StateValidator stateValidator;
	private LocutionStateValidator dslValidator;
	private CallStateValidator callValidator;
	private CustomStateValidator customValidator;
	private InitialStateValidator initialValidator;
	private CallFlowStateValidator callFlowValidator;
	private FinalStateValidator finalValidator;
	private SwitchStateValidator switchStateValidator;
	private NoteValidator noteValidator;
	private MenuStateValidator menuStateValidator;
	private ComponentBeanValidator componentBeanValidator;

	public OperationsValidator() {
		this.flowValidator = new FlowValidator(this);
		this.stateValidator = new StateValidator(this);
		this.dslValidator = new LocutionStateValidator(this);
		this.callValidator = new CallStateValidator(this);
		this.customValidator = new CustomStateValidator(this);
		this.initialValidator = new InitialStateValidator(this);
		this.callFlowValidator = new CallFlowStateValidator(this);
		this.finalValidator = new FinalStateValidator(this);
		this.switchStateValidator = new SwitchStateValidator(this);
		this.noteValidator = new NoteValidator(this);
		this.menuStateValidator = new MenuStateValidator(this);
		this.componentBeanValidator = new ComponentBeanValidator(this);
	}

	/* (non-Javadoc)
	 * @see com.vectorsf.jvoice.core.validation.operations.IOperationsValidator#getFlowValidator()
	 */
	@Override
	public FlowValidator getFlowValidator() {
		return flowValidator;
	}

	/* (non-Javadoc)
	 * @see com.vectorsf.jvoice.core.validation.operations.IOperationsValidator#getStateValidator()
	 */
	@Override
	public StateValidator getStateValidator() {
		return stateValidator;
	}

	/* (non-Javadoc)
	 * @see com.vectorsf.jvoice.core.validation.operations.IOperationsValidator#getLocutionStateValidator()
	 */
	@Override
	public LocutionStateValidator getLocutionStateValidator() {
		return dslValidator;
	}

	/* (non-Javadoc)
	 * @see com.vectorsf.jvoice.core.validation.operations.IOperationsValidator#getCallStateValidator()
	 */
	@Override
	public CallStateValidator getCallStateValidator() {
		return callValidator;
	}

	/* (non-Javadoc)
	 * @see com.vectorsf.jvoice.core.validation.operations.IOperationsValidator#getCustomStateValidator()
	 */
	@Override
	public CustomStateValidator getCustomStateValidator() {
		return customValidator;
	}

	/* (non-Javadoc)
	 * @see com.vectorsf.jvoice.core.validation.operations.IOperationsValidator#getInitialStateValidator()
	 */
	@Override
	public InitialStateValidator getInitialStateValidator() {
		return initialValidator;
	}

	/* (non-Javadoc)
	 * @see com.vectorsf.jvoice.core.validation.operations.IOperationsValidator#getCallFlowStateValidator()
	 */
	@Override
	public CallFlowStateValidator getCallFlowStateValidator() {
		return callFlowValidator;
	}

	/* (non-Javadoc)
	 * @see com.vectorsf.jvoice.core.validation.operations.IOperationsValidator#getFinalStateValidator()
	 */
	@Override
	public FinalStateValidator getFinalStateValidator() {
		return finalValidator;
	}

	/* (non-Javadoc)
	 * @see com.vectorsf.jvoice.core.validation.operations.IOperationsValidator#getSwitchStateValidator()
	 */
	@Override
	public SwitchStateValidator getSwitchStateValidator() {
		return switchStateValidator;
	}

	/* (non-Javadoc)
	 * @see com.vectorsf.jvoice.core.validation.operations.IOperationsValidator#getNoteValidator()
	 */
	@Override
	public NoteValidator getNoteValidator() {
		return noteValidator;
	}

	/* (non-Javadoc)
	 * @see com.vectorsf.jvoice.core.validation.operations.IOperationsValidator#getMenuStateValidator()
	 */
	@Override
	public MenuStateValidator getMenuStateValidator() {
		return menuStateValidator;
	}

	/* (non-Javadoc)
	 * @see com.vectorsf.jvoice.core.validation.operations.IOperationsValidator#getComponentBeanValidator()
	 */
	@Override
	public ComponentBeanValidator getComponentBeanValidator() {
		return componentBeanValidator;
	}

}
