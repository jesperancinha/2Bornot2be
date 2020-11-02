package org.jesperancinha.ocp11.optional;

import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalRunner {
    public static void main(String[] args) {
        final String test = null;
        try {
            //  Optional.of a null will trow a NullPointerException. If a null is expected then Optional.ofNullable is the way to go.
            Optional.of(test);
        } catch (NullPointerException np) {
            np.printStackTrace();
        }

        final Optional<String> test1 = Optional.ofNullable(test);
        System.out.printf("We can now see that test1 is %s\n", test1);
        try {
            System.out.printf("And that its value is %s\n", test1.get());
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("We actually don't get to get the element because the Optional is empty");
        }

        final Optional<String> test2 = Optional.ofNullable(test);
        System.out.printf("A working solution: We can now see that test1 is %s\n", test2);
        try {
            System.out.printf("And that its value is \"%s\"\n", test1.orElse("There was nothing in this Optional"));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("We actually don't get to get the element because the Optional is empty");
        }
    }
}
