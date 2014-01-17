package com.vectorsf.jvoice.model.operations.provider.flow;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.AttributeValueWrapperItemProvider;

import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.OperationsPackage;

public class ParametersItemProvider extends TransientFlowItemProvider {

	public ParametersItemProvider(AdapterFactory adapterFactory, Flow supplier) {
		super(adapterFactory, supplier);
	}

	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(OperationsPackage.Literals.FLOW__PARAMETERS);
		}
		return childrenFeatures;
	}

	@Override
	public String getText(Object object) {
		return "parameters";
	}

	@Override
	public Object getImage(Object object) {
		return getResourceLocator().getImage("full/obj16/icon_nav_parameters.png");
	}

	@Override
	protected Object createWrapper(EObject object, EStructuralFeature feature, Object value, int index) {
		if (feature == OperationsPackage.Literals.FLOW__PARAMETERS) {
			value = new AttributeValueWrapperItemProvider(value, object, (EAttribute) feature, index, adapterFactory,
					getResourceLocator()) {
				@Override
				public Object getImage(Object object) {
					return getResourceLocator().getImage("full/obj16/icon_nav_parameter.png");
				}
			};
			return value;
		}
		return super.createWrapper(object, feature, value, index);

	}
}