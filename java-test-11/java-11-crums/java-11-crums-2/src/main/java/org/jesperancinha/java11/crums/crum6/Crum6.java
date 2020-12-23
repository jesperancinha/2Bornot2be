package org.jesperancinha.java11.crums.crum6;

import java.io.PrintWriter;
import java.io.Reader;
import java.util.Objects;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;

public class Crum6 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 6 - Using Console in java");

        var console = System.console();
        if (Objects.isNull(console)) {
            printBrightMagentaGenericLn(
                "No console found! Please run this program from the command line to be able to exercise Crum6");
        } else {
            printMagentaGenericLn("Please insert a password:");
            final char[] password = console.readPassword();
            printMagentaGenericLn("This is your password -> %s", new String(password));
            final Reader reader = console.reader();
            printMagentaGenericLn("Reader which can be used by other readers -> %s", reader);
            final PrintWriter printWriter = console.writer();
            printMagentaGenericLn("PrintWriter which can be used by other writers -> %s", printWriter);
            console.format("We can also write your passord (%s) this way\n", new String(password));
            printMagentaGenericLn("Try writing a string now:");
            final String s = console.readLine();
            printMagentaGenericLn("This is your string %s", s);
            printGreenGenericLn(
                "Our console always has `readPassword`, `readLine`, a `writer`, a `reader` and we can write to the output via `format`");
        }
    }
}
