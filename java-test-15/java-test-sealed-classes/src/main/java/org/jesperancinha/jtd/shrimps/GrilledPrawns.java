package org.jesperancinha.jtd.shrimps;

public record GrilledPrawns() implements Prawns {
    @Override
    public String toString() {
        return "I'm a prawn and I'm grilled!";
    }

    @Override
    public String wrapInABox() {
        return "All the grilled prawns are wrapped!";
    }
}
