package org.jesperancinha.jtd.jee.flash.flash7;

import java.util.Arrays;
import java.util.Collections;

import static org.jesperancinha.console.consolerizer.Consolerizer.setupFastDefaultWideTitleSpread;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.YELLOW;
import static org.jesperancinha.console.consolerizer.ConsolerizerInteractions.performQuestion;

public class Flash7 {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Flash 7 - Default error page");
        setupFastDefaultWideTitleSpread();
        final String question = "In which way can we define the inner node error-code of error-page to accept all error codes and work as a default page?";

        int maxFails = 2;
        final var correctAnswers = Collections.singletonList("omission");

        if (!Arrays.asList(args).contains("-d7")) {
            performQuestion(question, maxFails, correctAnswers);
        }

        GREEN.printGenericLn("More reading");

        YELLOW.printGenericLn("from:\nhttps://documentation.bloomreach.com/14/library/concepts/error-pages-and-error-handling/1.-handling-error-codes-and-exceptions-by-the-web.xml.html");
        YELLOW.printGenericLn("from:\nhttps://mail.codejava.net/java-ee/servlet/how-to-handle-error-in-web-xml-for-java-web-applications");
        MAGENTA.printGenericLn("You configure this by omitting the whole node. If you try * it will fail");
        MAGENTA.printGenericLn("Wildcard star does not work alone for error-code");
    }
}