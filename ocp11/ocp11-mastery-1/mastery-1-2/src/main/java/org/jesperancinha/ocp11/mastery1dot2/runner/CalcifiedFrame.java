package org.jesperancinha.ocp11.mastery1dot2.runner;

import org.jesperancinha.console.consolerizer.Consolerizer;

public interface CalcifiedFrame {
    default void protectTheShell() {
        Consolerizer.printGreenGeneric("CalcifiedFrame");
    }
}
