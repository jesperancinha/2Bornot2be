package org.jesperancinha.ocp11.mastery3dot1;

import org.jesperancinha.console.consolerizer.Consolerizer;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightCyanGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Mastery3Dot1Runner {
    public static void main(String[] args) {
        Consolerizer.typingWaitGlobal = 0;

        printBlueGenericLn("================== Master Module mastery-3-1 ==================");

        exercise1();


        printBrightCyanGenericLn("--- 2. Labels and `break` in loops");

    }

    private static void exercise1() {
        printBrightCyanGenericLn("--- 1. `Integer` Mathematical Bases `parseInt`");
        printGreenGenericLn("According to NPO(https://www.nporadio2.nl/song/3230/grote-mannen-worden-klein),  Diggy Dex single, \"Grote Mannen Worden Klein\" was releases in 2014");
        printGreenGenericLn("Let's see different ways to visualize this:");
        var debutGroteMannen = "2014";
        printGreenGenericLn("*** Integer.parseInt(%s)", debutGroteMannen);
        printYellowGenericLn("The single was \"Grote Mannen Worden Klein\" was released, in Decimal, in the year %d", Integer.parseInt(debutGroteMannen, 10));
        var binaryValue = Integer.toBinaryString(2014);
        printGreenGenericLn("*** Integer.parseInt(%s, 2)", binaryValue);
        printYellowGenericLn("The single was \"Grote Mannen Worden Klein\" was released, in Binary, in the year %d", Integer.parseInt(binaryValue, 2));
        printGreenGenericLn("References");
        printGreenGenericLn("1. https://www.nporadio2.nl/song/3230/grote-mannen-worden-klein");
        printGreenGenericLn("2. https://www.last.fm/music/Diggy+Dex/_/Grote+Mannen+Worden+Klein");
        printGreenGenericLn("3. https://www.metrolyrics.com/grote-mannen-worden-klein-lyrics-diggy-dex.html");
    }
}
