package com.vectorsf.jvoice.core.wsdl.generator.listener;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.base.model.service.JVModelLifecycleListener;
import com.vectorsf.jvoice.core.wsdl.generator.JVoiceWSDLGenerator;

public class WSDLGeneratorListener implements JVModelLifecycleListener {

	public WSDLGeneratorListener() {
	}

	@Override
	public void modelCreated(BaseModel baseModel) {
		JVoiceWSDLGenerator.getInstance().create(baseModel);
	}

}
