package org.jesperancinha.jtd.jee.mastery2.client;

import org.jboss.logmanager.handlers.SocketHandler;

import javax.websocket.CloseReason;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


/**
 * ws://www.example.com/api/destination;
 */
public class WebSocketClient {

    /**
     *
     * @param object
     * @param address
     * @throws URISyntaxException
     * @throws IOException
     * @throws DeploymentException
     */
    public void send(Object object, String address) throws URISyntaxException, IOException, DeploymentException {
        URI uri = new URI(address);
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        Session session = container.connectToServer(new SocketHandler(), uri);
        RemoteEndpoint.Async remote = session.getAsyncRemote();
        remote.sendObject(object);
        session.close(new CloseReason(CloseReason.CloseCodes.NORMAL_CLOSURE, "Closing Session"));
    }
}
