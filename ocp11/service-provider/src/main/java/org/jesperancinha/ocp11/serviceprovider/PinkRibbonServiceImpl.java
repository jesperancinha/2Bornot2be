package org.jesperancinha.ocp11.serviceprovider;

public class PinkRibbonServiceImpl implements  PinkRibbonService{

    @Override
    public String toString() {
        return "Your service is on and this is because of the META-INF.services folder and the text fil in it!";
    }

    @Override
    public void fight() {
        System.out.println("We're fighting!");
    }
}
