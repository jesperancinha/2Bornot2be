package org.jesperancinha.ocp11.functions;

import java.util.function.Function;

public class FunctionsRunner {
    public static void main(String[] args) {
        final Function<Integer, String> function1 = (a) -> Integer.toHexString(a);
        final Function<Integer, String> function2 = Integer::toHexString;
        final Function<Integer, String> function3 = (Integer a) -> Integer.toHexString(a);
        final Function<Integer, String> function4 = (a) -> {
            switch (a) {
                case 1:
                    return "Helderberg Mountain - South Africa";
                case 2:
                    return "Arabie Dam - South Africa";
                default:
                    return "Nothing";
            }
        };

        System.out.println(function1.apply(1000));
        System.out.println(function2.apply(1000));
        System.out.println(function3.apply(1000));
        System.out.println(function4.apply(1));
        System.out.println(function4.apply(2));
        System.out.println(function4.apply(3));
    }
}
