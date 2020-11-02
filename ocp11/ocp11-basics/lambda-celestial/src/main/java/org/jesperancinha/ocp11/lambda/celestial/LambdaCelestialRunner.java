package org.jesperancinha.ocp11.lambda.celestial;

import java.util.Arrays;
import java.util.List;

/**
 * Notice the different ways in which you can create lambdas
 *
 * Info taken from wikipedia on 2020/10/04:
 *
 * https://en.wikipedia.org/wiki/Maria_Mitchell
 * https://en.wikipedia.org/wiki/Nicole-Reine_Lepaute
 * https://en.wikipedia.org/wiki/Anna_Winlock
 */
public class LambdaCelestialRunner {
    public static void main(String[] args) {
        var data1 = new CelestialData("Anna Winlock", 1857, 1904, "433 Eros", "475 Ocllo");
        var data2 = new CelestialData("Nicole-Reine Lepaute", 1723, 1788, "Halley");
        var data3 = new CelestialData("Maria Mitchell", 1818, 1889, "C/1847 T1");

        var allData = Arrays.asList(data1, data2, data3);

        System.out.println("Just the data");
        processList(allData, (a, b, c, d) -> System.out.println(a + b + c + String.join("and", d)));

        System.out.println("\nA true story");
        processList(allData, (a, b, c, d) ->
                System.out.printf(
                        "%s worked in the astronomy sector and lived through years between %d and %d. " +
                                "The resulting work focused on celestial bodies %s\n", a, b, c,
                        String.join(" and ", d)));

        System.out.println("\nThe liars story");
        processList(allData, (a, b, c, d) ->
                System.out.printf(
                        "%s never worked in the astronomy sector! The celestial bodies %s were discovered by me in 2004!!!\n", a, String.join(" and ", d)));


        System.out.println("\nAnother true story");
        processList(allData, (String a, Integer b, Integer c, String[] d) ->
                System.out.printf(
                        "%s worked in the astronomy sector and lived through years between %d and %d. " +
                                "The resulting work focused on celestial bodies %s\n", a, b, c,
                        String.join(" and ", d)));

        System.out.println("\nYet another true story");
        processList(allData, (String a, Integer b, Integer c, String[] d) ->
        {
            System.out.printf(
                    "%s worked in the astronomy sector and lived through years between %d and %d. " +
                            "The resulting work focused on celestial bodies %s\n", a, b, c,
                    String.join(" and ", d));
        });

        System.out.println("\nStill another true story");
        processList(allData, (a, b, c, d) ->
        {
            System.out.printf(
                    "%s worked in the astronomy sector and lived through years between %d and %d. " +
                            "The resulting work focused on celestial bodies %s\n", a, b, c,
                    String.join(" and ", d));
        });
    }

    public static void processList(List<CelestialData> dataList, Work w) {
        for (CelestialData celestialData : dataList) {
            w.showWork(celestialData.author, celestialData.birthYear, celestialData.endYear, celestialData.celestials);
        }
    }
}
