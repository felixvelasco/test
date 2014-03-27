package com.vectorsf.jvoice.core.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.maven.model.Build;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.Plugin;
import org.apache.maven.model.PluginExecution;
import org.apache.maven.model.Repository;
import org.codehaus.plexus.util.xml.Xpp3Dom;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.m2e.core.MavenPlugin;
import org.eclipse.m2e.core.project.ProjectImportConfiguration;
import org.eclipse.xtext.ui.XtextProjectHelper;

public final class JVoiceProjectConfigurator {

	private JVoiceProjectConfigurator() {
	}

	public static void configureProject(final IProject project) throws CoreException {
		assert project.exists();

		ResourcesPlugin.getWorkspace()
				.run(new AddJVoiceNatureRunnable(project), project, IWorkspace.AVOID_UPDATE, null);

	}

	public static IProject createProject(final String groupId, final String artifactId, final String projectName,
			final String descriptionProject, IProgressMonitor monitor) throws CoreException {
		final IProject result[] = new IProject[1];
		SubProgressMonitor sub1 = new SubProgressMonitor(monitor, 85);
		IWorkspaceRunnable action = new IWorkspaceRunnable() {

			@Override
			public void run(IProgressMonitor monitor) throws CoreException {
				IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
				ProjectImportConfiguration configuration = new ProjectImportConfiguration();
				configuration.getResolverConfiguration().setResolveWorkspaceProjects(false);
				MavenPlugin.getProjectConfigurationManager().createSimpleProject(project, null,
						getModel(groupId, artifactId, projectName, descriptionProject),
						new String[] { "src/main/java", "src/main/resources/jv"}, configuration, monitor);

				result[0] = project;
			}
		};

		ResourcesPlugin.getWorkspace().run(action, sub1);
		IProject project = result[0];
		SubProgressMonitor sub2 = new SubProgressMonitor(monitor, 10);
		ResourcesPlugin.getWorkspace().run(new AddJVoiceNatureRunnable(project), sub2);

		String carpetaBeans = JVoiceModuleNature.getDefaultComponentsPackageName(project.getName());
		IJavaProject javaProject = JavaCore.create(result[0]);
		IFolder folder = project.getFolder("src/main/java");
		IPackageFragmentRoot defaultPackage = javaProject.getPackageFragmentRoot(folder);

		defaultPackage.createPackageFragment(carpetaBeans, true, null);
		monitor.worked(5);
		monitor.done();

		return result[0];
	}

