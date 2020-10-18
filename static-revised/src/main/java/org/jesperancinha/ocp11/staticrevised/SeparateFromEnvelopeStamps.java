package org.jesperancinha.ocp11.staticrevised;

interface SeparateFromEnvelopeStamps {
    public void steamEnvelope();

    private static void log(String msg) {
        System.out.println(msg);
    }

    public static void turnOffSteamer() {
        log("turning steamer off");
    }
}