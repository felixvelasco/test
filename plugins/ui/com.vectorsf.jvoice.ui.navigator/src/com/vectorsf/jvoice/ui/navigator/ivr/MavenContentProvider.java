package com.vectorsf.jvoice.ui.navigator.ivr;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.ui.navigator.JavaNavigatorContentProvider;
import org.eclipse.jdt.internal.ui.packageview.ClassPathContainer;

import com.vectorsf.jvoice.model.base.JVProject;

@SuppressWarnings("restriction")
public class MavenContentProvider extends JavaNavigatorContentProvider {

	private IPath mavenPath = new Path(
			"org.eclipse.m2e.MAVEN2_CLASSPATH_CONTAINER");

	private static final String EXCLUCION_PATTERNT = "**";

	@Override
	public Object[] getChildren(Object object) {
		if (object instanceof JVProject) {
			IProject prj = ResourcesPlugin.getWorkspace().getRoot()
					.getProject(((JVProject) object).getName());
			IJavaProject project = JavaCore.create(prj);

			if (!project.getProject().isOpen()) {
				return NO_CHILDREN;
			}
			boolean hayElementos = false;
			List<Object> result = new ArrayList<Object>();
			try {
				IClasspathEntry[] rawClasspath = project.getRawClasspath();

				for (int i = 0; i < rawClasspath.length; i++) {
					IClasspathEntry classpathEntry = rawClasspath[i];
					String cadenaExcluxion = null;

					for (IPath excluxion : classpathEntry
							.getExclusionPatterns()) {

						if (excluxion.toString().equals(EXCLUCION_PATTERNT)) {
							cadenaExcluxion = excluxion.toString();
						}

					}

					if (classpathEntry.getEntryKind() == IClasspathEntry.CPE_CONTAINER
							&& classpathEntry.getPath().equals(mavenPath)) {
						result.add(new ClassPathContainer(project,
								classpathEntry));
						hayElementos = true;

					} else if (classpathEntry.getEntryKind() == IClasspathEntry.CPE_SOURCE
							&& cadenaExcluxion == null) {

						IPackageFragmentRoot root = project
								.findPackageFragmentRoot(classpathEntry
										.getPath());
						if (root != null) {
							result.add(root);
							hayElementos = true;
						}
					}

				}
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
			if (hayElementos) {
				return result.toArray();
			} else {
				return new Object[0];
			}
		}

		return super.getChildren(object);
	}

}
