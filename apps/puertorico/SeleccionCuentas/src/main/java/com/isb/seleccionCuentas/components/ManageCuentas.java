package com.isb.seleccionCuentas.components;

import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.isb.global.components.CallData;

@Component
@Scope("prototype")
public class ManageCuentas 
{
	@Inject
	Text text;
	CallData data;
	
	
	public String manageTexts()
	{
		int nInd = Integer.parseInt(text.getIndice());
		String numCuenta = data.getListaCuentas().get(nInd).getNumCuenta();
		text.setTexto("Para la cuenta que termina en "+numCuenta.substring(numCuenta.length()-4)+", presione "+(nInd+1));
		nInd++;
		text.setIndice(""+nInd);
		return null;
	}
}
