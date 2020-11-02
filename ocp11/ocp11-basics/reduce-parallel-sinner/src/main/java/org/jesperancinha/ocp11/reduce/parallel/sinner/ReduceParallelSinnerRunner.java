package org.jesperancinha.ocp11.reduce.parallel.sinner;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static java.lang.Thread.sleep;

/**
 * The first simulation probably doesn't work.
 * Our local PC's are so fast these days, that the phenomenon I want you to see is very unlikely to happen if we don't introduce some sort of delay.
 * The second should always work
 * We are trying to show that although parallel operations can occur within reduce, its final result is alwqys given by the order of elements given in the liwt
 * In other words we never get "Jamie BurnsNickHaas" as a result. We can however get "Nick HaasJamie Burns".
 */
public class ReduceParallelSinnerRunner {
    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.printf("**************************** Try number %d\n", i + 1);
            List<String> carCrashCharacters = Arrays.asList("Nick Haas", "Jamie Burns");
            String victims = carCrashCharacters.parallelStream().reduce("\nHe was a victim -> ", (a, b) -> a.concat(b));
            System.out.println(victims);
            System.out.println("**************************** Done!");
            if (victims.contains("Nick HaasJamie Burns")) {
                System.out.println("**************************** Found Nick HaasJamie Burns!");
                break;
            }

        }
        System.out.println("**************************** It probably didn't work! Let's simulate a delay now...");

        AtomicLong atomicInteger = new AtomicLong(500);
        for (int i = 0; i < 10; i++) {
            System.out.printf("**************************** Try number %d\n", i + 1);
            List<String> carCrashCharacters = Arrays.asList("Nick Haas", "Jamie Burns");
            String victims = carCrashCharacters
                    .stream()
                    .peek(s -> {
                        try {
                            sleep(atomicInteger.addAndGet(100));
                        } catch (Exception e) {

                        }
                    })
                    .reduce("\nHe was a victim -> ", (a, b) -> a.concat(b));
            System.out.println(victims);
            System.out.println("**************************** Done!");
            if (victims.contains("Nick HaasJamie Burns")) {
                System.out.println("**************************** Found Nick HaasJamie Burns!");
                break;
            }
        }

        System.out.println("**************************** Let's try to reverse the order..");

        AtomicLong atomicInteger2 = new AtomicLong(500);
        for (int i = 0; i < 10; i++) {
            System.out.printf("**************************** Try number %d\n", i + 1);
            List<String> carCrashCharacters = Arrays.asList("Nick Haas", "Jamie Burns");
            String victims = carCrashCharacters
                    .stream()
                    .peek(s -> {
                        try {
                            sleep(atomicInteger2.addAndGet(-100));
                        } catch (Exception e) {

                        }
                    })
                    .reduce("\nHe was a victim -> ", (a, b) -> a.concat(b));
            System.out.println(victims);
            System.out.println("**************************** Done!");
            if (victims.contains("Jamie BurnsNick Haas")) {
                System.out.println("**************************** Found Jamie BurnsNick Haas!");
                break;
            }
        }

        System.out.println("**************************** As you can see, we couldn't create Jamie BurnsNick Haas");
    }
}
