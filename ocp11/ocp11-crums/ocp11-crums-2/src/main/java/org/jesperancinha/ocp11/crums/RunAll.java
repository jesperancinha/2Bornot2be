package org.jesperancinha.ocp11.crums;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.ocp11.crums.crum1.Crum1;
import org.jesperancinha.ocp11.crums.crum2.Crum2;
import org.jesperancinha.ocp11.crums.crum3.Crum3;
import org.jesperancinha.ocp11.crums.crum4.Crum4;

public class RunAll {
    public static void main(String[] args) {
        Consolerizer.typingWaitGlobal = 0;
        Consolerizer.maxLineCharsGlobal = 150;
        Consolerizer.titleSpread = 150;
        Crum1.main(null);
        Crum2.main(null);
        Crum3.main(null);
        Crum4.main(null);
    }
}
