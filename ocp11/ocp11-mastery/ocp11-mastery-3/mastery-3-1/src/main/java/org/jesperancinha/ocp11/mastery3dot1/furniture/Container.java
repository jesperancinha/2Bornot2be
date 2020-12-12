package org.jesperancinha.ocp11.mastery3dot1.furniture;

import org.jesperancinha.console.consolerizer.Consolerizer;

public interface Container {

    static void describeMe(){
        Consolerizer.printYellowGenericLn("I'm a container interface -> %s", Container.class.getName());
    }
}
