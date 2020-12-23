package org.jesperancinha.java11.crums.crum44;

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

        final List<String> bandsInConcert = List.of("REM", "B-52's", "Paul Simon", "Sarah Brightman", "John Cale", "REM");
        final List<Double> performancePrices = List.of(20.3, 34.5, 102.4, 1.34, 24.0, 55.5);
        printMagentaGenericLn("We will now zip the bandsInConcert with their price!");
        final Map<String, Double> map1 = IntStream.range(0, bandsInConcert.size())
            .boxed()
            .collect(Collectors.toMap(bandsInConcert::get, performancePrices::get, (ticketPrice1, ticketPrice2) -> {
                printOrangeGenericLn("ticketPrice1=$%.2f, ticketPrice1=$%.2f", ticketPrice1, ticketPrice2);
                final double totalTickets = ticketPrice1 + ticketPrice2;
                printOrangeGenericLn("You have an band playing with price $%.2f", totalTickets);
                printOrangeGenericLn("Can you guess which  on is it?", totalTickets);
                return totalTickets;
            }));

        printBrightCyanGenericLn(map1);

        printYellowGenericLn("Now we just double the values to reduce the ticket to price 0!!!");

        Stream.of(map1.entrySet(), map1.entrySet())
            .flatMap(Collection::stream)
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (ticketPrice1, ticketPrice2) -> {
                printOrangeGenericLn("ticketPrice1=$%.2f, ticketPrice2=$%.2f", ticketPrice1, ticketPrice2);
                return ticketPrice1 - ticketPrice2;
            }, LinkedHashMap::new))
            .forEach((var artistName, var ticketSumValue) -> printMagentaGenericLn("%s = $%.2f\n", artistName,
                ticketSumValue));

        printGreenGenericLn(
            "Let's remember that Collectors.toMap uses indexes or whatever value in the stream to setup the keys we need and the values");
        printGreenGenericLn("We can use these indexes to our advantage but we don't have to.");
        printGreenGenericLn("A BinaryOperator takes care of operations with the map values");
        printGreenGenericLn("The Extra supplier value is where the key/value pairs will be stored.");
    }
}
