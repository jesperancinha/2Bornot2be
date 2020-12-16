package org.jesperancinha.ocp11.crums.crum31;

import org.jesperancinha.console.consolerizer.Consolerizer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;

public class Crum31 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 31 - The things a Comparator do");

        final List<Sandwich> sandwiches = Arrays.asList(new Sandwich(3, "Bolas de Berlin"),
            new Sandwich(4, "Bolo de arroz"), new Sandwich(1, "Bolo de arroz"), new Sandwich(2, "Dom Rodrigo"));
        printMagentaGenericLn("We have a list of sandwiches");
        printMagentaGenericLn(sandwiches);
        printMagentaGenericLn("We can organize them by id");

        final List<Sandwich> collect = sandwiches.stream()
            .sorted((a, b) -> a.getId()
                .compareTo(b.getId()))
            .peek(Consolerizer::printOrangeGenericLn)
            .collect(Collectors.toList());

        printMagentaGenericLn(collect);

        printMagentaGenericLn("We can also organize them by name");

        final List<Sandwich> collect1 = sandwiches.stream()
            .sorted(Comparator.comparing(s -> s.getName()))
            .peek(Consolerizer::printOrangeGenericLn)
            .collect(Collectors.toList());

        printMagentaGenericLn(collect1);

        final Comparator<Sandwich> comparing = Comparator.comparing(s -> s.getName());
        final Comparator<Sandwich> comparator = comparing.thenComparing((a, b) -> a.getId()
            .compareTo(b.getId()));
        final List<Sandwich> collect2 = sandwiches.stream()
            .sorted(comparator)
            .peek(Consolerizer::printOrangeGenericLn)
            .collect(Collectors.toList());

        printMagentaGenericLn("We can also organize first by Id and then name");
        printMagentaGenericLn(collect2);

        final Stream<Sandwich> sorted = sandwiches.stream()
            .sorted();
        printMagentaGenericLn("Finally we can sort them with a terminating function");
        printMagentaGenericLn(sorted);
        printGreenGenericLn("We can make our own comparators");
        printGreenGenericLn(
            "If we know we are only using an item to compare or even if we have more we can use Comparator and thenComparing if further must follow suit");
        printGreenGenericLn("Note that Comparator only knows the type from the left hand side of assignment");
        printGreenGenericLn(
            "This means that in the lambda flow declaration, it is not possible to define a Comparator, thenComparing. The lambda will identify an Object only");
    }
}
