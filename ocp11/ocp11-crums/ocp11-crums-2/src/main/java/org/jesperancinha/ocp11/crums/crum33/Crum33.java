package org.jesperancinha.ocp11.crums.crum33;

import org.jesperancinha.console.consolerizer.Consolerizer;

import java.util.Arrays;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;

public class Crum33 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 33 - Enumerates and how they work");

        printMagentaGenericLn("We can list all enumerates if we just call values");
        printMagentaGenericLn("The printed value is exactly the same key we define in the code");
        Arrays.stream(CashContainer.values())
            .forEach(Consolerizer::printOrangeGenericLn);

        printMagentaGenericLn("We can also retrieve the value per key String:");
        printOrangeGenericLn("%s has index %s", "ATM", CashContainer.valueOf("ATM"));
        printMagentaGenericLn("It is case sensitive!");
        try {
            printOrangeGenericLn("%s has index %s", "ATm", CashContainer.valueOf("ATm"));
        } catch (IllegalArgumentException e) {
            printRedGenericLn(
                "This is expected! Note that an invalid value results in a RuntimeException of type IllegalArgumentException -> %s",
                e);
        }

        try {
            CashContainer.LIONACCOUNT.tryToClone();
        } catch (CloneNotSupportedException e) {
            printRedGenericLn(
                "This is expected, we tried to make clone accessible to the outside world. That is not possible. For enum throws a direct exception");
            printRedGenericLn("If we got to (java.lang.Enum) we find:");
            printRedGenericLn("    /**\n" + "     * Throws CloneNotSupportedException.  This guarantees that enums\n"
                + "     * are never cloned, which is necessary to preserve their \"singleton\"\n" + "     * status.\n"
                + "     *\n" + "     * @return (never returns)\n" + "     */\n"
                + "    protected final Object clone() throws CloneNotSupportedException {\n"
                + "        throw new CloneNotSupportedException();\n" + "    }");
            printRedGenericLn("And then we get this exception ->", e);
        }
        printGreenGenericLn("Enums only have two public methods available to the outside world");
        printGreenGenericLn("One gives you an array with all enum possible values");
        printGreenGenericLn(
            "Another gives you the enum value by the String that case-sensitively matches the key given in the code");
        printGreenGenericLn(
            "We can make methods inside enum. Enums are not cloneable. Trying to call that method from inside the enum results in an exception called CloneNotSupportedException");
    }
}
