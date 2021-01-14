package org.jesperancinha.jtd.jee.spain.secure;

import javax.annotation.Resource;
import javax.annotation.security.DeclareRoles;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
@LocalBean
@DeclareRoles({"Manager"})
public class PalaceWaitingRoom {

    @Resource
    private SessionContext sessionContext;

    public boolean isUserInRole(String roleName) {
        return sessionContext.isCallerInRole(roleName);
    }
    
}