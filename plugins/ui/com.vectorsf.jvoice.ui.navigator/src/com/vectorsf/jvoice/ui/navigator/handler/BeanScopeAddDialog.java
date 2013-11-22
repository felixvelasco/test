package com.vectorsf.jvoice.ui.navigator.handler;

import org.eclipse.jdt.core.IAnnotation;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IImportDeclaration;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.jdt.ui.StandardJavaElementContentProvider;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class BeanScopeAddDialog extends TitleAreaDialog {

	private Text txtName;
	private Text labelNameText;
	private Text valueNameText;
	private IJavaProject jProject;
	private Shell shell;

	public BeanScopeAddDialog(Shell parentShell) {
		super(parentShell);
	}

	public BeanScopeAddDialog(Shell parentShell, IJavaProject jProject) {
		super(parentShell);
		this.jProject = jProject;
		this.shell = parentShell;
	}

	@Override
	public void create() {
		super.create();
		setTitle("Add Bean to Scope");
		setMessage("Select Bean", IMessageProvider.INFORMATION);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(GridData.FILL_BOTH));
		GridLayout layout = new GridLayout(3, false);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		container.setLayout(layout);

		createName(container);
		createLabelName(container);
		createValueName(container);

		return area;
	}

	private void createName(Composite container) {
		Label lbtName = new Label(container, SWT.NONE);
		lbtName.setText("Scope Name:");

		GridData dataName = new GridData();
		dataName.grabExcessHorizontalSpace = true;
		dataName.horizontalAlignment = GridData.FILL;
		// dataName.horizontalSpan = 2;
		txtName = new Text(container, SWT.BORDER);
		txtName.setLayoutData(dataName);

		Label lbtSpace = new Label(container, SWT.NONE);
	}

	private void createLabelName(Composite container) {
		Label lbtJavaName = new Label(container, SWT.NONE);
		lbtJavaName.setText("Bean Class:");

		GridData dataJavaName = new GridData();
		dataJavaName.grabExcessHorizontalSpace = true;
		dataJavaName.horizontalAlignment = GridData.FILL;
		labelNameText = new Text(container, SWT.BORDER);
		labelNameText.setLayoutData(dataJavaName);
		labelNameText.setEditable(false);

		// browse button on right
		Button browse = new Button(container, SWT.PUSH);
		browse.setText("...");
		browse.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				StandardJavaElementContentProvider contentProvider = new StandardJavaElementContentProvider(
						false);
				ILabelProvider labelProvider = new JavaElementLabelProvider(
						JavaElementLabelProvider.SHOW_BASICS);

				ComponentsSelectionDialog dialog = new ComponentsSelectionDialog(
						shell, labelProvider, contentProvider);
				dialog.setInput(jProject);
				dialog.addFilter(new ComponentFilter());
				dialog.open();
			}
		});
	}

	private void createValueName(Composite container) {
		Label lbtValueName = new Label(container, SWT.NONE);
		lbtValueName.setText("Bean Name:");

		GridData dataValueName = new GridData();
		dataValueName.grabExcessHorizontalSpace = true;
		dataValueName.horizontalAlignment = GridData.FILL;
		valueNameText = new Text(container, SWT.BORDER);
		valueNameText.setLayoutData(dataValueName);
		valueNameText.setEditable(false);
		valueNameText.setEnabled(false);
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

	@Override
	protected void okPressed() {
		// saveInput();
		super.okPressed();
	}

	public class ComponentFilter extends ViewerFilter {

		@Override
		public boolean select(Viewer viewer, Object parentElement,
				Object element) {
			if (element instanceof ITypeRoot) {
				ITypeRoot unit = (ITypeRoot) element;
				IType type = unit.findPrimaryType();

				if (type == null) {
					return false;
				}

				IAnnotation[] annotations;
				try {
					annotations = type.getAnnotations();
					for (IAnnotation annotation : annotations) {
						String elementName = annotation.getElementName();
						if (elementName
								.equals("org.springframework.stereotype.Component")) {
							return true;
						} else if (elementName.equals("Component")
								&& element instanceof ICompilationUnit) {
							for (IImportDeclaration _import : ((ICompilationUnit) unit)
									.getImports()) {
								String importedType = _import.getElementName();
								if (importedType
										.equals("org.springframework.stereotype.Component")) {
									return true;
								}
								if (importedType
										.equals("org.springframework.stereotype.*")) {
									return true;
								}
							}
						}
					}
				} catch (JavaModelException e) {
					return false;
				}

				return false;
			}

			if (element instanceof IPackageFragment) {
				try {
					return ((IPackageFragment) element).hasChildren();
				} catch (JavaModelException e) {
					return false;
				}
			}
			if (element instanceof IPackageFragmentRoot) {
				// return !((IPackageFragmentRoot) element).isArchive();
				return true;
			}
			return false;
		}
	}

}
