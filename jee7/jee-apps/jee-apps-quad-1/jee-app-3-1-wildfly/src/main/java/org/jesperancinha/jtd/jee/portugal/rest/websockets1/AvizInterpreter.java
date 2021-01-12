package org.jesperancinha.jtd.jee.portugal.rest.websockets1;

import javax.websocket.OnMessage;
import javax.websocket.PongMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.nio.ByteBuffer;

import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowTitleLn;

@ServerEndpoint("/aviz/interpreter")
public class AvizInterpreter {

    @OnMessage
    public void textMessage(Session session, String msg) {
        printRainbowTitleLn("Text: %s" + msg);
    }

    @OnMessage
    public void binaryMessage(Session session, ByteBuffer msg) {
        printRainbowTitleLn("Binary: %s" + msg.toString());
    }

    @OnMessage
    public void pongMessage(Session session, PongMessage msg) {
        printRainbowTitleLn("Pong: %s" + msg.getApplicationData()
            .toString());
    }
}