package org.jesperancinha.java11.mastery1dot2.runner;

import org.jesperancinha.console.consolerizer.Consolerizer;

public interface SkinFrame {
    default void protectTheShell() {
        Consolerizer.printGreenGeneric("SkinFrame");
    }
}
