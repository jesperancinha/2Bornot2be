package org.jesperancinha.ocp11.comparing.thencomparing;

public class Film {
    private final String title;
    private final String leadingRole;
    private final Integer year;
    private final Float rottenTomatoes;

    public Film(String title, String leadingRole, Integer year, Float rottenTomatoes){
        this.title = title;
        this.leadingRole = leadingRole;
        this.year = year;
        this.rottenTomatoes = rottenTomatoes;
    }

    public String getTitle() {
        return title;
    }

    public String getLeadingRole() {
        return leadingRole;
    }

    public Integer getYear() {
        return year;
    }

    public Float getRottenTomatoes() {
        return rottenTomatoes;
    }

    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", leadingRole='" + leadingRole + '\'' +
                ", year=" + year +
                ", rottenTomatoes=" + rottenTomatoes +
                '}'+'\n';
    }
}
