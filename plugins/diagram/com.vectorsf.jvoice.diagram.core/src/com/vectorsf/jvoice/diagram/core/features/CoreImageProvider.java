package com.vectorsf.jvoice.diagram.core.features;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;

public class CoreImageProvider extends AbstractImageProvider {

	// States
	public static final String IMG_TRANSACTION_PAD = "transition_pad"; //$NON-NLS-1$

	public static final String IMG_RELATION_PAD = "relation_pad"; //$NON-NLS-1$

	public static final String SET_FINAL_PAD = "set_final_pad"; //$NON-NLS-1$

	public static final String UNSET_FINAL_PAD = "unset_final_pad"; //$NON-NLS-1$

	public static final String IMG_DROPDOWN = "icon_deco_dropdown";

	public static final String IMG_PALETTE_CUSTOM = "icon_est_custom";
	public static final String IMG_PALETTE_EXECUTION = "icon_est_execution";
	public static final String IMG_PALETTE_FINAL = "icon_est_final";
	public static final String IMG_PALETTE_INPUT = "icon_est_input";
	public static final String IMG_PALETTE_MENU = "icon_est_menu";
	public static final String IMG_PALETTE_PROMPT = "icon_est_prompt";
	public static final String IMG_PALETTE_RECORD = "icon_est_record";
	public static final String IMG_PALETTE_SUBFLOW = "icon_est_subflow";
	public static final String IMG_PALETTE_SWITCH = "icon_est_switch";
	public static final String IMG_PALETTE_TRANSFER = "icon_est_transfer";
	public static final String IMG_PALETTE_NOTE = "icon_notes";

	public static final String IMG_STATE_CUSTOM = "icon_comp_custom";
	public static final String IMG_STATE_EXECUTION = "icon_comp_execution";
	public static final String IMG_STATE_FINAL = "icon_comp_final";
	public static final String IMG_STATE_HANGUP = "icon_comp_hangup";
	public static final String IMG_STATE_INPUT = "icon_comp_input";
	public static final String IMG_STATE_MENU = "icon_comp_menu";
	public static final String IMG_STATE_PROMPT = "icon_comp_prompt";
	public static final String IMG_STATE_RECORD = "icon_comp_record";
	public static final String IMG_STATE_SUBFLOW = "icon_comp_subflow";
	public static final String IMG_STATE_SWITCH = "icon_comp_switch";
	public static final String IMG_STATE_TRANSFER = "icon_comp_transfer";

	@Override
	protected void addAvailableImages() {

		addImageFilePath(IMG_TRANSACTION_PAD, "icons/transition.gif"); //$NON-NLS-1$
		addImageFilePath(IMG_RELATION_PAD, "icons/relation.gif"); //$NON-NLS-1$
		addImageFilePath(SET_FINAL_PAD, "icons/setFinal.gif"); //$NON-NLS-1$
		addImageFilePath(UNSET_FINAL_PAD, "icons/unsetFinal.gif"); //$NON-NLS-1$

		addImageFilePath(IMG_PALETTE_CUSTOM, "icons/palette/icon_est_custom.png");
		addImageFilePath(IMG_PALETTE_EXECUTION, "icons/palette/icon_est_execution.png");
		addImageFilePath(IMG_PALETTE_FINAL, "icons/palette/icon_est_final.png");
		addImageFilePath(IMG_PALETTE_INPUT, "icons/palette/icon_est_input.png");
		addImageFilePath(IMG_PALETTE_MENU, "icons/palette/icon_est_menu.png");
		addImageFilePath(IMG_PALETTE_PROMPT, "icons/palette/icon_est_prompt.png");
		addImageFilePath(IMG_PALETTE_RECORD, "icons/palette/icon_est_record.png");
		addImageFilePath(IMG_PALETTE_SUBFLOW, "icons/palette/icon_est_subflow.png");
		addImageFilePath(IMG_PALETTE_SWITCH, "icons/palette/icon_est_switch.png");
		addImageFilePath(IMG_PALETTE_TRANSFER, "icons/palette/icon_est_transfer.png");

		addImageFilePath(IMG_PALETTE_NOTE, "icons/palette/icon_notes.png");

		addImageFilePath(IMG_STATE_CUSTOM, "icons/states/icon_comp_custom.png");
		addImageFilePath(IMG_STATE_EXECUTION, "icons/states/icon_comp_execution.png");
		addImageFilePath(IMG_STATE_FINAL, "icons/states/icon_comp_final.png");
		addImageFilePath(IMG_STATE_HANGUP, "icons/states/icon_comp_hangup.png");
		addImageFilePath(IMG_STATE_INPUT, "icons/states/icon_comp_input.png");
		addImageFilePath(IMG_STATE_MENU, "icons/states/icon_comp_menu.png");
		addImageFilePath(IMG_STATE_PROMPT, "icons/states/icon_comp_prompt.png");
		addImageFilePath(IMG_STATE_RECORD, "icons/states/icon_comp_record.png");
		addImageFilePath(IMG_STATE_SUBFLOW, "icons/states/icon_comp_subflow.png");
		addImageFilePath(IMG_STATE_SWITCH, "icons/states/icon_comp_switch.png");
		addImageFilePath(IMG_STATE_TRANSFER, "icons/states/icon_comp_transfer.png");

		addImageFilePath(IMG_DROPDOWN, "icons/states/dropdown.png"); //$NON-NLS-1$
	}

}
