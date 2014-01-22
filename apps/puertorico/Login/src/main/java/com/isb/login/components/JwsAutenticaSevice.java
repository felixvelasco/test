package com.isb.login.components;

import java.io.Serializable;

import javax.inject.Inject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.isb.global.components.CallData;
import com.ivrpr.ws.JwServiceAutenticaRequest;
import com.ivrpr.ws.JwServiceAutenticaResponse2;
import com.ivrpr.ws.ObjectFactory;
import com.ivrpr.ws.WebServices;
import com.vectorsf.jvoiceframework.core.service.ws.WebServiceProvider;

@Component()
@Scope("session")
public class JwsAutenticaSevice implements Serializable {

	private static final long serialVersionUID = 6673215030467377034L;
	
	@Inject
	private WebServiceProvider webServiceProvider;
	@Inject
	private CallData callData;
	
	public void autenticacion() {
		try
		{
			WebServices webService = webServiceProvider.getClient(WebServices.class, "WebServicesPort");

			ObjectFactory of = new ObjectFactory();
			JwServiceAutenticaRequest req = of.createJwServiceAutenticaRequest();
			req.setANI("");
			req.setCallID("");
			req.setConnID("");
			req.setIdContacto("");
			req.setNSS(callData.getUser().getSsid());
			req.setNIP(callData.getUser().getPin());

			JwServiceAutenticaResponse2 res = webService.jwServiceAutentica(req);
			System.out.println("########################## " + res.getDescTipoSegmento());

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
