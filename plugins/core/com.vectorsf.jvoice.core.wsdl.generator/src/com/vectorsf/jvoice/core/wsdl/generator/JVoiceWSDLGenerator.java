package com.vectorsf.jvoice.core.wsdl.generator;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.core.wsdl.generator.listener.WSDLResourceChangeListener;

public class JVoiceWSDLGenerator {

	private static JVoiceWSDLGenerator instance = new JVoiceWSDLGenerator();
	
	private JVoiceWSDLGenerator() {

	}

	public static JVoiceWSDLGenerator getInstance() {
		return instance;
	}

	public void create(BaseModel baseModel) {

		final IWorkspace workspace = ResourcesPlugin.getWorkspace();

//		for (IProject project : workspace.getRoot().getProjects()) {
//			try {
//				if (project.isOpen() && project.hasNature(JVoiceApplicationNature.NATURE_ID)) {
//					baseModel.getModel().getProjects().add(createApplication(project));
//				} else if (project.isOpen() && project.hasNature(JVoiceModuleNature.NATURE_ID)) {
//					baseModel.getModel().getProjects().add(createProject(project));
//				}
//			} catch (CoreException e) {
//				// CoreException is only launched on closed or non-existing projects, and we are guarded against both
//				// conditions
//			}
//		}

		workspace.addResourceChangeListener(new WSDLResourceChangeListener());
	}

}
