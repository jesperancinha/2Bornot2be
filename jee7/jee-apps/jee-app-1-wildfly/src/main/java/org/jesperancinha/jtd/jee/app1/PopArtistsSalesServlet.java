package org.jesperancinha.jtd.jee.app1;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.jtd.jee.app1.beans.Sales;
import org.jesperancinha.jtd.jee.app1.managers.SalesRequest;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;

@WebServlet("/popartists/sales")
public class PopArtistsSalesServlet extends HttpServlet {

    @Inject
    PopArtistsService popArtistsService;

    @Inject
    @Sales
    private long totalSales;

    // Injected normal scoped bean is not proxyable
    // If you put @RequestScoped. TODO: Find what this is all about
    @Inject
    @SalesRequest
    private Long totalSalesDynamic;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Consolerizer.typingWaitGlobal = 0;
        Consolerizer.maxLineCharsGlobal = 100;
        Consolerizer.titleSpread = 100;
        Consolerizer.blackAndWhite = false;
        printBlueGenericTitleLn("Application1");
        printBlueGenericTitleLn(PopArtistsSalesServlet.this.getClass());
        printMagentaGenericLn("We first pick an artist at random");
        final List<String> popArtists = popArtistsService.popArtists();
        final int len = popArtists.size();
        final int i = (int) (Math.random() * len);
        printOrangeGenericLn("This is our picked artist:");
        final String chosenArtist = popArtists.get(i);
        printOrangeGenericLn(chosenArtist);
        printMagentaGenericLn("Now we can randomly say that this artist has sold %d records!", totalSales);

        printGreenGenericLn(
            "Note that we were able to inject a 'long' primitive. This can be done, but the type must match!");
        printGreenGenericLn(
            "Our injected value is created once. It is application scoped and so it created per application instance");

        resp.setContentType("text/html");
        final PrintWriter writer = resp.getWriter();
        writer.println("<html><head><title>An artists page</title></head><body>");
        writer.println(String.format("<h1>Artist %s has sold %d records!</h1>", chosenArtist, totalSales));
        writer.println(String.format("<h1>Artist %s has sold %d records!</h1>", chosenArtist, totalSalesDynamic));
        final String exercise1 = "Note that in JEE, we do not need to use any extra annotation to inject a Service.\n"
            + "The service itself, does not use any annotation";
        writer.println("<p>" + exercise1 + "</p>");
        writer.println("<a href=\"../index.html\">Back</a>");
        writer.println("<a href=\"./sales\">Refresh</a>");
        writer.println("</body></html>");
        writer.close();
    }

}