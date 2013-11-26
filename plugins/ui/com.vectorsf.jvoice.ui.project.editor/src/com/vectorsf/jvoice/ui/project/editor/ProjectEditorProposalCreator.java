package com.vectorsf.jvoice.ui.project.editor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.parsley.binding.ProposalCreator;

import com.vectorsf.jvoice.model.base.EventHandler;
import com.vectorsf.jvoice.model.base.EventsEnum;
import com.vectorsf.jvoice.model.base.JVProject;
import com.vectorsf.jvoice.model.operations.Flow;
import com.vectorsf.jvoice.model.operations.OperationsPackage;

public class ProjectEditorProposalCreator extends ProposalCreator {

	public List<EventsEnum> proposals_EventHandler_event(EventHandler handler) {
		List<EventsEnum> ret = getAllEvents();
		ret.removeAll(collectCoveredEvents(handler));

		return ret;
	}

	public List<Object> proposals_EventHandler_handler(EventHandler handler) {
		Set<Object> allInstances = new HashSet<>(findAllInstances(OperationsPackage.eINSTANCE.getFlow()));
		ArrayList<Object> ret = new ArrayList<>(allInstances);
		Collections.sort(ret, new Comparator<Object>() {
			@Override
			public int compare(Object o1, Object o2) {
				Flow f1 = (Flow) o1;
				Flow f2 = (Flow) o2;
				return fullName(f2).compareTo(fullName(f1));
			}
		});

		return ret;
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

	private ArrayList<EventsEnum> getAllEvents() {
		// TODO ENUM!
		return new ArrayList<>(EventsEnum.VALUES);
	}
}
