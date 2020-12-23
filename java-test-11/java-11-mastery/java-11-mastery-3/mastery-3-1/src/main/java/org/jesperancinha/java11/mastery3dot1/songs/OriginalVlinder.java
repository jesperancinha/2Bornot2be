package org.jesperancinha.java11.mastery3dot1.songs;

import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;

public class OriginalVlinder extends RawVlinder {

    @Override
    protected void playVlinder() {
        printOrangeGenericLn("The original version of `Verdronken vlinder` came about in 1967 as a B-Side recording of Boudewijn de Groot's single `Onder ons`");
    }

    @Override
    public void publicPoint() {
        this.playVlinder();
    }
}
