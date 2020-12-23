package org.jesperancinha.java11.mastery3dot1.furniture;

import org.jesperancinha.console.consolerizer.Consolerizer;

import java.time.LocalDateTime;

import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;

public class RecordCase extends Case {

    int currentYear = LocalDateTime.now().getYear();

    public RecordCase(int capacity) {
        super(capacity);
    }

    public void showCapacity() {
        Consolerizer.printOrangeGenericLn("This RecordCase has a capacity of %d records", super.capacity);
    }

    public void printStuff() {
        printOrangeGenericLn("Current year is %d", currentYear);
    }

    public static void describeMe() {
        Consolerizer.printYellowGenericLn("I'm a record case class -> %s", RecordCase.class.getName());
    }

}
