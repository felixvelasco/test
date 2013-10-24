package com.vectorsf.jvoice.core.factory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.RegistryFactory;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;

public class JVBeanFactoryManager {

	private static final String BUNDLE_ID = "com.vectorsf.jvoice.core.reconciliator";
	private static final String FACTORY_EXTENSION_POINT_NAME = "factory";
	private static final String CLASS_ATTRIBUTE = "class";
	private static final String EXTENSION_ATTRIBUTE = "extension";
	private Collection<IConfigurationElement> elements;

	private static final JVBeanFactoryManager INSTANCE = new JVBeanFactoryManager();
	private LoadingCache<String, JVBeanFactory> extension2factory;
	private Map<String, IConfigurationElement> extension2element;

	public static JVBeanFactoryManager getInstance() {
		return INSTANCE;
	}

	public JVBeanFactory getFactory(String extension) {
		try {
			return extension2factory.get(extension);
		} catch (ExecutionException e) {
			e.getCause().printStackTrace();
		}
		return null;
	}

	private JVBeanFactoryManager() {
		extension2factory = CacheBuilder.newBuilder().build(new CacheLoader<String, JVBeanFactory>() {
			@Override
			public JVBeanFactory load(String key) throws CoreException {
				return (JVBeanFactory) extension2element.get(key).createExecutableExtension(CLASS_ATTRIBUTE);
			}
		});
		elements = new ArrayList<>();
		extension2element = Maps.newHashMap();
		readConfiguration();
	}

	private void readConfiguration() {
		final IConfigurationElement[] configurationElements = RegistryFactory.getRegistry()
				.getConfigurationElementsFor(BUNDLE_ID, FACTORY_EXTENSION_POINT_NAME);

		for (IConfigurationElement element : configurationElements) {
			extension2element.put(element.getAttribute(EXTENSION_ATTRIBUTE), element);
		}
		Collections.addAll(elements, configurationElements);
	}

}
