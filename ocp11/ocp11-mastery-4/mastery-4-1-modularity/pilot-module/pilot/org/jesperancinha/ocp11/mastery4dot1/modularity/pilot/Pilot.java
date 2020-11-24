package org.jesperancinha.ocp11.mastery4dot1.modularity.pilot;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGeneric;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;

public class Pilot {

    public static void presentPilot() {
        printBlueGeneric("***");
        printGreenGenericLn("--- Pilot %s ---", new Pilot("Tom Lecky-Thompson"));
        printBlueGeneric("***");
    }

    private String name;

    private Pilot(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pilot{" +
                "name='" + name + '\'' +
                '}';
    }
}
