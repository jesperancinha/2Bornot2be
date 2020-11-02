package org.jesperancinha.ocp11.streams.filter;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class StreamsFilterRunner {
    public static void main(String[] args) {
        var cast = Arrays.asList("Harry Ambrose",
                "Sonya Barzel",
                "Leela Burns",
                "Vic Soto",
                "Jamie Burns",
                "Police Chief",
                "Melanie",
                "Eli",
                "Rori Barnhill",
                "Forensics Tech",
                "NYPD Patrolperson",
                "Eddie",
                "Young Check");

        cast.sort(String::compareTo);
        System.out.println(cast);
        System.out.println("---*** Different ways to get all names with 4 length *** ---");
        System.out.println("*** Way one: Filter and parallel collect");

        var newList1 = cast.stream()
                .map(character -> character.split(" "))
                .flatMap(characters -> Arrays.stream(characters.clone()))
                .filter(character -> character.length() == 4)
                .parallel()
                .collect(Collectors.toList());

        System.out.println(newList1);
        System.out.println("*** Way two: parallel, filter and collect");

        var newList2 = cast.stream()
                .map(character -> character.split(" "))
                .flatMap(characters -> Arrays.stream(characters.clone()))
                .parallel()
                .filter(character -> character.length() == 4)
                .collect(Collectors.toList());

        System.out.println(newList2);

        System.out.println("*** Way three: vanilla");

        var newList3 = new ArrayList<>();
        cast.stream()
                .map(character -> character.split(" "))
                .flatMap(characters -> Arrays.stream(characters.clone()))
                .parallel()
                .forEach(character -> {
                    if (character.length() == 4) {
                        newList3.add(character);
                    }
                });

        System.out.println(newList3);
        System.out.println("*** Way three: vanilla ordered");

        var newList4 = new ArrayList<>();
        cast.stream()
                .map(character -> character.split(" "))
                .flatMap(characters -> Arrays.stream(characters.clone()))
                .parallel()
                .forEachOrdered(character -> {
                    if (character.length() == 4) {
                        newList4.add(character);
                    }
                });

        System.out.println(newList4);

        System.out.println("*** Way three: vanilla ordered result");

        var newList5 = new ArrayList<>();
        cast.stream()
                .map(character -> character.split(" "))
                .flatMap(characters -> Arrays.stream(characters.clone()))
                .parallel()
                .sorted()
                .forEachOrdered(character -> {
                    if (character.length() == 4) {
                        newList5.add(character);
                    }
                });

        System.out.println(newList5);
    }
}
