package org.jesperancinha.java11.mastery4dot1.modularity.hangar;

import org.jesperancinha.java11.mastery4dot1.modularity.pilot.Pilot;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGeneric;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;

public class Hangar {

    private String name;

    public static void presentHangar() {
        printBlueGeneric("***");
        printGreenGenericLn("--- Starting point was %s ---", new Hangar("Royal Air Force Space at St Pancras, London, UK"));
        printBlueGeneric("***");
        Pilot.presentPilot();
        Plane.transportPilot();

    }

    private Hangar(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Hangar{" +
                "name='" + name + '\'' +
                '}';
    }
}
