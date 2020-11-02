package org.jesperancinha.ocp11.comparing.thencomparing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Let's compare stuff with then comparing.
 * <p>
 * We'll use:
 * Leading role
 * then year,
 * then rotten tomatoes score
 * finally the year.
 */
public class ThenComparingRunner {
    public static void main(String[] args) {
        List<Film> allFilms =
                Arrays.asList(
                        new Film("Evita", "Madonna", 1996, 63F),
                        new Film("Who's That Girl", "Madonna", 1987, 38F),
                        new Film("Silence of the Lambs", "Jodie Foster", 1991, 96F),
                        new Film("Shadows and the Fog", "Jodie Foster", 1991, 52F),
                        new Film("Body of Evidence", "Madonna", 1993, 8F),
                        new Film("Nell", "Jodie Foster", 1994, 55F),
                        new Film("Maverick", "Jodie Foster", 1994, 66F),
                        new Film("Dangerous Game", "Madonna", 1993, 31F)
                );

        allFilms.sort(Comparator
                .comparing(Film::getLeadingRole)
                .thenComparing(Film::getYear)
                .thenComparing(Film::getRottenTomatoes)
                .thenComparing(Film::getTitle));

        System.out.println(allFilms);
    }
}
