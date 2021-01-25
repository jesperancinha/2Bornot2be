package org.jesperancinha.jtd.jee.flash.flash1;

import java.util.Arrays;

import static org.jesperancinha.console.consolerizer.Consolerizer.setupFastDefaultWideTitleSpread;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.ORANGE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.YELLOW;
import static org.jesperancinha.console.consolerizer.ConsolerizerInteractions.performQuestion;

public class Flash1 {
    public static void main(String[] args) {

        BLUE.printGenericTitleLn("Flash 1 - Which are Java EE components ?");
        setupFastDefaultWideTitleSpread();
        final String question = "Name all Java EE components that you know";
        int maxFails = 5;
        final var correctAnswers = Arrays.asList("JSF", "JSP", "Servlet", "Application", "Applet", "EJB", "Business Components");

        if (!Arrays.asList(args).contains("-d1")) {
            performQuestion(question, maxFails, correctAnswers);
        }

        GREEN.printGenericLn("More reading");

        YELLOW.printGenericLn("from:\nhttps://turngeek.github.io/javaee7inaweek/chapter/i-2-the-component-architecture-of-java-ee-7/");
        MAGENTA.printGenericLn("Web Components:");
        ORANGE.printGenericLn("Java Server Faces (JSF)");
        ORANGE.printGenericLn("Java Servlet");
        ORANGE.printGenericLn("Java Server Pages (JSP)");
        MAGENTA.printGenericLn("Java EE Components:");
        MAGENTA.printGenericLn("Application clients and applets that run on the client");
        MAGENTA.printGenericLn("Enterprise Java Beans (EJB) and business components that run on the server");
    }
}
