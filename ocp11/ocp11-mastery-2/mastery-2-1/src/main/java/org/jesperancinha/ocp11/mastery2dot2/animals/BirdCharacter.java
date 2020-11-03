package org.jesperancinha.ocp11.mastery2dot2.animals;

import org.jesperancinha.console.consolerizer.Consolerizer;

public class BirdCharacter extends Bird {

    public final String name;

    public BirdCharacter(String name) {
        this.name = name;
    }

    @Override
    public void saySomething() {
        Consolerizer.printGreenGeneric("Quack Quack");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String found() {
        return "pond";
    }
}
