package org.jesperancinha.java11.crums.crum18;

import org.jesperancinha.console.consolerizer.Consolerizer;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;

public class Crum18 {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 18 - Fun with numbers and formats");

        Consolerizer.printMagentaGenericLn("%c", 'a');
        Consolerizer.printMagentaGenericLn("%c", 'b');
        Consolerizer.printMagentaGenericLn("%c", 'c');
        Consolerizer.printMagentaGenericLn("%c", 'd');
        Consolerizer.printMagentaGenericLn("%c", 'c');
        Consolerizer.printMagentaGenericLn(0b10101010);
        Consolerizer.printMagentaGenericLn(Integer.toBinaryString(170));
        Consolerizer.printMagentaGenericLn("%n");
        Consolerizer.printMagentaGenericLn("%h", 17);

        Consolerizer.printOrangeGenericLn("https://www.javatpoint.com/java-string-format");
    }
}
