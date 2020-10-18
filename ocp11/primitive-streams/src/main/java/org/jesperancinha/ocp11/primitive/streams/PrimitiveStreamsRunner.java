package org.jesperancinha.ocp11.primitive.streams;

import java.util.List;
import java.util.function.DoubleFunction;
import java.util.function.IntFunction;
import java.util.function.LongFunction;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Primitive streams are ideal to spare on boxing and unboxing operations.
 */
public class PrimitiveStreamsRunner {
    public static void main(String[] args) {
        IntFunction<String> functionA = a -> "WOW" + a * a;
        List<String> collectA = IntStream.of(1, 2, 3, 4).mapToObj(functionA).collect(Collectors.toList());
        System.out.println(collectA);

        DoubleFunction<String> functionB = b-> "BOUBLE" + b * b;
        List<String> collectB = DoubleStream.of(3.4,5.6,7.8,9.1).mapToObj(functionB).collect(Collectors.toList());
        System.out.println(collectB);

        LongFunction<String> functionC = c->"ZZZZ" + c*c;
        List<String> collectC  = LongStream.of(10000, 20000, 340000, 5000).mapToObj(functionC).collect(Collectors.toList());
        System.out.println(collectC);
    }
}
