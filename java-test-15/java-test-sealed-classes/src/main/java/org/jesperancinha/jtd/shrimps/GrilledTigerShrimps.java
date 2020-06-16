package org.jesperancinha.jtd.shrimps;

public record GrilledTigerShrimps() implements Prawns{
    @Override
    public String toString() {
        return "I'm definitely not a prawn. I'm a tiger ... ... ! Ok, ok... I'm also a prawn 🙄";
    }

    @Override
    public String wrapInABox() {
        return "So although many people call me a shrimp, others also call me a prawn. So that's why I can also be wrapped in a box";
    }
}
