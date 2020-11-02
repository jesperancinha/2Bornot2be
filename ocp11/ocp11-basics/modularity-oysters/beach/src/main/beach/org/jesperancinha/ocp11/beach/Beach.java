package org.jesperancinha.ocp11.beach;

import java.util.ServiceLoader;
import org.jesperancinha.ocp11.sand.Sand;

public class Beach {
    public String searchBeach(){
        ServiceLoader<Sand> load = ServiceLoader.load(Sand.class);
        Sand sand = load.findFirst().orElse(null);
        return sand.checkOyster();
    }
}
