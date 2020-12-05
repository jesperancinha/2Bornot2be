package org.jesperancinha.ocp11.mastery4dot3.cousins;

public class Cousins {
    public final String getCousins(){
        return String.format("They have %s cousins", (int) (Math.random() * 100));
    }
}
