package org.jesperancinha.ocp11.crums.crum27;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;

public class Crum27 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 27 - Boxing and Autoboxing");

        final Boolean aBoolean = true;
        final Byte aByte = 127;
        final Short aShort = 32767;
        final Character character = 'a';
        final Integer aInteger = 1122334455;
        final Long aLong = 2233445566778899L;
        final Float aFloat = 1881.1881f;
        final Double aDouble = 1881.1881;

        printMagentaGenericLn("These are the basic boxing operations:");
        printBlueGenericLn("        final Boolean aBoolean = true;\n" + "        final Byte aByte = 127;\n"
            + "        final Short aShort = 32767;\n" + "        final Integer aInteger = 1122334455;\n"
            + "        final Long aLong = 2233445566778899L;\n" + "        final Float aFloat = 1881.1881f;\n"
            + "        final Double aDouble = 1881.1881;");
        printMagentaGenericLn("Some boxing operations aren't that simple:");

        final String iAmANumberInAString = 12345 + " - This is a number. Did you notice the boxng operation?";

        printBlueGenericLn(
            "        final String iAmANumberInAString = 12345 + \" - This is a number. Did you notice the boxng operation?\";");

        printOrangeGenericLn("All numbers so far:");
        printOrangeGenericLn(aBoolean);
        printOrangeGenericLn(aByte);
        printOrangeGenericLn(aShort);
        printOrangeGenericLn(character);
        printOrangeGenericLn(aInteger);
        printOrangeGenericLn(aLong);
        printOrangeGenericLn(aFloat);
        printOrangeGenericLn(aDouble);
        printOrangeGenericLn(iAmANumberInAString);

        printMagentaGenericLn(
            "The reason why adding with \"+\" a number to String results in boxing operations is because that the number implicitly boxed so that the toString is called");
        printMagentaGenericLn("It's difficult to determine this and to assess what is going on but we'll try");

        final int b = 1;
        final int c = 2;
        final String a = b + " this is a sentence and autoboxing has happened" + c;
        printMagentaGenericLn("This sentence was built with auto-boxing -> %s", a);

        final Integer bC = 1;
        final Integer cC = 1;
        final String aC = b + "this is a sentence and autoboxing has not happened. It was already pre-done" + c;
        printMagentaGenericLn("This sentence was built with pre-auto-boxing -> %s", a);

        printGreenGenericLn("Auto-boxing is basically the way Java uses auto-version from primitive types to their object counter parts");
        printGreenGenericLn("Auto-boxing needs to match the type being boxed in");
        printGreenGenericLn("In a String building, this happens implicitly and all numbers are converted to their object counterparts, where the toString is later being called.");


    }
}
