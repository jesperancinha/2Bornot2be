package org.jesperancinha.jtd.jee.portugal.rest.websockets1;

import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;

@ServerEndpoint(value = "/aviz/security/noencoding", encoders = { AvizEncoder.class }, decoders = { AvizDecoder.class })
public class AvizSecurityEndpointNoEncoding {

    @OnOpen
    public void onOpen(Session session, EndpointConfig conf) {
        printBlueGenericTitleLn("");
    }

    @OnMessage
    public void onMessage(Session session, String decodedMessage) throws IOException, EncodeException {
        printOrangeGenericLn(decodedMessage);
        printGreenGenericLn(decodedMessage);
        session.getBasicRemote().sendText(decodedMessage);
    }

}
