
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
 *         &lt;element name="JWServicePagosPendPRResult" type="{http://tempuri.org/}JWServicePagosPendPR_Response2" minOccurs="0"/>
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
    "jwServicePagosPendPRResult"
})
@XmlRootElement(name = "JWServicePagosPendPRResponse")
public class JWServicePagosPendPRResponse {

    @XmlElement(name = "JWServicePagosPendPRResult")
    protected JWServicePagosPendPRResponse2 jwServicePagosPendPRResult;

    /**
     * Obtiene el valor de la propiedad jwServicePagosPendPRResult.
     * 
     * @return
     *     possible object is
     *     {@link JWServicePagosPendPRResponse2 }
     *     
     */
    public JWServicePagosPendPRResponse2 getJWServicePagosPendPRResult() {
        return jwServicePagosPendPRResult;
    }

    /**
     * Define el valor de la propiedad jwServicePagosPendPRResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JWServicePagosPendPRResponse2 }
     *     
     */
    public void setJWServicePagosPendPRResult(JWServicePagosPendPRResponse2 value) {
        this.jwServicePagosPendPRResult = value;
    }

}
