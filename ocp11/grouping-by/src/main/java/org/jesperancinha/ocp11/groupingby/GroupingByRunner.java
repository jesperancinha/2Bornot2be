package org.jesperancinha.ocp11.groupingby;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Number of key Awards by famous IT people
 * <p>
 * Figures taken from wikipedia on the 3rd October 2020
 * <p>
 * https://en.wikipedia.org/wiki/Dorothy_E._Denning
 * https://en.wikipedia.org/wiki/Joan_Clarke
 * https://en.wikipedia.org/wiki/Margaret_Rock
 * https://en.wikipedia.org/wiki/Katherine_Johnson
 * https://en.wikipedia.org/wiki/Mary_Lou_Jepsen
 * https://en.wikipedia.org/wiki/Shafi_Goldwasser
 * https://en.wikipedia.org/wiki/Annie_Easley
 * https://en.wikipedia.org/wiki/Danielle_George
 * <p>
 * Notice that the grouping is especially made complicated to make it clear how the collector in grouping works.
 */
public class GroupingByRunner {
    public static void main(String[] args) {
        var peopleInTech = Map.of(
                "Dorothy Denning", 8,
                "Joan Clarke", 0,
                "Margaret Rock", 0,
                "Katherine Johnson", 22,
                "Mary Lou Jepsen", 10,
                "Shafi Goldwasser", 20,
                "Annie Easley", 0,
                "Danielle George", 4);

        Map<String, Integer> collect = peopleInTech.keySet().stream().collect(Collectors.groupingBy(x -> {
                    if (peopleInTech.get(x) == 0) {
                        return "ZERO";
                    } else if (peopleInTech.get(x) <= 10) {
                        return "TENNERS";
                    } else if (peopleInTech.get(x) > 10) {
                        return "COOL";
                    }
                    return "NONE";
                }, Collectors.summingInt(x -> 1)
        ));
        System.out.println(collect);
    }
}
