package org.jesperancinha.jtd.jee.the.netherlands.rest;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import java.io.Serializable;

import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowFlag;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowTitleLn;

@SessionScoped
public class EventProcessor implements Serializable {

    public void sendPressRelease(
        @Observes(notifyObserver = Reception.ALWAYS)
            ArrivalEvent event) {
        printRainbowTitleLn("Event received! -> %s", event);
        printRainbowTitleLn("Reception.ALWAYS means that we ALWAYS receive this event.");
        printRainbowTitleLn("Reception.ALWAYS and TransactionPhase.IN_PROGRESS are the default values");
        printRainbowFlag("Press statement has been given! %s", event.getMessage());
    }

    public void cleanPalace(
        @Observes(notifyObserver = Reception.IF_EXISTS)
            ArrivalEvent event) {
        printRainbowTitleLn("Event received! -> %s", event);
        printRainbowTitleLn("We get this event only when there is an instance in a related context.");
        printRainbowTitleLn("Otherwise we never get this event.");
        printRainbowTitleLn("Remember that TransactionPhase.IN_PROGRESS is the default value for during.");
        printRainbowFlag("Cleaners have been notified! %s", event.getMessage());
    }

    public void informFamily(ArrivalEvent event) {

    }

    public void orderFlowers(ArrivalEvent event) {

    }

    public void arrangeGarden(ArrivalEvent event) {

    }
}
