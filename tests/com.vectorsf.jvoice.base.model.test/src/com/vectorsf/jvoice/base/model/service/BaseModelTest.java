/**
 * 
 */
package com.vectorsf.jvoice.base.model.service;

import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * 
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class BaseModelTest extends BaseModelSuite {

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
		deleteProject(ResourcesPlugin.getWorkspace().getRoot().getProject("base"));
	}

	@Test
	public void testSanityCheck() {
		JVModel model = BaseModel.getInstance().getModel();
		assertNotNull(model);
		assertEquals(1, model.getProjects().size());

		assertThat(model.getProjects().get(0).getPackages(), hasSize(1));
	}

	@Test
	public void testNewPackage() {
		JVModel model = BaseModel.getInstance().getModel();
		assertNotNull(model);
		assertEquals(1, model.getProjects().size());

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
		assertNotNull(model);
		assertEquals(1, model.getProjects().size());

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
}