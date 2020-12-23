package org.jesperancinha.java11.service.module;

import org.jesperancinha.console.consolerizer.Consolerizer;

public class ServiceModule implements ServiceInterface {
    public void detachModule(){
        Consolerizer.printRainbowTitleLn("Apollo 13 - Service Module detached...");
    }
}
