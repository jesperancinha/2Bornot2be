package org.jesperancinha.jtd.jee.app2.soap;

import javax.jws.HandlerChain;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.xml.ws.WebServiceRef;
import java.io.IOException;

@WebServlet("/herbs/ref")
public class KitchenHerbsWebRefServlet implements Servlet {

    /**
     * Injecting the SEI (Service Endpoint Interface)
     */
    @WebServiceRef(KitchenHerbsService.class) // @WebServiceClient
    private KitchenHerbsMessenger kitchenHerbsMessenger;

    @WebServiceRef(wsdlLocation = "META-INF/wsdl/AnyService/Any.wsdl")
    private KitchenHerbsServiceWsdl kitchenHerbsServiceWsdl;

    @WebServiceRef
    public KitchenHerbsServicePure helloMessengerServicePure;

    @WebServiceRef(KitchenHerbsServiceHandlerChain.class)
    @HandlerChain(file="handler-chain.xml")
    private KitchenHerbsMessengerHandlerChain kitchenHerbsMessengerHandlerChain;

    @Override
    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
