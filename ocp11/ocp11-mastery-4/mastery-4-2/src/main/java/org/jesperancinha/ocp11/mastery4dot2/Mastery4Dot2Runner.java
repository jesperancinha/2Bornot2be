package org.jesperancinha.ocp11.mastery4dot2;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.ocp11.mastery4dot2.concert.Band;
import org.jesperancinha.ocp11.mastery4dot2.concert.GenericBand;
import org.jesperancinha.ocp11.mastery4dot2.concert.QuintetBand;
import org.jesperancinha.ocp11.mastery4dot2.concert.Ticket;
import org.jesperancinha.ocp11.mastery4dot2.record.Company;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightCyanGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printUnicornsLn;
import static org.jesperancinha.ocp11.mastery4dot2.concert.Ticket.getTicketsLongNumbers;
import static org.jesperancinha.ocp11.mastery4dot2.concert.Ticket.getTicketsStringNumbers;

public class Mastery4Dot2Runner {
    private static boolean skipQuestions;

    public static void main(String[] args) {
        if (args.length > 0) {
            skipQuestions = "-skip".equals(args[0]);
        }
        Consolerizer.typingWaitGlobal = 0;
        printBlueGenericLn("==================== Master Module mastery-4-2 ====================");
        printBlueGenericLn("----> Run with -ea or -enableassertions for a more accurate run");

        exercise1();
        exercise2();
        exercise3();
        exercise4();
        exercise5();
        exercise6();

        printUnicornsLn(100);
        printGreenGenericLn("Hope you enjoyed this mastery into Java 11 with some Spanish Indie/Pop flavor flavour to it.");
        printGreenGenericLn("Please keep coming back as I'll be creating more mastery modules.");
        printGreenGenericLn("Thank you!");
        printUnicornsLn(100);
    }

    private static void exercise6() {
        printBrightCyanGenericLn("--- 6. Bypassing overloading methods with different return types");
        printRainbowLn("==");
        printGreenGenericLn("Case: We want to go one of the \"La casa azul\" concerts.");
        printGreenGenericLn("Time is running out to book them, we don't know to which one we can go to.");
        printGreenGenericLn("So we decide to buy a bunch of them.");
        var ticket1 = new Ticket("La casa azul", "El Ejido, " +
                "ES", "ES23424ES23432", LocalDateTime.of(2019, 4, 27, 0, 0, 0));
        var ticket2 = new Ticket("La casa azul", "El Ejido, " +
                "ES", 123232341342312L, LocalDateTime.of(2019, 4, 27, 0, 0, 0));
        var ticket3 = new Ticket("La casa azul", "Seville, " +
                "ES", 193874567394857L, LocalDateTime.of(2019, 6, 29, 0, 0, 0));
        printMagentaGenericLn("Our first ticket is -> %s", ticket1);
        printMagentaGenericLn("Our second ticket is -> %s", ticket2);
        printMagentaGenericLn("Our third ticket is -> %s", ticket3);
        printMagentaGenericLn("We have all the tickets for \"La casa azul\":\n%s", getTicketsStringNumbers("La casa azul"));
        printMagentaGenericLn("Some of them are just numbers:\n%s", getTicketsLongNumbers("La casa azul"));
        printBrightCyanGenericLn("We realize that we can only go to the latest one!");
        printBrightCyanGenericLn("Let's unregister te last two tickets");
        var ticket1U = Ticket.unregisterTicket("ES23424ES23432");
        var ticket2U = Ticket.unregisterTicket(123232341342312L);
        assert ticket1.equals(ticket1U);
        assert ticket2.equals(ticket2U);
        printMagentaGenericLn("We've unregistered tickets\n%s\nand\n%s", ticket1U, ticket2U);
        final var allTicketsLaCasaAzul = getTicketsStringNumbers("La casa azul");
        printMagentaGenericLn("We finally should only have one ticket in our reservation:\n%s", allTicketsLaCasaAzul);
        final var ticketNumber = allTicketsLaCasaAzul.get(0);
        final var finalTicket = Ticket.getTicket(ticketNumber);
        printMagentaGenericLn("Hurrah! We are going to %s to watch %s with ticket %s on the %s",
                finalTicket.getVenue(), finalTicket.getBandName(), finalTicket.getTicketNumber(), finalTicket.getLocalDateTime());
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. Methods can be overloaded if their parameters are different both in number and in types");
        printGreenGenericLn("2. The compiler cannot tell two methods apart if they differ only in their return type");
        printGreenGenericLn("3. This makes sense because if you call a method and do not assign its return value, you also would not be able to tell which method should be called would you?");
        printGreenGenericLn("4. By the previous point we can also infer that parameter naming will not play a role in overloading since we don't call methods via their parameters name in Java... Not yet at least 😊");
    }

