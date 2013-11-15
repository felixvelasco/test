package com.vectorsf.jvoice.core.project;

import com.vectorsf.jvoice.model.base.BaseFactory;
import com.vectorsf.jvoice.model.base.JVProject;

public class JVoiceModuleNature extends AbstractJVoiceNature {

	public static final String NATURE_ID = PLUGIN_ID + ".jVoiceNature"; //$NON-NLS-1$

	@Override
	protected JVProject createProject() {
		return BaseFactory.eINSTANCE.createJVModule();
	}

}
