package com.vectorsf.jvoice.base.model.internal.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.RegistryFactory;
import org.eclipse.emf.common.EMFPlugin;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.base.model.service.JVModelLifecycleListener;

public class ListenersManager {
	public static final String BUNDLE_ID = "com.vectorsf.jvoice.base.model";
	private static final String LISTENER_EXTENSION_POINT_NAME = "listener";
	private static final String CLASS_ATTRIBUTE = "class";
	private static final String PRIORITY_ATTRIBUTE = "priority";

	
	private static Set<IConfigurationElement> elements;
	private static Map<IConfigurationElement, JVModelLifecycleListener> listenersCache;
	
	public static void init() {
		elements = new TreeSet<>(new Sorter());
		listenersCache = new HashMap<>();
		if (EMFPlugin.IS_ECLIPSE_RUNNING) {
			readConfiguration();
			notifyCreation();
		}
	}
	
	private static void notifyCreation() {
		for (IConfigurationElement element : elements) {
			JVModelLifecycleListener listener = getListener(element);
			if (listener != null) {
				listener.modelCreated(BaseModel.getInstance());
			}
		}
	}

	private static JVModelLifecycleListener getListener(IConfigurationElement element) {
		JVModelLifecycleListener listener = listenersCache.get(element);
		if (listener == null) {
			try {
				listener = (JVModelLifecycleListener) element.createExecutableExtension(CLASS_ATTRIBUTE);
			} catch (CoreException e) {
			}
			listenersCache.put(element, listener);
		}
		return listener;
	}
	
	private static void readConfiguration() {

		final IConfigurationElement[] configurationElements = RegistryFactory.getRegistry()
				.getConfigurationElementsFor(BUNDLE_ID, LISTENER_EXTENSION_POINT_NAME);

		Collections.addAll(elements, configurationElements);
	}
	
	private static class Sorter implements Comparator<IConfigurationElement> {

		@Override
		public int compare(IConfigurationElement element1, IConfigurationElement element2) {
			int p1 = getPriority(element1);
			int p2 = getPriority(element2);

			if (p1 != p2) {
				return p2 - p1;
			} else {
				return element2.hashCode() - element1.hashCode();
			}
		}

		private int getPriority(IConfigurationElement element) {
			String sPriority = element.getAttribute(PRIORITY_ATTRIBUTE);
			int priority = 500;
			if (sPriority != null) {
				try {
					priority = Integer.valueOf(sPriority);
				} catch (NumberFormatException nfe) {
				}
			}
			return priority;
		}

	}

}
