package org.jesperancinha.jtd.jee.girl.bands.servlets;

import org.jesperancinha.console.consolerizer.Consolerizer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class RightNameServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("text/html");
            final var writer = response.getWriter();
            final var leftName = request.getParameter("left");
            writer.println("The song is:");
            writer.println(leftName +" Forever");
            writer.close();
        } catch (Exception e) {
            Consolerizer.printRedThrowableAndExit(e);
        }
    }

}
