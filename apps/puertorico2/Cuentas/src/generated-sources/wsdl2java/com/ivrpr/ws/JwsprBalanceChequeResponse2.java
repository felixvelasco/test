
package com.ivrpr.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para jwsprBalanceChequeResponse2 complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="jwsprBalanceChequeResponse2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="listaCheques" type="{http://ws.ivrpr.com/}listaCheques" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="listaDepositos" type="{http://ws.ivrpr.com/}listaDepositos" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="listaRetiros" type="{http://ws.ivrpr.com/}listaRetiros" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="msjError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="saldoContable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="saldoDisponible" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="saldoLineaReserva" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="seqCheques" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="seqDepositos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="seqRetiros" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statusCtaCheques" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jwsprBalanceChequeResponse2", propOrder = {
    "codigoError",
    "listaCheques",
    "listaDepositos",
    "listaRetiros",
    "msjError",
    "saldoContable",
    "saldoDisponible",
    "saldoLineaReserva",
    "seqCheques",
    "seqDepositos",
    "seqRetiros",
    "statusCtaCheques"
})
public class JwsprBalanceChequeResponse2 {

    protected String codigoError;
    @XmlElement(nillable = true)
    protected List<ListaCheques> listaCheques;
    @XmlElement(nillable = true)
    protected List<ListaDepositos> listaDepositos;
    @XmlElement(nillable = true)
    protected List<ListaRetiros> listaRetiros;
    protected String msjError;
    protected String saldoContable;
    protected String saldoDisponible;
    protected String saldoLineaReserva;
    protected String seqCheques;
    protected String seqDepositos;
    protected String seqRetiros;
    protected String statusCtaCheques;

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
     * Gets the value of the listaCheques property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaCheques property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaCheques().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ListaCheques }
     * 
     * 
     */
    public List<ListaCheques> getListaCheques() {
        if (listaCheques == null) {
            listaCheques = new ArrayList<ListaCheques>();
        }
        return this.listaCheques;
    }

    /**
     * Gets the value of the listaDepositos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaDepositos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaDepositos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ListaDepositos }
     * 
     * 
     */
    public List<ListaDepositos> getListaDepositos() {
        if (listaDepositos == null) {
            listaDepositos = new ArrayList<ListaDepositos>();
        }
        return this.listaDepositos;
    }

    /**
     * Gets the value of the listaRetiros property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaRetiros property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaRetiros().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ListaRetiros }
     * 
     * 
     */
    public List<ListaRetiros> getListaRetiros() {
        if (listaRetiros == null) {
            listaRetiros = new ArrayList<ListaRetiros>();
        }
        return this.listaRetiros;
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
     * Obtiene el valor de la propiedad saldoContable.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaldoContable() {
        return saldoContable;
    }

    /**
     * Define el valor de la propiedad saldoContable.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaldoContable(String value) {
        this.saldoContable = value;
    }

    /**
     * Obtiene el valor de la propiedad saldoDisponible.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaldoDisponible() {
        return saldoDisponible;
    }

    /**
     * Define el valor de la propiedad saldoDisponible.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaldoDisponible(String value) {
        this.saldoDisponible = value;
    }

    /**
     * Obtiene el valor de la propiedad saldoLineaReserva.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaldoLineaReserva() {
        return saldoLineaReserva;
    }

    /**
     * Define el valor de la propiedad saldoLineaReserva.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaldoLineaReserva(String value) {
        this.saldoLineaReserva = value;
    }

    /**
     * Obtiene el valor de la propiedad seqCheques.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeqCheques() {
        return seqCheques;
    }

    /**
     * Define el valor de la propiedad seqCheques.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeqCheques(String value) {
        this.seqCheques = value;
    }

    /**
     * Obtiene el valor de la propiedad seqDepositos.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeqDepositos() {
        return seqDepositos;
    }

    /**
     * Define el valor de la propiedad seqDepositos.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeqDepositos(String value) {
        this.seqDepositos = value;
    }

    /**
     * Obtiene el valor de la propiedad seqRetiros.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeqRetiros() {
        return seqRetiros;
    }

    /**
     * Define el valor de la propiedad seqRetiros.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeqRetiros(String value) {
        this.seqRetiros = value;
    }

    /**
     * Obtiene el valor de la propiedad statusCtaCheques.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusCtaCheques() {
        return statusCtaCheques;
    }

    /**
     * Define el valor de la propiedad statusCtaCheques.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusCtaCheques(String value) {
        this.statusCtaCheques = value;
    }

}
