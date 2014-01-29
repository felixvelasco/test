package com.vectorsf.jvoice.diagram.core.features;

import org.eclipse.graphiti.ui.platform.AbstractImageProvider;

public class CoreImageProvider extends AbstractImageProvider
{

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

	public static final String IMG_MORE_EVENTS_DIALOG = "icon_more_events_dialog";

	public static final String IMG_LARGE_PALETTE_CUSTOM = "large_icon_est_custom";

	public static final String IMG_LARGE_PALETTE_EXECUTION = "large_icon_est_execution";

	public static final String IMG_LARGE_PALETTE_FINAL = "large_icon_est_final";

	public static final String IMG_LARGE_PALETTE_INPUT = "large_icon_est_input";

	public static final String IMG_LARGE_PALETTE_MENU = "large_icon_est_menu";

	public static final String IMG_LARGE_PALETTE_PROMPT = "large_icon_est_prompt";

	public static final String IMG_LARGE_PALETTE_RECORD = "large_icon_est_record";

	public static final String IMG_LARGE_PALETTE_SUBFLOW = "large_icon_est_subflow";

	public static final String IMG_LARGE_PALETTE_SWITCH = "large_icon_est_switch";

	public static final String IMG_LARGE_PALETTE_TRANSFER = "large_icon_est_transfer";

