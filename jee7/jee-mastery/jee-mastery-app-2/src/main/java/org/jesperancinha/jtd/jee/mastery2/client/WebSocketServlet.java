package org.jesperancinha.jtd.jee.mastery2.client;

import org.jesperancinha.jtd.jee.mastery2.sockets.Lyric;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.DeploymentException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BRIGHT_CYAN;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.MAGENTA;

@WebServlet("/ariaschorus/socket")
public class WebSocketServlet extends HttpServlet {

    @Inject
    private WebSocketClient webSocketClient;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Lyric lyric = new Lyric();
        lyric.setArtist("Enya");
        lyric.setSong("So I could find my way");
        lyric.setLyricExtract("A thousand dreams");
        try {
            webSocketClient.send(lyric, "ws://localhost:8080/jee-mastery-app-2-1.0.0-SNAPSHOT/ariaschorus/lyrics");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (DeploymentException e) {
            e.printStackTrace();
        }
        final PrintWriter writer = resp.getWriter();
        writer.println(BRIGHT_CYAN.getPBText("Please check your logs! Your lyric is sent!"));
        writer.println(MAGENTA.getPText("<p><a href=\"../index.xhtml\">Back</a></p>"));
    }
}
