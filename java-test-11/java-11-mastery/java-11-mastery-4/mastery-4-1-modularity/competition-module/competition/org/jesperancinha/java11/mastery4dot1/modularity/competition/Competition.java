package org.jesperancinha.java11.mastery4dot1.modularity.competition;

import org.jesperancinha.java11.mastery4dot1.modularity.hangar.Hangar;
import org.jesperancinha.java11.mastery4dot1.modularity.hangar.Plane;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;

public class Competition {

    private String name;

    public static void main(String[] args) {
        BLUE.printGeneric("***");
        printGreenGenericLn("--- We start the competition %s ---", new Competition("Daily Mail Trans-Atlantic Air Race of 1969"));
        BLUE.printGeneric("***");
        Hangar.presentHangar();
        Plane.transportPilot();
    }

    private Competition(String name) {

        this.name = name;
    }

    @Override
    public String toString() {
        return "Competition{" +
                "name='" + name + '\'' +
                '}';
    }
}
