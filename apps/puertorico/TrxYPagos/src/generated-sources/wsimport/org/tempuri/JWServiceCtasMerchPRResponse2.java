
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para JWServiceCtasMerchPR_Response2 complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="JWServiceCtasMerchPR_Response2">
 *   &lt;complexContent>
 *     &lt;extension base="{http://tempuri.org/}JWService_Response">
 *       &lt;sequence>
 *         &lt;element name="merchantCtaL" type="{http://tempuri.org/}ArrayOfJWServiceCtasMerchPR_Response_MerchantItem" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JWServiceCtasMerchPR_Response2", propOrder = {
    "merchantCtaL"
})
public class JWServiceCtasMerchPRResponse2
    extends JWServiceResponse
{

    protected ArrayOfJWServiceCtasMerchPRResponseMerchantItem merchantCtaL;

    /**
     * Obtiene el valor de la propiedad merchantCtaL.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJWServiceCtasMerchPRResponseMerchantItem }
     *     
     */
    public ArrayOfJWServiceCtasMerchPRResponseMerchantItem getMerchantCtaL() {
        return merchantCtaL;
    }

    /**
     * Define el valor de la propiedad merchantCtaL.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJWServiceCtasMerchPRResponseMerchantItem }
     *     
     */
    public void setMerchantCtaL(ArrayOfJWServiceCtasMerchPRResponseMerchantItem value) {
        this.merchantCtaL = value;
    }

}
