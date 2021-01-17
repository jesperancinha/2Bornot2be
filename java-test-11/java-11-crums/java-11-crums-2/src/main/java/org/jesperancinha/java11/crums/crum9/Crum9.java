package org.jesperancinha.java11.crums.crum9;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Crum9 extends B implements A {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 9 - Shadowing in static members?");
        // Reference to 'a' is ambiguous, both 'B.a' and 'A.a' match
        // a = 40;
        printMagentaGenericLn("This is possible -> %d", A.a);
        printMagentaGenericLn("This is possible -> %d", B.a);

        printMagentaGenericLn("This is possible -> %d", b);
        printMagentaGenericLn("This is possible -> %d", C.b);

        // 'org.jesperancinha.java11.crums.crum9.C' is not an enclosing class
        // C.this.b;

        printYellowGenericLn("From instance is the same thing:");

        new Crum9().fromInstance();

        printGreenGenericLn("Because both a's are at the same level, they do not shadow each other");
        printGreenGenericLn("This way the compiler doesn't know what to do if only a is given.");
        printGreenGenericLn(
            "b's don't have this problem, because b in B overshadows b in C, given they B is a subclass of C");
        printGreenGenericLn(
            "As a curiosity we see that the static this doesn't work due to C not being an enclosing class");
    }

    private void fromInstance() {
        printMagentaGenericLn("This is possible -> %d", A.a);
        printMagentaGenericLn("This is possible -> %d", B.a);

        printMagentaGenericLn("This is possible -> %d", b);
        printMagentaGenericLn("This is possible -> %d", C.b);

    }
}
