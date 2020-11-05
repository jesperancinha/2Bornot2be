package org.jesperancinha.ocp11.mastery2dot1.animals;

import org.jesperancinha.console.consolerizer.Consolerizer;

public abstract class Wolf extends Mamal {

    private String instrument;
    public String name;

    public Wolf(String instrument) {
        this.instrument = instrument;
    }

    @Override
    public void saySomething() {
        Consolerizer.printGreenGeneric("Roar!!!\n");
    }

    @Override
    public String found() {
        return "forest";
    }

    @Override
    public String getInstrument() {
        return instrument;
    }

    @Override
    public String toString() {
        return "Wolf{" +
                "instrument='" + instrument + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
