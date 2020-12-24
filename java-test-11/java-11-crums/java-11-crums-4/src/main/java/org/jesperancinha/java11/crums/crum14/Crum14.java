package org.jesperancinha.java11.crums.crum14;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightCyanGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Crum14 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 14 - Working with Collectors.toMap");

        final List<String> bandsInConcert = List.of("REM - Price = 20.3", "B-52's - Price = 34.5",
            "Paul Simon - Price = 102.4", "Sarah Brightman  - Price = 1.34", "John Cale  - Price = 24.0",
            "REM  - Price = 55.5");
        printMagentaGenericLn("We were given an unorganized list of bands playing and their ticket prices");
        printOrangeGenericLn(bandsInConcert);
        printMagentaGenericLn("We will now turn our list into a map of band and price");
        printMagentaGenericLn("Then we'll solve the ambiguity by summing up the prices found");
        Map<String, Double> map1 = bandsInConcert.stream()
            .collect(Collectors.toMap(band -> band.split(" - Price = ")[0],
                band -> Double.parseDouble(band.split(" - Price = ")[1]), (ticketPrice1, ticketPrice2) -> {
                    printOrangeGenericLn("ticketPrice1=$%.2f, ticketPrice1=$%.2f", ticketPrice1, ticketPrice2);
                    final double totalTicketPrice = ticketPrice1 + ticketPrice2;
                    printOrangeGenericLn("You have a band playing with price $%.2f", totalTicketPrice);
                    printOrangeGenericLn("Can you guess which  on is it?", totalTicketPrice);
                    return totalTicketPrice;
                }));

        printMagentaGenericLn("This is our organized band list ");
        printBrightCyanGenericLn(map1);

        printYellowGenericLn(
            "Now we just double the values to reduce the ticket to price 0. We found discounts on the web!!!");

        final LinkedHashMap<String, Double> concertsWithDiscount = Stream.of(map1.entrySet(), map1.entrySet())
            .flatMap(Collection::stream)
            .sorted(Map.Entry.comparingByValue())
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (ticketPrice1, ticketPrice2) -> {
                printOrangeGenericLn("ticketPrice1=$%.2f, ticketPrice2=$%.2f", ticketPrice1, ticketPrice2);
                return ticketPrice1 - ticketPrice2;
            }, LinkedHashMap::new));
        concertsWithDiscount.forEach(
            (var artistName, var ticketSumValue) -> printBlueGenericLn("%s = $%.2f\n", artistName, ticketSumValue));

        printMagentaGenericLn("But can still change this, because we created a LinkeHashMap now.");
        printMagentaGenericLn("This means that we can change our results");
        concertsWithDiscount.put("REM", 40_000.2222);

        printOrangeGenericLn(concertsWithDiscount);

        map1 = bandsInConcert.stream()
            .collect(Collectors.toMap(band -> band.split(" - Price = ")[0],
                band -> Double.parseDouble(band.split(" - Price = ")[1]), (ticketPrice1, ticketPrice2) -> {
                    printOrangeGenericLn("ticketPrice1=$%.2f, ticketPrice1=$%.2f", ticketPrice1, ticketPrice2);
                    final double totalTicketPrice = ticketPrice1 + ticketPrice2;
                    printOrangeGenericLn("You have a band playing with price $%.2f", totalTicketPrice);
                    printOrangeGenericLn("Can you guess which  on is it?", totalTicketPrice);
                    return totalTicketPrice;
                }));

        printMagentaGenericLn("So let's try again");
        final Map<String, Double> umutableConcerts = Collections.unmodifiableMap(
            Stream.of(map1.entrySet(), map1.entrySet())
                .flatMap(Collection::stream)
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (ticketPrice1, ticketPrice2) -> {
                    printOrangeGenericLn("ticketPrice1=$%.2f, ticketPrice2=$%.2f", ticketPrice1, ticketPrice2);
                    return ticketPrice1 - ticketPrice2;
                })));

        printOrangeGenericLn(umutableConcerts);
        printMagentaGenericLn("Let's see if we can change them:");

        try {
            umutableConcerts.put("REM", 40_000.2222);
        } catch (UnsupportedOperationException e) {
            printRedGenericLn("This is expected! We cannot change our map and we have free tickets! -> %s", e);
        }

        printGreenGenericLn(
            "Let's remember that Collectors.toMap uses indexes or whatever value in the stream to setup the keys we need and the values");
        printGreenGenericLn("We can use these indexes to our advantage but we don't have to.");
        printGreenGenericLn("A BinaryOperator takes care of operations with the map values");
        printGreenGenericLn("The Extra supplier value is where the key/value pairs will be stored.");
        printGreenGenericLn("Pay attention to the Comparators use: Map.Entry.comparingByValue() and Map.Entry.comparingByKey()");
    }
}
