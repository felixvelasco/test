package com.isb.seleccionCuentas.components;

import java.util.List;

import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.isb.global.components.Account;
import com.isb.global.components.CallData;
import com.isb.global.components.User;

@Component
@Scope("prototype")
public class ManageCuentas 
{
	@Inject
	Text text;
	
	@Inject
	AuxClass aux;
	
	CallData data;
	
	@Inject
	private User user;
	
	
	public void manageTexts()
	{		
		StringBuilder sbText = new StringBuilder();
		List<Account> lCuen = data.getListaCuentas();

		sbText = getTextForAccounts(lCuen, aux);
		
		aux.incVuelta();	
		text.setTexto(sbText.toString());
		
	}
	
	public void manageDebitAccountsTexts(){
		
		StringBuilder sbText = new StringBuilder();
		List<Account> cuentasDebito = user.getCuentasDebito();
		
		sbText = getTextForAccounts(cuentasDebito, aux);
		
		aux.incVuelta();	
		text.setTexto(sbText.toString());
		
	}
	
	private StringBuilder getTextForAccounts(List<Account> accounts,AuxClass aux){
		
		StringBuilder sbTexts = new StringBuilder();

		// se listan las 5 primeras
		if (aux.getVuelta().equals("1"))
		{
			sbTexts.append("Por favor, seleccione la cuenta desde la que quiere hacer el pago.");
			for (int i = 0; i < accounts.size()&& i < 5; i++) 
			{
				Account debitAccount = accounts.get(i);
				sbTexts.append("Para la cuenta que termina en "+debitAccount.getNumCuenta().substring(debitAccount.getNumCuenta().length()-4)+", presione "+(i+1)+". ");
			}
			if (accounts.size()>5)
			{
				sbTexts.append("Para listar las siguientes cuentas presione 6.");
			}
		}
		// se listan las 5 segundas
		else
		{
			for (int i = 5; i < accounts.size()&& i < 10; i++) 
			{
				Account accounti = accounts.get(i);
				sbTexts.append("Para la cuenta que termina en "+accounti.getNumCuenta().substring(accounti.getNumCuenta().length()-4)+", presione "+(i+1)+". ");
			}			
		}
		
		return sbTexts;
		
	}
}
