package org.jesperancinha.java11.service.module;

import org.jesperancinha.console.consolerizer.Consolerizer;

import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowTitleLn;

public class ServiceModule implements ServiceInterface {
    public void detachModule(){
        printRainbowTitleLn("Apollo 13 - Service Module detached...");
    }
}
