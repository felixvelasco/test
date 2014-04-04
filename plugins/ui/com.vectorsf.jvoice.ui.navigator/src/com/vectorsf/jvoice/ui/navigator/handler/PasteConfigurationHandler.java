package com.vectorsf.jvoice.ui.navigator.handler;

import java.util.Collection;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.model.base.Configuration;
import com.vectorsf.jvoice.model.base.JVProject;

public class PasteConfigurationHandler extends AbstractHandler {

	private IPath path;
	private static final Path PROPERTIES_PATH = new Path(BaseModel.PROPERTIES_PATH);

	/*
	 * Método que se encarga de activar o no el comando correspondiente.
	 */
	@Override
	public void setEnabled(Object evaluationContext) {

		Clipboard clip = new Clipboard(Display.getCurrent());
		Object contents = clip.getContents(LocalSelectionTransfer.getTransfer());
		clip.dispose();
		if (contents == null) {
			setBaseEnabled(false);
		} else {
			Object target = getTarget(evaluationContext);
			if (target instanceof JVProject) {
				boolean state = getListFromClipboard(contents, Configuration.class) != null;
				setBaseEnabled(state);
			} else {
				setBaseEnabled(false);
			}
		}
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		Clipboard clip = new Clipboard(Display.getCurrent());
		Object contents = clip.getContents(LocalSelectionTransfer.getTransfer());
		clip.dispose();
		if (contents == null) {
			return null;
		}

		Object objtarget = getTarget(event.getApplicationContext());

		if (objtarget == null) {
			return null;
		}
		/*
		 * Compobamos que existe la carpeta de properties donde queremos copiar el fichero. Si no existe la creamos.
		 */
		IFolder folderProper = getPropertiesFolder(objtarget);
		if (!folderProper.exists()) {
			try {
				folderProper.create(true, true, null);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}

		/*
		 * Una vez que hemos creado la carpeta de properties, en caso de que no existiese, se procede a la copia del
		 * fichero
		 */
		pastePropertiesFiles(event, contents, objtarget);

		return null;
	}

	/*
	 * Método para recuperar la ruta donde se guardan los properties. Depende desde donde hayamos iniciado la creación,
	 * un proyecto o un paquete, para montarla.
	 */
	private IFolder getPropertiesFolder(Object objtarget) {
		String nameproject = null;
		if (objtarget instanceof JVProject) {
			nameproject = ((JVProject) objtarget).getName();
			path = new Path("/" + nameproject).append(PROPERTIES_PATH);
			return ResourcesPlugin.getWorkspace().getRoot().getFolder(path);
		} else {
			return null;
		}

	}

	private void pastePropertiesFiles(ExecutionEvent event, Object contents, Object target) {
		List<Configuration> configurations = getListFromClipboard(contents, Configuration.class);
		if (configurations == null) {
			return;
		}

		final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

		for (Configuration configuration : configurations) {

			String candidateName = null;

			final IFile propertiesFile = (IFile) Platform.getAdapterManager().getAdapter(configuration, IFile.class);

			IProject projectDestino = (IProject) Platform.getAdapterManager().getAdapter(target, IProject.class);
			IPath basicPath = projectDestino.getFullPath().append(propertiesFile.getProjectRelativePath());
			final IPath targetPath;

			// Se comprueba el nombre del fichero y en caso de existir en
			// el destino se recupera un nombre valido para ofrecer al
			// usuario.
			candidateName = findValidName(root, basicPath);

			// Comprobamos si el fichero existe en el destino. Si existe, se
			// lanza un cuadro de dialogo donde el usuario podra poner el
			// nombre que desee al fichero.
			if (root.getFile(basicPath).exists()) {
				// Proponemos al usuario un nombre valido para el fichero.
				InputDialog dialog = new InputDialog(HandlerUtil.getActiveShell(event), "Conflicto de nombre",
						"Ya existe un recurso llamado " + basicPath.lastSegment(), candidateName,
						new IInputValidator() {

							@Override
							public String isValid(String input) {
								String fileName = input + ".properties";

								IStatus validateName = root.getWorkspace().validateName(fileName, IResource.FILE);
								if (!validateName.isOK()) {
									return validateName.getMessage();
								}

								IResource newFile = propertiesFile.getParent().findMember(fileName);
								if (newFile != null && newFile.exists()) {
									return "Ya existe un recurso con ese nombre";
								}

								return null;
							}
						});

				dialog.open();

				// Obtenemos el nuevo target con el nombre del
				// fichero seleccionado por el usuario.
				targetPath = getPropertiesFolder(target).getFullPath().append(dialog.getValue() + ".properties");

			} else {
				targetPath = basicPath;
			}

			try {

				IWorkspaceRunnable runnable = new IWorkspaceRunnable() {

					@Override
					public void run(IProgressMonitor monitor) throws CoreException {
						try {
							propertiesFile.copy(targetPath, true, monitor);
						} catch (Exception e) {

						}

					}
				};
				ResourcesPlugin.getWorkspace().run(runnable, null);

			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	private Object getTarget(Object target) {
		Object def = ((IEvaluationContext) target).getDefaultVariable();
		if (def instanceof Collection<?> && ((Collection<?>) def).size() == 1) {
			Object o = ((Collection<?>) def).iterator().next();

			if (o instanceof JVProject) {
				return o;
			} else {
				return null;
			}
		}
		return null;
	}

	private <T> List<T> getListFromClipboard(Object contents, Class<T> clazz) {

		// Todos los elementos deben ser navegaciones
		if (contents instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection) contents;
			if (selection.isEmpty()) {
				return null;
			}
			List<?> toPaste = selection.toList();
			for (Object o : toPaste) {
				if (!clazz.isInstance(o)) {
					return null;
				}
			}
			@SuppressWarnings("unchecked")
			List<T> ret = (List<T>) toPaste;
			return ret;
		}
		return null;
	}

	private String findValidName(IWorkspaceRoot root, IPath targetPath) {

		if (root.getFile(targetPath).exists()) {
			String newName = "CopyOf" + targetPath.lastSegment();
			IPath parentPath = targetPath.removeLastSegments(1);
			IPath newPath = parentPath.append(newName);

			return findValidName(root, newPath);

		} else {
			return targetPath.removeFileExtension().lastSegment();
		}
	}

}
