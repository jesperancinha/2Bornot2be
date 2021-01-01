package org.jesperancinha.jtd.jee.app2.soap;

import org.jesperancinha.jtd.jee.soap.HelloWorldServerImplService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/herbs/ref")
public class KitchenHerbsWebRefServlet extends HttpServlet {

    /**
     * Injecting the SEI (Service Endpoint Interface)
     */
//    @WebServiceRef(KitchenHerbsService.class) // @WebServiceClient
//    private KitchenHerbsMessenger kitchenHerbsMessenger;

//    @WebServiceRef(wsdlLocation = "META-INF/wsdl/KitchenHerbsService/hello.wsdl")
//    private KitchenHerbsServiceWsdl kitchenHerbsServiceWsdl;

//    @WebServiceRef
//    public KitchenHerbsServicePure helloMessengerServicePure;
//
//    @WebServiceRef(KitchenHerbsServiceHandlerChain.class)
//    @HandlerChain(file="handler-chain.xml")
//    private KitchenHerbsMessengerHandlerChain kitchenHerbsMessengerHandlerChain;

    @WebServiceRef(wsdlLocation = "http://localhost:8080/jee-app-2-wildfly-ws-1.0-SNAPSHOT/HelloService?wsdl")
    private HelloWorldServerImplService helloWorldServerImplService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            out.println("<html lang=\"en\">");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet at " + request.getContextPath() + "</h1>");
            out.println("<p>" + sayHello("world") + "</p>");
            out.println("</body>");
            out.println("</html>");

        } finally {
            out.close();
        }
    }

    private String sayHello(String name) {
        return helloWorldServerImplService.getHelloPort().sayHelloWorld(name);
    }
}
