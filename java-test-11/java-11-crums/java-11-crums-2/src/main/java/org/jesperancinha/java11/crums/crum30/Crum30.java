package org.jesperancinha.java11.crums.crum30;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConColor.MAGENTA;

public class Crum30 {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 30 - @Repeatable annotation");
        MAGENTA.printGenericLn(new MashedPotatoes());

        GREEN.printGenericLn("Remember that the rule is that @Repeatable must have a container class");
        GREEN.printGenericLn("The container class must have an array of the repeating type");
    }
}
