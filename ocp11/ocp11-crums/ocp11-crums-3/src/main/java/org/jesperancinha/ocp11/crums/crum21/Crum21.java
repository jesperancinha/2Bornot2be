package org.jesperancinha.ocp11.crums.crum21;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Crum21 {

    private final class Saxophone {
        // Inner classes cannot have static declarations
        // static String  SMOOTH_OPERATOR = "No need to ask he's a smooth operator";

        // Yes they can!, If they are final of course
        final static String SMOOTH_OPERATOR = "No need to ask he's a smooth operator";

    }

    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 21 - Inner classes and static methods");


        printYellowGenericLn("from https://genius.com/Sade-smooth-operator-lyrics");
        printMagentaGenericLn("We can access SMOOTH_OPERATOR:");

        printOrangeGenericLn(Saxophone.SMOOTH_OPERATOR);

        printGreenGenericLn("The nuance here is that non-static inner classes normally cannot have anything static");
        printGreenGenericLn("However if static members are marked at final, then it is possible to do so.");
        printGreenGenericLn("This has mostly to do wth the fact that an inner class is dependent of its container instance and so changes to the static member would introduce a very confusing code");

    }
}
