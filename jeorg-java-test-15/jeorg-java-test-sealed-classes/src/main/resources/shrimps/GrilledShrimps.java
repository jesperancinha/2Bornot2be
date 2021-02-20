package org.jesperancinha.jtd.shrimps;

public record GrilledShrimps() implements Shrimps {
    @Override
    public String toString() {
        return "I'm a prawn and I'm grilled!";
    }

    @Override
    public String wrapInABox() {
        return "All the grilled prawns are wrapped!";
    }
}