    private static void exercise5() {
        printBrightCyanGenericLn("--- 5. Hiding and shadowing instance members");
        printRainbowLn("==");
        printGreenGenericLn("Case: \"Love of Lesbian\" was founded in 1997.");
        printGreenGenericLn("Alaska actually started in a band called \"Alaska y los Pegamoides\" in 1979.");
        printGreenGenericLn("\"Vetusta Morla\" is another band which started in 1998.");
        printGreenGenericLn("We are going to register them and understand the concept of shadouwing of instance members.");
        var band = new Band(List.of(
                "Santi Balmes",
                "Julián Saldarriaga",
                "Jordi Roig",
                "Joan Ramón Planell",
                "Oriol Bonet"), "Love of Lesbian");
        var quintetBand = new QuintetBand(
                List.of(
                        "Alaska",
                        "Nacho Canut",
                        "Ana Curra",
                        "Eduardo Benavente",
                        "Carlos Berlanga"
                ), "Alaska y los Pegamoides");
        var genericBand = new GenericBand(
                6, List.of(
                "Pucho",
                "David \"el Indio\"",
                "Álvaro B. Baglietto",
                "Jorge González",
                "Guillermo Galván",
                "Juanma Latorre"
        ), "Vetusta Morla");
        printMagentaGenericLn("This is band #1 -> %s", band);
        printMagentaGenericLn("This is band #2 -> %s", quintetBand);
        printMagentaGenericLn("This is band #3 -> %s", genericBand);
        printGreenGenericLn("We notice a few things that may sound odd.");
        printGreenGenericLn("1. Capacity is different for the subclasses of Band.");
        printGreenGenericLn("2. Capacity didn't limit the number of allowed members.");
        printMagentaGenericLn("Band #1 has %d members", band.capacity);
        printMagentaGenericLn("Band #2 has %d members", ((Band) quintetBand).capacity);
        printMagentaGenericLn("Band #3 has %d members", ((Band) genericBand).capacity);
        printGreenGenericLn("Well, we know that for the last two bands this is not true. This is why we have our common getters.");
        printMagentaGenericLn("Band #1 has %d members", band.getCapacity());
        printMagentaGenericLn("Band #2 has %d members", quintetBand.getCapacity());
        printMagentaGenericLn("Band #3 has %d members", genericBand.getCapacity());
        printGreenGenericLn("This is true, but do methods get overriden?");
        printMagentaGenericLn("Band #1 has %d members", band.getCapacity());
        printMagentaGenericLn("Band #2 has %d members", ((Band) quintetBand).getCapacity());
        printMagentaGenericLn("Band #3 has %d members", ((Band) genericBand).getCapacity());
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. Shadowing involves covering another variable. There is no limitation on how this can be done");
        printGreenGenericLn("2. The overshadowing member will also overshadow the scope");
        printGreenGenericLn("3. Methods do get overridden regardless of @Override");
        printGreenGenericLn("4. Capacity in an ArrayList only means that the initial capacity of the Array is fixed.");
        printGreenGenericLn("5. An ArrayList will change size automatically. Capacity is just used in performance and memory usage fine tuning.");
    }

