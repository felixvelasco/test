package com.vectorsf.jvoice.ui.diagram.properties.section.helper;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class LabelAndText {
	public final Label label;
	public final Text text;
	public final Button button;

	public LabelAndText(Label label, Text text, Button button) {
		this.label = label;
		this.text = text;
		this.button = button;
	}
}