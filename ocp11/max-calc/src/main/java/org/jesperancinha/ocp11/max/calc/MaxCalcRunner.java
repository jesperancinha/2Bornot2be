package org.jesperancinha.ocp11.max.calc;

import java.util.Comparator;
import java.util.List;

public class MaxCalcRunner {
    public static void main(String[] args) {
        var integerList = List.of(4,5,33,4,5,6,7,6,9);

        // Optional
        var max1 = integerList.stream().max(Comparator.comparingInt(o -> o)).get();
        System.out.printf("Max1 -> %d\n",max1);

        // Optional
        var max2 = integerList.stream().reduce((a,b)->a>b?a:b).get();
        System.out.printf("Max2 -> %d\n",max2);

        // OptionalInt
        var max3 = integerList.stream().mapToInt(a->a).max().getAsInt();
        System.out.printf("Max3 -> %d\n",max3);

        // OptionalInt
        var average = integerList.stream().mapToInt(a->a).average().orElse(0);
        System.out.printf("Average(It's always double!) -> %f\n",average);
    }
}
