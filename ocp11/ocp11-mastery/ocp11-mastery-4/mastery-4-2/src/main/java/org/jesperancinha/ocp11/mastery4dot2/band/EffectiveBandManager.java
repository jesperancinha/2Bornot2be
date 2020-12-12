package org.jesperancinha.ocp11.mastery4dot2.band;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.ocp11.mastery4dot2.concert.Band;

import java.time.temporal.Temporal;
import java.util.Map;

public class EffectiveBandManager extends BandManager {
    @Override
    public Map<Band, Temporal> getUpcomingDates(Band t, Temporal b) {
        Consolerizer.printOrangeGenericLn("Overriden called!!");
        return Map.of(t, b);
    }
}
