package org.jesperancinha.ocp11.average;

import java.util.List;

public class AverageRunner {
    public static void main(String[] args) {
        var values = List.of(123, 456, 789);

        var average1 = values.stream().mapToInt(x -> x).average().getAsDouble();
        var average2 = values.stream().mapToDouble(x -> x).average().getAsDouble();
        var average3 = values.stream().mapToLong(x -> x).average().getAsDouble();

        var average4 = values.parallelStream().mapToInt(x -> x).average().getAsDouble();
        var average5 = values.parallelStream().mapToDouble(x -> x).average().getAsDouble();
        var average6 = values.parallelStream().mapToLong(x -> x).average().getAsDouble();

        var average7 = values.parallelStream().parallel().mapToInt(x -> x).average().getAsDouble();
        var average8 = values.parallelStream().parallel().mapToDouble(x -> x).average().getAsDouble();
        var average9 = values.parallelStream().parallel() .mapToLong(x -> x).average().getAsDouble();

        System.out.printf("Average is %f %f %f\n", average1, average2, average3);
        System.out.printf("Average is %f %f %f\n", average4, average5, average6);
        System.out.printf("Average is %f %f %f\n", average7, average8, average9);
    }
}
