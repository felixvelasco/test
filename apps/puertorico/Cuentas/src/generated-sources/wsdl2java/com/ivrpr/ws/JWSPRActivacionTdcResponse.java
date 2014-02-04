
package com.ivrpr.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para JWSPRActivacionTdcResponse complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="JWSPRActivacionTdcResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://ws.ivrpr.com/}jwsprActivacionTdcResponse2" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JWSPRActivacionTdcResponse", propOrder = {
    "_return"
})
public class JWSPRActivacionTdcResponse {

    @XmlElement(name = "return")
    protected JwsprActivacionTdcResponse2 _return;

    /**
     * Obtiene el valor de la propiedad return.
     * 
     * @return
     *     possible object is
     *     {@link JwsprActivacionTdcResponse2 }
     *     
     */
    public JwsprActivacionTdcResponse2 getReturn() {
        return _return;
    }

    /**
     * Define el valor de la propiedad return.
     * 
     * @param value
     *     allowed object is
     *     {@link JwsprActivacionTdcResponse2 }
     *     
     */
    public void setReturn(JwsprActivacionTdcResponse2 value) {
        this._return = value;
    }

}
