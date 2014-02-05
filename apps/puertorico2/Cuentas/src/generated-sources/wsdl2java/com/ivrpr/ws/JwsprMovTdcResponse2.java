
package com.ivrpr.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para jwsprMovTdcResponse2 complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="jwsprMovTdcResponse2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="destipt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idMovSal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="listMovs" type="{http://ws.ivrpr.com/}dataMPV3" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="msjError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="panTdc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jwsprMovTdcResponse2", propOrder = {
    "codigoError",
    "destipt",
    "idMovSal",
    "listMovs",
    "msjError",
    "panTdc"
})
public class JwsprMovTdcResponse2 {

    protected String codigoError;
    protected String destipt;
    protected String idMovSal;
    @XmlElement(nillable = true)
    protected List<DataMPV3> listMovs;
    protected String msjError;
    protected String panTdc;

    /**
     * Obtiene el valor de la propiedad codigoError.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoError() {
        return codigoError;
    }

    /**
     * Define el valor de la propiedad codigoError.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoError(String value) {
        this.codigoError = value;
    }

    /**
     * Obtiene el valor de la propiedad destipt.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestipt() {
        return destipt;
    }

    /**
     * Define el valor de la propiedad destipt.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestipt(String value) {
        this.destipt = value;
    }

    /**
     * Obtiene el valor de la propiedad idMovSal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdMovSal() {
        return idMovSal;
    }

    /**
     * Define el valor de la propiedad idMovSal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdMovSal(String value) {
        this.idMovSal = value;
    }

    /**
     * Gets the value of the listMovs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listMovs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListMovs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataMPV3 }
     * 
     * 
     */
    public List<DataMPV3> getListMovs() {
        if (listMovs == null) {
            listMovs = new ArrayList<DataMPV3>();
        }
        return this.listMovs;
    }

    /**
     * Obtiene el valor de la propiedad msjError.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsjError() {
        return msjError;
    }

    /**
     * Define el valor de la propiedad msjError.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsjError(String value) {
        this.msjError = value;
    }

    /**
     * Obtiene el valor de la propiedad panTdc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPanTdc() {
        return panTdc;
    }

    /**
     * Define el valor de la propiedad panTdc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPanTdc(String value) {
        this.panTdc = value;
    }

}
