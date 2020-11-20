package org.jesperancinha.ocp11.mastery4dot1;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.ocp11.mastery4dot1.levels.BeginnerException;
import org.jesperancinha.ocp11.mastery4dot1.levels.ExpertException;
import org.jesperancinha.ocp11.mastery4dot1.levels.JuniorException;
import org.jesperancinha.ocp11.mastery4dot1.levels.MediorException;
import org.jesperancinha.ocp11.mastery4dot1.levels.RookieException;
import org.jesperancinha.ocp11.mastery4dot1.levels.SeniorException;

import java.util.Scanner;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightCyanGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGeneric;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedThrowableAndExit;
import static org.jesperancinha.console.consolerizer.Consolerizer.printUnicornsLn;

public class Mastery4Dot1Runner {
    public static void main(String[] args) {
        Consolerizer.typingWaitGlobal = 0;

        printBlueGenericLn("================== Master Module mastery-4-1 ==================");

        printBrightCyanGenericLn("--- 1. `Exception` `catch` order");
        printRainbowLn("==");
        printGreenGenericLn("Case: We have just made a test about the history of the United States of America.");
        printGreenGenericLn("You are applying for a United States residency and nationality.");
        printGreenGenericLn("You will be qualified in 6 levels in lowest to highest order:");
        printGreenGenericLn("rookie, beginner, junior, medior, expert or senior");
        final var scanner = new Scanner(System.in);
        try {
            printBrightCyanGenericLn("In what year was president JFK born?");
            if (!scanner.nextLine().equals("1917")) {
                throw new RookieException();
            }
            printBrightCyanGenericLn("JFK was which president of the United States of America?");
            if (!scanner.nextLine().equals("35")) {
                throw new BeginnerException();
            }
            printBrightCyanGenericLn("How many years was JFK in power?");
            if (!scanner.nextLine().equals("3")) {
                throw new JuniorException();
            }
            printBrightCyanGenericLn("In what year did JFK enrolled in Harvard University?");
            if (!scanner.nextLine().equals("1936")) {
                throw new JuniorException();
            }
            printBrightCyanGenericLn("In what year did JFK write his senior thesis on how Britain was in a considerable weak position against the germans in WWII?");
            if (!scanner.nextLine().equals("1939")) {
                throw new MediorException();
            }
            printBrightCyanGenericLn("When did JFK graduated?");
            if (!scanner.nextLine().equals("1940")) {
                throw new ExpertException();
            }
            printBrightCyanGenericLn("How manu copies did `Why England Slept` sold?");
            if (!scanner.nextLine().equals("80000")) {
                throw new SeniorException();
            }
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

        printUnicornsLn(100);
        printGreenGenericLn("Hope you enjoyed this mastery into Java 11 with the united states of america's history flavour to it.");
        printGreenGenericLn("Please keep coming back as I'll be creating more mastery modules.");
        printGreenGenericLn("Thank you!");
        printUnicornsLn(100);
    }
}
