
package com.ivrpr.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para jwsprTarjetaCreditoRequest complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="jwsprTarjetaCreditoRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="callID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="connID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pecoden" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pecodof" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="penumco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jwsprTarjetaCreditoRequest", propOrder = {
    "callID",
    "connID",
    "pecoden",
    "pecodof",
    "penumco"
})
public class JwsprTarjetaCreditoRequest {

    protected String callID;
    protected String connID;
    protected String pecoden;
    protected String pecodof;
    protected String penumco;

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
     * Obtiene el valor de la propiedad pecoden.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPecoden() {
        return pecoden;
    }

    /**
     * Define el valor de la propiedad pecoden.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPecoden(String value) {
        this.pecoden = value;
    }

    /**
     * Obtiene el valor de la propiedad pecodof.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPecodof() {
        return pecodof;
    }

    /**
     * Define el valor de la propiedad pecodof.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPecodof(String value) {
        this.pecodof = value;
    }

    /**
     * Obtiene el valor de la propiedad penumco.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPenumco() {
        return penumco;
    }

    /**
     * Define el valor de la propiedad penumco.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPenumco(String value) {
        this.penumco = value;
    }

}
