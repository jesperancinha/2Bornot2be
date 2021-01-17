package org.jesperancinha.java11.crums.crum28;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;

public class Crum28 {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 28 - Loss of precision with Float and double");

        int a = 2222;
        float b = a;
        printOrangeGenericLn("The result %d - %d = %d", a, (int) b, (int) b - a);
        a = 222222222;
        b = a;
        printOrangeGenericLn("The result %d - %d = %d", a, (int) b, (int) b - a);
        a = 222222222;
        double c = a;
        printOrangeGenericLn("The result %d - %d = %d", a, (int) c, (int) c - a);

        printGreenGenericLn("Note that the reason we don't get 0 on the second exercise is because float loses precision when the number has more than 6 significant digits");

        printGreenGenericLn("Float can hold 6 to 9 significant digits");
        printGreenGenericLn("Double can hold 15 to 18 significant digits");
    }
}
