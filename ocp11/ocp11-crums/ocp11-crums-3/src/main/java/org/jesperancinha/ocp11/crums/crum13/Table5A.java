package org.jesperancinha.ocp11.crums.crum13;

import java.io.Serializable;

public class Table5A extends TableLegs implements Serializable {

    private String name;

    public Table5A() {
        super(5, 25);
        name = "5A";
    }
}