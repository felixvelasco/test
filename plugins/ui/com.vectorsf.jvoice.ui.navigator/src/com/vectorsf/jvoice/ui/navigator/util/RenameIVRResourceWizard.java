package com.vectorsf.jvoice.ui.navigator.util;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.graphiti.mm.pictograms.Diagram;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.RenameRefactoring;
import org.eclipse.ltk.internal.core.refactoring.resource.RenameResourceProcessor;
import org.eclipse.ltk.internal.ui.refactoring.RefactoringUIMessages;
import org.eclipse.ltk.ui.refactoring.RefactoringWizard;
import org.eclipse.ltk.ui.refactoring.UserInputWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtext.resource.SaveOptions;

import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;

@SuppressWarnings("restriction")
public class RenameIVRResourceWizard extends RefactoringWizard {

	private static IResource resource;
	private static final String[] extensions = { "jvflow", "voiceDsl" };

	@SuppressWarnings("static-access")
	public RenameIVRResourceWizard(IResource resource) {

		super(new RenameRefactoring(new RenameResourceProcessor(resource)),
				DIALOG_BASED_USER_INTERFACE);
		setDefaultPageTitle(RefactoringUIMessages.RenameResourceWizard_page_title);
		setWindowTitle(RefactoringUIMessages.RenameResourceWizard_window_title);

		this.resource = resource;
	}

	@Override
	protected void addUserInputPages() {
		RenameResourceProcessor processor = (RenameResourceProcessor) getRefactoring()
				.getAdapter(RenameResourceProcessor.class);
		addPage(new RenameResourceRefactoringConfigurationPage(processor));
	}

	private static class RenameResourceRefactoringConfigurationPage extends
			UserInputWizardPage {

		private final RenameResourceProcessor fRefactoringProcessor;
		private Text fNameField;

		public RenameResourceRefactoringConfigurationPage(
				RenameResourceProcessor processor) {
			super("RenameResourceRefactoringInputPage"); //$NON-NLS-1$
			fRefactoringProcessor = processor;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt
		 * .widgets.Composite)
		 */
		@Override
		public void createControl(Composite parent) {
			Composite composite = new Composite(parent, SWT.NONE);
			composite.setLayout(new GridLayout(2, false));
			composite
					.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
			composite.setFont(parent.getFont());

			Label label = new Label(composite, SWT.NONE);
			label.setText(RefactoringUIMessages.RenameResourceWizard_name_field_label);
			label.setLayoutData(new GridData());

			fNameField = new Text(composite, SWT.BORDER);
			fNameField.setText(fRefactoringProcessor.getNewResourceName());
			fNameField.setFont(composite.getFont());
			fNameField.setLayoutData(new GridData(GridData.FILL,
					GridData.BEGINNING, true, false));
			fNameField.addModifyListener(new ModifyListener() {
				@Override
				public void modifyText(ModifyEvent e) {
					validatePage();
				}
			});

			fNameField.selectAll();
			setPageComplete(false);
			setControl(composite);
		}

		@Override
		public void setVisible(boolean visible) {
			if (visible) {
				fNameField.setFocus();
			}
			super.setVisible(visible);
		}

		@SuppressWarnings("static-access")
		protected final void validatePage() {
			String text = fNameField.getText();

			RefactoringStatus status = fRefactoringProcessor
					.validateNewElementName(text);
			if (resource instanceof IFile) {
				boolean extensionBien = false;
				if (text.contains(".")
						&& text.substring(text.indexOf(".")).length() > 1) {

					String textoExtension = text
							.substring(text.indexOf(".") + 1);
					for (int i = 0; i < extensions.length; i++) {
						if (extensions[i].equals(textoExtension)) {
							extensionBien = true;
							break;
						}
					}
				}

				if (!extensionBien) {
					status = status.createFatalErrorStatus("muy mal");
				}
			}
			setPageComplete(status);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.eclipse.ltk.ui.refactoring.UserInputWizardPage#performFinish()
		 */
		@Override
		protected boolean performFinish() {
			try {
				IWorkspaceRunnable runnable = new IWorkspaceRunnable() {

					@Override
					public void run(IProgressMonitor monitor)
							throws CoreException {
						initializeRefactoring();
						if (resource instanceof IFile) {
							renameBean();
						}
						superPerformFinish();

					}
				};
				ResourcesPlugin.getWorkspace().run(runnable, null);

				return true;
			} catch (CoreException e) {
				e.printStackTrace();
				return false;
			}
		}

		protected void superPerformFinish() {
			super.performFinish();

		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.eclipse.ltk.ui.refactoring.UserInputWizardPage#getNextPage()
		 */
		@Override
		public IWizardPage getNextPage() {
			initializeRefactoring();
			return super.getNextPage();
		}

		private void initializeRefactoring() {
			fRefactoringProcessor.setNewResourceName(fNameField.getText());
		}

		private boolean renameBean() {
			String newName = fNameField.getText().substring(0,
					fNameField.getText().lastIndexOf('.'));
			ResourceSetImpl resourceSetImpl = new ResourceSetImpl();
			Resource emfRes = resourceSetImpl.createResource(URI
					.createPlatformResourceURI(resource.getFullPath()
							.toString(), true));
			try {
				emfRes.load(null);

				for (EObject obj : emfRes.getContents()) {
					if (obj instanceof VoiceDsl) {
						((VoiceDsl) obj).setName(newName);

					} else if (obj instanceof JVBean) {
						((JVBean) obj).setName(newName);
						((JVBean) obj).setDescription(newName);
						List<EObject> listaObjetos = ((Flow) obj).eResource()
								.getContents();
						for (int i = 0; i < listaObjetos.size(); i++) {
							EObject objeto = listaObjetos.get(i);
							if (objeto instanceof Diagram) {
								((Diagram) objeto).setName(newName);
							}
						}
					}
				}
				try {
					emfRes.save(SaveOptions.newBuilder().noValidation()
							.getOptions().toOptionsMap());
				} catch (RuntimeException re) {
					re.printStackTrace();
				}
				return true;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
	}
}
