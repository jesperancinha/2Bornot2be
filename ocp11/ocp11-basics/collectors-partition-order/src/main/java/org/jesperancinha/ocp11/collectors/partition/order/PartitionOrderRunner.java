package org.jesperancinha.ocp11.collectors.partition.order;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Note that the false partition always comes first.
 */
public class PartitionOrderRunner {
    public static void main(String[] args) {
        List<Integer> randomNumbers = List.of(33, 40, 42, 222, 666);

        Predicate<Integer> test1 = x -> x < 40;

        randomNumbers.stream()
                .collect(Collectors.partitioningBy(test1, Collectors.counting()))
                .values()
                .forEach(System.out::println);

    }
}
