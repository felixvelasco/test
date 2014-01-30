package com.vectorsf.jvoice.diagram.core.editor;

import org.eclipse.graphiti.ui.editor.DefaultRefreshBehavior;
import org.eclipse.graphiti.ui.editor.DiagramBehavior;

/**
 * Para que refresque los estados al arrancar el editor. Por ejemplo, que actualice los options del estado Menu.
 */
public class JVoiceRefreshBehavior extends DefaultRefreshBehavior {

	public JVoiceRefreshBehavior(DiagramBehavior diagramBehavior) {
		super(diagramBehavior);
	}

	@Override
	protected void autoUpdate() {
		super.autoUpdate();
		System.out.println("#########################JVoiceRefreshBehavior.autoUpdate(): ");
	}

}
