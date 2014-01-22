
package com.ivrpr.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para jwsprTarjetaCreditoResponse2 complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="jwsprTarjetaCreditoResponse2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="balanceAdeudaTdc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="balanceDispTdc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creditLimitTdc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="desmarca" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="destiptot" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecCargoTdc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecUltPago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="importeUltPagoTdc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="msjError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pagoMinTdc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jwsprTarjetaCreditoResponse2", propOrder = {
    "balanceAdeudaTdc",
    "balanceDispTdc",
    "codigoError",
    "creditLimitTdc",
    "desmarca",
    "destiptot",
    "fecCargoTdc",
    "fecUltPago",
    "importeUltPagoTdc",
    "msjError",
    "pagoMinTdc",
    "pan"
})
public class JwsprTarjetaCreditoResponse2 {

    protected String balanceAdeudaTdc;
    protected String balanceDispTdc;
    protected String codigoError;
    protected String creditLimitTdc;
    protected String desmarca;
    protected String destiptot;
    protected String fecCargoTdc;
    protected String fecUltPago;
    protected String importeUltPagoTdc;
    protected String msjError;
    protected String pagoMinTdc;
    protected String pan;

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
     * Obtiene el valor de la propiedad desmarca.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesmarca() {
        return desmarca;
    }

    /**
     * Define el valor de la propiedad desmarca.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesmarca(String value) {
        this.desmarca = value;
    }

    /**
     * Obtiene el valor de la propiedad destiptot.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestiptot() {
        return destiptot;
    }

    /**
     * Define el valor de la propiedad destiptot.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestiptot(String value) {
        this.destiptot = value;
    }

    /**
     * Obtiene el valor de la propiedad fecCargoTdc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecCargoTdc() {
        return fecCargoTdc;
    }

    /**
     * Define el valor de la propiedad fecCargoTdc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecCargoTdc(String value) {
        this.fecCargoTdc = value;
    }

    /**
     * Obtiene el valor de la propiedad fecUltPago.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecUltPago() {
        return fecUltPago;
    }

    /**
     * Define el valor de la propiedad fecUltPago.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecUltPago(String value) {
        this.fecUltPago = value;
    }

    /**
     * Obtiene el valor de la propiedad importeUltPagoTdc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImporteUltPagoTdc() {
        return importeUltPagoTdc;
    }

    /**
     * Define el valor de la propiedad importeUltPagoTdc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImporteUltPagoTdc(String value) {
        this.importeUltPagoTdc = value;
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

    /**
     * Obtiene el valor de la propiedad pagoMinTdc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPagoMinTdc() {
        return pagoMinTdc;
    }

    /**
     * Define el valor de la propiedad pagoMinTdc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPagoMinTdc(String value) {
        this.pagoMinTdc = value;
    }

    /**
     * Obtiene el valor de la propiedad pan.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPan() {
        return pan;
    }

    /**
     * Define el valor de la propiedad pan.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPan(String value) {
        this.pan = value;
    }

}
