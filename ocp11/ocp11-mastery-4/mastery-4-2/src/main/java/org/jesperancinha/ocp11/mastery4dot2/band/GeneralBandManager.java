package org.jesperancinha.ocp11.mastery4dot2.band;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.ocp11.mastery4dot2.concert.Band;
import org.jesperancinha.ocp11.mastery4dot2.concert.GenericBand;

import java.time.LocalDateTime;
import java.time.temporal.Temporal;
import java.util.HashMap;
import java.util.Map;

public class GeneralBandManager extends BandManager {

    @Override
    public Map<GenericBand, LocalDateTime> getUpcomingDates(Band t, Temporal d) {
        final Map<GenericBand, LocalDateTime> genericBandLocalDateTimeHashMap = new HashMap<>();
        genericBandLocalDateTimeHashMap.put((GenericBand) t, (LocalDateTime) d);
        Consolerizer.printOrangeGenericLn("Overriden called!!");
        return new HashMap<>(genericBandLocalDateTimeHashMap);
    }

    public Map<GenericBand, LocalDateTime> getUpcomingDates(GenericBand t, Temporal d) {
        Consolerizer.printOrangeGenericLn("Overloaded called!!");
        return new HashMap<>(Map.of(t, (LocalDateTime) d));
    }
}
