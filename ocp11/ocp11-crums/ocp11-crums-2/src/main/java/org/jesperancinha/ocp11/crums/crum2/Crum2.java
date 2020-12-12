package org.jesperancinha.ocp11.crums.crum2;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;

public class Crum2 {

    private static final int dob = 1979;

    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 2 - Accessing static variables");

        printMagentaGenericLn("The year was %d", dob);
        printMagentaGenericLn("The year was also %d", Crum2.dob);
        printMagentaGenericLn("The year was in a very strange way also  %d", new Crum2().dob);
        printMagentaGenericLn("The year was in another very strange way also  %d", new Crum2().getDob());

        printGreenGenericLn("Static access looks simple, but it has a lot of nuances");
        printGreenGenericLn("`this` can still be  used to a access static variables from a local instance context");

    }

    /**
     * The this context also allows access to static variables
     * Although this is not very used and not advisable, it is still possible to do.
     * @return
     */
    public int getDob() {
        return dob;
    }
}
