package com.vectorsf.jvoice.ui.navigator.util;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class RenameFlowParameterPage extends WizardPage {

	private Text text;

	private Composite container;

	public RenameFlowParameterPage() {
		super("Rename Resource");
		setTitle("Rename Resource");
	}

	@Override
	public void createControl(Composite parent) {
		container = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		Label label1 = new Label(container, SWT.NONE);
		label1.setText("New name: ");
		text = new Text(container, SWT.BORDER | SWT.SINGLE);
		text.setText("");
		text.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (!text.getText().isEmpty()) {
					setPageComplete(true);
				}
			}
		});
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		text.setLayoutData(gd);
		setControl(container);
		setPageComplete(false);
	}

	public String getText() {
		return text.getText();
	}

}
