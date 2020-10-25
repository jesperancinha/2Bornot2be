package org.jesperancinha.ocp11.streamsum;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;

public class StreamSumRunner {
    public static void main(String[] args) {
        final List<Integer> listIntegers = Arrays.asList(1, 2, 3);

        // 1. Invoking sum from as stream
        // double sum1 = listIntegers.stream().sum();

        // 2. Reducing values
        double sum2 = listIntegers.stream().reduce(0, (a, b) -> a + b);
        System.out.printf("listIntegers.stream().reduce(0, (a, b) -> a + b); %f \n", sum2);

        // 3. Mapping to IntStream and summing
        double sum3 = listIntegers.stream().mapToInt(x -> x).sum();
        System.out.printf("listIntegers.stream().mapToInt(x -> x).sum(); %f\n", sum3);

        // 4. Summing outside
        // double sum4 = 0;
        // listIntegers.stream().forEach(x -> { sum4 = sum4 + x; });

        // 5. Summing with peeking
        // double sum5 = 0;
        // listIntegers.stream().peek(x-> {sum5 = sum5 + x;}).forEach(y->{});

        // 6. Summing with a Double stream
        var doubleStream = DoubleStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        double sum6 = doubleStream.filter(x -> x % 3 == 0).sum();
        System.out.printf("doubleStream.filter(x -> x %% 3 == 0).sum(); %f\n", sum6);

    }
}
