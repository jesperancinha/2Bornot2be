package org.jesperancinha.ocp11.mastery4dot2;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.ocp11.mastery4dot2.band.EffectiveBandManager;
import org.jesperancinha.ocp11.mastery4dot2.band.GeneralBandManager;
import org.jesperancinha.ocp11.mastery4dot2.band.QuintetBandManager;
import org.jesperancinha.ocp11.mastery4dot2.concert.Band;
import org.jesperancinha.ocp11.mastery4dot2.concert.GenericBand;
import org.jesperancinha.ocp11.mastery4dot2.concert.QuintetBand;
import org.jesperancinha.ocp11.mastery4dot2.concert.Ticket;
import org.jesperancinha.ocp11.mastery4dot2.record.Company;
import org.jesperancinha.ocp11.mastery4dot2.show.CristalBall;
import org.jesperancinha.ocp11.mastery4dot2.show.SuperCristalBall;
import org.jesperancinha.ocp11.mastery4dot2.songs.Compilation;
import org.jesperancinha.ocp11.mastery4dot2.styles.Indie;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Permission;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.Temporal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightCyanGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedThrowableAndExit;
import static org.jesperancinha.console.consolerizer.Consolerizer.printUnicornsLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;
import static org.jesperancinha.ocp11.mastery4dot2.concert.Ticket.getTicketsLongNumbers;
import static org.jesperancinha.ocp11.mastery4dot2.concert.Ticket.getTicketsStringNumbers;

public class Mastery4Dot2Runner {
    private static boolean skipQuestions;

    public static void main(String[] args) {
        if (args.length > 0) {
            skipQuestions = "-skip".equals(args[0]);
        }
        Consolerizer.typingWaitGlobal = 0;
        Consolerizer.maxLineCharsGlobal = 200;
        printBlueGenericLn("==================== Master Module mastery-4-2 ====================");
        printBlueGenericLn("----> Run with VM command -ea or -enableassertions for a more accurate run");
        printBlueGenericLn("----> Run with -skip to skip questions");
        printBlueGenericLn("----> Note that this mastery need the prepare.sh script to be run first.");

//        exercise1();
//        exercise2();
//        exercise3();
//        exercise4();
//        exercise5();
//        exercise6();
//        exercise7();
//        exercise8();
//        exercise9();
//        exercise10();
//        exercise11();
//        exercise12();
//        exercise13();
//        exercise14();
//        exercise15();
//        exercise16();

        printBrightCyanGenericLn("--- 17. `writeUTF` and where it is possible with `BufferedWriter` and `FileOutputWriter`");
        printRainbowLn("==");
        printGreenGenericLn("Case: In the year 2000, spanish singer, Monica Naranjo, came into the music scene with her hit \"Sobreviviré\"");
        printGreenGenericLn("Given the raw energy of the lyrics of the songs and its meaning, \"Sobreviviré\" became an anthem of those who fight to be understood and accepted");
        printGreenGenericLn("In the video, Monica Naranjo depics just that.");
        printGreenGenericLn("We want to copy these lyrics from the source to new files.");
        printGreenGenericLn("We will do this in two ways. One with a BufferedWriter and the other with a FileOutputStream.");
        String source = null;
        try(var fis = new FileInputStream("/tmp/monica_naranjo_lyrics.txt")){
            source = new String(fis.readAllBytes(), Charset.defaultCharset());
        } catch (FileNotFoundException e) {
           printRedThrowableAndExit(e);
        } catch (IOException e) {
            printRedThrowableAndExit(e);
        }
        printMagentaGenericLn("We just read the lyrics");
        printBrightMagentaGenericLn(source);
        printMagentaGenericLn("We will now write this to file in UTF(Unicode Transformation Format) %s","/tmp/mn1.txt");
        try(var fos = new FileOutputStream("/tmp/mn1.txt")){
           final ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeUTF(source);
            oos.flush();
        } catch (FileNotFoundException e) {
            printRedThrowableAndExit(e);
        } catch (IOException e) {
            printRedThrowableAndExit(e);
        }
        readFile("/tmp/mn1.txt");
        try(var bw = new BufferedWriter(new FileWriter("/tmp/mn2.txt", Charset.defaultCharset()))){
            bw.write('U');
            bw.write('T');
            bw.write('F');
            bw.write('-');
            bw.write(source);
        } catch (IOException e) {
            printRedThrowableAndExit(e);
        }
        readFile("/tmp/mn2.txt");
        try(var fos = new FileOutputStream("/tmp/mn3.txt")){
            final OutputStreamWriter osw = new OutputStreamWriter(fos, Charset.defaultCharset().name());
            osw.write(source);
            osw.flush();
        } catch (FileNotFoundException e) {
            printRedThrowableAndExit(e);
        } catch (IOException e) {
            printRedThrowableAndExit(e);
        }        printGreenGenericLn("Take-away");
        readFile("/tmp/mn3.txt");
        printGreenGenericLn("1. We can specify UTF with FileWriter, OutputStreamWriter and with ObjectOutputStream");
        printGreenGenericLn("2. It is not mandatory to specify UTF with Writers. CharSet is optional");
        printGreenGenericLn("3. In the OutputStream we have methods that can write in UTF directly (writeUTF)");

        moduleEnd();
    }

