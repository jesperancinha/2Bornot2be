package org.jesperancinha.jtd.shrimps;

import java.util.logging.Logger;

public class ShrimpsLauncher {

    private static Logger logger = Logger.getLogger(ShrimpsLauncher.class.getName());

    public static void main(String[] args) {
        final var cookedShrimps = new CookedShrimps();
        final var grilledShrimps = new GrilledShrimps();
        final var grilledTigerPrawns = new GrilledTigerPrawns();
        final var stewedChicken = new StewedChicken();

        logger.info(cookedShrimps.toString());
        logger.info(grilledShrimps.toString());
        logger.info(grilledTigerPrawns.toString());
        logger.info(stewedChicken.toString());

        logger.info(cookedShrimps.wrapInABox());
        logger.info(grilledShrimps.wrapInABox());
    }
}

