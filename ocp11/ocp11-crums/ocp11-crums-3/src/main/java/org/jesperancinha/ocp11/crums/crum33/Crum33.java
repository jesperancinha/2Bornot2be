package org.jesperancinha.ocp11.crums.crum33;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printNewLine;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowTitle;

public class Crum33 {
    public static void main(String[] args) {

        printBlueGenericTitleLn("Crum 33 - Creating different types of fors");

        printBlueGenericLn(
            "        //'var' is not allowed in a compound declaration\n" + "        // for(var a=0, b=0; b<10; b++){\n"
                + "        //     \n" + "        // }");
        //'var' is not allowed in a compound declaration
        // for(var a=0, b=0; b<10; b++){
        //
        // }

        for (var i = 0; i < 10; i++) {

        }

        printMagentaGenericLn("We cannot use var do declare variables in a compound");

        for (int i = 0, j = 10; i < 10; i++) {
            printRainbowTitle("" + i + " " + j);
        }
        printNewLine();

        printMagentaGenericLn("We an however declare var outside the for loop:");

        var a = 0;
        for (; a < 20; a++) {
            printRainbowTitle("" + a);
        }
        printNewLine();

        printGreenGenericLn("In Java 11 a for loop can be a bit complicated to understand at some point");
        printGreenGenericLn("Important key things to remember");
        printGreenGenericLn("var cannot be declared inside de for compound");
        printGreenGenericLn("var can be declared outside and used within the loop");
        printGreenGenericLn("We can declare multi-variables but we cannot re-declared them");
    }
}
