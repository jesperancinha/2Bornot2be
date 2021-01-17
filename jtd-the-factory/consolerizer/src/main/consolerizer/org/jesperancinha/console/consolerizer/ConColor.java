package org.jesperancinha.console.consolerizer;

import java.util.Arrays;
import java.util.List;

public enum ConColor {
    WHITE("FFFFFF", "\033[0m"),
    BLACK("000000", "\033[0;30m"),
    BLUE("0000AA", "\033[0;34m"),
    GREEN("00AA00", "\033[0;32m"),
    CYAN("00AAAA", "\033[0;36m"),
    RED("AA0000", "\033[0;31m"),
    ORANGE("AA0000", "\u001b[38;5;208m"),
    MAGENTA("AA00AA", "\u001b[38;5;135m"),
    BROWN("AA5500", "\033[0;33m"),
    LIGHT_GREY("AAAAAA", "\033[0;37m"),
    DARK_GREY("555555", "\033[0;90m"),
    BRIGHT_BLUE("5555FF", "\033[1;34m"),
    BRIGHT_GREEN("55FF55", "\033[1;32m"),
    BRIGHT_CYAN("55FFFF", "\033[1;36m"),
    BRIGHT_RED("FF5555", "\033[1;31m"),
    BRIGHT_MAGENTA("FF55FF", "\033[0;95m"),
    YELLOW("FFFF55", "\033[0;33m"),
    BRIGHT_WHITE("FFFFFF", "\033[1;37m"),
    BG_ORANGE("AA0000", "\033[48:2:255:165:0m");

    private final Consolerizer colorManager;
    private final String hexColor;
    private final String consoleColor;

    ConColor(String hexColor, String consoleColor) {
        this.hexColor = hexColor;
        this.consoleColor = consoleColor;
        this.colorManager = new Consolerizer(this);
    }

    public static ConColor getRandomColor() {
        final ConColor[] values = values();
        var randomI = (int) (Math.random() * values.length);
        return values[randomI];
    }

    public String getConsoleColor() {
        return consoleColor;
    }

    public String getHexColor() {
        return hexColor;
    }

    public Consolerizer getColorManager() {
        return colorManager;
    }

    public void printGenericLn(Object text, Object... args) {
       colorManager.printGenericLn(text, args);
    }

    public void printGenericLn(Object text) {
        colorManager.printGenericLn(text);
    }

    public void printGeneric(Object text) {
        colorManager.printGeneric(text);
    }

    public void printGeneric(String text, Object... args) {
        colorManager.printGeneric(text, args);
    }

    public void printGenericTitleLn(Object text, Object... args) {
        printGenericTitleLn(String.format("" + text, args));
    }

    public void printGenericTitleLn(Object text) {
        final String titleString = Consolerizer.createTitleLineLn(text, '=');
        printGeneric(titleString);
    }
    public static List<String> getConsoleRainbow() {
        return Arrays.asList(RED.getConsoleColor(), ORANGE.getConsoleColor(), YELLOW.getConsoleColor(),
                GREEN.getConsoleColor(), BLUE.getConsoleColor(), MAGENTA.getConsoleColor());
    }

    public static List<ConColor> getConsoleRainbowEnumList() {
        return Arrays.asList(RED, ORANGE, YELLOW, GREEN, BLUE, MAGENTA);
    }
}
