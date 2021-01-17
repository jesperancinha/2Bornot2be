package org.jesperancinha.java11.crums.crum3;

import org.jesperancinha.console.consolerizer.Consolerizer;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConColor.MAGENTA;

public class Crum3 {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 3 - The dangling if problem");
        if (1 != 1)
            if (2 == 2)
                Consolerizer.printYellowGenericLn("This won't go to the output");
        MAGENTA.printGenericLn("You don't see the last print, because the first statement doesn't match");
        MAGENTA.printGenericLn("Also, do you notice that there is no compilation error?");
        MAGENTA.printGenericLn("Always check the identation. It is often misleading");
        MAGENTA.printGenericLn("This if illustrates the dangling If problem of Java coming from C/C++");
    }
}
