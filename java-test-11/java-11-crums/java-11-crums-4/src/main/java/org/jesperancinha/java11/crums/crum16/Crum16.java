package org.jesperancinha.java11.crums.crum16;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;

public class Crum16 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 16 - Zipping in Java 11");

        printMagentaGenericLn("We can zip in Java 11 in multiple ways");
        printMagentaGenericLn("One way is to just use the indexes of a list");

        printMagentaGenericLn("We are given a list of cups and a list of their prices. Their orders match");

        var cups = List.of("Black Cup", "Chinese Cup", "Delft Cup", "Euro cup", "Black Cup");
        var prices = List.of(12.3, 400.2, 123000.4, 40000000.12, 123.5);

        printOrangeGenericLn("Our cups: %s", cups);
        printOrangeGenericLn("Our prices: %s", prices);

        try {
            final Map<String, Double> collect = IntStream.range(0, cups.size())
                .boxed()
                .collect(Collectors.toMap(cups::get, prices::get));
        } catch (IllegalStateException e) {
            printRedGenericLn(
                "This is expected! We did not implement a disambiguation! Black Cup exists more than once in the list -> %s",
                e);
        }

        printMagentaGenericLn("So let's disambiguate now:");
        final Map<String, Double> summingAndCollecting = IntStream.range(0, cups.size())
            .boxed()
            .collect(Collectors.toMap(cups::get, prices::get, Double::sum));

        printMagentaGenericLn("We now have the price sum of all cups per type");

        printOrangeGenericLn(summingAndCollecting);

        printGreenGenericLn("We should always implement a disambiguation method");
        printGreenGenericLn("Disambiguation is not strictly necessary if we know that no element is repeated");
        printGreenGenericLn("We can specify the hashmap type if we want to.");
        printGreenGenericLn("The hash map types must not be immutable because the collector uses a Supplier as a starting point.");
    }
}
