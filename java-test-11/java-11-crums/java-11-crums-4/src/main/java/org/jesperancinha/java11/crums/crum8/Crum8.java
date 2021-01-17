package org.jesperancinha.java11.crums.crum8;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Crum8 implements B {

    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 8 - Overriding interface methods and creating methods after Java 9");

        final Crum8 crum8 = new Crum8();

        final int i = crum8.countSheeps();
        final int theSheeps = crum8.getTheSheeps();

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