    private static void readFile(String resultFilename) {
        try(var fis = new FileInputStream(resultFilename)){
            printMagentaGenericLn("We just read this from file %s", resultFilename);
            final String s = new String(fis.readAllBytes(), Charset.defaultCharset());
            printBrightMagentaGenericLn(s);
        } catch (FileNotFoundException e) {
            printRedThrowableAndExit(e);
        } catch (IOException e) {
            printRedThrowableAndExit(e);
        }
    }

    private static void exercise16() {
        printBrightCyanGenericLn("--- 16. NavigableMap and `pollLastEntry` and `pollFirstEntry`");
        printRainbowLn("==");
        printGreenGenericLn("Case: \"Supersubmarina\" is a band from Spain.");
        printGreenGenericLn("In 2008 and 2009, they've edited their first two EP(Extended Play)s");
        printGreenGenericLn("You'll show these vinyls to your friends");
        printGreenGenericLn("And then you will lend them");
        final String[] cientoCero = {"Cientocero","Elástica galáctica","No es así","Cientocero (english)","Cientocero (maqueta)"};
        final String[] supersubmarina = {"Supersubmarina","Ana","Supersubmarina","OCB"};
        final NavigableMap<String, List<String>> albums = new TreeMap<>(){{
            put("Cientocero", Arrays.stream(cientoCero).collect(Collectors.toList()));
            put("Supersubmarina", Arrays.stream(supersubmarina).collect(Collectors.toList()));
        }};
        printMagentaGenericLn("Ciento cero is %s", String.join(",",cientoCero));
        printMagentaGenericLn("Supersubmarina is %s", String.join(",",supersubmarina));
        printBlueGenericLn("Let's tail this from %s:", "Cientocero");
        printMagentaGenericLn("%s", albums.tailMap("Cientocero"));
        printBlueGenericLn("And now from %s:", "Supersubmarina");
        printMagentaGenericLn("%s", albums.tailMap("Supersubmarina"));
        printBlueGenericLn("Let's head this from %s:", "Cientocero");
        printMagentaGenericLn("%s", albums.headMap("Cientocero"));
        printBlueGenericLn("And now from %s:", "Supersubmarina");
        printMagentaGenericLn("%s", albums.headMap("Supersubmarina"));
        final Map.Entry<String, List<String>> firstLending = albums.pollFirstEntry();
        printMagentaGenericLn("We just took out the first album: %s", firstLending);
        printMagentaGenericLn("So the our album collection looks like this: %s", albums);
        final Map.Entry<String, List<String>> lastLending = albums.pollLastEntry();
        printMagentaGenericLn("We just took out the last album: %s", lastLending);
        printMagentaGenericLn("So the our album collection should be empty now: %s", albums);
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. Navigable maps are very simple");
        printGreenGenericLn("2. Important methods are pollFirstEntry, pollLastEntry, tailMap and headMaps");
        printGreenGenericLn("3. Head is exclusive, whiile tail is inclusive");
    }

