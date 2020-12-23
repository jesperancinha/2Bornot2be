package org.jesperancinha.java11.crums.crum13;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightCyanGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowStack;

public class Crum13 {

    public static String expectation = "You did not expected this did you?";

    public static Crum13 getInstance() {
        return null;
    }

    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 13 - Getting static values from a null reference");

        printMagentaGenericLn("Pretty bewildering this example if you don't know it, but it is possible! 😱");

        final Crum13 instance = getInstance();
        printBrightCyanGenericLn("Our crum instance is %s", instance);
        printRainbowStack(instance.expectation);
        printBrightMagentaGenericLn("We can even get another null -> %s", instance.getInstance());
        printGreenGenericLn(
            "References can be used to access static members, regardless that the instance itself is null or not");
        printGreenGenericLn("A reference is not attached to any static member");

    }
}
