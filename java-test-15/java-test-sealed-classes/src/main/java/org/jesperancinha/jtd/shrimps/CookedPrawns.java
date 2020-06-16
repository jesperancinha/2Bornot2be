package org.jesperancinha.jtd.shrimps;

public record CookedPrawns() implements Prawns {

    @Override
    public String toString() {
        return "I'm a prawn and I'm cooked!";
    }

    @Override
    public String wrapInABox() {
        return "All the cooked prawns are wrapped!";
    }
}
