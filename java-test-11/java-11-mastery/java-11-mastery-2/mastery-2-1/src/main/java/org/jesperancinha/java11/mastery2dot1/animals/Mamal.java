package org.jesperancinha.java11.mastery2dot1.animals;

import org.jesperancinha.console.consolerizer.Consolerizer;

public abstract class Mamal implements Animal {
    @Override
    public void saySomething() {
        Consolerizer.printGreenGeneric("You still didn't implement me!");
    }
}
