package org.jesperancinha.java11.crums.crum16;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Long.MIN_VALUE;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Crum16 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 16 - How to import statically");

        printYellowGenericLn("Maximum value for an integer is %s",MAX_VALUE);
        printYellowGenericLn("Minimum value for a Long is %s",MIN_VALUE);

        printBlueGenericLn("This is how import static is done. Notice the order:");
        printBlueGenericLn("import static java.lang.Integer.MAX_VALUE;\n" + "import static java.lang.Long.MIN_VALUE;\n"
            + "import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;\n"
            + "import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;\n"
            + "import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;");
    }
}
