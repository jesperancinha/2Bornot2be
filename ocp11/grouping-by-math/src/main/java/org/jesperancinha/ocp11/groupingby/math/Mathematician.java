package org.jesperancinha.ocp11.groupingby.math;

public class Mathematician {
    private final String name;
    private final Integer birthYear;
    private final Integer endYear;

    public Mathematician(final String name, final Integer birthYear, final Integer endYear) {
        this.name = name;
        this.birthYear = birthYear;
        this.endYear = endYear;
    }

    public String getName() {
        return name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }
}
