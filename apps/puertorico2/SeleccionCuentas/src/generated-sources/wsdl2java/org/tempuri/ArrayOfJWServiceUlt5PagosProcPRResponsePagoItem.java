
package org.tempuri;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ArrayOfJWServiceUlt5PagosProcPR_Response_PagoItem complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfJWServiceUlt5PagosProcPR_Response_PagoItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="JWServiceUlt5PagosProcPR_Response_PagoItem" type="{http://tempuri.org/}JWServiceUlt5PagosProcPR_Response_PagoItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfJWServiceUlt5PagosProcPR_Response_PagoItem", propOrder = {
    "jwServiceUlt5PagosProcPRResponsePagoItem"
})
public class ArrayOfJWServiceUlt5PagosProcPRResponsePagoItem {

    @XmlElement(name = "JWServiceUlt5PagosProcPR_Response_PagoItem", nillable = true)
    protected List<JWServiceUlt5PagosProcPRResponsePagoItem> jwServiceUlt5PagosProcPRResponsePagoItem;

    /**
     * Gets the value of the jwServiceUlt5PagosProcPRResponsePagoItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the jwServiceUlt5PagosProcPRResponsePagoItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJWServiceUlt5PagosProcPRResponsePagoItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JWServiceUlt5PagosProcPRResponsePagoItem }
     * 
     * 
     */
    public List<JWServiceUlt5PagosProcPRResponsePagoItem> getJWServiceUlt5PagosProcPRResponsePagoItem() {
        if (jwServiceUlt5PagosProcPRResponsePagoItem == null) {
            jwServiceUlt5PagosProcPRResponsePagoItem = new ArrayList<JWServiceUlt5PagosProcPRResponsePagoItem>();
        }
        return this.jwServiceUlt5PagosProcPRResponsePagoItem;
    }

}
