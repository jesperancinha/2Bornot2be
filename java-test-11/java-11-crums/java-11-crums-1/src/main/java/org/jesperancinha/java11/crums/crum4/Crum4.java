package org.jesperancinha.java11.crums.crum4;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGeneric;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printNewLine;

public class Crum4 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 4 - Variable initialization on for loops");

        // Variable 'i' might not have been initialized
        // int i;
        int i = 0;
        for (; i < 10; i++) {
            printMagentaGeneric(i);
        }
        printNewLine();
        printMagentaGenericLn("The point is that all variables in a for loop need to be initialized");
        printMagentaGenericLn(
            "This is pretty much the case of every local variable before using them for the first time");
    }
}
