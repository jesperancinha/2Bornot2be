package org.jesperancinha.ocp11.streamsum;

import java.util.Arrays;
import java.util.List;

public class StreamSumRunner {
    public static void main(String[] args) {
        final List<Integer> listIntegers = Arrays.asList(1, 2, 3);

        // 1. Invoking sum from as stream
        // double sum1 = listIntegers.stream().sum();

        // 2. Reducing values
        double sum2 = listIntegers.stream().reduce(0, (a, b) -> a + b);

        // 3. Mapping to IntStream and summing
        double sum3 = listIntegers.stream().mapToInt(x -> x).sum();

        // 4. Summing outside
        // double sum4 = 0;
        // listIntegers.stream().forEach(x -> { sum4 = sum4 + x; });

        // 5. Summing with peeking
        // double sum5 = 0;
        // listIntegers.stream().peek(x-> {sum5 = sum5 + x;}).forEach(y->{});
    }
}
