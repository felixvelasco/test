package com.vectorsf.jvoice.ui.wizard.create;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.vectorsf.jvoice.core.operation.helper.FlowService;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;
import com.vectorsf.jvoice.ui.wizard.Activator;

public class SelectDefinitionWizardPage extends WizardPage {

	private static final String PAGE_DESC = "Select definition type";
	private static final String PAGE_TITLE = "Select type";

	private Button textualButton;
	private Button programmaticButton;
	private SelectionListener buttonsSelectionListener;

	private Object[] textualsArray;
	private Object[] methodsArray;

	private Composite filteredArea;
	private TableViewer viewer;
	private Flow flow;
	private DefinitionHelper definition;
	private CreateDefinitionWizard wizard;
	private AdapterFactoryLabelProvider textualLabelProvider;
	private JavaElementLabelProvider methodsLabelProvider;

	public SelectDefinitionWizardPage(CreateDefinitionWizard wizard, Flow flow, DefinitionHelper definition) {
		super(PAGE_TITLE);
		setTitle(PAGE_TITLE);
		setDescription(PAGE_DESC);
		setImageDescriptor(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "res/wizban/icon_wiz_locution.png"));
		buttonsSelectionListener = new RadioSelectionListener();

		this.flow = flow;
		this.wizard = wizard;
		this.definition = definition;
		this.textualsArray = getTextualDefinitions().toArray();
		this.methodsArray = getMethodDefinitions().toArray();
		textualLabelProvider = new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		methodsLabelProvider = new JavaElementLabelProvider(JavaElementLabelProvider.SHOW_PARAMETERS
				| JavaElementLabelProvider.SHOW_OVERLAY_ICONS | JavaElementLabelProvider.SHOW_RETURN_TYPE);
	}

	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		composite.setFont(parent.getFont());
		GridData gd = new GridData(GridData.FILL_BOTH);
		composite.setLayoutData(gd);

		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		composite.setLayout(layout);
		{
			// Element name label
			Label selectTypeLabel = new Label(composite, SWT.NONE);
			selectTypeLabel.setText("Select definition:");
			selectTypeLabel.setFont(parent.getFont());
			GridData data = new GridData(GridData.FILL_HORIZONTAL);
			data.horizontalSpan = 2;
			selectTypeLabel.setLayoutData(data);
		}

		{
			filteredArea = createTable(composite);
			GridData data = new GridData(GridData.FILL_BOTH);
			data.horizontalSpan = 2;
			filteredArea.setLayoutData(data);
		}

		{
			{
				// Textual radio button
				textualButton = new Button(composite, SWT.RADIO);
				textualButton.setText("Textual");
				textualButton.setSelection(true);
				GridData data = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
				data.horizontalAlignment = GridData.HORIZONTAL_ALIGN_CENTER;
				textualButton.setLayoutData(data);
				textualButton.setFont(parent.getFont());
				textualButton.addSelectionListener(buttonsSelectionListener);
			}
			{
				// Programmable ratio button
				programmaticButton = new Button(composite, SWT.RADIO);
				programmaticButton.setText("Programmable");
				GridData data = new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_BEGINNING);
				data.horizontalAlignment = GridData.HORIZONTAL_ALIGN_CENTER;
				programmaticButton.setLayoutData(data);
				programmaticButton.setFont(parent.getFont());
				programmaticButton.addSelectionListener(buttonsSelectionListener);
			}
		}

		setPageComplete(false);

		// Show description on opening
		setErrorMessage(null);
		setMessage(null);
		setControl(composite);
	}

	protected Composite createTable(Composite parent) {
		viewer = new TableViewer(parent, SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL);
		viewer.setContentProvider(new ArrayContentProvider());
		setTextual();

		viewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				Object selection = ((IStructuredSelection) event.getSelection()).getFirstElement();
				handleSelected(selection);
			}
		});

		return viewer.getTable();
	}

	protected void handleSelected(Object selection) {
		validatePage();
	}

	private void validatePage() {
		setPageComplete(!viewer.getSelection().isEmpty());
	}

	public boolean isTextual() {
		return wizard.isTextual();
	}

	public String getDefinitionName() {

		Object selectedElement = getSelectedElement();
		if (selectedElement == null) {
			return null;
		}

		if (selectedElement instanceof IMethod) {
			IMethod method = (IMethod) selectedElement;
			return method.getElementName();
		} else {
			VoiceDsl def = (VoiceDsl) selectedElement;
			return def.getName();
		}
	}

	public Object getSelectedElement() {
		return ((IStructuredSelection) viewer.getSelection()).getFirstElement();
	}

	public void setTextual(boolean textual) {
		if (textual) {
			if (programmaticButton.getSelection()) {
				textualButton.setSelection(true);
				programmaticButton.setSelection(false);
			}
			setTextual();
		} else if (!textual) {
			if (textualButton.getSelection()) {
				textualButton.setSelection(false);
				programmaticButton.setSelection(true);
			}
			setMethod();
		}
	}

	private void setTextual() {
		viewer.setLabelProvider(textualLabelProvider);
		viewer.setInput(textualsArray);
	}

	private void setMethod() {
		viewer.setLabelProvider(methodsLabelProvider);
		viewer.setInput(methodsArray);
	}

	private List<VoiceDsl> getTextualDefinitions() {
		List<VoiceDsl> locutionResources = new ArrayList<VoiceDsl>();
		IPath flowFolderPath = getFlowFolderPath(flow);

		IFolder resourcesFolder = (IFolder) ResourcesPlugin.getWorkspace().getRoot().findMember(flowFolderPath);

		try {
			for (IResource resource : resourcesFolder.members()) {
				if (resource instanceof IFile) {
					URI uri = URI.createPlatformResourceURI(resource.getFullPath().toString(), true);
					if (!resource.getName().contains(".jsp")) {
						try {
							Resource res = flow.eResource().getResourceSet().getResource(uri, true);
							EObject eObject = res.getContents().get(0);

							if (definition.getDefClass().isInstance(eObject)) {
								locutionResources.add((VoiceDsl) eObject);
							}
						} catch (RuntimeException ignored) {
						}
					}
				}
			}
		} catch (CoreException e1) {
			e1.printStackTrace();
		}
		return locutionResources;
	}

	private List<IMethod> getMethodDefinitions() {
		List<IMethod> methods = new ArrayList<>();

		try {
			IType helperType = FlowService.getHelperType(flow);
			for (IMethod method : helperType.getMethods()) {
				String declaredReturnType = method.getReturnType();
				if (Signature.getArrayCount(declaredReturnType) > 0) {
					continue;
				}
				int flags = method.getFlags();
				if (Flags.isAbstract(flags) || Flags.isStatic(flags)) {
					continue;
				}

				String humanReturnType = Signature.toString(declaredReturnType);
				if (isInteresting(humanReturnType)) {
					methods.add(method);
				}
			}
		} catch (JavaModelException e1) {
			e1.printStackTrace();
		}
		return methods;
	}

	private boolean isInteresting(String humanReturnType) {
		return true;
	}

	private IPath getFlowFolderPath(Flow flow) {
		IPath path = new Path(flow.eResource().getURI().toPlatformString(true));
		IPath parentPath = path.removeLastSegments(1);

		return parentPath.append(flow.getName() + ".resources");
	}

	public class RadioSelectionListener implements SelectionListener {

		@Override
		public void widgetSelected(SelectionEvent e) {
			if (e.getSource() == textualButton && textualButton.getSelection()) {
				wizard.setTextual(true);

			} else if (e.getSource() == programmaticButton && programmaticButton.getSelection()) {
				wizard.setTextual(false);

			}
			validatePage();
		}

		@Override
		public void widgetDefaultSelected(SelectionEvent e) {
		}

	}

}
