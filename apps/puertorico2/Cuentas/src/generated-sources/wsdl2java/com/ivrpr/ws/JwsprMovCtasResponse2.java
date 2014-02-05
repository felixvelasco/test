
package com.ivrpr.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para jwsprMovCtasResponse2 complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="jwsprMovCtasResponse2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="contSeq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="listaMovs" type="{http://ws.ivrpr.com/}jwsprMovCtasMovimientos" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="movDevueltos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "jwsprMovCtasResponse2", propOrder = {
    "codigoError",
    "contSeq",
    "listaMovs",
    "movDevueltos",
    "msjError"
})
public class JwsprMovCtasResponse2 {

    protected String codigoError;
    protected String contSeq;
    @XmlElement(nillable = true)
    protected List<JwsprMovCtasMovimientos> listaMovs;
    protected String movDevueltos;
    protected String msjError;

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
     * Obtiene el valor de la propiedad contSeq.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContSeq() {
        return contSeq;
    }

    /**
     * Define el valor de la propiedad contSeq.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContSeq(String value) {
        this.contSeq = value;
    }

    /**
     * Gets the value of the listaMovs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaMovs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaMovs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JwsprMovCtasMovimientos }
     * 
     * 
     */
    public List<JwsprMovCtasMovimientos> getListaMovs() {
        if (listaMovs == null) {
            listaMovs = new ArrayList<JwsprMovCtasMovimientos>();
        }
        return this.listaMovs;
    }

    /**
     * Obtiene el valor de la propiedad movDevueltos.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMovDevueltos() {
        return movDevueltos;
    }

    /**
     * Define el valor de la propiedad movDevueltos.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMovDevueltos(String value) {
        this.movDevueltos = value;
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
