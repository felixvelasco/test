
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para JWServiceMerchantPay_Response2 complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="JWServiceMerchantPay_Response2">
 *   &lt;complexContent>
 *     &lt;extension base="{http://tempuri.org/}JWService_Response">
 *       &lt;sequence>
 *         &lt;element name="numConfirmacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JWServiceMerchantPay_Response2", propOrder = {
    "numConfirmacion"
})
public class JWServiceMerchantPayResponse2
    extends JWServiceResponse
{

    protected String numConfirmacion;

    /**
     * Obtiene el valor de la propiedad numConfirmacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumConfirmacion() {
        return numConfirmacion;
    }

    /**
     * Define el valor de la propiedad numConfirmacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumConfirmacion(String value) {
        this.numConfirmacion = value;
    }

}
