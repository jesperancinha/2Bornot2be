package org.jesperancinha.console.consolerizer;

import java.util.ArrayList;
import java.util.Scanner;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.ORANGE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.RED;

public class ConsolerizerTexts {

    static String createTitleLineLn(Object text, char limitingChar, boolean newLine) {
        final String fullText = text.toString();
        var remaining = Consolerizer.titleSpread - fullText.length() - 2;
        var padding = (int) Math.ceil(remaining / 2f);
        final String substring = new String(new char[padding]).replace('\0', limitingChar)
                .concat(" ")
                .concat(fullText)
                .concat(" ")
                .concat(new String(new char[padding]).replace('\0', limitingChar))
                .substring(0, Consolerizer.titleSpread);
        if (newLine) {
            return substring.concat("\n");
        }
        return substring;
    }

    static String trim(String string) {
        return string.replaceAll("^[\n]+|[\n]+$", "");
    }
}
