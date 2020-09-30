package org.jesperancinha.ocp11.autocloseable;

import java.io.Closeable;
import java.io.IOException;

public class LVBagCloseable implements Closeable {

    private final boolean hole;

    public LVBagCloseable() {
        this.hole = false;
    }

    public LVBagCloseable(boolean hole) {
        this.hole = hole;
    }

    @Override
    public void close() throws IOException {
        if (this.hole) {
            throw new IOException();
        }
        System.out.println("Your LV Bag has been closed!");
    }
}
