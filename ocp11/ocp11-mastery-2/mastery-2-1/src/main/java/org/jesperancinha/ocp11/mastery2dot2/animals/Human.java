package org.jesperancinha.ocp11.mastery2dot2.animals;

import org.jesperancinha.console.consolerizer.Consolerizer;

public abstract class Human extends Mamal {

    private String instrument;
    public String name;

    public Human(String instrument) throws NoBlahException {
        this.instrument = instrument;
        if(instrument.equals("blah")){
            throw new NoBlahBlahBlahException();
        }
    }

    @Override
    public void saySomething() {
        Consolerizer.printGreenGeneric("Ih ih ih\n");
    }

    @Override
    public String found() {
        return "House";
    }

    @Override
    public String getInstrument() {
        return instrument;
    }

    @Override
    public String toString() {
        return "Human{" +
                "instrument='" + instrument + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
