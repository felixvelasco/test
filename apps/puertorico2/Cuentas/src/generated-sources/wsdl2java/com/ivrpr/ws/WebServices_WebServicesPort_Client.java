
package com.ivrpr.ws;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.8
 * 2014-02-06T10:15:38.195+01:00
 * Generated source version: 2.7.8
 * 
 */
public final class WebServices_WebServicesPort_Client {

    private static final QName SERVICE_NAME = new QName("http://ws.ivrpr.com/", "WebServicesService");

    private WebServices_WebServicesPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = WebServicesService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        WebServicesService ss = new WebServicesService(wsdlURL, SERVICE_NAME);
        WebServices port = ss.getWebServicesPort();  
        
        {
        System.out.println("Invoking jwServiceSPF...");
        com.ivrpr.ws.JwServiceSPFRequest _jwServiceSPF_arg0 = null;
        com.ivrpr.ws.JwServiceSPFResponse2 _jwServiceSPF__return = port.jwServiceSPF(_jwServiceSPF_arg0);
        System.out.println("jwServiceSPF.result=" + _jwServiceSPF__return);


        }
        {
        System.out.println("Invoking jwsprCertDepositos...");
        com.ivrpr.ws.JwsprCertDepositosRequest _jwsprCertDepositos_arg0 = null;
        com.ivrpr.ws.JwsprCertDepositosResponse2 _jwsprCertDepositos__return = port.jwsprCertDepositos(_jwsprCertDepositos_arg0);
        System.out.println("jwsprCertDepositos.result=" + _jwsprCertDepositos__return);


        }
        {
        System.out.println("Invoking jwsprBalanceCheque...");
        com.ivrpr.ws.JwsprBalanceChequeRequest _jwsprBalanceCheque_arg0 = null;
        com.ivrpr.ws.JwsprBalanceChequeResponse2 _jwsprBalanceCheque__return = port.jwsprBalanceCheque(_jwsprBalanceCheque_arg0);
        System.out.println("jwsprBalanceCheque.result=" + _jwsprBalanceCheque__return);


        }
        {
        System.out.println("Invoking jwsprMovTdc...");
        com.ivrpr.ws.JwsprMovTdcRequest _jwsprMovTdc_arg0 = null;
        com.ivrpr.ws.JwsprMovTdcResponse2 _jwsprMovTdc__return = port.jwsprMovTdc(_jwsprMovTdc_arg0);
        System.out.println("jwsprMovTdc.result=" + _jwsprMovTdc__return);


        }
        {
        System.out.println("Invoking jwsprBalanceAhorro...");
        com.ivrpr.ws.JwsprBalanceAhorroRequest _jwsprBalanceAhorro_arg0 = null;
        com.ivrpr.ws.JwsprBalanceAhorroResponse2 _jwsprBalanceAhorro__return = port.jwsprBalanceAhorro(_jwsprBalanceAhorro_arg0);
        System.out.println("jwsprBalanceAhorro.result=" + _jwsprBalanceAhorro__return);


        }
        {
        System.out.println("Invoking jwServiceSegmento...");
        com.ivrpr.ws.JwServiceSegmentoRequest _jwServiceSegmento_arg0 = null;
        com.ivrpr.ws.JwServiceSegmentoResponse2 _jwServiceSegmento__return = port.jwServiceSegmento(_jwServiceSegmento_arg0);
        System.out.println("jwServiceSegmento.result=" + _jwServiceSegmento__return);


        }
        {
        System.out.println("Invoking jwsprPortafolio...");
        com.ivrpr.ws.JwsprPortafolioRequest _jwsprPortafolio_arg0 = null;
        com.ivrpr.ws.JwsprPortafolioResponse2 _jwsprPortafolio__return = port.jwsprPortafolio(_jwsprPortafolio_arg0);
        System.out.println("jwsprPortafolio.result=" + _jwsprPortafolio__return);


        }
        {
        System.out.println("Invoking jwsprSuspendeCheques...");
        com.ivrpr.ws.JwsprSuspendeChequesRequest _jwsprSuspendeCheques_arg0 = null;
        com.ivrpr.ws.JwsprSuspendeChequesResponse2 _jwsprSuspendeCheques__return = port.jwsprSuspendeCheques(_jwsprSuspendeCheques_arg0);
        System.out.println("jwsprSuspendeCheques.result=" + _jwsprSuspendeCheques__return);


        }
        {
        System.out.println("Invoking jwsprLineaReserva...");
        com.ivrpr.ws.JwsprLineaReservaRequest _jwsprLineaReserva_arg0 = null;
        com.ivrpr.ws.JwsprLineaReservaResponse2 _jwsprLineaReserva__return = port.jwsprLineaReserva(_jwsprLineaReserva_arg0);
        System.out.println("jwsprLineaReserva.result=" + _jwsprLineaReserva__return);


        }
        {
        System.out.println("Invoking jwsprActivacionTdc...");
        com.ivrpr.ws.JwsprActivacionTdcRequest _jwsprActivacionTdc_arg0 = null;
        com.ivrpr.ws.JwsprActivacionTdcResponse2 _jwsprActivacionTdc__return = port.jwsprActivacionTdc(_jwsprActivacionTdc_arg0);
        System.out.println("jwsprActivacionTdc.result=" + _jwsprActivacionTdc__return);


        }
        {
        System.out.println("Invoking jwsprChequePagado...");
        com.ivrpr.ws.JwsprChequePagadoRequest _jwsprChequePagado_arg0 = null;
        com.ivrpr.ws.JwsprChequePagadoResponse2 _jwsprChequePagado__return = port.jwsprChequePagado(_jwsprChequePagado_arg0);
        System.out.println("jwsprChequePagado.result=" + _jwsprChequePagado__return);


        }
        {
        System.out.println("Invoking jwServiceAutentica...");
        com.ivrpr.ws.JwServiceAutenticaRequest _jwServiceAutentica_arg0 = null;
        com.ivrpr.ws.JwServiceAutenticaResponse2 _jwServiceAutentica__return = port.jwServiceAutentica(_jwServiceAutentica_arg0);
        System.out.println("jwServiceAutentica.result=" + _jwServiceAutentica__return);


        }
        {
        System.out.println("Invoking jwsprMovCtas...");
        com.ivrpr.ws.JwsprMovCtasRequest _jwsprMovCtas_arg0 = null;
        com.ivrpr.ws.JwsprMovCtasResponse2 _jwsprMovCtas__return = port.jwsprMovCtas(_jwsprMovCtas_arg0);
        System.out.println("jwsprMovCtas.result=" + _jwsprMovCtas__return);


        }
        {
        System.out.println("Invoking jwsprPagoTdc...");
        com.ivrpr.ws.JwsprPagoTdcRequest _jwsprPagoTdc_arg0 = null;
        com.ivrpr.ws.JwsprPagoTdcResponse2 _jwsprPagoTdc__return = port.jwsprPagoTdc(_jwsprPagoTdc_arg0);
        System.out.println("jwsprPagoTdc.result=" + _jwsprPagoTdc__return);


        }
        {
        System.out.println("Invoking jwsprTarjetaCredito...");
        com.ivrpr.ws.JwsprTarjetaCreditoRequest _jwsprTarjetaCredito_arg0 = null;
        com.ivrpr.ws.JwsprTarjetaCreditoResponse2 _jwsprTarjetaCredito__return = port.jwsprTarjetaCredito(_jwsprTarjetaCredito_arg0);
        System.out.println("jwsprTarjetaCredito.result=" + _jwsprTarjetaCredito__return);


        }
        {
        System.out.println("Invoking jwsprCtasIRA...");
        com.ivrpr.ws.JwsprCtasIRARequest _jwsprCtasIRA_arg0 = null;
        com.ivrpr.ws.JwsprCtasIRAResponse2 _jwsprCtasIRA__return = port.jwsprCtasIRA(_jwsprCtasIRA_arg0);
        System.out.println("jwsprCtasIRA.result=" + _jwsprCtasIRA__return);


        }
        {
        System.out.println("Invoking jwsprCambioNip...");
        com.ivrpr.ws.JwsprCambioNipRequest _jwsprCambioNip_arg0 = null;
        com.ivrpr.ws.JwsprCambioNipResponse2 _jwsprCambioNip__return = port.jwsprCambioNip(_jwsprCambioNip_arg0);
        System.out.println("jwsprCambioNip.result=" + _jwsprCambioNip__return);


        }
        {
        System.out.println("Invoking jwsprTransferCtas...");
        com.ivrpr.ws.JwsprTransferCtaRequest _jwsprTransferCtas_arg0 = null;
        com.ivrpr.ws.JwsprTransferCtaResponse2 _jwsprTransferCtas__return = port.jwsprTransferCtas(_jwsprTransferCtas_arg0);
        System.out.println("jwsprTransferCtas.result=" + _jwsprTransferCtas__return);


        }

        System.exit(0);
    }

}
