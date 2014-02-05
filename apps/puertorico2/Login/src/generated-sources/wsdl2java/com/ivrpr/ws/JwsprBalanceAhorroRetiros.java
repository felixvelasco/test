
package com.ivrpr.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para jwsprBalanceAhorroRetiros complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="jwsprBalanceAhorroRetiros">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cantidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecRetiro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jwsprBalanceAhorroRetiros", propOrder = {
    "cantidad",
    "fecRetiro"
})
public class JwsprBalanceAhorroRetiros {

    protected String cantidad;
    protected String fecRetiro;

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
     * Obtiene el valor de la propiedad fecRetiro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecRetiro() {
        return fecRetiro;
    }

    /**
     * Define el valor de la propiedad fecRetiro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecRetiro(String value) {
        this.fecRetiro = value;
    }

}
