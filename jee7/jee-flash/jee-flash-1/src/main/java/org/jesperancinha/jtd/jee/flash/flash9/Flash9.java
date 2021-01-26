package org.jesperancinha.jtd.jee.flash.flash9;

import java.util.Arrays;
import java.util.Collections;

import static org.jesperancinha.console.consolerizer.Consolerizer.setupFastDefaultWideTitleSpread;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.YELLOW;
import static org.jesperancinha.console.consolerizer.ConsolerizerInteractions.performQuestion;

public class Flash9 {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Flash 9 - Throwing Exception to rollback");
        setupFastDefaultWideTitleSpread();
        final String question = "When you want to rollback a transaction, can you throw any transaction? Which one if not?";

        int maxFails = 1;
        final var correctAnswers = Collections.singletonList("ApplicationException");

        if (!Arrays.asList(args).contains("-d9")) {
            performQuestion(question, maxFails, correctAnswers);
        }

        GREEN.printGenericLn("More reading");

        YELLOW.printGenericLn("from:\nhttps://tomee.apache.org/examples-trunk/applicationexception/");
        YELLOW.printGenericLn("from:\nhttps://docs.oracle.com/javaee/7/api/javax/ejb/ApplicationException.html");
        MAGENTA.printGenericLn("An Exception on its own will not trigger a rollback");
        MAGENTA.printGenericLn("It has to be of type javax.ejb.ApplicationException");
    }
}