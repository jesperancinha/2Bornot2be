package org.jesperancinha.jtd.jee.flash;

import org.jesperancinha.jtd.jee.flash.flash1.Flash1;
import org.jesperancinha.jtd.jee.flash.flash10.Flash10;
import org.jesperancinha.jtd.jee.flash.flash11.Flash11;
import org.jesperancinha.jtd.jee.flash.flash12.Flash12;
import org.jesperancinha.jtd.jee.flash.flash13.Flash13;
import org.jesperancinha.jtd.jee.flash.flash14.Flash14;
import org.jesperancinha.jtd.jee.flash.flash2.Flash2;
import org.jesperancinha.jtd.jee.flash.flash3.Flash3;
import org.jesperancinha.jtd.jee.flash.flash4.Flash4;
import org.jesperancinha.jtd.jee.flash.flash5.Flash5;
import org.jesperancinha.jtd.jee.flash.flash6.Flash6;
import org.jesperancinha.jtd.jee.flash.flash7.Flash7;
import org.jesperancinha.jtd.jee.flash.flash8.Flash8;
import org.jesperancinha.jtd.jee.flash.flash9.Flash9;

import static org.jesperancinha.console.consolerizer.Consolerizer.setupFastDefaultWideTitleSpread;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BLUE;

public class FlashCardLauncher {
    public static void main(String[] args) {
        final var argsCustom = new String[]{"-d1", "-d2", "-d3", "-d4", "-d5", "-d6", "-d7", "-d8", "-d9", "-d10", "-d11", "-d12"};
        setupFastDefaultWideTitleSpread();
        BLUE.printGenericTitleLn("Welcome to the Flash Cards module 1 about JEE");
        Flash1.main(argsCustom);
        Flash2.main(argsCustom);
        Flash3.main(argsCustom);
        Flash4.main(argsCustom);
        Flash5.main(argsCustom);
        Flash6.main(argsCustom);
        Flash7.main(argsCustom);
        Flash8.main(argsCustom);
        Flash9.main(argsCustom);
        Flash10.main(argsCustom);
        Flash11.main(argsCustom);
        Flash12.main(argsCustom);
        Flash13.main(argsCustom);
        Flash14.main(argsCustom);
        BLUE.printGenericTitleLn("This is the end of the Flash Cards module 1 about JEE");
    }
}
