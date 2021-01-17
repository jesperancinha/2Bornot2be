package org.jesperancinha.console.consolerizer;

public class ConTexts {

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
}
