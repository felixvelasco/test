
package com.ivrpr.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para jwsprBalanceAhorroResponse2 complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="jwsprBalanceAhorroResponse2">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codigoError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecIntAcred" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="listaDepositos" type="{http://ws.ivrpr.com/}jwsprBalanceAhorroDeposito" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="listaRetiros" type="{http://ws.ivrpr.com/}jwsprBalanceAhorroRetiros" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="montoIntAcred" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="msjError" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="saldoContable" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="saldoDisponible" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="seqDepositos" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="seqRetiros" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statusCtaAhorro" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jwsprBalanceAhorroResponse2", propOrder = {
    "codigoError",
    "fecIntAcred",
    "listaDepositos",
    "listaRetiros",
    "montoIntAcred",
    "msjError",
    "saldoContable",
    "saldoDisponible",
    "seqDepositos",
    "seqRetiros",
    "statusCtaAhorro"
})
public class JwsprBalanceAhorroResponse2 {

    protected String codigoError;
    protected String fecIntAcred;
    @XmlElement(nillable = true)
    protected List<JwsprBalanceAhorroDeposito> listaDepositos;
    @XmlElement(nillable = true)
    protected List<JwsprBalanceAhorroRetiros> listaRetiros;
    protected String montoIntAcred;
    protected String msjError;
    protected String saldoContable;
    protected String saldoDisponible;
    protected String seqDepositos;
    protected String seqRetiros;
    protected String statusCtaAhorro;

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
     * Obtiene el valor de la propiedad fecIntAcred.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFecIntAcred() {
        return fecIntAcred;
    }

    /**
     * Define el valor de la propiedad fecIntAcred.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFecIntAcred(String value) {
        this.fecIntAcred = value;
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
     * {@link JwsprBalanceAhorroDeposito }
     * 
     * 
     */
    public List<JwsprBalanceAhorroDeposito> getListaDepositos() {
        if (listaDepositos == null) {
            listaDepositos = new ArrayList<JwsprBalanceAhorroDeposito>();
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
     * {@link JwsprBalanceAhorroRetiros }
     * 
     * 
     */
    public List<JwsprBalanceAhorroRetiros> getListaRetiros() {
        if (listaRetiros == null) {
            listaRetiros = new ArrayList<JwsprBalanceAhorroRetiros>();
        }
        return this.listaRetiros;
    }

    /**
     * Obtiene el valor de la propiedad montoIntAcred.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMontoIntAcred() {
        return montoIntAcred;
    }

    /**
     * Define el valor de la propiedad montoIntAcred.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMontoIntAcred(String value) {
        this.montoIntAcred = value;
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
     * Obtiene el valor de la propiedad statusCtaAhorro.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusCtaAhorro() {
        return statusCtaAhorro;
    }

    /**
     * Define el valor de la propiedad statusCtaAhorro.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusCtaAhorro(String value) {
        this.statusCtaAhorro = value;
    }

}
