package org.jesperancinha.java11.crums.crum18;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;

public class Crum18 {

    public static class Plate {
        private final String design;
        private final LocalDateTime localDateTime;

        public Plate(String design, LocalDateTime localDateTime) {
            this.design = design;
            this.localDateTime = localDateTime;
        }

        public LocalDateTime getLocalDateTime() {
            return localDateTime;
        }

        public String getDesign() {
            return design;
        }

        @Override
        public String toString() {
            return "Plate{" + "design='" + design + '\'' + ", localDateTime=" + localDateTime + '}';
        }
    }

    public static void main(String[] args) {

        BLUE.printGenericTitleLn("Crum 18 - Understanding Comparator and Comparable");

        final Comparator<Plate> comparator = (p1, p2) -> p1.getDesign()
            .compareTo(p2.getDesign());
        final Comparator<Plate> comparator2 = Comparator.comparing(Plate::getDesign);
        final Comparator<Plate> comparator3 = comparator2.thenComparing(Comparator.comparing(Plate::getLocalDateTime));

        final var streamOfInts = IntStream.of(12, 44, 22, 73, 94, 12, 54);
        final Comparator<Integer> compareTo = Integer::compareTo;
        streamOfInts.boxed()
            .max(compareTo);

        MAGENTA.printGenericLn("The first thing to understand is that Numberic Object and Strings are comparables:");
        printOrangeGenericLn("Integer -> %s ", Integer.valueOf(100) instanceof Comparable);
        printOrangeGenericLn("Double -> %s ", Double.valueOf(100) instanceof Comparable);
        printOrangeGenericLn("Float -> %s ", Float.valueOf(100) instanceof Comparable);
        printOrangeGenericLn("Byte -> %s ", Byte.valueOf((byte) 100) instanceof Comparable);
        printOrangeGenericLn("Short -> %s ", Short.valueOf((short) 100) instanceof Comparable);
        printOrangeGenericLn("Character -> %s ", Character.valueOf((char) 100) instanceof Comparable);
        printOrangeGenericLn("String -> %s ", "Whatevever" instanceof Comparable);

        MAGENTA.printGenericLn("This means that they all implement method compareTo");

        MAGENTA.printGenericLn("In lambda experssions, when we implement Comparators and use the standard compareTo, we can do that because the elements are Comparable");

        MAGENTA.printGenericLn("In our list of plates we have:");

        var plateList = List.of(new Plate("Chinese Porcelain", LocalDateTime.now()),
            new Plate("Delft Porcelain", LocalDateTime.now()), new Plate("Braga Porcelain", LocalDateTime.now()));

        printOrangeGenericLn(plateList);

        MAGENTA.printGenericLn("If we sort by the first comparator we've made, we find:");
        printOrangeGenericLn(plateList.stream()
            .sorted(comparator)
            .collect(Collectors.toList()));

        MAGENTA.printGenericLn("If we sort by the second comparator we've made, we find:");
        printOrangeGenericLn(plateList.stream()
            .sorted(comparator2)
            .collect(Collectors.toList()));

        MAGENTA.printGenericLn("If we sort by the third comparator we've made, we find:");
        printOrangeGenericLn(plateList.stream()
            .sorted(comparator3)
            .collect(Collectors.toList()));

        GREEN.printGenericLn("A Comparator is not a Comparable");
        GREEN.printGenericLn("We compare with comparables");
        GREEN.printGenericLn("Comparable is an interface");
        GREEN.printGenericLn("Comparator is a functional interface, which receives two arguments of the same type and return an int");
        GREEN.printGenericLn("The int represents a form of distance between the two comparable objects");
        GREEN.printGenericLn("The original compareTo method is an implementation of the Comparator functional interface");

    }
}
