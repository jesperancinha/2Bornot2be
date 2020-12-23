package org.jesperancinha.java11.mastery3dot2.marisco;

import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Caranguejo {
    {
        printYellowGenericLn("Caranguejo strolls around on the beach! 🦀");
        if (true) {
            throw new RuntimeException("Oh no! It ran away  in panic!! 💨");
        }
    }

    public static Caranguejo fishCaranguejo() {
        printYellowGenericLn("Trying to catch Caranguejo 🕸");
        return new Caranguejo();
    }
}
