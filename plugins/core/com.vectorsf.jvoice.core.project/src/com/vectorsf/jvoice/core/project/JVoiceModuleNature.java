package com.vectorsf.jvoice.core.project;

import com.vectorsf.jvoice.model.base.BaseFactory;
import com.vectorsf.jvoice.model.base.JVModule;
import com.vectorsf.jvoice.model.base.JVProject;

public class JVoiceModuleNature extends AbstractJVoiceNature {

	private static final String DOT = ".";
	private static final String COMPONENTS_SUFIX = "components";
	public static final String NATURE_ID = PLUGIN_ID + ".jVoiceNature"; //$NON-NLS-1$

	@Override
	protected JVProject createProject() {
		return BaseFactory.eINSTANCE.createJVModule();
	}

	@Override
	protected void setupProject(JVProject jvProject) {
		super.setupProject(jvProject);
		JVModule module = (JVModule) jvProject;
		module.setComponentsPackage(getDefaultComponentsPackageName(module));
	}

	public static String getDefaultComponentsPackageName(JVModule module) {
		return getBaseName() + DOT + lowerCaseFirst(module.getName()) + DOT + COMPONENTS_SUFIX;
	}
	
	public static String getDefaultComponentsPackageName(String name) {
		return getBaseName() + DOT + lowerCaseFirst(name) + DOT + COMPONENTS_SUFIX;
	}

	private static String lowerCaseFirst(String name) {
		char c = name.charAt(0);
		if (Character.isUpperCase(c)) {
			return Character.toLowerCase(c) + name.substring(1);
		}
		return name;
	}

	private static String getBaseName() {
		// TODO Obtain from preferences
		return "com.isb";
	}
}
