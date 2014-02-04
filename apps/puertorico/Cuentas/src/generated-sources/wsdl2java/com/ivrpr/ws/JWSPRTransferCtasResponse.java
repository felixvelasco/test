
package com.ivrpr.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para JWSPRTransferCtasResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="JWSPRTransferCtasResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://ws.ivrpr.com/}jwsprTransferCtaResponse2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JWSPRTransferCtasResponse", propOrder = {
    "_return"
})
public class JWSPRTransferCtasResponse {

    @XmlElement(name = "return")
    protected JwsprTransferCtaResponse2 _return;

    /**
     * Obtiene el valor de la propiedad return.
     * 
     * @return
     *     possible object is
     *     {@link JwsprTransferCtaResponse2 }
     *     
     */
    public JwsprTransferCtaResponse2 getReturn() {
        return _return;
    }

    /**
     * Define el valor de la propiedad return.
     * 
     * @param value
     *     allowed object is
     *     {@link JwsprTransferCtaResponse2 }
     *     
     */
    public void setReturn(JwsprTransferCtaResponse2 value) {
        this._return = value;
    }

}
