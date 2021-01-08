package org.jesperancinha.jtd.jee.girl.bands.servlets;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.omg.CORBA.Context;

import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

@Named("girlPowerBean")
@SessionScoped
public class GirlPowerBean implements Serializable {

    private boolean logged;

    @Inject
    private HttpSession httpSession;

    public void login() {
        Consolerizer.printBrightMagentaGenericLn("Logging in...");
        httpSession.setAttribute("LOGGED_IN","Spice Girls");
        this.logged = true;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }
}