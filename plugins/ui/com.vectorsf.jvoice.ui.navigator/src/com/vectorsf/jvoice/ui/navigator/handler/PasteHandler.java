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
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.core.operation.helper.FlowService;
import com.vectorsf.jvoice.core.operation.helper.PrototypeCreator;
import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVModule;
import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.base.JVProject;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;

public class PasteHandler extends AbstractHandler {

	private IPath targetPath;
	private IPath resourcesPath;
	private boolean rename;

	@Override
	public void setEnabled(Object evaluationContext) {

		Clipboard clip = new Clipboard(Display.getCurrent());
		Object contents = clip.getContents(LocalSelectionTransfer.getTransfer());
		clip.dispose();
		if (contents == null) {
			setBaseEnabled(false);
		} else {
			Object target = getTarget(evaluationContext);
			if (target instanceof JVPackage) {
				boolean state = getListFromClipboard(contents, Flow.class) != null;
				setBaseEnabled(state);
			} else if (target instanceof JVProject) {
				boolean state = getListFromClipboard(contents, JVPackage.class) != null;
				setBaseEnabled(state);
			} else if (target instanceof Flow) {
				boolean state = getListFromClipboard(contents, VoiceDsl.class) != null;
				setBaseEnabled(state);
			} else {
				setBaseEnabled(false);
			}
		}
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		rename = false;
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
		// Distinguimos si lo que hemos seleccionado es un paquete o un
		// proyecto.
		if (objtarget instanceof JVPackage) {
			pasteInPackage(event, contents, (JVPackage) objtarget);

		} else if (objtarget instanceof JVModule) {
			pasteInModule(event, contents, (JVModule) objtarget);
		}

		return null;
	}

