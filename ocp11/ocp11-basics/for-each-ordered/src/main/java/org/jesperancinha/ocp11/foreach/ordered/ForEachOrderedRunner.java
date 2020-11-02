package org.jesperancinha.ocp11.foreach.ordered;

import java.util.Arrays;
import java.util.List;

public class ForEachOrderedRunner {
    public static void main(String[] args) {
        Character[] ca = {'z', 'y', 'x', 'w', 'v'};
        List<Character> l = Arrays.asList(ca);
        l.parallelStream().peek(System.out::print).forEachOrdered(System.out::print);
        System.out.println("");
        l.parallelStream().peek(System.out::print).forEachOrdered(System.out::print);
        System.out.println("");
        l.parallelStream().peek(System.out::print).forEachOrdered(System.out::print);
        System.out.println("");
        l.parallelStream().peek(System.out::print).forEachOrdered(System.out::print);
        System.out.println("");

        System.out.println("Now let's examine this in more detail:");
        l.parallelStream().peek(c -> System.out.printf("$%c", c)).forEachOrdered(c -> System.out.printf("#%c", c));
        System.out.println("");
        l.parallelStream().peek(c -> System.out.printf("$%c", c)).forEachOrdered(c -> System.out.printf("#%c", c));
        System.out.println("");
        l.parallelStream().peek(c -> System.out.printf("$%c", c)).forEachOrdered(c -> System.out.printf("#%c", c));
        System.out.println("");
        l.parallelStream().peek(c -> System.out.printf("$%c", c)).forEachOrdered(c -> System.out.printf("#%c", c));
        System.out.println("Check the #. Do you see anything? Notice that the order is always the same.");


    }
}
