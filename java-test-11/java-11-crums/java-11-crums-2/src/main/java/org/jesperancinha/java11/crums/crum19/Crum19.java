package org.jesperancinha.java11.crums.crum19;

import java.util.concurrent.atomic.AtomicInteger;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;

public class Crum19 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 19 - Atomic numbers");

        final var atomicInteger1 = new AtomicInteger();
        final var atomicInteger2 = new AtomicInteger(50);

        printMagentaGenericLn("We can initialize an atomicInteger with %d or with a number %d",
            atomicInteger1.get(), atomicInteger2.get());
        atomicInteger2.set(9999);
        printMagentaGenericLn("We can change the value by adding it after %d, or by adding it before %d",
            atomicInteger1.getAndSet(70), atomicInteger2.get());
        printMagentaGenericLn("Now we have values %d and %d", atomicInteger1.get(), atomicInteger2.get());
        printMagentaGenericLn("We can also add and get in one line and so we have %d and %d",
            atomicInteger1.addAndGet(10000), atomicInteger2.addAndGet(20000));
        printMagentaGenericLn("We can also create our own accumulator and then we can get %d and %d",
            atomicInteger1.accumulateAndGet(4, (left, right) -> left * right),
            atomicInteger2.accumulateAndGet(19, (left, right) -> left / right));
        printMagentaGenericLn("We can also decrement now %d and %d",
            atomicInteger1.decrementAndGet(), atomicInteger2.decrementAndGet());
        printMagentaGenericLn("Or we can also decrement later %d and %d",
            atomicInteger1.getAndDecrement(), atomicInteger2.getAndDecrement());
        printMagentaGenericLn("So now we can check the current values %d and %d",
            atomicInteger1.get(), atomicInteger2.get());
        printMagentaGenericLn("We can also, match compare and change!");
        atomicInteger1.compareAndSet(40280, 50000);
        printMagentaGenericLn("So now we can check the current values %d and %d",
            atomicInteger1.get(), atomicInteger2.get());
        printMagentaGenericLn("It didn't match! but now it does:");
        atomicInteger1.compareAndSet(40278, 50000);
        printMagentaGenericLn("So now we can check the current values %d and %d",
            atomicInteger1.get(), atomicInteger2.get());

        printGreenGenericLn("With exception to a few methods, most atomic methods return a value of before or after a change");
        printGreenGenericLn("Set methods perform operations where a void or a boolean is returned");
        printGreenGenericLn("Atomic also has compare methods, which change the value if a value matches an expectation");
        printGreenGenericLn("There is no increment method. All add, increment, decrement, accumulate and update have get and get after counterparts");
    }
}
