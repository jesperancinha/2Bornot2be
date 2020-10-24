package org.jesperancinha.ocp11.predicates.part2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Predicates2Runner {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(42, 666, 222, 33);
        Predicate<Integer> parityChecker = (Integer number) -> number % 2 ==0;
        // If the input parameter of the lambda predicate is defined to be an Integer,
        // then this must also define the type of lambda.
        // Predicate rightAnswerChecker = (Integer number) -> number == 42;
        Predicate<Integer> rightAnswerChecker = (Integer number) -> number == 42;
        long count = values.stream().filter(parityChecker).filter(rightAnswerChecker).count();
        System.out.printf("There are %d right answers!", count);
    }
}
