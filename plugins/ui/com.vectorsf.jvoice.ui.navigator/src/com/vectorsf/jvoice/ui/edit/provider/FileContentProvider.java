package com.vectorsf.jvoice.ui.edit.provider;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.internal.ui.navigator.JavaNavigatorContentProvider;

import com.vectorsf.jvoice.model.base.JVModule;
import com.vectorsf.jvoice.model.base.JVProject;

public class FileContentProvider extends JavaNavigatorContentProvider {

	String path = "/src/main/resources/other";

	public FileContentProvider(String inPath) {
		path = inPath;
	}

	@Override
	public Object[] getChildren(Object object) {
		List lObjects = new ArrayList();

		if (object instanceof JVModule) {

			IProject prj = ResourcesPlugin.getWorkspace().getRoot()
					.getProject(((JVProject) object).getName());

			if (prj.getFolder(path).exists()) {
				object = prj.getFolder(path);
				lObjects.add(object);
			}

		} else if (object instanceof IFolder) {
			File directorio = new File(object.toString());
			if (directorio.getName().equals("audios")
					|| directorio.getName().equals("wsdl")) {
				Object[] children = super.getChildren(object);
				for (Object object2 : children) {
					lObjects.add(object2);
				}
			}

		}

		return lObjects.toArray();
	}
}
