package org.jesperancinha.ocp11.crums.crum34;

import org.jesperancinha.console.consolerizer.Consolerizer;

import java.text.DateFormat;
import java.util.Arrays;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;

public class Crum34 {

    @Boat(value = "Armonense", type = BoatType.PASSENGER)
    @Boat(value = "Ferreirinha", type = BoatType.FISHING)
    private class ArmonaBoat {

    }

    @Boats({ @Boat(value = "Armonense", type = BoatType.PASSENGER),
        @Boat(value = "Ferreirinha", type = BoatType.FISHING) })
    private class TourBoat {

    }

    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 34 - Repeatable annotations");

        final Crum34 crum34 = new Crum34();

        final ArmonaBoat armonaBoat = crum34.new ArmonaBoat();

        final TourBoat tourBoat = crum34.new TourBoat();

        printMagentaGenericLn("For the %s boat we have:", armonaBoat.getClass());
        Arrays.stream(armonaBoat.getClass()
            .getAnnotations())
            .forEach(Consolerizer::printBrightCyanGenericLn);
        printMagentaGenericLn("For the %s boat we have:", tourBoat.getClass());
        Arrays.stream(tourBoat.getClass()
            .getAnnotations())
            .forEach(Consolerizer::printBrightCyanGenericLn);

        printGreenGenericLn(
            "We need to be aware that although we made our annotation Boat repeatable, it is not dependent on Boats");
        printGreenGenericLn(
            "The code declaration of Boats allow us to use the Boat annotation independently and repeatedly");
    }
}
