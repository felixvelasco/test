
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para JWService_Response complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="JWService_Response">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MSJERROR" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JWService_Response", propOrder = {
    "codigoError",
    "msjerror"
})
@XmlSeeAlso({
    JWServiceMerchListPRResponse2 .class,
    JWServiceMerchantPayResponse2 .class,
    JWServicePagosPendPRResponse2 .class,
    JWServiceUlt5PagosProcPRResponse2 .class,
    JWServiceCtasMerchPRResponse2 .class,
    JWServiceCtasCustPRResponse2 .class
})
public class JWServiceResponse {

    protected String codigoError;
    @XmlElement(name = "MSJERROR")
    protected String msjerror;

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
     * Obtiene el valor de la propiedad msjerror.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSJERROR() {
        return msjerror;
    }

    /**
     * Define el valor de la propiedad msjerror.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSJERROR(String value) {
        this.msjerror = value;
    }

}
