
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
 *         &lt;element name="JWServiceCtasMerchPRResult" type="{http://tempuri.org/}JWServiceCtasMerchPR_Response2" minOccurs="0"/>
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
    "jwServiceCtasMerchPRResult"
})
@XmlRootElement(name = "JWServiceCtasMerchPRResponse")
public class JWServiceCtasMerchPRResponse {

    @XmlElement(name = "JWServiceCtasMerchPRResult")
    protected JWServiceCtasMerchPRResponse2 jwServiceCtasMerchPRResult;

    /**
     * Obtiene el valor de la propiedad jwServiceCtasMerchPRResult.
     * 
     * @return
     *     possible object is
     *     {@link JWServiceCtasMerchPRResponse2 }
     *     
     */
    public JWServiceCtasMerchPRResponse2 getJWServiceCtasMerchPRResult() {
        return jwServiceCtasMerchPRResult;
    }

    /**
     * Define el valor de la propiedad jwServiceCtasMerchPRResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JWServiceCtasMerchPRResponse2 }
     *     
     */
    public void setJWServiceCtasMerchPRResult(JWServiceCtasMerchPRResponse2 value) {
        this.jwServiceCtasMerchPRResult = value;
    }

}
