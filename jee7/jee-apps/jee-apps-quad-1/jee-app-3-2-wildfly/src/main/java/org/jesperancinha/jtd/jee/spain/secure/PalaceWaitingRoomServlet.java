package org.jesperancinha.jtd.jee.spain.secure;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;

@WebServlet("/history/palace/servlet")
public class PalaceWaitingRoomServlet extends HttpServlet {

    @EJB
    private ContextProvider contextProvider;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final var context = contextProvider.getContext();
        printBrightMagentaGenericLn(context
            .isCallerInRole("Manager"));
        final PrintWriter writer = resp.getWriter();
        printGreenGenericLn("With a correct role installation we can check with isCallerInRole from EJB SessionContext, if the user belongs to a certain role.");
        printGreenGenericLn("For semantic purposes a Caller is also the logged in user.");
        printGreenGenericLn("A principal can be referred to as the representation of that user.");
        writer.println("Hi there!");
        writer.println("I just checked that user" + context.getCallerPrincipal().getName() + " has profile Manager!");
    }
}
