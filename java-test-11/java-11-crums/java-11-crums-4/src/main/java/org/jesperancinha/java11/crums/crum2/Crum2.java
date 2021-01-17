package org.jesperancinha.java11.crums.crum2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;

public class Crum2 {

    private static class Boat {
        List<? super CharSequence> getBoats() {
            return Arrays.asList("O Armonense", "Rio Belo", "Mira Sado");
        }
    }

    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 2 - List, Collections and bounded types");

        printMagentaGenericLn("We have these boat names:");

        final List<? super CharSequence> boats = new Boat().getBoats();

        printOrangeGenericLn(boats);
        printMagentaGenericLn("We have created these boats without bounded types");
        final CharSequence a_estrela = (CharSequence) new String("A Estrela");
        boats.set(0, a_estrela);
        printMagentaGenericLn("This means that all elements have to be String");
        printOrangeGenericLn(boats);
        boats.set(1, "Ferreirinha");
        printOrangeGenericLn(boats);
        printMagentaGenericLn("The difference here is that when we perform a get from this list, we get Object:");
        final Object text = boats.get(0);
        printOrangeGenericLn(text);

        printMagentaGenericLn("Lets now create an ArrayDeque of our boats:");

        // Cannot resolve constructor 'ArrayDeque(java.util.List<capture<? super java.lang.CharSequence>>)'
        // final ArrayDeque<String> arrayDeque = new ArrayDeque<String>(boats);
        final ArrayDeque<String> arrayDeque = new ArrayDeque<String>(boats.stream()
            .map(x -> (String) x)
            .collect(Collectors.toList()));

        printOrangeGenericLn(arrayDeque);

        printMagentaGenericLn("An ArrayDeque is not a List! -> %s", arrayDeque instanceof List);
        printMagentaGenericLn("But the boat list is a List! -> %s", boats instanceof List);
        printMagentaGenericLn("And both of them are collections: %s  %s", arrayDeque instanceof Collection,
            boats instanceof Collection);
        printGreenGenericLn(
            "Unbounded types or wildcards with super determine the base type that can be added to a list");
        printGreenGenericLn("These, however, say nothing about the return type.");
        printGreenGenericLn("Not all Collections are Lists");
        printGreenGenericLn("An ArrayList is a List, and is also a Collection");
        printGreenGenericLn("A List is not a Collection. They are different interfaces");
        printGreenGenericLn("An ArrayDeque is a Collection but it is not a List");
        printGreenGenericLn("An ArrayDeque is Deque");

    }
}
