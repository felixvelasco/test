/**
 * 
 */
package com.vectorsf.jvoice.base.model.service;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.vectorsf.jvoice.model.base.JVModel;
import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.base.JVProject;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

import static org.junit.Assert.fail;

/**
 * 
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class BaseModelTest extends BaseModelResources {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		IProject base = createProject("base");
		createFolders(base, ruta);
		createFolders(base, rutaProperties);
		createFolders(base, ruta + "/paq");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("Tamaño " + ResourcesPlugin.getWorkspace().getRoot().getProjects().length);
		for (IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
			try {
				deleteProject(project);
			} catch (CoreException ce) {
				fail(ce.getMessage());
			}
		}
		System.out.println("Tamaño despues : " + ResourcesPlugin.getWorkspace().getRoot().getProjects().length);
	}

	@Test
	public void testSanityCheck() {
		JVModel model = BaseModel.getInstance().getModel();
		assertThat(model, is(not(nullValue())));
		assertThat(model.getProjects(), hasSize(1));

		assertThat(model.getProjects().get(0).getPackages(), hasSize(1));
	}

	@Test
	public void testNewPackage() {
		JVModel model = BaseModel.getInstance().getModel();

		JVProject jvProject = model.getProjects().get(0);
		List<JVPackage> packages = jvProject.getPackages();
		assertThat(packages, hasSize(1));

		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(jvProject.getName());
		try {
			createFolders(project, ruta + "/paq1");
		} catch (CoreException ce) {
			fail(ce.getMessage());
		}

		assertThat(packages, hasSize(2));
		assertThat(packages, Matchers.<JVPackage> hasItem(hasProperty("name", is("paq1"))));

		try {
			createFolders(project, ruta + "/paq/uete");
		} catch (CoreException ce) {
			fail(ce.getMessage());
		}

		assertThat(packages, hasSize(3));
		assertThat(packages, Matchers.<JVPackage> hasItem(hasProperty("name", is("paq.uete"))));
	}

	@Test
	public void testDeletePackage() {
		JVModel model = BaseModel.getInstance().getModel();

		JVProject jvProject = model.getProjects().get(0);
		List<JVPackage> packages = jvProject.getPackages();
		assertThat(packages, hasSize(1));

		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(jvProject.getName());
		try {
			executeWksRunnable(new IWorkspaceRunnable() {
				@Override
				public void run(IProgressMonitor monitor) throws CoreException {
					createFolders(project, ruta + "/paq1");
					createFolders(project, ruta + "/paq2");
				}
			});
		} catch (CoreException ce) {
			fail(ce.getMessage());
		}

		assertThat(packages, hasSize(3));
		assertThat(packages, Matchers.<JVPackage> hasItem(hasProperty("name", is("paq1"))));
		assertThat(packages, Matchers.<JVPackage> hasItem(hasProperty("name", is("paq2"))));
	}

	@Test
	public void testChangeTwoPackages() {
		JVModel model = BaseModel.getInstance().getModel();

		JVProject jvProject = model.getProjects().get(0);
		List<JVPackage> packages = jvProject.getPackages();
		assertThat(packages, hasSize(1));

		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(jvProject.getName());
		try {
			deleteFolder(project, ruta + "/paq");
		} catch (CoreException ce) {
			fail(ce.getMessage());
		}

		assertThat(packages, is(empty()));
	}

	@Test
	public void testUpdateTwoPackages() {
		JVModel model = BaseModel.getInstance().getModel();

		JVProject jvProject = model.getProjects().get(0);
		List<JVPackage> packages = jvProject.getPackages();
		assertThat(packages, hasSize(1));

		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(jvProject.getName());
		try {
			executeWksRunnable(new IWorkspaceRunnable() {

				@Override
				public void run(IProgressMonitor monitor) throws CoreException {
					createFolders(project, ruta + "/paq/que/te/cuento");
					createFolders(project, ruta + "/el/mono/mario");
				}
			});
		} catch (CoreException ce) {
			fail(ce.getMessage());
		}

		assertThat(jvProject.getPackages(), hasSize(7));

		try {
			executeWksRunnable(new IWorkspaceRunnable() {

				@Override
				public void run(IProgressMonitor monitor) throws CoreException {
					createFile(project, ruta + "/paq/que/te/cuento/primer.bean", "asd");
					createFile(project, ruta + "/paq/que/te/cuento/segundo.bean", "zxc");
				}
			});
		} catch (CoreException ce) {
			fail(ce.getMessage());
		}

		assertThat(jvProject.getPackages(), hasSize(7));
	}

	@Test
	public void testDeleteProject() {
		JVModel model = BaseModel.getInstance().getModel();

		try {
			executeWksRunnable(new IWorkspaceRunnable() {
				@Override
				public void run(IProgressMonitor monitor) throws CoreException {
					IProject base = createProject("base2");
					createFolders(base, ruta + "/paquetillo");
				}
			});
		} catch (CoreException ce) {
			fail(ce.getMessage());
		}

		assertThat(model.getProjects(), hasSize(2));
		JVProject jvProject = model.getProjects().get(1);
		List<JVPackage> packages = jvProject.getPackages();
		assertThat(packages, hasSize(1));
		assertThat(packages, Matchers.<JVPackage> hasItem(hasProperty("name", is("paquetillo"))));

		try {
			executeWksRunnable(new IWorkspaceRunnable() {
				@Override
				public void run(IProgressMonitor monitor) throws CoreException {
					deleteProject(ResourcesPlugin.getWorkspace().getRoot().getProject("base2"));
				}
			});
		} catch (CoreException ce) {
			fail(ce.getMessage());
		}

		assertThat(model.getProjects(), hasSize(1));
	}

	@Test
	public void testDeleteProjects() {
		JVModel model = BaseModel.getInstance().getModel();

		final IProject[] prjs = new IProject[2];
		try {
			executeWksRunnable(new IWorkspaceRunnable() {
				@Override
				public void run(IProgressMonitor monitor) throws CoreException {
					prjs[0] = createProject("base2");
					createFolders(prjs[0], ruta + "/paquetillo");

					prjs[1] = createProject("base3");
					createFolders(prjs[1], ruta + "/paquete/cuento");
				}
			});
		} catch (CoreException ce) {
			fail(ce.getMessage());
		}

		assertThat(model.getProjects(), hasSize(3));
		assertThat(model.getProjects(), Matchers.<JVProject> hasItem(hasProperty("name", is("base2"))));
		assertThat(model.getProjects(), Matchers.<JVProject> hasItem(hasProperty("name", is("base3"))));

		try {
			executeWksRunnable(new IWorkspaceRunnable() {
				@Override
				public void run(IProgressMonitor monitor) throws CoreException {
					deleteProject(prjs[0]);
					deleteProject(prjs[1]);
				}
			});
		} catch (CoreException ce) {
			fail(ce.getMessage());
		}

		assertThat(model.getProjects(), hasSize(1));
	}
}
