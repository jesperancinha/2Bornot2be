package org.jesperancinha.java11.crums.crum30;

import org.jesperancinha.console.consolerizer.Consolerizer;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;

public class Crum30 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 30 - @Repeatable annotation");
        printMagentaGenericLn(new MashedPotatoes());

        Consolerizer.printGreenGenericLn("Remember that the rule is that @Repeatable must have a container class");
        Consolerizer.printGreenGenericLn("The container class must have an array of the repeating type");
    }
}
