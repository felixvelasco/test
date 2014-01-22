
package com.ivrpr.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para jwsprCtasIRAResponse2 complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="jwsprCtasIRAResponse2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="balanceIRA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="intNominalIRA" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "jwsprCtasIRAResponse2", propOrder = {
    "balanceIRA",
    "codigoError",
    "intNominalIRA",
    "msjError"
})
public class JwsprCtasIRAResponse2 {

    protected String balanceIRA;
    protected String codigoError;
    protected String intNominalIRA;
    protected String msjError;

    /**
     * Obtiene el valor de la propiedad balanceIRA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBalanceIRA() {
        return balanceIRA;
    }

    /**
     * Define el valor de la propiedad balanceIRA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBalanceIRA(String value) {
        this.balanceIRA = value;
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
     * Obtiene el valor de la propiedad intNominalIRA.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntNominalIRA() {
        return intNominalIRA;
    }

    /**
     * Define el valor de la propiedad intNominalIRA.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntNominalIRA(String value) {
        this.intNominalIRA = value;
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
