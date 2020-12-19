package org.jesperancinha.ocp11.crums.crum12;

import java.awt.*;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;

public class Crum12 {

    private interface Berry {
        Color color = Color.BLUE;
    }

    private static class RoundBerry implements Berry {
        public static Color color = Color.BLUE;
    }

    private static class BlueBerry extends RoundBerry implements Berry {

        public Color getColor() {

            // Crum12.java:21:20
            // java: reference to color is ambiguous
            // both variable color in org.jesperancinha.ocp11.crums.crum12.Crum12.RoundBerry and variable color
            // in org.jesperancinha.ocp11.crums.crum12.Crum12.Berry match
            // return color;
            return Color.BLUE;
        }
    }

    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 12 - Equally applicable fields");
        printMagentaGenericLn(
            "If you run with this following code, you'll get the following error. This happens upon compilation but not the one from your IDE. You need to complete a full compilation from the command line or just do a normal run to generate the following error.");
        printMagentaGenericLn("Before running you need to switch the commmented lines");
        printBlueGenericLn("             Crum12.java:21:20\n" + "             java: reference to color is ambiguous\n"
            + "             both variable color in org.jesperancinha.ocp11.crums.crum12.Crum12.RoundBerry and variable color\n"
            + "             in org.jesperancinha.ocp11.crums.crum12.Crum12.Berry match\n"
            + "             return color;");
        printMagentaGenericLn(new BlueBerry().getColor());

        printGreenGenericLn(
            "The point here is that both the interface and the class are implementing the same static member");
        printGreenGenericLn(
            "This on its own is not an issue. The problem is that our subclass implements the same interface and extends from the same class");
        printGreenGenericLn(
            "This means that no shadowing can occur. In that sense the compiler will not know which color to pick");
        printGreenGenericLn("If the member isn't used, the compiler just doesn't use it.");
    }
}
