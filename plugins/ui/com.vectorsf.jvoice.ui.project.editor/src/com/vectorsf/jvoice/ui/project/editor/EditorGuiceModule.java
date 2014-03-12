package com.vectorsf.jvoice.ui.project.editor;

import org.eclipse.emf.parsley.binding.FormControlFactory;
import org.eclipse.emf.parsley.binding.ProposalCreator;
import org.eclipse.emf.parsley.builders.TableViewerColumnBuilder;
import org.eclipse.emf.parsley.resource.EmptyResourceInitializer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;

public class EditorGuiceModule extends EmfParsleyGuiceModuleGen {

	public EditorGuiceModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	@Override
	public Class<? extends FormControlFactory> bindFormControlFactory() {
		return ProjectEditorFormControlFactory.class;
	}

	@Override
	public Class<? extends TableViewerColumnBuilder> bindTableViewerColumnBuilder() {
		return TableViewerColumnBuilder.class;
	}

	@Override
	public Class<? extends EmptyResourceInitializer> bindEmptyResourceInitializer() {
		return ProjectEditorEmptyResourceInitializer.class;
	}

	@Override
	public Class<? extends ProposalCreator> bindProposalCreator() {
		return ProjectEditorProposalCreator.class;
	}

	/**
	 * ILabelProvider must be ProjectEditorLabelProvider
	 * 
	 * @see ProjectEditorLabelProvider
	 */
	@Override
	public Class<? extends ILabelProvider> bindILabelProvider() {
		return ProjectEditorLabelProvider.class;
	}
}
