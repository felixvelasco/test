
package com.ivrpr.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dataMPV3 complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dataMPV3">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="debCredInd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descMov" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecTranTdc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="importeMovTdc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="refer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataMPV3", propOrder = {
    "debCredInd",
    "descMov",
    "fecTranTdc",
    "importeMovTdc",
    "refer"
})
public class DataMPV3 {

    protected String debCredInd;
    protected String descMov;
    protected String fecTranTdc;
    protected String importeMovTdc;
    protected String refer;

    /**
     * Obtiene el valor de la propiedad debCredInd.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDebCredInd() {
        return debCredInd;
    }

    /**
     * Define el valor de la propiedad debCredInd.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDebCredInd(String value) {
        this.debCredInd = value;
    }

    /**
     * Obtiene el valor de la propiedad descMov.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescMov() {
        return descMov;
    }

    /**
     * Define el valor de la propiedad descMov.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescMov(String value) {
        this.descMov = value;
    }

    /**
     * Obtiene el valor de la propiedad fecTranTdc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecTranTdc() {
        return fecTranTdc;
    }

    /**
     * Define el valor de la propiedad fecTranTdc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecTranTdc(String value) {
        this.fecTranTdc = value;
    }

    /**
     * Obtiene el valor de la propiedad importeMovTdc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImporteMovTdc() {
        return importeMovTdc;
    }

    /**
     * Define el valor de la propiedad importeMovTdc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImporteMovTdc(String value) {
        this.importeMovTdc = value;
    }

    /**
     * Obtiene el valor de la propiedad refer.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRefer() {
        return refer;
    }

    /**
     * Define el valor de la propiedad refer.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRefer(String value) {
        this.refer = value;
    }

}
