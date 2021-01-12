package org.jesperancinha.jtd.jee.portugal.rest.websockets1;

import javax.websocket.CloseReason;
import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.List;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;

@ServerEndpoint("/aviz")
public class AvizEndPoint {

    private static final List<String> KINGS_OF_AVIZ = List.of("João I", "Duarte I", "Afonso V", "João II", "Manuel I",
        "João III", "Sebastião I", "Henrique I", "António I");


    @OnMessage
    public void onMessage(Session session, String message) throws IOException {
        printBlueGenericTitleLn("OnMessage from %s called!", this.getClass()
            .getCanonicalName());
        session.getBasicRemote()
            .sendText(message);
        for (Session sess : session.getOpenSessions()) {
            if (sess.isOpen())
                sess.getBasicRemote()
                    .sendText(message);
        }
    }

    @OnOpen
    public void onOpen(Session session, EndpointConfig conf) throws IOException, EncodeException {
        printBlueGenericTitleLn("OnOpen from %s called!", this.getClass()
            .getCanonicalName());
        session.getBasicRemote()
            .sendText("Welcome to the house of Aviz!");
        session.getBasicRemote()
            .sendText("The kings are:");
        session.getBasicRemote()
            .sendObject(KINGS_OF_AVIZ.toString());
        printGreenGenericLn(KINGS_OF_AVIZ);
        printGreenGenericLn("from: http://www.devdoc.net/javaxe/JavaEE-7u2/docs/javaee-tutorial/doc/websocket001.htm");
        printGreenGenericLn("GET /path/to/websocket/endpoint HTTP/1.1\n" + "Host: localhost\n" + "Upgrade: websocket\n"
            + "Connection: Upgrade\n" + "Sec-WebSocket-Key: xqBt3ImNzJbYqRINxEFlkg==\n" + "Origin: http://localhost\n"
            + "Sec-WebSocket-Version: 13");
    }

    @OnError
    public void onError(Session session, Throwable error) {
        printBlueGenericTitleLn("onError from %s called!", this.getClass()
            .getCanonicalName());
    }

    @OnClose
    public void onClose(Session session, CloseReason reason) throws IOException {
        printBlueGenericTitleLn("onClose from %s called!", this.getClass()
            .getCanonicalName());
        session.getBasicRemote().sendText("Connection closed!");
        session.getBasicRemote().sendText(reason.getReasonPhrase());
    }

}
