
package com.ivrpr.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para listaTdc complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="listaTdc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="descTipoTdc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pecoden" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pecodof" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pecodpr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pecodsu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="penumco" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoTdc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listaTdc", propOrder = {
    "descTipoTdc",
    "pan",
    "pecoden",
    "pecodof",
    "pecodpr",
    "pecodsu",
    "penumco",
    "tipoTdc"
})
public class ListaTdc {

    protected String descTipoTdc;
    protected String pan;
    protected String pecoden;
    protected String pecodof;
    protected String pecodpr;
    protected String pecodsu;
    protected String penumco;
    protected String tipoTdc;

    /**
     * Obtiene el valor de la propiedad descTipoTdc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescTipoTdc() {
        return descTipoTdc;
    }

    /**
     * Define el valor de la propiedad descTipoTdc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescTipoTdc(String value) {
        this.descTipoTdc = value;
    }

    /**
     * Obtiene el valor de la propiedad pan.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPan() {
        return pan;
    }

    /**
     * Define el valor de la propiedad pan.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPan(String value) {
        this.pan = value;
    }

    /**
     * Obtiene el valor de la propiedad pecoden.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPecoden() {
        return pecoden;
    }

    /**
     * Define el valor de la propiedad pecoden.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPecoden(String value) {
        this.pecoden = value;
    }

    /**
     * Obtiene el valor de la propiedad pecodof.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPecodof() {
        return pecodof;
    }

    /**
     * Define el valor de la propiedad pecodof.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPecodof(String value) {
        this.pecodof = value;
    }

    /**
     * Obtiene el valor de la propiedad pecodpr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPecodpr() {
        return pecodpr;
    }

    /**
     * Define el valor de la propiedad pecodpr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPecodpr(String value) {
        this.pecodpr = value;
    }

    /**
     * Obtiene el valor de la propiedad pecodsu.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPecodsu() {
        return pecodsu;
    }

    /**
     * Define el valor de la propiedad pecodsu.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPecodsu(String value) {
        this.pecodsu = value;
    }

    /**
     * Obtiene el valor de la propiedad penumco.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPenumco() {
        return penumco;
    }

    /**
     * Define el valor de la propiedad penumco.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPenumco(String value) {
        this.penumco = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoTdc.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoTdc() {
        return tipoTdc;
    }

    /**
     * Define el valor de la propiedad tipoTdc.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoTdc(String value) {
        this.tipoTdc = value;
    }

}
