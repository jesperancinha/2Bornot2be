package org.jesperancinha.ocp11.mastery1dot2.runn1er;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.ocp11.mastery1dot2.runner.MutantTurtle;

public class FailMutantTurtle extends MutantTurtle {
    public void feelHandOfAnotherTurtleSneaky() throws InterruptedException {
        new MutantTurtle().sneakyFeelHand();
    }

    public void feelHandOfAnotherTurtle() throws InterruptedException {
        Consolerizer.printGreenGeneric("Here we don't need to be sneaky!\n");
        Consolerizer.printRedGeneric("Not neaky!\n");
        super.feelHand();
    }
}
