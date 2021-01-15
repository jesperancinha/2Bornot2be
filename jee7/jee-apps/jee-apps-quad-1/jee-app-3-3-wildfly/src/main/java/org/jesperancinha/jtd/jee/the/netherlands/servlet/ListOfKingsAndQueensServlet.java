package org.jesperancinha.jtd.jee.the.netherlands.servlet;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;

@WebServlet("/history/dynasties")
public class ListOfKingsAndQueensServlet extends HttpServlet {

    @Inject
    private ListOfKingsAndQueensBean listOfKingsAndQueensBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final List<String> orangeNassau = listOfKingsAndQueensBean.getOrangeNassau();

        final PrintWriter writer = resp.getWriter();

        writer.println("<h1>This is the Royal Orange-Nassau first Dynasty</h1>");
        printGreenGenericLn("You are currently logged in as %s", req.getUserPrincipal());
        orangeNassau.forEach(writer::println);

        writer.println(String.format("You are currently logged in as %s", req.getUserPrincipal()));

        try {

            final List<String> nassau = listOfKingsAndQueensBean.getNassau();
            writer.println("<h1>This is the Nassau Dynasty</h1>");
            nassau.forEach(writer::println);

        } catch (Exception e) {
            printRedGenericLn("This may be expected! -> %s", e.getMessage());
            printGreenGenericLn(
                "Check your user. It has to have the Manager role, otherwise they cannot see the Nassau dynasty member list");
        }

        writer.println("<p><a href=\"../index.xhtml\">Back</a></p>");
    }
}
