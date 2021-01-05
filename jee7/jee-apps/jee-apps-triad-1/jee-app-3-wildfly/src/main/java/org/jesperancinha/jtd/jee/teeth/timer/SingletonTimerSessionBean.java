package org.jesperancinha.jtd.jee.teeth.timer;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;

import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

@Singleton
public class SingletonTimerSessionBean {

    @Resource
    private SessionContext context;

    public void createTimer(long duration) {
        context.getTimerService()
            .createTimer(duration, "I've timed in " + duration + "seconds with a SingletonTimerSessionBean");
    }

    @Timeout
    public void timeOutHandler(Timer timer){
        printYellowGenericLn(timer.getInfo());
        timer.cancel();
    }
}
