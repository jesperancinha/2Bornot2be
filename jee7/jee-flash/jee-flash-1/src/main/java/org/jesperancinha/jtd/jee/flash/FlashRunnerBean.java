package org.jesperancinha.jtd.jee.flash;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named("CrumRunner")
@ApplicationScoped
@Startup
@Singleton
public class FlashRunnerBean {

    @PostConstruct
    public void postConstruct() {
    }
}
