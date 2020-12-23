package org.jesperancinha.java11.crums.crum39;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;

public class Crum39 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 39 - String has concat and StringBuilder has append");

        var sale = "Peixinho fresquinho";

        printMagentaGenericLn("The fisherman says:");

        printOrangeGenericLn(sale.concat(" a 5 euros o kilo!"));

        printMagentaGenericLn("The fisherman alos says:");

        var sb = new StringBuilder(sale);

        printOrangeGenericLn(sb.append(" a 5 euros o kilo!"));

        printGreenGenericLn("String has concat and StringBuilder has append. That's it! Enjoy!");
    }
}
