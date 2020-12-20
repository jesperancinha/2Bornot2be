package org.jesperancinha.ocp11.crums.crum37;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGeneric;

public class Crum37 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 37 - unmodifiableList");

        var numA = new Integer[] { 11, 22 };
        var list1 = new ArrayList<Integer>(List.of(numA));
        list1.add(null);
        list1.add(null);
        list1.add(null);
        list1.add(null);
        list1.add(null);
        list1.add(null);
        var list2 = Collections.unmodifiableList(list1);
        try {
            var list4 = List.of(list1.toArray(new Integer[0]));
        } catch (NullPointerException e) {
            printRedGeneric(
                "This is expected! Although Collections.unmodifiableList allow Null values, List.Of do not! -> %s", e);
        }
        list1.set(2, 99);
        List<List<Integer>> list3 = List.of(list1, list2);

        printOrangeGenericLn(list3);
        printGreenGenericLn("Remember that unlike List.of, unmodifiableLists do allow null values");
    }
}
