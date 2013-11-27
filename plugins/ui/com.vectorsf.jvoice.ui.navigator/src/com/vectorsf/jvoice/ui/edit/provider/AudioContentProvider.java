package com.vectorsf.jvoice.ui.edit.provider;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.internal.ui.navigator.JavaNavigatorContentProvider;

import com.vectorsf.jvoice.model.base.JVModule;
import com.vectorsf.jvoice.model.base.JVProject;

public class AudioContentProvider extends JavaNavigatorContentProvider {

	private static final String AUDIO_PATH = "/src/main/resources/audios";
	private static ResourceSetImpl resourceSet = new ResourceSetImpl();

	@Override
	public Object[] getChildren(Object object) {
		List lObjects = new ArrayList();

		if (object instanceof JVModule) {

			IProject prj = ResourcesPlugin.getWorkspace().getRoot()
					.getProject(((JVProject) object).getName());

			if (prj.getFolder(AUDIO_PATH).exists()) {
				System.out.println("guay");
				object = prj.getFolder(AUDIO_PATH);
				lObjects.add(object);

			} else {
				System.out.println("puag");
			}

		} else if (object instanceof IFolder) {
			File directorio = new File(object.toString());
			if (directorio.getName().equals("audios")) {
				Object[] children = super.getChildren(object);
				for (Object object2 : children) {
					lObjects.add(object2);
				}
			}

		}

		return lObjects.toArray();
	}
}
