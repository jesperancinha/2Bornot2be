package org.jesperancinha.ocp11.mastery3dot1.furniture;

import org.jesperancinha.console.consolerizer.Consolerizer;

public class Case {

    int capacity;

    public Case(int capacity) {
        this.showCapacity();
        this.capacity = capacity;
        this.showCapacity();
    }

    public void showCapacity() {
        Consolerizer.printOrangeGenericLn("This Case has a capacity of %d elements", capacity);
    }

    @Override
    public String toString() {
        return "Case{" +
                "capacity=" + capacity +
                '}';
    }
}
