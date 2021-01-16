package org.jesperancinha.jtd.jee.the.netherlands.rest;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;

import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowTitleLn;

@RequestScoped
public class EventProcessor {

    public void sendPressRelease(
        @Observes(notifyObserver = Reception.ALWAYS)
            ArrivalEvent event) {
        printRainbowTitleLn("Event received! -> %s", event);
        printRainbowTitleLn("Reception.ALWAYS means that we ALWAYS receive this event.");
        printRainbowTitleLn("Reception.ALWAYS and TransactionPhase.IN_PROGRESS are the default values");
    }

    public void cleanPalace(@Observes(notifyObserver = Reception.IF_EXISTS)
        ArrivalEvent event) {
        printRainbowTitleLn("Event received! -> %s", event);
        printRainbowTitleLn("We get this event only when there is an instance in a related context.");
        printRainbowTitleLn("Otherwise we never get this event.");
        printRainbowTitleLn("Remember that TransactionPhase.IN_PROGRESS is the default value for during.");

    }

    public void informFamily(ArrivalEvent event) {

    }

    public void orderFlowers(ArrivalEvent event) {

    }

    public void arrangeGarden(ArrivalEvent event) {

    }
}
