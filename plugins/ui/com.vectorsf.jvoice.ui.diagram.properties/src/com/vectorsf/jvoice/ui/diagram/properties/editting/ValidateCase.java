package com.vectorsf.jvoice.ui.diagram.properties.editting;

import org.eclipse.core.internal.resources.OS;
import org.eclipse.core.internal.utils.Messages;
import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.osgi.util.NLS;

import com.vectorsf.jvoice.model.operations.Case;
import com.vectorsf.jvoice.model.operations.SwitchState;

@SuppressWarnings("restriction")
public class ValidateCase implements ICellEditorValidator {

	private Case miCase;
	private String DEFAULT = "default";
	public ValidateCase(Case element) {
		this.miCase = element;
	}

	@Override
	public String isValid(Object value) {
		String message;
		try{
			String valor = String.valueOf(value).trim();
			if (valor.isEmpty()){
				throw new Exception("eventName is empty");
			}
			if (valor.equals(DEFAULT)){
				throw new Exception (DEFAULT + " already exist");
			}
			SwitchState estadoSelection = (SwitchState)miCase.eContainer();
			if(estadoSelection.getCase(valor)!=null){
				throw new Exception (valor +  " already exist");
			}
			if(valor.contains(" ")){
				throw new Exception (valor +  " not can have blank spaces");
			}
			
			char[] chars = OS.INVALID_RESOURCE_CHARACTERS;
			for (int i = 0; i < chars.length; i++)
				if (valor.indexOf(chars[i]) != -1) {
					message = NLS.bind(Messages.resources_invalidCharInName, String.valueOf(chars[i]), valor);
					throw new Exception (message);
				}
			if (!OS.isNameValid(valor)) {
				message = NLS.bind(Messages.resources_invalidName, valor);
				throw new Exception (message);
			}
			
		}catch (Exception exception){
			return exception.getMessage();
	    }
 	   return null;
	}

}
