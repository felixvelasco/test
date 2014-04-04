package com.vectorsf.jvoice.core.project;

import java.io.IOException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.m2e.core.MavenPlugin;
import org.eclipse.m2e.core.project.IMavenProjectFacade;

import com.vectorsf.jvoice.model.base.JVProject;

public abstract class AbstractJVoiceNature implements IProjectNature {

	public static final String PROJECT_INFORMATION_FILE = ".projectInformation"; //$NON-NLS-1$
	public static final String PLUGIN_ID = "com.vectorsf.jvoice.core.project"; //$NON-NLS-1$
	public static final String NATURE_ID = PLUGIN_ID + ".jVoiceApplicationNature"; //$NON-NLS-1$
	public static final String JVOICE_FRAMEWORK_VERSION = "1.4.0-SNAPSHOT";
	public static final String JVOICE_COMPILER_VERSION = "1.4.0-SNAPSHOT";
	public static final String JVOICE_REPOSITORY_URL = "http://repository-felixvelasco.forge.cloudbees.com/snapshot/snapshot/";
	public static final String JVOICE_REPOSITORY_NAME = "Jvoice snapshot repository";
	public static final String JVOICE_REPOSITORY_ID = "jvoiceSnapshot";

	private IProject project;

	public AbstractJVoiceNature() {
		super();
	}

	@Override
	public void configure() throws CoreException {
		try {
			createModelResource();
		} catch (IOException e) {
			Status status = new Status(IStatus.ERROR, PLUGIN_ID, "Error creating project information", e);
			throw new CoreException(status);
		}
	}

	@Override
	public void deconfigure() throws CoreException {
	}

	@Override
	public IProject getProject() {
		return project;
	}

	@Override
	public void setProject(IProject project) {
		this.project = project;
	}

	private void createModelResource() throws IOException {
		URI uri = URI
				.createPlatformResourceURI(project.getFullPath().append(PROJECT_INFORMATION_FILE).toString(), true);

		ResourceSet rset = new ResourceSetImpl();
		Resource res = rset.createResource(uri);

		JVProject jvProject = createProject();
		jvProject.setName(project.getName());
		jvProject.setDescription(getDescriptionFromMaven());
		setupProject(jvProject);

		res.getContents().add(jvProject);

		res.save(null);

	}

	protected void setupProject(JVProject jvProject) {
		// Subclasses may override with extra configuration
	}

	protected abstract JVProject createProject();

	private String getDescriptionFromMaven() {
		IMavenProjectFacade mavenProject = MavenPlugin.getMavenProjectRegistry().getProject(project);
		return mavenProject.getMavenProject().getDescription();
	}

}