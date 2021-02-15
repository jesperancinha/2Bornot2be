package org.jesperancinha.jtd.jee.flash.flash6;

import java.util.Arrays;

import static org.jesperancinha.console.consolerizer.Consolerizer.setupFastDefaultWideTitleSpread;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.YELLOW;
import static org.jesperancinha.console.consolerizer.ConsolerizerInteractions.performQuestion;

public class Flash6 {
    public static void main(String[] args) {

        BLUE.printGenericTitleLn("Flash 6 - Namespaces for placeholders");
        setupFastDefaultWideTitleSpread();
        final String question = "Which two most important namespaces give you the possibility to create a nice placeholder?";

        int maxFails = 2;
        final var correctAnswers = Arrays.asList("XHTML", "Passthrough");

        if (!Arrays.asList(args).contains("-d6")) {
            performQuestion(question, maxFails, correctAnswers);
        }

        GREEN.printGenericLn("More reading");

        YELLOW.printGenericLn("from:\nhttps://javaee.github.io/tutorial/jsf-facelets009.html");
        MAGENTA.printGenericLn("The relevant namespaces are:");
        MAGENTA.printGenericLn("1. http://www.w3.org/1999/xhtml");
        MAGENTA.printGenericLn("2. http://xmlns.jcp.org/jsf/passthrough");
    }
}