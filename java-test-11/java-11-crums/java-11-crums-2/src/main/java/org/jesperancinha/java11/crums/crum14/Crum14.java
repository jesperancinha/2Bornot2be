package org.jesperancinha.java11.crums.crum14;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Crum14 {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 14 - Creating a list from an array");

        final Integer[] array = new Integer[] { 1, 2, 3, 4, 5, 6, 7 };

        var listOfArray1 = List.of(array);
        var listOfArray2 = Arrays.asList(array);

        printMagentaGenericLn("We start out from array %s", Arrays.stream(array)
            .collect(Collectors.toList()));
        printBrightMagentaGenericLn("We have these lists:");
        printYellowGenericLn(listOfArray1);
        printYellowGenericLn(listOfArray2);

        printMagentaGenericLn("If we change the source array:");
        array[0] = 9;
        printMagentaGenericLn(Arrays.stream(array)
            .collect(Collectors.toList()));

        printBrightMagentaGenericLn("Checking any of our lists again we should not have the same values:");
        printYellowGenericLn(listOfArray1);
        printYellowGenericLn(listOfArray2);

        final int array2[] = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };

        var listOfArray3 = List.of(array2);
        var listOfArray4 = Arrays.asList(array2);

        printBrightMagentaGenericLn(
            "Last curiosity is if we try to creatr the same Lists from an array of primitive values:");
        printYellowGenericLn(listOfArray3);
        printYellowGenericLn(listOfArray4);

        printMagentaGenericLn("Notice that we didn't create a list of Integers");
        printMagentaGenericLn(listOfArray3.get(0));
        printMagentaGenericLn("Instead, we have created a List of an array of integers");
        printMagentaGenericLn(
            "This is because Generic Lists are prepared to work with objects and ca interpret an array of objects");
        printMagentaGenericLn("They do not, however interpret an array of primitive values such as int.");

        // Type argument cannot be of primitive type
        // List<int> abc = new ArrayList<>();

        printGreenGenericLn(
            "The first list isn't changed. We must never forget that List.of returns an unmutable ArrayList.");
        printGreenGenericLn(
            "The second list changes because ArrayList is mutable and had been created initially from the source array, which stays in memory");

    }
}
