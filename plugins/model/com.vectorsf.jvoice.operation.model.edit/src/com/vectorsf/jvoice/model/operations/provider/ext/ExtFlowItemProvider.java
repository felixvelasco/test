package com.vectorsf.jvoice.model.operations.provider.ext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;

import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.provider.FlowItemProvider;

public class ExtFlowItemProvider extends FlowItemProvider {

	private List<Object> children;

	public ExtFlowItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		String label = ((Flow) object).getName();
		return label;
	}

	@Override
	public Object getImage(Object object) {
		return getResourceLocator().getImage("full/obj16/Flow.png");
	}

	@Override
	public Collection<?> getChildren(Object object) {
		if (children == null) {
			Flow flow = (Flow) object;
			children = new ArrayList<>();
			children.add(new LocutionItemProvider(adapterFactory, flow));
			// children.add(new ContextItemProvider(adapterFactory, flow));
			// children.add(new CustomPageItemProvider(adapterFactory, flow));
		}
		return children;
	}
}
