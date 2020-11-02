package org.jesperancinha.oc11.modularity.one;

import java.util.ServiceLoader;

public class CatModuleRunner {
    public static void main(String[] args) {
        ServiceLoader<Feline> loader = ServiceLoader.load(Feline.class);
        Feline first = loader.findFirst().orElse(null);
        assert first != null;
        first.purr();
    }
}
