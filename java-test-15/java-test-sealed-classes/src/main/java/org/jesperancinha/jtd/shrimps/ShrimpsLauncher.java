package org.jesperancinha.jtd.shrimps;

import java.util.logging.Logger;

public class ShrimpsLauncher {

    private static Logger logger = Logger.getLogger(ShrimpsLauncher.class.getName());

    public static void main(String[] args) {
        final var cookedPrawns = new CookedShrimps();
        final var grilledPrawns = new GrilledShrimps();
        final var grilledTigerShrimps = new GrilledTigerPrawns();
        final var stewedChicken = new StewedChicken();

        logger.info(cookedPrawns.toString());
        logger.info(grilledPrawns.toString());
        logger.info(grilledTigerShrimps.toString());
        logger.info(stewedChicken.toString());
    }
}

