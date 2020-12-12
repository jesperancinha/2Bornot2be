package org.jesperancinha.ocp11.crums.crum3;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;

public class Crum3 {

    private class A {
        public A createA() {
            return new A();
        }

    }

    private class B extends A {
        public B createB() {
            return new B();
        }
    }

    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 3 - Subclasses and upper classes");
        final A a = new Crum3().new A();
        final B b = new Crum3().new B();

        printMagentaGenericLn("We create A -> %s", a);
        printMagentaGenericLn("We create B -> %s", b);

         A a1 = a.createA();
         B b1 = b.createB();

        printMagentaGenericLn("We create A1 from A -> %s which ia instance of %s", a1, a1.getClass());
        printMagentaGenericLn("We create B1 from B -> %s", b1);

        try {
            b1 = (B) a1;
        } catch (ClassCastException e) {
            printRedGenericLn("We cannot assign B1 to A1 -> %s", e);
        }

        a1 = b1;

        printMagentaGenericLn("We can however assign A1 to B1 -> %s", a1);

        printGreenGenericLn("The upper in the class in the hierarchy you are the broader are the instances your reference can be assigned to.");
        printGreenGenericLn("Also notice that we had to create an instance of Crum3 in order to create the first instances of A and B");
    }
}
