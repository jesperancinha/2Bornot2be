package org.jesperancinha.java11.crums.crum22;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;

public class Crum22 {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 22 - System properties and HashTable");

        StringBuilder sb = new StringBuilder();
        for (var key : System.getProperties()
            .keySet()) {
            sb.append(key);
            sb.append(" ");
        }
        printMagentaGenericLn(sb.toString());
        sb.setLength(0);

        for (var keySet : System.getProperties()
            .entrySet()) {
            sb.append(String.format("%s->%s,", keySet.getKey(), keySet.getValue()));
        }
        printMagentaGenericLn(sb.toString());
        printGreenGenericLn(
            "It's important to understand System.getProperties returns a HashTable of all system properties");
        printGreenGenericLn("A HashTable is synchronized and thread safe.");
        printGreenGenericLn("The Properties object return is a subtype of a hashtable.");

    }
}
