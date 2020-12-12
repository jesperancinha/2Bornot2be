package org.jesperancinha.ocp11.crums;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.ocp11.crums.crum1.Crum1;

public class RunAll {
    public static void main(String[] args) {
        Consolerizer.typingWaitGlobal = 0;
        Consolerizer.maxLineCharsGlobal = 150;
        Consolerizer.titleSpread = 150;
        Crum1.main(null);
    }
}
