package org.jesperancinha.console.consolerizer;

public class Htmlizer {

    public static String getPTextColor(final String
                                               hexColor, final String text) {
        return String.format("<p style=\"color:#%s\">%s</p>", hexColor.toLowerCase(), text);
    }

    public static String getPBTextColor(final String
                                               hexColor, final String text) {
        return String.format("<p style=\"color:#%s\"><b>%s</b></p>", hexColor.toLowerCase(), text);
    }
}
