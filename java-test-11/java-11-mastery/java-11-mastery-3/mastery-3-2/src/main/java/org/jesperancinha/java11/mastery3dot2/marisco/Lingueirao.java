package org.jesperancinha.java11.mastery3dot2.marisco;

import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Lingueirao {

   static  {
        printYellowGenericLn("Lingueirão comes out to clean up his house! 🪒");
        if (true) {
            throw new RuntimeException("Oh no! A bird just caught him! We won't fish this one! 🦅");
        }
    }

    public static Lingueirao fishLingueirao() {
        printYellowGenericLn("Trying to catch Lingueirão 🕸");
        return new Lingueirao();
    }
}
