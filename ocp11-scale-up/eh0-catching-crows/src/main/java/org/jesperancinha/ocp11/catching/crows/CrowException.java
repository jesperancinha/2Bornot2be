package org.jesperancinha.ocp11.catching.crows;

public class CrowException extends Exception {

    @Override
    public String getMessage() {
        return "This crow is healty!";
    }
}
