package com.vectorsf.jvoice.ui.project.editor;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;

import com.google.inject.Inject;
import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.ui.project.editor.ui.provider.LabelProviderGen;

/**
 * Extends LabelProviderGen to manage label texts when JVBeans's owner package cannot be resolved.
 * 
 * @author idafereyes
 * 
 */
public class ProjectEditorLabelProvider extends LabelProviderGen {

	@Inject
	public ProjectEditorLabelProvider(AdapterFactoryLabelProvider delegate) {
		super(delegate);
	}

	@Override
	public String text(JVBean it) {

		if (it.getOwnerPackage() != null) {
			return super.text(it);
		}

		// When owner package is null we need to get the flow name from resouce uri.
		URI uri = it.eResource().getURI();
		// Creates a platform resource URI with the path where flows should be to use it as a base path.
		URI baseURI = URI.createPlatformResourceURI(getProjectName(uri) + "/" + BaseModel.JV_PATH + "/", true);
		// Takes the flow name including its package without its file extension.
		URI deresolvedURI = uri.deresolve(baseURI).trimFileExtension();

		// Replaces dots for slashes to show it at the editor.
		return deresolvedURI.toString().replace("/", ".");

	}

	private String getProjectName(URI uri) {
		return uri.segment(1);
	}
}
