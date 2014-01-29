
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para JWServiceMerchListPR_Response2 complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="JWServiceMerchListPR_Response2">
 *   &lt;complexContent>
 *     &lt;extension base="{http://tempuri.org/}JWService_Response">
 *       &lt;sequence>
 *         &lt;element name="customerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="MerchantL" type="{http://tempuri.org/}ArrayOfJWServiceMerchListPR_Response_MerchantItem" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JWServiceMerchListPR_Response2", propOrder = {
    "customerId",
    "merchantL"
})
public class JWServiceMerchListPRResponse2
    extends JWServiceResponse
{

    protected String customerId;
    @XmlElement(name = "MerchantL")
    protected ArrayOfJWServiceMerchListPRResponseMerchantItem merchantL;

    /**
     * Obtiene el valor de la propiedad customerId.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Define el valor de la propiedad customerId.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerId(String value) {
        this.customerId = value;
    }

    /**
     * Obtiene el valor de la propiedad merchantL.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJWServiceMerchListPRResponseMerchantItem }
     *     
     */
    public ArrayOfJWServiceMerchListPRResponseMerchantItem getMerchantL() {
        return merchantL;
    }

    /**
     * Define el valor de la propiedad merchantL.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJWServiceMerchListPRResponseMerchantItem }
     *     
     */
    public void setMerchantL(ArrayOfJWServiceMerchListPRResponseMerchantItem value) {
        this.merchantL = value;
    }

}
