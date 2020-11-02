package org.jesperancinha.ocp11.serviceprovider;

import java.util.ServiceLoader;

public class ServiceProviderRunner {
    public static void main(String[] args) {
        System.out.println("With just loading");
        ServiceLoader<PinkRibbonService> load1 = ServiceLoader.load(PinkRibbonService.class);
        PinkRibbonService pinkRibbonService = load1.iterator().next();
        System.out.println(pinkRibbonService);
        pinkRibbonService.fight();

        System.out.println("With an Iterable");
        Iterable<PinkRibbonService> loadIterable1 = ServiceLoader.load(PinkRibbonService.class);
        PinkRibbonService next = loadIterable1.iterator().next();
        System.out.println(next);
        next.fight();

        System.out.println("NOTE: The ServiceLoader is in itself and Iterable.");
    }
}
