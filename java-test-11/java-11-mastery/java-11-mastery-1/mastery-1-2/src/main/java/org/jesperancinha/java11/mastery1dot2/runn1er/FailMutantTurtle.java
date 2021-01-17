package org.jesperancinha.java11.mastery1dot2.runn1er;

import org.jesperancinha.java11.mastery1dot2.runner.MutantTurtle;

import static org.jesperancinha.console.consolerizer.ConColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConColor.RED;

public class FailMutantTurtle extends MutantTurtle {
    public void feelHandOfAnotherTurtleSneaky() throws InterruptedException {
        new MutantTurtle().sneakyFeelHand();
    }

    public void feelHandOfAnotherTurtle() throws InterruptedException {
        GREEN.printGeneric("Here we don't need to be sneaky!\n");
        RED.printGeneric("Not neaky!\n");
        super.feelHand();
    }
}
