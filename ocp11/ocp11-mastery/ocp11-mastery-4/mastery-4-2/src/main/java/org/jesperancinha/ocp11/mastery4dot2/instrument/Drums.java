package org.jesperancinha.ocp11.mastery4dot2.instrument;

import org.jesperancinha.console.consolerizer.Consolerizer;

public final class Drums implements AutoCloseable {

    public Drums() {
        Consolerizer.printGreenGenericLn("🥁 ¡Drums created! 🥁");
    }

    public final void playDrum() {
        Consolerizer.printGreenGeneric("Playing drums");
    }

    public final void playWrongDrum() throws DrumException {
        Consolerizer.printRedGenericLn("Oh no! I think I hit the wrong drum!");
        throw new DrumException();
    }

    @Override
    public final void close() throws DrumsIOException {
        Consolerizer.printGreenGeneric("Keep playing and let the rhythm guide you! João Esperancinha");
        throw new DrumsIOException();
    }
}
