package org.jesperancinha.ocp11.lambda.film;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.jesperancinha.ocp11.lambda.film.FilmGenre.BIOGRAPHY;
import static org.jesperancinha.ocp11.lambda.film.FilmGenre.DRAMA;
import static org.jesperancinha.ocp11.lambda.film.FilmGenre.HISTORY;
import static org.jesperancinha.ocp11.lambda.film.FilmGenre.ROMANCE;
import static org.jesperancinha.ocp11.lambda.film.FilmRating.R;

public class LambdaFilmRunner {
    public static void main(String[] args) {
        List<Film> movies = Arrays.asList(
                new Film("Anna Karenina", R, DRAMA, ROMANCE),
                new Film("On the Basis of Sex", R, BIOGRAPHY, DRAMA),
                new Film("Marie Curie: The Courage of Knowledge", R, BIOGRAPHY, DRAMA, ROMANCE),
                new Film("Hidden Figures", R, BIOGRAPHY, DRAMA, HISTORY),
                new Film("Elizabeth", R, BIOGRAPHY, DRAMA, HISTORY)
        );
        System.out.println("We will get nothing here. We only created a stream, but we have done nothing with it.");
        Stream<String> stringStream = movies.stream()
                .filter(mov -> mov.getRating() == R)
                .peek(mov -> System.out.println(mov.getTitle()))
                .map(Film::getTitle);

        System.out.println("When we ask for a result, we finally run the stream, which means that peek will be called.");
        Optional<String> first = movies.stream()
                .filter(mov -> mov.getRating() == R)
                .peek(mov -> System.out.println(mov.getTitle()))
                .map(Film::getTitle)
                .findFirst();
        System.out.println("With findFirst we were able to get the first result");
    }
}
