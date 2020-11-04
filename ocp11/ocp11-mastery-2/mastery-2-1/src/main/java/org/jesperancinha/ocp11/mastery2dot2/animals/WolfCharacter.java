package org.jesperancinha.ocp11.mastery2dot2.animals;

public class WolfCharacter extends Wolf {

    public WolfCharacter(String name) {
        super("French horns");
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public static class Food{

    }
}
