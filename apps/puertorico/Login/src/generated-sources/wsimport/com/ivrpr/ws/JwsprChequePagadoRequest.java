
package com.ivrpr.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para jwsprChequePagadoRequest complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="jwsprChequePagadoRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="callID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="connID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numCheque" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numCtaCheques" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jwsprChequePagadoRequest", propOrder = {
    "callID",
    "connID",
    "numCheque",
    "numCtaCheques"
})
public class JwsprChequePagadoRequest {

    protected String callID;
    protected String connID;
    protected String numCheque;
    protected String numCtaCheques;

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
     * Obtiene el valor de la propiedad numCheque.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumCheque() {
        return numCheque;
    }

    /**
     * Define el valor de la propiedad numCheque.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumCheque(String value) {
        this.numCheque = value;
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

}
