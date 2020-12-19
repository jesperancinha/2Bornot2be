package org.jesperancinha.ocp11.flashmodule.module3;

import org.jesperancinha.console.consolerizer.Consolerizer;

import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowStack;

public class FlashModule3 {
    public static void main(String[] args) {
        printRainbowStack("You are running Flash Module 3");
        printOrangeGenericLn("You can run a module and specify where the modules are using:");
        printRainbowStack("-p");
        printRainbowStack("--module-path");
        printGreenGenericLn("-p and --module-path are the same");
        printRainbowStack("-p and --module-path are the same and specify where the modules are");
        printRainbowStack("You can specify the folder where they are and/or the jars directly separated by colon");
        printGreenGenericLn("This is valid for compile (javac) and running (java)");
        printGreenGenericLn("This is valid for compile (javac) and running (java)");
        printGreenGenericLn("This is valid for compile (javac) and running (java)");
        printGreenGenericLn("This is valid for compile (javac) and running (java)");
    }
}
