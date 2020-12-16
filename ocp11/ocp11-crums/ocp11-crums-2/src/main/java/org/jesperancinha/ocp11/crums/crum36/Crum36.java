package org.jesperancinha.ocp11.crums.crum36;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Crum36 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 36 - When return from try and finally compete with each other");

        String result1 = getNumber(1);
        String result2 = getNumber(2);

        printMagentaGenericLn("If no exception is thrown we get %s", result1);
        printMagentaGenericLn("If exception is thrown we get %s", result2);

        printGreenGenericLn("We know that finally is the last operation guaranteed to happen");
        printGreenGenericLn("This is why its return value wins when competing with an thrown catch exception or the successful case");

    }

    private static String getNumber(int i) {
        try {
            if (i == 1) {
                return new Crum36() + "1";
            }
            throw new Exception();
        } catch (Exception e) {
            return "2";
        } finally {
            return "3";
        }
    }

    @Override
    public String toString() {
        printYellowGenericLn("As you can see, the return operations still happen, regardless.");
        return super.toString();
    }
}
