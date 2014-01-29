
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para JWServiceCtasCustPR_Response_CtaItem complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="JWServiceCtasCustPR_Response_CtaItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="numCuenta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="IdCuenta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoProduct" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FecProcPay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JWServiceCtasCustPR_Response_CtaItem", propOrder = {
    "numCuenta",
    "idCuenta",
    "tipoProduct",
    "fecProcPay"
})
public class JWServiceCtasCustPRResponseCtaItem {

    protected String numCuenta;
    @XmlElement(name = "IdCuenta")
    protected String idCuenta;
    protected String tipoProduct;
    @XmlElement(name = "FecProcPay")
    protected String fecProcPay;

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
     * Obtiene el valor de la propiedad idCuenta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdCuenta() {
        return idCuenta;
    }

    /**
     * Define el valor de la propiedad idCuenta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdCuenta(String value) {
        this.idCuenta = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoProduct.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoProduct() {
        return tipoProduct;
    }

    /**
     * Define el valor de la propiedad tipoProduct.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoProduct(String value) {
        this.tipoProduct = value;
    }

    /**
     * Obtiene el valor de la propiedad fecProcPay.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecProcPay() {
        return fecProcPay;
    }

    /**
     * Define el valor de la propiedad fecProcPay.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecProcPay(String value) {
        this.fecProcPay = value;
    }

}