	public static final String IMG_LARGE_PALETTE_NOTE = "large_icon_notes";

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
	protected void addAvailableImages()
	{

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

		addImageFilePath(IMG_LARGE_PALETTE_CUSTOM, "icons/palette/large/icon_est_custom.png");
		addImageFilePath(IMG_LARGE_PALETTE_EXECUTION, "icons/palette/large/icon_est_execution.png");
		addImageFilePath(IMG_LARGE_PALETTE_FINAL, "icons/palette/large/icon_est_final.png");
		addImageFilePath(IMG_LARGE_PALETTE_INPUT, "icons/palette/large/icon_est_input.png");
		addImageFilePath(IMG_LARGE_PALETTE_MENU, "icons/palette/large/icon_est_menu.png");
		addImageFilePath(IMG_LARGE_PALETTE_PROMPT, "icons/palette/large/icon_est_prompt.png");
		addImageFilePath(IMG_LARGE_PALETTE_RECORD, "icons/palette/large/icon_est_record.png");
		addImageFilePath(IMG_LARGE_PALETTE_SUBFLOW, "icons/palette/large/icon_est_subflow.png");
		addImageFilePath(IMG_LARGE_PALETTE_SWITCH, "icons/palette/large/icon_est_switch.png");
		addImageFilePath(IMG_LARGE_PALETTE_TRANSFER, "icons/palette/large/icon_est_transfer.png");

		addImageFilePath(IMG_LARGE_PALETTE_NOTE, "icons/palette/large/icon_notes.png");

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

		addImageFilePath(IMG_MORE_EVENTS_DIALOG, "icons/icon_more_events_dialog.png");

		// Eventos que pueden lanzar los estados
		addImageFilePath("busy", "icons/events/icon_event_busy.png");
		addImageFilePath("conn_error", "icons/events/icon_event_conn_error.png");
		addImageFilePath("error", "icons/events/icon_event_error.png");
		addImageFilePath("far_end_disc", "icons/events/icon_event_far_end_disc.png");
		addImageFilePath("hangup", "icons/events/icon_event_hangup.png");
		addImageFilePath("match", "icons/events/icon_event_match.png");
		addImageFilePath("maxatt", "icons/events/icon_event_maxatt.png");
		addImageFilePath("maxtime", "icons/events/icon_event_maxtime.png");
		addImageFilePath("netw_busy", "icons/events/icon_event_netw_busy.png");
		addImageFilePath("netw_disconnect", "icons/events/icon_event_netw_disconnect.png");
		addImageFilePath("noanswer", "icons/events/icon_event_noanswer.png");
		addImageFilePath("noinput", "icons/events/icon_event_noimput.png");
		addImageFilePath("nomatch", "icons/events/icon_event_nomatch.png");
		addImageFilePath("noresource", "icons/events/icon_event_noresource.png");
		addImageFilePath("recorded", "icons/events/icon_event_recorded.png");
		addImageFilePath("record_unsup", "icons/events/icon_event_record_unsup.png");
		addImageFilePath("success", "icons/events/icon_event_success.png");
		addImageFilePath("transferred", "icons/events/icon_event_transferred.png");
		addImageFilePath("unknown", "icons/events/icon_event_unknown.png");

		
		
//		addImageFilePath("account_on", "icon/events/icon_event_account_on.png");
//		addImageFilePath("alta_on", "icon/events/icon_event_alta_on.png");
//		addImageFilePath("baja_on", "icon/events/icon_event_baja_on.png");
//		addImageFilePath("broker_on", "icon/events/icon_event_broker_on.png");
//		addImageFilePath("busy_on", "icon/events/icon_event_busy_on.png");
//		addImageFilePath("card_on", "icon/events/icon_event_card_on.png");
//		addImageFilePath("conn_error_on", "icon/events/icon_event_conn_error_on.png");
//		addImageFilePath("consulta_on", "icon/events/icon_event_consulta_on.png");
//		addImageFilePath("editar_on", "icon/events/icon_event_editar_on.png");
//		addImageFilePath("error_on", "icon/events/icon_event_error_on.png");
//		addImageFilePath("far_end_disc_on", "icon/events/icon_event_far_end_disc_on.png");
//		addImageFilePath("hangup_on", "icon/events/icon_event_hangup_on.png");
//		addImageFilePath("loans_on", "icon/events/icon_event_loans_on.png");
//		addImageFilePath("match_on", "icon/events/icon_event_match_on.png");
//		addImageFilePath("maxatt_on", "icon/events/icon_event_maxatt_on.png");
//		addImageFilePath("maxtime_on", "icon/events/icon_event_maxtime_on.png");
//		addImageFilePath("mortgages_on", "icon/events/icon_event_mortgages_on.png");
//		addImageFilePath("netw_busy_on", "icon/events/icon_event_netw_busy_on.png");
//		addImageFilePath("netw_disconnect_on", "icon/events/icon_event_netw_disconnect_on.png");
//		addImageFilePath("noanswer_on", "icon/events/icon_event_noanswer_on.png");
//		addImageFilePath("noimput_on", "icon/events/icon_event_noimput_on.png");
//		addImageFilePath("nomatch_on", "icon/events/icon_event_nomatch_on.png");
//		addImageFilePath("noresource_on", "icon/events/icon_event_noresource_on.png");
//		addImageFilePath("payments_on", "icon/events/icon_event_payments_on.png");
//		addImageFilePath("pinManagement_on", "icon/events/icon_event_pinManagement_on.png");
//		addImageFilePath("recorded_on", "icon/events/icon_event_recorded_on.png");
//		addImageFilePath("record_unsup_on", "icon/events/icon_event_record_unsup_on.png");
//		addImageFilePath("success_on", "icon/events/icon_event_success_on.png");
//		addImageFilePath("transferred_on", "icon/events/icon_event_transferred_on.png");
//		addImageFilePath("unknown_on", "icon/events/icon_event_unknown_on.png");
//		
//		addImageFilePath("account_off", "icon/events/icon_event_account_off.png");
//		addImageFilePath("alta_off", "icon/events/icon_event_alta_off.png");
//		addImageFilePath("baja_off", "icon/events/icon_event_baja_off.png");
//		addImageFilePath("broker_off", "icon/events/icon_event_broker_off.png");
//		addImageFilePath("busy_off", "icon/events/icon_event_busy_off.png");
//		addImageFilePath("card_off", "icon/events/icon_event_card_off.png");
//		addImageFilePath("conn_error_off", "icon/events/icon_event_conn_error_off.png");
//		addImageFilePath("consulta_off", "icon/events/icon_event_consulta_off.png");
//		addImageFilePath("editar_off", "icon/events/icon_event_editar_off.png");
//		addImageFilePath("error_off", "icon/events/icon_event_error_off.png");
//		addImageFilePath("far_end_disc_off", "icon/events/icon_event_far_end_disc_off.png");
//		addImageFilePath("hangup_off", "icon/events/icon_event_hangup_off.png");
//		addImageFilePath("loans_off", "icon/events/icon_event_loans_off.png");
//		addImageFilePath("match_off", "icon/events/icon_event_match_off.png");
//		addImageFilePath("maxatt_off", "icon/events/icon_event_maxatt_off.png");
//		addImageFilePath("maxtime_off", "icon/events/icon_event_maxtime_off.png");
//		addImageFilePath("mortgages_off", "icon/events/icon_event_mortgages_off.png");
//		addImageFilePath("netw_busy_off", "icon/events/icon_event_netw_busy_off.png");
//		addImageFilePath("netw_disconnect_off", "icon/events/icon_event_netw_disconnect_off.png");
//		addImageFilePath("noanswer_off", "icon/events/icon_event_noanswer_off.png");
//		addImageFilePath("noimput_off", "icon/events/icon_event_noimput_off.png");
//		addImageFilePath("nomatch_off", "icon/events/icon_event_nomatch_off.png");
//		addImageFilePath("noresource_off", "icon/events/icon_event_noresource_off.png");
//		addImageFilePath("payments_off", "icon/events/icon_event_payments_off.png");
//		addImageFilePath("pinManagement_off", "icon/events/icon_event_pinManagement_off.png");
//		addImageFilePath("recorded_off", "icon/events/icon_event_recorded_off.png");
//		addImageFilePath("record_unsup_off", "icon/events/icon_event_record_unsup_off.png");
//		addImageFilePath("success_off", "icon/events/icon_event_success_off.png");
//		addImageFilePath("transferred_off", "icon/events/icon_event_transferred_off.png");
//		addImageFilePath("unknown_off", "icon/events/icon_event_unknown_off.png");
		
	}
}
