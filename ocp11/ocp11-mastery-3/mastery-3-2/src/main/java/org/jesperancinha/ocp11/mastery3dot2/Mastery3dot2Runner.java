package org.jesperancinha.ocp11.mastery3dot2;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.ocp11.mastery3dot2.festival.Artist;
import org.jesperancinha.ocp11.mastery3dot2.mercado.Building;
import org.jesperancinha.ocp11.mastery3dot2.mercado.Construction;
import org.jesperancinha.ocp11.mastery3dot2.mercado.Market;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightCyanGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printUnicornsLn;

public class Mastery3dot2Runner {
    public static void main(String[] args) {
        Consolerizer.typingWaitGlobal = 0;

        printBlueGenericLn("================== Master Module mastery-3-2 ==================");

        exercise1();
        exercise2();
        exercise3();

        printUnicornsLn(100);
        printGreenGenericLn("Hope you enjoyed this mastery into Java 11 with the flavour, sounds, sexyness and lights of Olhão City!");
        printGreenGenericLn("Please keep coming back as I'll be creating more mastery modules.");
        printGreenGenericLn("Thank you!");
        printUnicornsLn(100);
    }

    private static void exercise3() {
        printBrightCyanGenericLn("--- 3. Sorting Immutable `List`'s");
        printRainbowLn("==");
        printGreenGenericLn("Case: We finally got the listings of the \"Festival do Marisco 2019\"");
        printGreenGenericLn("We want to keep these listings safe, will anyone be able to change them?");
        var artist1 = new Artist("Matias Damásio e Aurea", LocalDate.of(2019, 8, 9));
        var artist2 = new Artist("HMB", LocalDate.of(2019, 8, 10));
        var artist3 = new Artist("Killer Queen", LocalDate.of(2019, 8, 11));
        var artist4 = new Artist("Paula Fenandes", LocalDate.of(2019, 8, 12));
        var artist5 = new Artist("Ludmilla", LocalDate.of(2019, 8, 13));
        var artist6 = new Artist("Resistência", LocalDate.of(2019, 8, 14));
        var allArtists = List.of(artist1, artist2, artist3, artist4, artist5, artist6);
        try {
            allArtists.sort(Artist::compare);
        } catch (UnsupportedOperationException e) {
            printRedGenericLn("We are attempting to change a well established list.");
            printRedGenericLn("allArtists.sort(Artist::compare); -> This list is marked as immutable. We get this error: %s", e);
        }
        try {
            List.copyOf(allArtists).sort(Artist::compare);
        } catch (UnsupportedOperationException e) {
            printRedGenericLn("Making a copy of immutable also doesn't work");
            printRedGenericLn("List.copyOf(allArtists).sort(Artist::compare); -> This list is marked as immutable. We get this error: %s", e);
        }
        try {
            new ArrayList<>(allArtists).sort(Artist::compare);
            printGreenGenericLn("new ArrayList<>(allArtists).sort(Artist::compare); -> This is probably the only way to get a changed list and make modifications on it.");
            printGreenGenericLn("We just create a new ArrayList from the immutable list in order to get a mutable list.");
        } catch (UnsupportedOperationException e) {
            printRedGenericLn("Ooops... This should not have happened. Please check your runtime: %s", e);
        }
        printGreenGenericLn("Immutability principles are very common and traverse the whole JDK.");
        printGreenGenericLn("When working with collections it is important to understand when to we get immutables and when do we get mutables");
    }

