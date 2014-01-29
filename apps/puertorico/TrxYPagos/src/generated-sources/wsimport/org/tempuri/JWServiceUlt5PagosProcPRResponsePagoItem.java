
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para JWServiceUlt5PagosProcPR_Response_PagoItem complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="JWServiceUlt5PagosProcPR_Response_PagoItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numConfirmacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="merchantId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="montoPay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FechProcPay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "JWServiceUlt5PagosProcPR_Response_PagoItem", propOrder = {
    "numConfirmacion",
    "merchantId",
    "montoPay",
    "fechProcPay",
    "vruNumber"
})
public class JWServiceUlt5PagosProcPRResponsePagoItem {

    protected String numConfirmacion;
    protected String merchantId;
    protected String montoPay;
    @XmlElement(name = "FechProcPay")
    protected String fechProcPay;
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
