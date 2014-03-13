package com.vectorsf.jvoice.core.validation.operations.test;

import org.easymock.EasyMock;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.vectorsf.jvoice.core.validation.operations.CallStateValidator;
import com.vectorsf.jvoice.core.validation.operations.IOperationsValidator;
import com.vectorsf.jvoice.model.operations.CallState;
import com.vectorsf.jvoice.model.operations.ComponentBean;
import com.vectorsf.jvoice.model.operations.Flow;

@RunWith(BlockJUnit4ClassRunner.class)
public class CallStateValidatorTest {
	@Test
	public void test_validate_CallState_exitsBeanInExecute() {
		IOperationsValidator ov = (IOperationsValidator) EasyMock.createNiceMock(IOperationsValidator.class);
		EasyMock.replay(ov);
		CallStateValidator csv = new CallStateValidator(ov);

		URI emfUri = URI.createFileURI("prueba.txt");

		Resource resource = (Resource) EasyMock.createMock(Resource.class);
		EasyMock.expect(resource.getURI()).andReturn(emfUri);
		EasyMock.replay(resource);

		Flow flow = (Flow) EasyMock.createMock(Flow.class);
		EasyMock.expect(flow.getName()).andReturn("myFlow").anyTimes();
		EasyMock.replay(flow);

		ComponentBean cb = (ComponentBean) EasyMock.createMock(ComponentBean.class);
		EasyMock.expect(cb.getFqdn()).andReturn("MyBean").anyTimes();
		EasyMock.replay(cb);

		CallState state = (CallState) EasyMock.createMock(CallState.class);
		EasyMock.expect(state.eContainer()).andReturn(flow);
		EasyMock.expect(state.eResource()).andReturn(resource);
		EasyMock.expect(state.getBean()).andReturn(cb).anyTimes();
		EasyMock.expect(state.getName()).andReturn("myState").anyTimes();
		EasyMock.replay(state);

		csv.validate_CallState_exitsBeanInExecute(state);
		ov.error(state, "No exits bean in execute state \"" + state.getName() + " " + state + "\" in flow \"" + flow.getName() + "\"");
		EasyMock.verify(ov);
		System.out.println("Final de test_validate_CallState_exitsBeanInExecute");
	}

	@Test(expected = AssertionError.class)
	public void test_validate_CallState_reallyExitsBeanInExecute() {
		IOperationsValidator ov = (IOperationsValidator) EasyMock.createNiceMock(IOperationsValidator.class);
		EasyMock.replay(ov);
		CallStateValidator csv = new CallStateValidator(ov);

		URI emfUri = URI.createPlatformPluginURI(
						"/com.vectorsf.jvoice.core.validation.test/src/com/vectorsf/jvoice/core/validation/operations/test/CallStateValidatorTest.java",
						false);

		Resource resource = (Resource) EasyMock.createMock(Resource.class);
		EasyMock.expect(resource.getURI()).andReturn(emfUri);
		EasyMock.replay(resource);

		Flow flow = (Flow) EasyMock.createMock(Flow.class);
		EasyMock.expect(flow.getName()).andReturn("myFlow").anyTimes();
		EasyMock.replay(flow);

		ComponentBean cb = (ComponentBean) EasyMock.createMock(ComponentBean.class);
		EasyMock.expect(cb.getFqdn()).andReturn("com.vectorsf.validation.test.BeanTest").anyTimes();
		EasyMock.replay(cb);

		CallState state = (CallState) EasyMock.createMock(CallState.class);
		EasyMock.expect(state.eContainer()).andReturn(flow);
		EasyMock.expect(state.eResource()).andReturn(resource);
		EasyMock.expect(state.getBean()).andReturn(cb).anyTimes();
		EasyMock.expect(state.getName()).andReturn("myState").times(1);

		EasyMock.replay(state);

		csv.validate_CallState_exitsBeanInExecute(state);
		EasyMock.verify(state);
		EasyMock.verify(ov);
		System.out.println("Final de test_validate_CallState_reallyExitsBeanInExecute");
	}
}