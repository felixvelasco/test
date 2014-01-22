package com.vectorsf.jvoice.core.project;

import java.util.ArrayList;
import java.util.List;

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
						new String[] { "src/main/java", "src/main/resources/jv" }, configuration, monitor);

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

		model.setName(projectName);
		model.setDescription(descriptionProject);
		
		List<Dependency> dependencies = new ArrayList<Dependency>();
		Dependency jvFlow = new Dependency();
		jvFlow.setGroupId("com.vectorsf");
		jvFlow.setArtifactId("jvoiceframework-flow");
		jvFlow.setVersion("1.0-SNAPSHOT");
		dependencies.add(jvFlow);
		model.setDependencies(dependencies);

		Plugin dsl_builder = new Plugin();
		dsl_builder.setGroupId("com.vectorsf.jvoice");
		dsl_builder.setArtifactId("dsl-builder");
		dsl_builder.setVersion("0.0.2-SNAPSHOT");
		PluginExecution voiceDSL = new PluginExecution();
		voiceDSL.setPhase("generate-sources");
		voiceDSL.addGoal("generateFlow");
		dsl_builder.addExecution(voiceDSL);

		Plugin dsl_builder2 = new Plugin();
		dsl_builder2.setGroupId("com.vectorsf.jvoice");
		dsl_builder2.setArtifactId("dsl-builder");
		dsl_builder2.setVersion("0.0.2-SNAPSHOT");
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
		ws_pol.setGroupId("org.jvnet.jax-ws-commons");
		ws_pol.setArtifactId("jaxws-maven-plugin");
		ws_pol.setVersion("2.3");
		PluginExecution pexecution = new PluginExecution();
		pexecution.addGoal("wsimport");

		Xpp3Dom configuration4 = new Xpp3Dom("configuration");

		Xpp3Dom wsdlDirectory = new Xpp3Dom("wsdlDirectory");
		wsdlDirectory.setValue("src/main/resources/META-INF/wsdl");
		configuration4.addChild(wsdlDirectory);
		
		Xpp3Dom wsdlXjcArgs = new Xpp3Dom("xjcArgs");
		configuration4.addChild(wsdlXjcArgs);
		
		Xpp3Dom wsdlXjcArg = new Xpp3Dom("xjcArg");
		wsdlXjcArg.setValue("-XautoNameResolution");
		wsdlXjcArgs.addChild(wsdlXjcArg);
		
	
		String sPaquete = JVoiceModuleNature
				.getDefaultWSDLPackageName(projectName);
		Xpp3Dom wsdlLocation = new Xpp3Dom("wsdlLocation");
		wsdlLocation.setValue("http://" + sPaquete + ".*");
		configuration4.addChild(wsdlLocation);

		Xpp3Dom sourceDestDir = new Xpp3Dom("sourceDestDir");
		sourceDestDir.setValue("src/generated-sources/wsimport");
		configuration4.addChild(sourceDestDir);

		Xpp3Dom wsdlFiles = new Xpp3Dom("wsdlFiles");
		pexecution.setConfiguration(wsdlFiles);

		configuration4.addChild(wsdlFiles);

		Xpp3Dom keep = new Xpp3Dom("keep");
		keep.setValue("true");
		configuration4.addChild(keep);

		pexecution.setConfiguration(configuration4);

		ws_pol.addExecution(pexecution);

		
		
		Build build = new Build();
		build.addPlugin(dsl_builder);
		build.addPlugin(dsl_builder2);
		build.addPlugin(dsl_builder3);
		build.addPlugin(ws_pol);

		model.setBuild(build);

		Repository repository = new Repository();
		repository.setId("jvoice");
		repository.setName("JVoice repository");
		repository.setUrl("http://isbks208510504s.scisb.isban.corp/nexus/content/groups/jvoiceGroup/");

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
