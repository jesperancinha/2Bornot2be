package org.jesperancinha.jtd.jee.app2.mdb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {

    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),

    @ActivationConfigProperty(propertyName = "destination", propertyValue = "activemq/queue/TestQueue") },
    messageListenerInterface = MessageListener.class)

public class KitchenHerbsMDB implements CustomMessageListener {

    @Override
    public void onMessage(Message message) {

        try {

            if (message instanceof TextMessage) {

                System.out.println("Got Message "

                    + ((TextMessage) message).getText());

            }

        } catch (JMSException e) {

            e.printStackTrace();

        }

    }

}