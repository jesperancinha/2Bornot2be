package org.jesperancinha.ocp11.consumer;


import java.util.List;
import java.util.function.Consumer;

public class ConsumerRunner {
    public static void main(String[] args) {

        option1(args);
        option2(args);
        option3(args);
        option4(args);
        option5(args);

        alternative6(args);
    }

    private static void alternative6(String[] args) {
        Consumer<String> x = (String msg) -> { System.out.println(msg);};
        List.of(args).forEach(x);
    }


    /**
     * Incompatible parameter types in lambda expression: expected Object but found String
     * List.of is creating a list of arrays of String.
     * It is not creating List of Strings
     * Check alternative 6 for the fix
     *
     * @param args {@link String[]}
     */
    private static void option5(String[] args) {
        // Consumer x = (String msg) -> { System.out.println(msg);};
        // List.of(args).forEach(x);

    }

    private static void option4(String[] args) {
        final Consumer x = (m)->{};
        List.of(args).forEach(x);
    }

    /**
     * Cannot infer type: method reference requires an explicit target type
     *
     * @param args {@link String[]}
     */
    private static void option3(String[] args) {
        // var x = System.out::println;
        // List.of(args).forEach(x);
    }

    private static void option2(String[] args) {
        final Consumer x = System.out::println;
        List.of(args).forEach(x);
    }

    /**
     * It is not a statement and so it will not work
     *
     * @param args {@link String[]}
     */
    private static void option1(String[] args) {
        // Consumer x = ()->{System.out::println;}
        // List.of(args).forEach(x);
    }
}
