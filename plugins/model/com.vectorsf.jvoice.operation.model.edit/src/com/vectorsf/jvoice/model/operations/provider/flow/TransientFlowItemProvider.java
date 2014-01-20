package com.vectorsf.jvoice.model.operations.provider.flow;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.ui.IEditorMatchingStrategy;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.EditorReference;
import org.eclipse.ui.internal.PartSite;

import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.OperationsPackage;
import com.vectorsf.jvoice.model.operations.provider.CoreOperationsEditPlugin;

/**
 * The base implementation for the non-modeled children.
 */
public class TransientFlowItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {

	private Flow flow;
	private PartAdapter adapter;

	public TransientFlowItemProvider(AdapterFactory adapterFactory, Flow flow) {
		super(adapterFactory);
		flow.eAdapters().add(this);
		this.flow = flow;
		this.adapter = new PartAdapter();

		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		activePage.addPartListener(adapter);
	}

	@Override
	public Collection<?> getChildren(Object object) {
		return super.getChildren(getLiveFlow());
	}

	public Flow getLiveFlow() {
		URI uri = EcoreUtil.getURI(flow);
		IEditorPart editor = findEditor(uri);

		if (editor == null || !(editor instanceof IEditingDomainProvider)) {
			return flow;
		} else if (editor instanceof IEditingDomainProvider) {
			IEditingDomainProvider provider = (IEditingDomainProvider) editor;
			EditingDomain editingDomain = provider.getEditingDomain();
			ResourceSet rSet = editingDomain.getResourceSet();
			Flow liveFlow = (Flow) rSet.getEObject(uri, true);

			if (!liveFlow.eAdapters().contains(this)) {
				liveFlow.eAdapters().add(this);
				targets.add(liveFlow);
			}

			return liveFlow;
		}
		return null;
	}

	@Override
	public Collection<?> getNewChildDescriptors(Object object, EditingDomain editingDomain, Object sibling) {
		return super.getNewChildDescriptors(target, editingDomain, sibling);
	}

	@Override
	public Object getParent(Object object) {
		return target;
	}

	@Override
	public Object getImage(Object object) {
		return getResourceLocator().getImage("full/obj16/folder");
	}

	@Override
	public ResourceLocator getResourceLocator() {
		return CoreOperationsEditPlugin.INSTANCE;
	}

	@Override
	public Command createCommand(final Object object, final EditingDomain domain,
			Class<? extends Command> commandClass, CommandParameter commandParameter) {
		commandParameter.setOwner(target);
		return super.createCommand(target, domain, commandClass, commandParameter);
	}

	@Override
	protected Command createRemoveCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Collection<?> collection) {
		return createWrappedCommand(super.createRemoveCommand(domain, owner, feature, collection), owner);
	}

	@Override
	protected Command createAddCommand(EditingDomain domain, EObject owner, EStructuralFeature feature,
			Collection<?> collection, int index) {
		return createWrappedCommand(super.createAddCommand(domain, owner, feature, collection, index), owner);
	}

	protected Command createWrappedCommand(Command command, final EObject owner) {
		return new CommandWrapper(command) {
			@Override
			public Collection<?> getAffectedObjects() {
				Collection<?> affected = super.getAffectedObjects();
				if (affected.contains(owner)) {
					affected = Collections.singleton(TransientFlowItemProvider.this);
				}
				return affected;
			}
		};
	}

	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Flow.class)) {
		case OperationsPackage.FLOW__PARAMETERS:
		case OperationsPackage.FLOW__STATES:
		case OperationsPackage.FLOW__BEANS:
			fireNotifyChanged(new ViewerNotification(notification, flow, true, false));
			return;
		}
		super.notifyChanged(notification);
	}

	public Flow getFlow() {
		return flow;
	}

	@Override
	public void dispose() {
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		activePage.removePartListener(adapter);
		super.dispose();
	}

	private IEditorPart findEditor(URI uri) {
		URIEditorInput input = new URIEditorInput(uri);
		return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findEditor(input);
	}

	private class PartAdapter implements IPartListener {

		@Override
		public void partActivated(IWorkbenchPart part) {
		}

		@Override
		public void partBroughtToTop(IWorkbenchPart part) {
		}

		@SuppressWarnings("restriction")
		@Override
		public void partClosed(IWorkbenchPart part) {
			if (part instanceof IEditorPart && part instanceof IEditingDomainProvider) {
				IWorkbenchPartReference partRef = ((PartSite) part.getSite()).getPartReference();
				URI uri = EcoreUtil.getURI(flow);
				EditorReference editorReference = (EditorReference) partRef;
				IEditorMatchingStrategy editorMatchingStrategy = editorReference.getDescriptor()
						.getEditorMatchingStrategy();
				if (editorMatchingStrategy != null
						&& editorMatchingStrategy.matches(editorReference, new URIEditorInput(uri))) {
					fireNotifyChanged(new ViewerNotification(null, flow, true, false));
				}
			}
		}

		@Override
		public void partDeactivated(IWorkbenchPart part) {
		}

		@Override
		public void partOpened(IWorkbenchPart part) {
			if (part instanceof IEditorPart && part instanceof IEditingDomainProvider) {
				URI uri = EcoreUtil.getURI(flow);
				if (part == findEditor(uri)) {
					fireNotifyChanged(new ViewerNotification(null, flow, true, false));
				}
			}
		}

	}
}