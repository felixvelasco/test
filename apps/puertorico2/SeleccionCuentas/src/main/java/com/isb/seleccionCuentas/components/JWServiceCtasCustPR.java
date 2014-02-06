package com.isb.seleccionCuentas.components;

import java.io.Serializable;

import org.springframework.stereotype.Component;

@Component
public class JWServiceCtasCustPR implements Serializable{
	
	private static final long serialVersionUID = 153093399972831559L;

	public void invokeCtasCustPR(){
		
		System.out.println("Invoking CtasCustPR WS");
		
	}

}
