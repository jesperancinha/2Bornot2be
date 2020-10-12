package org.jesperancinha.ocp11.serviceprovider;

import java.util.ServiceLoader;

public class ServiceProviderRunner {
    public static void main(String[] args) {
        ServiceLoader<PinkRibbonService> load1 = ServiceLoader.load(PinkRibbonService.class);
        PinkRibbonService pinkRibbonService = load1.iterator().next();
        System.out.println(pinkRibbonService);
        pinkRibbonService.fight();
    }
}
