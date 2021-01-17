package org.jesperancinha.jtd.jee.spain.secure;

import org.jesperancinha.console.consolerizer.Consolerizer;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Objects;

import static org.jesperancinha.console.consolerizer.ConColor.RED;

// Caused by: org.jboss.weld.exceptions.DefinitionException:
// WELD-000082: Scope interface javax.enterprise.context.SessionScoped
// is not allowed on stateless session beans for class
// org.jesperancinha.jtd.jee.spain.secure.PalaceSessionWaitingRoom.
// Only @Dependent is allowed.
// @Stateless
@SessionScoped
@Stateful
public class PalaceSessionWaitingRoom implements Serializable {

    @EJB
    private ContextProvider contextProvider;
    @Resource
    private SessionContext context;

    public boolean isUserInRole(String roleName) {
        if (Objects.isNull(contextProvider)) {
            Consolerizer.printYellowGenericLn("The context provider session is null");
            Consolerizer.printYellowGenericLn("You probably call this from a JSP");
            Consolerizer.printYellowGenericLn("Try now using the REST service");
            return false;
        }
        try {
            Consolerizer.printOrangeGenericLn("Is user %s in role %s? Answer: %s", contextProvider.getContext()
                .getCallerPrincipal(), contextProvider.getContext()
                .isCallerInRole(roleName));
        } catch (Exception exception) {
            RED.printGenericLn("This is expected! The AuthorizationManager is indeed not available -> %s", exception.getMessage());
        } finally {
            Consolerizer.printRainbowTitleLn(context.getCallerPrincipal());
        }
        return false;
    }

}