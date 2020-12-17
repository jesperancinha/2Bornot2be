package org.jesperancinha.ocp11.crums.crum5;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;

public class Crum5 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 5 - DateTimeFormatter of pattern");

        var dateTimeFormatter = DateTimeFormatter.ofPattern("e d y h H s m 'wow!' 'This is cool'");
        printOrangeGenericLn(dateTimeFormatter);
        printMagentaGenericLn(dateTimeFormatter.format(LocalDateTime.now()));
        var dateTimeFormatter2 = DateTimeFormatter.ofPattern("ee dd yy hh HH ss mm");
        printOrangeGenericLn(dateTimeFormatter2);
        printMagentaGenericLn(dateTimeFormatter2.format(LocalDateTime.now()));
        try {
            var dateTimeFormatter3 = DateTimeFormatter.ofPattern("eee ddd yyy hhh HHH sss mmm");
            printOrangeGenericLn(dateTimeFormatter3);
            printMagentaGenericLn(dateTimeFormatter3.format(LocalDateTime.now()));
        } catch (java.lang.IllegalArgumentException e) {
            printRedGenericLn(
                "This is expected. The parameter for day of the month may only have 2 digits at max -> %s", e);
        }

        try {
            var dateTimeFormatter3 = DateTimeFormatter.ofPattern("eee dd yyy hhh HHH sss mmm");
            printOrangeGenericLn(dateTimeFormatter3);
            printMagentaGenericLn(dateTimeFormatter3.format(LocalDateTime.now()));
        } catch (java.lang.IllegalArgumentException e) {
            printRedGenericLn("This is expected. The parameter for hour may only have 2 digits at max -> %s", e);
        }

        try {
            var dateTimeFormatter3 = DateTimeFormatter.ofPattern("eee dd yyy hh HHH sss mmm");
            printOrangeGenericLn(dateTimeFormatter3);
            printMagentaGenericLn(dateTimeFormatter3.format(LocalDateTime.now()));
        } catch (java.lang.IllegalArgumentException e) {
            printRedGenericLn("This is expected. The parameter for 24 hour may only have 2 digits at max -> %s", e);
        }

        try {
            var dateTimeFormatter3 = DateTimeFormatter.ofPattern("eee dd yyy hh HH ss mmm");
            printOrangeGenericLn(dateTimeFormatter3);
            printMagentaGenericLn(dateTimeFormatter3.format(LocalDateTime.now()));
        } catch (java.lang.IllegalArgumentException e) {
            printRedGenericLn("This is expected. The parameter for seconds may only have 2 digits at max -> %s", e);
        }

        try {
            var dateTimeFormatter3 = DateTimeFormatter.ofPattern("eee dd yyy hh HH ss mmm");
            printOrangeGenericLn(dateTimeFormatter3);
            printMagentaGenericLn(dateTimeFormatter3.format(LocalDateTime.now()));
        } catch (java.lang.IllegalArgumentException e) {
            printRedGenericLn("This is expected. The parameter for minutes may only have 2 digits at max -> %s", e);
        }

        var dateTimeFormatter3 = DateTimeFormatter.ofPattern("eee dd yyy hh HH ss mm");
        printOrangeGenericLn(dateTimeFormatter3);
        printMagentaGenericLn(dateTimeFormatter3.format(LocalDateTime.now()));

        var dateTimeFormatter4 = DateTimeFormatter.ofPattern("eeee dd yyyy hh HH ss mm");
        printOrangeGenericLn(dateTimeFormatter4);
        printMagentaGenericLn(dateTimeFormatter4.format(LocalDateTime.now()));

        var dateTimeFormatter5 = DateTimeFormatter.ofPattern("eeeee dd yyyyy hh HH ss mm");
        printOrangeGenericLn(dateTimeFormatter5);
        printMagentaGenericLn(dateTimeFormatter5.format(LocalDateTime.now()));

        try {
            var dateTimeFormatter6 = DateTimeFormatter.ofPattern("eeeeee dd yyyyyy hh HH ss mm");
            printOrangeGenericLn(dateTimeFormatter6);
            printMagentaGenericLn(dateTimeFormatter6.format(LocalDateTime.now()));
        } catch (java.lang.IllegalArgumentException e) {
            printRedGenericLn("This is expected. The maximum repetition possible for any patter is 5-> %s", e);
        }

        printGreenGenericLn("We can generally say that 5 is the maximum digit repetition for a DateTimeFormatter");
        printGreenGenericLn("We can introduce our own text. To escape it we put it between single quotes");
        printGreenGenericLn("Some digit types like 24 hour, hour, minute, second, day of the month, only allow up to 2 repetitions");
    }
}
