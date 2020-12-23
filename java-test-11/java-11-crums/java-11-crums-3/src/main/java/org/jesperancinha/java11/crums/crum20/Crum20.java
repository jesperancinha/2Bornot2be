package org.jesperancinha.java11.crums.crum20;

import java.nio.BufferOverflowException;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;

public class Crum20 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 20 - Accessibility and Extensibility - Defending against DOS");

        printMagentaGenericLn(
            "Let' make a method that doesn't follow Guideline 4-1 / EXTEND-1: Limit the accessibility of classes, interfaces, methods, and fields");
        printRedGenericLn(getAStrawberry());
        printMagentaGenericLn(
            "It is public, so anyone from the outside can access it. It's simple. We make it private:");
        printRedGenericLn(getAStrawberryPrivate());
        printMagentaGenericLn(
            "Now let's just make multiple copies of it and we'll specify a size of a buffer we want to copy it to:");
        printRedGenericLn(makeStrawberryCopy(getAStrawberryPrivate(), 1000));
        printMagentaGenericLn(
            "Sounds, good, but we are creating a char array without checking the size of the destination array.");
        printMagentaGenericLn(
            "This will still violate Java Security guideline Guideline 1-3 / DOS-3: Resource limit checks should not suffer from integer overflow");

        printMagentaGenericLn(
            "In this case we can create a new method which checks that there is no overflow of the integer parameter");

        try {
            printRainbowTitleLn(makeStrawberryCopySafe(getAStrawberryPrivate(), Integer.MAX_VALUE));
        } catch (BufferOverflowException | OutOfMemoryError e) {
            printRedGenericLn("This is expected. Our final method is now inline with Guidelines 4-1 and 1-3 -> %s", e);
            printRedGenericLn(
                "Note that if you get an OutOfMemoryError, that is ok for now, but the code should also be protected against that");
        }

        printGreenGenericLn("It is important that from a security perspective that our code follows certain guideline");
        printGreenGenericLn(
            "Important ones are accessibility and extensibility, resource limit checks, and cloning in immutable objects");
        printGreenGenericLn("Further reading: https://www.oracle.com/java/technologies/javase/seccodeguide.html");

    }

    private static String makeStrawberryCopySafe(String aStrawberryPrivate, int i) {
        if (i >= Integer.MAX_VALUE) {
            throw new BufferOverflowException();
        }
        final char[] chars = aStrawberryPrivate.toCharArray();
        final char[] charsTo = new char[i];
        System.arraycopy(chars, 0, charsTo, 0, Math.min(i, chars.length));
        return new String(charsTo);

    }

    private static String makeStrawberryCopy(String aStrawberryPrivate, int i) {
        final char[] chars = aStrawberryPrivate.toCharArray();
        final char[] charsTo = new char[i];
        System.arraycopy(chars, 0, charsTo, 0, Math.min(i, chars.length));
        return new String(charsTo);

    }

    private static String getAStrawberryPrivate() {
        return "I'm a private strawberry! 🍓";
    }

    public static String getAStrawberry() {
        return "Here is one, enjoy! 🍓";
    }
}
