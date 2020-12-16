package org.jesperancinha.ocp11.crums.crum32;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;

public class Crum32 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 32 - How to unbox");

        printMagentaGenericLn("Unboxing operations can be done multiple ways");
        final Integer a = 123;
        final int aU = a;
        final long bU = a;
        final float cU = a;
        final double dU = a;
        final byte eU = a.byteValue();
        final short fU = a.shortValue();
        final char gU = (char) a.shortValue();

        printOrangeGenericLn(a);
        printOrangeGenericLn(aU);
        printOrangeGenericLn(bU);
        printOrangeGenericLn(cU);
        printOrangeGenericLn(dU);
        printOrangeGenericLn(eU);
        printOrangeGenericLn(fU);
        printOrangeGenericLn(gU);

        printMagentaGenericLn("These are examples of unbxing operations that work as unboxing from an Integer");
        printBlueGenericLn("        final Integer a = 123;\n" + "        final int aU = a;\n"
            + "        final long bU = a;\n" + "        final float cU = a;\n" + "        final double dU = a;\n"
            + "        final byte eU = a.byteValue();\n" + "        final short fU = a.shortValue();\n"
            + "        final char gU = (char) a.shortValue();");


        printMagentaGenericLn("These are examples of unbxing operations that work as unboxing from an Byte");
        final Byte bB = 123;
        final byte bAB = bB;
        final short bBB = bB;
        final char bCB = Character.highSurrogate(bB);
        final int bDB = bB;
        final long bEB = bB;
        final float bFB = bB;
        final double bGB = bB;
        printOrangeGenericLn(bB);
        printOrangeGenericLn(bAB);
        printOrangeGenericLn(bBB);
        printOrangeGenericLn(bCB);
        printOrangeGenericLn(bDB);
        printOrangeGenericLn(bEB);
        printOrangeGenericLn(bFB);
        printOrangeGenericLn(bGB);
        printBlueGenericLn("        final Byte bB = 123;\n" + "        final byte bAB = bB;\n"
            + "        final short bBB = bB;\n" + "        final char bCB = Character.highSurrogate(bB);\n"
            + "        final int bDB = bB;\n" + "        final long bEB = bB;\n" + "        final float bFB = bB;\n"
            + "        final double bGB = bB;");
        printGreenGenericLn("Unboxing works in the same way as primitive inter conversions");
        printGreenGenericLn("There are some exceptions");
        printGreenGenericLn("If the type to be converted to is shorter or doesn't match the range, unboxing will not happen implicitly");
    }
}
