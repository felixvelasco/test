package com.isb.jVoice.dsl.builder;

import org.eclipse.emf.common.util.EList;

import com.vectorsf.jvoice.model.operations.InitialState;
import com.vectorsf.jvoice.model.operations.State;
import com.vectorsf.jvoice.model.operations.Transition;

class GetNameTransOut {
	
	public static String Name(State state) {
		String name="";
		if (state instanceof InitialState){
			EList<Transition> TranSalida = state.getOutgoingTransitions();
			for (Transition transition : TranSalida) {			
				name=transition.getTarget().getName().toString();			
			}
		}
		return name;
		
	}
	
	

}
