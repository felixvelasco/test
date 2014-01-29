
package org.tempuri;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfJWServiceCtasMerchPR_Response_MerchantItem complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJWServiceCtasMerchPR_Response_MerchantItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="JWServiceCtasMerchPR_Response_MerchantItem" type="{http://tempuri.org/}JWServiceCtasMerchPR_Response_MerchantItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJWServiceCtasMerchPR_Response_MerchantItem", propOrder = {
    "jwServiceCtasMerchPRResponseMerchantItem"
})
public class ArrayOfJWServiceCtasMerchPRResponseMerchantItem {

    @XmlElement(name = "JWServiceCtasMerchPR_Response_MerchantItem", nillable = true)
    protected List<JWServiceCtasMerchPRResponseMerchantItem> jwServiceCtasMerchPRResponseMerchantItem;

    /**
     * Gets the value of the jwServiceCtasMerchPRResponseMerchantItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the jwServiceCtasMerchPRResponseMerchantItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJWServiceCtasMerchPRResponseMerchantItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JWServiceCtasMerchPRResponseMerchantItem }
     * 
     * 
     */
    public List<JWServiceCtasMerchPRResponseMerchantItem> getJWServiceCtasMerchPRResponseMerchantItem() {
        if (jwServiceCtasMerchPRResponseMerchantItem == null) {
            jwServiceCtasMerchPRResponseMerchantItem = new ArrayList<JWServiceCtasMerchPRResponseMerchantItem>();
        }
        return this.jwServiceCtasMerchPRResponseMerchantItem;
    }

}
