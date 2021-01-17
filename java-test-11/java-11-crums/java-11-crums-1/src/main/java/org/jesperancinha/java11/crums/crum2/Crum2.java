package org.jesperancinha.java11.crums.crum2;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;

public class Crum2 {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 2 - Max of Max");
        printMagentaGenericLn("Let's get the Maxiums of the different integral and non-integral types");
        printBrightMagentaGenericLn("Maximum of byte is -> %s", Byte.MAX_VALUE);
        printBrightMagentaGenericLn("Maximum of short is -> %s", Short.MAX_VALUE);
        printBrightMagentaGenericLn("Maximum of char is (note that char cannot be printed as a number with %%s) -> %s",
            (int) Character.MAX_VALUE);
        printBrightMagentaGenericLn("Maximum of int is -> %s", Integer.MAX_VALUE);
        printBrightMagentaGenericLn("Maximum of long is -> %s", Long.MAX_VALUE);
        printBrightMagentaGenericLn("Maximum of float is -> %s", Float.MAX_VALUE);
        printBrightMagentaGenericLn("Maximum of double is -> %s", Double.MAX_VALUE);

        printGreenGenericLn("Maximum of one byte values can only be -> %s", Byte.MAX_VALUE);
        printGreenGenericLn("Maximum of two byte values can only be -> %s",
            Math.max(Short.MAX_VALUE, Character.MAX_VALUE));
        printGreenGenericLn("Maximum of four byte values can only be -> %s",
            Math.max(Integer.MAX_VALUE, Float.MAX_VALUE));
        printGreenGenericLn("Maximum of eight byte values can only be -> %s",
            Math.max(Long.MAX_VALUE, Double.MAX_VALUE));

    }
}
