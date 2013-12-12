package com.isb.bks.ivr.voice.m2e.builder.internal;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.vectorsf.jvoice.base.model.service.BaseModel;

public class DeleteFileXML implements IResourceDeltaVisitor {

	private String target = "target/jVoice";
	private final static IPath pkgPath = new Path(BaseModel.JV_PATH);

	public DeleteFileXML() {
	}

	@Override
	public boolean visit(IResourceDelta delta) throws CoreException {
		IResource resource = delta.getResource();
		if (isValidFolder(resource)) {
			if (resource.getType() != IResource.FILE) {
				return true;
			}
			if (delta.getKind() == IResourceDelta.REMOVED) {
				IFile file = (IFile) resource;
				IPath ruta = file.getParent().getProjectRelativePath().makeRelativeTo(pkgPath);
				String name = file.getName().replace(".jvflow", "").trim();
				IPath pkgPathTarget = new Path(target + "/" + ruta);
				IFolder folderTarget = file.getProject().getFolder(pkgPathTarget);

				for (IResource member : folderTarget.members()) {
					if (member instanceof IFile) {
						String nameMember = member.getName().replace(".xml", "").trim();
						if (nameMember.equals(name)) {
							member.delete(false, null);
							deleteFolder(folderTarget);
						}
					}

				}

			}
		}

		return true;
	}

	private void deleteFolder(IFolder folderTarget) {
		try {
			if (folderTarget.members().length == 0) {
				folderTarget.delete(true, null);
				IFolder parent = (IFolder) folderTarget.getParent();
				String baseTarget = folderTarget.getProject().getName() + "/" + target;
				if (parent.exists() && !parent.getFullPath().makeRelative().toString().equals(baseTarget)
						&& parent.members().length == 0) {
					deleteFolder(parent);
				}

			}
		} catch (CoreException e) {
			e.printStackTrace();
		}

	}

	private boolean isValidFolder(IResource resource) {
		if (pkgPath.isPrefixOf(resource.getProjectRelativePath()) && !pkgPath.equals(resource.getProjectRelativePath())) {
			return true;
		} else {
			return false;
		}
	}
}
