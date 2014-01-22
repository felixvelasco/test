
package com.ivrpr.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para jwsprSuspendeChequesRequest complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="jwsprSuspendeChequesRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="callID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="connID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="montoCheque" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numCtaCheques" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numSerieAltaCheque" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numSerieBajaCheque" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoCtaCheques" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jwsprSuspendeChequesRequest", propOrder = {
    "callID",
    "connID",
    "montoCheque",
    "numCtaCheques",
    "numSerieAltaCheque",
    "numSerieBajaCheque",
    "tipoCtaCheques"
})
public class JwsprSuspendeChequesRequest {

    protected String callID;
    protected String connID;
    protected String montoCheque;
    protected String numCtaCheques;
    protected String numSerieAltaCheque;
    protected String numSerieBajaCheque;
    protected String tipoCtaCheques;

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
     * Obtiene el valor de la propiedad montoCheque.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMontoCheque() {
        return montoCheque;
    }

    /**
     * Define el valor de la propiedad montoCheque.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMontoCheque(String value) {
        this.montoCheque = value;
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
     * Obtiene el valor de la propiedad numSerieAltaCheque.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumSerieAltaCheque() {
        return numSerieAltaCheque;
    }

    /**
     * Define el valor de la propiedad numSerieAltaCheque.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumSerieAltaCheque(String value) {
        this.numSerieAltaCheque = value;
    }

    /**
     * Obtiene el valor de la propiedad numSerieBajaCheque.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumSerieBajaCheque() {
        return numSerieBajaCheque;
    }

    /**
     * Define el valor de la propiedad numSerieBajaCheque.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumSerieBajaCheque(String value) {
        this.numSerieBajaCheque = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoCtaCheques.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoCtaCheques() {
        return tipoCtaCheques;
    }

    /**
     * Define el valor de la propiedad tipoCtaCheques.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoCtaCheques(String value) {
        this.tipoCtaCheques = value;
    }

}
