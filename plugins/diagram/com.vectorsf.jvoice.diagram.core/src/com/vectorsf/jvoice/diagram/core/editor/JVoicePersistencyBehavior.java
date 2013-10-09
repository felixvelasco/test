package com.vectorsf.jvoice.diagram.core.editor;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.transaction.Transaction;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.impl.TransactionalEditingDomainImpl;
import org.eclipse.graphiti.ui.editor.DefaultPersistencyBehavior;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;

public class JVoicePersistencyBehavior extends DefaultPersistencyBehavior {

	public JVoicePersistencyBehavior(DiagramBehavior diagramBehavior) {
		super(diagramBehavior);
	}

	@Override
	protected Set<Resource> save(
			final TransactionalEditingDomain editingDomain,
			final Map<Resource, Map<?, ?>> saveOptions, IProgressMonitor monitor) {
		final Map<URI, Throwable> failedSaves = new HashMap<URI, Throwable>();
		final Set<Resource> savedResources = new HashSet<Resource>();
		final IWorkspaceRunnable wsRunnable = new IWorkspaceRunnable() {
			@Override
			public void run(final IProgressMonitor monitor)
					throws CoreException {

				final Runnable runnable = new Runnable() {
					@Override
					public void run() {
						Transaction parentTx;
						if (editingDomain != null
								&& (parentTx = ((TransactionalEditingDomainImpl) editingDomain)
										.getActiveTransaction()) != null) {
							do {
								if (!parentTx.isReadOnly()) {
									throw new IllegalStateException(
											"saveInWorkspaceRunnable() called from within a command (likely to produce deadlock)"); //$NON-NLS-1$
								}
							} while ((parentTx = ((TransactionalEditingDomainImpl) editingDomain)
									.getActiveTransaction().getParent()) != null);
						}

						final EList<Resource> resources = editingDomain
								.getResourceSet().getResources();
						// Copy list to an array to prevent
						// ConcurrentModificationExceptions
						// during the saving of the dirty resources
						Resource[] resourcesArray = new Resource[resources
								.size()];
						resourcesArray = resources.toArray(resourcesArray);
						for (int i = 0; i < resourcesArray.length; i++) {
							// In case resource modification tracking is
							// switched on,
							// we can check if a resource has been modified, so
							// that we only need to save
							// really changed resources; otherwise we need to
							// save all resources in the set
							final Resource resource = resourcesArray[i];
							/*
							 * Bug 371513 - Added check for isLoaded(): a
							 * resource that has not yet been loaded (possibly
							 * after a reload triggered by a change in another
							 * editor) has no content yet; saving such a
							 * resource will simply erase _all_ content from the
							 * resource on the disk (including the diagram). -->
							 * a not yet loaded resource must not be saved
							 */
							if ((!resource.isTrackingModification() || resource
									.isModified())
									&& resource.isLoaded()
									&& resource instanceof XMLResource) {
								try {
									resource.save(saveOptions.get(resource));
									savedResources.add(resource);
								} catch (final Throwable t) {
									failedSaves.put(resource.getURI(), t);
								}
							}
						}
					}
				};

				try {
					editingDomain.runExclusive(runnable);
				} catch (final InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		};
		try {
			ResourcesPlugin.getWorkspace().run(wsRunnable, null);
			if (!failedSaves.isEmpty()) {
				throw new WrappedException(createMessage(failedSaves),
						new RuntimeException());
			}
		} catch (final CoreException e) {
			final Throwable cause = e.getStatus().getException();
			if (cause instanceof RuntimeException) {
				throw (RuntimeException) cause;
			}
			throw new RuntimeException(e);
		}

		return savedResources;
	}

	private String createMessage(Map<URI, Throwable> failedSaves) {
		final StringBuilder buf = new StringBuilder(
				"The following resources could not be saved:"); //$NON-NLS-1$
		for (final Entry<URI, Throwable> entry : failedSaves.entrySet()) {
			buf.append("\nURI: ").append(entry.getKey().toString()).append(", cause: \n").append(getExceptionAsString(entry.getValue())); //$NON-NLS-1$ //$NON-NLS-2$
		}
		return buf.toString();
	}

	private String getExceptionAsString(Throwable t) {
		final StringWriter stringWriter = new StringWriter();
		final PrintWriter printWriter = new PrintWriter(stringWriter);
		t.printStackTrace(printWriter);
		final String result = stringWriter.toString();
		try {
			stringWriter.close();
		} catch (final IOException e) {
			// $JL-EXC$ ignore
		}
		printWriter.close();
		return result;
	}

}
