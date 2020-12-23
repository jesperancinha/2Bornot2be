package org.jesperancinha.java11.mastery3dot2.mercado;

import org.jesperancinha.console.consolerizer.Consolerizer;

import java.io.Serializable;
import java.util.UUID;

import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;

public class Market extends Building implements Serializable {

    private final UUID marketId = UUID.randomUUID();

    public Market(float height, float dimX, float dimY, String mainMaterial) {
        super(height, dimX, dimY, mainMaterial);
        printOrangeGenericLn("Market constructor has been called! %s", this.toString());
    }

    public Market() {
        printOrangeGenericLn("Market (no-args) constructor has been called! %s", this.toString());
    }

    public static void getInfo() {
        Consolerizer.printYellowGenericLn("A Market has a UUID");
    }


    public String getCurrentInfo() {
        return "marketId=" + marketId;
    }

    @Override
    public String toString() {
        return ("Market{" +
                "marketId=" + marketId +
                '}').concat(super.toString());
    }
}
