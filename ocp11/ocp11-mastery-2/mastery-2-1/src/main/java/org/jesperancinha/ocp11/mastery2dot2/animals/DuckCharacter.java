package org.jesperancinha.ocp11.mastery2dot2.animals;

public class DuckCharacter extends Bird {

    public DuckCharacter(String name) {
        super("Oboe");
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String found() {
        return "Forest";
    }
}
