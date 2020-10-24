package org.jesperancinha.ocp11.disambiguity.beans;

public interface Leaf {
    default String getColor(){
        return "green";
    }
}
