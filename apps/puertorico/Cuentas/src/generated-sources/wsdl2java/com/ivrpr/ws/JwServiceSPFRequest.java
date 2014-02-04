
package com.ivrpr.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para jwServiceSPFRequest complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="jwServiceSPFRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ANI" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="callID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="connID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NSS" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jwServiceSPFRequest", propOrder = {
    "ani",
    "callID",
    "connID",
    "nss"
})
public class JwServiceSPFRequest {

    @XmlElement(name = "ANI")
    protected String ani;
    protected String callID;
    protected String connID;
    @XmlElement(name = "NSS")
    protected String nss;

    /**
     * Obtiene el valor de la propiedad ani.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getANI() {
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
    public void setANI(String value) {
        this.ani = value;
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

}
