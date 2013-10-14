package com.vectorsf.jvoice.ui.navigator.handler;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;

import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.base.JVProject;
import com.vectorsf.jvoice.prompt.model.voiceDsl.VoiceDsl;

public class PasteHandler extends AbstractHandler {

	private IPath targetPath;
	private IResource targetRes;
	private IFolder miPack;
	private IFile miBean;
	private boolean rename;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		rename = false;
		Clipboard clip = new Clipboard(Display.getCurrent());
		Object contents = clip.getContents(LocalSelectionTransfer.getTransfer());
		if (contents == null) {
			return null;
		}

		Object Objtarget = getValidTarget(((IEvaluationContext) event.getApplicationContext()).getDefaultVariable());

		if (Objtarget == null) {
			return null;
		}
		final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		// Distinguimos si lo que hemos seleccionado es un paquete o un
		// proyecto.
		if (Objtarget instanceof JVPackage) {
			JVPackage target = (JVPackage) Objtarget;

			List<JVBean> beans = getJVBeanFromClipboard(contents);
			if (beans == null) {
				return null;
			}
			for (JVBean bean : beans) {

				miBean = (IFile) Platform.getAdapterManager().getAdapter(bean, IFile.class);

				targetRes = (IResource) Platform.getAdapterManager().getAdapter(target, IResource.class);
				targetPath = targetRes.getFullPath().append(miBean.getName());

				// Se comprueba el nombre del fichero y en caso de existir en el
				// destino se recupera un nombre valido para ofrecer al usuario.
				String nombre = nombreValido(root, targetPath, target, miBean, targetRes, miBean.getName());
				// Comprobamos si el fichero existe en el destino. Si existe, se
				// lanza un cuadro de dialogo donde el usuario podra poner el
				// nombre que desee al fichero.
				if (root.getFile(targetPath).exists()) {
					rename = true;
					// Proponemos al usuario un nombre valido para el fichero.
					InputDialog ventana = new InputDialog(HandlerUtil.getActiveShell(event), "Conflicto de nombre",
							nombre + " " + "Ya existe un recurso llamado " + nombre, nombre, new IInputValidator() {

								@Override
								public String isValid(String input) {

									IStatus validateName = root.getWorkspace().validateName(input, IResource.FILE);
									if (!validateName.isOK()) {
										return validateName.getMessage();
									}
									targetPath = targetRes.getFullPath().append(
											miBean.getParent().getProjectRelativePath().append(input));
									if (root.getFile(targetPath).exists()) {
										return "Ya existe un recurso con ese nombre";
									}

									return null;
								}
							});

					ventana.open();
					String nombreUsuario = ventana.getValue();

					// Obtenemos el nuevo target con la ruta, y el nombre del
					// paquete seleccionado por el usuario.
					targetPath = targetRes.getFullPath().append(nombreUsuario);

				}

				// Realizamos la copia del fichero al destino.
				try {
					IWorkspaceRunnable runnable = new IWorkspaceRunnable() {

						@Override
						public void run(IProgressMonitor monitor) throws CoreException {
							miBean.copy(targetPath, true, null);
							if (rename) {
								renameBean(targetPath);
							}

						}
					};
					ResourcesPlugin.getWorkspace().run(runnable, null);

				} catch (CoreException e) {
					e.printStackTrace();
				}
			}

		} else if (Objtarget instanceof JVProject) {
			JVProject target = (JVProject) Objtarget;

			List<JVPackage> packs = getJVPackFromClipboard(contents);
			if (packs == null) {
				return null;
			}
			for (JVPackage pack : packs) {

				miPack = (IFolder) Platform.getAdapterManager().getAdapter(pack, IFolder.class);

				targetRes = (IResource) Platform.getAdapterManager().getAdapter(target, IResource.class);
				targetPath = targetRes.getFullPath().append(miPack.getProjectRelativePath());

				// Se comprueba el nombre de la carpeta y en caso de existir en
				// el destino se recupera un nombre valido para ofrecer al
				// usuario.
				String nombre = nombreValido(root, targetPath, target, miPack, targetRes, miPack.getName());
				// Comprobamos si la carpeta existe en el destino. Si existe, se
				// lanza un cuadro de dialogo donde el usuario podra poner el
				// nombre que desee a la carpeta
				if (root.getFolder(targetPath).exists()) {

					// Proponemos al usuario un nombre valido para la carpeta.
					InputDialog ventana = new InputDialog(HandlerUtil.getActiveShell(event), "Conflicto de nombre",
							nombre + " " + "Ya existe un recurso llamado " + nombre, nombre, new IInputValidator() {

								@Override
								public String isValid(String input) {

									IStatus validateName = root.getWorkspace().validateName(input, IResource.FOLDER);
									if (!validateName.isOK()) {
										return validateName.getMessage();
									}

									targetPath = targetRes.getFullPath().append(
											miPack.getParent().getProjectRelativePath().append(input));
									if (root.getFolder(targetPath).exists()) {
										return "Ya existe un recurso con ese nombre";
									}

									return null;
								}
							});

					ventana.open();
					String nombreUsuario = ventana.getValue();

					// Obtenemos el nuevo target con la ruta, y el nombre del
					// paquete seleccionado por el usuario.
					targetPath = targetRes.getFullPath().append(
							miPack.getParent().getProjectRelativePath().append(nombreUsuario));

				}

				// Realizamos la copia del paquete al destino.
				try {
					miPack.copy(targetPath, true, null);
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}

		}

		return null;
	}

