
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="connID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="callID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="customerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numCuenta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="merchantId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idMerchantCta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="montoPay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FechProcPay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "connID",
    "callID",
    "customerId",
    "numCuenta",
    "merchantId",
    "idMerchantCta",
    "montoPay",
    "fechProcPay"
})
@XmlRootElement(name = "JWServiceMerchantPay")
public class JWServiceMerchantPay {

    protected String connID;
    protected String callID;
    protected String customerId;
    protected String numCuenta;
    protected String merchantId;
    protected String idMerchantCta;
    protected String montoPay;
    @XmlElement(name = "FechProcPay")
    protected String fechProcPay;

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
     * Obtiene el valor de la propiedad customerId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Define el valor de la propiedad customerId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerId(String value) {
        this.customerId = value;
    }

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
     * Obtiene el valor de la propiedad merchantId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * Define el valor de la propiedad merchantId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantId(String value) {
        this.merchantId = value;
    }

    /**
     * Obtiene el valor de la propiedad idMerchantCta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdMerchantCta() {
        return idMerchantCta;
    }

    /**
     * Define el valor de la propiedad idMerchantCta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdMerchantCta(String value) {
        this.idMerchantCta = value;
    }

    /**
     * Obtiene el valor de la propiedad montoPay.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMontoPay() {
        return montoPay;
    }

    /**
     * Define el valor de la propiedad montoPay.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMontoPay(String value) {
        this.montoPay = value;
    }

    /**
     * Obtiene el valor de la propiedad fechProcPay.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechProcPay() {
        return fechProcPay;
    }

    /**
     * Define el valor de la propiedad fechProcPay.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechProcPay(String value) {
        this.fechProcPay = value;
    }

}
