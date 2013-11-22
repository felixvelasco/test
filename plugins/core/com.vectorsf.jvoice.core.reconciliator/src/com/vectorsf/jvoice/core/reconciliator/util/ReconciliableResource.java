package com.vectorsf.jvoice.core.reconciliator.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;

import com.vectorsf.jvoice.core.reconciliator.JVoiceModelReconcilier;
import com.vectorsf.jvoice.model.base.JVModule;
import com.vectorsf.jvoice.model.base.JVProject;

public class ReconciliableResource extends XMIResourceImpl {

	public ReconciliableResource(URI uri) {
		super(uri);
		getDefaultLoadOptions().put(OPTION_RESOURCE_HANDLER, new ReconciliableHandler());
	}

	public class ReconciliableHandler implements ResourceHandler {

		@Override
		public void preLoad(XMLResource resource, InputStream inputStream, Map<?, ?> options) {

		}

		@Override
		public void postLoad(XMLResource resource, InputStream inputStream, Map<?, ?> options) {
			IPath path = new Path(uri.toPlatformString(true));
			final IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IProject project = workspace.getRoot().findMember(path).getProject();
			EObject content = getContents().get(0);
			if (content instanceof JVModule) {
				JVoiceModelReconcilier.getInstance().addPackages(project, (JVModule) content, getResourceSet());
			}
			if (content instanceof JVProject) {
				JVoiceModelReconcilier.getInstance().addConfiguration(project, (JVProject) content);
			}
		}

		@Override
		public void preSave(XMLResource resource, OutputStream outputStream, Map<?, ?> options) {

		}

		@Override
		public void postSave(XMLResource resource, OutputStream outputStream, Map<?, ?> options) {

		}

	}
}
