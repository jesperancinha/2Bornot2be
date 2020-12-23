package org.jesperancinha.java11.mastery3dot1.concert;

import org.jesperancinha.console.consolerizer.Consolerizer;

public interface Concert {
    int addConcertGoer() throws ConcerCapacityExceededException;

    int getCurrentCount();

    default void sleep() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Consolerizer.printRedGenericLn("Error has occurred! %s", e);
        }
    }
}
