package com.vectorsf.jvoice.ui.project.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.parsley.binding.ProposalCreator;

import com.vectorsf.jvoice.model.base.EventHandler;
import com.vectorsf.jvoice.model.base.EventsEnum;
import com.vectorsf.jvoice.model.base.JVApplication;
import com.vectorsf.jvoice.model.base.JVBean;
import com.vectorsf.jvoice.model.base.JVModule;
import com.vectorsf.jvoice.model.base.JVPackage;
import com.vectorsf.jvoice.model.base.JVProject;
import com.vectorsf.jvoice.model.operations.Flow;

public class ProjectEditorProposalCreator extends ProposalCreator {

	public List<EventsEnum> proposals_EventHandler_event(EventHandler handler) {
		List<EventsEnum> ret = new ArrayList<>(EventsEnum.VALUES);
		ret.removeAll(collectCoveredEvents(handler));

		return ret;
	}

	public List<Object> proposals_EventHandler_handler(EventHandler handler) {
		List<Object> allInstances = new ArrayList<>();
		JVProject project = (JVProject) handler.eContainer();
		if (project instanceof JVModule) {
			for (JVPackage pck : ((JVModule) project).getPackages()) {
				for (JVBean bean : pck.getBeans()) {
					if (bean instanceof Flow) {
						allInstances.add(bean);
					}
				}
			}
		} else if (project instanceof JVApplication) {
			// TODO
		}

		return allInstances;
	}

	protected String fullName(Flow flow) {

		return flow.getOwnerPackage().getName() + "." + flow.getName();
	}

	private List<Object> collectCoveredEvents(EventHandler handler) {
		JVProject project = (JVProject) handler.eContainer();
		List<Object> ret = new ArrayList<>();
		for (EventHandler handler2 : project.getHandlers()) {
			ret.add(handler2.getEvent());
		}

		ret.remove(handler.getEvent());
		return ret;
	}
}
