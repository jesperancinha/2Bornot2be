package org.jesperancinha.java11.crums.crum5;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Crum5 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 5 - default had no mandatory place in a switch");

        final int i = 10;
        switch (i) {
        default:
            printYellowGenericLn("Default");
        case 1:
            printYellowGenericLn("1");
        case 2:
            printYellowGenericLn("2");
        case 3:
            printYellowGenericLn("3");
        case 4:
            printYellowGenericLn("4");
        case 5:
            printYellowGenericLn("5");
        case 6:
            printYellowGenericLn("6");
        }
        printMagentaGenericLn("Note that although some code is unreachable, this complete code is compilable");
        printMagentaGenericLn(
            "Also not that unreachable means in this case that the individual cases are note selectable given that 10 is set before entering the switch");
    }
}
