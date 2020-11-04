package org.jesperancinha.ocp11.mastery2dot2.animals;

public interface Animal {
    void saySomething();

    /**
     * Although redundant, abstract is possible
     *
     * @return
     */
    public abstract String getName();

    String found();

    abstract String getInstrument();
}
