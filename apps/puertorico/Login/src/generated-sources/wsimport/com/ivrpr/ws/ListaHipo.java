
package com.ivrpr.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para listaHipo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="listaHipo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fecVenceHipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="hipoNum" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="montoProxPagoHipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="origMontoHipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="proxFecPagoHipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="saldoHipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listaHipo", propOrder = {
    "fecVenceHipo",
    "hipoNum",
    "montoProxPagoHipo",
    "origMontoHipo",
    "proxFecPagoHipo",
    "saldoHipo"
})
public class ListaHipo {

    protected String fecVenceHipo;
    protected String hipoNum;
    protected String montoProxPagoHipo;
    protected String origMontoHipo;
    protected String proxFecPagoHipo;
    protected String saldoHipo;

    /**
     * Obtiene el valor de la propiedad fecVenceHipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecVenceHipo() {
        return fecVenceHipo;
    }

    /**
     * Define el valor de la propiedad fecVenceHipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecVenceHipo(String value) {
        this.fecVenceHipo = value;
    }

    /**
     * Obtiene el valor de la propiedad hipoNum.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHipoNum() {
        return hipoNum;
    }

    /**
     * Define el valor de la propiedad hipoNum.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHipoNum(String value) {
        this.hipoNum = value;
    }

    /**
     * Obtiene el valor de la propiedad montoProxPagoHipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMontoProxPagoHipo() {
        return montoProxPagoHipo;
    }

    /**
     * Define el valor de la propiedad montoProxPagoHipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMontoProxPagoHipo(String value) {
        this.montoProxPagoHipo = value;
    }

    /**
     * Obtiene el valor de la propiedad origMontoHipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigMontoHipo() {
        return origMontoHipo;
    }

    /**
     * Define el valor de la propiedad origMontoHipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigMontoHipo(String value) {
        this.origMontoHipo = value;
    }

    /**
     * Obtiene el valor de la propiedad proxFecPagoHipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProxFecPagoHipo() {
        return proxFecPagoHipo;
    }

    /**
     * Define el valor de la propiedad proxFecPagoHipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProxFecPagoHipo(String value) {
        this.proxFecPagoHipo = value;
    }

    /**
     * Obtiene el valor de la propiedad saldoHipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaldoHipo() {
        return saldoHipo;
    }

    /**
     * Define el valor de la propiedad saldoHipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaldoHipo(String value) {
        this.saldoHipo = value;
    }

}
