package org.jesperancinha.ocp11.mastery3dot1.furniture;

import org.jesperancinha.console.consolerizer.Consolerizer;

public class BookCase extends Case {
    public BookCase(int capacity) {
        super(capacity);
    }

    public void showCapacity() {
        Consolerizer.printOrangeGenericLn("This RecordCase has a capacity of %d records", super.capacity);
    }
}
