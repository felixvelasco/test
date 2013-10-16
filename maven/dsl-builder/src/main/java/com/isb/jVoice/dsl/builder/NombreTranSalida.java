package com.isb.jVoice.dsl.builder;

import org.eclipse.emf.common.util.EList;

import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.Transition;

class NombreTranSalida {
	
	public static String Nombre(State state) {
		String name="";
		
		EList<Transition> TranSalida = state.getOutgoingTransitions();
		for (Transition transition : TranSalida) {			
			name=transition.getTarget().getName().toString();			
		}
	
		return name;
		
	}
	
	

}
