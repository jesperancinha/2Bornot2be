package org.jesperancinha.java11.crums.crum13;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedThrowableAndExit;

public class Crum13 {
    class Running {
        public void running() throws Exception {
            printOrangeGenericLn("We are now running....");
        }
    }

    public class Marathon extends Running {
        public void running() {
            printOrangeGenericLn("We are now in the marathon...");
        }

    }

    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 13 - Overriding throws");

        final Crum13 crum13 = new Crum13();
        Running running = crum13.new Marathon();
        try {
            running.running();
        } catch (Exception e) {
            printRedThrowableAndExit(e);
        }

        printGreenGenericLn("The rule is always that the method overriding is always more specific if we choose to override the exception");
        printGreenGenericLn("No exception is always acceptable in the overriding method.");
    }
}
