
package com.ivrpr.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para jwsprTransferCtaRequest complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="jwsprTransferCtaRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="callID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="connID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cuentaDeposito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cuentaRetiro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="montoTransfer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoCtaDeposito" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoCtaRetiro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jwsprTransferCtaRequest", propOrder = {
    "callID",
    "connID",
    "cuentaDeposito",
    "cuentaRetiro",
    "montoTransfer",
    "tipoCtaDeposito",
    "tipoCtaRetiro"
})
public class JwsprTransferCtaRequest {

    protected String callID;
    protected String connID;
    protected String cuentaDeposito;
    protected String cuentaRetiro;
    protected String montoTransfer;
    protected String tipoCtaDeposito;
    protected String tipoCtaRetiro;

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
     * Obtiene el valor de la propiedad cuentaDeposito.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCuentaDeposito() {
        return cuentaDeposito;
    }

    /**
     * Define el valor de la propiedad cuentaDeposito.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCuentaDeposito(String value) {
        this.cuentaDeposito = value;
    }

    /**
     * Obtiene el valor de la propiedad cuentaRetiro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCuentaRetiro() {
        return cuentaRetiro;
    }

    /**
     * Define el valor de la propiedad cuentaRetiro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCuentaRetiro(String value) {
        this.cuentaRetiro = value;
    }

    /**
     * Obtiene el valor de la propiedad montoTransfer.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMontoTransfer() {
        return montoTransfer;
    }

    /**
     * Define el valor de la propiedad montoTransfer.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMontoTransfer(String value) {
        this.montoTransfer = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoCtaDeposito.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoCtaDeposito() {
        return tipoCtaDeposito;
    }

    /**
     * Define el valor de la propiedad tipoCtaDeposito.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoCtaDeposito(String value) {
        this.tipoCtaDeposito = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoCtaRetiro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoCtaRetiro() {
        return tipoCtaRetiro;
    }

    /**
     * Define el valor de la propiedad tipoCtaRetiro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoCtaRetiro(String value) {
        this.tipoCtaRetiro = value;
    }

}
