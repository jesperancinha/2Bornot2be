package org.jesperancinha.ocp11.mastery3dot1;

import org.jesperancinha.console.consolerizer.Consolerizer;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Spliterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightCyanGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Mastery3Dot1Runner {
    public static void main(String[] args) {
        Consolerizer.typingWaitGlobal = 0;

        printBlueGenericLn("================== Master Module mastery-3-1 ==================");

        exercise1();
        exercise2();
        exercise3();
        exercise4();

        printBrightCyanGenericLn("--- 5. How `null` is interpreted in overloading");
        printRainbowLn("==");
        printGreenGenericLn("Case: We receive different shop items.");
        printGreenGenericLn("Now we want to check their state.");
        printGreenGenericLn("In our shop there are many automated ways of checking the state of items, but we generally just call the `checkItem` procedure.");
        printGreenGenericLn("We receive a copy of the album \"De stilte voorbij\" by pop-band \"Abel\", but the store manager has found different ways to check it's authenticity.");
        printGreenGenericLn("Let's see how he does it:");

        var record = new VinylRecord("2742984738947894790942370470", "De stilte voorbij", "2000", "[PIAS] Holland", "Normal");
        printMagentaGenericLn("This is our record. It's a vinyl! %s", record);
        printMagentaGenericLn("We'll call `checkItem` in different ways!");
        printMagentaGenericLn("Shop.checkItem(record);");
        Shop.checkItem(record);
        printMagentaGenericLn("Shop.checkItem((Record) record);");
        Shop.checkItem((Record) record);
        printMagentaGenericLn("Shop.checkItem((ShopItem) record);");
        Shop.checkItem((ShopItem) record);
        printMagentaGenericLn("Finally we make a machine a start the `checkItem` procedure without a record");
        Shop.checkItem(null);
        printGreenGenericLn("Never forget that a call with null will search for the most specific overloading!");
    }

    private static void exercise4() {
        printBrightCyanGenericLn("--- 4. `@Override` in `equals`");
        printRainbowLn("==");
        printGreenGenericLn("Case: We want to buy a record of Maaike Ouboter");
        printGreenGenericLn("We made a selection of an article we really want to buy.");
        printMagentaGenericLn("Customer -> Good morning, do you have Maaike Ouboter album \"Vanaf nu is het van jou?\"");
        printMagentaGenericLn("Clerk -> Yes I do, let me check...");
        var albumsInStore = List.of(
                new ShopItem("2742984738947894790942370470", "Vanaf nu is het van jou", "2018", "Sony Music Entertainment", "Normal"),
                new ShopItem("2394720347320943290482084328", "Vanaf nu is het van jou", "2018", "Sony Music Entertainment", "Special"),
                new ShopItem("9839043805934789054378573895", "En hoe het dan ook weer dag wordt", "2015", "Sony Music Entertainment", "Normal")
        );
        printMagentaGenericLn("Clerk -> So that album was published in %s, by %s, one moment...", "2018", "Sony Music Entertainment");
        List<ShopItem> itemsInStore = albumsInStore.stream().filter(shopItem -> shopItem.equals(new ShopItem("", "Vanaf nu is het van jou", "2018", "Sony Music Entertainment", "Normal")))
                .collect(Collectors.toList());
        printMagentaGenericLn("Clerk -> We seem to have two of those, do you know exactly the one you want?\n%s", itemsInStore);
        printMagentaGenericLn("Customer -> Yes, I want the special super special please");
        printMagentaGenericLn("Clerk -> Yes, let me check if we have it... %b. We don't sorry. Do you have another selection?",itemsInStore.contains(new ShopItem("", "Vanaf nu is het van jou", "2018", "Sony Music Entertainment", "SuperSpecial")));
        printMagentaGenericLn("Customer -> Yes, I want the special edition please");
        printMagentaGenericLn("Clerk -> Yes, let me check if we have it... %b. Yes! We do! Great! 😉", itemsInStore.contains(new ShopItem("", "Vanaf nu is het van jou", "2018", "Sony Music Entertainment", "Special")));
        printGreenGenericLn("Important take out here is that `@Override` must be done with `Object` and equals can of course be overloaded.");
    }

    private static void exercise3() {
        printBrightCyanGenericLn("--- 3. `Files.newDirectoryStream` Listings and the `glob` pattern");
        printRainbowLn("==");
        printGreenGenericLn("Case: We saved a part of Abel's Lyrics somewhere, for our social study work, but we don't know where the file is.");
        printGreenGenericLn("We took the lyrics from https://www.musixmatch.com/lyrics/Abel/Onderweg,");
        printGreenGenericLn("but now we have no access to the internet and we have to deliver our work in 2 hours! Help!");
        printGreenGenericLn("In this exercise we will find Abel's lyrics in our tmp folder. We hope the system hasn't deleted it yet...");
        printMagentaGenericLn("We will try to find our file in /tmp. Remember to run ./prepare.sh. Check Readme.md for more details:");

        try {
            var temporaryFolder = Paths.get("/tmp");
            var glob1 = "*.{gif,jpeg,jpg,bmp}";
            printGreenGenericLn("If we use a glob filter of %s we get:", glob1);
            DirectoryStream<Path> ds1 = Files.newDirectoryStream(temporaryFolder, glob1);
            Spliterator<Path> spliterator1 = ds1.spliterator();
            if (spliterator1.tryAdvance(Consolerizer::printYellowGenericLn)) {
                spliterator1.forEachRemaining(Consolerizer::printYellowGenericLn);
            } else {
                printRedGenericLn("No file found!");
            }
            var glob2 = "*.{txt}";
            printGreenGenericLn("This was the wrong extension! If we use a glob filter of %s we get:", glob2);
            DirectoryStream<Path> ds2 = Files.newDirectoryStream(temporaryFolder, glob2);
            Spliterator<Path> spliterator2 = ds2.spliterator();
            if (spliterator2.tryAdvance(Consolerizer::printYellowGenericLn)) {
                spliterator2.forEachRemaining(Consolerizer::printYellowGenericLn);
            } else {
                printRedGenericLn("No file found!");
                printRedGenericLn("We have to stop the lesson here because the test file isn't in /tmp folder. Please check Readme.md about running ./prepare.sh. If you still have issues try copying manually.");
                System.exit(1);
            }
            final String glob3 = "[ebal][ebal][ebal][ebal].[rwegonde][rwegonde][rwegonde][rwegonde][rwegonde][rwegonde][rwegonde][rwegonde].{txt}";
            printGreenGenericLn("But this may lead to a lot of them! If we use a glob filter of %s we get:", glob3);
            DirectoryStream<Path> ds3 = Files.newDirectoryStream(temporaryFolder, glob3);
            Spliterator<Path> spliterator3 = ds3.spliterator();
            if (spliterator3.tryAdvance(Consolerizer::printYellowGenericLn)) {
                spliterator3.forEachRemaining(Consolerizer::printYellowGenericLn);
            } else {
                printRedGenericLn("No file found!");
                printRedGenericLn("We have to stop the lesson here because the test file isn't in /tmp folder. Please check Readme.md about running ./prepare.sh. If you still have issues try copying manually.");
                System.exit(1);
            }
            final String glob4 = "abel.onderweg.?";
            printGreenGenericLn("But this may still lead to a lot of them! If we use a glob filter of %s we get:", glob4);
            DirectoryStream<Path> ds4 = Files.newDirectoryStream(temporaryFolder, glob4);
            Spliterator<Path> spliterator4 = ds4.spliterator();
            if (spliterator4.tryAdvance(Consolerizer::printYellowGenericLn)) {
                spliterator4.forEachRemaining(Consolerizer::printYellowGenericLn);
            } else {
                printRedGenericLn("No file found!");
                printRedGenericLn("We have to stop the lesson here because the test file isn't in /tmp folder. Please check Readme.md about running ./prepare.sh. If you still have issues try copying manually.");
                System.exit(1);
            }
            final String glob5 = "abel.onderweg.{txt}";
            printGreenGenericLn("But this is not even our file!! If we use a glob filter of %s we get:", glob5);
            DirectoryStream<Path> ds5 = Files.newDirectoryStream(temporaryFolder, glob5);
            Spliterator<Path> spliterator5 = ds5.spliterator();
            if (!spliterator5.tryAdvance(file -> {
                try (var fis = new FileInputStream(file.toFile())) {
                    printBlueGenericLn(new String(fis.readAllBytes(), Charset.defaultCharset()));
                } catch (IOException e) {
                    printRedGenericLn("This was not supposed to have happened! %s", e);
                    System.exit(1);
                }
                printYellowGenericLn(file);
                printRainbowTitleLn("We finally found it!");
            })) {
                printRedGenericLn("No file found!");
                printRedGenericLn("We have to stop the lesson here because the test file isn't in /tmp folder. Please check Readme.md about running ./prepare.sh. If you still have issues try copying manually.");
                System.exit(1);
            }
        } catch (IOException e) {
            printRedGenericLn("This was not supposed to have happened! %s", e);
            System.exit(1);
        }
    }

    private static void exercise2() {
        printBrightCyanGenericLn("--- 2. Labels and `break` in loops");
        printRainbowLn("==");
        printGreenGenericLn("Case: You are a fan of \"De Jeugd van Tegenwoordig\" and you just keep buying their records.");
        printGreenGenericLn("You have a shelf with three rows where your records are organized by most favourite too less favourite album.");
        printGreenGenericLn("However, you bought a bunch of repeated records and because of your mood wings,");
        printGreenGenericLn("You don't even know anymore which one is your favourite and which one is not.");
        printGreenGenericLn("So now you have 2 records on the top shelf, 4 on the second one and 10 at the bottom!");
        printGreenGenericLn("But \"De Jeugd van Tegenwoordig\" only edited 8 albums!");
        printGreenGenericLn("We will use old fashioned for loops to figure out this mess.");
        printGreenGenericLn("On our example we just want to check how many iteration our for loops will perform.");
        printGreenGenericLn("Our criteria is:");
        printGreenGenericLn("1. For loop will break once a repetition is found");
        printGreenGenericLn("2. The Atomic Integer counts the number of repetitions found");
        printGreenGenericLn("3. Keep in mind that there might be more repetitions in one particular iteration, but those are not counted");
        printGreenGenericLn("4. Remember that the for loop will break and will skip the rest of the albums on that iteration");
        printGreenGenericLn("5. No repetitions will be counted on the same shelf");
        printGreenGenericLn("6. I know its difficult but that's the point 😊");
        printGreenGenericLn("Your goal is to guess how many iterations will the atomic number count");
        var albumList = List.of("Parels voor de zwijnen", "De Machine", "De lachende derde", "“Ja, Natúúrlijk!”", "X - Viering van het super decennium", "Manon", "Luek", "Anders (Different)");
        var random = new Random();
        int numberOfAlbums = albumList.size();
        class RandomizerDWVT {
            public List<String> getAlbums(int n) {
                return IntStream.range(0, n).map(i -> random.nextInt(numberOfAlbums))
                        .mapToObj(albumList::get).collect(Collectors.toList());
            }

        }
        var dwtRandomizer = new RandomizerDWVT();
        printGreenGenericLn("These are your randomized shelves:");
        int nShelf1 = 2;
        var shelf1 = dwtRandomizer.getAlbums(nShelf1);
        printGreenGenericLn("Shelf 1 -> %s", shelf1);
        int nShelf2 = 4;
        var shelf2 = dwtRandomizer.getAlbums(nShelf2);
        printGreenGenericLn("Shelf 2 -> %s", shelf2);
        int nShelf3 = 10;
        var shelf3 = dwtRandomizer.getAlbums(nShelf3);
        printGreenGenericLn("Shelf 3 -> %s", shelf3);
        printGreenGenericLn("Please guess how many repetitions will this method find ->", shelf3);
        var scanner = new Scanner(System.in);
        var repetitions = scanner.nextInt();
        var atomicInteger = new AtomicInteger();
        SHELF1:
        for (int i = 0; i < nShelf1; i++) {
            SHELF2:
            for (int j = 0; j < nShelf2; j++) {
                if (shelf1.get(i).equals(shelf2.get(j))) {
                    atomicInteger.incrementAndGet();
                    break;
                }
                SHELF3:
                for (int k = 0; k < nShelf3; k++) {
                    if (shelf3.get(k).equals(shelf2.get(j)) || shelf3.get(k).equals(shelf1.get(i))) {
                        atomicInteger.incrementAndGet();
                        break;
                    }
                }
            }
        }
        if (repetitions == atomicInteger.get()) {
            printGreenGenericLn("You made it champ!! There are indeed %d repetitions found! 🥇", atomicInteger.get());
        } else {
            printRedGenericLn("You failed this time, but try again. %d repetitions were found. Your participation awards you with a medal of courage! 🎖", atomicInteger.get());
        }
        printGreenGenericLn("1. https://nl.wikipedia.org/wiki/De_Jeugd_van_Tegenwoordig_(rapgroep)");
        printGreenGenericLn("2. https://www.youtube.com/watch?v=cNMXSKfWfLQ");

    }

    private static void exercise1() {
        printBrightCyanGenericLn("--- 1. `Integer` Mathematical Bases `parseInt`");
        printRainbowLn("==");
        printGreenGenericLn("According to NPO(https://www.nporadio2.nl/song/3230/grote-mannen-worden-klein),  Diggy Dex single, \"Grote Mannen Worden Klein\" was releases in 2014");
        printGreenGenericLn("Let's see different ways to visualize this:");
        var debutGroteMannen = "2014";
        printGreenGenericLn("*** Integer.parseInt(%s)", debutGroteMannen);
        printYellowGenericLn("The single was \"Grote Mannen Worden Klein\" was released, in Decimal, in the year %d", Integer.parseInt(debutGroteMannen, 10));
        var binaryValue = Integer.toBinaryString(2014);
        printGreenGenericLn("*** Integer.parseInt(%s, 2)", binaryValue);
        printYellowGenericLn("The single was \"Grote Mannen Worden Klein\" was released, in Binary, in the year %d", Integer.parseInt(binaryValue, 2));
        printGreenGenericLn("References");
        printGreenGenericLn("1. https://www.nporadio2.nl/song/3230/grote-mannen-worden-klein");
        printGreenGenericLn("2. https://www.last.fm/music/Diggy+Dex/_/Grote+Mannen+Worden+Klein");
        printGreenGenericLn("3. https://www.metrolyrics.com/grote-mannen-worden-klein-lyrics-diggy-dex.html");
    }
}
