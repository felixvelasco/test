
package com.ivrpr.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para jwsprPagoTdcRequest complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="jwsprPagoTdcRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="balanceAdeudaTdc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="balanceDispTdc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="callID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="connID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creditLimitTdc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="importePagTdc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numCtaCargo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="panTdc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jwsprPagoTdcRequest", propOrder = {
    "balanceAdeudaTdc",
    "balanceDispTdc",
    "callID",
    "connID",
    "creditLimitTdc",
    "importePagTdc",
    "numCtaCargo",
    "panTdc"
})
public class JwsprPagoTdcRequest {

    protected String balanceAdeudaTdc;
    protected String balanceDispTdc;
    protected String callID;
    protected String connID;
    protected String creditLimitTdc;
    protected String importePagTdc;
    protected String numCtaCargo;
    protected String panTdc;

    /**
     * Obtiene el valor de la propiedad balanceAdeudaTdc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBalanceAdeudaTdc() {
        return balanceAdeudaTdc;
    }

    /**
     * Define el valor de la propiedad balanceAdeudaTdc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBalanceAdeudaTdc(String value) {
        this.balanceAdeudaTdc = value;
    }

    /**
     * Obtiene el valor de la propiedad balanceDispTdc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBalanceDispTdc() {
        return balanceDispTdc;
    }

    /**
     * Define el valor de la propiedad balanceDispTdc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBalanceDispTdc(String value) {
        this.balanceDispTdc = value;
    }

    /**
     * Obtiene el valor de la propiedad callID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCallID() {
        return callID;
    }

    /**
     * Define el valor de la propiedad callID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCallID(String value) {
        this.callID = value;
    }

    /**
     * Obtiene el valor de la propiedad connID.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConnID() {
        return connID;
    }

    /**
     * Define el valor de la propiedad connID.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConnID(String value) {
        this.connID = value;
    }

    /**
     * Obtiene el valor de la propiedad creditLimitTdc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditLimitTdc() {
        return creditLimitTdc;
    }

    /**
     * Define el valor de la propiedad creditLimitTdc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditLimitTdc(String value) {
        this.creditLimitTdc = value;
    }

    /**
     * Obtiene el valor de la propiedad importePagTdc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImportePagTdc() {
        return importePagTdc;
    }

    /**
     * Define el valor de la propiedad importePagTdc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImportePagTdc(String value) {
        this.importePagTdc = value;
    }

    /**
     * Obtiene el valor de la propiedad numCtaCargo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumCtaCargo() {
        return numCtaCargo;
    }

    /**
     * Define el valor de la propiedad numCtaCargo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumCtaCargo(String value) {
        this.numCtaCargo = value;
    }

    /**
     * Obtiene el valor de la propiedad panTdc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPanTdc() {
        return panTdc;
    }

    /**
     * Define el valor de la propiedad panTdc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPanTdc(String value) {
        this.panTdc = value;
    }

}
