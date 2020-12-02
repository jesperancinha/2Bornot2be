package org.jesperancinha.ocp11.mastery4dot3;

import org.jesperancinha.console.consolerizer.Consolerizer;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printUnicornsLn;

public class Mastery4Dot3Runner {
    private static boolean skipQuestions;

    public static void main(String[] args) {
        if (args.length > 0) {
            skipQuestions = "-skip".equals(args[0]);
        }
        Consolerizer.typingWaitGlobal = 0;
        Consolerizer.maxLineCharsGlobal = 200;
        printBlueGenericLn("==================== Master Module mastery-4-3 And Then India ====================");
        printBlueGenericLn("----> Run with VM command -ea or -enableassertions for a more accurate run");
        printBlueGenericLn("----> Run with -skip to skip questions");
        printBlueGenericLn("----> Note that this mastery need the prepare.sh script to be run first.");


        moduleEnd();
    }

    private static void moduleEnd() {
        printUnicornsLn(100);
        printGreenGenericLn("Hope you enjoyed this mastery into Java 11 with some Spanish Indie/Pop flavor flavour to it.");
        printGreenGenericLn("Please keep coming back as I'll be creating more mastery modules.");
        printGreenGenericLn("Thank you!");
        printUnicornsLn(100);
    }
}