    private static void exercise15() {
        printBrightCyanGenericLn("--- 15. Iterating through a `CopyOnWriteArrayList` and the `UnsupportedOperationException`");
        printRainbowLn("==");
        printGreenGenericLn("Case: Someone is compiling songs of the band Dorian for you.");
        printGreenGenericLn("Your other half is waiting impatiently for the mix result.");
        printGreenGenericLn("You keep getting a list, always updated, but you have to read it at the same time its being filled.");
        printGreenGenericLn("It's hard to keep up, and so you decide to make multiple reads.");
        final String[] songs = {
                "Buenas Intenciones",
                "Duele",
                "La Tormenta de Arena",
                "Los Amigos que Perdí",
                "El Futuro no es de Nadie",
                "Vicios y Defectos",
                "Tristeza",
                "A Cualquier Otra parte",
                "Te Echamos de Menos (Undo Remix)",
                "Horas Bajas (Undo Remix)", "El Temblor (Lovo Remix)", "Verte Amanecer"};
        printMagentaGenericLn("This is our possible list:");
        printOrangeGenericLn("%s", String.join(",", songs));
        final Compilation compilation = new Compilation();

        final var songSet = Arrays.stream(songs).collect(Collectors.toCollection(ConcurrentSkipListSet::new));
        final ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            try {
                while (songSet.size() > 0) {
                    final String s = songSet.pollFirst();
                    compilation.addSong(s);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                printRedThrowableAndExit(e);
            }


        });
        executorService.submit(() -> {
            try {
                while (songSet.size() > 0) {
                    final Iterator<String> iterator = compilation.iterator();
                    while (iterator.hasNext()) {
                        printMagentaGenericLn("Got song %s", iterator.next());
                        Thread.sleep(500);
                    }
                    printBrightMagentaGenericLn("One Iteration done!");
                }
                final Iterator<String> iterator = compilation.iterator();
                while (iterator.hasNext()) {
                    printMagentaGenericLn("Got song %s", iterator.next());
                    Thread.sleep(500);
                }
                printBrightMagentaGenericLn("Last iteration done!");
            } catch (InterruptedException e) {
                printRedThrowableAndExit(e);
            }
        });
        executorService.shutdown();
        try {
            executorService.awaitTermination(15, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            printRedThrowableAndExit(e);
        }
        final Iterator<String> iterator = compilation.iterator();
        printMagentaGenericLn("No exception has occurred and everything went well.");
        printBlueGenericLn("Can we change the list with this iterator though?");
        try {
            iterator.remove();
        } catch (UnsupportedOperationException e) {
            printRedGenericLn("We cannot! And this is because this iterator is working with an array that is allowed to be copied and discarded -> %s", e);
        }
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. CopyOnWriteArrayList make a copy on every write operation");
        printGreenGenericLn("2. This way, there will be no concurrent type of exception thrown");
        printGreenGenericLn("3. The iterator of this type of List's does not support modifications");
    }

    private static void exercise14() {
        printBrightCyanGenericLn("--- 14. Static and instance initialization of final `members`");
        printRainbowLn("==");
        printGreenGenericLn("Case: We know that the band Dorian is mostly classified as being an Indie pop group.");
        printGreenGenericLn("We'll create its registry and see the many different ways we can initialize final values.");
        printGreenGenericLn("Have a look in the code. All these fields are mandatory and cannot change because they are final");
        var dorian = new Indie("Dorian");
        printMagentaGenericLn("This is our band %s", dorian);
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. All final fields have to be initialized");
        printGreenGenericLn("2. There is no difference in this mandatory action between static and instance members");
        printGreenGenericLn("3. Members can be initialized using accolades");
        printGreenGenericLn("4. There isn't a lot of reasons to use accolades this way. Just know that they work");
    }

    private static void exercise13() {
        printBrightCyanGenericLn("--- 13. `Float.POSITIVE_INFINITY` vs `Float.NEGATIVE_INFINITY`");
        printRainbowLn("==");
        printGreenGenericLn("Case: Vetusta Morla publish in 2020 its fith studio album entitled \"Mismo Sitio Distinto Lugar - Canciones dentro de canciones\".");
        printGreenGenericLn("They came up with this original concept of songs within songs.");
        printGreenGenericLn("When you find a song within a song you are really up to infinity.");
        printGreenGenericLn("We can represent the infinity of songs Vetusta Morla can make by using Float and Double.");
        var songs = Float.POSITIVE_INFINITY;
        var nosongs = Float.NEGATIVE_INFINITY;
        printOrangeGenericLn(songs);
        printOrangeGenericLn(nosongs);
        printBlueGenericLn("But how can we generate infinite songs?");
        var infiniteSongs = 1 / 0.0f;
        var noSongsToInfinity = -1 / 0.0f;
        printOrangeGenericLn(infiniteSongs);
        printOrangeGenericLn(noSongsToInfinity);
        printBlueGenericLn("Can we use double for this?");
        var songsDouble = Double.POSITIVE_INFINITY;
        var nosongsDouble = Double.NEGATIVE_INFINITY;
        printOrangeGenericLn(songsDouble);
        printOrangeGenericLn(nosongsDouble);
        printBlueGenericLn("But how can we generate double infinite songs?");
        var infiniteSongsDouble = 1 / 0.0;
        var noSongsToInfinityDouble = -1 / 0.0;
        printOrangeGenericLn(infiniteSongsDouble);
        printOrangeGenericLn(noSongsToInfinityDouble);
        printBlueGenericLn("Sounds good, but how about that overflow Exception?");
        try {
            var notWithLongs = 1 / 0L;
        } catch (ArithmeticException e) {
            printRedGenericLn("Nope, no Longs allowed! -> %s", e);
        }
        printBlueGenericLn("Ok... and ints?");
        try {
            var notWithIntegers = 1 / 0;
        } catch (ArithmeticException e) {
            printRedGenericLn("Nope, no ints either! -> %s", e);
        }
        printBlueGenericLn("Shorts?");
        try {
            var notWithShorts = 1 / (short) 0;
        } catch (ArithmeticException e) {
            printRedGenericLn("Shorts also won't do! -> %s", e);
        }
        printBlueGenericLn("Then I guess Byte won't also work?");
        try {
            var notWithBytes = 1 / (byte) 0;
        } catch (ArithmeticException e) {
            printRedGenericLn("Bingo! -> %s", e);
        }
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. There infinity representations for Float and Double calculations");
        printGreenGenericLn("2. Numbers without decimals cannot make a division by zero");
        printGreenGenericLn("3. Division by zero with Float and Double are akin to ∞ (infinity) in math.");
    }

