package org.jesperancinha.java11.crums.crum9;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;

public class Crum9 {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 9 - Unreachable after a try catch");

        final int i = calculateTheCalculation();

        MAGENTA.printGenericLn("When running this, please uncomment line with // return 100. For now this returns %d", i);
        printGreenGenericLn(
            "The reason why the code does not compile is because both the try and the catch return a value");
        printGreenGenericLn("If we uncomment the final block, it will always return 400");
        printGreenGenericLn("If we uncomment the last return it won't even compile");

    }

    private static int calculateTheCalculation() {
        try {
            return 102;
        } catch (Exception e) {
            return 101;
        } finally {
            // return 400;
        }
        // return 100;
    }
}
