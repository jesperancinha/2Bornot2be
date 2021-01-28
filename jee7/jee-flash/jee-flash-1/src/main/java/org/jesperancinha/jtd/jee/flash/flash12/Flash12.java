package org.jesperancinha.jtd.jee.flash.flash12;

import java.util.Arrays;
import java.util.List;

import static org.jesperancinha.console.consolerizer.Consolerizer.setupFastDefaultWideTitleSpread;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.ConsolerizerInteractions.performQuestion;

public class Flash12 {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Flash 12 - JSTL in JSP and JSF");
        setupFastDefaultWideTitleSpread();
        final String question = "The core library for JSP and JSF differ in many aspects, but given iteration, testing and localization functions, which one is JSP missing?";

        int maxFails = 5;

        final var correctAnswers = List.of("localization");

        if (!Arrays.asList(args).contains("-d12")) {
            performQuestion(question, maxFails, correctAnswers);
        }

        GREEN.printGenericLn("More reading");
        BLUE.printGenericTitleLn("Usage of core in JSF/XHTML and JSP");
        MAGENTA.printGenericLn("1. https://docs.oracle.com/javaee/7/javaserver-faces-2-2/vdldocs-facelets/c/tld-summary.html");
        MAGENTA.printGenericLn("2. https://docs.oracle.com/javaee/5/jstl/1.1/docs/tlddocs/c/tld-summary.html");
        BLUE.printGenericTitleLn("Usage of locale in JSF/XHTML");
        MAGENTA.printGenericLn("3. https://docs.oracle.com/javaee/7/javaserver-faces-2-2/vdldocs-facelets/f/view.html");
    }
}