    private static void exercise12() {
        printBrightCyanGenericLn("--- 12. Immutability with Guidelines 7 and 6");
        printRainbowLn("==");
        printGreenGenericLn("Case: We just made a much safer Cristal Ball for Alaska to use.");
        printGreenGenericLn("Let's give it a try!.");
        SuperCristalBall superBolaDeCristal = null;
        try {
            superBolaDeCristal = SuperCristalBall.createCristalBall(
                    "Alaska",
                    new Date(86, Calendar.OCTOBER, 6),
                    new Band(
                            List.of(
                                    "Alaska",
                                    "Nacho Canut",
                                    "Ana Curra",
                                    "Eduardo Benavente",
                                    "Carlos Berlanga"
                            ), "Alaska y los Pegamoides"));
        } catch (NoSuchProviderException e) {
            printRedThrowableAndExit(e);
        } catch (NoSuchAlgorithmException e) {
            printRedThrowableAndExit(e);
        }
        printMagentaGenericLn("This is our new and improved cristal ball:\n%s", superBolaDeCristal);
        printBlueGenericLn("Note that we've made this Cristal Ball so safe that it now obeys guidelines 6 and 7!");
        printBlueGenericLn("Therefore, for this module, there isn't much to test.");
        printBlueGenericLn("Please follow the code for a better understandinf of what's happening and namely have a look at the comments.");
        printBlueGenericLn("Of course read the guidelines here -> https://www.oracle.com/java/technologies/javase/seccodeguide.html");
        // Guideline 7-2 / OBJECT-2: Prevent the unauthorized construction of sensitive classes
        SecurityManager setSecurityManager = new SecurityManager() {
            @Override
            public void checkExit(int status) {
                throw new RuntimeException("Ahha! Not today you are not!");
            }

            @Override
            public void checkPermission(Permission perm) {
            }
        };
        System.setSecurityManager(setSecurityManager);

        try {
            assert superBolaDeCristal != null;
            // Guideline 7-2 / OBJECT-2: Prevent the unauthorized construction of sensitive classes
            superBolaDeCristal.leaveEarth();
        } catch (RuntimeException e) {
            printRedGenericLn("The reason why this exception is thrown is that our SecurityManager doesn't let us exit with an error:\n%s\nIt's magic!", e);
        }
        System.setSecurityManager(new SecurityManager());

        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. We've made a few tests here, but this module will not be able to cover all of guidelines 6 and 7");
        printGreenGenericLn("2. Guideline 6 is about protecting Mutability");
        printGreenGenericLn("3. Guideline 7 is about protecting Object construction");
        printGreenGenericLn("4. Some guidelines may fuse with each other");
        printGreenGenericLn("5. Some are much more important than others");
        printGreenGenericLn("6. Guideline 7-1 / OBJECT-1: Avoid exposing constructors of sensitive classes");
        printGreenGenericLn("7. Guideline 7-2 / OBJECT-2: Prevent the unauthorized construction of sensitive classes");
        printGreenGenericLn("8. Guideline 7-4 / OBJECT-4: Prevent constructors from calling methods that can be overridden");
        printGreenGenericLn("9. Guideline 7-5 / OBJECT-5: Defend against cloning of non-final classes");
    }

