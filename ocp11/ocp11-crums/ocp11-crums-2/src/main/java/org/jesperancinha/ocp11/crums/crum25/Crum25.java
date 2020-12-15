package org.jesperancinha.ocp11.crums.crum25;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;

public class Crum25 {
    public static void main(String[] args) throws InterruptedException {
        printBlueGenericTitleLn("Crum 25 - When does GC washes away an object");

        String a = IntStream.range(0, Integer.MAX_VALUE / 1000)
            .boxed()
            .map(Object::toString)
            .collect(Collectors.joining());
        long before = getMemoryAllocation();
        a = null;
        long after = getMemoryAllocation();
        long objectSize = before - after;
        printMagentaGenericLn("This is the estimated byte object size -> %d bytes", objectSize);
        a = IntStream.range(0, Integer.MAX_VALUE / 1000)
            .boxed()
            .map(Object::toString)
            .collect(Collectors.joining());
        before = getMemoryAllocation();
        printMagentaGenericLn("This is the estimated byte object size doing the same test -> %d bytes", objectSize);
        after = getMemoryAllocation();
        printMagentaGenericLn("This difference if we don't point to null -> %d bytes", before - after);
        a = null;
        after = getMemoryAllocation();
        objectSize = before - after;
        printMagentaGenericLn("This is the estimated byte object size for the second time -> %d bytes", objectSize);

        printGreenGenericLn(
            "What we need to bear in mind is that, although we are using the same reference, if we set it to null, the object instance loses its references");
        printGreenGenericLn("Independently of the Garbage collection mechanism used, the basic principle is the same");
        printGreenGenericLn(
            "If no references are attached to the instance created, that instance is eligible to be removed by Garbage Collections");

    }

    private static long getMemoryAllocation() throws InterruptedException {
        System.gc();
        System.runFinalization();
        Thread.sleep(1000);
        return Runtime.getRuntime()
            .totalMemory() - Runtime.getRuntime()
            .freeMemory();
    }
}
