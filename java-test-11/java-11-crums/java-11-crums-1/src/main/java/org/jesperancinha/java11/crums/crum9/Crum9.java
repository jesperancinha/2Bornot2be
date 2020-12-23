package org.jesperancinha.java11.crums.crum9;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Crum9 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 9 - Unreacheable code");
        // Unreachable statement
        // while(false){
        //
        // }

        while (true) {
            break;
        }
        if (false) {

        }
        do {

        } while (false);

        // Unreachable statement
        // for(;false;){
        //
        // }

        for(;;){
           break;
        }

        for(;true;){
            break;

        }

        boolean a = false;
        for(;a & false;){
          printYellowGenericLn(a);
        }

        printMagentaGenericLn("The exception in this case is if");
        printMagentaGenericLn("If can have unreachable conditions");
        printMagentaGenericLn("If while and for loops may not have unreachable conditions");
        printMagentaGenericLn("do{}while() loops are always reachable at least once");
        printMagentaGenericLn("An unreachable condition in a for or a while loop is characterized by being constantly false");
        printMagentaGenericLn("Constantly false means that the compiler reads literally a false value");

    }
}
