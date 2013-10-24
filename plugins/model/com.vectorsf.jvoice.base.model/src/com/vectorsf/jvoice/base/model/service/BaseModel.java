package com.vectorsf.jvoice.base.model.service;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import com.vectorsf.jvoice.base.model.internal.service.BaseModelEclipseHelper;
import com.vectorsf.jvoice.base.model.internal.service.ListenersManager;
import com.vectorsf.jvoice.model.base.BaseFactory;
import com.vectorsf.jvoice.model.base.JVModel;
import com.vectorsf.jvoice.model.base.JVProject;

public class BaseModel {

	public static final String JV_PATH = "src/main/resources/jv";
	public static final String PROPERTIES_PATH = "src/main/config/properties";

	private static final BaseModel baseModel;

	static {
		baseModel = new BaseModel();
		ListenersManager.init();
	}

	private JVModel model;
	private ResourceSet resourceSet;

	public static BaseModel getInstance() {
		return baseModel;
	}

	public JVModel getModel() {
		return model;
	}

	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	public List<JVProject> getVisibleProjects(JVProject project) {
		if (EMFPlugin.IS_ECLIPSE_RUNNING) {
			return BaseModelEclipseHelper.getVisibleProjects(project);
		} else {
			return Collections.singletonList(project);
		}
	}

	private BaseModel() {
		resourceSet = new ResourceSetImpl();
		model = BaseFactory.eINSTANCE.createJVModel();
	}

}
