package org.jesperancinha.console.consolerizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.ORANGE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.RED;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.YELLOW;

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

    public static void performQuestion(String question, int maxFails, final Map<String, List<String>> correctAnswers) {
        RED.printSyncGenericLn("Q: " + question + ":");
        YELLOW.printGenericLn("NOTE: To provide an answer use a =>. Left side is the key and the right side is the value");
        final var correctResponses = new HashMap<String, List<String>>();
        int fails = maxFails;
        while (fails-- > 0 && correctResponses.size() != correctAnswers.size()) {
            Scanner sc = new Scanner(System.in);
            final String answer = sc.nextLine();
            final var keyValue = answer.split("=>");
            if (keyValue.length != 2) {
                RED.printGenericLn("Fail! %d correct , %d to go! You have %d tries left", correctResponses.size(), correctAnswers.size() - correctResponses.size(), fails);
                continue;
            }
            final String key = keyValue[0].trim();
            final List<String> value = Arrays.stream(keyValue[1].trim().split(",")).map(String::trim).collect(Collectors.toList());

            final List<String> correctAnswersList = correctAnswers.get(key);
            if (Objects.nonNull(correctAnswersList) && value.containsAll(correctAnswersList)) {
                if (correctAnswersList
                        .stream()
                        .filter(ca -> ca.contains(answer))
                        .findAny()
                        .map(ca -> correctResponses.get(key).stream().anyMatch(cr -> cr.contains(ca))).orElse(false)) {
                    ORANGE.printGenericLn("You've answered this already! %d correct , %d to go! You have %d tries left", correctResponses.size(), correctAnswers.size() - correctResponses.size(), fails);
                } else {
                    correctResponses.put(key, value);
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
