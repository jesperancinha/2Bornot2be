package org.jesperancinha.ocp11.crums.crum10;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;

public class Crum10 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 10 - ClassNotFoundException and NotSuchFieldException");

        try {
            calculateExceptions();
        } catch (NoSuchFieldException e) {
           printRedGenericLn("This is expected! NoSuchFieldException is a checked exception that needs to be in throws -> %s", e);
        }
        try {
            calculateException2();
        } catch (ClassNotFoundException e) {
            printRedGenericLn("This is expected! ClassNotFoundException is a checked exception that needs to be in throws -> %s", e);
        }
        try {
            calculateException3();
        } catch (Exception e) {
            printRedGenericLn("This is expected! Exception is a checked exception that needs to be in throws -> %s", e);
        }

        printGreenGenericLn("It is important to know that subclasses of ReflectiveOperationException are also checked exceptions");
        printGreenGenericLn("If they are thrown, they need to be catch or the method needs to have throws.");

    }

    private static void calculateException3() throws Exception {
        throw new Exception();
    }

    private static void calculateException2() throws ClassNotFoundException {
        throw new ClassNotFoundException();
    }

    private static void calculateExceptions() throws NoSuchFieldException {
        throw  new NoSuchFieldException();
    }
}
