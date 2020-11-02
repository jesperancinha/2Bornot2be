package org.jesperancinha.ocp11.lambda.celestial;

public class CelestialData {
    final String[] celestials;
    final String author;
    final Integer birthYear;
    final Integer endYear;

    public CelestialData(final String author, final Integer birthYear, final Integer endYear, final String... celestials) {
        this.author = author;
        this.birthYear = birthYear;
        this.endYear = endYear;
        this.celestials = celestials;
    }
}
