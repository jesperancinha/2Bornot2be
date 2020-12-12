package org.jesperancinha.ocp11.rocket;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.ocp11.lunar.extra.HelloSender;
import org.jesperancinha.ocp11.lunar.module.LunarInterface;
import org.jesperancinha.ocp11.service.module.ServiceInterface;

import java.util.ServiceLoader;

public class RocketRunner {
    public static void main(String[] args) {
        Consolerizer.typingWaitGlobal = 0;
        Consolerizer.printBlueGenericLn("============ Welcome to the Apollo 13's mission launch of 1970 ============");
        Consolerizer.printRainbowTitleLn("Apollo 13 - Rocket Launched!...");

        ServiceLoader<ServiceInterface> serviceLoaderServiceModule = ServiceLoader.load(ServiceInterface.class);
        ServiceLoader<LunarInterface> serviceLoaderLunarModule = ServiceLoader.load(LunarInterface.class);

        var lunarInterface = serviceLoaderLunarModule.findFirst().orElse(null);
        var serviceInterface = serviceLoaderServiceModule.findFirst().orElse(null);

        HelloSender.sendHello();
        serviceInterface.detachModule();
        lunarInterface.detachModule();

        Consolerizer.printYellowGenericLn("Mission complete");
        Consolerizer.printGreenGenericLn("Done!!");
    }
}
