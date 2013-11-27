package com.vectorsf.jvoice.ui.navigator.drop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.FileTransfer;
import org.eclipse.swt.dnd.TransferData;
import org.eclipse.ui.navigator.CommonDropAdapter;
import org.eclipse.ui.navigator.CommonDropAdapterAssistant;

import com.vectorsf.jvoice.model.base.JVModule;
import com.vectorsf.jvoice.model.base.JVPackage;

public class FileCommonDropAdapterAssistant extends CommonDropAdapterAssistant {

	private String mType = ".other";
	private String mDirBase = "/src/main/resources/other";
	private String destino;
	private IResource targetRes;

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

		// Comprobamos que el archivo que se quiere mover es un WAV. De momento
		// solo se podran copiar estos archivos para que se cree la carpeta de
		// audios
		String[] resource = (String[]) FileTransfer.getInstance().nativeToJava(
				transferType);
		String sExt = resource[0].substring(resource[0].lastIndexOf(".") + 1);
		if (!sExt.equalsIgnoreCase(mType)) {
			return Status.CANCEL_STATUS;
		}

		return Status.OK_STATUS;
	}

	@Override
	public IStatus handleDrop(CommonDropAdapter aDropAdapter,
			DropTargetEvent aDropTargetEvent, Object aTarget) {
		aDropTargetEvent.detail = DND.DROP_NONE;
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IWorkspaceRoot root = workspace.getRoot();

		if (aTarget instanceof JVModule) {
			JVModule target = (JVModule) aTarget;
			// Mirar direcciones geenradas para copiar
			destino = root.getProject(target.getName()).getLocation()
					+ mDirBase;
			targetRes = (IResource) Platform.getAdapterManager().getAdapter(
					target, IResource.class);

		} else if (aTarget instanceof JVPackage) {
			JVPackage target = (JVPackage) aTarget;
			destino = root.getProject(target.getOwnerModule().getName())
					.getLocation() + mDirBase;
			targetRes = (IResource) Platform.getAdapterManager().getAdapter(
					target.getOwnerModule(), IResource.class);
		} else if (aTarget instanceof IFolder) {
			IFolder target = (IFolder) aTarget;
			destino = root.getProject(target.getProject().getName())
					.getLocation() + mDirBase;
			targetRes = (IResource) Platform.getAdapterManager().getAdapter(
					target.getProject(), IResource.class);
		}

		String[] dataruta = (String[]) aDropTargetEvent.data;
		String ruta = dataruta[0];
		File filewav = new File(ruta);
		File pathdestino = new File(destino);
		// Si no existe la carpeta audio, la crea.
		if (!pathdestino.exists()) {
			getDir(pathdestino);
		}

		// Comprobamos que el archivo ya no existe en el Modulo.
		IPath targetPath = targetRes.getFullPath().append(mDirBase)
				.append(filewav.getName());
		if (root.getFile(targetPath).exists()) {
			return Status.CANCEL_STATUS;
		}

		File rutadestino = new File(pathdestino, filewav.getName());

		copyFile(filewav, rutadestino);

		return Status.OK_STATUS;
	}

	/**
	 * @param filewav
	 * @param rutadestino
	 */
	protected void copyFile(File filewav, File rutadestino) {
		try {
			FileInputStream in = new FileInputStream(filewav.getAbsolutePath());
			FileOutputStream out = new FileOutputStream(
					rutadestino.getAbsolutePath());
			int c;
			while ((c = in.read()) != -1) {
				out.write(c);
			}

			in.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param pathname
	 * 
	 */
	protected void getDir(File path) {
		if (!path.exists()) {
			path.mkdirs();
		}
	}

	@Override
	public boolean isSupportedType(TransferData aTransferType) {
		return FileTransfer.getInstance().isSupportedType(aTransferType);

	}
}
