package org.tempuri;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.8
 * 2014-02-06T17:05:52.965+01:00
 * Generated source version: 2.7.8
 * 
 */
@WebService(targetNamespace = "http://tempuri.org/", name = "ServicesSoap")
@XmlSeeAlso({ObjectFactory.class})
public interface ServicesSoap {

    @WebResult(name = "JWServiceUlt5PagosProcPRResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "JWServiceUlt5PagosProcPR", targetNamespace = "http://tempuri.org/", className = "org.tempuri.JWServiceUlt5PagosProcPR")
    @WebMethod(operationName = "JWServiceUlt5PagosProcPR", action = "http://tempuri.org/JWServiceUlt5PagosProcPR")
    @ResponseWrapper(localName = "JWServiceUlt5PagosProcPRResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.JWServiceUlt5PagosProcPRResponse")
    public org.tempuri.JWServiceUlt5PagosProcPRResponse2 jwServiceUlt5PagosProcPR(
        @WebParam(name = "connID", targetNamespace = "http://tempuri.org/")
        java.lang.String connID,
        @WebParam(name = "callID", targetNamespace = "http://tempuri.org/")
        java.lang.String callID,
        @WebParam(name = "NSS", targetNamespace = "http://tempuri.org/")
        java.lang.String nss,
        @WebParam(name = "customerId", targetNamespace = "http://tempuri.org/")
        java.lang.String customerId
    );

    @WebResult(name = "JWServiceCtasMerchPRResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "JWServiceCtasMerchPR", targetNamespace = "http://tempuri.org/", className = "org.tempuri.JWServiceCtasMerchPR")
    @WebMethod(operationName = "JWServiceCtasMerchPR", action = "http://tempuri.org/JWServiceCtasMerchPR")
    @ResponseWrapper(localName = "JWServiceCtasMerchPRResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.JWServiceCtasMerchPRResponse")
    public org.tempuri.JWServiceCtasMerchPRResponse2 jwServiceCtasMerchPR(
        @WebParam(name = "connID", targetNamespace = "http://tempuri.org/")
        java.lang.String connID,
        @WebParam(name = "callID", targetNamespace = "http://tempuri.org/")
        java.lang.String callID,
        @WebParam(name = "customerId", targetNamespace = "http://tempuri.org/")
        java.lang.String customerId,
        @WebParam(name = "merchantId", targetNamespace = "http://tempuri.org/")
        java.lang.String merchantId
    );

    @WebResult(name = "JWServiceMerchantPayResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "JWServiceMerchantPay", targetNamespace = "http://tempuri.org/", className = "org.tempuri.JWServiceMerchantPay")
    @WebMethod(operationName = "JWServiceMerchantPay", action = "http://tempuri.org/JWServiceMerchantPay")
    @ResponseWrapper(localName = "JWServiceMerchantPayResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.JWServiceMerchantPayResponse")
    public org.tempuri.JWServiceMerchantPayResponse2 jwServiceMerchantPay(
        @WebParam(name = "connID", targetNamespace = "http://tempuri.org/")
        java.lang.String connID,
        @WebParam(name = "callID", targetNamespace = "http://tempuri.org/")
        java.lang.String callID,
        @WebParam(name = "customerId", targetNamespace = "http://tempuri.org/")
        java.lang.String customerId,
        @WebParam(name = "numCuenta", targetNamespace = "http://tempuri.org/")
        java.lang.String numCuenta,
        @WebParam(name = "merchantId", targetNamespace = "http://tempuri.org/")
        java.lang.String merchantId,
        @WebParam(name = "idMerchantCta", targetNamespace = "http://tempuri.org/")
        java.lang.String idMerchantCta,
        @WebParam(name = "montoPay", targetNamespace = "http://tempuri.org/")
        java.lang.String montoPay,
        @WebParam(name = "FechProcPay", targetNamespace = "http://tempuri.org/")
        java.lang.String fechProcPay
    );

    @WebResult(name = "JWServiceCtasCustPRResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "JWServiceCtasCustPR", targetNamespace = "http://tempuri.org/", className = "org.tempuri.JWServiceCtasCustPR")
    @WebMethod(operationName = "JWServiceCtasCustPR", action = "http://tempuri.org/JWServiceCtasCustPR")
    @ResponseWrapper(localName = "JWServiceCtasCustPRResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.JWServiceCtasCustPRResponse")
    public org.tempuri.JWServiceCtasCustPRResponse2 jwServiceCtasCustPR(
        @WebParam(name = "connID", targetNamespace = "http://tempuri.org/")
        java.lang.String connID,
        @WebParam(name = "callID", targetNamespace = "http://tempuri.org/")
        java.lang.String callID,
        @WebParam(name = "customerId", targetNamespace = "http://tempuri.org/")
        java.lang.String customerId,
        @WebParam(name = "idMerchantCta", targetNamespace = "http://tempuri.org/")
        java.lang.String idMerchantCta
    );

    @WebResult(name = "JWServiceMerchListPRResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "JWServiceMerchListPR", targetNamespace = "http://tempuri.org/", className = "org.tempuri.JWServiceMerchListPR")
    @WebMethod(operationName = "JWServiceMerchListPR", action = "http://tempuri.org/JWServiceMerchListPR")
    @ResponseWrapper(localName = "JWServiceMerchListPRResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.JWServiceMerchListPRResponse")
    public org.tempuri.JWServiceMerchListPRResponse2 jwServiceMerchListPR(
        @WebParam(name = "connID", targetNamespace = "http://tempuri.org/")
        java.lang.String connID,
        @WebParam(name = "callID", targetNamespace = "http://tempuri.org/")
        java.lang.String callID,
        @WebParam(name = "NSS", targetNamespace = "http://tempuri.org/")
        java.lang.String nss
    );

    @WebResult(name = "JWServicePagosPendPRResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "JWServicePagosPendPR", targetNamespace = "http://tempuri.org/", className = "org.tempuri.JWServicePagosPendPR")
    @WebMethod(operationName = "JWServicePagosPendPR", action = "http://tempuri.org/JWServicePagosPendPR")
    @ResponseWrapper(localName = "JWServicePagosPendPRResponse", targetNamespace = "http://tempuri.org/", className = "org.tempuri.JWServicePagosPendPRResponse")
    public org.tempuri.JWServicePagosPendPRResponse2 jwServicePagosPendPR(
        @WebParam(name = "connID", targetNamespace = "http://tempuri.org/")
        java.lang.String connID,
        @WebParam(name = "callID", targetNamespace = "http://tempuri.org/")
        java.lang.String callID,
        @WebParam(name = "NSS", targetNamespace = "http://tempuri.org/")
        java.lang.String nss,
        @WebParam(name = "customerId", targetNamespace = "http://tempuri.org/")
        java.lang.String customerId
    );
}
