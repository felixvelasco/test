
package com.ivrpr.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para jwsprLineaReservaResponse2 complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="jwsprLineaReservaResponse2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creditLimitLR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecProxPago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="montoAdeudadoLR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="montoDispoLR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="montoProxPago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="msjError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jwsprLineaReservaResponse2", propOrder = {
    "codigoError",
    "creditLimitLR",
    "fecProxPago",
    "montoAdeudadoLR",
    "montoDispoLR",
    "montoProxPago",
    "msjError"
})
public class JwsprLineaReservaResponse2 {

    protected String codigoError;
    protected String creditLimitLR;
    protected String fecProxPago;
    protected String montoAdeudadoLR;
    protected String montoDispoLR;
    protected String montoProxPago;
    protected String msjError;

    /**
     * Obtiene el valor de la propiedad codigoError.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoError() {
        return codigoError;
    }

    /**
     * Define el valor de la propiedad codigoError.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoError(String value) {
        this.codigoError = value;
    }

    /**
     * Obtiene el valor de la propiedad creditLimitLR.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditLimitLR() {
        return creditLimitLR;
    }

    /**
     * Define el valor de la propiedad creditLimitLR.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditLimitLR(String value) {
        this.creditLimitLR = value;
    }

    /**
     * Obtiene el valor de la propiedad fecProxPago.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecProxPago() {
        return fecProxPago;
    }

    /**
     * Define el valor de la propiedad fecProxPago.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecProxPago(String value) {
        this.fecProxPago = value;
    }

    /**
     * Obtiene el valor de la propiedad montoAdeudadoLR.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMontoAdeudadoLR() {
        return montoAdeudadoLR;
    }

    /**
     * Define el valor de la propiedad montoAdeudadoLR.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMontoAdeudadoLR(String value) {
        this.montoAdeudadoLR = value;
    }

    /**
     * Obtiene el valor de la propiedad montoDispoLR.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMontoDispoLR() {
        return montoDispoLR;
    }

    /**
     * Define el valor de la propiedad montoDispoLR.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMontoDispoLR(String value) {
        this.montoDispoLR = value;
    }

    /**
     * Obtiene el valor de la propiedad montoProxPago.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMontoProxPago() {
        return montoProxPago;
    }

    /**
     * Define el valor de la propiedad montoProxPago.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMontoProxPago(String value) {
        this.montoProxPago = value;
    }

    /**
     * Obtiene el valor de la propiedad msjError.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsjError() {
        return msjError;
    }

    /**
     * Define el valor de la propiedad msjError.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsjError(String value) {
        this.msjError = value;
    }

}
