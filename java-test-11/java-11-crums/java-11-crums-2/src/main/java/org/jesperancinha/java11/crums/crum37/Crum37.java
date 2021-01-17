package org.jesperancinha.java11.crums.crum37;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;

public class Crum37 {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 37 - Exceptions are final");

        MAGENTA.printGenericLn("A very simple concept is that thrown exceptions from a multi-catch are final");
        MAGENTA.printGenericLn("We'll test this now:");

        try {
            throw new IndexOutOfBoundsException();
        } catch (IndexOutOfBoundsException | NullPointerException e) {
            // e = new Exception();
            printRedGenericLn("This is expected -> %s", e);

        }
        printGreenGenericLn("We cannot reassign exceptions coming from a multi catch");
        printGreenGenericLn("We do not need to memorize this");
        printGreenGenericLn("The compiler just doesn't know which exception type is going to be thrown");
        printGreenGenericLn(
            "Since exceptions in a multi-catch have no relation with each other, the compiler makes them final");

    }
}