	private void pasteInModule(ExecutionEvent event, Object contents, JVModule target) {
		String nombreUsuario;

		List<JVPackage> packs = getListFromClipboard(contents, JVPackage.class);
		if (packs == null) {
			return;
		}
		for (JVPackage pack : packs) {

			final IFolder miPack = (IFolder) Platform.getAdapterManager().getAdapter(pack, IFolder.class);

			final IProject targetRes = (IProject) Platform.getAdapterManager().getAdapter(target, IProject.class);
			targetPath = targetRes.getFullPath().append(miPack.getProjectRelativePath());
			final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

			// Se comprueba el nombre de la carpeta y en caso de existir en
			// el destino se recupera un nombre valido para ofrecer al
			// usuario.
			String nombre = findValidName(root, targetPath, target, miPack, targetRes, miPack.getName());
			// Comprobamos si la carpeta existe en el destino. Si existe, se
			// lanza un cuadro de dialogo donde el usuario podra poner el
			// nombre que desee a la carpeta
			if (root.getFolder(targetPath).exists()) {

				// Proponemos al usuario un nombre valido para la carpeta.
				InputDialog ventana = new InputDialog(HandlerUtil.getActiveShell(event), "Conflicto de nombre",
						"Ya existe un recurso llamado " + miPack.getName(), nombre, new IInputValidator() {

							@Override
							public String isValid(String input) {

								IStatus validateName = root.getWorkspace().validateName(input, IResource.FOLDER);
								if (!validateName.isOK()) {
									return validateName.getMessage();
								}

								IResource newFolder = miPack.getParent().findMember(input);
								if (newFolder != null && newFolder.exists()) {
									return "Ya existe un recurso con ese nombre";
								}

								return null;
							}
						});

				ventana.open();
				nombreUsuario = ventana.getValue();

				// Obtenemos el nuevo target con la ruta, y el nombre del
				// paquete seleccionado por el usuario.
				nombreUsuario = nombreUsuario.replace(".", "/");
				targetPath = targetRes.getFullPath().append(new Path(BaseModel.JV_PATH).append(nombreUsuario));

			}

			try {
				IWorkspaceRunnable runnable = new CopyFolderWksRunnable(miPack, targetPath);
				ResourcesPlugin.getWorkspace().run(runnable, null);

			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	private void pasteInPackage(ExecutionEvent event, Object contents, JVPackage target) {
		String nombreUsuario;

		List<Flow> flows = getListFromClipboard(contents, Flow.class);
		if (flows == null) {
			return;
		}
		for (Flow flow : flows) {

			final IFile beanFile = (IFile) Platform.getAdapterManager().getAdapter(flow, IFile.class);

			IPath pathRecursos = new Path(beanFile.getName().replace(".jvflow", ".resources"));
			final IFolder recursos = beanFile.getParent().getFolder(pathRecursos);

			final IFolder targetRes = (IFolder) Platform.getAdapterManager().getAdapter(target, IResource.class);
			targetPath = targetRes.getFullPath().append(beanFile.getName());
			resourcesPath = targetRes.getFullPath().append(recursos.getName());
			final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

			// Se comprueba el nombre del fichero y en caso de existir en el
			// destino se recupera un nombre valido para ofrecer al usuario.
			String nombre = findValidName(root, targetPath, target, beanFile, targetRes, beanFile.getName());
			// Comprobamos si el fichero existe en el destino. Si existe, se
			// lanza un cuadro de dialogo donde el usuario podra poner el
			// nombre que desee al fichero.
			String newFileName = nombre.substring(0, nombre.lastIndexOf('.'));
			if (root.getFile(targetPath).exists()) {
				rename = true;
				// Proponemos al usuario un nombre valido para el fichero.
				InputDialog ventana = new InputDialog(HandlerUtil.getActiveShell(event), "Conflicto de nombre",
						"Ya existe un recurso llamado " + targetPath.lastSegment(), newFileName, new IInputValidator() {

							@Override
							public String isValid(String input) {
								String fileName = input + ".jvflow";

								IStatus validateName = root.getWorkspace().validateName(fileName, IResource.FILE);
								if (!validateName.isOK()) {
									return validateName.getMessage();
								}

								IResource newFile = targetRes.findMember(fileName);
								if (newFile != null && newFile.exists()) {
									return "Ya existe un recurso con ese nombre";
								}

								return null;
							}
						});

				ventana.open();
				nombreUsuario = ventana.getValue();

				// Obtenemos el nuevo target con la ruta, y el nombre del
				// paquete seleccionado por el usuario.
				targetPath = targetRes.getFullPath().append(nombreUsuario + ".jvflow");
				resourcesPath = targetRes.getFullPath().append(nombreUsuario + ".resources");
			} else {
				nombreUsuario = flow.getName();
			}

			// Realizamos la copia del fichero al destino.
			try {
				final IPackageFragment helperTargetPackage = FlowService.getHelperPackage(targetPath);
				final ICompilationUnit helperOriginalClass = FlowService.getHelperICU(flow);
				final String finalnombreUsuario = FlowService.toTitleCase(nombreUsuario);

				IWorkspaceRunnable runnable = new IWorkspaceRunnable() {

					@Override
					public void run(IProgressMonitor monitor) throws CoreException {
						beanFile.copy(targetPath, true, monitor);
						recursos.copy(resourcesPath, true, monitor);
						if (helperOriginalClass != null) {
							helperOriginalClass.copy(helperTargetPackage, null, finalnombreUsuario + ".java", true,
									monitor);
						} else {
							PrototypeCreator.createBeanFor(finalnombreUsuario, helperTargetPackage, monitor);
						}

						FlowService.actualizaFlow(targetPath, helperTargetPackage.getElementName() + "."
								+ finalnombreUsuario, rename);
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

			if (o instanceof JVPackage || o instanceof JVProject || o instanceof JVBean) {
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

	private String findValidName(IWorkspaceRoot root, IPath targetPath, JVProject target, IFolder folder,
			IResource targetRes, String nameUser) {

		if (root.getFolder(targetPath).exists()) {
			String newName = "CopyOf" + nameUser;
			targetPath = targetRes.getFullPath().append(folder.getParent().getProjectRelativePath().append(newName));

			return findValidName(root, targetPath, target, folder, targetRes, newName);

		} else {
			return nameUser;
		}
	}

	private String findValidName(IWorkspaceRoot root, IPath targetPath, JVPackage target, IFile file,
			IResource targetRes, String nameUser) {

		if (root.getFile(targetPath).exists()) {

			String newName = "CopyOf" + nameUser;
			targetPath = targetRes.getFullPath().append(newName);

			return findValidName(root, targetPath, target, file, targetRes, newName);

		} else {
			return nameUser;
		}

	}
}
