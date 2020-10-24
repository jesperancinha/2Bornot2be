package org.jesperancinha.ocp11.any.match;

import java.util.Arrays;

public class AnyMatchRunner {
    public static void main(String[] args) {
        final String quickBrownFox = "The quick brown fox jumps over the lazy dog";
        boolean found = Arrays.stream(quickBrownFox.split(" ")).anyMatch(s -> s.contains("o"));
        System.out.println(found);
        System.out.println("It did jump didn't?");
    }
}
