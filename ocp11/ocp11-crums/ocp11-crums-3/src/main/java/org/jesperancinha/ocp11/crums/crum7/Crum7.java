package org.jesperancinha.ocp11.crums.crum7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;

public class Crum7 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 7 - indexOf and contains");

        printMagentaGenericLn("indexOf and contains accept Object.");
        final List<String> strings = Arrays.asList("Doja Cat", "Nicky Minaj", "Cardi B", "Cher");

        try {
            strings.add("What?");
        } catch (UnsupportedOperationException e) {
            printRedGenericLn("This is expected! Arrays.asList returns a fixed size list -> %s", e);
            printMagentaGenericLn("What we can do is swap Nicky Minaj with just Nicky:");
            strings.set(1, "Nicky");
            printOrangeGenericLn(strings);
        }

        var singerNames = new ArrayList<>(strings);

        printMagentaGenericLn("These are all our singers:");
        printOrangeGenericLn(singerNames);
        printMagentaGenericLn("Let's check if cher is there:");
        printOrangeGenericLn(singerNames.contains("Cher"));
        printMagentaGenericLn("Now we try to find a double there:");

        // 'List<String>' may not contain objects of type 'Double'
        printOrangeGenericLn(singerNames.contains(1.4));
        printMagentaGenericLn("So this is of course false.");
        printMagentaGenericLn("We can now try to find the index of Camilla Cabello in the list.");
        printOrangeGenericLn("Oh oh, it's not there and so the index is %d", singerNames.indexOf("Camilla Cabello"));
        printOrangeGenericLn("But we do find Cardi B %d", singerNames.indexOf("Cardi B"));
        printOrangeGenericLn("But if we look for a number, this time an Integer, we still get %d",
            singerNames.indexOf(1234));
        singerNames.add("Camilla Cabello");
        printMagentaGenericLn("We now have added Camilla Cabello");
        printOrangeGenericLn("And there we go, Camilla Cabello has now index %d in our list",
            singerNames.indexOf("Camilla Cabello"));

        printGreenGenericLn("indexOf and contains accept objects");
        printGreenGenericLn("Setting a wrong type as a parameter is pointless, but it doesn't cause an exception");
        printGreenGenericLn(
            "In both cases this is just a find operation which makes it logic that it does not throw an exception and instead it just returns false");
        printGreenGenericLn(
            "As an added curiosity, not that Arrays.asList returns a fixed size list. It is still mutable. List.of is immutable");
    }
}
