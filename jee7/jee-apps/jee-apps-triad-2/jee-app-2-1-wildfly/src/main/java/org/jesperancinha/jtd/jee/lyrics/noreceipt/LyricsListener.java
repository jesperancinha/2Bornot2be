package org.jesperancinha.jtd.jee.lyrics.noreceipt;

import org.jesperancinha.console.consolerizer.Consolerizer;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConColor.ORANGE;

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:/jms/LyricsQueue") })
public class LyricsListener implements MessageListener {
    @Override
    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
                BLUE.printGenericTitleLn("Received a message!");
                ORANGE.printGenericLn(textMessage.getText());
                Consolerizer.printUnicornsLn(100);
            } catch (Exception ex) {
                ex.printStackTrace(System.err);
            }
        }
    }
}