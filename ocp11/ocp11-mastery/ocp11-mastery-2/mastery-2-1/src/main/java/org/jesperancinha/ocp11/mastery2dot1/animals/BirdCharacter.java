package org.jesperancinha.ocp11.mastery2dot1.animals;

import org.jesperancinha.console.consolerizer.Consolerizer;

public class BirdCharacter extends Bird {

    public BirdCharacter(String name) {
        super("Flute");
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
