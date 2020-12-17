package org.jesperancinha.ocp11.crums.crum2;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowLn;

public class Crum2 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 2 - java.util.RandomAccess interface");
        final List<String> options = Arrays.stream(args)
            .collect(Collectors.toList());
        final boolean skipTime = options.contains("-skipTime");
        printMagentaGenericLn("We know that ArrayList implements the RandomAccessInterface");
        printMagentaGenericLn("We know that LinkedList does not implement the RandomAccessInterface");

        printMagentaGenericLn("The first is said to a have a constant time access to each of their elements.");
        printMagentaGenericLn("The second is said to take longer for the last elements for each retrieval");

        LocalDateTime time1 = LocalDateTime.now();
        var arrayList = new ArrayList<Integer>();
        int MAX_ELEMENTS = 50000000;
        if (skipTime) {
            MAX_ELEMENTS = 1000;
        }
        for (int i = 0; i < MAX_ELEMENTS; i++) {
            arrayList.add(i);

        }
        LocalDateTime time2 = LocalDateTime.now();

        var linkedList = new LinkedList<Integer>();
        for (int i = 0; i < MAX_ELEMENTS; i++) {
            linkedList.add(i);
        }
        LocalDateTime time3 = LocalDateTime.now();

        printMagentaGenericLn("It took %s nanoseconds to fill the array list", time1.until(time2, ChronoUnit.NANOS));
        printMagentaGenericLn("It took %s nanoseconds to fill the linked list", time2.until(time3, ChronoUnit.NANOS));

        for (int i = 0; i < 10; i++) {
            calculate(arrayList, linkedList);
        }

        printGreenGenericLn(
            "The idea is that with massive amount of elements, the ArrayList will maintain constant time access");
        printGreenGenericLn("This is because it implements the RandomAccess interface");
        printGreenGenericLn(
            "When it comes to the LinkedList, it is not marked with that, and ths means that it implements its own algorithm");
        printGreenGenericLn(
            "In practice, what we do see with our example is that the longer the lists are the longer it takes to add elements");
        printGreenGenericLn("For the ArrayList, that time doesn't seem to differ much per added element");
        printGreenGenericLn("For the LinkedList, there is a noticeable difference. For a small number of elements, a LinkedList may be a better option.");
        printGreenGenericLn("Try to run with and without the -skipTime flag 😊.");

    }

    private static void calculate(ArrayList<Integer> arrayList, LinkedList<Integer> linkedList) {
        LocalDateTime time3 = LocalDateTime.now();

        var lastElementArrayList = arrayList.get(arrayList.size() - 1);
        LocalDateTime time4 = LocalDateTime.now();

        var fistElementArrayList = arrayList.get(0);
        LocalDateTime time5 = LocalDateTime.now();

        var lastElementLinkedList = linkedList.get(linkedList.size() - 1);
        LocalDateTime time6 = LocalDateTime.now();
        var firstElementLinkedList = linkedList.get(0);
        LocalDateTime time7 = LocalDateTime.now();

        printRainbowLn('-', 10);
        printMagentaGenericLn("It took %s nanoseconds to get the last element of the array list",
            time3.until(time4, ChronoUnit.NANOS));
        printMagentaGenericLn("It took %s nanoseconds to get the first element of the array list",
            time4.until(time5, ChronoUnit.NANOS));
        printMagentaGenericLn("It took %s nanoseconds to get the last element of the linked list",
            time5.until(time6, ChronoUnit.NANOS));
        printMagentaGenericLn("It took %s nanoseconds to get the first element of the linked list",
            time6.until(time7, ChronoUnit.NANOS));
    }
}
