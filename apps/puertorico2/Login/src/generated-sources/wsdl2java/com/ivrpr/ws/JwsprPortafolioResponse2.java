
package com.ivrpr.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para jwsprPortafolioResponse2 complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="jwsprPortafolioResponse2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="clientName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="listaCuentas" type="{http://ws.ivrpr.com/}listaCuentas" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="listaHipo" type="{http://ws.ivrpr.com/}listaHipo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="listaTdc" type="{http://ws.ivrpr.com/}listaTdc" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="msjError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jwsprPortafolioResponse2", propOrder = {
    "clientName",
    "codigoError",
    "listaCuentas",
    "listaHipo",
    "listaTdc",
    "msjError"
})
public class JwsprPortafolioResponse2 {

    protected String clientName;
    protected String codigoError;
    @XmlElement(nillable = true)
    protected List<ListaCuentas> listaCuentas;
    @XmlElement(nillable = true)
    protected List<ListaHipo> listaHipo;
    @XmlElement(nillable = true)
    protected List<ListaTdc> listaTdc;
    protected String msjError;

    /**
     * Obtiene el valor de la propiedad clientName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * Define el valor de la propiedad clientName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientName(String value) {
        this.clientName = value;
    }

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
     * Gets the value of the listaCuentas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaCuentas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaCuentas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ListaCuentas }
     * 
     * 
     */
    public List<ListaCuentas> getListaCuentas() {
        if (listaCuentas == null) {
            listaCuentas = new ArrayList<ListaCuentas>();
        }
        return this.listaCuentas;
    }

    /**
     * Gets the value of the listaHipo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaHipo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaHipo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ListaHipo }
     * 
     * 
     */
    public List<ListaHipo> getListaHipo() {
        if (listaHipo == null) {
            listaHipo = new ArrayList<ListaHipo>();
        }
        return this.listaHipo;
    }

    /**
     * Gets the value of the listaTdc property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaTdc property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaTdc().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ListaTdc }
     * 
     * 
     */
    public List<ListaTdc> getListaTdc() {
        if (listaTdc == null) {
            listaTdc = new ArrayList<ListaTdc>();
        }
        return this.listaTdc;
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

}
