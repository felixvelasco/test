package com.vectorsf.jvoice.model.operations.provider.flow;

import java.util.Collection;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.vectorsf.jvoice.model.base.BasePackage;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.LocutionState;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDslFactory;

public class LocutionItemProvider extends TransientFlowItemProvider {

	public LocutionItemProvider(AdapterFactory adapterFactory, Flow supplier) {
		super(adapterFactory, supplier);
	}

	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(BasePackage.Literals.JV_PACKAGE__BEANS);
		}
		return childrenFeatures;
	}

	@Override
	public String getText(Object object) {
		return "locutions";
	}

	@Override
	public Object getImage(Object object) {
		return getResourceLocator().getImage("full/obj16/icon_nav_locutions.png");
	}

	@Override
	public Collection<?> getChildren(Object object) {
		Function<State, VoiceDsl> collectLocutions = new Function<State, VoiceDsl>() {

			@Override
			public VoiceDsl apply(State input) {
				if (input instanceof LocutionState) {
					VoiceDsl locution = ((LocutionState) input).getLocution();
					if (locution.eIsProxy()) {
						locution = (VoiceDsl) EcoreUtil.resolve(locution, input);
					}
					return locution;
				}
				return null;
			};
		};
		return Collections2.filter(Collections2.transform(getFlow().getStates(), collectLocutions),
				Predicates.<Object> notNull());
	}

	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
		newChildDescriptors.add(createChildParameter(BasePackage.Literals.JV_PACKAGE__BEANS,
				VoiceDslFactory.eINSTANCE.createMenuDsl()));
		newChildDescriptors.add(createChildParameter(BasePackage.Literals.JV_PACKAGE__BEANS,
				VoiceDslFactory.eINSTANCE.createInputDsl()));
		newChildDescriptors.add(createChildParameter(BasePackage.Literals.JV_PACKAGE__BEANS,
				VoiceDslFactory.eINSTANCE.createPromptDsl()));
	}

	@Override
	protected Command createDragAndDropCommand(EditingDomain domain, Object owner, float location, int operations,
			int operation, Collection<?> collection) {
		if (new AddCommand(domain, (EObject) owner, BasePackage.Literals.JV_PACKAGE__BEANS, collection).canExecute()) {
			return super.createDragAndDropCommand(domain, owner, location, operations, operation, collection);
		}
		return UnexecutableCommand.INSTANCE;
	}

}