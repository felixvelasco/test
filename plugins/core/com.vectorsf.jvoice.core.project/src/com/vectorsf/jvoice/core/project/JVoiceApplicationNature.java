package com.vectorsf.jvoice.core.project;

import com.vectorsf.jvoice.model.base.BaseFactory;
import com.vectorsf.jvoice.model.base.JVProject;

public class JVoiceApplicationNature extends AbstractJVoiceNature {

	@Override
	protected JVProject createProject() {
		return BaseFactory.eINSTANCE.createJVApplication();
	}

}
