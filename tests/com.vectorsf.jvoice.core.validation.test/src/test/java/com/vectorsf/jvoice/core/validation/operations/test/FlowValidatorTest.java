package com.vectorsf.jvoice.core.validation.operations.test;

import org.easymock.EasyMock;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.vectorsf.jvoice.core.validation.operations.FlowValidator;
import com.vectorsf.jvoice.core.validation.operations.IOperationsValidator;
import com.vectorsf.jvoice.model.operations.CallState;
import com.vectorsf.jvoice.model.operations.ComponentBean;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.State;

@RunWith(BlockJUnit4ClassRunner.class)
public class FlowValidatorTest {
	@Test
	public void test_validate_Flow_exitsBeanInExecute() {
		IOperationsValidator ov = (IOperationsValidator) EasyMock.createNiceMock(IOperationsValidator.class);
		EasyMock.replay(ov);
		FlowValidator flowValidator = new FlowValidator(ov);

		URI emfUri = URI.createFileURI("prueba.txt");

		Resource resource = (Resource) EasyMock.createMock(Resource.class);
		EasyMock.expect(resource.getURI()).andReturn(emfUri);
		EasyMock.replay(resource);

		Flow flow = (Flow) EasyMock.createMock(Flow.class);
		EasyMock.expect(flow.getName()).andReturn("myFlow").anyTimes();

		ComponentBean cb = (ComponentBean) EasyMock.createMock(ComponentBean.class);
		EasyMock.expect(cb.getFqdn()).andReturn("MyBean").anyTimes();
		EasyMock.replay(cb);

		CallState state = (CallState) EasyMock.createMock(CallState.class);
		EasyMock.expect(state.eContainer()).andReturn(flow);
		EasyMock.expect(state.eResource()).andReturn(resource);
		EasyMock.expect(state.getBean()).andReturn(cb).anyTimes();
		EasyMock.expect(state.getName()).andReturn("myState").anyTimes();

		EList<State> states = new BasicEList<>();
		states.add(state);

		EasyMock.expect(flow.getStates()).andReturn(states);

		EasyMock.replay(state);
		EasyMock.replay(flow);

		flowValidator.validate_Flow_exitsBeanInExecute(flow);
		ov.error(flow, "In flow  \"" + flow.getName() + "\""
				+ " not exits bean in state \"" + state.getName() + "\"");
		EasyMock.verify(ov);
		System.out.println("Final de test_validate_CallState_exitsBeanInExecute");
	}

	@Test(expected = AssertionError.class)
	public void test_validate_Flow_reallyExitsBeanInExecute() {
		IOperationsValidator ov = (IOperationsValidator) EasyMock
				.createNiceMock(IOperationsValidator.class);
		EasyMock.replay(ov);
		FlowValidator flowValidator = new FlowValidator(ov);

		URI emfUri = URI.createPlatformPluginURI(
						"/com.vectorsf.jvoice.core.validation.test/src/com/vectorsf/jvoice/core/validation/operations/test/FlowValidatorTest.java",
						false);

		Resource resource = (Resource) EasyMock.createMock(Resource.class);
		EasyMock.expect(resource.getURI()).andReturn(emfUri);
		EasyMock.replay(resource);

		Flow flow = (Flow) EasyMock.createMock(Flow.class);
		EasyMock.expect(flow.getName()).andReturn("myFlow").anyTimes();

		ComponentBean cb = (ComponentBean) EasyMock
				.createMock(ComponentBean.class);
		EasyMock.expect(cb.getFqdn())
				.andReturn("com.vectorsf.validation.test.BeanTest").anyTimes();
		EasyMock.replay(cb);

		CallState state = (CallState) EasyMock.createMock(CallState.class);
		EasyMock.expect(state.eContainer()).andReturn(flow);
		EasyMock.expect(state.eResource()).andReturn(resource);
		EasyMock.expect(state.getBean()).andReturn(cb).anyTimes();
		EasyMock.expect(state.getName()).andReturn("myState").times(1);

		EList<State> states = new BasicEList<>();
		states.add(state);

		EasyMock.expect(flow.getStates()).andReturn(states);

		EasyMock.replay(state);
		EasyMock.replay(flow);

		flowValidator.validate_Flow_exitsBeanInExecute(flow);

		EasyMock.verify(state);
		EasyMock.verify(ov);
		System.out.println("Final de test_validate_CallState_reallyExitsBeanInExecute");
	}
}