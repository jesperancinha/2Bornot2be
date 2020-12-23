package org.jesperancinha.java11.mastery4dot1.modularity.hangar;

import org.jesperancinha.java11.mastery4dot1.modularity.pilot.Pilot;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;

public class Plane {

    private String model;

    public static void transportPilot() {
        printBlueGenericLn("***");
        printGreenGenericLn("--- Pilot is getting transported by the airplane ---");
        Pilot.presentPilot();
        printGreenGenericLn("--- %s ---", new Plane("Royal Navy F-4 Phantom II"));
        printBlueGenericLn("***");
    }

    private Plane(String model) {

        this.model = model;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + model + '\'' +
                '}';
    }
}
