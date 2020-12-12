package org.jesperancinha.ocp11.mastery1dot2.runner;

import org.jesperancinha.console.consolerizer.Consolerizer;

public class Turtle {
    protected void feelHand() throws InterruptedException {
        Consolerizer.printGreenGeneric("Feels alive!\n");
    }

    public void sneakyFeelHand() throws InterruptedException {
        feelHand();
    }
}
