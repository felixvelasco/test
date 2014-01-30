
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
 *         &lt;element name="JWServiceMerchListPRResult" type="{http://tempuri.org/}JWServiceMerchListPR_Response2" minOccurs="0"/>
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
    "jwServiceMerchListPRResult"
})
@XmlRootElement(name = "JWServiceMerchListPRResponse")
public class JWServiceMerchListPRResponse {

    @XmlElement(name = "JWServiceMerchListPRResult")
    protected JWServiceMerchListPRResponse2 jwServiceMerchListPRResult;

    /**
     * Obtiene el valor de la propiedad jwServiceMerchListPRResult.
     * 
     * @return
     *     possible object is
     *     {@link JWServiceMerchListPRResponse2 }
     *     
     */
    public JWServiceMerchListPRResponse2 getJWServiceMerchListPRResult() {
        return jwServiceMerchListPRResult;
    }

    /**
     * Define el valor de la propiedad jwServiceMerchListPRResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JWServiceMerchListPRResponse2 }
     *     
     */
    public void setJWServiceMerchListPRResult(JWServiceMerchListPRResponse2 value) {
        this.jwServiceMerchListPRResult = value;
    }

}
