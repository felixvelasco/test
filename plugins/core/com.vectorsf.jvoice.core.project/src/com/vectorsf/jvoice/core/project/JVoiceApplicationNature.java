package com.vectorsf.jvoice.core.project;

import com.vectorsf.jvoice.model.base.BaseFactory;
import com.vectorsf.jvoice.model.base.JVProject;

//import org.eclipse.core.resources.ICommand;
//import org.eclipse.core.resources.IProjectDescription;

public class JVoiceApplicationNature extends AbstractJVoiceNature {

	@Override
	protected JVProject createProject() {
		return BaseFactory.eINSTANCE.createJVApplication();
	}

}
