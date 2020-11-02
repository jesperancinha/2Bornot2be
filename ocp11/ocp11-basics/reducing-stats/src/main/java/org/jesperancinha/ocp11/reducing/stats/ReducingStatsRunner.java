package org.jesperancinha.ocp11.reducing.stats;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class ReducingStatsRunner {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    /**
     * 1. Wrong test
     * reduce returns an optional which cannot be directly printed.
     */
    private static void test1() {
        IntStream intStream = createIntStream();
        OptionalInt reduce = intStream.reduce((a, b) -> a + 1);
        System.out.println(reduce);
    }

    /**
     * 2. Good test
     * reduce returns an optional which cannot be directly printed.
     */
    private static void test2() {
        IntStream intStream = createIntStream();
        int reduce = intStream.reduce(0, (a, b) -> a + b);
        System.out.println(reduce);
    }

    /**
     * 2. Good test but shorter
     * reduce returns an optional which cannot be directly printed.
     */
    private static void test3() {
        IntStream intStream = createIntStream();
        int reduce = intStream.reduce(0, Integer::sum);
        System.out.println(reduce);
    }

    /**
     * 4. Wrong test
     * reduce returns an {@link OptionalInt} which is not related to {@link Optional}
     * Also no test if a value actually exists in the {@link OptionalInt}
     */
    private static void test4() {
//        IntStream intStream = createIntStream();
//        Optional reduce = intStream.reduce((a, b) -> a + b);
//        System.out.println(reduce.getAsInt);
        IntStream intStream = createIntStream();
        OptionalInt reduce = intStream.reduce(Integer::sum);
        System.out.println(reduce.getAsInt());
    }

    /**
     * 5. Good test
     * orElse works with {@link OptionalInt} just as well as in {@link Optional}, though they are different methods
     */
    private static void test5() {

        IntStream intStream = createIntStream();
        OptionalInt reduce = intStream.reduce(Integer::sum);
        System.out.println(reduce.orElse(0));
    }

    private static IntStream createIntStream() {
        Integer[] ciphersInEurope = new Integer[]{
                5823,
                3371,
                5465,
                3689,
                45171,
                640,
                1911,
                7170,
                22094,
                31930,
                2997,
                33776,
                302,
                989,
                1227,
                230,
                8837,
                181,
                10408,
                3884,
                23367,
                4235,
                10273,
                1248,
                2275,
                2263,
                3803,
                35361,
                124,
                11,
                2144,
                3318,
                5286,
                23546
        };

        return Arrays.stream(ciphersInEurope).mapToInt(value -> value);
    }
}
