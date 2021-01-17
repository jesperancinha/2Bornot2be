package org.jesperancinha.java11.crums.crum16;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Long.MIN_VALUE;
import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Crum16 {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 16 - How to import statically");

        printYellowGenericLn("Maximum value for an integer is %s",MAX_VALUE);
        printYellowGenericLn("Minimum value for a Long is %s",MIN_VALUE);

        BLUE.printGenericLn("This is how import static is done. Notice the order:");
        BLUE.printGenericLn("import static java.lang.Integer.MAX_VALUE;\n" + "import static java.lang.Long.MIN_VALUE;\n"
            + "import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;\n"
            + "import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;\n"
            + "import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;");
    }
}
