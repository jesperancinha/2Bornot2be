package org.jesperancinha.ocp11.flatmapping.collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class FlatMappingCollectionsRunner {
    public static void main(String[] args) {
        List<String> cast = Arrays.asList(
                "Bartosz Bielenia",
                "Aleksandra Konieczn",
                "Eliza Rycembel",
                "Tomasz Zietek",
                "Barbara Kurzaj",
                "Leszek Lichota",
                "Zdzislaw Wardejn",
                "Lukasz Simlat",
                "Anna Biernacik",
                "Lidia Bogacz",
                "Malwina Brych",
                "Bogdan Brzyski",
                "Juliusz Chrzastowski",
                "Radoslaw Ciucias",
                "Mateusz Czwartosz");
        cast.sort(String::compareTo);


        List<String> characters = Arrays.asList(
                "Daniel",
                "Lidia",
                "Eliza",
                "Pinczer",
                "Ewa Kobielski - the widow",
                "Walkiewicz - the mayor",
                "Priest",
                "Father Tomasz",
                "Marta's friend",
                "Mother",
                "Girl",
                "Molinska's son",
                "Policeman",
                "Chaplain",
                "Bonus");
        characters.sort(String::compareTo);

        System.out.println("---***||||||||||| Doing it via forEach!");
        Stream.of(cast, characters).forEach(System.out::println);

        System.out.println("---***||||||||||| Doing it via flatMap and streaming each element!");
        Stream.of(cast, characters).flatMap(Stream::of).forEach(System.out::println);

        System.out.println("---***||||||||||| Doing it via flatMap and calling the stream of each element!");
        Stream.of(cast, characters).flatMap(Collection::stream).forEach(System.out::println);
    }
}
