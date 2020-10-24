package org.jesperancinha.ocp11.foreach.ordered.part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ForEachOrdered2Runner {
    public static void main(String[] args) {
        List<String> allCharacters = Arrays.asList(
                "Jessica Fletcher",
                "Bernie",
                "Kitty Donovan",
                "Peter Brill",
                "George",
                "Louise McCallum",
                "Grady Fletcher",
                "Ashley Vickers",
                "Dexter Baxendale",
                "Doctor",
                "Chief Roy Gunderson",
                "Preston Giles",
                "Caleb McCallum",
                "Eleanor Thompson",
                "Lois Hoey");
        allCharacters.sort(Comparator.naturalOrder());
        System.out.println("**** Ordered, but names are inserted in the wrong order ****");
        List<String> newList= Collections.synchronizedList(new ArrayList<>());
        allCharacters.parallelStream()
                .peek(newList::add)
                .forEachOrdered(System.out::println);
        System.out.println("**** Unordered ****");
        newList.stream()
                .forEach(System.out::println);
        System.out.println("**** Ordered, and names are inserted in the right order ****");
        List<String> newList2= Collections.synchronizedList(new ArrayList<>());
        allCharacters.stream()
                .peek(newList2::add)
                .forEachOrdered(System.out::println);
        System.out.println("**** Ordered  ****");
        newList2.stream()
                .forEach(System.out::println);
    }
}
