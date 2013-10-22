package com.vectorsf.jvoice.ui.diagram.properties.util;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.diagram.core.pattern.states.JVBeanContentProvider;
import com.vectorsf.jvoice.model.base.JVProject;
import com.vectorsf.jvoice.model.operations.CallFlowState;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.ui.diagram.properties.dialogs.DialogSubFlow;
import com.vectorsf.jvoice.ui.diagram.properties.dialogs.FilterDialogSubFlow;
import com.vectorsf.jvoice.ui.diagram.properties.dialogs.ValidatorSubFlow;

public class EditarDominioSubFlow extends RecordingCommand {

	private CallFlowState subFlow;
	private Text nameSubFlow;
	
	public EditarDominioSubFlow(TransactionalEditingDomain domain, CallFlowState subFlow, Text nameSubFlow) {
		super(domain);
		this.subFlow = subFlow;
		this.nameSubFlow = nameSubFlow;
		
	}

	@Override
	protected void doExecute() {
		Shell activeShell = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell();
		
		URI res = subFlow.eResource().getURI();
		String projectName = res.segment(1);
		JVProject project = BaseModel.getInstance().getModel()
				.getProject(projectName);
		List<JVProject> proj = project.getReferencedProjects();
        JVBeanContentProvider callFlowContentProvider = new JVBeanContentProvider(
        		new ComposedAdapterFactory(
        				ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
        		
        DialogSubFlow dialog = new DialogSubFlow(
        		activeShell,
    			new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
    					ComposedAdapterFactory.Descriptor.Registry.INSTANCE)),
    					callFlowContentProvider);
        		
        dialog.setAllowMultiple(false);
    			
    	ValidatorSubFlow validator = new ValidatorSubFlow();
    			
    	dialog.setValidator(validator);

    	FilterDialogSubFlow vfilter = new FilterDialogSubFlow();
    			

    	dialog.addFilter(vfilter);
    	dialog.setTitle("Flow Selection");
    	dialog.setMessage("Select a flow:");
    	dialog.setInput(proj);
    	dialog.open();

    	Object[] results = dialog.getResult();
    	Flow result = null;

    	if (results != null && results[0] instanceof Flow) {
    		result = (Flow) results[0];
    		subFlow.setSubflow(result);
    		nameSubFlow.setText(subFlow.getSubflow().getName());
    	}
	}
}