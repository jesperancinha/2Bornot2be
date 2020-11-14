package org.jesperancinha.ocp11.mastery3dot1;

import org.jesperancinha.console.consolerizer.Consolerizer;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightCyanGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Mastery3Dot1Runner {
    public static void main(String[] args) {
        Consolerizer.typingWaitGlobal = 0;

        printBlueGenericLn("================== Master Module mastery-3-1 ==================");

        exercise1();


        printBrightCyanGenericLn("--- 2. Labels and `break` in loops");
        printRainbowLn("==");
        printGreenGenericLn("Case: You are a fan of \"De Jeugd van Tegenwoordig\" and you just keep buying their record");
        printGreenGenericLn("You have a shelf with three rows where your records are organized by most favourite less favourite");
        printGreenGenericLn("However, you bought a bunch of repeated records and because your mood wings,");
        printGreenGenericLn("You don't even know anymore which one is your favourite and which one not.");
        printGreenGenericLn("So now you have 2 records on the top shelf, 4 at the second one and 10 at the bottom!");
        printGreenGenericLn("But \"De Jeugds van Tegenwoordig\" only edited 8 albums!");
        printGreenGenericLn("We will use old fashioned for loops to figure out this mess.");
        printGreenGenericLn("On our example we just want to check how many iteration our for loops will perform.");
        printGreenGenericLn("Our criterias are:");
        printGreenGenericLn("1. For loop will break once a repetition is found");
        printGreenGenericLn("2. The Atomic Integer counts the number of repetitions found");
        printGreenGenericLn("3. Keep in mind that there might be more repetitions, but those are not counted");
        printGreenGenericLn("4. Remember that the for loop will break and will skip the rest of the albums on that iteration");
        printGreenGenericLn("5. No repetitions will be counted on the same shelf ");
        printGreenGenericLn("6. I know its difficult but that's the point 😊");
        printGreenGenericLn("Your is to guess how many iterations will the atomic number count");
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
        if(repetitions == atomicInteger.get()){
            printGreenGenericLn("You made it champ!! There are indeed %d repetitions found! 🥇", atomicInteger.get());
        } else {
            printRedGenericLn("You failed this time, but try again. %d repetitions were found. Your participation awards you with a medal of courage! 🎖", atomicInteger.get());
        }
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
