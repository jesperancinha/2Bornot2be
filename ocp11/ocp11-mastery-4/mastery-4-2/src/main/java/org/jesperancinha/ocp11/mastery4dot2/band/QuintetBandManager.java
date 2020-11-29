package org.jesperancinha.ocp11.mastery4dot2.band;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.ocp11.mastery4dot2.concert.Band;
import org.jesperancinha.ocp11.mastery4dot2.concert.QuintetBand;

import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.util.HashMap;
import java.util.Map;

public class QuintetBandManager extends BandManager {

    @Override
    public Map<QuintetBand, LocalDate> getUpcomingDates(Band t, Temporal d) {
        final Map<QuintetBand, LocalDate> quintetBandLocalDateHashMap = new HashMap<>();
        quintetBandLocalDateHashMap.put((QuintetBand) t, (LocalDate) d);
        Consolerizer.printOrangeGenericLn("Overriden called!!");
        return quintetBandLocalDateHashMap;
    }

    public Map<QuintetBand, LocalDate> getUpcomingDates(QuintetBand t, Temporal d) {
        Consolerizer.printOrangeGenericLn("Overloaded called!!");
        return Map.of(t, (LocalDate) d);
    }
}
