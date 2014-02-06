
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
 *         &lt;element name="JWServiceUlt5PagosProcPRResult" type="{http://tempuri.org/}JWServiceUlt5PagosProcPR_Response2" minOccurs="0"/>
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
    "jwServiceUlt5PagosProcPRResult"
})
@XmlRootElement(name = "JWServiceUlt5PagosProcPRResponse")
public class JWServiceUlt5PagosProcPRResponse {

    @XmlElement(name = "JWServiceUlt5PagosProcPRResult")
    protected JWServiceUlt5PagosProcPRResponse2 jwServiceUlt5PagosProcPRResult;

    /**
     * Obtiene el valor de la propiedad jwServiceUlt5PagosProcPRResult.
     * 
     * @return
     *     possible object is
     *     {@link JWServiceUlt5PagosProcPRResponse2 }
     *     
     */
    public JWServiceUlt5PagosProcPRResponse2 getJWServiceUlt5PagosProcPRResult() {
        return jwServiceUlt5PagosProcPRResult;
    }

    /**
     * Define el valor de la propiedad jwServiceUlt5PagosProcPRResult.
     * 
     * @param value
     *     allowed object is
     *     {@link JWServiceUlt5PagosProcPRResponse2 }
     *     
     */
    public void setJWServiceUlt5PagosProcPRResult(JWServiceUlt5PagosProcPRResponse2 value) {
        this.jwServiceUlt5PagosProcPRResult = value;
    }

}
