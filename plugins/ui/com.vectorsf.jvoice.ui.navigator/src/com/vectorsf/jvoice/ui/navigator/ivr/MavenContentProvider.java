package com.vectorsf.jvoice.ui.navigator.ivr;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.ui.navigator.JavaNavigatorContentProvider;
import org.eclipse.jdt.internal.ui.packageview.ClassPathContainer;

import com.vectorsf.jvoice.model.base.JVProject;



@SuppressWarnings("restriction")
public class MavenContentProvider extends JavaNavigatorContentProvider {
	
	private IPath mavenPath = new Path("org.eclipse.m2e.MAVEN2_CLASSPATH_CONTAINER");

	@Override
	public Object[] getChildren(Object object) {
		if (object instanceof JVProject) {
			IProject prj = ResourcesPlugin.getWorkspace().getRoot().getProject(((JVProject) object).getName());
			IJavaProject project = JavaCore.create(prj);
			
			if (!project.getProject().isOpen())
				return NO_CHILDREN;
	
			try {
				IClasspathEntry[] rawClasspath= project.getRawClasspath();
				for (int i= 0; i < rawClasspath.length; i++) {
					IClasspathEntry classpathEntry= rawClasspath[i];
					System.out.println(classpathEntry.getPath());
					if (classpathEntry.getEntryKind() == IClasspathEntry.CPE_CONTAINER && classpathEntry.getPath().equals(mavenPath)) {
						return new Object[] {new ClassPathContainer(project, classpathEntry) };
					}
				}
			} catch (JavaModelException e) {
				e.printStackTrace();
			}
			return new Object [0];
		}
	
		return super.getChildren(object);
	}
}
