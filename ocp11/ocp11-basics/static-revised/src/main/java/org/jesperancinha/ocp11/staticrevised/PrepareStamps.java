package org.jesperancinha.ocp11.staticrevised;

interface PrepareStamps extends SeparateFromEnvelopeStamps {
    public default void separateFromEnvelope() {
        steamEnvelope();
        System.out.println("Got the stamps!");
    }
}