package org.jesperancinha.ocp11.crums;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.ocp11.crums.crum1.Crum1;
import org.jesperancinha.ocp11.crums.crum10.Crum10;
import org.jesperancinha.ocp11.crums.crum11.Crum11;
import org.jesperancinha.ocp11.crums.crum12.Crum12;
import org.jesperancinha.ocp11.crums.crum13.Crum13;
import org.jesperancinha.ocp11.crums.crum14.Crum14;
import org.jesperancinha.ocp11.crums.crum2.Crum2;
import org.jesperancinha.ocp11.crums.crum3.Crum3;
import org.jesperancinha.ocp11.crums.crum4.Crum4;
import org.jesperancinha.ocp11.crums.crum5.Crum5;
import org.jesperancinha.ocp11.crums.crum6.Crum6;
import org.jesperancinha.ocp11.crums.crum7.Crum7;
import org.jesperancinha.ocp11.crums.crum8.Crum8;
import org.jesperancinha.ocp11.crums.crum9.Crum9;

public class RunAll {
    public static void main(String[] args) {
        Consolerizer.typingWaitGlobal = 0;
        Consolerizer.maxLineCharsGlobal = 150;
        Consolerizer.titleSpread = 150;
        Crum1.main(null);
        Crum2.main(null);
        Crum3.main(null);
        Crum4.main(null);
        Crum5.main(null);
        Crum6.main(null);
        Crum7.main(null);
        Crum8.main(null);
        Crum9.main(null);
        Crum10.main(null);
        Crum11.main(null);
        Crum12.main(null);
        Crum13.main(null);
        Crum14.main(null);
    }
}
