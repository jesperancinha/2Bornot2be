package org.jesperancinha.ocp11.crums.crum43;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedThrowableAndExit;

public class Crum43 {
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
        printBlueGenericTitleLn("Crum 43 - Overriding throws");

        final Crum43 crum43 = new Crum43();
        Running running = crum43.new Marathon();
        try {
            running.running();
        } catch (Exception e) {
            printRedThrowableAndExit(e);
        }



    }
}
