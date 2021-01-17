package org.jesperancinha.java11.crums.crum17;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;

public class Crum17 {

    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 17 - Multiple classes in one file");

        MainOne.main(null);
        MainTwo.main(null );

        printMagentaGenericLn("Notice that we are able to create two classes in one file");
        printMagentaGenericLn("For this to be possible, they have to be package protected");
        printMagentaGenericLn("Methods can be public");
    }
}
