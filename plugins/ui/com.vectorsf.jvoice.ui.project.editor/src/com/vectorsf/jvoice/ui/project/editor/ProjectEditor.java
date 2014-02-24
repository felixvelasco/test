package com.vectorsf.jvoice.ui.project.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.parsley.editors.EmfAbstractEditor;
import org.eclipse.emf.parsley.factories.FormFactory;
import org.eclipse.emf.parsley.factories.TableFormFactory;
import org.eclipse.emf.parsley.resource.LoadResourceResponse;
import org.eclipse.emf.parsley.widgets.FormDetailComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;

import com.google.inject.Inject;
import com.vectorsf.jvoice.model.base.JVProject;

public class ProjectEditor extends EmfAbstractEditor {

	@Inject
	private FormFactory formFactory;

	@Inject
	private TableFormFactory tableFormFactory;

	private EventsHandlerComposite eventsComposite;

	@Override
	protected void createPages() {

		IEditorInput editorInput = getEditorInput();
		IFile file = (IFile) editorInput.getAdapter(IFile.class);

		URI resourceURI = URI.createPlatformResourceURI(file.getProject().getFile(".projectInformation").getFullPath()
				.toString(), true);
		LoadResourceResponse response = resourceLoader.getResource(editingDomain, resourceURI);
		JVProject project = (JVProject) response.getResource().getContents().get(0);
		EcoreUtil.resolveAll(project);

		Composite parent = getContainer();

		FormDetailComposite formComposite = formFactory.createFormDetailComposite(parent, SWT.NONE);
		formComposite.init(project);

		eventsComposite = new EventsHandlerComposite(parent, SWT.NONE, tableFormFactory);
		eventsComposite.init(project);

		parent.layout(true, true);

		int pageIndex = addPage(formComposite);
		setPageText(pageIndex, "Project");

		pageIndex = addPage(eventsComposite);
		setPageText(pageIndex, "Event handlers");

		setActivePage(0);

		// Ensures that this editor will only display the page's tab
		// area if there are more than one page
		//
		getContainer().addControlListener(new ControlAdapter() {
			boolean guard = false;

			@Override
			public void controlResized(ControlEvent event) {
				if (!guard) {
					guard = true;
					hideTabs();
					guard = false;
				}
			}
		});
	}

	@Override
	public void init(IEditorSite site, IEditorInput editorInput) {
		super.init(site, editorInput);

		IFile file = (IFile) editorInput.getAdapter(IFile.class);
		setPartName(file.getProject().getName());

	}

	@Override
	public void setFocus() {
		eventsComposite.setFocus();
	}

}