    private static void exercise4() {
        printBrightCyanGenericLn("--- 4. The `java.desktop` module");
        printRainbowLn("==");
        printGreenGenericLn("Case: We want an app that lets us surf the web for short stories about Spanish music");
        printGreenGenericLn("We'll make our first prototype using the \"Bandido\". A famous spanish album from \"Miguel Bosé\" containing famous anthem \"Amante bandido\"");
        printGreenGenericLn("We'll use this as the name of our module: amante.bandido");
        printGreenGenericLn("Please find this module in the sources for mastery-4-3-swing and run it.");
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. Java SWING libraries, although part of the JDK, they are not part of the java.base module.");
        printGreenGenericLn("2. Because they are not part of the java.base module, they have to be required.");
        printGreenGenericLn("3. To require them, you need to require the java.desktop module. Example:");
        printGreenGenericLn("module amante.bandido {\n" +
                "    requires java.desktop;\n" +
                "    requires consolerizer;\n" +
                "}");
    }

    private static void exercise3() {
        printBrightCyanGenericLn("--- 3. The body of `switch`");
        printRainbowLn("==");
        printGreenGenericLn("Case: \"¿A quién le importa?\" is a single from 1984 sung by Alaska and Dinamara, and edited by Nacho Canut and Carlos Berlanga.");
        printGreenGenericLn("There have been a lot of switches in styles up until present for this song. Several covers.");
        printGreenGenericLn("The reason why this song is so popular is because later in the 80's, it found great recognition in marginalized groups.");
        printGreenGenericLn("Most importantly the LGBT community from spanish speaking countries.");
        printGreenGenericLn("The song gained such momentum in that community, that it is now celebrated in the same way as \"I will survive\" from Gloria Gaynor is.");
        printGreenGenericLn("It mainly has to do with the rebelious theme of the song in which it is said:");
        printGreenGenericLn("\"Who cares as to what to I do? Who cares as to what do I say? I am like this, I will always be like this and I will never change.\"");

        var i = 1984;
        printMagentaGenericLn("In year %d version %s was released.", i, getYearMusic(i));
        i = 2002;
        printMagentaGenericLn("In year %d version %s was released.", i, getYearMusic(i));
        i = 2011;
        printMagentaGenericLn("In year %d version %s was released.", i, getYearMusic(i));
        i = 2017;
        var m = 6;
        printMagentaGenericLn("In year %d and month %d version %s was released.", i, m, getYearMonthMusic(i, m));
        m = 12;
        printMagentaGenericLn("In year %d and month %d version %s was released.", i, m, getYearMonthMusic(i, m));
        i = 2020;
        m = 6;
        printMagentaGenericLn("In year %d and month %d version %s was released.", i, m, getYearMonthMusic(i, m));
        m = 7;
        printMagentaGenericLn("In year %d and month %d version %s was released.", i, m, getYearMonthMusic(i, m));

        printGreenGenericLn("Curiosities about switch and other accolades:");

        printBlueGenericLn("        int k =0;\n" +
                "        for (; k < 100; k++) ;\n" +
                "        while(k < 100);\n" +
                "        do {} while (k<100);\n" +
                "        // Do while without a body is illegal\n" +
                "        // do while (k<100);\n" +
                "        // Switches without a body are illegal\n" +
                "        // switch(i);");
        int k = 0;
        for (; k < 100; k++) ;
        while (k < 100) ;
        do {
        } while (k < 100);
        // Do while without a body is illegal
        // do while (k<100);
        // Switches without a body are illegal
        // switch(i);k
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. Switches must have a body!");
        printGreenGenericLn("2. Switches only accept int, short, long, byte, char, their boxed counterparts, Short, Long, Byte, Character, and String and enums as parameters.");
        printGreenGenericLn("3. do while is akin to a switch in the sense that it also cannot be done without a body.");
        printGreenGenericLn("4. for and while can be done without a body.");
    }

