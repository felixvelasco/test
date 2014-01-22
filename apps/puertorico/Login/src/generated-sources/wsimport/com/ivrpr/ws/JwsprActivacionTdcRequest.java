
package com.ivrpr.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para jwsprActivacionTdcRequest complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="jwsprActivacionTdcRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ani" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CVC2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="callID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="connID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NSS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoAccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jwsprActivacionTdcRequest", propOrder = {
    "ani",
    "cvc2",
    "callID",
    "connID",
    "nss",
    "pan",
    "tipoAccion"
})
public class JwsprActivacionTdcRequest {

    protected String ani;
    @XmlElement(name = "CVC2")
    protected String cvc2;
    protected String callID;
    protected String connID;
    @XmlElement(name = "NSS")
    protected String nss;
    protected String pan;
    protected String tipoAccion;

    /**
     * Obtiene el valor de la propiedad ani.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAni() {
        return ani;
    }

    /**
     * Define el valor de la propiedad ani.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAni(String value) {
        this.ani = value;
    }

    /**
     * Obtiene el valor de la propiedad cvc2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCVC2() {
        return cvc2;
    }

    /**
     * Define el valor de la propiedad cvc2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCVC2(String value) {
        this.cvc2 = value;
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
     * Obtiene el valor de la propiedad nss.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNSS() {
        return nss;
    }

    /**
     * Define el valor de la propiedad nss.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNSS(String value) {
        this.nss = value;
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

    /**
     * Obtiene el valor de la propiedad tipoAccion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoAccion() {
        return tipoAccion;
    }

    /**
     * Define el valor de la propiedad tipoAccion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoAccion(String value) {
        this.tipoAccion = value;
    }

}
