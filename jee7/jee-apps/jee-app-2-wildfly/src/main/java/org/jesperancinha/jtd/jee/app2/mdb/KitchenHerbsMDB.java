package org.jesperancinha.jtd.jee.app2.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedThrowableAndExit;
import static org.jesperancinha.console.consolerizer.Consolerizer.setupFastDefault;

@MessageDriven(activationConfig = {

    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destination", propertyValue = "jboss/activemq/queue/TestQueue")

}, messageListenerInterface = MessageListener.class)
public class KitchenHerbsMDB implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            setupFastDefault();
            printBrightMagentaGenericLn("We've got this message -> %s", message);
            if (message instanceof TextMessage) {
                printBrightMagentaGenericLn("More specifically: %s", ((TextMessage) message).getText());
            }

        } catch (JMSException e) {
            printRedThrowableAndExit(e);
        }

    }

}