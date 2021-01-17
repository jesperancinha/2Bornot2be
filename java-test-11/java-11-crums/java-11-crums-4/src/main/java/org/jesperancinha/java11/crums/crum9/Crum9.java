package org.jesperancinha.java11.crums.crum9;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;

public class Crum9 {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 9 - String has concat and StringBuilder has append");

        var sale = "Peixinho fresquinho";

        printMagentaGenericLn("The fisherman says:");

        printOrangeGenericLn(sale.concat(" a 5 euros o kilo!"));

        printMagentaGenericLn("The fisherman alos says:");

        var sb = new StringBuilder(sale);

        printOrangeGenericLn(sb.append(" a 5 euros o kilo!"));

        printGreenGenericLn("String has concat and StringBuilder has append. That's it! Enjoy!");
    }
}
