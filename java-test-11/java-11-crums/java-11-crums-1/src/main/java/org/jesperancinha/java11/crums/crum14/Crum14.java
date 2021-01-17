package org.jesperancinha.java11.crums.crum14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightCyanGenericLn;

public class Crum14 {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 14 - Type Arrays legal operations");

        final List<Double> list = new ArrayList<>();
        list.add(111d);

        printBrightCyanGenericLn(list);
        printBrightCyanGenericLn(list.contains(111d));
        printBrightCyanGenericLn(list.contains(111f));
        printBrightCyanGenericLn(list.contains("WOW"));
        printBrightCyanGenericLn(list.containsAll(List.of(111d)));
        printBrightCyanGenericLn(list.containsAll(Collections.singletonList(111d)));

        MAGENTA.printGenericLn("Notice that you can only add elements strictly of the type of the array");
        MAGENTA.printGenericLn("Contains works with all types though");
        MAGENTA.printGenericLn("Contains expects and Object and containsAll expects a list of Objects");
    }
}
