package com.vectorsf.jvoice.ui.diagram.properties.listeners;

import java.util.List;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.graphiti.mm.pictograms.PictogramElement;
import org.eclipse.graphiti.services.Graphiti;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

import com.vectorsf.jvoice.model.operations.Case;
import com.vectorsf.jvoice.model.operations.InputState;
import com.vectorsf.jvoice.model.operations.MenuState;
import com.vectorsf.jvoice.model.operations.PromptState;
import com.vectorsf.jvoice.model.operations.RecordState;
import com.vectorsf.jvoice.model.operations.SwitchState;
import com.vectorsf.jvoice.model.operations.TransferState;
import com.vectorsf.jvoice.ui.diagram.properties.filters.StateSection;
import com.vectorsf.jvoice.ui.diagram.properties.util.AddCaseSwitch;
import com.vectorsf.jvoice.ui.diagram.properties.util.DownCaseSwitch;
import com.vectorsf.jvoice.ui.diagram.properties.util.EditMenuStateLocution;
import com.vectorsf.jvoice.ui.diagram.properties.util.RemoveCaseSwitch;
import com.vectorsf.jvoice.ui.diagram.properties.util.UpCaseSwitch;

public class PropertiesListener implements Listener {

	private Text nameSubFlow;
	private TableViewer tableViewer;
	private StateSection stateSection;

	public PropertiesListener(StateSection stateSection, Text nameSubFlow) {
		this.nameSubFlow = nameSubFlow;
		this.stateSection = stateSection;
	}

	public PropertiesListener(StateSection stateSection, TableViewer tableViewer) {
		this.stateSection = stateSection;
		this.tableViewer = tableViewer;
	}

	@Override
	public void handleEvent(Event event) {
		PictogramElement pe = null;
		if (stateSection != null) {
			pe = stateSection.obtenerPe();
		}

		if (pe != null) {
			Object bo = Graphiti.getLinkService().getBusinessObjectForLinkedPictogramElement(pe);
			// the filter assured, that it is a EClass
			if (bo == null) {
				return;
			}

			if (bo instanceof MenuState) {
				MenuState menuLocution = (MenuState) bo;
				TransactionalEditingDomain dominio = TransactionUtil.getEditingDomain(menuLocution);
				dominio.getCommandStack().execute(new EditMenuStateLocution(dominio, menuLocution, nameSubFlow));
			} else if (bo instanceof InputState) {
				InputState inputLocution = (InputState) bo;
				TransactionalEditingDomain dominio = TransactionUtil.getEditingDomain(inputLocution);
				dominio.getCommandStack().execute(new EditMenuStateLocution(dominio, inputLocution, nameSubFlow));
			} else if (bo instanceof RecordState) {
				RecordState recordLocution = (RecordState) bo;
				TransactionalEditingDomain dominio = TransactionUtil.getEditingDomain(recordLocution);
				dominio.getCommandStack().execute(new EditMenuStateLocution(dominio, recordLocution, nameSubFlow));
			} else if (bo instanceof PromptState) {
				PromptState outputLocution = (PromptState) bo;
				TransactionalEditingDomain dominio = TransactionUtil.getEditingDomain(outputLocution);
				dominio.getCommandStack().execute(new EditMenuStateLocution(dominio, outputLocution, nameSubFlow));
			} else if (bo instanceof TransferState) {
				TransferState transferLocution = (TransferState) bo;
				TransactionalEditingDomain dominio = TransactionUtil.getEditingDomain(transferLocution);
				dominio.getCommandStack().execute(new EditMenuStateLocution(dominio, transferLocution, nameSubFlow));
			} else if (bo instanceof SwitchState) {
				SwitchState estadoSelection = (SwitchState) bo;
				List<Case> casos = stateSection.obtenerCases();
				TransactionalEditingDomain dominio = TransactionUtil.getEditingDomain(estadoSelection);

				if (event.widget.getData().equals("add")) {
					dominio.getCommandStack().execute(new AddCaseSwitch(dominio, estadoSelection, casos, tableViewer));
				} else if (event.widget.getData().equals("remove")) {
					dominio.getCommandStack().execute(
							new RemoveCaseSwitch(stateSection.obtenerFeatureProvider(), dominio, estadoSelection,
									casos, tableViewer));
				} else if (event.widget.getData().equals("up")) {
					dominio.getCommandStack().execute(new UpCaseSwitch(dominio, estadoSelection, casos, tableViewer));
				} else if (event.widget.getData().equals("down")) {
					dominio.getCommandStack().execute(new DownCaseSwitch(dominio, estadoSelection, casos, tableViewer));
				}
			}
			if (stateSection != null) {
				stateSection.refresh();
			}

		}
	}
}
