package org.jesperancinha.ocp11.autocloseable;

public class AutoCloseableRunner {

    public static void main(String[] args) throws Exception {

        try (
            var lvBag = new LVBagCloseable();
            var viperBag = new ViperBagAutocloseable()) {
            System.out.println("" + lvBag + "-" + viperBag);
        } finally {
            System.out.println("Done Whatever!");
        }

        System.out.println("Check the closing order!");

    }
}
