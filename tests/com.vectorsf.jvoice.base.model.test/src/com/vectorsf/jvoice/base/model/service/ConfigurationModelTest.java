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

import com.vectorsf.jvoice.model.base.Configuration;
import com.vectorsf.jvoice.model.base.JVModel;
import com.vectorsf.jvoice.model.base.JVProject;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

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
	public void testCreateProperties() {
		JVModel model = BaseModel.getInstance().getModel();

		JVProject jvProject = model.getProject(BASE);
		List<Configuration> configurations = jvProject.getConfiguration();
		assertThat(configurations, is(empty()));

		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(jvProject.getName());
		try {
			createFile(project, rutaProperties + "/test.properties",
					"uno=prueba\ndos=test\ntres=ejemplo\ncuatro=example\n");
		} catch (CoreException ce) {
			fail(ce.getMessage());
		}

		assertThat(configurations, hasSize(1));
		assertThat(configurations, Matchers.<Configuration> hasItem(hasProperty("name", is("test"))));
		Configuration test = configurations.get(0);

		assertThat(test.getParameters().keySet(), hasSize(4));
		assertThat(test.getParameters().keySet(), containsInAnyOrder("uno", "dos", "tres", "cuatro"));
	}

}
