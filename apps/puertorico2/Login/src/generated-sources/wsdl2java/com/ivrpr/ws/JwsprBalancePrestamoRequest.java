
package com.ivrpr.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para jwsprBalancePrestamoRequest complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="jwsprBalancePrestamoRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="callID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="connID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numCtaPrestamo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoCtaPrestamo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jwsprBalancePrestamoRequest", propOrder = {
    "callID",
    "connID",
    "numCtaPrestamo",
    "tipoCtaPrestamo"
})
public class JwsprBalancePrestamoRequest {

    protected String callID;
    protected String connID;
    protected String numCtaPrestamo;
    protected String tipoCtaPrestamo;

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
     * Obtiene el valor de la propiedad numCtaPrestamo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumCtaPrestamo() {
        return numCtaPrestamo;
    }

    /**
     * Define el valor de la propiedad numCtaPrestamo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumCtaPrestamo(String value) {
        this.numCtaPrestamo = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoCtaPrestamo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoCtaPrestamo() {
        return tipoCtaPrestamo;
    }

    /**
     * Define el valor de la propiedad tipoCtaPrestamo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoCtaPrestamo(String value) {
        this.tipoCtaPrestamo = value;
    }

}
