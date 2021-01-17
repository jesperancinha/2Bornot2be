package org.jesperancinha.java11.mastery4dot3.family;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.java11.mastery4dot3.cousins.Cousins;
import org.jesperancinha.java11.mastery4dot3.yourcousins.YourCousins;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;

public class FamilyRunner {
    public static void main(String[] args) {
        var cousins = new Cousins();
        var yourCousins = new YourCousins();
        BLUE.printGenericLn("Let's start a family party!");
        BLUE.printGenericLn("We start with their cousins!");
        Consolerizer.printMagentaGenericLn(cousins.getCousins());
        BLUE.printGenericLn("And now we start with our cousins!");
        Consolerizer.printMagentaGeneric(yourCousins.getCousins());
    }
}
