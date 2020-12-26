package org.jesperancinha.jtd.jee.app1;

import org.jesperancinha.console.consolerizer.Consolerizer;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;

@WebServlet("/popartists")
public class PopArtistsServlet extends HttpServlet {

    @Inject
    PopArtistsService popArtistsService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        Consolerizer.typingWaitGlobal = 0;
        Consolerizer.maxLineCharsGlobal = 100;
        Consolerizer.titleSpread = 100;
        Consolerizer.blackAndWhite = false;
        printBlueGenericTitleLn("Application1");
        printBlueGenericTitleLn(PopArtistsServlet.this.getClass());

        final List<String> popArtists = popArtistsService.popArtists();
        printMagentaGenericLn(popArtists);

        PrintWriter writer = resp.getWriter();
        writer.println("<html><head><title>An artists page</title></head><body>");
        writer.println("<h1>" + popArtists + "</h1>");
        final String exercise1 = "Note that in JEE, we do not need to use any extra annotation to inject a Service.\n"
            + "The service itself, does not use any annotation";
        writer.println("<p>" + exercise1 + "</p>");
        writer.println("<a href=\"index.html\">Back</a>");
        writer.println("<a href=\"./popartists\">Refresh</a>");
        writer.println("</body></html>");
        writer.close();
    }

}