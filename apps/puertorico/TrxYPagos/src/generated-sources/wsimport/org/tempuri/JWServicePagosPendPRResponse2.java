
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para JWServicePagosPendPR_Response2 complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="JWServicePagosPendPR_Response2">
 *   &lt;complexContent>
 *     &lt;extension base="{http://tempuri.org/}JWService_Response">
 *       &lt;sequence>
 *         &lt;element name="ListPayPend" type="{http://tempuri.org/}ArrayOfJWServicePagosPendPR_Response_PagoItem" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JWServicePagosPendPR_Response2", propOrder = {
    "listPayPend"
})
public class JWServicePagosPendPRResponse2
    extends JWServiceResponse
{

    @XmlElement(name = "ListPayPend")
    protected ArrayOfJWServicePagosPendPRResponsePagoItem listPayPend;

    /**
     * Obtiene el valor de la propiedad listPayPend.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJWServicePagosPendPRResponsePagoItem }
     *     
     */
    public ArrayOfJWServicePagosPendPRResponsePagoItem getListPayPend() {
        return listPayPend;
    }

    /**
     * Define el valor de la propiedad listPayPend.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJWServicePagosPendPRResponsePagoItem }
     *     
     */
    public void setListPayPend(ArrayOfJWServicePagosPendPRResponsePagoItem value) {
        this.listPayPend = value;
    }

}
