package org.jesperancinha.ocp11.compute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ComputeRunner {
    public static void main(String[] args) {
        Map<String, List<String>> episodeCharacters = new HashMap<>();

        List<String> allCharactersEpisode0 = Arrays.asList(
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
        String episode0 = "The Murder of Sherlock Holmes";
        for (var character : allCharactersEpisode0) {
            episodeCharacters.computeIfAbsent(episode0, episode -> new ArrayList<>()).add(character);
        }

        System.out.println("This is the pilot episode");
        System.out.println(episodeCharacters);
        System.out.println("We now compute it and reset the episod to the main character");

        episodeCharacters.computeIfPresent(episode0,
                (s, strings) -> {
                    System.out.println(">>>" + s);
                    return Collections.singletonList(allCharactersEpisode0.get(0));
                });

        System.out.println(episodeCharacters);

        String episode1 = "Deadly Lady";

        List<String> allCharactersEpisode1 = Arrays.asList(
                "Jessica Fletcher",
                "Capt. Ethan Cragg",
                "Sheriff Amos Tupper",
                "Nancy Earl",
                "Ralph / Stephen Earl",
                "Maggie Earl",
                "Terry Jones",
                "Grace Earl Lamont",
                "Brian Shelby",
                "Lisa Earl Shelby",
                "Jonathan Bailey",
                "Emma",
                "Nils Andersen",
                "Elias Cobb");


        System.out.println("We try to make episode 1, but only if it exists. It will probably not work");

        List<String> episode1FirstCharacter = episodeCharacters.computeIfPresent(episode1,
                (s, strings) -> {
                    System.out.println(">>>" + s);
                    return Collections.singletonList(allCharactersEpisode0.get(0));
                });

        System.out.println(episodeCharacters);
        System.out.println("As you can see, it didn't!");
        System.out.println(episode1FirstCharacter);
        System.out.println("And of course since we couldn't do anything with IfPresent, we didn't get our first episode with the character list");
        System.out.println("Let's compute it!");

        allCharactersEpisode1.forEach(character ->
                episodeCharacters.compute(episode1, (s, strings) -> {
                    System.out.println(">>>" + s);
                    return Objects.requireNonNullElseGet(strings, ArrayList::new);
                }).add(character));

        System.out.println(episodeCharacters);
    }

}
