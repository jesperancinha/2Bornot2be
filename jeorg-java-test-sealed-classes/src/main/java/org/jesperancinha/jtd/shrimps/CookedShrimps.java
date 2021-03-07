package org.jesperancinha.jtd.shrimps;

public record CookedShrimps() implements Shrimps {

    @Override
    public String toString() {
        return "I'm a prawn and I'm cooked!";
    }

    @Override
    public String wrapInABox() {
        return "All the cooked prawns are wrapped!";
    }
}
