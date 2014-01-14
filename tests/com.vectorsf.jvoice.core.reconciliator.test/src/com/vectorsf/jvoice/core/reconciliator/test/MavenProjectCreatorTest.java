/**
 * 
 */
package com.vectorsf.jvoice.core.reconciliator.test;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.core.internal.resources.ResourceException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.graphiti.mm.algorithms.AlgorithmsPackage;
import org.eclipse.graphiti.mm.algorithms.styles.StylesPackage;
import org.eclipse.graphiti.mm.pictograms.PictogramsPackage;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;
import com.isb.bks.ivr.voice.dsl.VoiceDslStandaloneSetup;
import com.vectorsf.jvoice.core.reconciliator.MavenProjectCreator;
import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVModule;
import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.operations.OperationsPackage;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;

import static org.junit.Assert.fail;

import static com.vectorsf.jvoice.base.test.ResourcesHelper.CONFIG_PATH;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.JV_PATH;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.createFolders;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.createProject;
import static com.vectorsf.jvoice.base.test.ResourcesHelper.deleteProject;

/**
 * 
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class MavenProjectCreatorTest {

	private static final String PAQ = "paq";
	private static final String BASE = "base";

	public static final Bundle bundle = Platform.getBundle("com.vectorsf.jvoice.core.reconciliator");

	public static void setClassUp() {
		@SuppressWarnings("unused")
		OperationsPackage einstance = OperationsPackage.eINSTANCE; // DO NOT DELETE
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xml", new XMIResourceFactoryImpl());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		IProject base = createProject(BASE);
		createFolders(base, JV_PATH);
		createFolders(base, CONFIG_PATH);
		createFolders(base, JV_PATH + "/" + PAQ);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		for (IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
			try {
				while (true) {
					if (project.isSynchronized(2)) {
						try {
							deleteProject(project);
						} catch (ResourceException re) {
							IStatus status = re.getStatus();
							System.err.println(status);
							if (status.getException() != null) {
								status.getException().printStackTrace();
							}
							throw re;
						}
						break;
					} else {
						project.refreshLocal(2, null);
						Thread.sleep(3000);
					}
				}
			} catch (CoreException ce) {
				fail(ce.getMessage());
			}
		}
	}

	@Test
	public void testMavenProjectCreator() throws IOException, URISyntaxException {

		Injector injector = new VoiceDslStandaloneSetup().createInjectorAndDoEMFRegistration();

		EPackage.Registry.INSTANCE.put(OperationsPackage.eNS_URI, OperationsPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(PictogramsPackage.eNS_URI, PictogramsPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(AlgorithmsPackage.eNS_URI, AlgorithmsPackage.eINSTANCE);
		EPackage.Registry.INSTANCE.put(StylesPackage.eNS_URI, StylesPackage.eINSTANCE);

		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("jvflow", new XMIResourceFactoryImpl());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("projectInformation",
				new XMIResourceFactoryImpl());

		MavenProjectCreator mpc = new MavenProjectCreator();

		URL pluginLib;
		String prefixPluginLib;

		pluginLib = FileLocator.resolve(FileLocator.find(Platform.getBundle("com.vectorsf.jvoice.core.reconciliator"),
				new Path("resources/modP-1.0.0.jar"), null));

		pluginLib = new URL(pluginLib.toString().replace(" ", "%20")); //$NON-NLS-1$ //$NON-NLS-2$
		File bundleFileLib = new File(pluginLib.toURI());
		prefixPluginLib = bundleFileLib.getAbsolutePath();

		JVModule module = mpc.createProject(new Path(prefixPluginLib));
		assertThat(module, is(not(nullValue())));

		Matcher<Iterable<? super JVPackage>> hasPackageWithName = hasPackageWithName("pack1");
		assertThat(module.getPackages(), hasPackageWithName);
		hasPackageWithName = hasPackageWithName("pack2");

		Matcher<Iterable<? super JVBean>> hasBeanWithName = hasBeanWithName("f1");
		assertThat(module.getPackage("pack1").getBeans(), hasBeanWithName);
		hasBeanWithName = hasBeanWithName("f2");
		assertThat(module.getPackage("pack1").getBeans(), hasBeanWithName);
		hasBeanWithName = hasBeanWithName("f3");
		assertThat(module.getPackage("pack2").getBeans(), hasBeanWithName);

	}

	private Matcher<Iterable<? super JVPackage>> hasPackageWithName(String packName) {
		return Matchers.<JVPackage> hasItem(hasProperty("name", is(packName)));
	}

	private Matcher<Iterable<? super JVBean>> hasBeanWithName(String beanName) {
		return Matchers.<JVBean> hasItem(hasProperty("name", is(beanName)));
	}

}
