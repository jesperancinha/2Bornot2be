package org.jesperancinha.jtd.jee.girl.bands.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightCyanGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowTitleLn;

@WebServlet("/LogoutGirlBandRecordStoreServlet")
public class LogoutGirlBandRecordStoreServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        final var cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                if (cookie.getName()
                    .equals("JSESSIONID")) {
                    printRainbowTitleLn("JSESSIONID=" + cookie.getValue());
                } else {
                    printBrightCyanGenericLn("Found cookie %s!. Invalidating...", cookie);
                    printBrightCyanGenericLn("%s=%s", cookie.getName(), cookie.getValue());
                }
            }
        }
        HttpSession httpSesssion = request.getSession(false);
        printMagentaGenericLn("Username is=%s", httpSesssion.getAttribute("username"));
        if (httpSesssion != null) {
            httpSesssion.invalidate();
        }
        printBlueGenericLn("Session %s is now invalidated", httpSesssion);
        response.sendRedirect("/jee-app-2-2-wildfly-1.0.0-SNAPSHOT");
    }

}