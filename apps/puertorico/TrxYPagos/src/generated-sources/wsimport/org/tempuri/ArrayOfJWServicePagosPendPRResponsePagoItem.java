
package org.tempuri;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfJWServicePagosPendPR_Response_PagoItem complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJWServicePagosPendPR_Response_PagoItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="JWServicePagosPendPR_Response_PagoItem" type="{http://tempuri.org/}JWServicePagosPendPR_Response_PagoItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJWServicePagosPendPR_Response_PagoItem", propOrder = {
    "jwServicePagosPendPRResponsePagoItem"
})
public class ArrayOfJWServicePagosPendPRResponsePagoItem {

    @XmlElement(name = "JWServicePagosPendPR_Response_PagoItem", nillable = true)
    protected List<JWServicePagosPendPRResponsePagoItem> jwServicePagosPendPRResponsePagoItem;

    /**
     * Gets the value of the jwServicePagosPendPRResponsePagoItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the jwServicePagosPendPRResponsePagoItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJWServicePagosPendPRResponsePagoItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JWServicePagosPendPRResponsePagoItem }
     * 
     * 
     */
    public List<JWServicePagosPendPRResponsePagoItem> getJWServicePagosPendPRResponsePagoItem() {
        if (jwServicePagosPendPRResponsePagoItem == null) {
            jwServicePagosPendPRResponsePagoItem = new ArrayList<JWServicePagosPendPRResponsePagoItem>();
        }
        return this.jwServicePagosPendPRResponsePagoItem;
    }

}
