package org.jesperancinha.java11.crums.crum4;

import org.jesperancinha.console.consolerizer.Consolerizer;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedThrowableAndExit;

public class Crum4 {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 4 - The contents of a BufferedReader");

        printMagentaGenericLn("A buffered reader provides buffered functionality to a reader");
        printMagentaGenericLn(
            "This is actually the reason why a BufferedReader can be initialized with any reader, including itself");

        var bufferedReader1 = new BufferedReader(
            new InputStreamReader(new ByteArrayInputStream("This is a good String".getBytes())));

        int read;
        try {
            while ((read = bufferedReader1.read()) != -1) {
                Consolerizer.printYellowGeneric((char) read);
            }
        } catch (IOException e) {
            printRedThrowableAndExit(e);
        }

        Consolerizer.printNewLine();
        bufferedReader1 = new BufferedReader(
            new InputStreamReader(new ByteArrayInputStream("This is a good String".getBytes())));

        var bufferedReader2 = new BufferedReader(bufferedReader1);

        try {
            while ((read = bufferedReader2.read()) != -1) {
                Consolerizer.printYellowGeneric((char) read);
            }
        } catch (IOException e) {
            printRedThrowableAndExit(e);
        }
        Consolerizer.printNewLine();

        printGreenGenericLn(
            "The point is that a BufferedReader can be creater with all java.io.Reader subtypes and java.io.Reader included");
    }
}
