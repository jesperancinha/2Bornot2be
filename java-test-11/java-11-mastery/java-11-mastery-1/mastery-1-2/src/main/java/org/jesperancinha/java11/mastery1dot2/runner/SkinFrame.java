package org.jesperancinha.java11.mastery1dot2.runner;

import static org.jesperancinha.console.consolerizer.ConColor.GREEN;

public interface SkinFrame {
    default void protectTheShell() {
        GREEN.printGeneric("SkinFrame");
    }
}
