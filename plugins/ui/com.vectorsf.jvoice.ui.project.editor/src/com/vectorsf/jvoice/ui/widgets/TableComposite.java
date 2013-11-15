package com.vectorsf.jvoice.ui.widgets;

import java.util.List;

import org.eclipse.emf.common.ui.viewer.IViewerProvider;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.parsley.builders.TableViewerBuilder;
import org.eclipse.emf.parsley.viewers.ViewerInitializer;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;

import com.google.inject.Inject;

/**
 * A generic composite with a Table
 * 
 * @author Francesco Guidieri
 * 
 */
public class TableComposite extends Composite implements IViewerProvider {

	private TableViewerBuilder tableViewerBuilder;
	private TableViewer tableViewer;
	private boolean autoBuild;

	protected ViewerInitializer viewerInitializer;

	public TableComposite(Composite parent, int style, boolean autoBuild) {
		super(parent, style);
		this.autoBuild = autoBuild;
		createViewer(parent);
	}

	public TableComposite(Composite parent, int style) {
		this(parent, style, false);
	}

	protected StructuredViewer createViewer(Composite parent) {
		tableViewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
		return tableViewer;
	}

	public void buildTable(EClass type, IStructuredContentProvider contentProvider) {
		removeExistingColumns();
		tableViewerBuilder.build(tableViewer, type, contentProvider);
	}

	public TableViewerBuilder getTableViewerBuilder() {
		return tableViewerBuilder;
	}

	@Inject
	public void setTableViewerBuilder(TableViewerBuilder tableViewerBuilder) {
		this.tableViewerBuilder = tableViewerBuilder;
	}

	public void update(Object input) {
		if (autoBuild) {
			removeExistingColumns();
		}
		if (input instanceof List) {
			final List<?> elements = (List<?>) input;
			IStructuredContentProvider contentProvider = new ArrayContentProvider();
			if (elements.size() > 0) {
				EObject eObject = (EObject) elements.get(0);
				tableViewerBuilder.build(tableViewer, eObject.eClass(), contentProvider);
				tableViewer.setContentProvider(contentProvider);
				// TODO
				PlatformUI.getWorkbench().getDisplay().asyncExec(new Runnable() {
					@Override
					public void run() {
						tableViewer.setInput(elements);
					}
				});
			} else {
				viewerInitializer.initialize(tableViewer, input, contentProvider, null);
			}
		}
	}

	private void removeExistingColumns() {
		for (int i = tableViewer.getTable().getColumns().length; i > 0; i--) {
			tableViewer.getTable().getColumns()[i - 1].dispose();
		}
		tableViewer.getTable().pack();
	}

	public void buildTable(EClass eType) {
		buildTable(eType, new ArrayContentProvider());
	}

	public ViewerInitializer getViewerInitializer() {
		return viewerInitializer;
	}

	@Inject
	public void setViewerInitializer(ViewerInitializer viewerInitializer) {
		this.viewerInitializer = viewerInitializer;
	}

	@Override
	public Viewer getViewer() {
		return tableViewer;
	}
}
