package org.jesperancinha.ocp11.crums.crum8;

import java.util.Arrays;
import java.util.List;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Crum8 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 8 - Keywords and Values");
        final List<String> keywords = Arrays.asList("abstract", "continue", "for", "new", "switch", "assert", "default",
            "goto", "package", "synchronized", "boolean", "do", "if", "private", "this", "break", "double",
            "implements", "protected", "throw", "byte", "else", "import", "public", "throws", "case", "enum",
            "instanceof", "return", "transient", "catch", "extends", "int", "short", "try", "char", "final",
            "interface", "static", "void", "class", "finally", "long", "strictfp", "volatile", "const", "float",
            "native", "super", "while");
        printMagentaGenericLn("You can find all Java keywords on the oracle website:");
        printMagentaGenericLn("https://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html");
        int i = 0;
        int a = 0;
        OHNO:
        for (int j = 0; j < 100; j++) {
            a++;
            BOOP: for (int k = 0; k < 100; k++) {
                if (k == 0) {
                    a++;
                    break BOOP;
                    // Unreachable statement
                    // a++;
                }
                break OHNO;
            }
        }
        printYellowGenericLn("A should be 200 ->  %s", a);
        LINE:
        if (i < 2) {
            printMagentaGenericLn("These are all the keywords:");
            printMagentaGenericLn(keywords);
            i++;
            break LINE;
        }

    }
}
