
package org.tempuri;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para JWServiceUlt5PagosProcPR_Response2 complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="JWServiceUlt5PagosProcPR_Response2">
 *   &lt;complexContent>
 *     &lt;extension base="{http://tempuri.org/}JWService_Response">
 *       &lt;sequence>
 *         &lt;element name="ListPayProc" type="{http://tempuri.org/}ArrayOfJWServiceUlt5PagosProcPR_Response_PagoItem" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "JWServiceUlt5PagosProcPR_Response2", propOrder = {
    "listPayProc"
})
public class JWServiceUlt5PagosProcPRResponse2
    extends JWServiceResponse
{

    @XmlElement(name = "ListPayProc")
    protected ArrayOfJWServiceUlt5PagosProcPRResponsePagoItem listPayProc;

    /**
     * Obtiene el valor de la propiedad listPayProc.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfJWServiceUlt5PagosProcPRResponsePagoItem }
     *     
     */
    public ArrayOfJWServiceUlt5PagosProcPRResponsePagoItem getListPayProc() {
        return listPayProc;
    }

    /**
     * Define el valor de la propiedad listPayProc.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfJWServiceUlt5PagosProcPRResponsePagoItem }
     *     
     */
    public void setListPayProc(ArrayOfJWServiceUlt5PagosProcPRResponsePagoItem value) {
        this.listPayProc = value;
    }

}
