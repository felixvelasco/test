
package com.ivrpr.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para listaCuentas complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="listaCuentas">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numCuenta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="prodCuenta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statusCuenta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listaCuentas", propOrder = {
    "numCuenta",
    "prodCuenta",
    "statusCuenta"
})
public class ListaCuentas {

    protected String numCuenta;
    protected String prodCuenta;
    protected String statusCuenta;

    /**
     * Obtiene el valor de la propiedad numCuenta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumCuenta() {
        return numCuenta;
    }

    /**
     * Define el valor de la propiedad numCuenta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumCuenta(String value) {
        this.numCuenta = value;
    }

    /**
     * Obtiene el valor de la propiedad prodCuenta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProdCuenta() {
        return prodCuenta;
    }

    /**
     * Define el valor de la propiedad prodCuenta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProdCuenta(String value) {
        this.prodCuenta = value;
    }

    /**
     * Obtiene el valor de la propiedad statusCuenta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusCuenta() {
        return statusCuenta;
    }

    /**
     * Define el valor de la propiedad statusCuenta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusCuenta(String value) {
        this.statusCuenta = value;
    }

}