    /**
     * -   [RUBÍ 2020, entrada completa a quien le importa](https://www.youtube.com/watch?v=aNMdaRbX_-k)
     * -   [Rosa López · A quién le importa - 2020](https://www.youtube.com/watch?v=NxlfzjWX2Z4)
     * -   [A QUIÉN LE IMPORTA - Grupal | Gala 7 | OT 2017](https://www.youtube.com/watch?v=hoH6OXQpmQY)
     * -   [Himno World Pride Madrid 2017 - A quien le importa 2017](https://www.lasexta.com/especiales/world-pride-madrid/orgullo-lgtbi/a-quien-le-importa-asi-suena-el-himno-oficial-del-world-pride-madrid-2017_201706285953f2d20cf2a25c00ab7737.html)
     * -   [Fangoria - A quien le importa 2011](https://www.youtube.com/watch?v=XX_hWpPnd3I)
     * -   [Thalia - A Quien Le Importa - Video Oficial 2002](https://www.youtube.com/watch?v=s0MG5mdwweU)
     * -   [Alaska y Dinarama A Quién Le Importa (1984)](https://www.youtube.com/watch?v=N2L7cRsUA0E)
     *
     * @param y Year of the song inception
     * @param m Month of the song inception
     * @return
     */
    private static String getYearMonthMusic(int y, int m) {
        switch (y) {
            case 2002:
                return "Thalia - A Quien Le Importa - Video Oficial 2002 - https://www.youtube.com/watch?v=s0MG5mdwweU";
            // Unreachable statement
            // break;
            case 2011:
                return "Fangoria - A quien le importa 2011 - https://www.youtube.com/watch?v=XX_hWpPnd3I";
            case 2017:
                switch (m) {
                    case 12:
                        return "A QUIÉN LE IMPORTA - Grupal | Gala 7 | OT 2017 - https://www.youtube.com/watch?v=hoH6OXQpmQY";
                    case 6:
                    default:
                        return "Himno World Pride Madrid 2017 - A quien le importa 2017\nhttps://www.lasexta.com/especiales/world-pride-madrid/orgullo-lgtbi/a-quien-le-importa-asi-suena-el-himno-oficial-del-world-pride-madrid-2017_201706285953f2d20cf2a25c00ab7737.html";
                }
            case 2020:
                switch (m) {
                    case 6:
                        return "Rosa López · A quién le importa - 2020 - https://www.youtube.com/watch?v=NxlfzjWX2Z4";
                    case 7:
                    default:
                        return "Camila Sodi - RUBÍ 2020, entrada completa a quien le importa - https://www.youtube.com/watch?v=aNMdaRbX_-k";


                }
            case 1984:
                // Unreachable statement
                // break;
            default:
                return "Alaska y Dinarama A Quién Le Importa (1984) - https://www.youtube.com/watch?v=N2L7cRsUA0E";
        }
    }

    private static String getYearMusic(int y) {
        return getYearMonthMusic(y, 0);
    }


    private static void exercise2() {
        printBrightCyanGenericLn("--- 2. Different ways to use `this`");
        printRainbowLn("==");
        printGreenGenericLn("Case: In 1981, Hispavox edited and published single \"Juntos\" by Paloma San Basilio");
        printGreenGenericLn("Since then, this song has been sung and remixed by different artists.");
        printGreenGenericLn("We will register this event and see how can we use `this`.");

        var company = new Company("Hispavox");
        var music = company.new Music("Juntos", "Paloma San Basilio",
                LocalDateTime.of(1981, 1, 1, 0, 0, 0));
        // 'org.jesperancinha.ocp11.mastery4dot2.record.Company' is not an enclosing class
        // Company.this
        printBlueGenericLn("The only reason why %s works is because %s is an enclosing class of %s.",
                "Company.this.company", "Company", "Music");
        printMagentaGenericLn(music.getTheMusic());
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. `this` is more commonly used within a class to refer to the instance members");
        printGreenGenericLn("2. It cannot be used for static members");
        printGreenGenericLn("3. Although less common, we can use this to refer to the instance members of an enclosing class");
        printGreenGenericLn("4. Even though it looks like a static accessor, it is an instance member accessor");
    }

