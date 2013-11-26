package com.vectorsf.jvoice.ui.project.editor;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.RemoveCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.parsley.factories.TableFormFactory;
import org.eclipse.emf.parsley.widgets.TableFormComposite;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import com.vectorsf.jvoice.model.base.BaseFactory;
import com.vectorsf.jvoice.model.base.BasePackage;
import com.vectorsf.jvoice.model.base.EventHandler;
import com.vectorsf.jvoice.model.base.JVProject;

public class EventsHandlerComposite extends Composite {

	private FormToolkit toolkit;
	private ScrolledForm scrolledForm;
	private Composite mainComposite;
	private TableFormComposite tableFormDetailComposite;
	private TableFormFactory tableFormFactory;

	private RemoveAction removeAction;

	public EventsHandlerComposite(Composite parent, int style, TableFormFactory tableFormFactory) {
		super(parent, style);
		this.tableFormFactory = tableFormFactory;
		toolkit = new FormToolkit(parent.getDisplay());
		toolkit.adapt(this);
	}

	public void init(JVProject project) {
		createScrolledForm();
		setActions(project);

		tableFormDetailComposite = tableFormFactory.createTableFormMasterDetailComposite(mainComposite, SWT.NONE,
				BasePackage.eINSTANCE.getEventHandler());
		tableFormDetailComposite.setLayoutData(new GridData(GridData.FILL_BOTH));
		tableFormDetailComposite.update(project.getHandlers());

		tableFormDetailComposite.getViewer().addSelectionChangedListener(new RemoveButtonListener());
	}

	private void createScrolledForm() {
		// toolkit.paintBordersFor(this);
		setLayout(new GridLayout(1, false));

		scrolledForm = toolkit.createScrolledForm(this);
		// make sure that the form takes all the space
		scrolledForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		scrolledForm.getBody().setLayout(new GridLayout());
		scrolledForm.setText("Event handlers");

		mainComposite = scrolledForm.getBody();
	}

	private void setActions(JVProject project) {
		IToolBarManager toolBarManager = scrolledForm.getToolBarManager();
		toolBarManager.add(new AddAction(project));
		removeAction = new RemoveAction(project);
		removeAction.setEnabled(false);
		toolBarManager.add(removeAction);

		toolBarManager.update(true);
	}

	@Override
	public boolean setFocus() {
		return tableFormDetailComposite.setFocus();
	}

	public class RemoveButtonListener implements ISelectionChangedListener {

		@Override
		public void selectionChanged(SelectionChangedEvent event) {
			ISelection selection = event.getSelection();
			if (selection instanceof IStructuredSelection) {
				removeAction.setEnabled(!selection.isEmpty());
				removeAction.setSelection(((IStructuredSelection) selection).getFirstElement());
			}
		}

	}

	public class AddAction extends Action {

		private JVProject project;

		public AddAction(JVProject project) {
			super("Add");
			this.project = project;
		}

		@Override
		public void run() {
			EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(project);
			EventHandler newHandler = BaseFactory.eINSTANCE.createEventHandler();
			Command command = AddCommand.create(editingDomain, project, BasePackage.eINSTANCE.getJVProject_Handlers(),
					newHandler);

			editingDomain.getCommandStack().execute(command);

			tableFormDetailComposite.getViewer().refresh();
		}
	}

	private final class RemoveAction extends Action {
		private JVProject project;
		private Object selectedHandler;

		public RemoveAction(JVProject project) {
			super("Remove");
			this.project = project;
		}

		public void setSelection(Object selectedHandler) {
			this.selectedHandler = selectedHandler;
		}

		@Override
		public void run() {
			EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(project);
			Command command = RemoveCommand.create(editingDomain, project,
					BasePackage.eINSTANCE.getJVProject_Handlers(), selectedHandler);

			editingDomain.getCommandStack().execute(command);

			tableFormDetailComposite.getViewer().refresh();
		}
	}
}
