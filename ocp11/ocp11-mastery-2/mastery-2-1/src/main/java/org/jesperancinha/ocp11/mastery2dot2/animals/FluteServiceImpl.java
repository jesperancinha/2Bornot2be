package org.jesperancinha.ocp11.mastery2dot2.animals;

import org.jesperancinha.console.consolerizer.Consolerizer;

public class FluteServiceImpl {
    public static FluteService provider(){
        return new FluteService() {
            @Override
            public void play() {
                Consolerizer.printRedGenericLn("Playing the flute...");
            }
        };
    }
}
