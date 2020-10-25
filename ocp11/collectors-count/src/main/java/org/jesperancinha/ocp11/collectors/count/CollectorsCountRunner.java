package org.jesperancinha.ocp11.collectors.count;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsCountRunner {
    public static void main(String[] args) {
        List<String> blames = Arrays.asList("Rochelle Perts", "Pierre Bouvier", "Ioana Ignat", "Annelies Kruidenier");
        int count = blames.stream()
                .map(s -> s.split(" "))
                .flatMap(Stream::of)
                .filter(s -> s.startsWith("I"))
                .collect(Collectors.counting()).intValue();
        long countLong = blames.stream()
                .map(s -> s.split(" "))
                .flatMap(Stream::of)
                .filter(s -> s.startsWith("I"))
                .collect(Collectors.counting());
        long countSimplified = blames.stream()
                .map(s -> s.split(" "))
                .flatMap(Stream::of)
                .filter(s -> s.startsWith("I")).count();
        System.out.printf("There are %d words that start with an I\n", count);
        System.out.printf("There are %d words that start with an I\n", countLong);
        System.out.printf("There are %d words that start with an I\n", countSimplified);
    }
}
