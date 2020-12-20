package org.jesperancinha.ocp11.crums.crum42;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;

public class Crum42 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 42 - Caching with numbers");

        Integer i = Integer.parseInt("127");
        Integer ia = i;
        Integer j = -128;
        Integer ja = j;
        Integer k = 0;
        Integer ka = k;
        Integer l = Integer.parseInt("234");
        Integer la = l;

        ia++;
        ia--;
        ja++;
        ja--;
        ka++;
        ka--;
        la++;
        la--;

        printOrangeGenericLn(i == ia);
        printOrangeGenericLn(j == ja);
        printOrangeGenericLn(k == ka);
        printOrangeGenericLn(l == la);

        printGreenGenericLn(
            "Java optimizes values from -128 to 127. The rest of the objects use cache. This is why the equals fails for the last case");
    }
}
