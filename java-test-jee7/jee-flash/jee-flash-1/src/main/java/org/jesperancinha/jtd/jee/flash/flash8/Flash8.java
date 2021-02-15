package org.jesperancinha.jtd.jee.flash.flash8;

import java.util.Arrays;

import static org.jesperancinha.console.consolerizer.Consolerizer.setupFastDefaultWideTitleSpread;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.YELLOW;
import static org.jesperancinha.console.consolerizer.ConsolerizerInteractions.performQuestion;

public class Flash8 {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Flash 8 - REST parameter types");
        setupFastDefaultWideTitleSpread();
        final String question = "Name the most important REST parameter annotations?";

        int maxFails = 5;
        final var correctAnswers = Arrays.asList("@CookieParam", "@QueryParam", "@PathParam", "@MatrixParam", "@HeaderParam", "@FormParam");

        if (!Arrays.asList(args).contains("-d8")) {
            performQuestion(question, maxFails, correctAnswers);
        }

        GREEN.printGenericLn("More reading");

        YELLOW.printGenericLn("from:\nhttps://stackoverflow.com/questions/10183875/whats-the-difference-between-queryparam-and-matrixparam-in-jax-rs");
        YELLOW.printGenericLn("from:\nhttps://docs.oracle.com/javaee/7/api/index.html");
        MAGENTA.printGenericLn("There are many types:");
        MAGENTA.printGenericLn("1. @CookieParam - Injection of a cookie");
        MAGENTA.printGenericLn("2. @QueryParam - Query param - http://address/path?name=value");
        MAGENTA.printGenericLn("3. @PathParam - Path param - http://address/path/value");
        MAGENTA.printGenericLn("4. @MatrixParam - Matrix param - http://address/path;name=value");
        MAGENTA.printGenericLn("5. @HeaderParam - Header param - Mostly used in POST requests");
        MAGENTA.printGenericLn("6. @FormParam - Form param - Another type of param that comes in forms");
    }
}