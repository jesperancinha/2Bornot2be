package org.jesperancinha.ocp11.autocloseable;

import java.io.IOException;

public class ViperBagAutocloseable implements AutoCloseable {

    private final boolean hole;

    public ViperBagAutocloseable() {
        this.hole = false;
    }

    public ViperBagAutocloseable(boolean hole) {
        this.hole = hole;
    }

    @Override
    public void close() throws Exception {
        if (this.hole) {
            throw new Exception();
        }
        System.out.println("Your Viper Bag has been closed!");
    }
}
