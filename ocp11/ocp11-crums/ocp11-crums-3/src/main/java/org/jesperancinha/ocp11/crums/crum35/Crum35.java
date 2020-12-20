package org.jesperancinha.ocp11.crums.crum35;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGeneric;

public class Crum35 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 35 - Exception handling");
        Crum35 crum35 = new Crum35();
        try {
            try {
                crum35.method1();
            } catch (CustomException e) {
                // Please comment the try catch to see the effect.
                try {
                    // Unhandled exception: org.jesperancinha.ocp11.crums.crum35.CustomException
                    crum35.method1();
                } catch (CustomException customException) {
                    printRedGeneric("This is expected. Please comment this try catch to see the effect -> %s", e);
                }
            } finally {
                crum35.method2();
            }
        } catch (NullPointerException e) {
            printRedGeneric("This is expected. We are throwing a NullPointerException -> %s", e);
        }

        printBlueGenericLn(" Crum35 crum35 = new Crum35();\n" + "        try {\n" + "            crum35.method1();\n"
            + "        } catch (CustomException e) {\n"
            + "            // Please comment the try catch to see the effect.\n" + "            try {\n"
            + "                // Unhandled exception: org.jesperancinha.ocp11.crums.crum35.CustomException\n"
            + "                crum35.method1();\n" + "            } catch (CustomException customException) {\n"
            + "                customException.printStackTrace();\n" + "            }\n" + "        } finally {\n"
            + "            crum35.method2();\n" + "        }");

        printGreenGenericLn("In this case, there isn't much to do than to exercise our eyes");
        printGreenGenericLn(
            "In the catch of this try/cath, there is another exception being thrown that is not easy to spot.");
    }

    public void method1() throws CustomException {
        throw new CustomException();
    }

    public void method2() throws RuntimeException {
        throw new NullPointerException();
    }
}

