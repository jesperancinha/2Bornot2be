package org.jesperancinha.console.consolerizer;

import java.util.List;

public class ConGraphs {

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
        int heightPerColorBar = (int) ((double) (Consolerizer.titleSpread) * 10d / 19d) / 6 / 4;
        heightPerColorBar = heightPerColorBar <= 0 ?
                1 :
                heightPerColorBar;
        final List<ConColor> consoleRainbow = ConColor.getConsoleRainbowEnumList();
        final int ranbowColorSize = consoleRainbow.size();
        final int height = ranbowColorSize * heightPerColorBar;
        int iMiddle = height / 2;
        iMiddle = height % 2 == 0 ?
                iMiddle - 1 :
                iMiddle;
        for (int i = 0, k = 0; i < ranbowColorSize; i++) {
            Consolerizer.printColor(consoleRainbow.get(i));
            for (int j = 0; j < heightPerColorBar; j++, k++) {
                if (k == iMiddle || k == iMiddle + 1) {
                    Consolerizer.printPrivateText(Consolerizer.createTitleLine(flagText, '*'));
                } else {
                    Consolerizer.printPrivateText("*".repeat(Consolerizer.titleSpread));
                }
                Consolerizer.printNewLine();
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
