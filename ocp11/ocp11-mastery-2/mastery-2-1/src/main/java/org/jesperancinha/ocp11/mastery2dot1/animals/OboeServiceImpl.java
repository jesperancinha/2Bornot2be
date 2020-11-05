package org.jesperancinha.ocp11.mastery2dot1.animals;

import org.jesperancinha.console.consolerizer.Consolerizer;

public class OboeServiceImpl implements OboeService {

    @Override
    public void play() {
        Consolerizer.printRedGenericLn("Playing the oboe...");

    }
}
