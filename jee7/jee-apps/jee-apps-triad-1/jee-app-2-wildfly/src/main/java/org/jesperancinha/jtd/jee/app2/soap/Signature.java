package org.jesperancinha.jtd.jee.app2.soap;

import org.jesperancinha.console.consolerizer.Consolerizer;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Collections;
import java.util.Set;

import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;

public class Signature implements SOAPHandler<SOAPMessageContext> {
    @Override
    public Set<QName> getHeaders() {
        return Collections.emptySet();
    }

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        try {
            final SOAPMessage message = context.getMessage();
            final SOAPBody body = message.getSOAPBody();
            final String localName = body.getFirstChild()
                    .getLocalName();
            Consolerizer.setupFastDefault();
            printOrangeGenericLn("This is the body -> %s", body);
            printOrangeGenericLn("And this is the first node name -> %s", localName);
            return true;
        } catch (SOAPException e) {
            return false;
        }
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return true;
    }

    @Override
    public void close(MessageContext context) {

    }
}
