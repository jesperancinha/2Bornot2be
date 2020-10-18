package org.jesperancinha.ocp11.intermediate.operations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Never forget that intermediate operations do not generate output.
 * In fact they don't even run without a terminal operation.
 */
public class IntermediateRunner {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("Ella Fitzgerald", "Gloria Gaynor", "Aretha Franklin");
        str.stream().filter(name -> {
            System.out.println(name + " ");
            return name.startsWith("A");
        });
        System.out.println("See? Nothing gets printed!");
        System.out.println("However once a terminal operation is called we then see:");
        List<String> str2 = Arrays.asList("Ella Fitzgerald", "Gloria Gaynor", "Aretha Franklin");
        str2.stream().filter(name -> {
            System.out.println(name + " ");
            return name.startsWith("A");
        }).count();
        System.out.println("Collect is also a way to see results:");
        List<String> str3 = Arrays.asList("Ella Fitzgerald", "Gloria Gaynor", "Aretha Franklin");
        List<String> filteredStrings = str3.stream().filter(name -> {
            System.out.println(name + " ");
            return name.startsWith("A");
        }).collect(Collectors.toList());
        System.out.println(filteredStrings);
    }
}
