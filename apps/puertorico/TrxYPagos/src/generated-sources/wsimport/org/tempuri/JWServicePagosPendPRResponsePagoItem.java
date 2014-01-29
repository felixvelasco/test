
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para JWServicePagosPendPR_Response_PagoItem complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="JWServicePagosPendPR_Response_PagoItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numConfirmacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statusPago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="merchantId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="montoPay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FechPay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="VRUNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JWServicePagosPendPR_Response_PagoItem", propOrder = {
    "numConfirmacion",
    "statusPago",
    "merchantId",
    "montoPay",
    "fechPay",
    "vruNumber"
})
public class JWServicePagosPendPRResponsePagoItem {

    protected String numConfirmacion;
    protected String statusPago;
    protected String merchantId;
    protected String montoPay;
    @XmlElement(name = "FechPay")
    protected String fechPay;
    @XmlElement(name = "VRUNumber")
    protected String vruNumber;

    /**
     * Obtiene el valor de la propiedad numConfirmacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumConfirmacion() {
        return numConfirmacion;
    }

    /**
     * Define el valor de la propiedad numConfirmacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumConfirmacion(String value) {
        this.numConfirmacion = value;
    }

    /**
     * Obtiene el valor de la propiedad statusPago.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusPago() {
        return statusPago;
    }

    /**
     * Define el valor de la propiedad statusPago.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusPago(String value) {
        this.statusPago = value;
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
     * Obtiene el valor de la propiedad fechPay.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechPay() {
        return fechPay;
    }

    /**
     * Define el valor de la propiedad fechPay.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechPay(String value) {
        this.fechPay = value;
    }

    /**
     * Obtiene el valor de la propiedad vruNumber.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVRUNumber() {
        return vruNumber;
    }

    /**
     * Define el valor de la propiedad vruNumber.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVRUNumber(String value) {
        this.vruNumber = value;
    }

}
