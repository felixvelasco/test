/**
 * 
 */
package com.vectorsf.jvoice.base.model.service;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import com.vectorsf.jvoice.model.base.Configuration;
import com.vectorsf.jvoice.model.base.JVModel;
import com.vectorsf.jvoice.model.base.JVProject;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.contains;
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
public class ConfigurationModelTest extends BaseModelResources {

	private static final String BASE = "base";

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		IProject base = createProject(BASE);
		createFolders(base, ruta);
		createFolders(base, rutaProperties);
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
	public void testCreateProperties() throws CoreException {
		JVModel model = BaseModel.getInstance().getModel();

		JVProject jvProject = model.getProject(BASE);
		List<Configuration> configurations = jvProject.getConfiguration();
		assertThat(configurations, is(empty()));

		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(jvProject.getName());
		executeWksRunnable(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				createFile(project, rutaProperties + "/test.properties",
						"uno=prueba\ndos=test\ntres=ejemplo\ncuatro=example\n");
			}
		}, project);

		assertThat(configurations, hasSize(1));
		assertThat(configurations, Matchers.<Configuration> hasItem(hasProperty("name", is("test"))));
		Configuration test = configurations.get(0);

		assertThat(test.getParameters().keySet(), hasSize(4));
		assertThat(test.getParameters().keySet(), containsInAnyOrder("uno", "dos", "tres", "cuatro"));
	}

	@Test
	public void testCreateNonPropertiesFiles() throws CoreException {
		JVModel model = BaseModel.getInstance().getModel();

		JVProject jvProject = model.getProject(BASE);
		List<Configuration> configurations = jvProject.getConfiguration();
		assertThat(configurations, is(empty()));

		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(jvProject.getName());
		executeWksRunnable(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				createFile(project, rutaProperties + "/test.nonproperties",
						"uno=prueba\ndos=test\ntres=ejemplo\ncuatro=example\n");
			}
		}, project);

		assertThat(configurations, is(empty()));

		executeWksRunnable(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				createFolders(project, rutaProperties + "/folder.properties");
			}
		}, project);

		assertThat(configurations, is(empty()));

	}

	@Test
	public void testCreatePropertiesAndNonProperties() throws CoreException {
		JVModel model = BaseModel.getInstance().getModel();

		JVProject jvProject = model.getProject(BASE);
		List<Configuration> configurations = jvProject.getConfiguration();
		assertThat(configurations, is(empty()));

		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(jvProject.getName());
		executeWksRunnable(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				createFile(project, rutaProperties + "/test.properties",
						"uno=prueba\ndos=test\ntres=ejemplo\ncuatro=example\n");
				createFile(project, rutaProperties + "/otherTest.nonProperties",
						"one=prueba\ntwo=test\nthree=ejemplo\nfour=example\n");
			}
		}, project);

		assertThat(configurations, hasSize(1));
		assertThat(configurations, Matchers.<Configuration> hasItem(hasProperty("name", is("test"))));
		Configuration test = configurations.get(0);

		assertThat(test.getParameters().keySet(), hasSize(4));
		assertThat(test.getParameters().keySet(), containsInAnyOrder("uno", "dos", "tres", "cuatro"));
	}

	@Test
	public void testCreateProjectWithProperties() throws CoreException {
		JVModel model = BaseModel.getInstance().getModel();

		executeWksRunnable(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				IProject project = createProject("testing");
				createFile(project, rutaProperties + "/test.properties",
						"uno=prueba\ndos=test\ntres=ejemplo\ncuatro=example\n");
				createFile(project, rutaProperties + "/otherTest.properties",
						"one=prueba\ntwo=test\nthree=ejemplo\nfour=example\n");
				createFile(project, rutaProperties + "/otherTest.nonProperties",
						"un=prueba\ndeux=test\ntrois=ejemplo\nquatre=example\n");
			}
		});

		JVProject project = model.getProject("testing");
		assertThat(project, is(not(nullValue())));
		List<Configuration> configurations = project.getConfiguration();

		assertThat(configurations, hasSize(2));
		@SuppressWarnings("unchecked")
		Matcher<Iterable<? extends Configuration>> containsTestAndOtherTest = containsInAnyOrder(
				Matchers.<Configuration> hasProperty("name", is("test")),
				Matchers.<Configuration> hasProperty("name", is("otherTest")));
		assertThat(configurations, containsTestAndOtherTest);

		Configuration test = project.getConfiguration("test");
		assertThat(test.getParameters().keySet(), hasSize(4));
		assertThat(test.getParameters().keySet(), containsInAnyOrder("uno", "dos", "tres", "cuatro"));

		Configuration otherTest = project.getConfiguration("otherTest");
		assertThat(otherTest.getParameters().keySet(), hasSize(4));
		assertThat(otherTest.getParameters().keySet(), containsInAnyOrder("one", "two", "three", "four"));
	}

	@Test
	public void testDeleteTwoProperties() throws CoreException {
		JVModel model = BaseModel.getInstance().getModel();

		JVProject jvProject = model.getProject(BASE);
		List<Configuration> configurations = jvProject.getConfiguration();
		assertThat(configurations, is(empty()));

		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(jvProject.getName());
		executeWksRunnable(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				createFile(project, rutaProperties + "/test.properties",
						"uno=prueba\ndos=test\ntres=ejemplo\ncuatro=example\n");
				createFile(project, rutaProperties + "/test2.properties",
						"uno=prueba\ndos=test\ntres=ejemplo\ncuatro=example\n");
			}
		}, project);

		assertThat(configurations, hasSize(2));
		assertThat(configurations, Matchers.<Configuration> hasItem(hasProperty("name", is("test"))));
		assertThat(configurations, Matchers.<Configuration> hasItem(hasProperty("name", is("test2"))));
		Configuration test = configurations.get(0);

		assertThat(test.getParameters().keySet(), hasSize(4));
		assertThat(test.getParameters().keySet(), containsInAnyOrder("uno", "dos", "tres", "cuatro"));

		executeWksRunnable(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				deleteFile(project, rutaProperties + "/test2.properties");
			}
		});

		assertThat(configurations, hasSize(1));
		assertThat(configurations, Matchers.<Configuration> hasItem(hasProperty("name", is("test"))));

		executeWksRunnable(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				deleteFile(project, rutaProperties + "/test.properties");
			}
		}, project);

		assertThat(configurations, is(empty()));
	}

	@Test
	public void testDeleteTwoPropertiesAtOnce() throws CoreException {
		JVModel model = BaseModel.getInstance().getModel();

		JVProject jvProject = model.getProject(BASE);
		List<Configuration> configurations = jvProject.getConfiguration();
		assertThat(configurations, is(empty()));

		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(jvProject.getName());
		executeWksRunnable(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				createFile(project, rutaProperties + "/test.properties",
						"uno=prueba\ndos=test\ntres=ejemplo\ncuatro=example\n");
				createFile(project, rutaProperties + "/test2.properties",
						"uno=prueba\ndos=test\ntres=ejemplo\ncuatro=example\n");
			}
		}, project);

		assertThat(configurations, hasSize(2));
		assertThat(configurations, Matchers.<Configuration> hasItem(hasProperty("name", is("test"))));
		assertThat(configurations, Matchers.<Configuration> hasItem(hasProperty("name", is("test2"))));
		Configuration test = configurations.get(0);

		assertThat(test.getParameters().keySet(), hasSize(4));
		assertThat(test.getParameters().keySet(), containsInAnyOrder("uno", "dos", "tres", "cuatro"));

		executeWksRunnable(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				deleteFile(project, rutaProperties + "/test2.properties");
				deleteFile(project, rutaProperties + "/test.properties");
			}
		}, project);

		assertThat(configurations, is(empty()));
	}

	@Test(timeout = 5000)
	public void testPerfCreateProperties() throws CoreException {
		JVModel model = BaseModel.getInstance().getModel();

		JVProject jvProject = model.getProject(BASE);
		List<Configuration> configurations = jvProject.getConfiguration();
		assertThat(configurations, is(empty()));

		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(jvProject.getName());
		executeWksRunnable(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				for (int i = 0; i < 100; i++) {
					createFile(project, rutaProperties + "/test" + i + ".properties",
							"uno=prueba\ndos=test\ntres=ejemplo\ncuatro=example\n");
				}
			}
		}, project);

		assertThat(configurations, hasSize(100));
	}

	@Test
	public void testUpdateProperties() throws CoreException {
		JVModel model = BaseModel.getInstance().getModel();

		JVProject jvProject = model.getProject(BASE);
		List<Configuration> configurations = jvProject.getConfiguration();
		assertThat(configurations, is(empty()));

		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(jvProject.getName());
		final IFile[] file = new IFile[1];
		executeWksRunnable(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				file[0] = createFile(project, rutaProperties + "/test.properties",
						"uno=prueba\ndos=test\ntres=ejemplo\ncuatro=example\n");
			}
		}, project);
		assertThat(configurations, hasSize(1));
		assertThat(configurations, Matchers.<Configuration> hasItem(hasProperty("name", is("test"))));
		Configuration test = configurations.get(0);

		assertThat(test.getParameters().keySet(), hasSize(4));
		assertThat(test.getParameters().keySet(), containsInAnyOrder("uno", "dos", "tres", "cuatro"));

		executeWksRunnable(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				updateFile(file[0], "one=prueba\ntwo=test\nthree=ejemplo\nfour=example\n");
			}
		});

		assertThat(configurations, contains(test));
		assertThat(test.getParameters().keySet(), hasSize(4));
		assertThat(test.getParameters().keySet(), containsInAnyOrder("one", "two", "three", "four"));

	}

	@Test
	public void testRenameProperties() throws CoreException {
		JVModel model = BaseModel.getInstance().getModel();

		JVProject jvProject = model.getProject(BASE);
		List<Configuration> configurations = jvProject.getConfiguration();
		assertThat(configurations, is(empty()));

		final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(jvProject.getName());
		final IFile[] file = new IFile[1];
		executeWksRunnable(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				file[0] = createFile(project, rutaProperties + "/test.properties",
						"uno=prueba\ndos=test\ntres=ejemplo\ncuatro=example\n");
			}
		}, project);

		assertThat(configurations, hasSize(1));
		assertThat(configurations, Matchers.<Configuration> hasItem(hasProperty("name", is("test"))));
		Configuration test = configurations.get(0);

		assertThat(test.getParameters().keySet(), hasSize(4));
		assertThat(test.getParameters().keySet(), containsInAnyOrder("uno", "dos", "tres", "cuatro"));

		executeWksRunnable(new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				moveFile(file[0], file[0].getParent().getFullPath().append("test2.properties"));
			}
		});

		assertThat(configurations, hasSize(1));
		assertThat(configurations, Matchers.<Configuration> hasItem(hasProperty("name", is("test2"))));
		Configuration test2 = configurations.get(0);

		assertThat(test2.getParameters().keySet(), hasSize(4));
		assertThat(test2.getParameters().keySet(), containsInAnyOrder("uno", "dos", "tres", "cuatro"));

	}
}
