package org.jesperancinha.java11.crums.crum21;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;

public class Crum21 {

    private class A {

        int a;
        public A(int  a) {
            printOrangeGenericLn("Created A");
            this.a = a;
        }

        @Override
        public String toString() {
            return "A{" + "a=" + a + '}';
        }
    }

    private class B extends A {
        long a;
        public B(long a) {
            super((int) a);
            printOrangeGenericLn("Created B");
            this.a = a;
        }

        @Override
        public String toString() {
            return "B{" + "a=" + a + '}';
        }
    }

    private class Flying {
        public A getA() {
            return new A(888);
        }
    }

    private class Bird extends Flying {

        @Override
        public B getA() {
            return new B(999);
        }
    }

    private class Plane extends Flying {

        @Override
        public A getA() {
            return new A(111);
        }
    }

    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 21 - Overriding return types");

        printMagentaGenericLn("Revising again the overriding capabilities of Java");

        final Crum21 crum21 = new Crum21();
        final Bird bird = crum21.new Bird();
        final Plane plane = crum21.new Plane();
        final Flying flying = crum21.new Flying();

        final B b = bird.getA();
        final A a = plane.getA();
        final A a1 = flying.getA();

        printMagentaGenericLn("We create a B from bird -> %s", b);
        printMagentaGenericLn("We create an A from plane -> %s", a);
        printMagentaGenericLn("We create an A from flying -> %s", a1);

        printGreenGenericLn("The principle is that the return type, if an an object, it must be of the same type or a subtype of the overriden type.");
        printGreenGenericLn("Overriding happens with the same type of parameters.");
        printGreenGenericLn("Always take into consideration the type erasure operation of java to determine if overriding of certain method is legal.");
    }
}
