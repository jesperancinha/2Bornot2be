package org.jesperancinha.ocp11.mastery3dot2.pesca;

import java.util.UUID;

public class Peixe {
    public final String commonName;

    public final double size;

    private final UUID uuid = UUID.randomUUID();

    public CrateSize crateSize = null;

    public Peixe(String commonName, double size) {
        this.commonName = commonName;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Peixe{" +
                "commonName='" + commonName + '\'' +
                ", size=" + size +
                ", uuid=" + uuid +
                ", crateSize=" + crateSize +
                '}';
    }
}
