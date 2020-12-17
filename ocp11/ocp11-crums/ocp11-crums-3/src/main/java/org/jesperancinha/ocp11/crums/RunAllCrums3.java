package org.jesperancinha.ocp11.crums;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.ocp11.crums.crum1.Crum1;
import org.jesperancinha.ocp11.crums.crum2.Crum2;

import java.util.Arrays;

public class RunAllCrums3 {
    public static void main(String[] args) throws InterruptedException {
        Consolerizer.typingWaitGlobal = 0;
        Consolerizer.maxLineCharsGlobal = 150;
        Consolerizer.titleSpread = 150;
        Consolerizer.blackAndWhite = Arrays.asList(args)
            .contains("-bw");

        Crum1.main(args);
        Crum2.main(args);

    }
}
