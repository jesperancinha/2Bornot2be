package org.jesperancinha.jtd.jee.flash.flash1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.jesperancinha.console.consolerizer.Consolerizer.setupFastDefaultWideTitleSpread;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.ORANGE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.RED;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.YELLOW;

public class Flash1 {
    public static void main(String[] args) {
        setupFastDefaultWideTitleSpread();
        BLUE.printGenericTitleLn("Crum1 - Which are Java EE components ?");
        RED.printSyncGenericLn("Q: Name all Java EE components that you know:");

        int maxFails = 5;
        int fails = maxFails;
        final var correctAnswers = Arrays.asList("JSF", "JSP", "Servlet", "Application", "Applet", "EJB", "Business Components");
        final var correctResponses = new ArrayList<String>();
        while (fails-- > 0 && correctResponses.size() != correctAnswers.size()) {
            Scanner sc = new Scanner(System.in);
            final String answer = sc.nextLine();
            if (correctAnswers.stream().anyMatch(answer::contains)) {
                if (correctAnswers
                        .stream()
                        .filter(ca -> ca.contains(answer))
                        .findAny()
                        .map(ca -> correctResponses.stream().anyMatch(cr -> cr.contains(ca))).orElse(false)) {
                    ORANGE.printGenericLn("You've answered this already! %d correct , %d to go! You have %d tries left", correctResponses.size(), correctAnswers.size() - correctResponses.size(), fails);
                } else {
                    correctResponses.add(answer);
                    fails = maxFails;
                    GREEN.printGenericLn("Correct! %d correct , %d to go! You have %d tries left", correctResponses.size(), correctAnswers.size() - correctResponses.size(), fails);
                }
            } else {
                RED.printGenericLn("Fail! %d correct , %d to go! You have %d tries left", correctResponses.size(), correctAnswers.size() - correctResponses.size(), fails);
            }
        }

        if (correctResponses.size() == correctAnswers.size()) {
            GREEN.printGenericLn("You have answered this question correctly! 👍");
        } else {
            RED.printGenericLn("You have failed this question! No worries, just study harder next time 😊");
        }
        ORANGE.printGenericLn("Correct answers were %s", correctAnswers);
        MAGENTA.printGenericLn("Your correct answers were %s", correctResponses);

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
