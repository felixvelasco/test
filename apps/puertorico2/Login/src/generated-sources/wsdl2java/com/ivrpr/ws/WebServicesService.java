package com.ivrpr.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.8
 * 2014-02-04T18:30:09.577+01:00
 * Generated source version: 2.7.8
 * 
 */
@WebServiceClient(name = "WebServicesService", 
                  wsdlLocation = "http://localhost/wsdl/WebServicesService.wsdl",
                  targetNamespace = "http://ws.ivrpr.com/") 
public class WebServicesService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://ws.ivrpr.com/", "WebServicesService");
    public final static QName WebServicesPort = new QName("http://ws.ivrpr.com/", "WebServicesPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost/wsdl/WebServicesService.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(WebServicesService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost/wsdl/WebServicesService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public WebServicesService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public WebServicesService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WebServicesService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public WebServicesService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public WebServicesService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public WebServicesService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns WebServices
     */
    @WebEndpoint(name = "WebServicesPort")
    public WebServices getWebServicesPort() {
        return super.getPort(WebServicesPort, WebServices.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WebServices
     */
    @WebEndpoint(name = "WebServicesPort")
    public WebServices getWebServicesPort(WebServiceFeature... features) {
        return super.getPort(WebServicesPort, WebServices.class, features);
    }

}
