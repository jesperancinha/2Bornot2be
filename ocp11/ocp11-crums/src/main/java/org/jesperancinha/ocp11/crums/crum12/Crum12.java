package org.jesperancinha.ocp11.crums.crum12;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;

public class Crum12 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 12 - How many strings we create");

        final String a = "Whatup?";
        final String b = new String(a);
        final String c = a + b;
        final Object d = new Object();

        printMagentaGenericLn("We just created three strings:");
        printMagentaGenericLn(a);
        printMagentaGenericLn(b);
        printMagentaGenericLn(c);

        printOrangeGenericLn(a == b);
        printOrangeGenericLn(b == c);
        printOrangeGenericLn(a == c);
        printOrangeGenericLn(a == "Whatup?");
        printOrangeGenericLn(b == "Whatup?");
        printOrangeGenericLn(b.equals(a));
        printOrangeGenericLn(a.hashCode());
        printOrangeGenericLn(b.hashCode());
        printOrangeGenericLn(c.hashCode());
        printOrangeGenericLn("Oh, and we created object d -> %s", d);

    }
}
