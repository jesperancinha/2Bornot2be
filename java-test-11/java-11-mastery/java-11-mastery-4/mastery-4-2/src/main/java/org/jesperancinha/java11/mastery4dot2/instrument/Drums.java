package org.jesperancinha.java11.mastery4dot2.instrument;

import org.jesperancinha.console.consolerizer.Consolerizer;

import static org.jesperancinha.console.consolerizer.ConColor.GREEN;

public final class Drums implements AutoCloseable {

    public Drums() {
        GREEN.printGenericLn("🥁 ¡Drums created! 🥁");
    }

    public final void playDrum() {
        GREEN.printGeneric("Playing drums");
    }

    public final void playWrongDrum() throws DrumException {
        Consolerizer.printRedGenericLn("Oh no! I think I hit the wrong drum!");
        throw new DrumException();
    }

    @Override
    public final void close() throws DrumsIOException {
        GREEN.printGeneric("Keep playing and let the rhythm guide you! João Esperancinha");
        throw new DrumsIOException();
    }
}
