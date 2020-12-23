package org.jesperancinha.java11.crums.crum14;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;

public class Crum14 {

    public static class Kitten {
        private final String name;

        public Kitten(@Special String name) {
            this.name = name;
        }

        @Override
        public @Special String toString() {
            return "Kitten{" + "name='" + name + '\'' + '}';
        }
    }

    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 14 - Annotations on types");
        final @Special String foxy = "Foxy";
        var kitten = new @Special Kitten(foxy);

        final @Special String bibi = "Bibi";
        var kittenName = new @Special String(bibi);
        var kitten2 = new @Special Kitten(kittenName);
        printMagentaGenericLn("We have created two kittens:");

        printOrangeGenericLn("This is %s, %s", foxy, kitten);
        printOrangeGenericLn("This is %s, %s", bibi, kitten2);

        printGreenGenericLn("We were able to use this @Special annotation in type and parameter type parameters.");
    }
}
