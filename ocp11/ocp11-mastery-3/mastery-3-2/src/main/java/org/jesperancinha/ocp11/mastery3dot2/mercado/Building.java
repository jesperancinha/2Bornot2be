package org.jesperancinha.ocp11.mastery3dot2.mercado;

import org.jesperancinha.console.consolerizer.Consolerizer;

import java.io.Serializable;

public class Building extends Construction implements Serializable {
    float height;

    float dimX;

    float dimY;
    public Building(float height, float dimX, float dimY, String mainMaterial) {
        super(mainMaterial);
        this.height = height;
        this.dimX = dimX;
        this.dimY = dimY;
        Consolerizer.printOrangeGenericLn("Building constructor has been called! %s", toString());
    }

    public Building() {
        Consolerizer.printOrangeGenericLn("Building (no-args) constructor has been called! %s", toString());
    }

    @Override
    public String toString() {
        return ("Building{" +
                "height=" + height +
                ", dimX=" + dimX +
                ", dimY=" + dimY +
                '}').concat(super.toString());
    }
}
