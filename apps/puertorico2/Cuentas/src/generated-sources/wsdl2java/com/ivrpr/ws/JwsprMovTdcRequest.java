
package com.ivrpr.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para jwsprMovTdcRequest complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="jwsprMovTdcRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="callID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="connID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecFin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecInicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idMov" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "jwsprMovTdcRequest", propOrder = {
    "callID",
    "connID",
    "fecFin",
    "fecInicio",
    "idMov",
    "pecoden",
    "pecodof",
    "penumco"
})
public class JwsprMovTdcRequest {

    protected String callID;
    protected String connID;
    protected String fecFin;
    protected String fecInicio;
    protected String idMov;
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
     * Obtiene el valor de la propiedad fecFin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecFin() {
        return fecFin;
    }

    /**
     * Define el valor de la propiedad fecFin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecFin(String value) {
        this.fecFin = value;
    }

    /**
     * Obtiene el valor de la propiedad fecInicio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecInicio() {
        return fecInicio;
    }

    /**
     * Define el valor de la propiedad fecInicio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecInicio(String value) {
        this.fecInicio = value;
    }

    /**
     * Obtiene el valor de la propiedad idMov.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdMov() {
        return idMov;
    }

    /**
     * Define el valor de la propiedad idMov.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdMov(String value) {
        this.idMov = value;
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
