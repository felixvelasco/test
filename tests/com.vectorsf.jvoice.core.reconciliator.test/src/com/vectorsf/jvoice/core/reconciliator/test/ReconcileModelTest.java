/**
 * 
 */
package com.vectorsf.jvoice.core.reconciliator.test;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVModel;
import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.base.JVProject;
import com.vectorsf.jvoice.model.operations.OperationsPackage;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.containsInAnyOrder;
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
public class ReconcileModelTest extends BaseModelResources {

	private static final String PAQ = "paq";
	private static final String BASE = "base";

	@BeforeClass
	public static void setClassUp() {
		@SuppressWarnings("unused")
		OperationsPackage einstance = OperationsPackage.eINSTANCE;
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xml", new XMIResourceFactoryImpl());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		IProject base = createProject(BASE);
		createFolders(base, ruta);
		createFolders(base, rutaProperties);
		createFolders(base, ruta + "/" + PAQ);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		for (IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
			try {
				deleteProject(project);
			} catch (CoreException ce) {
				fail(ce.getMessage());
			}
		}
	}

	@Test
	public void testSanityCheck() {
		JVModel model = BaseModel.getInstance().getModel();
		assertThat(model, is(not(nullValue())));
		assertThat(model.getProjects(), hasSize(1));
		assertThat(model.getProject(BASE), is(not(nullValue())));
		assertThat(model.getProject(BASE).getPackages(), hasSize(1));
		assertThat(model.getProject(BASE).getPackage(PAQ), is(not(nullValue())));
		assertThat(model.getProject(BASE).getPackage(PAQ).getBeans(), is(empty()));
	}

	@Test
	public void testNewPackage() {
		JVModel model = BaseModel.getInstance().getModel();

		JVProject jvProject = model.getProject(BASE);
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

		try {
			createFolders(project, ruta + "/otra/jerarquia/de/paquetes");
		} catch (CoreException ce) {
			fail(ce.getMessage());
		}

		assertThat(packages, hasSize(7));
		assertThat(packages, Matchers.<JVPackage> hasItem(hasProperty("name", is("otra.jerarquia.de.paquetes"))));
	}

