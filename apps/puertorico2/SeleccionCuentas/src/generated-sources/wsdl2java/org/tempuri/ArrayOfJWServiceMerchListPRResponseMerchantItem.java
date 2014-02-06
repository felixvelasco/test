
package org.tempuri;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfJWServiceMerchListPR_Response_MerchantItem complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJWServiceMerchListPR_Response_MerchantItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="JWServiceMerchListPR_Response_MerchantItem" type="{http://tempuri.org/}JWServiceMerchListPR_Response_MerchantItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJWServiceMerchListPR_Response_MerchantItem", propOrder = {
    "jwServiceMerchListPRResponseMerchantItem"
})
public class ArrayOfJWServiceMerchListPRResponseMerchantItem {

    @XmlElement(name = "JWServiceMerchListPR_Response_MerchantItem", nillable = true)
    protected List<JWServiceMerchListPRResponseMerchantItem> jwServiceMerchListPRResponseMerchantItem;

    /**
     * Gets the value of the jwServiceMerchListPRResponseMerchantItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the jwServiceMerchListPRResponseMerchantItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJWServiceMerchListPRResponseMerchantItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JWServiceMerchListPRResponseMerchantItem }
     * 
     * 
     */
    public List<JWServiceMerchListPRResponseMerchantItem> getJWServiceMerchListPRResponseMerchantItem() {
        if (jwServiceMerchListPRResponseMerchantItem == null) {
            jwServiceMerchListPRResponseMerchantItem = new ArrayList<JWServiceMerchListPRResponseMerchantItem>();
        }
        return this.jwServiceMerchListPRResponseMerchantItem;
    }

}
