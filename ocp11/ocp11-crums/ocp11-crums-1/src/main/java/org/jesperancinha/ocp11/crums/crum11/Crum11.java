package org.jesperancinha.ocp11.crums.crum11;

import org.jesperancinha.console.consolerizer.Consolerizer;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printNewLine;

public class Crum11 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 11 - All english letters fit a byte");

        for (byte i = 'A'; i <= 122; i++) {
            Consolerizer.printBrightMagentaGeneric(i);
            Consolerizer.printBrightMagentaGeneric((char)i);
        }

        printNewLine();

    }
}
