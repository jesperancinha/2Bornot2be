package org.jesperancinha.jtd.jee.teeth.serialization;

import java.io.Serializable;

public class PeriodontitisObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String property;

    public PeriodontitisObject(String value) {
        this.property = value;
    }

    public String getProperty() {
        return property;
    }

}
