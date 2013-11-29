package com.vectorsf.jvoice.ui.navigator.drop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.ui.navigator.CommonDropAdapter;
import org.eclipse.ui.navigator.CommonDropAdapterAssistant;

import com.vectorsf.jvoice.model.base.JVModule;
import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.ui.navigator.activator.Activator;

public abstract class FileCommonDropAdapterAssistant extends
		CommonDropAdapterAssistant {

	private String mType;
	private String mDirBase;
	private IProject iproject;

	public FileCommonDropAdapterAssistant(String inType, String inDirBase) {
		mType = inType;
		mDirBase = inDirBase;
	}

	@Override
	public IStatus validateDrop(Object target, int operation,
			TransferData transferType) {

		if (operation != DND.DROP_COPY) {
			return Status.CANCEL_STATUS;
		}

		// Check the file extension
		FileTransfer instance = FileTransfer.getInstance();
		if (instance.isSupportedType(transferType)) {
			String[] resources = (String[]) instance.nativeToJava(transferType);
			if (resources != null) {
				for (String recurso : resources) {
					if (recurso.contains(".")
							&& recurso.length() - 1 > recurso.lastIndexOf(".")) {
						String sExt = recurso.substring(recurso
								.lastIndexOf(".") + 1);
						if (!sExt.equalsIgnoreCase(mType)) {
							return Status.CANCEL_STATUS;
						}
					} else {
						return Status.CANCEL_STATUS;
					}
				}
				return Status.OK_STATUS;
			}
		}

		return Status.CANCEL_STATUS;
	}

	@Override
	public IStatus handleDrop(CommonDropAdapter aDropAdapter,
			DropTargetEvent aDropTargetEvent, Object aTarget) {
		aDropTargetEvent.detail = DND.DROP_NONE;
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();

		IFolder targetFolder;
		if (aTarget instanceof JVModule) {
			JVModule target = (JVModule) aTarget;
			iproject = root.getProject(target.getName());
			// Mirar direcciones geenradas para copiar
			targetFolder = root.getProject(target.getName())
					.getFolder(mDirBase);

		} else if (aTarget instanceof JVPackage) {
			JVPackage target = (JVPackage) aTarget;
			iproject = root.getProject(target.getOwnerModule().getName());
			targetFolder = root.getProject(target.getOwnerModule().getName())
					.getFolder(mDirBase);
		} else if (aTarget instanceof IFolder) {
			IFolder target = (IFolder) aTarget;
			iproject = target.getProject();
			targetFolder = target.getProject().getFolder(mDirBase);
		} else {
			return Status.CANCEL_STATUS;
		}

		String[] dataruta = (String[]) aDropTargetEvent.data;
		for (String dato : dataruta) {
			String ruta = dato;
			File originalFile = new File(ruta);

			try {
				// Si no existe la carpeta padre, la crea.
				if (!targetFolder.exists()) {
					recursivelyCreate(targetFolder);
				}

				// Comprobamos que el archivo ya no existe en el Modulo.
				IFile target = targetFolder.getFile(originalFile.getName());
				if (target.exists()) {
					return Status.CANCEL_STATUS;
				}

				FileInputStream source = new FileInputStream(originalFile);
				target.create(source, true, null);

				// En caso de ser un wsdl añadimos plugin al pom
				if ("wsdl".equalsIgnoreCase(mType)) {
					ConfigurationPomWSDL configurate = new ConfigurationPomWSDL();
					configurate.initial(iproject);
				}

			} catch (CoreException | FileNotFoundException e) {
				return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
						"Error copying resources", e);
			}
		}

		return Status.OK_STATUS;
	}

	private void recursivelyCreate(IFolder container) throws CoreException {
		if (!container.getParent().exists()) {
			recursivelyCreate((IFolder) container.getParent());
		}
		container.create(true, true, null);
	}

	@Override
	public boolean isSupportedType(TransferData aTransferType) {
		return FileTransfer.getInstance().isSupportedType(aTransferType);
	}
}
