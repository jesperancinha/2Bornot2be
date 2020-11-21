package org.jesperancinha.ocp11.mastery4dot1;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.ocp11.mastery4dot1.levels.BeginnerException;
import org.jesperancinha.ocp11.mastery4dot1.levels.ExpertException;
import org.jesperancinha.ocp11.mastery4dot1.levels.JuniorException;
import org.jesperancinha.ocp11.mastery4dot1.levels.MediorException;
import org.jesperancinha.ocp11.mastery4dot1.levels.RookieException;
import org.jesperancinha.ocp11.mastery4dot1.levels.SeniorException;
import org.jesperancinha.ocp11.mastery4dot1.levels.SuperSeniorException;

import java.util.Scanner;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightCyanGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedThrowableAndExit;
import static org.jesperancinha.console.consolerizer.Consolerizer.printUnicornsLn;

public class Mastery4Dot1Runner {
    private static boolean skipQuestions;

    public static void main(String[] args) {
        if (args.length > 0) {
            skipQuestions = "-skip".equals(args[0]);
        }
        Consolerizer.typingWaitGlobal = 0;
        printBlueGenericLn("================== Master Module mastery-4-1 ==================");

        exercise1();
        exercise2();

        printUnicornsLn(100);
        printGreenGenericLn("Hope you enjoyed this mastery into Java 11 with the united states of america's history flavour to it.");
        printGreenGenericLn("Please keep coming back as I'll be creating more mastery modules.");
        printGreenGenericLn("Thank you!");
        printUnicornsLn(100);
    }

    private static void exercise2() {
        printBrightCyanGenericLn("--- 2. What is the output of `String` for it's 3 different kind of values: `null`, \"\" and \"Something\"");
        printRainbowLn("==");
        printGreenGenericLn("Case: Three students are making resets: Katie, Chloe and Susan");
        printBlueGenericLn("Teacher: In what year was JFK assigned to the ONI field office at Headquarters");
        final String katieResponse = null;
        printMagentaGenericLn("Katie: Hmmmm.... " + katieResponse);
        printBlueGenericLn("T: That is not correct. Chloe?");
        final var chloeResponse = "";
        printMagentaGenericLn("Chloe: I don't know, maybe, %s", chloeResponse);
        printBlueGenericLn("T: You also don't know? How about you Susan?");
        final Object susanResponse = "January 1942";
        printMagentaGenericLn("Susan: Of course I do! It was in %s", susanResponse);

        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. An empty string does not generate output");
        printGreenGenericLn("2. A null string generates `null` as output");
        printGreenGenericLn("3. A string with a value, generates that value as output");
    }

    private static void exercise1() {
        printBrightCyanGenericLn("--- 1. `Exception` `catch` order");
        printRainbowLn("==");
        printGreenGenericLn("Case: We have just made a test about the history of the United States of America.");
        printGreenGenericLn("You are applying for a United States residency and nationality.");
        printGreenGenericLn("You will be qualified in 6 levels in lowest to highest order:");
        printGreenGenericLn("rookie, beginner, junior, medior, expert or senior");
        final var scanner = new Scanner(System.in);
        try {
            question(scanner, "In what year was president JFK born?", "1917", new RookieException());
            question(scanner, "JFK was which president of the United States of America?", "35", new BeginnerException());
            question(scanner, "How many years was JFK in power?", "3", new JuniorException());
            question(scanner, "In what year did JFK enrolled in Harvard University?", "1936", new MediorException());
            question(scanner, "In what year did JFK write his senior thesis on " +
                    "how Britain was in a considerable weak position against the germans in WWII?", "1939", new ExpertException());
            question(scanner, "When did JFK graduated?", "1940", new SeniorException());
            question(scanner, "How many copies did `Why England Slept` sold?", "80000", new SuperSeniorException());
        } catch (SuperSeniorException e) {
            printMagentaGenericLn("You are a Super Senior!");
        } catch (SeniorException e) {
            printMagentaGenericLn("You are a Senior!");
        } catch (ExpertException e) {
            printMagentaGenericLn("You are a Expert!");
        } catch (MediorException e) {
            printMagentaGenericLn("You are a Medior!");
        } catch (JuniorException e) {
            printMagentaGenericLn("You are a Junior!");
        } catch (BeginnerException e) {
            printMagentaGenericLn("You are a Beginner!");
        } catch (RookieException e) {
            printMagentaGenericLn("You are a Rookie!");
        } catch (Exception e) {
            printRedThrowableAndExit(e);
        }
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. In a try with multiple catches, the order is more specific to more generic");
    }

    private static void question(Scanner scanner, String s, String s2, RookieException e) throws RookieException {
        printBrightCyanGenericLn(s);
        String a7;
        if (skipQuestions) {
            a7 = s2;
            printGreenGenericLn(a7);
        } else {
            a7 = scanner.nextLine();
        }
        if (!a7.equals(s2)) {
            throw e;
        }
    }
}
