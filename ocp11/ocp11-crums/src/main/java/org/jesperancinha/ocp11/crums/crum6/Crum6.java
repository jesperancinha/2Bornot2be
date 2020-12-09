package org.jesperancinha.ocp11.crums.crum6;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Crum6 {
    public static void main(String[] args) {
        final String text = "Crum 6 - String length() is not length nor is it size()";
        printBlueGenericTitleLn(text);
        printMagentaGenericLn("This string has %s characters", text.length());
        // Cannot resolve symbol 'length'
        // printMagentaGenericLn("This string has %s characters", text.length);
        // Cannot resolve method 'size' in 'String'
        // printMagentaGenericLn("This string has %s characters", text.size());
        printMagentaGenericLn("Note that it is important to understand that length is an instance method of String");
        printMagentaGenericLn("length is not an instance member of String");
        printMagentaGenericLn("size is not an instance method of String");
        printYellowGenericLn("This is what will happen during compile time:\n"
            + "        // Cannot resolve symbol 'length'\n"
            + "        // printMagentaGenericLn(\"This string has %s characters\", text.length);\n"
            + "        // Cannot resolve method 'size' in 'String'\n"
            + "        // printMagentaGenericLn(\"This string has %s characters\", text.size());");


    }
}
