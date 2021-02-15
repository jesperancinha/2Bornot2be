package org.jesperancinha.jtd.jee.flash.flash13;

import java.util.Arrays;
import java.util.List;

import static org.jesperancinha.console.consolerizer.Consolerizer.setupFastDefaultWideTitleSpread;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.ConsolerizerInteractions.performQuestion;

public class Flash13 {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Flash 13 - JEE Tiers");
        setupFastDefaultWideTitleSpread();
        final String question = "Java Enterprise consists of a few tiers. Name all of them";

        int maxFails = 5;

        final var correctAnswers = List.of("Client", "Web", "Business", "Enterprise Information System");

        if (!Arrays.asList(args).contains("-d13")) {
            performQuestion(question, maxFails, correctAnswers);
        }

        GREEN.printGenericLn("More reading");
        MAGENTA.printGenericLn("1. https://docs.oracle.com/javaee/5/tutorial/doc/bnaay.html");
    }
}