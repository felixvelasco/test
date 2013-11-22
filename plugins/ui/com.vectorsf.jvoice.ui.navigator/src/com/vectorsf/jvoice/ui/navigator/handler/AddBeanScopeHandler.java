package com.vectorsf.jvoice.ui.navigator.handler;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import com.vectorsf.jvoice.core.uri.VegaXMLURIHandlerImpl;
import com.vectorsf.jvoice.model.operations.ComponentBean;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.provider.flow.ScopeItemProvider;

public class AddBeanScopeHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		Flow flow = getFlow(event);
		if (flow == null) {
			return null;
		}

		IProject project = getProject(flow);
		Shell shell = HandlerUtil.getActiveShell(event);

		BeanScopeAddDialog dialog = new BeanScopeAddDialog(shell, (IPackageFragment) findPackage(flow, project));
		if (dialog.open() == Window.OK) {
			try {
				addScopedBean(flow, dialog.getComponentBean());
			} catch (IOException e) {
				throw new ExecutionException("Error saving " + flow.getName(), e);
			}
		}

		return null;
	}

	private void addScopedBean(Flow flow, ComponentBean bean) throws IOException {
		URI uri = EcoreUtil.getURI(flow);
		ResourceSet resourceSet = new ResourceSetImpl();
		VegaXMLURIHandlerImpl vegaURIHandler = new VegaXMLURIHandlerImpl();
		resourceSet.getLoadOptions().put(XMLResource.OPTION_URI_HANDLER, vegaURIHandler);
		Flow persistedFlow = (Flow) resourceSet.getEObject(uri, true);

		persistedFlow.getBeans().add(bean);
		persistedFlow.eResource().save(null);
	}

	@SuppressWarnings("restriction")
	private IJavaElement findPackage(Flow flow, IProject project) {
		org.eclipse.jdt.internal.core.JavaProject javaProject = (org.eclipse.jdt.internal.core.JavaProject) JavaCore
				.create(project);
		try {
			return javaProject.findPackageFragment(flow.getOwnerPackage().getOwnerModule().getComponentsPackage());
		} catch (JavaModelException e) {
			return null;
		}
	}

	private IProject getProject(Flow flow) {
		URI uri = flow.eResource().getURI();
		IPath path = new Path(uri.toPlatformString(true));
		return ResourcesPlugin.getWorkspace().getRoot().getFile(path).getProject();
	}

	private Flow getFlow(ExecutionEvent event) {
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if (currentSelection instanceof IStructuredSelection) {
			Object firstElement = ((IStructuredSelection) currentSelection).getFirstElement();
			if (firstElement instanceof ScopeItemProvider) {
				return ((ScopeItemProvider) firstElement).getFlow();
			}
		}

		return null;
	}

}