	@SuppressWarnings("unchecked")
	private Object getValidTarget(Object target) {
		if (!(target instanceof Collection<?>) || ((Collection<Object>) target).size() != 1) {
			return null;
		}

		Object o = ((Collection<Object>) target).iterator().next();

		if (o instanceof JVPackage || o instanceof JVProject) {
			return o;
		} else {
			return null;
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<JVBean> getJVBeanFromClipboard(Object contents) {

		// Todos los elementos deben ser navegaciones
		List toPaste = ((IStructuredSelection) contents).toList();
		for (Object o : toPaste) {
			if (!(o instanceof JVBean)) {
				return null;
			}
		}
		return toPaste;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private List<JVPackage> getJVPackFromClipboard(Object contents) {

		// Todos los elementos deben ser navegaciones
		List toPaste = ((IStructuredSelection) contents).toList();
		for (Object o : toPaste) {
			if (!(o instanceof JVPackage)) {
				return null;
			}
		}
		return toPaste;
	}

	private String getNewName(Object beanPackage, String name) {
		if (beanPackage instanceof JVPackage) {
			JVPackage proPack = (JVPackage) beanPackage;
			for (EObject o : proPack.eContents()) {
				if (o instanceof JVBean) {
					String navName = ((JVBean) o).getName();
					if (navName != null && navName.equals(name)) {
						// Se vuelve a llamar a s� mismo para comprobar que el
						// nombre creado tampoco existe.
						return getNewName(beanPackage, "Copy of " + name);
					}
				}
			}
			return name;

		} else if (beanPackage instanceof JVProject) {
			JVProject proPack = (JVProject) beanPackage;
			for (EObject o : proPack.eContents()) {
				if (o instanceof JVPackage) {
					String navName = ((JVPackage) o).getName();
					if (navName != null && navName.equals(name)) {
						// Se vuelve a llamar a s� mismo para comprobar que el
						// nombre creado tampoco existe.
						return getNewName(beanPackage, "Copy of " + name);
					}
				}
			}
			return name;
		} else {
			return null;
		}

	}

	// Metodo para recuperar un nombre valido para el fichero o la carpeta que
	// se quiere copiar en caso de que haya uno en el destino con el mismo
	// nombre.
	private String nombreValido(IWorkspaceRoot root, IPath targetPath, Object targets, Object miobjeto,
			IResource targetRes, String NameUser) {
		if (targets instanceof JVProject) {
			JVProject target = (JVProject) targets;
			IFolder mipackage = (IFolder) miobjeto;

			if (root.getFolder(targetPath).exists()) {

				String newName = getNewName(target, "CopyOf" + mipackage.getName());

				targetPath = targetRes.getFullPath().append(
						mipackage.getParent().getProjectRelativePath().append(newName));

				return nombreValido(root, targetPath, target, mipackage, targetRes, newName);

			} else {
				return NameUser;
			}
		} else if (targets instanceof JVPackage) {
			JVPackage target = (JVPackage) targets;
			IFile mipackage = (IFile) miobjeto;

			if (root.getFile(targetPath).exists()) {

				String newName = getNewName(target, "CopyOf" + mipackage.getName());

				targetPath = targetRes.getFullPath().append(
						mipackage.getParent().getProjectRelativePath().append(newName));

				return nombreValido(root, targetPath, target, mipackage, targetRes, newName);

			} else {
				return NameUser;
			}

		} else {
			return null;
		}
	}

	private void renameBean(IPath targetPath) {
		String newName = targetPath.lastSegment();
		newName = newName.substring(0, newName.lastIndexOf('.'));
		ResourceSetImpl resourceSetImpl = new ResourceSetImpl();
		Resource emfRes = resourceSetImpl.createResource(URI.createPlatformResourceURI(targetPath.toString(), true));
		try {
			emfRes.load(null);

			for (EObject obj : emfRes.getContents()) {
				if (obj instanceof VoiceDsl) {
					((VoiceDsl) obj).setName(newName);

				} else if (obj instanceof JVBean) {
					((JVBean) obj).setName(newName);
				}
			}
			emfRes.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
