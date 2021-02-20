package org.jesperancinha.java11.crums.crum9;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.ORANGE;

public class Crum9 {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 9 - String has concat and StringBuilder has append");

        var sale = "Peixinho fresquinho";

        MAGENTA.printGenericLn("The fisherman says:");

        ORANGE.printGenericLn(sale.concat(" a 5 euros o kilo!"));

        MAGENTA.printGenericLn("The fisherman alos says:");

        var sb = new StringBuilder(sale);

        ORANGE.printGenericLn(sb.append(" a 5 euros o kilo!"));

        GREEN.printGenericLn("String has concat and StringBuilder has append. That's it! Enjoy!");
    }
}
