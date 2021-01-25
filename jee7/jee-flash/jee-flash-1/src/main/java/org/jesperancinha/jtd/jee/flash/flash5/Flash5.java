package org.jesperancinha.jtd.jee.flash.flash5;

import java.util.Arrays;

import static org.jesperancinha.console.consolerizer.Consolerizer.setupFastDefaultWideTitleSpread;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.YELLOW;
import static org.jesperancinha.console.consolerizer.ConsolerizerInteractions.performQuestion;

public class Flash5 {
    public static void main(String[] args) {

        BLUE.printGenericTitleLn("Flash 5 - Relevant classes for JAAS (Java Authentication and Authorization Service)");
        setupFastDefaultWideTitleSpread();
        final String question = "Which classes are the most relevant for JAAS ?";

        int maxFails = 5;
        final var correctAnswers = Arrays.asList("LoginContext", "LoginModule", "CodeSource", "Configuration", "Principal", "Subject");

        if (!Arrays.asList(args).contains("-d5")) {
            performQuestion(question, maxFails, correctAnswers);
        }

        GREEN.printGenericLn("More reading");

        YELLOW.printGenericLn("from:\nhttps://docs.oracle.com/javase/8/docs/technotes/guides/security/jaas/JAASRefGuide.html");
        MAGENTA.printGenericLn("The relevant classes are:");
        MAGENTA.printGenericLn("1. LoginContext");
        MAGENTA.printGenericLn("2. LoginModule");
        MAGENTA.printGenericLn("3. CodeSource");
        MAGENTA.printGenericLn("4. Configuration");
        MAGENTA.printGenericLn("5. Principal");
        MAGENTA.printGenericLn("6. Subject");
    }
}