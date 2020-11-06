package org.jesperancinha.console.consolerizer;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Thread.sleep;
import static org.jesperancinha.console.consolerizer.ConColor.BRIGHT_WHITE;

public class Consolerizer {

    private final static int TYPING_DEFAULT_MS = 10;
    private final static ConColor CON_COLOR_DEFAULT = BRIGHT_WHITE;

    private int typingWait;
    public static int typingWaitGlobal = TYPING_DEFAULT_MS;

    private ConColor conColor = CON_COLOR_DEFAULT;

    public Consolerizer() {
        typingWait = TYPING_DEFAULT_MS;
    }

    public Consolerizer(int typingWait) {
        this.typingWait = typingWait;
    }

    public static Consolerizer createGreen() {
        return new Consolerizer().conColor(ConColor.BRIGHT_GREEN);
    }

    public Consolerizer conColor(ConColor conColor) {
        this.conColor = conColor;
        return this;
    }

    public Consolerizer typingWait(int typingWait) {
        this.typingWait = typingWait;
        return this;
    }

    public static void printBlueGenericLn(String text, Object... args) {
        printBlueGeneric(text.concat("\n"), args);

    }

    public static void printBlueGenericLn(Object text) {
        printBlueGeneric(text.toString().concat("\n"));
    }

    public static void printBlueGeneric(String text) {
        System.out.print(ConColor.BLUE.getConsoleColor());
        printPrivateText(text);
    }

    public static void printBlueGeneric(String text, Object... args) {
        System.out.print(ConColor.BLUE.getConsoleColor());
        printPrivateText(text, args);
    }


    public static void printGreenGenericLn(Object text) {
        printGreenGeneric(("" + text).trim().concat("\n"));
    }

    public static void printGreenGeneric(Object text) {
        System.out.print("\033[0;32m");
        printPrivateText(text.toString());
    }

    public static void printGreenGenericLn(String text, Object... args) {
        printGreenGeneric(text.concat("\n"), args);
    }

    public static void printGreenGeneric(String text, Object... args) {
        System.out.print("\033[0;32m");
        printPrivateText(text, args);
    }

    public static void printRedGenericLn(String text, Object... args) {
        printRedGeneric(text.concat("\n"), args);
    }

    public static void printRedGeneric(String text, Object... args) {
        System.out.print("\033[0;31m");
        printPrivateText(text, args);
    }

    public static void printRedGenericLn(String text) {
        printRedGeneric(text.concat("\n"));
    }

    public static void printRedGeneric(String text) {
        System.out.print("\033[0;31m");
        printPrivateText(text);
    }

    public static void printYellowGenericLn(Object text) {
        printYellowGeneric(text.toString().concat("\n"));

    }

    public static void printYellowGeneric(String text) {
        System.out.print(ConColor.YELLOW.getConsoleColor());
        printPrivateText(text);
    }

    public void printColorText(final ConColor conColor, String text) {
        System.out.print(conColor.getConsoleColor());
        printPrivateText(text);
    }

    public void printRed(String text) {
        System.out.print("\033[0;31m");
        printPrivateText(text);
    }

    public void printRed(String text, String... args) {
        System.out.print("\033[0;31m");
        printPrivateText(text, args);
    }

    public void printGreen(String text) {
        System.out.print("\033[1;32m");
        printPrivateText(text);
    }

    public void printBlue(String text) {
        System.out.print("\033[0;34m");
        printPrivateText(text);
    }

    public static void printBrightCyanGenericLn(final String text, final Object... args) {
        printBrightCyanGeneric(text.concat("\n"), args);
    }

    public static void printBrightCyanGenericLn(String text) {
        printBrightCyanGeneric(text.concat("\n"));
    }

    public static void printBrightCyanGeneric(String text) {
        System.out.print(ConColor.BRIGHT_CYAN.getConsoleColor());
        printPrivateText(text);
    }


    public static void printBrightCyanGeneric(String text, Object... args) {
        System.out.print(ConColor.BRIGHT_CYAN.getConsoleColor());
        printPrivateText(text, args);
    }

    public void printBrightCyan(String text) {
        System.out.print(ConColor.BRIGHT_CYAN.getConsoleColor());
        printPrivateText(text);
    }

    public void printBrightCyan(String text, String... args) {
        System.out.print(ConColor.BRIGHT_CYAN.getConsoleColor());
        printPrivateText(text, args);
    }

    public void printText(String text) {
        System.out.print(conColor.getConsoleColor());
        printPrivateText(text);
    }

    public void printText(String text, Object... vars) {
        System.out.print(conColor.getConsoleColor());
        printPrivateText(text, vars);
    }

    private static void printPrivateText(String text) {
        printPrivateText(text, typingWaitGlobal);
    }


    private static void printPrivateText(String text, Object... vars) {

        for (int i = 0; i < vars.length; i++) {
            var variable = vars[i];
            if (variable instanceof Exception) {
                var e = (Exception) variable;
                var stackTrace = e.getStackTrace();
                var sb = new StringBuilder(e.getClass().getCanonicalName());
                if (Objects.nonNull(e.getMessage())) {
                    sb.append("\n\t");
                    sb.append(e.getMessage());
                }
                Arrays.stream(stackTrace).forEach(stackTraceElement -> {
                    sb.append("\n\t");
                    sb.append(stackTraceElement.toString());
                });
                vars[i] = sb.toString();
            }
            if (variable instanceof String[]) {
                vars[i] = "[".concat(String.join(",", (String[]) variable)).concat("]");
            }
            if (variable instanceof int[]) {
                vars[i] = "[".concat(IntStream.of((int[]) variable).mapToObj(Integer::toString).collect(Collectors.joining(",")).concat("]"));
            }
        }
        printPrivateText(text, typingWaitGlobal, vars);
    }


    private static void printPrivateText(String text, int typingWait) {
        for (int i = 0; i < text.length(); i++) {
            if (typingWait > 0) {
                try {
                    sleep(typingWait);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(text.charAt(i));
        }
        if (!text.contains("\n")) {
            System.out.print(" ");
        }
    }

    private static void printPrivateText(String text, int typingWait, final Object... vars) {
        var newText = String.format(text, vars);
        for (int i = 0; i < newText.length(); i++) {
            if (typingWait > 0) {
                try {
                    sleep(typingWait);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(newText.charAt(i));
        }
        if (!text.contains("\n")) {
            System.out.print(" ");
        }
    }

    public static void printRainbowTitleLn(final String title) {
        printRainbowTitle(title);
        System.out.print("\n");
    }

    public static void printRainbowTitle(final String title) {
        List<String> consoleRainbow = ConColor.getConsoleRainbow();
        var k = 0;
        for (var i = 0; i < title.length(); i++) {
            if (k == consoleRainbow.size()) {
                k = 0;
            }
            System.out.print(consoleRainbow.get(k));
            System.out.print(title.charAt(i));
            if (title.charAt(i) != ' ') {
                k++;
            }
        }
    }

    public static void printRainbowLn(final String theme) {
        printRainbow(theme);
        System.out.print("\n");
    }

    public static void printRainbow(final String theme) {
        ConColor.getConsoleRainbow().forEach(color -> {
            System.out.print(color);
            System.out.print(theme);
        });
    }

    public static void printUnicornsLn(final int nUnicorns) {
        for (int i = 0; i < nUnicorns; i++) {
            System.out.print("🦄");
        }
        System.out.println("\n");
    }
}