    private static void exercise11() {
        printBrightCyanGenericLn("--- 11. Method overloading and overriding with `extends`");
        printRainbowLn("==");
        printGreenGenericLn("Case: Some of us like music \"Rosario Flores\" style, others prefer something more edgy like \"Dorian\".");
        printGreenGenericLn("We now have to manage the upcoming dates and for that we have created just one BandManager abstraction");
        printGreenGenericLn("Further we have implemented 3 different ways to override and other two to overload the BandManager method.");
        printGreenGenericLn("We'll put these methods to the test for different times of music history.");
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
        var paulinaRubio = new GenericBand(1, List.of("Paulina Rubio"), "Paulina Rubio");
        var rosarioFlores = new GenericBand(1, List.of("Rosario Flores"), "Rosario Flores");
        printMagentaGenericLn("These are our bands:\n%s\n%s\n%s\n%s\n%s", band, quintetBand, genericBand, paulinaRubio, rosarioFlores);
        var effectiveBandManager = new EffectiveBandManager();
        var generalBandManager = new GeneralBandManager();
        var quintetBandManager = new QuintetBandManager();
        final Map<Band, Temporal> upcomingDates = effectiveBandManager.getUpcomingDates(band, LocalDateTime.now());
        final Map<GenericBand, LocalDateTime> upcomingDates1 = generalBandManager.getUpcomingDates(genericBand, LocalDateTime.now());
        final Map<QuintetBand, LocalDate> upcomingDates2 = quintetBandManager.getUpcomingDates(quintetBand, LocalDate.now());
        printMagentaGenericLn("The first maps are now ready:\n%s\n%s\n%s", upcomingDates, upcomingDates1, upcomingDates2);
        upcomingDates1.put(paulinaRubio, LocalDateTime.now());
        upcomingDates1.put(rosarioFlores, LocalDateTime.now());
        printMagentaGenericLn("Adding two more artists to this new concert we get:\n%s", upcomingDates1);
        final Map<GenericBand, LocalDateTime> upcomingDates3 = generalBandManager.getUpcomingDates((Band) genericBand, LocalDateTime.now());
        final Map<QuintetBand, LocalDate> upcomingDates4 = quintetBandManager.getUpcomingDates((Band) quintetBand, LocalDate.now());
        printBrightMagentaGenericLn("Had we used the overriden methods we would have gotten:\n%s\nand\n%s", upcomingDates3, upcomingDates4);
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. Overloading and overriding with extends obeys some specific rules");
        printGreenGenericLn("2. The base type is the parameter you have to use in order to override");
        printGreenGenericLn("3. Subclass types of the declared base parameter always results in overloading");
        printGreenGenericLn("4. The return parameters may be subclass types");
        printGreenGenericLn("5. Since they have to be subclasses or the same, the type cannot be erased when overriding");
    }

    private static void exercise10() {
        printBrightCyanGenericLn("--- 10. Evaluation order of conditional operators");
        printRainbowLn("==");
        printGreenGenericLn("Case: Pepe is a manager that loves going to concerts.");
        printGreenGenericLn("In your team, you know that he is crazy about \"Vetusta Morla\".");
        printGreenGenericLn("However, sometimes, Pepe forgets to say to the team that is off.");
        printGreenGenericLn("Not only that, but at the same time that \"Vetusta Morla\" is playing, \"Sidonie\" is also playing in the same week.");
        printGreenGenericLn("If any of this is true, then we know that Pepe will be off the whole November of 2011.");
        printGreenGenericLn("We'll check this:");
        var month = 11;
        var year = 2011;
        if (pepeIsOffOn(year, month, 24) || pepeIsOffOn(year, month, 25)) {
            printMagentaGenericLn("Pepe won't be coming to work this november!");
        }
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. Logic operators such as || and && can short circuit in Java");
        printGreenGenericLn("2. Short circuiting does not imply the evaluation of all operands");
        printGreenGenericLn("3. Since they are evaluated left to right and considering mathematical precedence, the runtime knows when further evaluation is not needed");
        printGreenGenericLn("4. When not all operands are evaluated, we call this  a short-circuit");
    }

    private static boolean pepeIsOffOn(int year, int month, int day) {
        var concertVetustaDate = LocalDateTime.of(2011, 11, 25, 0, 0);
        var concertSidonieDate = LocalDateTime.of(2011, 11, 24, 0, 0);
        if (concertVetustaDate.getYear() == year &&
                concertVetustaDate.getMonthValue() == month &&
                concertVetustaDate.getDayOfMonth() == day) {
            printMagentaGenericLn("Pepe is going to see Vetusta Morla on the %s", concertVetustaDate);
            return true;
        }
        if (concertVetustaDate.getYear() == year &&
                concertSidonieDate.getMonthValue() == month &&
                concertSidonieDate.getDayOfMonth() == day) {
            printMagentaGenericLn("Pepe is going to see Sidonie on the %s", concertSidonieDate);
            return true;
        }
        return false;
    }

