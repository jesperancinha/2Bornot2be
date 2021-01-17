package org.jesperancinha.java11.crums.crum35;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;

public class Crum35 {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 35 - trimming and stripping Strings");

        var stringA = "    I did all my best to smile    ";
        var stringB = "    ";
        var stringC = "I'm only happy when it rains    ";
        var stringD = "    I only smile in the dark";
        char c = '\u001A';

        var stringE = c + "I'm only happy when its complicated" + c;

        printMagentaGenericLn("from: https://genius.com/This-mortal-coil-song-to-the-siren-lyrics");
        printMagentaGenericLn("from: https://genius.com/Garbage-only-happy-when-it-rains-lyrics");
        printMagentaGenericLn(
            "from: https://www.journaldev.com/33291/java-string-trim-method-examples#:~:text=String%20trim");
        printMagentaGenericLn("We are presented the following strings:");
        printOrangeGenericLn(stringA);
        printOrangeGenericLn(stringB);
        printOrangeGenericLn(stringC);
        printOrangeGenericLn(stringD);
        printOrangeGenericLn(stringE);

        printMagentaGenericLn("This is what happens with a trim:");
        printOrangeGenericLn("%s, %d", stringA.trim(), stringA.trim()
            .length());
        printOrangeGenericLn("%s, %d", stringB.trim(), stringB.trim()
            .length());
        printOrangeGenericLn("%s, %d", stringC.trim(), stringC.trim()
            .length());
        printOrangeGenericLn("%s, %d", stringD.trim(), stringD.trim()
            .length());
        printOrangeGenericLn("%s, %d", stringE.trim(), stringE.trim()
            .length());

        printMagentaGenericLn("This is what happens with a strip:");
        printOrangeGenericLn("%s, %d", stringA.strip(), stringA.strip()
            .length());
        printOrangeGenericLn("%s, %d", stringB.strip(), stringB.strip()
            .length());
        printOrangeGenericLn("%s, %d", stringC.strip(), stringC.strip()
            .length());
        printOrangeGenericLn("%s, %d", stringD.strip(), stringD.strip()
            .length());
        printOrangeGenericLn("%s, %d", stringE.strip(), stringE.strip()
            .length());

        printMagentaGenericLn("We can also just strip left:");
        printOrangeGenericLn("%s, %d", stringA.stripLeading(), stringA.stripLeading()
            .length());
        printOrangeGenericLn("%s, %d", stringB.stripLeading(), stringB.stripLeading()
            .length());
        printOrangeGenericLn("%s, %d", stringC.stripLeading(), stringC.stripLeading()
            .length());
        printOrangeGenericLn("%s, %d", stringD.stripLeading(), stringD.stripLeading()
            .length());
        printOrangeGenericLn("%s, %d", stringE.stripLeading(), stringE.stripLeading()
            .length());

        printMagentaGenericLn("Or strip right:");
        printOrangeGenericLn("%s, %d", stringA.stripTrailing(), stringA.stripTrailing()
            .length());
        printOrangeGenericLn("%s, %d", stringB.stripTrailing(), stringB.stripTrailing()
            .length());
        printOrangeGenericLn("%s, %d", stringC.stripTrailing(), stringC.stripTrailing()
            .length());
        printOrangeGenericLn("%s, %d", stringD.stripTrailing(), stringD.stripTrailing()
            .length());
        printOrangeGenericLn("%s, %d", stringE.stripTrailing(), stringE.stripTrailing()
            .length());

        printGreenGenericLn("Trim looks to do the same as strip, but there is a subtle difference");
        printGreenGenericLn("Trim removes all characters under '\\u001A'");
        printGreenGenericLn("Strip removes all characters under the UTF standard.");
        printGreenGenericLn("Strip also uses the Character.isWhiteSpace(codepoint) method");
        printGreenGenericLn("It must follow these rules:");
        printGreenGenericLn("It is a Unicode space character (SPACE_SEPARATOR, LINE_SEPARATOR, or PARAGRAPH_SEPARATOR) but is not also a non-breaking space ('\\u00A0', '\\u2007', '\\u202F').\n"
            + "It is '\\t', U+0009 HORIZONTAL TABULATION.\n" + "It is '\\n', U+000A LINE FEED.\n"
            + "It is '\\u000B', U+000B VERTICAL TABULATION.\n" + "It is '\\f', U+000C FORM FEED.\n"
            + "It is '\\r', U+000D CARRIAGE RETURN.\n" + "It is '\\u001C', U+001C FILE SEPARATOR.\n"
            + "It is '\\u001D', U+001D GROUP SEPARATOR.\n" + "It is '\\u001E', U+001E RECORD SEPARATOR.\n"
            + "It is '\\u001F', U+001F UNIT SEPARATOR.");
    }
}
