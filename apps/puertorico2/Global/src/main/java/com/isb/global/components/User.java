package com.isb.global.components;

import java.io.Serializable;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class User implements Serializable {

	private static final long serialVersionUID = -5322130833243268248L;
	
	private boolean logged;
	private String ssid;
	private String pin;
	
	private List<Account> cuentasDebito;
	
	public boolean isLogged() {
		return logged;
	}

	public void setLogged(boolean logged) {
		this.logged = logged;
	}

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public List<Account> getCuentasDebito() {
		return cuentasDebito;
	}

	public void setCuentasDebito(List<Account> cuentasDebito) {
		this.cuentasDebito = cuentasDebito;
	}
	
	
}