    private static void exercise9() {
        printBrightCyanGenericLn("--- 9. Why use `putIfAbsent`?");
        printRainbowLn("==");
        printGreenGenericLn("Case: Someone in your group of friends suggested to go to the next concert of Paulina Rubio.");
        printGreenGenericLn("Unfortunatelly you cannot go.");
        printGreenGenericLn("However your friends, Paco, Lori, Nere, Cristina, Viktor, Carlos and Andrea, are really excited to go!");
        printGreenGenericLn("We need to distribute the tickets as fast as possible and store them in a map.");
        printGreenGenericLn("The best ticket is the front row one, so in spite of being best friends, they will struggle to get the best one first!");
        printOrangeGenericLn("Ticket office is open!");
        var ticketFrontRow = new Ticket("Paulina Rubio", "Valdemoro - Madrid - España", "ES1028562319",
                LocalDateTime.of(2010, 5, 8, 0, 0));
        var ticketRowTwo = new Ticket("Paulina Rubio", "Valdemoro - Madrid - España", "ES0384518495",
                LocalDateTime.of(2010, 5, 8, 0, 0));
        var ticketRowThree = new Ticket("Paulina Rubio", "Valdemoro - Madrid - España", "ES0174538594",
                LocalDateTime.of(2010, 5, 8, 0, 0));
        var ticketRowFour = new Ticket("Paulina Rubio", "Valdemoro - Madrid - España", "ES3287451065",
                LocalDateTime.of(2010, 5, 8, 0, 0));
        var ticketRowFive = new Ticket("Paulina Rubio", "Valdemoro - Madrid - España", "ES0102956473",
                LocalDateTime.of(2010, 5, 8, 0, 0));
        var ticketRowSix = new Ticket("Paulina Rubio", "Valdemoro - Madrid - España", "ES6674993217",
                LocalDateTime.of(2010, 5, 8, 0, 0));
        var ticketRowSeven = new Ticket("Paulina Rubio", "Valdemoro - Madrid - España", "ES9928465748",
                LocalDateTime.of(2010, 5, 8, 0, 0));
        var precedenceTickets = List.of(ticketFrontRow,
                ticketRowTwo, ticketRowThree, ticketRowFour, ticketRowFive, ticketRowSix, ticketRowSeven);
        ExecutorService executorService = Executors.newFixedThreadPool(7);
        final var ticketMap = new ConcurrentHashMap<Ticket, String>();
        executorService.submit(tryAssignTo(precedenceTickets, ticketMap, "Paco"));
        executorService.submit(tryAssignTo(precedenceTickets, ticketMap, "Lori"));
        executorService.submit(tryAssignTo(precedenceTickets, ticketMap, "Nere"));
        executorService.submit(tryAssignTo(precedenceTickets, ticketMap, "Cristina"));
        executorService.submit(tryAssignTo(precedenceTickets, ticketMap, "Viktor"));
        executorService.submit(tryAssignTo(precedenceTickets, ticketMap, "Carlos"));
        executorService.submit(tryAssignTo(precedenceTickets, ticketMap, "Andrea"));
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            printRedThrowableAndExit(e);
        }
        printMagentaGenericLn("The result is \n%s", ticketMap.entrySet().stream().map(Object::toString).collect(Collectors.joining("\n")));
        printGreenGenericLn("We would get the same result if we had used putIfAbsent:");
        final var ticketMap2 = new ConcurrentHashMap<Ticket, String>();
        executorService = Executors.newFixedThreadPool(7);
        executorService.submit(tryAssignToNoLog(precedenceTickets, ticketMap2, "Paco"));
        executorService.submit(tryAssignToNoLog(precedenceTickets, ticketMap2, "Lori"));
        executorService.submit(tryAssignToNoLog(precedenceTickets, ticketMap2, "Nere"));
        executorService.submit(tryAssignToNoLog(precedenceTickets, ticketMap2, "Cristina"));
        executorService.submit(tryAssignToNoLog(precedenceTickets, ticketMap2, "Viktor"));
        executorService.submit(tryAssignToNoLog(precedenceTickets, ticketMap2, "Carlos"));
        executorService.submit(tryAssignToNoLog(precedenceTickets, ticketMap2, "Andrea"));
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            printRedThrowableAndExit(e);
        }
        printMagentaGenericLn("The new result is \n%s", ticketMap.entrySet().stream().map(Object::toString).collect(Collectors.joining("\n")));
        printGreenGenericLn("These operations will not fail for non-thread safe maps:");
        final var ticketMap3 = new HashMap<Ticket, String>();
        executorService = Executors.newFixedThreadPool(7);
        executorService.submit(tryAssignTo(precedenceTickets, ticketMap3, "Paco"));
        executorService.submit(tryAssignTo(precedenceTickets, ticketMap3, "Lori"));
        executorService.submit(tryAssignTo(precedenceTickets, ticketMap3, "Nere"));
        executorService.submit(tryAssignTo(precedenceTickets, ticketMap3, "Cristina"));
        executorService.submit(tryAssignTo(precedenceTickets, ticketMap3, "Viktor"));
        executorService.submit(tryAssignTo(precedenceTickets, ticketMap3, "Carlos"));
        executorService.submit(tryAssignTo(precedenceTickets, ticketMap3, "Andrea"));
        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            printRedThrowableAndExit(e);
        }
        printMagentaGenericLn("The new result is also what we are looking for:\n%s", ticketMap.entrySet().stream().map(Object::toString).collect(Collectors.joining("\n")));
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. In order to add to a hashmap in a concurrent way, we should use an atomic operation.");
        printGreenGenericLn("2. putIfAbsent performs a check if exists and add then if not, it puts an element into the map in an atomic way.");
        printGreenGenericLn("3. This, also works in a non-thread safe map.");
        printGreenGenericLn("4. For that we do not have to combine our operation with a ConcurrentHashMap which is thread safe.");
    }

    private static Runnable tryAssignToNoLog(List<Ticket> precedenceTickets, Map<Ticket, String> ticketMap, String winner) {
        return () -> {
            for (var nextTicket : precedenceTickets) {
                final String computeIfAbsent = ticketMap.putIfAbsent(nextTicket, winner);
                if (Objects.equals(computeIfAbsent, winner)) {
                    break;
                }
            }
        };
    }

    private static Runnable tryAssignTo(List<Ticket> precedenceTickets, Map<Ticket, String> ticketMap, String winner) {
        return () -> {
            for (var nextTicket : precedenceTickets) {
                final String computeIfAbsent = ticketMap.computeIfAbsent(nextTicket, ticket -> {
                    printOrangeGenericLn("Assigning ticket %s to %s", ticket, winner);
                    return winner;
                });
                if (Objects.equals(computeIfAbsent, winner)) {
                    break;
                }
            }
        };
    }

    private static void exercise8() {
        printBrightCyanGenericLn("--- 8. Overwriting with `FileOutputStream`");
        printRainbowLn("==");
        printGreenGenericLn("Case: \"Sueño su boca\" was the first big hit of Raúl Cuenca in Spain.");
        printGreenGenericLn("In the year 2000, this hit was being played all across spanish speaking countries and the rest of the latin world.");
        printGreenGenericLn("You want to save the lyrics and made it through to copying them to one friend");
        printGreenGenericLn("Now you you are making the second copy you make a mistake and only copy a bit of it to the same destination file.");
        printGreenGenericLn("Will there be a change?.");
        try (
                var fis = new FileInputStream("/tmp/raul_lyrics.txt");
                var fos = new FileOutputStream("/tmp/raul_lyrics2.txt");
        ) {
            byte[] buffer = new byte[2048];
            int bytes;
            while ((bytes = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytes);
                printYellowGenericLn(new String(buffer).trim());
            }
        } catch (FileNotFoundException e) {
            printRedThrowableAndExit(e);
        } catch (IOException e) {
            printRedThrowableAndExit(e);
        } catch (Exception e) {
            printRedThrowableAndExit(e);
        }
        printBlueGenericLn("Check your file contents in the file system: /tmp/raul_lyrics2.txt.");
        printBlueGenericLn("Press ENTER twice to continue...");
        if (!skipQuestions) {
            try {
                System.in.read();
            } catch (IOException e) {
                printRedThrowableAndExit(e);
            }
        }
        try (
                var fis = new FileInputStream("/tmp/raul_lyrics.txt");
                var fos = new FileOutputStream("/tmp/raul_lyrics2.txt");
        ) {
            byte[] buffer = new byte[100];
            int bytes;
            bytes = fis.read(buffer);
            fos.write(buffer, 0, bytes);
            printYellowGenericLn(new String(buffer).trim());
        } catch (FileNotFoundException e) {
            printRedThrowableAndExit(e);
        } catch (IOException e) {
            printRedThrowableAndExit(e);
        } catch (Exception e) {
            printRedThrowableAndExit(e);
        }
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. By default, FileOutputStream is configured to have the appendMode to false.");
        printGreenGenericLn("2. If appendMode is disable, the file gets overwritten.");
        printGreenGenericLn("3. Overwriting a file means that the file is written all over again.");
        printGreenGenericLn("4. When we start again, we remove all original data.");
    }

    private static void exercise7() {
        printBrightCyanGenericLn("--- 7. Immutability standards and using `LocalDate` and `LocalDateTime`");
        printRainbowLn("==");
        printGreenGenericLn("Case: Alaska started a show in 1984 based on the writings of Dolores Rico Oliver called \"La bola de cristal\".");
        printGreenGenericLn("\"La bola de cristal\", if yo haven't guessed already means \"The cristal ball\"");
        printGreenGenericLn("Cristal balls are always portrayed the same way");
        printGreenGenericLn("They are magic and they give information about the past, the present and the future.");
        printGreenGenericLn("Each cristal ball is also unique, but how do cristal balls make sure they are not tampered with?");
        printGreenGenericLn("In other words, what makes cristal balls immutable?");
        printGreenGenericLn("For our case we are just interested on the first 5 requirements for security guidelines 6 on Mutable classes: https://www.oracle.com/java/technologies/javase/seccodeguide.html");
        CristalBall bolaDeCristal = null;
        try {
            bolaDeCristal = CristalBall.createCristalBall(
                    "Alaska",
                    new Date(86, Calendar.OCTOBER, 6),
                    new Band(
                            List.of(
                                    "Alaska",
                                    "Nacho Canut",
                                    "Ana Curra",
                                    "Eduardo Benavente",
                                    "Carlos Berlanga"
                            ), "Alaska y los Pegamoides"));
        } catch (NoSuchProviderException e) {
            printRedThrowableAndExit(e);
        } catch (NoSuchAlgorithmException e) {
            printRedThrowableAndExit(e);
        }
        printMagentaGenericLn("This is the Cristal Ball of Episode I\n%s", bolaDeCristal);
        printMagentaGenericLn("We can get the from the available ones\n%s", CristalBall.getHost(bolaDeCristal));
        printMagentaGenericLn("We can get it from the available ones\n%s", CristalBall.getCristalBall(bolaDeCristal.getPriv()));
        printBrightCyanGenericLn("We can also comment it out:");
        bolaDeCristal.setComment("Me encanta este show! Super guay!!");
        printMagentaGenericLn("And then we get a comment on our Cristal Ball\n%s", bolaDeCristal);
        printBrightCyanGenericLn("And if we check if this is immutable:");
        Date date = bolaDeCristal.getDate();
        Date dateSafeCopy = bolaDeCristal.getDateSafeCopy();
        LocalDate localDate = bolaDeCristal.getLocalDate();
        LocalDateTime localDateTime = bolaDeCristal.getLocalDateTime();
        Band band = bolaDeCristal.getBand();
        String host = bolaDeCristal.getHost();
        printMagentaGenericLn("We get that\n%s had a band:\n%s\nand the pilot show aired on spanish television on the:%s\n%s\n%s\n%s ", host, band, date, dateSafeCopy, localDate, localDateTime);
        printBrightCyanGenericLn("Let's tamper that and see if we can change it!");
        date.setYear(200);
        dateSafeCopy.setTime(200);
        band.capacity = 1000;
        printBrightCyanGenericLn("Note that LocalDate and LocalDateTime are already immutable");
        printBrightCyanGenericLn("We did change the date objects and the capacity.");
        printBrightCyanGenericLn("From the outside we get the impression that we changed our original cristal ball:");
        printMagentaGenericLn("We get that\n%s had a band:\n%s\nand the pilot show aired on spanish television on the:%s\n%s\n%s\n%s ", host, band, date, dateSafeCopy, localDate, localDateTime);
        printBrightCyanGenericLn("But from the inside we see that nothing has changed:");
        date = bolaDeCristal.getDate();
        dateSafeCopy = bolaDeCristal.getDateSafeCopy();
        localDate = bolaDeCristal.getLocalDate();
        localDateTime = bolaDeCristal.getLocalDateTime();
        band = bolaDeCristal.getBand();
        host = bolaDeCristal.getHost();
        printMagentaGenericLn("We get that\n%s had a band:\n%s\nand the pilot show aired on spanish television on the:%s\n%s\n%s\n%s ", host, band, date, dateSafeCopy, localDate, localDateTime);
        printBrightCyanGenericLn("If we make a copy of it, we can use our method. Remember that we made a copy method to make a copy easy and follow the secuirty guidelines:");
        try {
            printMagentaGenericLn("This is our copy:\n%s", bolaDeCristal.copy());
        } catch (NoSuchProviderException e) {
            printRedThrowableAndExit(e);
        } catch (NoSuchAlgorithmException e) {
            printRedThrowableAndExit(e);
        }
        printGreenGenericLn("Take-away");
        printGreenGenericLn("1. We followed the Java Security Guidelines for Mutability from point 1 to 5, which are the most common");
        printGreenGenericLn("1.1 Guideline 6-1 / MUTABLE-1: Prefer immutability for value types");
        printGreenGenericLn("1.2 Guideline 6-2 / MUTABLE-2: Create copies of mutable output values");
        printGreenGenericLn("1.3 Guideline 6-3 / MUTABLE-3: Create safe copies of mutable and subclassable input values");
        printGreenGenericLn("1.4 Guideline 6-4 / MUTABLE-4: Support copy functionality for a mutable class");
        printGreenGenericLn("1.5 Guideline 6-5 / MUTABLE-5: Do not trust identity equality when overridable on input reference objects");
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
        printGreenGenericLn("9. Octals may not have digits higher than 8 otherwise the 0 before the number rule won't work!");
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

    private static void moduleEnd() {
        printUnicornsLn(100);
        printGreenGenericLn("Hope you enjoyed this mastery into Java 11 with some Spanish Indie/Pop flavor flavour to it.");
        printGreenGenericLn("Please keep coming back as I'll be creating more mastery modules.");
        printGreenGenericLn("Thank you!");
        printUnicornsLn(100);
    }
}
