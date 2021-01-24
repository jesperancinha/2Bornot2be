package org.jesperancinha.console.consolerizer;

import org.apache.commons.text.StringEscapeUtils;

public class Htmlizer {

    public static String getPTextEscapedColor(final String
                                                      hexColor, final String text) {
        return String.format("<p style=\"margin:0; font-family: monospace; color:#%s\">%s</p>", hexColor.toLowerCase(), StringEscapeUtils.escapeHtml4(text));
    }

    public static String getPBTextEscapedColor(final String
                                                       hexColor, final String text) {
        return String.format("<p style=\"margin:0; font-family: monospace; color:#%s\"><b>%s</b></p>", hexColor.toLowerCase(), StringEscapeUtils.escapeHtml4(text));
    }

    public static String getPTextColor(final String
                                               hexColor, final String text) {
        return String.format("<p style=\"margin:0; font-family: monospace; color:#%s\">%s</p>", hexColor.toLowerCase(), text);
    }

    public static String getPBTextColor(final String
                                                hexColor, final String text) {
        return String.format("<p style=\"margin:0; font-family: monospace; color:#%s\"><b>%s</b></p>", hexColor.toLowerCase(), text);
    }
}
