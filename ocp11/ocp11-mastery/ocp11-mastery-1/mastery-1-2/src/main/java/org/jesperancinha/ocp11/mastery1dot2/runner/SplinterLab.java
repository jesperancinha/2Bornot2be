package org.jesperancinha.ocp11.mastery1dot2.runner;

import org.jesperancinha.console.consolerizer.Consolerizer;

public class SplinterLab extends Lab {

    // 5. Return type in overriden methods
    @Override
    MutantTurtle doExperiment() throws InterruptedException {
        Consolerizer.printGreenGeneric("We are creating a mutant!");
        return new MutantTurtle();
    }

    public class SecretLab extends SplinterLab {
        public SplinterLab getLab() throws InterruptedException {
            Consolerizer.printGreenGeneric("This lab is your lab so you are calling your own lab! \n");
            return this;
        }
    }

    public class Erlenmeyer extends Glass {

    }

    private class Glass extends Shape {

    }
}
