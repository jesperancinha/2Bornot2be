package org.jesperancinha.ocp11.crums.crum15;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGeneric;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;

public class Crum15 {

    private int a;

    // Variable 'a' is already defined in the scope
    // private static int a;

    private static int b;
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 15 - Coexistence of instance and static members");
        printMagentaGenericLn("Note that we could not create a static member named a");
        final Crum15 crum15 = new Crum15();
        printMagentaGenericLn("This is because we already have an instance member named  a=%s", crum15.a);
        printMagentaGenericLn("And so  we have to name our static variable something else such as b=%s", b);

        printMagentaGenericLn("The same is valid for methods:");
        printMagentaGenericLn("This is because we already have an instance member named  a=%s", crum15.getA());
        printMagentaGenericLn("And so  we have to name our static variable something else such as b=%s", crum15.getB());
        printMagentaGenericLn("And so  we have to name our static variable something else such as b=%s", getB());

        printGreenGenericLn("Variable initialization is mandatory in local scopes");
        printGreenGenericLn("For instance and static scopes, we do not need to initialize them");
        printGreenGenericLn("Variables of the same name cannot coexist on the same class even if they are instance and static members");
        printGreenGenericLn("We always need to pay attention that static cannot access instance, but instance can access static");
    }

    public int getA() {
        return a;
    }

    public static int getB() {
        return b;
    }

    // 'getB()' is already defined in 'org.jesperancinha.ocp11.crums.crum15.Crum15'
    // public int getB() {
    //     return b;
    // }
}
