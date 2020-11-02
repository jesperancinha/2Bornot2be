package org.jesperancinha.ocp11.sand;

import org.jesperancinha.ocp11.oyster.Oyster;

public class SandImpl {
    public static Sand provider(){
        return new Sand() {
            @Override
            public String checkOyster() {
                return Oyster.getPearl();
            }
        };
    }
}
