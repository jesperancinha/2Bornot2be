package org.jesperancinha.java11.crums.crum34;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;

public class Crum34 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 34 - Assignment return values");

        printMagentaGenericLn("An assignment returns a value");
        int a;
        printMagentaGenericLn("a = 5 + 10 will return %d", a = 5 + 10);
        float b;
        printMagentaGenericLn("b = 1234.5 * 1234.3 will return %f", b = 1234.5f * 1234.3f);

        printMagentaGenericLn("We can confirm that at the same time the assignment has completed:");
        printMagentaGenericLn("This is the value for a:");
        printMagentaGenericLn(a);
        printMagentaGenericLn("This is the value for b:");
        printMagentaGenericLn(b);

        printGreenGenericLn("The point with this crum is just to show that an assignment returns the value the variable is being assigned to");

    }
}
