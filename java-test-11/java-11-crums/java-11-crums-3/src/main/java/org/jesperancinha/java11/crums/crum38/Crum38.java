package org.jesperancinha.java11.crums.crum38;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Crum38 implements B {

    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 38 - Overriding interface methods and creating methods after Java 9");

        final Crum38 crum38 = new Crum38();

        final int i = crum38.countSheeps();
        final int theSheeps = crum38.getTheSheeps();

        printOrangeGenericLn("We've counted %d sheeps from a total of %d", i, theSheeps);

        printYellowGenericLn("And sheeps make this sound %s", B.sheepMakesASound());
        printGreenGenericLn("An interface can have methods that @Override other methods");
        printGreenGenericLn("An interface can contain private methods that contain a body");
        printGreenGenericLn("Static methods are also valida, public by default and must have a body");
    }

    @Override
    public int getTheSheeps() {
        return 4000;
    }
}
