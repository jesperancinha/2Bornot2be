package org.jesperancinha.java11.crums.crum29;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;

public class Crum29 {
    public static void main(String[] args) {

        BLUE.printGenericTitleLn("Crum 29 - isBlank or strip?");

        char c = Character.LINE_SEPARATOR;

        var stringA = c + "Feels like I'm walking on broken glass" + c;

        var stringB = "" + c;

        printMagentaGenericLn("Although strip() flows the UTF standard, it is a slective way of striping strings");

        printOrangeGenericLn("With strip, stringA is not empty -> %s", stringA.strip() == "");
        printOrangeGenericLn("With strip, stringB is also not empty -> %s", stringB.strip() == "");
        printOrangeGenericLn("With isBlank, stringA is not blank -> %s", stringA.isBlank());
        printOrangeGenericLn("With isBlank, stringB is actually blank -> %s", stringB.isBlank());


        printGreenGenericLn("The idea is that if we want to check for blank Strings, we should use isBlank");

    }
}
