package org.jesperancinha.java11.crums.crum26;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConColor.BRIGHT_MAGENTA;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;

public class Crum26 {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 26 - List.of and List.copyOf do not support null elements");

        var strings = new String[]{"Paul Simon","PJ Harvey","Courtney Love",null,"Roy Orbinson"};

        printOrangeGenericLn("We have a list of artists:");

        BRIGHT_MAGENTA.printGenericLn(Arrays.stream(strings).collect(Collectors.toList()));

        printOrangeGenericLn("Let's make an immutable list of it:");

        try {
            List.of(strings);
        } catch (NullPointerException e){
            printRedGenericLn("This is expected! The NullPointerException is thrown because there is a null element -> %s",e);
        }

        try {
            List.copyOf(Arrays.asList(strings));
        } catch (NullPointerException e){
            printRedGenericLn("This is expected! The NullPointerException is thrown because there is a null element -> %s",e);
        }

        printGreenGenericLn("It is important to understand the null values aren't accepted in some list creations.");
        printGreenGenericLn("The creation of immutable lists require that all elements are filled in.");
        printGreenGenericLn("A null value does not make since in immutable lists");



    }
}
