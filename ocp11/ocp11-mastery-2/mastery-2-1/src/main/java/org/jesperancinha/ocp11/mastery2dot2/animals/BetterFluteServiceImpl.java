package org.jesperancinha.ocp11.mastery2dot2.animals;

import org.jesperancinha.console.consolerizer.Consolerizer;

public class BetterFluteServiceImpl {
    public static FluteService provider(){
        return () -> Consolerizer.printRedGenericLn("Playing the better flute...");
    }
}
