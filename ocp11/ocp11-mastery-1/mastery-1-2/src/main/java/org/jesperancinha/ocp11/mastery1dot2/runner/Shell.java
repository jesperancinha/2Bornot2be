package org.jesperancinha.ocp11.mastery1dot2.runner;

import org.jesperancinha.console.consolerizer.Consolerizer;

//4. Default methods multi-implementation
public class Shell implements CalcifiedFrame, SkinFrame {
    public void protectTheShell() {
        Consolerizer.printGreenGeneric("We now are properly protected with CalcifiedShell and Skin\n");
    }
}
