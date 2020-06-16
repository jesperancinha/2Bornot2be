package org.jesperancinha.jtd.shrimps;

import java.util.logging.Logger;

public class ShrimpsLauncher {

    private static Logger logger = Logger.getLogger(ShrimpsLauncher.class.getName());

    public static void main(String[] args) {
        final var cookedPrawns = new CookedPrawns();
        final var grilledPrawns = new GrilledPrawns();
        final var grilledTigerShrimps = new GrilledTigerShrimps();
        final var stewedChicken = new StewedChicken();

        logger.info(cookedPrawns.toString());
        logger.info(grilledPrawns.toString());
        logger.info(grilledTigerShrimps.toString());
        logger.info(stewedChicken.toString());
    }
}