	@Test
	public void testDeletePackage() {
		JVModel model = BaseModel.getInstance().getModel();

		JVProject jvProject = model.getProject(BASE);
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
			}, project);
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

		JVProject jvProject = model.getProject(BASE);
		List<JVPackage> packages = jvProject.getPackages();
		assertThat(packages, hasSize(1));

		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(jvProject.getName());
		try {
			deleteFolder(project, ruta + "/" + PAQ);
		} catch (CoreException ce) {
			fail(ce.getMessage());
		}

		assertThat(packages, is(empty()));
	}

	@Test
	public void testBeanCreation() {
		JVModel model = BaseModel.getInstance().getModel();

		JVProject jvProject = model.getProject(BASE);
		JVPackage pack = jvProject.getPackage(PAQ);
		assertThat(pack.getBeans(), is(empty()));

		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(jvProject.getName());
		final String bean1 = "one.jvflow";
		try {
			executeWksRunnable(new IWorkspaceRunnable() {

				@Override
				public void run(IProgressMonitor monitor) throws CoreException {
					createFile(project, ruta + "/" + PAQ + "/" + bean1, getInputStreamResource("one.jvflow"));
				}
			}, project);
		} catch (CoreException ce) {
			fail(ce.getMessage());
		}

		assertThat(pack.getBeans(), hasSize(1));
		assertThat(pack.getBeans(), Matchers.<JVBean> hasItem(hasProperty("name", is("one"))));

		final String bean2 = "two.jvflow";
		try {
			executeWksRunnable(new IWorkspaceRunnable() {

				@Override
				public void run(IProgressMonitor monitor) throws CoreException {
					createFile(project, ruta + "/" + PAQ + "/" + bean2, getInputStreamResource("two.jvflow"));
				}
			});
		} catch (CoreException ce) {
			fail(ce.getMessage());
		}

		@SuppressWarnings("unchecked")
		Matcher<Iterable<? extends JVBean>> containsOneAndTwo = containsInAnyOrder(
				Matchers.<JVBean> hasProperty("name", is("one")), Matchers.<JVBean> hasProperty("name", is("two")));

		assertThat(pack.getBeans(), hasSize(2));
		assertThat(pack.getBeans(), containsOneAndTwo);
	}

	@Test
	public void testBeanDelete() {
		JVModel model = BaseModel.getInstance().getModel();
		ResourceSet resourceSet = BaseModel.getInstance().getResourceSet();
		assertThat(resourceSet.getResources(), is(empty()));

		JVProject jvProject = model.getProject(BASE);
		JVPackage pack = jvProject.getPackage(PAQ);
		assertThat(pack.getBeans(), is(empty()));

		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(jvProject.getName());
		final String bean1 = "one.jvflow";
		final String bean2 = "two.jvflow";
		try {
			executeWksRunnable(new IWorkspaceRunnable() {

				@Override
				public void run(IProgressMonitor monitor) throws CoreException {
					createFile(project, ruta + "/" + PAQ + "/" + bean1, getInputStreamResource(bean1));
					createFile(project, ruta + "/" + PAQ + "/" + bean2, getInputStreamResource(bean2));
				}
			}, project);
		} catch (CoreException ce) {
			fail(ce.getMessage());
		}

		assertThat(resourceSet.getResources(), hasSize(2));
		assertThat(pack.getBeans(), hasSize(2));

		try {
			executeWksRunnable(new IWorkspaceRunnable() {

				@Override
				public void run(IProgressMonitor monitor) throws CoreException {
					deleteFile(project, ruta + "/" + PAQ + "/" + bean2);
				}
			}, project);
		} catch (CoreException ce) {
			fail(ce.getMessage());
		}

		assertThat(resourceSet.getResources(), hasSize(1));
		assertThat(pack.getBeans(), hasSize(1));

		try {
			executeWksRunnable(new IWorkspaceRunnable() {

				@Override
				public void run(IProgressMonitor monitor) throws CoreException {
					deleteFile(project, ruta + "/" + PAQ + "/" + bean1);
				}
			}, project);
		} catch (CoreException ce) {
			fail(ce.getMessage());
		}

		assertThat(pack.getBeans(), is(empty()));

		assertThat(BaseModel.getInstance().getResourceSet().getResources(), is(empty()));
	}

	@Test
	public void testBeanMove() {
		JVModel model = BaseModel.getInstance().getModel();

		JVProject jvProject = model.getProject(BASE);
		JVPackage paqPackage = jvProject.getPackage(PAQ);
		assertThat(paqPackage.getBeans(), is(empty()));

		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(jvProject.getName());
		final String bean1 = "one.jvflow";
		try {
			executeWksRunnable(new IWorkspaceRunnable() {

				@Override
				public void run(IProgressMonitor monitor) throws CoreException {
					createFile(project, ruta + "/" + PAQ + "/" + bean1, getInputStreamResource(bean1));
				}
			}, project);
		} catch (CoreException ce) {
			fail(ce.getMessage());
		}

		assertThat(paqPackage.getBeans(), hasSize(1));

		try {
			executeWksRunnable(new IWorkspaceRunnable() {

				@Override
				public void run(IProgressMonitor monitor) throws CoreException {
					createFolders(project, ruta + "/otro/paquete");
					IFile file = project.getFile(ruta + "/" + PAQ + "/" + bean1);
					IPath fullPath = project.getFile(ruta + "/otro/paquete/" + bean1).getFullPath();

					moveFile(file, fullPath);
				}
			});
		} catch (CoreException ce) {
			fail(ce.getMessage());
		}

		assertThat(paqPackage.getBeans(), is(empty()));
		assertThat(jvProject.getPackages(), hasSize(3));

		JVPackage otherPackage = jvProject.getPackage("otro.paquete");
		assertThat(otherPackage, is(not(nullValue())));
		assertThat(otherPackage.getBeans(), hasSize(1));
		assertThat(otherPackage.getBeans(), Matchers.<JVBean> hasItem(hasProperty("name", is("one"))));
	}

	@Test
	public void testUpdateTwoPackages() {
		JVModel model = BaseModel.getInstance().getModel();

		JVProject jvProject = model.getProject(BASE);
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
			}, project);
		} catch (CoreException ce) {
			fail(ce.getMessage());
		}

		assertThat(jvProject.getPackages(), hasSize(7));

		try {
			executeWksRunnable(new IWorkspaceRunnable() {

				@Override
				public void run(IProgressMonitor monitor) throws CoreException {
					createFile(project, ruta + "/paq/que/te/cuento/one.jvflow", getInputStreamResource("one.jvflow"));
					createFile(project, ruta + "/paq/que/te/cuento/two.jvflow", getInputStreamResource("two.jvflow"));
					createFile(project, ruta + "/el/mono/mario/three.jvflow", getInputStreamResource("three.jvflow"));
				}
			}, project);
		} catch (CoreException ce) {
			fail(ce.getMessage());
		}

		assertThat(jvProject.getPackage("paq.que.te.cuento").getBeans(), hasSize(2));
		assertThat(jvProject.getPackage("el.mono.mario").getBeans(), hasSize(1));
		assertThat(jvProject.getPackage("el.mono").getBeans(), is(empty()));
		assertThat(jvProject.getPackage("paq.que.te").getBeans(), is(empty()));
	}

	@Test
	public void testUpdateTwoProjects() {
		JVModel model = BaseModel.getInstance().getModel();

		JVProject jvProject = model.getProject(BASE);
		List<JVPackage> packages = jvProject.getPackages();
		assertThat(packages, hasSize(1));

		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(BASE);
		final String segundo = "segundo";
		try {
			executeWksRunnable(new IWorkspaceRunnable() {

				@Override
				public void run(IProgressMonitor monitor) throws CoreException {
					createProject(segundo);
				}
			});
		} catch (CoreException ce) {
			fail(ce.getMessage());
		}
		final IProject project2 = ResourcesPlugin.getWorkspace().getRoot().getProject(segundo);

		assertThat(model.getProjects(), hasSize(2));
		JVProject jvProject2 = model.getProject(segundo);
		List<JVPackage> packages2 = jvProject2.getPackages();
		assertThat(packages2, is(empty()));

		try {
			executeWksRunnable(new IWorkspaceRunnable() {

				@Override
				public void run(IProgressMonitor monitor) throws CoreException {
					createFile(project, ruta + "/paq/que/te/cuento/one.jvflow", getInputStreamResource("one.jvflow"));
					createFile(project, ruta + "/paq/que/te/cuento/two.jvflow", getInputStreamResource("two.jvflow"));
					createFile(project2, ruta + "/el/mono/mario/three.jvflow", getInputStreamResource("three.jvflow"));
				}
			});
		} catch (CoreException ce) {
			fail(ce.getMessage());
		}
		assertThat(jvProject.getPackages(), hasSize(4));
		assertThat(jvProject2.getPackages(), hasSize(3));

		assertThat(jvProject.getPackage("paq.que.te.cuento").getBeans(), hasSize(2));
		assertThat(jvProject.getPackage("paq.que.te").getBeans(), is(empty()));
		assertThat(jvProject2.getPackage("el.mono.mario").getBeans(), hasSize(1));
		assertThat(jvProject2.getPackage("el.mono").getBeans(), is(empty()));
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
		JVProject jvProject = model.getProject("base2");
		List<JVPackage> packages = jvProject.getPackages();
		assertThat(packages, hasSize(1));
		assertThat(jvProject.getPackage("paquetillo"), is(not(nullValue())));

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
		assertThat(model.getProject("base2"), is(not(nullValue())));
		assertThat(model.getProject("base3"), is(not(nullValue())));

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
