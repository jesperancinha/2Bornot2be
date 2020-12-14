package org.jesperancinha.ocp11.crums.crum5;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;
import static org.jesperancinha.ocp11.crums.crum5.Type.B;

interface ISubTypeA {
    Type getA();

    Type getCloneA() throws Exception;
}

enum SubTypeA implements ISubTypeA {
    AA, AB;

    private final Type A = Type.A;

    public Type getA() {
        return A;
    }

    public Type getCloneA() {
        try {
            return (Type) clone();
        } catch (CloneNotSupportedException e) {
            printRedGenericLn("An enum is not cloneable. Remember that these are static values -> %s", e);
        }
        return null;
    }
}

enum Type {
    A, B, C, D
}

class RunningModule {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 5 - Using enums");

        final Type a = Type.A;
        final Type b = B;

        printMagentaGenericLn("We create reference for type A -> %s", a);
        printMagentaGenericLn("Then the reference for type B -> %s", b);

        printMagentaGenericLn("We can also create types which contain others");
        printMagentaGenericLn("We create a SubTypeA -> %s", SubTypeA.AA);
        printMagentaGenericLn("We can also create another SubTypeA -> %s", SubTypeA.AB);
        printMagentaGenericLn("We know that any SubTypeA contains a reference to a static A member -> %s",
            SubTypeA.AB.getA());
        printMagentaGenericLn("Using an interface we get the same -> %s", ((ISubTypeA) (SubTypeA.AB)).getA());

        printMagentaGenericLn("We can also use instances to access types in the same way -> %s",
            new RunningModule().getType());

        printGreenGenericLn("What we see is that enums are full of surprised");
        printGreenGenericLn("An enum is final and cannot be extended");
        final Type cloneA = SubTypeA.AB.getCloneA();
        printGreenGenericLn("We can also not clone it");
        printGreenGenericLn(
            "Note that static imports work, however, if they are not present, we have to use he main enum type to start to reference our enum value");
    }

    public Type getType() {
        final Type a = Type.A;
        return a;
    }
}
