package com.vectorsf.jvoice.ui.diagram.properties.listeners;

import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Text;

public class VerifyNumericListener implements VerifyListener {

	@Override
	public void verifyText(VerifyEvent e) {
		Text text = (Text)e.getSource();

        // get old text and create new text by using the VerifyEvent.text
        final String oldS = text.getText();
        String newS = oldS.substring(0, e.start) + e.text + oldS.substring(e.end);
        boolean isInt = true;
        try
        {
            Integer.parseInt(newS);
        }
        catch(NumberFormatException ex)
        {
        	isInt = false;
        }
        if(!isInt)
            e.doit = false;
	}

}
