package org.jesperancinha.jtd.jee.mastery1.beans;

import java.io.Serializable;

public class Record implements Serializable {
    private String name;

    private String type;

    private String year;

    private String artist;

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getYear() {
        return year;
    }

    public String getArtist() {
        return artist;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Record{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", year='" + year + '\'' +
                ", artist='" + artist + '\'' +
                '}';
    }
}
