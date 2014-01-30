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

	public static final String IMG_EVENT_BUSY = "busy";

	public static final String IMG_EVENT_CONNECTIONERROR = "connectionerror";

	public static final String IMG_EVENT_ERROR = "error";

	public static final String IMG_EVENT_FAR_END_DISCONNECT = "far_end_disconnect";

	public static final String IMG_EVENT_HANGUP = "hangup";

	public static final String IMG_EVENT_MATCH = "match";

	public static final String IMG_EVENT_MAXATTEMPTS = "maxattempts";

	public static final String IMG_EVENT_MAXTIME_DISCONNECT = "maxtime_disconnect";

	public static final String IMG_EVENT_NEAR_END_DISCONNECT = "near_end_disconnect";

	public static final String IMG_EVENT_NETWORK_BUSY = "network_busy";

	public static final String IMG_EVENT_NETWORK_DISCONNECT = "network_disconnect";

	public static final String IMG_EVENT_NOANSWER = "noanswer";

	public static final String IMG_EVENT_MAXNOINPUT = "maxnoinput";

	public static final String IMG_EVENT_MAXNOMATCH = "maxnomatch";

	public static final String IMG_EVENT_NORESOURCE = "noresource";

	public static final String IMG_EVENT_RECORDED = "recorded";

	public static final String IMG_EVENT_RECORDUNSUPPORTED = "recordunsupported";

	public static final String IMG_EVENT_SUCCESS = "success";

	public static final String IMG_EVENT_TRANSFERRED = "transferred";

	public static final String IMG_EVENT_UNKNOWN = "unknown";

	public static final String IMG_EVENT_OK = "ok";

	public static final String IMG_EVENT_ON_EXT = "_on";

	public static final String IMG_EVENT_OFF_EXT = "_off";

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

		// Iconos para los eventos predefinidos en caso de estar seleccionados.
		addImageFilePath(IMG_EVENT_BUSY + IMG_EVENT_ON_EXT, "icons/events/on/icon_event_busy_on.png");
		addImageFilePath(IMG_EVENT_CONNECTIONERROR + IMG_EVENT_ON_EXT, "icons/events/on/icon_event_conn_error_on.png");
		addImageFilePath(IMG_EVENT_ERROR + IMG_EVENT_ON_EXT, "icons/events/on/icon_event_error_on.png");
		addImageFilePath(IMG_EVENT_FAR_END_DISCONNECT + IMG_EVENT_ON_EXT,
				"icons/events/on/icon_event_far_end_disc_on.png");
		addImageFilePath(IMG_EVENT_HANGUP + IMG_EVENT_ON_EXT, "icons/events/on/icon_event_hangup_on.png");
		addImageFilePath(IMG_EVENT_MATCH + IMG_EVENT_ON_EXT, "icons/events/on/icon_event_match_on.png");
		addImageFilePath(IMG_EVENT_MAXATTEMPTS + IMG_EVENT_ON_EXT, "icons/events/on/icon_event_maxatt_on.png");
		addImageFilePath(IMG_EVENT_MAXTIME_DISCONNECT + IMG_EVENT_ON_EXT, "icons/events/on/icon_event_maxtime_on.png");
		addImageFilePath(IMG_EVENT_NEAR_END_DISCONNECT + IMG_EVENT_ON_EXT, "icons/events/on/icon_event_hangup_on.png");
		addImageFilePath(IMG_EVENT_NETWORK_BUSY + IMG_EVENT_ON_EXT, "icons/events/on/icon_event_netw_busy_on.png");
		addImageFilePath(IMG_EVENT_NOANSWER + IMG_EVENT_ON_EXT, "icons/events/on/icon_event_noanswer_on.png");
		addImageFilePath(IMG_EVENT_MAXNOINPUT + IMG_EVENT_ON_EXT, "icons/events/on/icon_event_maxnoinput_on.png");
		addImageFilePath(IMG_EVENT_MAXNOMATCH + IMG_EVENT_ON_EXT, "icons/events/on/icon_event_maxnomatch_on.png");
		addImageFilePath(IMG_EVENT_NETWORK_DISCONNECT + IMG_EVENT_ON_EXT,
				"icons/events/on/icon_event_netw_disconnect_on.png");
		addImageFilePath(IMG_EVENT_NORESOURCE + IMG_EVENT_ON_EXT, "icons/events/on/icon_event_noresource_on.png");
		addImageFilePath(IMG_EVENT_RECORDED + IMG_EVENT_ON_EXT, "icons/events/on/icon_event_recorded_on.png");
		addImageFilePath(IMG_EVENT_SUCCESS + IMG_EVENT_ON_EXT, "icons/events/on/icon_event_success_on.png");
		addImageFilePath(IMG_EVENT_RECORDUNSUPPORTED + IMG_EVENT_ON_EXT,
				"icons/events/on/icon_event_record_unsup_on.png");
		addImageFilePath(IMG_EVENT_TRANSFERRED + IMG_EVENT_ON_EXT, "icons/events/on/icon_event_transferred_on.png");
		addImageFilePath(IMG_EVENT_UNKNOWN + IMG_EVENT_ON_EXT, "icons/events/on/icon_event_unknown_on.png");
		addImageFilePath(IMG_EVENT_OK + IMG_EVENT_ON_EXT, "icons/events/on/icon_event_success_on.png");

		// Iconos para los eventos predefinidos en caso de no estar seleccionados.
		addImageFilePath(IMG_EVENT_BUSY + IMG_EVENT_OFF_EXT, "icons/events/on/icon_event_busy_off.png");
		addImageFilePath(IMG_EVENT_CONNECTIONERROR + IMG_EVENT_OFF_EXT, "icons/events/on/icon_event_conn_error_off.png");
		addImageFilePath(IMG_EVENT_ERROR + IMG_EVENT_OFF_EXT, "icons/events/on/icon_event_error_off.png");
		addImageFilePath(IMG_EVENT_FAR_END_DISCONNECT + IMG_EVENT_OFF_EXT,
				"icons/events/on/icon_event_far_end_disc_off.png");
		addImageFilePath(IMG_EVENT_HANGUP + IMG_EVENT_OFF_EXT, "icons/events/on/icon_event_hangup_off.png");
		addImageFilePath(IMG_EVENT_MATCH + IMG_EVENT_OFF_EXT, "icons/events/on/icon_event_match_off.png");
		addImageFilePath(IMG_EVENT_MAXATTEMPTS + IMG_EVENT_OFF_EXT, "icons/events/on/icon_event_maxatt_off.png");
		addImageFilePath(IMG_EVENT_MAXTIME_DISCONNECT + IMG_EVENT_OFF_EXT, "icons/events/on/icon_event_maxtime_off.png");
		addImageFilePath(IMG_EVENT_NEAR_END_DISCONNECT + IMG_EVENT_OFF_EXT, "icons/events/on/icon_event_hangup_off.png");
		addImageFilePath(IMG_EVENT_NETWORK_BUSY + IMG_EVENT_OFF_EXT, "icons/events/on/icon_event_netw_busy_off.png");
		addImageFilePath(IMG_EVENT_NOANSWER + IMG_EVENT_OFF_EXT, "icons/events/on/icon_event_noanswer_off.png");
		addImageFilePath(IMG_EVENT_MAXNOINPUT + IMG_EVENT_OFF_EXT, "icons/events/on/icon_event_maxnoinput_off.png");
		addImageFilePath(IMG_EVENT_MAXNOMATCH + IMG_EVENT_OFF_EXT, "icons/events/on/icon_event_maxnomatch_off.png");
		addImageFilePath(IMG_EVENT_NETWORK_DISCONNECT + IMG_EVENT_OFF_EXT,
				"icons/events/on/icon_event_netw_disconnect_off.png");
		addImageFilePath(IMG_EVENT_NORESOURCE + IMG_EVENT_OFF_EXT, "icons/events/on/icon_event_noresource_off.png");
		addImageFilePath(IMG_EVENT_RECORDED + IMG_EVENT_OFF_EXT, "icons/events/on/icon_event_recorded_off.png");
		addImageFilePath(IMG_EVENT_SUCCESS + IMG_EVENT_OFF_EXT, "icons/events/on/icon_event_success_off.png");
		addImageFilePath(IMG_EVENT_RECORDUNSUPPORTED + IMG_EVENT_OFF_EXT,
				"icons/events/on/icon_event_record_unsup_off.png");
		addImageFilePath(IMG_EVENT_TRANSFERRED + IMG_EVENT_OFF_EXT, "icons/events/on/icon_event_transferred_off.png");
		addImageFilePath(IMG_EVENT_UNKNOWN + IMG_EVENT_OFF_EXT, "icons/events/on/icon_event_unknown_off.png");
		addImageFilePath(IMG_EVENT_OK + IMG_EVENT_OFF_EXT, "icons/events/on/icon_event_success_off.png");

		// Iconos para las opciones de menú más usuales en caso de estar seleccionadas.
		addImageFilePath("account_on", "icons/events/on/icon_event_account_on.png");
		addImageFilePath("alta_on", "icons/events/on/icon_event_alta_on.png");
		addImageFilePath("baja_on", "icons/events/on/icon_event_baja_on.png");
		addImageFilePath("broker_on", "icons/events/on/icon_event_broker_on.png");
		addImageFilePath("card_on", "icons/events/on/icon_event_card_on.png");
		addImageFilePath("consulta_on", "icons/events/on/icon_event_consulta_on.png");
		addImageFilePath("editar_on", "icons/events/on/icon_event_editar_on.png");
		addImageFilePath("loans_on", "icons/events/on/icon_event_loans_on.png");
		addImageFilePath("mortgages_on", "icons/events/on/icon_event_mortgages_on.png");
		addImageFilePath("payments_on", "icons/events/on/icon_event_payments_on.png");
		addImageFilePath("pinManagement_on", "icons/events/on/icon_event_pinManagement_on.png");

		// Iconos para las opciones de menú más usuales en caso de NO estar seleccionadas.
		addImageFilePath("account_on", "icons/events/on/icon_event_account_on.png");
		addImageFilePath("alta_on", "icons/events/on/icon_event_alta_on.png");
		addImageFilePath("baja_on", "icons/events/on/icon_event_baja_on.png");
		addImageFilePath("broker_on", "icons/events/on/icon_event_broker_on.png");
		addImageFilePath("card_on", "icons/events/on/icon_event_card_on.png");
		addImageFilePath("consulta_on", "icons/events/on/icon_event_consulta_on.png");
		addImageFilePath("editar_on", "icons/events/on/icon_event_editar_on.png");
		addImageFilePath("loans_on", "icons/events/on/icon_event_loans_on.png");
		addImageFilePath("mortgages_on", "icons/events/on/icon_event_mortgages_on.png");
		addImageFilePath("payments_on", "icons/events/on/icon_event_payments_on.png");
		addImageFilePath("pinManagement_on", "icons/events/on/icon_event_pinManagement_on.png");

	}
}
