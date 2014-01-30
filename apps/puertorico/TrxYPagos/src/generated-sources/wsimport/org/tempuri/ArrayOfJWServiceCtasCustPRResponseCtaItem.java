
package org.tempuri;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfJWServiceCtasCustPR_Response_CtaItem complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJWServiceCtasCustPR_Response_CtaItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="JWServiceCtasCustPR_Response_CtaItem" type="{http://tempuri.org/}JWServiceCtasCustPR_Response_CtaItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJWServiceCtasCustPR_Response_CtaItem", propOrder = {
    "jwServiceCtasCustPRResponseCtaItem"
})
public class ArrayOfJWServiceCtasCustPRResponseCtaItem {

    @XmlElement(name = "JWServiceCtasCustPR_Response_CtaItem", nillable = true)
    protected List<JWServiceCtasCustPRResponseCtaItem> jwServiceCtasCustPRResponseCtaItem;

    /**
     * Gets the value of the jwServiceCtasCustPRResponseCtaItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the jwServiceCtasCustPRResponseCtaItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJWServiceCtasCustPRResponseCtaItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JWServiceCtasCustPRResponseCtaItem }
     * 
     * 
     */
    public List<JWServiceCtasCustPRResponseCtaItem> getJWServiceCtasCustPRResponseCtaItem() {
        if (jwServiceCtasCustPRResponseCtaItem == null) {
            jwServiceCtasCustPRResponseCtaItem = new ArrayList<JWServiceCtasCustPRResponseCtaItem>();
        }
        return this.jwServiceCtasCustPRResponseCtaItem;
    }

}
