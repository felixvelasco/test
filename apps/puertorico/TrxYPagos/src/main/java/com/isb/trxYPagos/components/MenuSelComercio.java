package com.isb.trxYPagos.components;

import java.io.Serializable;

import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class MenuSelComercio implements Serializable {

	private static final long serialVersionUID = 5601957698327244373L;
	
	@Inject
	private PagoComercio pagoComercio;
	
	private int paginaSel;

	public int getPaginaSel() {
		return paginaSel;
	}

	public void setPaginaSel(int paginaSel) {
		this.paginaSel = paginaSel;
	}

	public PagoComercio getPagoComercio() {
		return pagoComercio;
	}

	public void setPagoComercio(PagoComercio pagoComercio) {
		this.pagoComercio = pagoComercio;
	}
	
	public String condPrompt(int index) {
		return String.valueOf( getPaginaSel() * 5 + index < pagoComercio.getListaComercios().size());
	}
	
	public String condTTS(int index) {
		if( getPaginaSel() * 5 + index < pagoComercio.getListaComercios().size()) {
			return pagoComercio.getListaComercios().get(getPaginaSel() * 5 + index).getMerchantName();
		} else {
			return "";
		}
		
	}
}
