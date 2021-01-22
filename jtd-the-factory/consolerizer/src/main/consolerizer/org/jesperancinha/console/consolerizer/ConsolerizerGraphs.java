package org.jesperancinha.console.consolerizer;

import java.util.List;

public class ConsolerizerGraphs {

    public static String getUnicorns(int i) {
        final var sb = new StringBuilder();
        for (int j = 0; j < i; j++) {
            sb.append("🦄");
        }
        return sb.toString();
    }

    public static void printRainbowFlag(String flagText, Object... args) {
        printRainbowFlag(String.format(flagText, args));
    }

    /**
     * Follows the 19:10 rule for general flags
     *
     * @param flagText The text to be placed at the center of the flag
     */
    public static void printRainbowFlag(String flagText) {
        printRainbowFlag(flagText, new ConsolerizerConsoleWriter());

    }
    public static void printRainbowFlag(String flagText, ConsolerizerWriter consolerizerWriter) {
        int heightPerColorBar = (int) ((double) (Consolerizer.titleSpread) * 10d / 19d) / 6 / 4;
        heightPerColorBar = heightPerColorBar <= 0 ?
                1 :
                heightPerColorBar;
        final List<ConsolerizerColor> consoleRainbow = ConsolerizerColor.getConsoleRainbowEnumList();
        final int rainbowColorSize = consoleRainbow.size();
        final int height = rainbowColorSize * heightPerColorBar;
        int iMiddle = height / 2;
        iMiddle = height % 2 == 0 ?
                iMiddle - 1 :
                iMiddle;
        for (int i = 0, k = 0; i < rainbowColorSize; i++) {
            consolerizerWriter.printColor(consoleRainbow.get(i));
            for (int j = 0; j < heightPerColorBar; j++, k++) {
                if (k == iMiddle || k == iMiddle + 1) {
                    consolerizerWriter.printPrivateText(Consolerizer.createTitleLine(flagText, '*'));
                } else {
                    consolerizerWriter.printPrivateText("*".repeat(Consolerizer.titleSpread));
                }
                consolerizerWriter.printNewLine();
            }
        }
    }

    public static void printUnicornsLn(final int nUnicorns) {
        Consolerizer.printRainbowLn('-', nUnicorns / 4);
        for (int i = 0; i < nUnicorns; i++) {
            System.out.print("🦄");
        }
        Consolerizer.printNewLine();
        Consolerizer.printRainbowLn('-', nUnicorns / 4);
    }
}
