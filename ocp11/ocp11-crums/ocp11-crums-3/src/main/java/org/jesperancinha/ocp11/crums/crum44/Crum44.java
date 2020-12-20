package org.jesperancinha.ocp11.crums.crum44;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightCyanGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Crum44 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 44 - Working with Collectors.toMap");

        final List<String> tickets = List.of("REM", "B-52's", "Paul Simon", "Sarah Brightman", "John Cale", "REM");
        final List<Double> prices = List.of(20.3, 34.5, 102.4, 1.34, 24.0, 55.5);
        printMagentaGenericLn("We will now zip the tickets with their price!");
        final Map<String, Double> map1 = IntStream.range(0, tickets.size())
            .boxed()
            .collect(Collectors.toMap(tickets::get, prices::get, (x, y) -> {
                printOrangeGenericLn("x=%f, y=%f", x, y);
                return x + y;
            }));

        printBrightCyanGenericLn(map1);

        printYellowGenericLn("Now we just double the values to reduce the ticket to price 0!!!");
        final LinkedHashMap<String, Double> map2 = Stream.of(map1.entrySet(), map1.entrySet())
            .flatMap(Collection::stream)
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> {
                printOrangeGenericLn("x=%f, y=%f", x, y);
                return x - y;
            }, LinkedHashMap::new));
        map2.forEach((var k, var v) -> printMagentaGenericLn("%s = %.10f\n", k, v));

        printGreenGenericLn(
            "Let's remember that Collectors.toMap uses indexes or whatever value in the strem to setup the keys we need and the values");
        printGreenGenericLn("We can use these indexes to our advantage but we don't have to.");
        printGreenGenericLn("A BinaryOperator takes care of operations with the map values");
        printGreenGenericLn("The Extra supplier value is where the key/value pairs will be stored.");
    }
}
