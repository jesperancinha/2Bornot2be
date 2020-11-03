package org.jesperancinha.ocp11.mastery2dot2.animals;

import org.jesperancinha.console.consolerizer.Consolerizer;

public class Wolf extends Mamal {
    public final String name;

    public Wolf(String name) {
        this.name = name;
    }

    @Override
    public void saySomething() {
       Consolerizer.printGreenGeneric("Roar!!!\n");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String found() {
        return "forest";
    }
}