	private static Model getModel(String groupId, String artifactId, String projectName, String descriptionProject) {
		Model model = new Model();
		model.setModelVersion("4.0.0"); //$NON-NLS-1$

		model.setGroupId(groupId);
		model.setArtifactId(artifactId);
		model.setVersion("1.0.0-SNAPSHOT");
		model.setPackaging("jar");
		Properties pro = new Properties();
		pro.put("wsdlRoot","src/main/resources/META-INF/wsdl");
		model.setProperties(pro);

		model.setName(projectName);
		model.setDescription(descriptionProject);
		
		List<Dependency> dependencies = new ArrayList<Dependency>();
		Dependency jvFlow = new Dependency();
		jvFlow.setGroupId("com.vectorsf");
		jvFlow.setArtifactId("jvoiceframework-flow");
		jvFlow.setVersion(AbstractJVoiceNature.JVOICE_FRAMEWORK_VERSION);
		dependencies.add(jvFlow);
		model.setDependencies(dependencies);

		Plugin dsl_builder = new Plugin();
		dsl_builder.setGroupId("com.vectorsf.jvoice");
		dsl_builder.setArtifactId("dsl-builder");
		dsl_builder.setVersion(AbstractJVoiceNature.JVOICE_COMPILER_VERSION);
		PluginExecution voiceDSL = new PluginExecution();
		voiceDSL.setPhase("generate-sources");
		voiceDSL.addGoal("generateFlow");
		dsl_builder.addExecution(voiceDSL);

		Plugin dsl_builder2 = new Plugin();
		dsl_builder2.setGroupId("com.vectorsf.jvoice");
		dsl_builder2.setArtifactId("dsl-builder");
		dsl_builder2.setVersion(AbstractJVoiceNature.JVOICE_COMPILER_VERSION);
		PluginExecution voiceDSL2 = new PluginExecution();
		voiceDSL2.setPhase("initialize");
		voiceDSL2.addGoal("prepareWSDLSources");

		dsl_builder2.addExecution(voiceDSL2);
		
		Plugin dsl_builder3 = new Plugin();
		dsl_builder3.setGroupId("org.apache.maven.plugins");
		dsl_builder3.setArtifactId("maven-compiler-plugin");
		dsl_builder3.setVersion("2.3.2");

		Xpp3Dom configuration = new Xpp3Dom("configuration");

		Xpp3Dom source = new Xpp3Dom("source");
		source.setValue("1.7");
		configuration.addChild(source);

		Xpp3Dom target = new Xpp3Dom("target");
		target.setValue("1.7");
		configuration.addChild(target);

		Xpp3Dom encoding = new Xpp3Dom("encoding");
		encoding.setValue("UTF-8");
		configuration.addChild(encoding);

		dsl_builder3.setConfiguration(configuration);

		Plugin ws_pol = new Plugin();
		ws_pol.setGroupId("org.apache.cxf");
		ws_pol.setArtifactId("cxf-codegen-plugin");
		ws_pol.setVersion("2.7.8");
		PluginExecution pexecution = new PluginExecution();
		pexecution.addGoal("wsdl2java");
		pexecution.setId("generate-sources");
		pexecution.setPhase("generate-sources");

		Xpp3Dom configuration4 = new Xpp3Dom("configuration");

		Xpp3Dom sourceRoot = new Xpp3Dom("sourceRoot");
		sourceRoot.setValue("src/generated-sources/wsdl2java");
		configuration4.addChild(sourceRoot);
		
		Xpp3Dom defaultOptions = new Xpp3Dom("defaultOptions");
		configuration4.addChild(defaultOptions);
		
		Xpp3Dom extraargs = new Xpp3Dom("extraargs");
		defaultOptions.addChild(extraargs);
		
		Xpp3Dom extraarg1 = new Xpp3Dom("extraarg");
		extraarg1.setValue("-client");
		extraargs.addChild(extraarg1);
		
		Xpp3Dom extraarg2 = new Xpp3Dom("extraarg");
		extraarg2.setValue("-autoNameResolution");
		extraargs.addChild(extraarg2);
		
		Xpp3Dom extraarg3 = new Xpp3Dom("extraarg");
		extraarg3.setValue("-verbose");
		extraargs.addChild(extraarg3);
		
		
		Xpp3Dom wsdlOptions = new Xpp3Dom("wsdlOptions");
		configuration4.addChild(wsdlOptions);

		pexecution.setConfiguration(configuration4);

		ws_pol.addExecution(pexecution);

		
		
		Build build = new Build();
		build.addPlugin(dsl_builder);
		build.addPlugin(dsl_builder2);
		build.addPlugin(dsl_builder3);
		build.addPlugin(ws_pol);

		model.setBuild(build);

		Repository repository = new Repository();
		repository.setId(AbstractJVoiceNature.JVOICE_REPOSITORY_ID);
		repository.setName(AbstractJVoiceNature.JVOICE_REPOSITORY_NAME);
		repository.setUrl(AbstractJVoiceNature.JVOICE_REPOSITORY_URL);

		model.addRepository(repository);
		model.addPluginRepository(repository);

		return model;
	}

	private static final class AddJVoiceNatureRunnable implements IWorkspaceRunnable {
		private final IProject project;

		private AddJVoiceNatureRunnable(IProject project) {
			this.project = project;
		}

		@Override
		public void run(IProgressMonitor monitor) throws CoreException {
			IProjectDescription description = project.getDescription();
			String[] natureIds = description.getNatureIds();

			String[] newNatureIds = new String[natureIds.length + 2];
			System.arraycopy(natureIds, 0, newNatureIds, 1, natureIds.length);
			newNatureIds[0] = JVoiceModuleNature.NATURE_ID;
			newNatureIds[newNatureIds.length - 1] = XtextProjectHelper.NATURE_ID;
			description.setNatureIds(newNatureIds);

			this.project.setDescription(description, null);
		}
	}

}
