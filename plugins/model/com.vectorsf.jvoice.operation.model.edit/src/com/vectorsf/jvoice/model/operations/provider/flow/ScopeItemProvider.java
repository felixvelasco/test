package com.vectorsf.jvoice.model.operations.provider.flow;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.OperationsFactory;
import com.vectorsf.jvoice.model.operations.OperationsPackage;

public class ScopeItemProvider extends TransientFlowItemProvider {

	public ScopeItemProvider(AdapterFactory adapterFactory, Flow supplier) {
		super(adapterFactory, supplier);
	}

	@Override
	public String getText(Object object) {
		return "scope";
	}

	@Override
	public Object getImage(Object object) {
		return getResourceLocator().getImage("full/obj16/icon_nav_beans.png");
	}

	@Override
	protected Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			childrenFeatures = new ArrayList<>();
			childrenFeatures.add(OperationsPackage.Literals.FLOW__BEANS);
		}
		return childrenFeatures;
	}

	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
		newChildDescriptors.add(createChildParameter(OperationsPackage.Literals.FLOW__BEANS,
				OperationsFactory.eINSTANCE.createComponentBean()));
	}

	@Override
	protected Command createDragAndDropCommand(EditingDomain domain, Object owner, float location, int operations,
			int operation, Collection<?> collection) {
		if (new AddCommand(domain, (EObject) owner, OperationsPackage.Literals.FLOW__BEANS, collection).canExecute()) {
			return super.createDragAndDropCommand(domain, owner, location, operations, operation, collection);
		}
		return UnexecutableCommand.INSTANCE;
	}

}