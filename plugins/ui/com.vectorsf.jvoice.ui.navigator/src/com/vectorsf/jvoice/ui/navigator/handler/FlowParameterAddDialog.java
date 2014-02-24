package com.vectorsf.jvoice.ui.navigator.handler;

import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.vectorsf.jvoice.model.operations.Flow;

public class FlowParameterAddDialog extends TitleAreaDialog {

    private Text nameText;
    private Flow flow;

    private String name;

    public FlowParameterAddDialog(Shell parentShell, Flow flow) {
	super(parentShell);
	this.flow = flow;
    }

    @Override
    public void create() {
	super.create();
	setTitle("Add parameter");
	setMessage("Set bean name");
    }

    @Override
    protected Control createDialogArea(Composite parent) {
	Composite area = (Composite) super.createDialogArea(parent);
	Composite container = new Composite(area, SWT.NONE);
	container.setLayoutData(new GridData(GridData.FILL_BOTH));
	GridLayout layout = new GridLayout(2, false);
	container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	container.setLayout(layout);

	createName(container);

	return area;
    }

    private void createName(Composite container) {
	Label lbtName = new Label(container, SWT.NONE);
	lbtName.setText("Parameter name:");

	GridData dataName = new GridData();
	dataName.grabExcessHorizontalSpace = true;
	dataName.horizontalAlignment = GridData.FILL;
	nameText = new Text(container, SWT.BORDER);
	nameText.setLayoutData(dataName);
	nameText.addModifyListener(new ModifyListener() {

	    @Override
	    public void modifyText(ModifyEvent e) {
		name = nameText.getText();
		getButton(OK).setEnabled(
			isValidParameterName(name)
				&& !flow.getParameters().contains(name));
	    }

	    private boolean isValidParameterName(String name) {
		return !name.isEmpty() && name.matches("\\w*");
	    }
	});

    }

    @Override
    protected boolean isResizable() {
	return true;
    }

    public String getParameterName() {
	return name;
    }

}
