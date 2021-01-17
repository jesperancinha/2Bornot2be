package org.jesperancinha.java11.mastery1dot2.runn1er;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.java11.mastery1dot2.runner.MutantTurtle;

import static org.jesperancinha.console.consolerizer.ConColor.GREEN;

public class FailMutantTurtle extends MutantTurtle {
    public void feelHandOfAnotherTurtleSneaky() throws InterruptedException {
        new MutantTurtle().sneakyFeelHand();
    }

    public void feelHandOfAnotherTurtle() throws InterruptedException {
        GREEN.printGeneric("Here we don't need to be sneaky!\n");
        Consolerizer.printRedGeneric("Not neaky!\n");
        super.feelHand();
    }
}
