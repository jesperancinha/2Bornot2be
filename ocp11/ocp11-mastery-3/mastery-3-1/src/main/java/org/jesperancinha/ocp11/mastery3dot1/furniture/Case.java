package org.jesperancinha.ocp11.mastery3dot1.furniture;

import org.jesperancinha.console.consolerizer.Consolerizer;

import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;

public class Case implements Container {

    int capacity = 50;

    public Case(int capacity) {
        this.showCapacity();
        this.capacity = capacity;
        this.showCapacity();
        this.printStuff();
    }

    public void showCapacity() {
        printOrangeGenericLn("This Case has a capacity of %d elements", capacity);
    }

    public void printStuff() {
        printOrangeGenericLn("I have nothing to say.");
    }

    @Override
    public String toString() {
        return "Case{" +
                "capacity=" + capacity +
                '}';
    }

    public static void describeMe() {
        Consolerizer.printYellowGenericLn("I'm a case class -> %s", Case.class.getName());
    }
}
