
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
 *         &lt;element name="JWServiceCtasCustPRResult" type="{http://tempuri.org/}JWServiceCtasCustPR_Response2" minOccurs="0"/>
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
    "jwServiceCtasCustPRResult"
})
@XmlRootElement(name = "JWServiceCtasCustPRResponse")
public class JWServiceCtasCustPRResponse {

    @XmlElement(name = "JWServiceCtasCustPRResult")
    protected JWServiceCtasCustPRResponse2 jwServiceCtasCustPRResult;

    /**
     * Obtiene el valor de la propiedad jwServiceCtasCustPRResult.
     * 
     * @return
     *     possible object is
     *     {@link JWServiceCtasCustPRResponse2 }
     *     
     */
    public JWServiceCtasCustPRResponse2 getJWServiceCtasCustPRResult() {
        return jwServiceCtasCustPRResult;
    }

    /**
     * Define el valor de la propiedad jwServiceCtasCustPRResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JWServiceCtasCustPRResponse2 }
     *     
     */
    public void setJWServiceCtasCustPRResult(JWServiceCtasCustPRResponse2 value) {
        this.jwServiceCtasCustPRResult = value;
    }

}
