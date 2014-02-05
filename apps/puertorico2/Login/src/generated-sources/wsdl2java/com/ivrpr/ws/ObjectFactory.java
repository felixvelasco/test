
package com.ivrpr.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.ivrpr.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _JWSPRCtasIRA_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRCtasIRA");
    private final static QName _JWSPRLineaReserva_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRLineaReserva");
    private final static QName _JWSPRLineaReservaResponse_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRLineaReservaResponse");
    private final static QName _JWSPRTarjetaCredito_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRTarjetaCredito");
    private final static QName _JWSPRActivacionTdcResponse_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRActivacionTdcResponse");
    private final static QName _JWSPRSuspendeChequesResponse_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRSuspendeChequesResponse");
    private final static QName _JWSPRCertDepositosResponse_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRCertDepositosResponse");
    private final static QName _JWSPRCambioNip_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRCambioNip");
    private final static QName _JWServiceAutentica_QNAME = new QName("http://ws.ivrpr.com/", "JWServiceAutentica");
    private final static QName _JWSPRSuspendeCheques_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRSuspendeCheques");
    private final static QName _JWSPRActivacionTdc_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRActivacionTdc");
    private final static QName _JWServiceAutenticaResponse_QNAME = new QName("http://ws.ivrpr.com/", "JWServiceAutenticaResponse");
    private final static QName _JWSPRCertDepositos_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRCertDepositos");
    private final static QName _JWSPRTransferCtas_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRTransferCtas");
    private final static QName _JWSPRMovTdc_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRMovTdc");
    private final static QName _JWSPRTransferCtasResponse_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRTransferCtasResponse");
    private final static QName _JWSPRPagoTdc_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRPagoTdc");
    private final static QName _JWSPRBalancePrestamo_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRBalancePrestamo");
    private final static QName _JWServiceSegmento_QNAME = new QName("http://ws.ivrpr.com/", "JWServiceSegmento");
    private final static QName _JWSPRPortafolioResponse_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRPortafolioResponse");
    private final static QName _JWServiceSegmentoResponse_QNAME = new QName("http://ws.ivrpr.com/", "JWServiceSegmentoResponse");
    private final static QName _JWSPRChequePagadoResponse_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRChequePagadoResponse");
    private final static QName _JWSPRMovTdcResponse_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRMovTdcResponse");
    private final static QName _JWSPRMovCtasResponse_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRMovCtasResponse");
    private final static QName _JWSPRPagoTdcResponse_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRPagoTdcResponse");
    private final static QName _JWSPRTarjetaCreditoResponse_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRTarjetaCreditoResponse");
    private final static QName _JWSPRChequePagado_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRChequePagado");
    private final static QName _JWSPRBalanceAhorroResponse_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRBalanceAhorroResponse");
    private final static QName _JWSPRBalanceChequeResponse_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRBalanceChequeResponse");
    private final static QName _JWSPRCtasIRAResponse_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRCtasIRAResponse");
    private final static QName _JWServiceSPF_QNAME = new QName("http://ws.ivrpr.com/", "JWServiceSPF");
    private final static QName _JWSPRBalanceCheque_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRBalanceCheque");
    private final static QName _JWServiceSPFResponse_QNAME = new QName("http://ws.ivrpr.com/", "JWServiceSPFResponse");
    private final static QName _JWSPRBalanceAhorro_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRBalanceAhorro");
    private final static QName _JWSPRMovCtas_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRMovCtas");
    private final static QName _JWSPRCambioNipResponse_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRCambioNipResponse");
    private final static QName _JWSPRPortafolio_QNAME = new QName("http://ws.ivrpr.com/", "JWSPRPortafolio");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.ivrpr.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JWSPRTarjetaCreditoResponse }
     * 
     */
    public JWSPRTarjetaCreditoResponse createJWSPRTarjetaCreditoResponse() {
        return new JWSPRTarjetaCreditoResponse();
    }

    /**
     * Create an instance of {@link JWSPRPagoTdcResponse }
     * 
     */
    public JWSPRPagoTdcResponse createJWSPRPagoTdcResponse() {
        return new JWSPRPagoTdcResponse();
    }

    /**
     * Create an instance of {@link JWSPRChequePagado }
     * 
     */
    public JWSPRChequePagado createJWSPRChequePagado() {
        return new JWSPRChequePagado();
    }

    /**
     * Create an instance of {@link JWSPRBalanceCheque }
     * 
     */
    public JWSPRBalanceCheque createJWSPRBalanceCheque() {
        return new JWSPRBalanceCheque();
    }

    /**
     * Create an instance of {@link JWServiceSPF }
     * 
     */
    public JWServiceSPF createJWServiceSPF() {
        return new JWServiceSPF();
    }

    /**
     * Create an instance of {@link JWSPRCtasIRAResponse }
     * 
     */
    public JWSPRCtasIRAResponse createJWSPRCtasIRAResponse() {
        return new JWSPRCtasIRAResponse();
    }

    /**
     * Create an instance of {@link JWSPRBalanceChequeResponse }
     * 
     */
    public JWSPRBalanceChequeResponse createJWSPRBalanceChequeResponse() {
        return new JWSPRBalanceChequeResponse();
    }

    /**
     * Create an instance of {@link JWSPRBalanceAhorroResponse }
     * 
     */
    public JWSPRBalanceAhorroResponse createJWSPRBalanceAhorroResponse() {
        return new JWSPRBalanceAhorroResponse();
    }

    /**
     * Create an instance of {@link JWSPRPortafolio }
     * 
     */
    public JWSPRPortafolio createJWSPRPortafolio() {
        return new JWSPRPortafolio();
    }

    /**
     * Create an instance of {@link JWSPRCambioNipResponse }
     * 
     */
    public JWSPRCambioNipResponse createJWSPRCambioNipResponse() {
        return new JWSPRCambioNipResponse();
    }

    /**
     * Create an instance of {@link JWSPRMovCtas }
     * 
     */
    public JWSPRMovCtas createJWSPRMovCtas() {
        return new JWSPRMovCtas();
    }

    /**
     * Create an instance of {@link JWSPRBalanceAhorro }
     * 
     */
    public JWSPRBalanceAhorro createJWSPRBalanceAhorro() {
        return new JWSPRBalanceAhorro();
    }

    /**
     * Create an instance of {@link JWServiceSPFResponse }
     * 
     */
    public JWServiceSPFResponse createJWServiceSPFResponse() {
        return new JWServiceSPFResponse();
    }

    /**
     * Create an instance of {@link JWSPRSuspendeChequesResponse }
     * 
     */
    public JWSPRSuspendeChequesResponse createJWSPRSuspendeChequesResponse() {
        return new JWSPRSuspendeChequesResponse();
    }

    /**
     * Create an instance of {@link JWSPRCertDepositosResponse }
     * 
     */
    public JWSPRCertDepositosResponse createJWSPRCertDepositosResponse() {
        return new JWSPRCertDepositosResponse();
    }

    /**
     * Create an instance of {@link JWSPRTarjetaCredito }
     * 
     */
    public JWSPRTarjetaCredito createJWSPRTarjetaCredito() {
        return new JWSPRTarjetaCredito();
    }

    /**
     * Create an instance of {@link JWSPRActivacionTdcResponse }
     * 
     */
    public JWSPRActivacionTdcResponse createJWSPRActivacionTdcResponse() {
        return new JWSPRActivacionTdcResponse();
    }

    /**
     * Create an instance of {@link JWSPRLineaReserva }
     * 
     */
    public JWSPRLineaReserva createJWSPRLineaReserva() {
        return new JWSPRLineaReserva();
    }

    /**
     * Create an instance of {@link JWSPRLineaReservaResponse }
     * 
     */
    public JWSPRLineaReservaResponse createJWSPRLineaReservaResponse() {
        return new JWSPRLineaReservaResponse();
    }

    /**
     * Create an instance of {@link JWSPRCtasIRA }
     * 
     */
    public JWSPRCtasIRA createJWSPRCtasIRA() {
        return new JWSPRCtasIRA();
    }

    /**
     * Create an instance of {@link JWServiceAutenticaResponse }
     * 
     */
    public JWServiceAutenticaResponse createJWServiceAutenticaResponse() {
        return new JWServiceAutenticaResponse();
    }

    /**
     * Create an instance of {@link JWSPRActivacionTdc }
     * 
     */
    public JWSPRActivacionTdc createJWSPRActivacionTdc() {
        return new JWSPRActivacionTdc();
    }

    /**
     * Create an instance of {@link JWSPRSuspendeCheques }
     * 
     */
    public JWSPRSuspendeCheques createJWSPRSuspendeCheques() {
        return new JWSPRSuspendeCheques();
    }

    /**
     * Create an instance of {@link JWServiceAutentica }
     * 
     */
    public JWServiceAutentica createJWServiceAutentica() {
        return new JWServiceAutentica();
    }

    /**
     * Create an instance of {@link JWSPRCambioNip }
     * 
     */
    public JWSPRCambioNip createJWSPRCambioNip() {
        return new JWSPRCambioNip();
    }

    /**
     * Create an instance of {@link JWSPRBalancePrestamo }
     * 
     */
    public JWSPRBalancePrestamo createJWSPRBalancePrestamo() {
        return new JWSPRBalancePrestamo();
    }

    /**
     * Create an instance of {@link JWSPRPagoTdc }
     * 
     */
    public JWSPRPagoTdc createJWSPRPagoTdc() {
        return new JWSPRPagoTdc();
    }

    /**
     * Create an instance of {@link JWSPRTransferCtasResponse }
     * 
     */
    public JWSPRTransferCtasResponse createJWSPRTransferCtasResponse() {
        return new JWSPRTransferCtasResponse();
    }

    /**
     * Create an instance of {@link JWSPRMovTdc }
     * 
     */
    public JWSPRMovTdc createJWSPRMovTdc() {
        return new JWSPRMovTdc();
    }

    /**
     * Create an instance of {@link JWSPRTransferCtas }
     * 
     */
    public JWSPRTransferCtas createJWSPRTransferCtas() {
        return new JWSPRTransferCtas();
    }

    /**
     * Create an instance of {@link JWSPRCertDepositos }
     * 
     */
    public JWSPRCertDepositos createJWSPRCertDepositos() {
        return new JWSPRCertDepositos();
    }

    /**
     * Create an instance of {@link JWSPRMovCtasResponse }
     * 
     */
    public JWSPRMovCtasResponse createJWSPRMovCtasResponse() {
        return new JWSPRMovCtasResponse();
    }

    /**
     * Create an instance of {@link JWSPRMovTdcResponse }
     * 
     */
    public JWSPRMovTdcResponse createJWSPRMovTdcResponse() {
        return new JWSPRMovTdcResponse();
    }

    /**
     * Create an instance of {@link JWSPRChequePagadoResponse }
     * 
     */
    public JWSPRChequePagadoResponse createJWSPRChequePagadoResponse() {
        return new JWSPRChequePagadoResponse();
    }

    /**
     * Create an instance of {@link JWServiceSegmentoResponse }
     * 
     */
    public JWServiceSegmentoResponse createJWServiceSegmentoResponse() {
        return new JWServiceSegmentoResponse();
    }

    /**
     * Create an instance of {@link JWSPRPortafolioResponse }
     * 
     */
    public JWSPRPortafolioResponse createJWSPRPortafolioResponse() {
        return new JWSPRPortafolioResponse();
    }

    /**
     * Create an instance of {@link JWServiceSegmento }
     * 
     */
    public JWServiceSegmento createJWServiceSegmento() {
        return new JWServiceSegmento();
    }

    /**
     * Create an instance of {@link JwsprMovCtasRequest }
     * 
     */
    public JwsprMovCtasRequest createJwsprMovCtasRequest() {
        return new JwsprMovCtasRequest();
    }

    /**
     * Create an instance of {@link ListaTdc }
     * 
     */
    public ListaTdc createListaTdc() {
        return new ListaTdc();
    }

    /**
     * Create an instance of {@link JwsprSuspendeChequesResponse2 }
     * 
     */
    public JwsprSuspendeChequesResponse2 createJwsprSuspendeChequesResponse2() {
        return new JwsprSuspendeChequesResponse2();
    }

    /**
     * Create an instance of {@link JwsprMovCtasResponse2 }
     * 
     */
    public JwsprMovCtasResponse2 createJwsprMovCtasResponse2() {
        return new JwsprMovCtasResponse2();
    }

    /**
     * Create an instance of {@link JwsprCambioNipResponse2 }
     * 
     */
    public JwsprCambioNipResponse2 createJwsprCambioNipResponse2() {
        return new JwsprCambioNipResponse2();
    }

    /**
     * Create an instance of {@link JwsprBalanceChequeRequest }
     * 
     */
    public JwsprBalanceChequeRequest createJwsprBalanceChequeRequest() {
        return new JwsprBalanceChequeRequest();
    }

    /**
     * Create an instance of {@link JwsprTarjetaCreditoResponse2 }
     * 
     */
    public JwsprTarjetaCreditoResponse2 createJwsprTarjetaCreditoResponse2() {
        return new JwsprTarjetaCreditoResponse2();
    }

    /**
     * Create an instance of {@link JwsprChequePagadoResponse2 }
     * 
     */
    public JwsprChequePagadoResponse2 createJwsprChequePagadoResponse2() {
        return new JwsprChequePagadoResponse2();
    }

    /**
     * Create an instance of {@link JwServiceSPFRequest }
     * 
     */
    public JwServiceSPFRequest createJwServiceSPFRequest() {
        return new JwServiceSPFRequest();
    }

    /**
     * Create an instance of {@link JwsprMovTdcRequest }
     * 
     */
    public JwsprMovTdcRequest createJwsprMovTdcRequest() {
        return new JwsprMovTdcRequest();
    }

    /**
     * Create an instance of {@link JwServiceSegmentoResponse2 }
     * 
     */
    public JwServiceSegmentoResponse2 createJwServiceSegmentoResponse2() {
        return new JwServiceSegmentoResponse2();
    }

    /**
     * Create an instance of {@link JwsprBalancePrestamoRequest }
     * 
     */
    public JwsprBalancePrestamoRequest createJwsprBalancePrestamoRequest() {
        return new JwsprBalancePrestamoRequest();
    }

    /**
     * Create an instance of {@link JwsprCtasIRARequest }
     * 
     */
    public JwsprCtasIRARequest createJwsprCtasIRARequest() {
        return new JwsprCtasIRARequest();
    }

    /**
     * Create an instance of {@link JwsprBalanceAhorroResponse2 }
     * 
     */
    public JwsprBalanceAhorroResponse2 createJwsprBalanceAhorroResponse2() {
        return new JwsprBalanceAhorroResponse2();
    }

    /**
     * Create an instance of {@link JwsprCambioNipRequest }
     * 
     */
    public JwsprCambioNipRequest createJwsprCambioNipRequest() {
        return new JwsprCambioNipRequest();
    }

    /**
     * Create an instance of {@link JwServiceAutenticaResponse2 }
     * 
     */
    public JwServiceAutenticaResponse2 createJwServiceAutenticaResponse2() {
        return new JwServiceAutenticaResponse2();
    }

    /**
     * Create an instance of {@link JwServiceAutenticaRequest }
     * 
     */
    public JwServiceAutenticaRequest createJwServiceAutenticaRequest() {
        return new JwServiceAutenticaRequest();
    }

    /**
     * Create an instance of {@link JwsprBalanceAhorroRetiros }
     * 
     */
    public JwsprBalanceAhorroRetiros createJwsprBalanceAhorroRetiros() {
        return new JwsprBalanceAhorroRetiros();
    }

    /**
     * Create an instance of {@link JwsprBalanceChequeResponse2 }
     * 
     */
    public JwsprBalanceChequeResponse2 createJwsprBalanceChequeResponse2() {
        return new JwsprBalanceChequeResponse2();
    }

    /**
     * Create an instance of {@link ListaDepositos }
     * 
     */
    public ListaDepositos createListaDepositos() {
        return new ListaDepositos();
    }

    /**
     * Create an instance of {@link JwsprChequePagadoRequest }
     * 
     */
    public JwsprChequePagadoRequest createJwsprChequePagadoRequest() {
        return new JwsprChequePagadoRequest();
    }

    /**
     * Create an instance of {@link JwsprCertDepositosResponse2 }
     * 
     */
    public JwsprCertDepositosResponse2 createJwsprCertDepositosResponse2() {
        return new JwsprCertDepositosResponse2();
    }

    /**
     * Create an instance of {@link ListaCheques }
     * 
     */
    public ListaCheques createListaCheques() {
        return new ListaCheques();
    }

    /**
     * Create an instance of {@link JwsprBalanceAhorroRequest }
     * 
     */
    public JwsprBalanceAhorroRequest createJwsprBalanceAhorroRequest() {
        return new JwsprBalanceAhorroRequest();
    }

    /**
     * Create an instance of {@link JwsprPagoTdcRequest }
     * 
     */
    public JwsprPagoTdcRequest createJwsprPagoTdcRequest() {
        return new JwsprPagoTdcRequest();
    }

    /**
     * Create an instance of {@link JwsprCtasIRAResponse2 }
     * 
     */
    public JwsprCtasIRAResponse2 createJwsprCtasIRAResponse2() {
        return new JwsprCtasIRAResponse2();
    }

    /**
     * Create an instance of {@link JwsprBalanceAhorroDeposito }
     * 
     */
    public JwsprBalanceAhorroDeposito createJwsprBalanceAhorroDeposito() {
        return new JwsprBalanceAhorroDeposito();
    }

    /**
     * Create an instance of {@link ListaHipo }
     * 
     */
    public ListaHipo createListaHipo() {
        return new ListaHipo();
    }

    /**
     * Create an instance of {@link ListaRetiros }
     * 
     */
    public ListaRetiros createListaRetiros() {
        return new ListaRetiros();
    }

    /**
     * Create an instance of {@link JwsprMovCtasMovimientos }
     * 
     */
    public JwsprMovCtasMovimientos createJwsprMovCtasMovimientos() {
        return new JwsprMovCtasMovimientos();
    }

    /**
     * Create an instance of {@link JwsprPortafolioRequest }
     * 
     */
    public JwsprPortafolioRequest createJwsprPortafolioRequest() {
        return new JwsprPortafolioRequest();
    }

    /**
     * Create an instance of {@link JwsprTransferCtaResponse2 }
     * 
     */
    public JwsprTransferCtaResponse2 createJwsprTransferCtaResponse2() {
        return new JwsprTransferCtaResponse2();
    }

    /**
     * Create an instance of {@link ListaCuentas }
     * 
     */
    public ListaCuentas createListaCuentas() {
        return new ListaCuentas();
    }

    /**
     * Create an instance of {@link JwsprActivacionTdcResponse2 }
     * 
     */
    public JwsprActivacionTdcResponse2 createJwsprActivacionTdcResponse2() {
        return new JwsprActivacionTdcResponse2();
    }

    /**
     * Create an instance of {@link JwsprPortafolioResponse2 }
     * 
     */
    public JwsprPortafolioResponse2 createJwsprPortafolioResponse2() {
        return new JwsprPortafolioResponse2();
    }

    /**
     * Create an instance of {@link JwServiceSegmentoRequest }
     * 
     */
    public JwServiceSegmentoRequest createJwServiceSegmentoRequest() {
        return new JwServiceSegmentoRequest();
    }

    /**
     * Create an instance of {@link JwsprPagoTdcResponse2 }
     * 
     */
    public JwsprPagoTdcResponse2 createJwsprPagoTdcResponse2() {
        return new JwsprPagoTdcResponse2();
    }

    /**
     * Create an instance of {@link JwsprLineaReservaRequest }
     * 
     */
    public JwsprLineaReservaRequest createJwsprLineaReservaRequest() {
        return new JwsprLineaReservaRequest();
    }

    /**
     * Create an instance of {@link JwsprLineaReservaResponse2 }
     * 
     */
    public JwsprLineaReservaResponse2 createJwsprLineaReservaResponse2() {
        return new JwsprLineaReservaResponse2();
    }

    /**
     * Create an instance of {@link JwServiceSPFResponse2 }
     * 
     */
    public JwServiceSPFResponse2 createJwServiceSPFResponse2() {
        return new JwServiceSPFResponse2();
    }

    /**
     * Create an instance of {@link JwsprTarjetaCreditoRequest }
     * 
     */
    public JwsprTarjetaCreditoRequest createJwsprTarjetaCreditoRequest() {
        return new JwsprTarjetaCreditoRequest();
    }

    /**
     * Create an instance of {@link JwsprSuspendeChequesRequest }
     * 
     */
    public JwsprSuspendeChequesRequest createJwsprSuspendeChequesRequest() {
        return new JwsprSuspendeChequesRequest();
    }

    /**
     * Create an instance of {@link JwsprActivacionTdcRequest }
     * 
     */
    public JwsprActivacionTdcRequest createJwsprActivacionTdcRequest() {
        return new JwsprActivacionTdcRequest();
    }

    /**
     * Create an instance of {@link JwsprTransferCtaRequest }
     * 
     */
    public JwsprTransferCtaRequest createJwsprTransferCtaRequest() {
        return new JwsprTransferCtaRequest();
    }

    /**
     * Create an instance of {@link DataMPV3 }
     * 
     */
    public DataMPV3 createDataMPV3() {
        return new DataMPV3();
    }

    /**
     * Create an instance of {@link JwsprMovTdcResponse2 }
     * 
     */
    public JwsprMovTdcResponse2 createJwsprMovTdcResponse2() {
        return new JwsprMovTdcResponse2();
    }

    /**
     * Create an instance of {@link JwsprCertDepositosRequest }
     * 
     */
    public JwsprCertDepositosRequest createJwsprCertDepositosRequest() {
        return new JwsprCertDepositosRequest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRCtasIRA }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRCtasIRA")
    public JAXBElement<JWSPRCtasIRA> createJWSPRCtasIRA(JWSPRCtasIRA value) {
        return new JAXBElement<JWSPRCtasIRA>(_JWSPRCtasIRA_QNAME, JWSPRCtasIRA.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRLineaReserva }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRLineaReserva")
    public JAXBElement<JWSPRLineaReserva> createJWSPRLineaReserva(JWSPRLineaReserva value) {
        return new JAXBElement<JWSPRLineaReserva>(_JWSPRLineaReserva_QNAME, JWSPRLineaReserva.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRLineaReservaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRLineaReservaResponse")
    public JAXBElement<JWSPRLineaReservaResponse> createJWSPRLineaReservaResponse(JWSPRLineaReservaResponse value) {
        return new JAXBElement<JWSPRLineaReservaResponse>(_JWSPRLineaReservaResponse_QNAME, JWSPRLineaReservaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRTarjetaCredito }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRTarjetaCredito")
    public JAXBElement<JWSPRTarjetaCredito> createJWSPRTarjetaCredito(JWSPRTarjetaCredito value) {
        return new JAXBElement<JWSPRTarjetaCredito>(_JWSPRTarjetaCredito_QNAME, JWSPRTarjetaCredito.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRActivacionTdcResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRActivacionTdcResponse")
    public JAXBElement<JWSPRActivacionTdcResponse> createJWSPRActivacionTdcResponse(JWSPRActivacionTdcResponse value) {
        return new JAXBElement<JWSPRActivacionTdcResponse>(_JWSPRActivacionTdcResponse_QNAME, JWSPRActivacionTdcResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRSuspendeChequesResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRSuspendeChequesResponse")
    public JAXBElement<JWSPRSuspendeChequesResponse> createJWSPRSuspendeChequesResponse(JWSPRSuspendeChequesResponse value) {
        return new JAXBElement<JWSPRSuspendeChequesResponse>(_JWSPRSuspendeChequesResponse_QNAME, JWSPRSuspendeChequesResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRCertDepositosResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRCertDepositosResponse")
    public JAXBElement<JWSPRCertDepositosResponse> createJWSPRCertDepositosResponse(JWSPRCertDepositosResponse value) {
        return new JAXBElement<JWSPRCertDepositosResponse>(_JWSPRCertDepositosResponse_QNAME, JWSPRCertDepositosResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRCambioNip }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRCambioNip")
    public JAXBElement<JWSPRCambioNip> createJWSPRCambioNip(JWSPRCambioNip value) {
        return new JAXBElement<JWSPRCambioNip>(_JWSPRCambioNip_QNAME, JWSPRCambioNip.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWServiceAutentica }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWServiceAutentica")
    public JAXBElement<JWServiceAutentica> createJWServiceAutentica(JWServiceAutentica value) {
        return new JAXBElement<JWServiceAutentica>(_JWServiceAutentica_QNAME, JWServiceAutentica.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRSuspendeCheques }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRSuspendeCheques")
    public JAXBElement<JWSPRSuspendeCheques> createJWSPRSuspendeCheques(JWSPRSuspendeCheques value) {
        return new JAXBElement<JWSPRSuspendeCheques>(_JWSPRSuspendeCheques_QNAME, JWSPRSuspendeCheques.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRActivacionTdc }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRActivacionTdc")
    public JAXBElement<JWSPRActivacionTdc> createJWSPRActivacionTdc(JWSPRActivacionTdc value) {
        return new JAXBElement<JWSPRActivacionTdc>(_JWSPRActivacionTdc_QNAME, JWSPRActivacionTdc.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWServiceAutenticaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWServiceAutenticaResponse")
    public JAXBElement<JWServiceAutenticaResponse> createJWServiceAutenticaResponse(JWServiceAutenticaResponse value) {
        return new JAXBElement<JWServiceAutenticaResponse>(_JWServiceAutenticaResponse_QNAME, JWServiceAutenticaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRCertDepositos }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRCertDepositos")
    public JAXBElement<JWSPRCertDepositos> createJWSPRCertDepositos(JWSPRCertDepositos value) {
        return new JAXBElement<JWSPRCertDepositos>(_JWSPRCertDepositos_QNAME, JWSPRCertDepositos.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRTransferCtas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRTransferCtas")
    public JAXBElement<JWSPRTransferCtas> createJWSPRTransferCtas(JWSPRTransferCtas value) {
        return new JAXBElement<JWSPRTransferCtas>(_JWSPRTransferCtas_QNAME, JWSPRTransferCtas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRMovTdc }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRMovTdc")
    public JAXBElement<JWSPRMovTdc> createJWSPRMovTdc(JWSPRMovTdc value) {
        return new JAXBElement<JWSPRMovTdc>(_JWSPRMovTdc_QNAME, JWSPRMovTdc.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRTransferCtasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRTransferCtasResponse")
    public JAXBElement<JWSPRTransferCtasResponse> createJWSPRTransferCtasResponse(JWSPRTransferCtasResponse value) {
        return new JAXBElement<JWSPRTransferCtasResponse>(_JWSPRTransferCtasResponse_QNAME, JWSPRTransferCtasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRPagoTdc }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRPagoTdc")
    public JAXBElement<JWSPRPagoTdc> createJWSPRPagoTdc(JWSPRPagoTdc value) {
        return new JAXBElement<JWSPRPagoTdc>(_JWSPRPagoTdc_QNAME, JWSPRPagoTdc.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRBalancePrestamo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRBalancePrestamo")
    public JAXBElement<JWSPRBalancePrestamo> createJWSPRBalancePrestamo(JWSPRBalancePrestamo value) {
        return new JAXBElement<JWSPRBalancePrestamo>(_JWSPRBalancePrestamo_QNAME, JWSPRBalancePrestamo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWServiceSegmento }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWServiceSegmento")
    public JAXBElement<JWServiceSegmento> createJWServiceSegmento(JWServiceSegmento value) {
        return new JAXBElement<JWServiceSegmento>(_JWServiceSegmento_QNAME, JWServiceSegmento.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRPortafolioResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRPortafolioResponse")
    public JAXBElement<JWSPRPortafolioResponse> createJWSPRPortafolioResponse(JWSPRPortafolioResponse value) {
        return new JAXBElement<JWSPRPortafolioResponse>(_JWSPRPortafolioResponse_QNAME, JWSPRPortafolioResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWServiceSegmentoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWServiceSegmentoResponse")
    public JAXBElement<JWServiceSegmentoResponse> createJWServiceSegmentoResponse(JWServiceSegmentoResponse value) {
        return new JAXBElement<JWServiceSegmentoResponse>(_JWServiceSegmentoResponse_QNAME, JWServiceSegmentoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRChequePagadoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRChequePagadoResponse")
    public JAXBElement<JWSPRChequePagadoResponse> createJWSPRChequePagadoResponse(JWSPRChequePagadoResponse value) {
        return new JAXBElement<JWSPRChequePagadoResponse>(_JWSPRChequePagadoResponse_QNAME, JWSPRChequePagadoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRMovTdcResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRMovTdcResponse")
    public JAXBElement<JWSPRMovTdcResponse> createJWSPRMovTdcResponse(JWSPRMovTdcResponse value) {
        return new JAXBElement<JWSPRMovTdcResponse>(_JWSPRMovTdcResponse_QNAME, JWSPRMovTdcResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRMovCtasResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRMovCtasResponse")
    public JAXBElement<JWSPRMovCtasResponse> createJWSPRMovCtasResponse(JWSPRMovCtasResponse value) {
        return new JAXBElement<JWSPRMovCtasResponse>(_JWSPRMovCtasResponse_QNAME, JWSPRMovCtasResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRPagoTdcResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRPagoTdcResponse")
    public JAXBElement<JWSPRPagoTdcResponse> createJWSPRPagoTdcResponse(JWSPRPagoTdcResponse value) {
        return new JAXBElement<JWSPRPagoTdcResponse>(_JWSPRPagoTdcResponse_QNAME, JWSPRPagoTdcResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRTarjetaCreditoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRTarjetaCreditoResponse")
    public JAXBElement<JWSPRTarjetaCreditoResponse> createJWSPRTarjetaCreditoResponse(JWSPRTarjetaCreditoResponse value) {
        return new JAXBElement<JWSPRTarjetaCreditoResponse>(_JWSPRTarjetaCreditoResponse_QNAME, JWSPRTarjetaCreditoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRChequePagado }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRChequePagado")
    public JAXBElement<JWSPRChequePagado> createJWSPRChequePagado(JWSPRChequePagado value) {
        return new JAXBElement<JWSPRChequePagado>(_JWSPRChequePagado_QNAME, JWSPRChequePagado.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRBalanceAhorroResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRBalanceAhorroResponse")
    public JAXBElement<JWSPRBalanceAhorroResponse> createJWSPRBalanceAhorroResponse(JWSPRBalanceAhorroResponse value) {
        return new JAXBElement<JWSPRBalanceAhorroResponse>(_JWSPRBalanceAhorroResponse_QNAME, JWSPRBalanceAhorroResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRBalanceChequeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRBalanceChequeResponse")
    public JAXBElement<JWSPRBalanceChequeResponse> createJWSPRBalanceChequeResponse(JWSPRBalanceChequeResponse value) {
        return new JAXBElement<JWSPRBalanceChequeResponse>(_JWSPRBalanceChequeResponse_QNAME, JWSPRBalanceChequeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRCtasIRAResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRCtasIRAResponse")
    public JAXBElement<JWSPRCtasIRAResponse> createJWSPRCtasIRAResponse(JWSPRCtasIRAResponse value) {
        return new JAXBElement<JWSPRCtasIRAResponse>(_JWSPRCtasIRAResponse_QNAME, JWSPRCtasIRAResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWServiceSPF }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWServiceSPF")
    public JAXBElement<JWServiceSPF> createJWServiceSPF(JWServiceSPF value) {
        return new JAXBElement<JWServiceSPF>(_JWServiceSPF_QNAME, JWServiceSPF.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRBalanceCheque }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRBalanceCheque")
    public JAXBElement<JWSPRBalanceCheque> createJWSPRBalanceCheque(JWSPRBalanceCheque value) {
        return new JAXBElement<JWSPRBalanceCheque>(_JWSPRBalanceCheque_QNAME, JWSPRBalanceCheque.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWServiceSPFResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWServiceSPFResponse")
    public JAXBElement<JWServiceSPFResponse> createJWServiceSPFResponse(JWServiceSPFResponse value) {
        return new JAXBElement<JWServiceSPFResponse>(_JWServiceSPFResponse_QNAME, JWServiceSPFResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRBalanceAhorro }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRBalanceAhorro")
    public JAXBElement<JWSPRBalanceAhorro> createJWSPRBalanceAhorro(JWSPRBalanceAhorro value) {
        return new JAXBElement<JWSPRBalanceAhorro>(_JWSPRBalanceAhorro_QNAME, JWSPRBalanceAhorro.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRMovCtas }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRMovCtas")
    public JAXBElement<JWSPRMovCtas> createJWSPRMovCtas(JWSPRMovCtas value) {
        return new JAXBElement<JWSPRMovCtas>(_JWSPRMovCtas_QNAME, JWSPRMovCtas.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRCambioNipResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRCambioNipResponse")
    public JAXBElement<JWSPRCambioNipResponse> createJWSPRCambioNipResponse(JWSPRCambioNipResponse value) {
        return new JAXBElement<JWSPRCambioNipResponse>(_JWSPRCambioNipResponse_QNAME, JWSPRCambioNipResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link JWSPRPortafolio }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.ivrpr.com/", name = "JWSPRPortafolio")
    public JAXBElement<JWSPRPortafolio> createJWSPRPortafolio(JWSPRPortafolio value) {
        return new JAXBElement<JWSPRPortafolio>(_JWSPRPortafolio_QNAME, JWSPRPortafolio.class, null, value);
    }

}
