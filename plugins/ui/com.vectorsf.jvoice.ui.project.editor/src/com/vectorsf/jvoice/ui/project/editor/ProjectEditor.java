package com.vectorsf.jvoice.ui.project.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.parsley.editors.EmfAbstractEditor;
import org.eclipse.emf.parsley.factories.FormFactory;
import org.eclipse.emf.parsley.factories.TableFormFactory;
import org.eclipse.emf.parsley.resource.LoadResourceResponse;
import org.eclipse.emf.parsley.widgets.FormDetailComposite;
import org.eclipse.emf.parsley.widgets.TableFormComposite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;

import com.google.inject.Inject;
import com.vectorsf.jvoice.model.base.BaseFactory;
import com.vectorsf.jvoice.model.base.BasePackage;
import com.vectorsf.jvoice.model.base.EventHandler;
import com.vectorsf.jvoice.model.base.JVProject;

public class ProjectEditor extends EmfAbstractEditor {

	@Inject
	private FormFactory formFactory;

	@Inject
	private TableFormFactory tableFormFactory;

	protected Composite parent;
	protected FormDetailComposite formComposite;
	private TableFormComposite tableFormDetailComposite;
	private Composite parentComposite;

	@Override
	protected void createPages() {

		IEditorInput editorInput = getEditorInput();
		IFile file = (IFile) editorInput.getAdapter(IFile.class);

		URI resourceURI = URI.createPlatformResourceURI(file.getProject().getFile(".projectInformation").getFullPath()
				.toString(), true);
		LoadResourceResponse response = resourceLoader.getResource(editingDomain, resourceURI);
		JVProject project = (JVProject) response.getResource().getContents().get(0);
		EcoreUtil.resolveAll(project);

		parent = getContainer();

		formComposite = formFactory.createFormDetailComposite(parent, SWT.NONE);
		formComposite.init(project);

		parentComposite = new Composite(parent, SWT.NONE);
		parentComposite.setLayout(new GridLayout());

		Composite buttonComposite = new Composite(parentComposite, SWT.NONE);
		buttonComposite.setLayout(new GridLayout(2, false));
		buttonComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Button addButton = new Button(buttonComposite, SWT.NONE);
		addButton.setText("Add new handler");
		addButton.addSelectionListener(new AddButtonSelectionListener(project));

		tableFormDetailComposite = tableFormFactory.createTableFormMasterDetailComposite(parentComposite, SWT.NONE,
				BasePackage.eINSTANCE.getEventHandler());
		tableFormDetailComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
		tableFormDetailComposite.update(project.getHandlers());

		parent.layout(true, true);

		int pageIndex = addPage(formComposite);
		setPageText(pageIndex, "Project");

		pageIndex = addPage(parentComposite);
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

		// updateProblemIndication();
	}

	@Override
	public void init(IEditorSite site, IEditorInput editorInput) {
		super.init(site, editorInput);

		IFile file = (IFile) editorInput.getAdapter(IFile.class);
		setPartName(file.getProject().getName());

	}

	@Override
	public void setFocus() {
		tableFormDetailComposite.setFocus();
	}

	private final class AddButtonSelectionListener extends SelectionAdapter {
		private JVProject project;

		public AddButtonSelectionListener(JVProject project) {
			this.project = project;
		}

		@Override
		public void widgetSelected(SelectionEvent e) {
			EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(project);
			EventHandler newHandler = BaseFactory.eINSTANCE.createEventHandler();
			Command command = AddCommand.create(editingDomain, project, BasePackage.eINSTANCE.getJVProject_Handlers(),
					newHandler);

			editingDomain.getCommandStack().execute(command);

			tableFormDetailComposite.getViewer().refresh();
		}
	}

}
