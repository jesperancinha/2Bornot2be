package org.jesperancinha.jtd.jee.flash.flash4;

import java.util.Arrays;

import static org.jesperancinha.console.consolerizer.Consolerizer.setupFastDefaultWideTitleSpread;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.YELLOW;
import static org.jesperancinha.console.consolerizer.ConsolerizerInteractions.performQuestion;

public class Flash4 {
    public static void main(String[] args) {

        BLUE.printGenericTitleLn("Flash 4 - What is JAAS (Java Authentication and Authorization Service) ?");
        setupFastDefaultWideTitleSpread();
        final String question = "What can JAAS be used for?";

        int maxFails = 1;
        final var correctAnswers = Arrays.asList("authentication", "authorization", "PAM");

        if (!Arrays.asList(args).contains("-d4")) {
            performQuestion(question, maxFails, correctAnswers);
        }

        GREEN.printGenericLn("More reading");

        YELLOW.printGenericLn("from:\nhttps://docs.oracle.com/javase/8/docs/technotes/guides/security/jaas/JAASRefGuide.html");
        MAGENTA.printGenericLn("JAAS implements authentication architecture");
        MAGENTA.printGenericLn("JAAS implements authorization architecture");
        MAGENTA.printGenericLn("JAAS implements PAM(Pluggable Authentication Module)");
    }
}