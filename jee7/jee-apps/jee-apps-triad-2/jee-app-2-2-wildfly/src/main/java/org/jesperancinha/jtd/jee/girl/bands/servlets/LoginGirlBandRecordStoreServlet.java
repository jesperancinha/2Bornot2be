package org.jesperancinha.jtd.jee.girl.bands.servlets;

import org.jesperancinha.console.consolerizer.Consolerizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightCyanGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

@WebServlet("/LoginGirlBandRecordStoreServlet")
public class LoginGirlBandRecordStoreServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String USER_ID = "admin";
    private static final String PASSWORD = "admin";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        final var user = request.getParameter("username");
        final var pwd = request.getParameter("password");

        if (USER_ID.equals(user) && PASSWORD.equals(pwd)) {
            var httpSession = request.getSession();
            httpSession.setAttribute("username", "Sugababes");
            printBrightMagentaGenericLn("We've put our username in the httpSession object -> %s",
                httpSession.getAttributeNames());
            httpSession.getAttributeNames()
                .asIterator()
                .forEachRemaining(Consolerizer::printBrightMagentaGenericLn);
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName()
                        .equals("JSESSIONID")) {
                        printRainbowTitleLn("JSESSIONID=%s", cookie.getValue());
                    } else {
                        printBrightCyanGenericLn("Found cookie %s!", cookie);
                        printBrightCyanGenericLn("%s=%s", cookie.getName(), cookie.getValue());
                    }
                }
            }
            var maxTime = 60;
            printYellowGenericLn("We'll make the session inactive after %s seconds...", maxTime);
            httpSession.setMaxInactiveInterval(maxTime);
            var userName = new Cookie("username", user);
            response.addCookie(userName);
            var encodedURL = response.encodeRedirectURL("store_main.jsp");
            Consolerizer.printBrightCyanGenericLn(encodedURL);
            response.sendRedirect(encodedURL);
        } else {
            var writer = response.getWriter();
            writer.println("<h1><font color=red>Wrong credentials! Please try again</font></h2>");
            var requestDispatcher = getServletContext().getRequestDispatcher("/");
            requestDispatcher.include(request, response);
        }

    }

}