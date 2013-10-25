package com.vectorsf.jvoice.ui.diagram.properties.util;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.graphiti.features.IFeatureProvider;
import org.eclipse.graphiti.features.context.IDeleteContext;
import org.eclipse.graphiti.features.context.impl.DeleteContext;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.PlatformUI;

import com.vectorsf.jvoice.diagram.core.features.editing.TransitionsDeleteFeature;
import com.vectorsf.jvoice.model.operations.Case;
import com.vectorsf.jvoice.model.operations.SwitchState;
import com.vectorsf.jvoice.model.operations.Transition;

public class RemoveCaseSwitch extends RecordingCommand {

	private SwitchState estadoSelection;
	private List<Case> casos;
	private TableViewer tableViewer;
	private IFeatureProvider featureProvider;
	
	public RemoveCaseSwitch (IFeatureProvider featureProvider, TransactionalEditingDomain domain, SwitchState estadoSelection, List<Case> casos, TableViewer tableViewer){
		super(domain);
		this.estadoSelection = estadoSelection;
		this.casos = casos;
		this.tableViewer = tableViewer;
		this.featureProvider = featureProvider;
	}
	@Override
	protected void doExecute() {
		TableItem[] item = tableViewer.getTable().getSelection();
		if (item.length>0){
			Case caso = (Case)item[0].getData();
			if (estadoSelection.getCase(caso.getEventName()) !=null && !caso.getEventName().equals("default")){
				if (!existTransition(caso)){
					estadoSelection.getCase().remove(caso);
					casos = estadoSelection.getCase();
	            	tableViewer.setInput(casos);
				}else{
					Shell activeShell = PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getShell();
					MessageBox dialog = 
							  new MessageBox(activeShell, SWT.ICON_WARNING | SWT.OK| SWT.CANCEL);
							dialog.setText("Warning");
							dialog.setMessage("The transition is active. Do you want to remove it?");

					int returnCode = dialog.open();
							
					if (returnCode == SWT.OK){
								
						boolean noBorrado = true;
						
						EList<Transition> OUTtransaction = estadoSelection.getOutgoingTransitions();
						for (Transition trans : OUTtransaction){		
									
							if(trans.getEventName().equals(caso.getEventName())){
								PictogramElement pe = featureProvider.getPictogramElementForBusinessObject(trans);

								IDeleteContext deleteContext = new DeleteContext(pe);
								TransitionsDeleteFeature deleteFeature = new TransitionsDeleteFeature (featureProvider, false);
								if (deleteFeature != null) {
									deleteFeature.delete(deleteContext);
									noBorrado = false;
									break;
								}
										
							}
						}
						if (!noBorrado){
							estadoSelection.getCase().remove(caso);
							casos = estadoSelection.getCase();
					        tableViewer.setInput(casos);
						}
					}
				}
			}
		}
	}
	
	private boolean existTransition(Case caso){
		EList<Transition> OUTtransaction = estadoSelection.getOutgoingTransitions();
		if(OUTtransaction.size()>0){
			for (Transition trans : OUTtransaction){            		
				if(trans.getEventName().equals(caso.getEventName())){
					return true;	
				}
			}
			return false;
		}else{
			return false;
		}
	}
}
