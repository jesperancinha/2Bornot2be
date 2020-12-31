package org.jesperancinha.jtd.jee.app2.soap;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceFeature;
import java.net.URL;

public class KitchenHerbsService extends Service {
    protected KitchenHerbsService(URL wsdlDocumentLocation, QName serviceName) {
        super(wsdlDocumentLocation, serviceName);
    }

    protected KitchenHerbsService(URL wsdlDocumentLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlDocumentLocation, serviceName, features);
    }
}
