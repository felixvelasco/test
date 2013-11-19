package com.vectorsf.jvoice.model.operations.provider.flow;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CommandWrapper;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.CommandParameter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.provider.CoreOperationsEditPlugin;

/**
 * The base implementation for the non-modeled children.
 */
public class TransientFlowItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {

	private Flow flow;

	public TransientFlowItemProvider(AdapterFactory adapterFactory, Flow flow) {
		super(adapterFactory);
		flow.eAdapters().add(this);
		this.flow = flow;
	}

	@Override
	public Collection<?> getChildren(Object object) {
		return super.getChildren(flow);
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

	protected Flow getFlow() {
		return flow;
	}
}