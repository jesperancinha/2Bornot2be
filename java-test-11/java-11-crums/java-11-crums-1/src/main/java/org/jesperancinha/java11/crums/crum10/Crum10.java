package org.jesperancinha.java11.crums.crum10;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Crum10 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 10 - Modulus operator investigation");

        printYellowGenericLn(33.33 % 2);
        printYellowGenericLn(33.33 % 3);
        printYellowGenericLn(33.33 % 3.3);

        double a = 1.2;
        float b = 1.2f;

        printYellowGenericLn(a % 1.2);
        printYellowGenericLn(b % 1.2);

        long y = 6;
        long p = 9;

        final long l = p % y;
        final int m = (int) (p % y);
        final float o = p % y;
        final double q = p % y;

        printYellowGenericLn(l);
        printYellowGenericLn(m);
        printYellowGenericLn(o);
        printYellowGenericLn(q);
    }
}
