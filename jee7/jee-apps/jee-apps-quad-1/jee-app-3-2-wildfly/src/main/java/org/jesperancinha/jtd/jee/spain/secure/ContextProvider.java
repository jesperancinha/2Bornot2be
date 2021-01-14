package org.jesperancinha.jtd.jee.spain.secure;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class ContextProvider {
    @Resource
    private SessionContext context;

    public void setContext(SessionContext context) {
        this.context = context;
    }

    public SessionContext getContext() {
        return context;
    }
}
