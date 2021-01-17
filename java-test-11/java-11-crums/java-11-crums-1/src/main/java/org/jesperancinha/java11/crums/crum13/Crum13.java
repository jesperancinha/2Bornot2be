package org.jesperancinha.java11.crums.crum13;

import java.util.Random;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Crum13 {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 13 - java.util and java.lang working closer together");

        final Random random = new Random();

        final int i = random.nextInt();
        final int j = random.nextInt();

        printYellowGenericLn("The maximum between %d and %d is %d", i, j, Math.max(i, j));
        printMagentaGenericLn("Important things to notice are that Random comes from the "
            + "java.util package and Math comes from the java.lang package");

    }
}
