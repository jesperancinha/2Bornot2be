package org.jesperancinha.ocp11.groupingby.math;

public class MathematicianCentury {
    private final String name;
    private final Integer century;

    public MathematicianCentury(final String name, final Integer century) {
        this.name = name;
        this.century = century;
    }

    public String getName() {
        return name;
    }

    public Integer getCentury() {
        return century;
    }
}
