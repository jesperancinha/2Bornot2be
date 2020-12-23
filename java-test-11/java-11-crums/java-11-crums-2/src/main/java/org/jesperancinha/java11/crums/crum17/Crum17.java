package org.jesperancinha.java11.crums.crum17;

import org.jesperancinha.console.consolerizer.Consolerizer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;

public class Crum17 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 17 - Terminating functions in lambda sequences");

        final Stream<String> names = Stream.of("Isla Fisher", "Amy Adams", "Jessica Chastain", "Bryce Dallas");

        final Stream<Character> characterStream = names.map(name -> {
            Consolerizer.printBrightMagentaGenericLn("This is an indication that mapping of name %s is following next",
                name);
            return name.charAt(0);
        });

        printMagentaGenericLn("Nothing has happened yet to the stream.");
        printMagentaGenericLn("Now we call the terminating function.");

        final List<Character> collect = characterStream.collect(Collectors.toList());

        printMagentaGenericLn("And this is the character list -> %s", collect);

        printGreenGenericLn("Lambda functions are only called once the terminating function is called");
        printGreenGenericLn(
            "Mapping is valid as long as uses an element of the stream  as parameter and then returns another, which can be of the desired type");

        printGreenGenericLn("Mapping takes an implementation of a Function interface, which we implement on the fly");
    }
}
