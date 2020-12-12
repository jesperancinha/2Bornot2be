package org.jesperancinha.ocp11.catching.crows;

public class SickCrowException extends CrowException{

    @Override
    public String getMessage() {
        return "This crow is sick";
    }
}
