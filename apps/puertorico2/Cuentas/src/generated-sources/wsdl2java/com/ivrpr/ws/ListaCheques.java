
package com.ivrpr.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para listaCheques complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="listaCheques">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cantidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecCheques" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numCheque" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listaCheques", propOrder = {
    "cantidad",
    "fecCheques",
    "numCheque"
})
public class ListaCheques {

    protected String cantidad;
    protected String fecCheques;
    protected String numCheque;

    /**
     * Obtiene el valor de la propiedad cantidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCantidad() {
        return cantidad;
    }

    /**
     * Define el valor de la propiedad cantidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCantidad(String value) {
        this.cantidad = value;
    }

    /**
     * Obtiene el valor de la propiedad fecCheques.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecCheques() {
        return fecCheques;
    }

    /**
     * Define el valor de la propiedad fecCheques.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecCheques(String value) {
        this.fecCheques = value;
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

}
