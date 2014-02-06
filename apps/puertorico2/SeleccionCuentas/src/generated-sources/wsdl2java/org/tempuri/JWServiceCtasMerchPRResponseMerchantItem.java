
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para JWServiceCtasMerchPR_Response_MerchantItem complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="JWServiceCtasMerchPR_Response_MerchantItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idMerchantCta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="merchantCta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JWServiceCtasMerchPR_Response_MerchantItem", propOrder = {
    "idMerchantCta",
    "merchantCta"
})
public class JWServiceCtasMerchPRResponseMerchantItem {

    protected String idMerchantCta;
    protected String merchantCta;

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
     * Obtiene el valor de la propiedad merchantCta.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantCta() {
        return merchantCta;
    }

    /**
     * Define el valor de la propiedad merchantCta.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantCta(String value) {
        this.merchantCta = value;
    }

}
