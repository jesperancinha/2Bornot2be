package org.jesperancinha.ocp11.numbers;

public class NumbersRunner {
    public static void main(String[] args) {
        int a = 1_9;
        int b = 1__34___3;
        double c = 3.444_4444_000_1;

        System.out.printf("Number %d is the same as %d\n", a, 19);
        System.out.printf("Number %d is the same as %d\n", b, 1343);
        System.out.printf("Number %f is the same as %f\n", c, 3.44444440001);
    }
}
