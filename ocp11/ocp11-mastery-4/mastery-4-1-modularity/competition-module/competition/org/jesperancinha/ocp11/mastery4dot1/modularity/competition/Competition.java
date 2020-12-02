package org.jesperancinha.ocp11.mastery4dot1.modularity.competition;

import org.jesperancinha.ocp11.mastery4dot1.modularity.hangar.Hangar;
import org.jesperancinha.ocp11.mastery4dot1.modularity.hangar.Plane;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGeneric;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;

public class Competition {

    private String name;

    public static void main(String[] args) {
        printBlueGeneric("***");
        printGreenGenericLn("--- We start the competition %s ---", new Competition("Daily Mail Trans-Atlantic Air Race of 1969"));
        printBlueGeneric("***");
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
