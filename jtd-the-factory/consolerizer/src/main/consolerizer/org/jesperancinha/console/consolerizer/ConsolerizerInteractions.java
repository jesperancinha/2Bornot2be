package org.jesperancinha.console.consolerizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.ORANGE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.RED;

public class ConsolerizerInteractions {
    public static void performQuestion(String question, String[] options, int maxFails, java.util.List<String> correctAnswers) {
        final var questionBlock = question.concat("\n");
        final var optionsBlock = String.join("\n", Arrays.asList(options));
        performQuestion(questionBlock.concat(optionsBlock), maxFails, correctAnswers);
    }

    public static void performQuestion(String question, int maxFails, java.util.List<String> correctAnswers) {
        RED.printSyncGenericLn("Q: " + question + ":");
        final var correctResponses = new ArrayList<String>();
        int fails = maxFails;
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
    }
}
