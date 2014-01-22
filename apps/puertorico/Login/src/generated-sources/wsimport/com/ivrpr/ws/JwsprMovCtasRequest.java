
package com.ivrpr.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para jwsprMovCtasRequest complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="jwsprMovCtasRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="callID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="connID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contData" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numCtaCheques" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sequencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoCuenta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tranType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jwsprMovCtasRequest", propOrder = {
    "callID",
    "connID",
    "contData",
    "numCtaCheques",
    "sequencia",
    "tipoCuenta",
    "tranType"
})
public class JwsprMovCtasRequest {

    protected String callID;
    protected String connID;
    protected String contData;
    protected String numCtaCheques;
    protected String sequencia;
    protected String tipoCuenta;
    protected String tranType;

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
     * Obtiene el valor de la propiedad contData.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContData() {
        return contData;
    }

    /**
     * Define el valor de la propiedad contData.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContData(String value) {
        this.contData = value;
    }

    /**
     * Obtiene el valor de la propiedad numCtaCheques.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumCtaCheques() {
        return numCtaCheques;
    }

    /**
     * Define el valor de la propiedad numCtaCheques.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumCtaCheques(String value) {
        this.numCtaCheques = value;
    }

    /**
     * Obtiene el valor de la propiedad sequencia.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSequencia() {
        return sequencia;
    }

    /**
     * Define el valor de la propiedad sequencia.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSequencia(String value) {
        this.sequencia = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoCuenta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoCuenta() {
        return tipoCuenta;
    }

    /**
     * Define el valor de la propiedad tipoCuenta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoCuenta(String value) {
        this.tipoCuenta = value;
    }

    /**
     * Obtiene el valor de la propiedad tranType.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTranType() {
        return tranType;
    }

    /**
     * Define el valor de la propiedad tranType.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTranType(String value) {
        this.tranType = value;
    }

}
