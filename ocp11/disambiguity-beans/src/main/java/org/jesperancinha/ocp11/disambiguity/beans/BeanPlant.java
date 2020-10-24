package org.jesperancinha.ocp11.disambiguity.beans;

public class BeanPlant implements Bean,Leaf {
    @Override
    public String getColor() {
        return "This is a great Bean Plant Color!";
    }
}
