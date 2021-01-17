package org.jesperancinha.java11.crums.crum3;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;

public class Crum3 {

    private static class A {
        @Override
        public String toString() {
            return "This is A";
        }
    }

    private static class B1 extends A {

        @Override
        public String toString() {
            return "This is B1";
        }
    }

    private static class B2 extends A {
        @Override
        public String toString() {
            return "This is B2";
        }
    }

    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 3 - Casting Exceptions at compile and runtime");

        var a = new A();
        a = new B1();
        a = new B2();
        var b1 = new B1();
        var b2 = new B2();

        printMagentaGenericLn("Up until this point everything is pretty much what we expect");

        BLUE.printGenericLn("        var a = new A();\n" + "        a = new B1();\n" + "        a = new B2();\n"
            + "        var b1 = new B1();\n" + "        var b2 = new B2();");

        printMagentaGenericLn(a);
        printMagentaGenericLn(b1);
        printMagentaGenericLn(b2);

        try {
            b1 = (B1) new A();
        } catch (RuntimeException e) {
            printRedGenericLn("This is expected. A ClassCastException is thrown if we make a wrong casting -> %s", e);
            printRedGenericLn("This did not generated any compile time error");
        }

        // Required type:
        // B1
        // Provided:
        // A
        // b1 = new A();

        printGreenGenericLn("It is very important to distinguish between compile errors and runtime errors");
        printGreenGenericLn(
            "When casting, a runtime error happens when the right happens in the code, but the instance does not match the casting type in any way");
        printGreenGenericLn(
            "A wrong cast may only happen if the type cast to is the same type or a sub-type of the instance");
        printGreenGenericLn("Without an explicit casting, the compiler detects immediately that something went wrong");
        printGreenGenericLn("When we make explicit casting, the compiler leaves that responsibility to us");
    }
}
