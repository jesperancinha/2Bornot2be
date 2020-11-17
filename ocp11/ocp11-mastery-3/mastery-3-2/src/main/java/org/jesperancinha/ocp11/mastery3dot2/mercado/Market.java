package org.jesperancinha.ocp11.mastery3dot2.mercado;

import org.jesperancinha.console.consolerizer.Consolerizer;

import java.io.Serializable;
import java.util.UUID;

public class Market extends Building implements Serializable {

    private  UUID marketId = UUID.randomUUID();

    public Market(float height, float dimX, float  dimY, String mainMaterial) {
        super(height, dimX, dimY, mainMaterial);
        Consolerizer.printOrangeGenericLn("Market constructor has been called! %s", this.toString());
    }

    public Market(){
        Consolerizer.printOrangeGenericLn("Market (no-args) constructor has been called! %s", this.toString());
    }

    @Override
    public String toString() {
        return ("Market{" +
                "marketId=" + marketId +
                '}').concat(super.toString());
    }
}
