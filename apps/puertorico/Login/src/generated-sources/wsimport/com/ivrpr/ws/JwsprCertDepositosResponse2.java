
package com.ivrpr.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para jwsprCertDepositosResponse2 complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="jwsprCertDepositosResponse2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecPagoUltIntCDS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecProxPagoCDS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecVencCDS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="montoUltPagoIntCDS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "jwsprCertDepositosResponse2", propOrder = {
    "codigoError",
    "fecPagoUltIntCDS",
    "fecProxPagoCDS",
    "fecVencCDS",
    "montoUltPagoIntCDS",
    "msjError"
})
public class JwsprCertDepositosResponse2 {

    protected String codigoError;
    protected String fecPagoUltIntCDS;
    protected String fecProxPagoCDS;
    protected String fecVencCDS;
    protected String montoUltPagoIntCDS;
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
     * Obtiene el valor de la propiedad fecPagoUltIntCDS.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecPagoUltIntCDS() {
        return fecPagoUltIntCDS;
    }

    /**
     * Define el valor de la propiedad fecPagoUltIntCDS.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecPagoUltIntCDS(String value) {
        this.fecPagoUltIntCDS = value;
    }

    /**
     * Obtiene el valor de la propiedad fecProxPagoCDS.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecProxPagoCDS() {
        return fecProxPagoCDS;
    }

    /**
     * Define el valor de la propiedad fecProxPagoCDS.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecProxPagoCDS(String value) {
        this.fecProxPagoCDS = value;
    }

    /**
     * Obtiene el valor de la propiedad fecVencCDS.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecVencCDS() {
        return fecVencCDS;
    }

    /**
     * Define el valor de la propiedad fecVencCDS.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecVencCDS(String value) {
        this.fecVencCDS = value;
    }

    /**
     * Obtiene el valor de la propiedad montoUltPagoIntCDS.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMontoUltPagoIntCDS() {
        return montoUltPagoIntCDS;
    }

    /**
     * Define el valor de la propiedad montoUltPagoIntCDS.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMontoUltPagoIntCDS(String value) {
        this.montoUltPagoIntCDS = value;
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
