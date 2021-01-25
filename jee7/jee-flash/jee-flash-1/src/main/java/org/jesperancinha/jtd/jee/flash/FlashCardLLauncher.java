package org.jesperancinha.jtd.jee.flash;

import org.jesperancinha.jtd.jee.flash.flash1.Flash1;
import org.jesperancinha.jtd.jee.flash.flash2.Flash2;

import static org.jesperancinha.console.consolerizer.Consolerizer.setupFastDefaultWideTitleSpread;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BLUE;

public class FlashCardLLauncher {
    public static void main(String[] args) {
        setupFastDefaultWideTitleSpread();
        BLUE.printGenericTitleLn("Welcome to the Flash Cards module 1 about JEE");
        Flash1.main(null);
        Flash2.main(null);
        BLUE.printGenericTitleLn("This is the end of the Flash Cards module 1 about JEE");
    }
}
