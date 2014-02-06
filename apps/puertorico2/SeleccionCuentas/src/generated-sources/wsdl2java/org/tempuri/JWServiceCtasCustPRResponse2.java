
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para JWServiceCtasCustPR_Response2 complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="JWServiceCtasCustPR_Response2">
 *   &lt;complexContent>
 *     &lt;extension base="{http://tempuri.org/}JWService_Response">
 *       &lt;sequence>
 *         &lt;element name="CuentasL" type="{http://tempuri.org/}ArrayOfJWServiceCtasCustPR_Response_CtaItem" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JWServiceCtasCustPR_Response2", propOrder = {
    "cuentasL"
})
public class JWServiceCtasCustPRResponse2
    extends JWServiceResponse
{

    @XmlElement(name = "CuentasL")
    protected ArrayOfJWServiceCtasCustPRResponseCtaItem cuentasL;

    /**
     * Obtiene el valor de la propiedad cuentasL.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJWServiceCtasCustPRResponseCtaItem }
     *     
     */
    public ArrayOfJWServiceCtasCustPRResponseCtaItem getCuentasL() {
        return cuentasL;
    }

    /**
     * Define el valor de la propiedad cuentasL.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJWServiceCtasCustPRResponseCtaItem }
     *     
     */
    public void setCuentasL(ArrayOfJWServiceCtasCustPRResponseCtaItem value) {
        this.cuentasL = value;
    }

}
