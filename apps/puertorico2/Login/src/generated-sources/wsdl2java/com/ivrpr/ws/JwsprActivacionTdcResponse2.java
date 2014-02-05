
package com.ivrpr.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para jwsprActivacionTdcResponse2 complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="jwsprActivacionTdcResponse2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="aviso1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="aviso2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codAviso1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="msjError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jwsprActivacionTdcResponse2", propOrder = {
    "aviso1",
    "aviso2",
    "codAviso1",
    "codigoError",
    "msjError"
})
public class JwsprActivacionTdcResponse2 {

    protected String aviso1;
    protected String aviso2;
    protected String codAviso1;
    protected String codigoError;
    protected String msjError;

    /**
     * Obtiene el valor de la propiedad aviso1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAviso1() {
        return aviso1;
    }

    /**
     * Define el valor de la propiedad aviso1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAviso1(String value) {
        this.aviso1 = value;
    }

    /**
     * Obtiene el valor de la propiedad aviso2.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAviso2() {
        return aviso2;
    }

    /**
     * Define el valor de la propiedad aviso2.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAviso2(String value) {
        this.aviso2 = value;
    }

    /**
     * Obtiene el valor de la propiedad codAviso1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodAviso1() {
        return codAviso1;
    }

    /**
     * Define el valor de la propiedad codAviso1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodAviso1(String value) {
        this.codAviso1 = value;
    }

    /**
     * Obtiene el valor de la propiedad codigoError.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoError() {
        return codigoError;
    }

    /**
     * Define el valor de la propiedad codigoError.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoError(String value) {
        this.codigoError = value;
    }

    /**
     * Obtiene el valor de la propiedad msjError.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsjError() {
        return msjError;
    }

    /**
     * Define el valor de la propiedad msjError.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsjError(String value) {
        this.msjError = value;
    }

}
