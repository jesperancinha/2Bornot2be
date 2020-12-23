package org.jesperancinha.java11.mastery4dot3.family;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.java11.mastery4dot3.cousins.Cousins;
import org.jesperancinha.java11.mastery4dot3.yourcousins.YourCousins;

public class FamilyRunner {
    public static void main(String[] args) {
        var cousins = new Cousins();
        var yourCousins = new YourCousins();
        Consolerizer.printBlueGenericLn("Let's start a family party!");
        Consolerizer.printBlueGenericLn("We start with their cousins!");
        Consolerizer.printMagentaGenericLn(cousins.getCousins());
        Consolerizer.printBlueGenericLn("And now we start with our cousins!");
        Consolerizer.printMagentaGeneric(yourCousins.getCousins());
    }
}
