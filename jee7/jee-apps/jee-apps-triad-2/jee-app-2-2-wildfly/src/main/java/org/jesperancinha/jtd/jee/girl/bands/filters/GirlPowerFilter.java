package org.jesperancinha.jtd.jee.girl.bands.filters;

import org.jesperancinha.console.consolerizer.Consolerizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightCyanGenericLn;

@WebFilter(urlPatterns = { "/app/secure/*" }, description = "Session Checker Filter")
public class GirlPowerFilter implements Filter {

    public static final String GIRL_POWER_FILTER_IS_BEING_REMOVED = "GirlPowerFilter is being removed";
    public static final String GIRL_POWER_FILTER_IS_BEING_INITIALIZED = "GirlPowerFilter is being initialized!";

    private FilterConfig config = null;

    public void init(FilterConfig config) {
        this.config = config;
        config.getServletContext()
            .log(GIRL_POWER_FILTER_IS_BEING_INITIALIZED);
        printBrightCyanGenericLn(GIRL_POWER_FILTER_IS_BEING_INITIALIZED);
    }

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
        throws ServletException, IOException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        Consolerizer.printOrangeGenericLn(
            "We are going to have a look and see if LOGGED_IN is available as session attribute");
        Consolerizer.printOrangeGenericLn("This is the role of a WebFilter");
        Consolerizer.printMagentaGenericLn("A WebFilter allows us to create a set of rules for a set of servlets");
        Consolerizer.printMagentaGenericLn("We could in theory configure this same thing per servlet.");
        Consolerizer.printMagentaGenericLn("However that would mean on specific configuration per servlet.");

        if (!request.getRequestURI()
            .endsWith("/") && request.getSession()
            .getAttribute("LOGGED_IN") == null) {
            response.sendRedirect(request.getContextPath() + "/");
        } else {
            chain.doFilter(req, res);
        }
    }

    public void destroy() {
        config.getServletContext()
            .log(GIRL_POWER_FILTER_IS_BEING_REMOVED);
        printBrightCyanGenericLn(GIRL_POWER_FILTER_IS_BEING_INITIALIZED);
    }
}