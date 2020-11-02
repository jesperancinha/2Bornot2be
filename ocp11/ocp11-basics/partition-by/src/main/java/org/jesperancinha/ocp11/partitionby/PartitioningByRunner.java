package org.jesperancinha.ocp11.partitionby;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
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
public class PartitioningByRunner {
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

        Map<Boolean, List<String>> collect = peopleInTech.keySet().stream()
                .collect(
                        Collectors.partitioningBy(x->peopleInTech.get(x)> 10)
        );

        // Showing the results
        collect.forEach((megaAchiever, strings) -> {
            if(megaAchiever){
                System.out.printf("These are mega achievers! %s%n", String.join(",", strings));
            } else {
                System.out.printf("These are fine achievers! %s%n", String.join(",", strings));
            }
        });
    }

}
