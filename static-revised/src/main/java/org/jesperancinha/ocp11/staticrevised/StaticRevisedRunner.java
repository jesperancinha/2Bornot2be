package org.jesperancinha.ocp11.staticrevised;

public class StaticRevisedRunner implements PrepareStamps {
    public void steamEnvelope() {
        System.out.println("Steam envelope...");
    }

    public static void main(String[] args) {
        PrepareStamps v = new StaticRevisedRunner();
        v.separateFromEnvelope();

        // We cannot make static calls using instances
        // v.shutdown();

        SeparateFromEnvelopeStamps.turnOffSteamer();
    }
}
