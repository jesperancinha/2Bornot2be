package org.jesperancinha.ocp11.mastery4dot2.instrument;

public class DrumException extends Exception {
    @Override
    public String getMessage() {
        return "Drums failed!";
    }
}
