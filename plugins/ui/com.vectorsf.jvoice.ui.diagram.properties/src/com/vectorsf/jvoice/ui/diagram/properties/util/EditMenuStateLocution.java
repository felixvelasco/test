package com.vectorsf.jvoice.ui.diagram.properties.util;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;

import com.vectorsf.jvoice.base.model.service.BaseModel;
import com.vectorsf.jvoice.diagram.core.pattern.states.JVBeanContentProvider;
import com.vectorsf.jvoice.model.base.JVProject;
import com.vectorsf.jvoice.model.operations.InputState;
import com.vectorsf.jvoice.model.operations.MenuState;
import com.vectorsf.jvoice.model.operations.PromptState;
import com.vectorsf.jvoice.prompt.model.voiceDsl.InputDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.MenuDsl;
import com.vectorsf.jvoice.prompt.model.voiceDsl.PromptDsl;
import com.vectorsf.jvoice.ui.diagram.properties.dialogs.DialogSubFlow;
import com.vectorsf.jvoice.ui.diagram.properties.dialogs.FilterDialogInput;
import com.vectorsf.jvoice.ui.diagram.properties.dialogs.FilterDialogMenu;
import com.vectorsf.jvoice.ui.diagram.properties.dialogs.FilterDialogOutput;
import com.vectorsf.jvoice.ui.diagram.properties.dialogs.ValidatorInput;
import com.vectorsf.jvoice.ui.diagram.properties.dialogs.ValidatorMenu;
import com.vectorsf.jvoice.ui.diagram.properties.dialogs.ValidatorOutput;

public class EditMenuStateLocution extends RecordingCommand {

	private MenuState menuLocution;
	private InputState inputLocution;
	private PromptState outputLocution;
	private Text nameSubFlow;
	
	public EditMenuStateLocution(TransactionalEditingDomain domain, MenuState menuLocution, Text nameSubFlow) {
		super(domain);
		this.menuLocution = menuLocution;
		this.nameSubFlow = nameSubFlow;
		
	}
	
	public EditMenuStateLocution(TransactionalEditingDomain domain, InputState inputLocution, Text nameSubFlow) {
		super(domain);
		this.inputLocution = inputLocution;
		this.nameSubFlow = nameSubFlow;
		
	}
	
	public EditMenuStateLocution(TransactionalEditingDomain domain, PromptState outputLocution, Text nameSubFlow) {
		super(domain);
		this.outputLocution = outputLocution;
		this.nameSubFlow = nameSubFlow;
		
	}
	
	@Override
	protected void doExecute() {
		Shell activeShell = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getShell();
		
		URI res = getUriLocutions();
		String projectName = res.segment(1);
		JVProject project = BaseModel.getInstance().getModel()
				.getProject(projectName);
		List<JVProject> proj = project.getReferencedProjects();
		
		JVBeanContentProvider locutionCP = new JVBeanContentProvider(
				new ComposedAdapterFactory(
						ComposedAdapterFactory.Descriptor.Registry.INSTANCE));
		
		DialogSubFlow dialog = new DialogSubFlow(
        		activeShell,
    			new AdapterFactoryLabelProvider(new ComposedAdapterFactory(
    					ComposedAdapterFactory.Descriptor.Registry.INSTANCE)),
    					locutionCP);
		
		dialog.setAllowMultiple(false);		
    	dialog.setValidator(getValidator());
    	dialog.addFilter(getFilter());

    	titleAndMessage(dialog);
    	
    	dialog.setInput(proj);
    	dialog.open();
    	
    	//change locution
    	Object[] results = dialog.getResult();
    	changeLocution(results);
	}

	private URI getUriLocutions(){
		if (menuLocution!=null)
			return menuLocution.eResource().getURI();
		if (inputLocution!=null)
			return inputLocution.eResource().getURI();
		if (outputLocution!=null)
			return outputLocution.eResource().getURI();
		return null;
	}
	
	private ISelectionStatusValidator getValidator(){
		if (menuLocution!=null)
			return new ValidatorMenu();
		if (inputLocution!=null)
			return new ValidatorInput();
		if (outputLocution!=null)
			return new ValidatorOutput();
		return null;
	}
	
	private ViewerFilter getFilter(){
		if (menuLocution!=null)
			return new FilterDialogMenu();
		if (inputLocution!=null)
			return new FilterDialogInput();
		if (outputLocution!=null)
			return new FilterDialogOutput();
		return null;
	}
	
	private void titleAndMessage(DialogSubFlow dialog){
		if (menuLocution!=null){
			dialog.setTitle("Menu Selection");
			dialog.setMessage("Select a menu:");
		}else if (inputLocution!=null){
			dialog.setTitle("Input Selection");
			dialog.setMessage("Select an input:");
		}else if (outputLocution!=null){
			dialog.setTitle("Output Selection");
			dialog.setMessage("Select an output:");
		}
	}
	
	private void changeLocution (Object[] results){
		if (results != null){
			if (results[0] instanceof MenuDsl){
				MenuDsl result = (MenuDsl) results[0];
	    		menuLocution.setLocution(result);
	    		nameSubFlow.setText(menuLocution.getLocution().getName());
	    		
			}else if (results[0] instanceof InputDsl){
				InputDsl result = (InputDsl) results[0];
				inputLocution.setLocution(result);
	    		nameSubFlow.setText(inputLocution.getLocution().getName());
	    		
			}else if (results[0] instanceof PromptDsl){
				PromptDsl result = (PromptDsl) results[0];
				outputLocution.setLocution(result);
	    		nameSubFlow.setText(outputLocution.getLocution().getName());
			}
		}
	}
}
