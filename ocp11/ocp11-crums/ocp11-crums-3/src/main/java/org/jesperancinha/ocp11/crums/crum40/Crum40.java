package org.jesperancinha.ocp11.crums.crum40;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;
import static org.jesperancinha.ocp11.crums.crum40.DocesPortugueses.DOMRODRIGO;
import static org.jesperancinha.ocp11.crums.crum40.DocesPortugueses.FAROFIAS;

public class Crum40 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 40 - Advanced Enums");

        printMagentaGenericLn("Let's examine elements of an enum");
        printMagentaGenericLn("We have these elements");

        printOrangeGenericLn(Arrays.stream(DocesPortugueses.values()).collect(Collectors.toList()));

        printMagentaGenericLn("In the case of %s", FAROFIAS);

        printOrangeGenericLn("The description is %s", FAROFIAS.getDescription());
        printMagentaGenericLn("In the case of %s", DOMRODRIGO);

        printOrangeGenericLn("The description is %s", DOMRODRIGO.getDescription());

        printGreenGenericLn("Static members in enums must be declared final, if we want to use th¬em in the constructor");
        printGreenGenericLn("It is acceptable to make anonymous subclasses per enum element");
        printGreenGenericLn("An enum constructor is always implicitly private   ");
    }
}
