package org.jesperancinha.java11.crums.crum11;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;

public class Crum11 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 11 - Advanced String literal comparison");

        final String a = "Java";

        final String b = "Java";

        final String c = "J" + 'a' + 'v' + 'a';

        final String va = "va";
        String va1 = "va";

        final String d = "Ja" + va;

        final String e = "Ja" + va1;

        String f = "java";

        String g = "java";

        printMagentaGenericLn("Since they are literals %s is equal to %s, %s == %s = %s", a, b, a, b, a == b);
        printMagentaGenericLn("Since they are literals %s is equal to %s, %s == %s = %s", a, c, a, c, a == c);
        printMagentaGenericLn("Since they are literals %s is equal to %s, %s == %s = %s", a, d, a, d, a == d);
        printMagentaGenericLn("Since they are literals %s is equal to %s, %s == %s = %s", f, g, f, g, f == g);
        printMagentaGenericLn("These are not literals and so %s is not equal to %s, %s == %s = %s", a, e, a, e, a == e);

        printGreenGenericLn("There is a difference and a very functional one between using final and not using final");
        printGreenGenericLn("When using final, the literals work to create Strings in the String pool");
        printGreenGenericLn("When not using final, the result becomes a reference and the bitwise == operator does not work.");
    }
}
