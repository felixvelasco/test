package com.vectorsf.jvoice.ui.project.editor;

import org.eclipse.emf.parsley.binding.FormControlFactory;
import org.eclipse.emf.parsley.builders.TableViewerColumnBuilder;
import org.eclipse.emf.parsley.resource.EmptyResourceInitializer;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import com.vectorsf.jvoice.ui.widgets.ProjectEditorTableViewerEditableColumnBuilder;

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
		return ProjectEditorTableViewerEditableColumnBuilder.class;
	}

	@Override
	public Class<? extends EmptyResourceInitializer> bindEmptyResourceInitializer() {
		return ProjectEditorEmptyResourceInitializer.class;
	}

}
