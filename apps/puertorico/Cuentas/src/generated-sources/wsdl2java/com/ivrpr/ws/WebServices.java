package com.ivrpr.ws;

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
 * 2014-02-04T13:57:42.115+01:00
 * Generated source version: 2.7.8
 * 
 */
@WebService(targetNamespace = "http://ws.ivrpr.com/", name = "WebServices")
@XmlSeeAlso({ObjectFactory.class})
public interface WebServices {

    @WebResult(name = "return", targetNamespace = "")
    @Action(input = "http://ws.ivrpr.com/WebServices/JWServiceSPFRequest", output = "http://ws.ivrpr.com/WebServices/JWServiceSPFResponse")
    @RequestWrapper(localName = "JWServiceSPF", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWServiceSPF")
    @WebMethod(operationName = "JWServiceSPF")
    @ResponseWrapper(localName = "JWServiceSPFResponse", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWServiceSPFResponse")
    public com.ivrpr.ws.JwServiceSPFResponse2 jwServiceSPF(
        @WebParam(name = "arg0", targetNamespace = "")
        com.ivrpr.ws.JwServiceSPFRequest arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @Action(input = "http://ws.ivrpr.com/WebServices/JWSPRCertDepositosRequest", output = "http://ws.ivrpr.com/WebServices/JWSPRCertDepositosResponse")
    @RequestWrapper(localName = "JWSPRCertDepositos", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWSPRCertDepositos")
    @WebMethod(operationName = "JWSPRCertDepositos")
    @ResponseWrapper(localName = "JWSPRCertDepositosResponse", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWSPRCertDepositosResponse")
    public com.ivrpr.ws.JwsprCertDepositosResponse2 jwsprCertDepositos(
        @WebParam(name = "arg0", targetNamespace = "")
        com.ivrpr.ws.JwsprCertDepositosRequest arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @Action(input = "http://ws.ivrpr.com/WebServices/JWSPRBalanceChequeRequest", output = "http://ws.ivrpr.com/WebServices/JWSPRBalanceChequeResponse")
    @RequestWrapper(localName = "JWSPRBalanceCheque", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWSPRBalanceCheque")
    @WebMethod(operationName = "JWSPRBalanceCheque")
    @ResponseWrapper(localName = "JWSPRBalanceChequeResponse", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWSPRBalanceChequeResponse")
    public com.ivrpr.ws.JwsprBalanceChequeResponse2 jwsprBalanceCheque(
        @WebParam(name = "arg0", targetNamespace = "")
        com.ivrpr.ws.JwsprBalanceChequeRequest arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @Action(input = "http://ws.ivrpr.com/WebServices/JWSPRMovTdcRequest", output = "http://ws.ivrpr.com/WebServices/JWSPRMovTdcResponse")
    @RequestWrapper(localName = "JWSPRMovTdc", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWSPRMovTdc")
    @WebMethod(operationName = "JWSPRMovTdc")
    @ResponseWrapper(localName = "JWSPRMovTdcResponse", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWSPRMovTdcResponse")
    public com.ivrpr.ws.JwsprMovTdcResponse2 jwsprMovTdc(
        @WebParam(name = "arg0", targetNamespace = "")
        com.ivrpr.ws.JwsprMovTdcRequest arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @Action(input = "http://ws.ivrpr.com/WebServices/JWSPRBalanceAhorroRequest", output = "http://ws.ivrpr.com/WebServices/JWSPRBalanceAhorroResponse")
    @RequestWrapper(localName = "JWSPRBalanceAhorro", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWSPRBalanceAhorro")
    @WebMethod(operationName = "JWSPRBalanceAhorro")
    @ResponseWrapper(localName = "JWSPRBalanceAhorroResponse", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWSPRBalanceAhorroResponse")
    public com.ivrpr.ws.JwsprBalanceAhorroResponse2 jwsprBalanceAhorro(
        @WebParam(name = "arg0", targetNamespace = "")
        com.ivrpr.ws.JwsprBalanceAhorroRequest arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @Action(input = "http://ws.ivrpr.com/WebServices/JWServiceSegmentoRequest", output = "http://ws.ivrpr.com/WebServices/JWServiceSegmentoResponse")
    @RequestWrapper(localName = "JWServiceSegmento", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWServiceSegmento")
    @WebMethod(operationName = "JWServiceSegmento")
    @ResponseWrapper(localName = "JWServiceSegmentoResponse", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWServiceSegmentoResponse")
    public com.ivrpr.ws.JwServiceSegmentoResponse2 jwServiceSegmento(
        @WebParam(name = "arg0", targetNamespace = "")
        com.ivrpr.ws.JwServiceSegmentoRequest arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @Action(input = "http://ws.ivrpr.com/WebServices/JWSPRPortafolioRequest", output = "http://ws.ivrpr.com/WebServices/JWSPRPortafolioResponse")
    @RequestWrapper(localName = "JWSPRPortafolio", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWSPRPortafolio")
    @WebMethod(operationName = "JWSPRPortafolio")
    @ResponseWrapper(localName = "JWSPRPortafolioResponse", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWSPRPortafolioResponse")
    public com.ivrpr.ws.JwsprPortafolioResponse2 jwsprPortafolio(
        @WebParam(name = "arg0", targetNamespace = "")
        com.ivrpr.ws.JwsprPortafolioRequest arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @Action(input = "http://ws.ivrpr.com/WebServices/JWSPRSuspendeChequesRequest", output = "http://ws.ivrpr.com/WebServices/JWSPRSuspendeChequesResponse")
    @RequestWrapper(localName = "JWSPRSuspendeCheques", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWSPRSuspendeCheques")
    @WebMethod(operationName = "JWSPRSuspendeCheques")
    @ResponseWrapper(localName = "JWSPRSuspendeChequesResponse", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWSPRSuspendeChequesResponse")
    public com.ivrpr.ws.JwsprSuspendeChequesResponse2 jwsprSuspendeCheques(
        @WebParam(name = "arg0", targetNamespace = "")
        com.ivrpr.ws.JwsprSuspendeChequesRequest arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @Action(input = "http://ws.ivrpr.com/WebServices/JWSPRLineaReservaRequest", output = "http://ws.ivrpr.com/WebServices/JWSPRLineaReservaResponse")
    @RequestWrapper(localName = "JWSPRLineaReserva", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWSPRLineaReserva")
    @WebMethod(operationName = "JWSPRLineaReserva")
    @ResponseWrapper(localName = "JWSPRLineaReservaResponse", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWSPRLineaReservaResponse")
    public com.ivrpr.ws.JwsprLineaReservaResponse2 jwsprLineaReserva(
        @WebParam(name = "arg0", targetNamespace = "")
        com.ivrpr.ws.JwsprLineaReservaRequest arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @Action(input = "http://ws.ivrpr.com/WebServices/JWSPRActivacionTdcRequest", output = "http://ws.ivrpr.com/WebServices/JWSPRActivacionTdcResponse")
    @RequestWrapper(localName = "JWSPRActivacionTdc", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWSPRActivacionTdc")
    @WebMethod(operationName = "JWSPRActivacionTdc")
    @ResponseWrapper(localName = "JWSPRActivacionTdcResponse", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWSPRActivacionTdcResponse")
    public com.ivrpr.ws.JwsprActivacionTdcResponse2 jwsprActivacionTdc(
        @WebParam(name = "arg0", targetNamespace = "")
        com.ivrpr.ws.JwsprActivacionTdcRequest arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @Action(input = "http://ws.ivrpr.com/WebServices/JWSPRChequePagadoRequest", output = "http://ws.ivrpr.com/WebServices/JWSPRChequePagadoResponse")
    @RequestWrapper(localName = "JWSPRChequePagado", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWSPRChequePagado")
    @WebMethod(operationName = "JWSPRChequePagado")
    @ResponseWrapper(localName = "JWSPRChequePagadoResponse", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWSPRChequePagadoResponse")
    public com.ivrpr.ws.JwsprChequePagadoResponse2 jwsprChequePagado(
        @WebParam(name = "arg0", targetNamespace = "")
        com.ivrpr.ws.JwsprChequePagadoRequest arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @Action(input = "http://ws.ivrpr.com/WebServices/JWServiceAutenticaRequest", output = "http://ws.ivrpr.com/WebServices/JWServiceAutenticaResponse")
    @RequestWrapper(localName = "JWServiceAutentica", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWServiceAutentica")
    @WebMethod(operationName = "JWServiceAutentica")
    @ResponseWrapper(localName = "JWServiceAutenticaResponse", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWServiceAutenticaResponse")
    public com.ivrpr.ws.JwServiceAutenticaResponse2 jwServiceAutentica(
        @WebParam(name = "arg0", targetNamespace = "")
        com.ivrpr.ws.JwServiceAutenticaRequest arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @Action(input = "http://ws.ivrpr.com/WebServices/JWSPRMovCtasRequest", output = "http://ws.ivrpr.com/WebServices/JWSPRMovCtasResponse")
    @RequestWrapper(localName = "JWSPRMovCtas", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWSPRMovCtas")
    @WebMethod(operationName = "JWSPRMovCtas")
    @ResponseWrapper(localName = "JWSPRMovCtasResponse", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWSPRMovCtasResponse")
    public com.ivrpr.ws.JwsprMovCtasResponse2 jwsprMovCtas(
        @WebParam(name = "arg0", targetNamespace = "")
        com.ivrpr.ws.JwsprMovCtasRequest arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @Action(input = "http://ws.ivrpr.com/WebServices/JWSPRPagoTdcRequest", output = "http://ws.ivrpr.com/WebServices/JWSPRPagoTdcResponse")
    @RequestWrapper(localName = "JWSPRPagoTdc", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWSPRPagoTdc")
    @WebMethod(operationName = "JWSPRPagoTdc")
    @ResponseWrapper(localName = "JWSPRPagoTdcResponse", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWSPRPagoTdcResponse")
    public com.ivrpr.ws.JwsprPagoTdcResponse2 jwsprPagoTdc(
        @WebParam(name = "arg0", targetNamespace = "")
        com.ivrpr.ws.JwsprPagoTdcRequest arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @Action(input = "http://ws.ivrpr.com/WebServices/JWSPRTarjetaCreditoRequest", output = "http://ws.ivrpr.com/WebServices/JWSPRTarjetaCreditoResponse")
    @RequestWrapper(localName = "JWSPRTarjetaCredito", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWSPRTarjetaCredito")
    @WebMethod(operationName = "JWSPRTarjetaCredito")
    @ResponseWrapper(localName = "JWSPRTarjetaCreditoResponse", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWSPRTarjetaCreditoResponse")
    public com.ivrpr.ws.JwsprTarjetaCreditoResponse2 jwsprTarjetaCredito(
        @WebParam(name = "arg0", targetNamespace = "")
        com.ivrpr.ws.JwsprTarjetaCreditoRequest arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @Action(input = "http://ws.ivrpr.com/WebServices/JWSPRCtasIRARequest", output = "http://ws.ivrpr.com/WebServices/JWSPRCtasIRAResponse")
    @RequestWrapper(localName = "JWSPRCtasIRA", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWSPRCtasIRA")
    @WebMethod(operationName = "JWSPRCtasIRA")
    @ResponseWrapper(localName = "JWSPRCtasIRAResponse", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWSPRCtasIRAResponse")
    public com.ivrpr.ws.JwsprCtasIRAResponse2 jwsprCtasIRA(
        @WebParam(name = "arg0", targetNamespace = "")
        com.ivrpr.ws.JwsprCtasIRARequest arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @Action(input = "http://ws.ivrpr.com/WebServices/JWSPRCambioNipRequest", output = "http://ws.ivrpr.com/WebServices/JWSPRCambioNipResponse")
    @RequestWrapper(localName = "JWSPRCambioNip", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWSPRCambioNip")
    @WebMethod(operationName = "JWSPRCambioNip")
    @ResponseWrapper(localName = "JWSPRCambioNipResponse", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWSPRCambioNipResponse")
    public com.ivrpr.ws.JwsprCambioNipResponse2 jwsprCambioNip(
        @WebParam(name = "arg0", targetNamespace = "")
        com.ivrpr.ws.JwsprCambioNipRequest arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @Action(input = "http://ws.ivrpr.com/WebServices/JWSPRTransferCtasRequest", output = "http://ws.ivrpr.com/WebServices/JWSPRTransferCtasResponse")
    @RequestWrapper(localName = "JWSPRTransferCtas", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWSPRTransferCtas")
    @WebMethod(operationName = "JWSPRTransferCtas")
    @ResponseWrapper(localName = "JWSPRTransferCtasResponse", targetNamespace = "http://ws.ivrpr.com/", className = "com.ivrpr.ws.JWSPRTransferCtasResponse")
    public com.ivrpr.ws.JwsprTransferCtaResponse2 jwsprTransferCtas(
        @WebParam(name = "arg0", targetNamespace = "")
        com.ivrpr.ws.JwsprTransferCtaRequest arg0
    );
}
