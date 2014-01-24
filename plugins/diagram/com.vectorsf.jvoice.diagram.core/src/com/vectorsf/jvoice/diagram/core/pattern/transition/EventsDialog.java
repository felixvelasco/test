package com.vectorsf.jvoice.diagram.core.pattern.transition;

import java.util.*;
import java.util.List;

import org.eclipse.jface.dialogs.*;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class EventsDialog extends Dialog {

	private String title;
	private Button okButton;
	private List<Button> buttons;
	private Text errorMessageText;
	private String errorMessage;

	private ButtonInfo[] options;

	private String[] values = new String[0];

	public EventsDialog(Shell parentShell, String dialogTitle, List<ButtonInfo> options) {
		super(parentShell);
		this.title = dialogTitle;
		this.options = options.toArray(new ButtonInfo[options.size()]);
		this.buttons = new ArrayList<Button>();
	}

	@Override
	protected void buttonPressed(int buttonId) {
		if (buttonId == IDialogConstants.OK_ID) {
			values = retrieveValues();
		} else {
			values = new String[0];
		}
		super.buttonPressed(buttonId);
	}

	private String[] retrieveValues() {
		List<String> checked = new ArrayList<String>();
		for (Button b : buttons) {
			if (b.getSelection()) {
				checked.add(b.getText());
			}
		}

		return checked.toArray(new String[checked.size()]);
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		if (title != null) {
			shell.setText(title);
		}
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		okButton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		final Composite composite = (Composite) super.createDialogArea(parent);
		Composite buttonComposite = new Composite(composite, SWT.WRAP);
		GridData data = new GridData(GridData.GRAB_HORIZONTAL | GridData.GRAB_VERTICAL | GridData.HORIZONTAL_ALIGN_FILL
				| GridData.VERTICAL_ALIGN_CENTER);
		buttonComposite.setLayoutData(data);
		buttonComposite.setLayout(new GridLayout(1, false));

		for (int i = 0; i < options.length; i++) {
			Button b = new Button(buttonComposite, SWT.CHECK);
			b.setImage(options[i].image);
			b.setData(options[i].name);
			b.setText(options[i].name);
			b.setSelection(options[i].selected);
			b.setEnabled(options[i].editable);
			b.setLayoutData(data);
			b.setToolTipText(options[i].name);
			buttons.add(b);
		}

		errorMessageText = new Text(composite, SWT.READ_ONLY | SWT.WRAP);
		errorMessageText.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
		errorMessageText.setBackground(errorMessageText.getDisplay().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
		setErrorMessage(errorMessage);

		applyDialogFont(composite);
		return composite;
	}

	protected Button getOkButton() {
		return okButton;
	}

	public String[] getValues() {
		return values;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		if (errorMessageText != null && !errorMessageText.isDisposed()) {
			errorMessageText.setText(errorMessage == null ? " \n " : errorMessage); //$NON-NLS-1$
			boolean hasError = errorMessage != null && StringConverter.removeWhiteSpaces(errorMessage).length() > 0;
			errorMessageText.setEnabled(hasError);
			errorMessageText.setVisible(hasError);
			errorMessageText.getParent().update();
		}
	}

	protected int getInputComboStyle() {
		return SWT.SIMPLE | SWT.BORDER;
	}

	public static final class ButtonInfo {
		public final String name;
		public final Image image;
		public final boolean selected;
		public final boolean editable;

		public ButtonInfo(String name, Image image, boolean selected, boolean editable) {
			this.name = name;
			this.image = image;
			this.selected = selected;
			this.editable = editable;
		}
	}

}
