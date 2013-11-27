package com.vectorsf.jvoice.model.operations.provider.flow;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EStructuralFeature;

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
		return super.getImage(object);
		// return getResourceLocator().getImage("full/obj16/icon_nav_parameters.png");
	}

}