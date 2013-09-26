package com.vectorsf.jvoice.core.project;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;

public class JVoiceProjectNature implements IProjectNature {

	private static final String JVOICEBUILDER = "jvoicebuildertest";
	private IProject project;

	@Override
	public void configure() throws CoreException {
		// addToBuildSpec(JVoiceBuilder.BUILDER_ID);
		addToBuildSpec(JVOICEBUILDER);
	}

	@Override
	public void deconfigure() throws CoreException {
		// removeFromBuildSpec(JVoiceBuilder.BUILDER_ID);
		removeFromBuildSpec(JVOICEBUILDER);
	}

	private void addToBuildSpec(String builderID) throws CoreException {
		IProjectDescription description = this.project.getDescription();
		ICommand[] commands = description.getBuildSpec();
		for (int i = 0; i < commands.length; ++i) {
			if (commands[i].getBuilderName().equals(builderID)) {
				return;
			}
		}

		ICommand command = description.newCommand();
		command.setBuilderName(builderID);
		ICommand[] newCommands = new ICommand[commands.length + 1];
		System.arraycopy(commands, 0, newCommands, 1, commands.length);
		newCommands[0] = command;
		description.setBuildSpec(newCommands);
		this.project.setDescription(description, null);
	}

	private void removeFromBuildSpec(String builderID) throws CoreException {
		IProjectDescription description = this.project.getDescription();
		ICommand[] commands = description.getBuildSpec();
		for (int i = 0; i < commands.length; ++i) {
			if (commands[i].getBuilderName().equals(builderID)) {
				ICommand[] newCommands = new ICommand[commands.length - 1];
				System.arraycopy(commands, 0, newCommands, 0, i);
				System.arraycopy(commands, i + 1, newCommands, i, commands.length - i - 1);
				description.setBuildSpec(newCommands);
				this.project.setDescription(description, null);
				return;
			}
		}
	}

	@Override
	public IProject getProject() {
		return project;
	}

	@Override
	public void setProject(IProject project) {
		this.project = project;
	}

}
