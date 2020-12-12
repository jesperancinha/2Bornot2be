package org.jesperancinha.ocp11.crums.crum1;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowTitleLn;

public class Crum1 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 1 - Calling static");
        // Pay attention to parenthesis and where they are needed
        Leaf.print();
        printRainbowTitleLn(Leaf.IAMASTATIC);
        new Leaf().printLocal();
    }
}
