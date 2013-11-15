package com.vectorsf.jvoice.ui.project.editor;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.parsley.resource.EmptyResourceInitializer;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.model.base.BaseFactory;
import com.vectorsf.jvoice.model.base.EventHandler;
import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVModule;
import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.base.JVProject;
import com.vectorsf.jvoice.model.operations.Flow;

public class ProjectEditorEmptyResourceInitializer extends EmptyResourceInitializer {
	@Override
	public void initialize(Resource resource) {
		URI uri = resource.getURI();
		if (uri.fileExtension().equals("projectInformation")) {
			ResourceSet resourceSet = resource.getResourceSet();
			IPath path = new Path(uri.toPlatformString(true));
			JVProject project = BaseModel.getInstance().getModel().getProject(path.segment(0));
			JVProject newProject = EcoreUtil.copy(project);

			newProject.getConfiguration().clear();
			if (newProject instanceof JVModule) {
				((JVModule) newProject).getPackages().clear();
				int i = 0;
				String[] mensaje = new String[] { "Sabes que si", "Es lo que tiene", "Tu si que vales",
						"Truño cataluño", "Sopas con ondas" };
				for (JVPackage pck : ((JVModule) project).getPackages()) {
					for (JVBean bean : pck.getBeans()) {
						if (bean instanceof Flow) {
							EventHandler eventHandler = BaseFactory.eINSTANCE.createEventHandler();
							eventHandler.setEvent(mensaje[i++]);
							JVBean eObject = (JVBean) resourceSet.getEObject(EcoreUtil.getURI(bean), true);
							eventHandler.setHandler(eObject);

							newProject.getHandlers().add(eventHandler);
						}
					}
				}
			}
			resource.getContents().add(newProject);

		}
		super.initialize(resource);
	}
}
