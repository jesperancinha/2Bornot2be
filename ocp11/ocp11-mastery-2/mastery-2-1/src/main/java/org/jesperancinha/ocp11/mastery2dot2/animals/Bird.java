package org.jesperancinha.ocp11.mastery2dot2.animals;

import org.jesperancinha.console.consolerizer.Consolerizer;

public abstract class Bird implements Animal {

    @Override
    public void saySomething() {
        Consolerizer.printGreenGeneric("You still didn't implement me!");

    }
}