    private static void exercise1() {
        printBrightCyanGenericLn("--- 1. Primitives Revised");
        printRainbowLn("==");
        printGreenGenericLn("Case: Music group Fangoria was created in 1989.");
        printGreenGenericLn("The name of the group was inspired by the love the group members, Alaska and Nacho Canut have for the magazine of the same name");
        printGreenGenericLn("We'll have a look at numbers related to that magazine and explore java primitive types with it");
        printRainbowLn("###");
        final byte issnLeft = 0164;
        printBrightCyanGenericLn("Byte - one byte - 2^8");
        printBrightCyanGenericLn("Range from %s to %s", Byte.MIN_VALUE, Byte.MAX_VALUE);
        printMagentaGenericLn("If we look at the left side of the issn, we a small number.");
        printMagentaGenericLn("164, is however, too big for the maximum allowed value for a byte.");
        printMagentaGenericLn("In this case, we can use its octed representation, which in turn is a smaller number than a 164.");
        printMagentaGenericLn("Octet radix numbers are represented with a 0 as a prefix.");
        printMagentaGenericLn("This is our number as we would read it in decimal: %s", Integer.toString(issnLeft, 10));
        printMagentaGenericLn("And this is what we want: %s", Integer.toString(issnLeft, 8));
        printBrightMagentaGenericLn("Note that we are able to pass a byte in the toString of Integer, just because the range of Integer covers the byte range");
        printBrightMagentaGenericLn("Also, bear in mind that primitive numbers without decimals are interpreted as integers. except for byte and short");
        printRainbowLn("###");
        short lossesPerIssue = 20000;
        printBrightCyanGenericLn("Short two bytes - 2^16");
        printBrightCyanGenericLn("Range from %s to %s", Short.MIN_VALUE, Short.MAX_VALUE);
        printMagentaGenericLn("In early beginnings, Fangoria magazine wasn't selling that much.");
        printMagentaGenericLn("The losses amounted to USD$20000 per issue");
        printMagentaGenericLn("We cannot put this number in a byte. It just falls out of range");
        printMagentaGenericLn("If we use a short though, we can safely accomodate it");
        printMagentaGenericLn("This is our number as we would read it in decimal: %s", Integer.toString(lossesPerIssue, 10));
        printMagentaGenericLn("Just for fun, we can look at its octal representation: %s", Integer.toString(lossesPerIssue, 8));
        printMagentaGenericLn("Which if we use that in the code we get: %s", 047040);
        printBrightMagentaGenericLn("Note that shor, just as byte, is often overlooked because it's just not common enough");
        printBrightMagentaGenericLn("However, the benefits of using primitives like these two for small numbers can represent an advantage");
        printRainbowLn("###");
        int oclc = 4618144;
        printBrightCyanGenericLn("Integer four bytes - 2^32");
        printBrightCyanGenericLn("Range from %s to %s", Integer.MIN_VALUE, Integer.MAX_VALUE);
        printMagentaGenericLn("As reported by wikipedia, the OCLC is the Ohio College Library Center number.");
        printMagentaGenericLn("We want to register this reference number for the publishing of issue 7 of Fangoria Magazine.");
        printMagentaGenericLn("For this, we cannot use Short anymore. It falls out of the range needed.");
        printMagentaGenericLn("We'll try with Integer.");
        printMagentaGenericLn("This is our number as we would read it in decimal: %s", Integer.toString(oclc, 10));
        printMagentaGenericLn("Just for fun, we can look at its octal representation: %s", Integer.toString(oclc, 8));
        printMagentaGenericLn("Which if we use that in the code we get: %s", 021473640);
        printBrightMagentaGenericLn("Important to note is again, how integer is always the type pointed out by the compiler");
        printBrightMagentaGenericLn("Especially if you look the octals, they are interpreted as int.");
        printBrightMagentaGenericLn("They only get converted when they match the range.");
        printRainbowLn("###");
        long firstPublicationMs = 283_996_800_000L;
        printBrightCyanGenericLn("Long eight bytes - 2^64");
        printBrightCyanGenericLn("Range from %s to %s", Long.MIN_VALUE, Long.MAX_VALUE);
        printMagentaGenericLn("The first publication of Fangoria happened on a specific date.");
        printMagentaGenericLn("We found the number in milliseconds.");
        printMagentaGenericLn("If we convert that to some epoch representation, we then convert from %d to %s", firstPublicationMs,
                LocalDateTime.ofInstant(Instant.ofEpochMilli(firstPublicationMs), ZoneId.systemDefault()));
        printMagentaGenericLn("This is our number as we would read it in decimal: %s", Long.toString(firstPublicationMs, 10));
        printMagentaGenericLn("Just for fun, we can look at its octal representation: %s", Long.toString(firstPublicationMs, 8));
        printMagentaGenericLn("Which if we use that in the code we get: %s", 04103741642000L);
        printBrightMagentaGenericLn("You probably noticed that we are using L to specify that it is a long.");
        printBrightMagentaGenericLn("The compiler needs to know what do we actually mean if the number falls out of the integer range.");
        printBrightMagentaGenericLn("If it falls out of the range of Integer and we want it to be long, we specify that with an appended L or l.");
        printRainbowLn("###");
        float firstPublicationMs2 = 283_996_800_000L;
        printBrightCyanGenericLn("Float 4 bytes - 2^32");
        printBrightCyanGenericLn("Range from %s to %s with a min normal %s", Float.MIN_VALUE, Float.MAX_VALUE, Float.MIN_NORMAL);
        printBrightCyanGenericLn("It stores up 6 to 7 significant numbers");
        printMagentaGenericLn("Before continuing in this section you probably noticed a strange conversion.");
        printMagentaGenericLn("A long to a float? Well that can happen simply because a long fits in a float range.");
        printMagentaGenericLn("And although float occupies less amount of bytes (4) than long (8), its implementation allows this to happen.");
        printMagentaGenericLn("This means that even with a float, the rule that it fits, is accepted is still valid.");
        printMagentaGenericLn("The only difference is that we need to specify L if its bigger than an int.");
        printMagentaGenericLn("If we convert that to some epoch representation from a float, we then convert from %f to %s", firstPublicationMs2,
                LocalDateTime.ofInstant(Instant.ofEpochMilli((long) firstPublicationMs2), ZoneId.systemDefault()));
        printBrightMagentaGenericLn("Notice that we had to upcast it to long. This is because the compiler does not understand that we are converting to a type with a lower range. Although the number fits, type float does not fit in the long range.");
        float parallelUniversePublications1 = (3_000_000f * 12 * 30 * 10);
        printMagentaGenericLn("Let's imagine that 10 universes are working together.");
        printMagentaGenericLn("The same thing happens in all of those 10 universes to our magazine.");
        printMagentaGenericLn("The website gets 3 million visits per month");
        printMagentaGenericLn("And we are calculating what would have happened if during the course of 30 years of existence, the numbers would have kept stable");
        printMagentaGenericLn("In the end we get all of these hits: %s", parallelUniversePublications1);
        printBrightMagentaGenericLn("Did you notice the f? f, means float. Without the f, the calculation would result in a numeric overflow warning from the compiler");
        printBrightMagentaGenericLn("Since one of the elements is now a float, the compiler will check if the result fits within the float range.");
        printBrightMagentaGenericLn("During runtime, well get a float as a result.");
        printRainbowLn("###");
        double parallelUniversePublications2 = (3_000_000d * 12 * 30 * 1e+200);
        double parallelUniversePublications3 = (3_000_000d * 12 * 30 * 1e+300);
        printBrightCyanGenericLn("Float 4 bytes - 2^32");
        printBrightCyanGenericLn("Range from %s to %s with a min normal %s", Double.MIN_VALUE, Double.MAX_VALUE, Double.MIN_NORMAL);
        printMagentaGenericLn("In the same way with Float, we can make a calculation if we have %s universes", 1e+200);
        printBrightMagentaGenericLn("Notice the d. Now we specify that the number is a double.");
        printMagentaGenericLn("If the number is too big, we'll get a different lind of mathematical notation.");
        printMagentaGenericLn("If we try with %s universes", parallelUniversePublications3);
        printMagentaGenericLn("A very high number is also considered a number, but Double specifies it as %s", parallelUniversePublications3);
        printBrightCyanGenericLn("Reminder: double values are 64 bit floating point numbers with a precision of 15 to 16 significant number digits.");
        printBrightCyanGenericLn("Doubles range from\n%s to %s in normal values", Double.MIN_NORMAL, Double.MAX_VALUE);
        printBrightCyanGenericLn("Doubles can also be: %s and be %f or %f", Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY);
        printBrightCyanGenericLn(parallelUniversePublications1);
        printBrightCyanGenericLn(parallelUniversePublications2);
        printBrightCyanGenericLn(parallelUniversePublications3);
        printRainbowLn("###");
        printGreenGenericLn("Curiosities about primitive types:");
        double maxTest = 3.40282353482789473289473289477899659000892042934820984928423804e+38;
        float maxTest2 = 3.40282353482789473289473289477899659000892042934820984928423804e+38f;
        float maxTest3 = 3.4028235e+38f;
        double maxTest4 = 3.4028235e+38;
        double maxTest5 = 3.4028235111112222233333444444555555666666777788889999111122222e+38;
        double maxTest6 = 1.79769313486231572234324324324e+308;
        printMagentaGenericLn("double maxTest = 3.40282353482789473289473289477899659000892042934820984928423804e+38:");
        printBrightMagentaGenericLn("%f", maxTest);
        printMagentaGenericLn("float maxTest2 = 3.40282353482789473289473289477899659000892042934820984928423804e+38f:");
        printBrightMagentaGenericLn("%f", maxTest2);
        printMagentaGenericLn("float maxTest3 = 3.40282353482789473289473289477899659000892042934820984928423804e+38f:");
        printBrightMagentaGenericLn("%f", maxTest3);
        printMagentaGenericLn("double maxTest4 = 3.4028235e+38:");
        printBrightMagentaGenericLn("%f", maxTest4);
        printMagentaGenericLn("double maxTest5 = 3.4028235111112222233333444444555555666666777788889999111122222e+38:");
        printBrightMagentaGenericLn("%f", maxTest5);
        printMagentaGenericLn("double maxTest5 = 3.4028235111112222233333444444555555666666777788889999111122222e+38");
        printBrightMagentaGenericLn("%s", Double.toString(maxTest5));
        printMagentaGenericLn("Float.MAX_VALUE:");
        printBrightMagentaGenericLn("%f", Float.MAX_VALUE);
        printMagentaGenericLn("Double.MAX_VALUE:");
        printBrightMagentaGenericLn("%f", Double.MAX_VALUE);
        printMagentaGenericLn("double maxTest6 = 1.79769313486231572234324324324e+308;");
        printBrightMagentaGenericLn("%f", maxTest6);
        printMagentaGenericLn("Double.toString(Double.MAX_VALUE):");
        printBrightMagentaGenericLn("%s", Double.toString(Double.MAX_VALUE));
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. Primitive type conversion rules and ranges are not simple");
        printGreenGenericLn("2. A number without decimal is considered an integer and automatically converted to a lower range if it fits it, but only on instantiation assignment.");
        printGreenGenericLn("3. A value with a coma is considered a double. An f will specify that it is a float");
        printGreenGenericLn("4. d is needed when making calculations that result in very large numbers");
        printGreenGenericLn("5. d is also needed if our number without decimals results to be higher than long");
        printGreenGenericLn("6. f is also needed if our number without decimals results to be higher than long");
        printGreenGenericLn("7. f can take in any integer or long");
        printGreenGenericLn("8. d can take in any integer or long or float");
        printGreenGenericLn("9. Octals have to be multiple of 8 otherwise the 0 before the number rule won't work!");
        double a;
        long b = 123;
        a = b;
        float c;
        c = b;
        long d = 123412341234L;
        c = 1.2f;
        a = c;
        a = 4.5;
        // Overflows
        a = 1233112213L * 12312232223L * 2;
        // Correct
        a = 1233112213d * 12312232223L * 2;
    }

}