    private static void exercise2() {
        printBrightCyanGenericLn("--- 2. Multi-dimensional arrays and ways to create them");
        printRainbowLn("==");
        printGreenGenericLn("Case: We are staying at a 5 star hotel in Olhão");
        printGreenGenericLn("The hotel serves us a 2X2 portion of cooked oysters plate.");
        printGreenGenericLn("It also serves 2X2 worldwide known raw oyster plate.");
        printGreenGenericLn("The mussels come fresh uit the fisherman's net.");
        printGreenGenericLn("We are buying them as they come along.");
        printGreenGenericLn("Good for us, good for the fisherman's and good for the economy.");
        printGreenGenericLn("In how many ways can we serve these plates?");

        var cookedOysters1 = new String[][]{{"CookedOyster", "CookedOyster"}, {"CookedOyster", "CookedOyster"}};
        final String[][] cookedOysters2 = {{"CookedOyster", "CookedOyster"}, {"CookedOyster", "CookedOyster"}};
        final String[][] cookedOysters3 = new String[2][2];
        cookedOysters3[0][0] = "CookedOyster";
        cookedOysters3[0][1] = "CookedOyster";
        cookedOysters3[1][0] = "CookedOyster";
        cookedOysters3[1][1] = "CookedOyster";
        final String[] cookedOysters4[] = {{"CookedOyster", "CookedOyster"}, {"CookedOyster", "CookedOyster"}};
        final String cookedOysters5[][] = {{"CookedOyster", "CookedOyster"}, {"CookedOyster", "CookedOyster"}};
        final String[][] rawOysters = new String[2][2];
        rawOysters[0][0] = "RawOyster";
        rawOysters[0][1] = "RawOyster";
        rawOysters[1][0] = "RawOyster";
        rawOysters[1][1] = "RawOyster";
        final String[] mussels[] = new String[2][];
        mussels[0] = new String[2];
        mussels[1] = new String[3];
        mussels[0][0] = "CookedMussel";
        mussels[0][1] = "CookedMussel";
        mussels[1][0] = "CookedMussel";
        mussels[1][1] = "CookedMussel";
        mussels[1][2] = "CookedMussel";
        printBlueGenericLn("var cookedOysters1 = new String[][]{{\"CookedOyster\", \"CookedOyster\"}, {\"CookedOyster\", \"CookedOyster\"}}; -> %s", cookedOysters1, "");
        printBlueGenericLn("final String[][] cookedOysters2 = {{\"CookedOyster\", \"CookedOyster\"}, {\"CookedOyster\", \"CookedOyster\"}}; -> %s", cookedOysters2);
        printBlueGenericLn("final String[][] cookedOysters3 = new String[2][2]; -> %s", cookedOysters3);
        printBlueGenericLn("final String[] cookedOysters4 [] = {{\"CookedOyster\", \"CookedOyster\"}, {\"CookedOyster\", \"CookedOyster\"}};", cookedOysters4);
        printBlueGenericLn("final String cookedOysters5 [][] = {{\"CookedOyster\", \"CookedOyster\"}, {\"CookedOyster\", \"CookedOyster\"}};", cookedOysters5);
        printBlueGenericLn("final String [][] rawOysters = new String[2][2];", rawOysters);
        printBlueGenericLn("final String [] mussels [] = new String[2][];", mussels);
        printGreenGenericLn("Big takeouts here for something seemingly simple:");
        printGreenGenericLn("1. All arrays must have at least one dimension");
        printGreenGenericLn("2. The first dimension MUST have a defined size upon initialization");
        printGreenGenericLn("3. var needs to know its type. Therefore an array declared with var can only be created with new");
        printGreenGenericLn("4. Different positions of a multidimensional array may have different array sizes in sub-dimensions");
        printGreenGenericLn("6. The rectangular brackets my follow a C++ or a Java notation. In other workds, brackets can be declared just before or just after the variable name with no particular restrictions on how many in the left or the right side");
    }

    private static void exercise1() {
        printBrightCyanGenericLn("--- 1. Serialization and polymorphism");
        printRainbowLn("==");
        printGreenGenericLn("Case: We are taking info from the \"Mercado de Olhão\"");
        printGreenGenericLn("When try to get the information from the registration website,");
        printGreenGenericLn("we cannot find the most common material!");
        printGreenGenericLn("Let's see how we register and then get the data.");
        var mercadoDeOlhao = new Market(5f, 26f, 11.5f, "bricks");
        printMagentaGenericLn("We register our data in %s", mercadoDeOlhao);
        printMagentaGenericLn("We register our data in %s", ((Building) mercadoDeOlhao).toString());
        printMagentaGenericLn("We register our data in %s", ((Construction) mercadoDeOlhao).toString());
        printBlueGenericLn("Sending data to file system...");
        var fileName = "/tmp/mastery3.3.obj";
        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(mercadoDeOlhao);
        } catch (IOException e) {
            e.printStackTrace();
        }
        printBlueGenericLn("Data Sent!");
        printBlueGenericLn("Retrieving data from file system...");
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            var newMarket = (Market) objectInputStream.readObject();
            printMagentaGenericLn("We read our data back from the file system and it is %s", newMarket);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        printGreenGenericLn("The takeout here, is that the non-serializable class, does not participate in the serializing process.");
        printGreenGenericLn("Although its constructor is called, no instance members are set.");
        printGreenGenericLn("The compiler needs the empty constructors only to know that the runtime can build these instances without parameters.");
        printGreenGenericLn("The constructors themselves are not called in the serializable instances.");
    }
}
