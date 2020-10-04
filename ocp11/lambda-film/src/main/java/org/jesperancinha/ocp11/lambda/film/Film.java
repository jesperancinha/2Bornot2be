package org.jesperancinha.ocp11.lambda.film;

public class Film {

    private String title;
    private FilmGenre[] filmGenres;
    private FilmRating rating;

    Film(String title, FilmRating rating, FilmGenre...filmGenres) {
        this.title = title;
        this.filmGenres = filmGenres;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public FilmRating getRating() {
        return rating;
    }

    public FilmGenre[] getFilmGenres() {
        return filmGenres;
    }
}
