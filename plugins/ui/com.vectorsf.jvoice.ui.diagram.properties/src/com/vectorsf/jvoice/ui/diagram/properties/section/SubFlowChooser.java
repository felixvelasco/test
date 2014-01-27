package com.vectorsf.jvoice.ui.diagram.properties.section;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.model.base.JVProject;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.ui.diagram.properties.section.helper.IObjectChooser;
import com.vectorsf.jvoice.ui.edit.dialogs.DialogSubFlow;
import com.vectorsf.jvoice.ui.edit.filters.FilterDialogSubFlow;
import com.vectorsf.jvoice.ui.edit.provider.JVBeanContentProvider;
import com.vectorsf.jvoice.ui.edit.validators.ValidatorSubFlow;

public class SubFlowChooser implements IObjectChooser {

	@Override
	public Object getValue(EObject bo, TransactionalEditingDomain editingDomain) {
		Shell activeShell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

		URI res = bo.eResource().getURI();
		String projectName = res.segment(1);
		JVProject project = BaseModel.getInstance().getModel().getProject(projectName);
		List<JVProject> proj = project.getReferencedProjects();
		JVBeanContentProvider callFlowContentProvider = new JVBeanContentProvider(new ComposedAdapterFactory(
				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));

		DialogSubFlow dialog = new DialogSubFlow(activeShell, new AdapterFactoryLabelProvider(
				new ComposedAdapterFactory(ComposedAdapterFactory.Descriptor.Registry.INSTANCE)),
				callFlowContentProvider);

		dialog.setAllowMultiple(false);
		dialog.setHelpAvailable(false);
		dialog.setIsButtonCreatevailable(false);
		dialog.setValidator(new ValidatorSubFlow());
		dialog.addFilter(new FilterDialogSubFlow());
		dialog.setTitle("Flow Selection");
		dialog.setMessage("Select a flow:");
		dialog.setInput(proj);
		dialog.open();

		Object[] results = dialog.getResult();
		Flow result = null;

		if (results != null && results[0] instanceof Flow) {
			result = (Flow) results[0];
			URI flowURI = EcoreUtil.getURI(result);
			result = (Flow) editingDomain.getResourceSet().getEObject(flowURI, true);
		}

		return result;
	}

}