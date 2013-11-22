package com.vectorsf.jvoice.model.operations.provider.ext;

import org.eclipse.emf.common.notify.Adapter;

import com.vectorsf.jvoice.model.operations.provider.OperationsItemProviderAdapterFactory;

public class ExtOperationsItemProviderAdapterFactory extends OperationsItemProviderAdapterFactory {

	@Override
	public Adapter createFlowAdapter() {
		return new ExtFlowItemProvider(this);
	}

	@Override
	public Adapter createComponentBeanAdapter() {
		if (componentBeanItemProvider == null) {
			componentBeanItemProvider = new ExtComponentBeanItemProvider(this);
		}

		return componentBeanItemProvider;
	}

	@Override
	public Adapter createInitialStateAdapter() {
		if (initialStateItemProvider == null) {
			initialStateItemProvider = new ExtInitialStateItemProvider(this);
		}

		return initialStateItemProvider;
	}

	@Override
	public Adapter createSwitchStateAdapter() {
		if (switchStateItemProvider == null) {
			switchStateItemProvider = new ExtSwitchStateItemProvider(this);
		}

		return switchStateItemProvider;
	}

	@Override
	public Adapter createFinalStateAdapter() {
		if (finalStateItemProvider == null) {
			finalStateItemProvider = new ExtFinalStateItemProvider(this);
		}

		return finalStateItemProvider;
	}
}
