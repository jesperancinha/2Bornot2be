package org.jesperancinha.ocp11.mastery3dot2;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.ocp11.mastery3dot2.cafes.galao.Galao;
import org.jesperancinha.ocp11.mastery3dot2.cafes.garoto.Garoto;
import org.jesperancinha.ocp11.mastery3dot2.festival.Artist;
import org.jesperancinha.ocp11.mastery3dot2.mercado.Building;
import org.jesperancinha.ocp11.mastery3dot2.mercado.Construction;
import org.jesperancinha.ocp11.mastery3dot2.mercado.Market;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingDeque;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightCyanGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printUnicornsLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Mastery3dot2Runner {
    public static void main(String[] args) {
        Consolerizer.typingWaitGlobal = 0;
        Consolerizer.maxLineCharsGlobal = 150;

        printBlueGenericLn("================== Master Module mastery-3-2 ==================");

        exercise1();
        exercise2();
        exercise3();
        exercise4();
        exercise5();
        exercise6();
        exercise7();
        exercise8();
        exercise9();
        exercise10();
        exercise11();

        printUnicornsLn(90);
        printGreenGenericLn("Hope you enjoyed this mastery into Java 11 with the flavour, sounds, sexyness and lights of Olhão City!");
        printGreenGenericLn("Please keep coming back as I'll be creating more mastery modules.");
        printGreenGenericLn("Thank you!");
        printUnicornsLn(90);
    }

    private static void exercise11() {
        printBrightCyanGenericLn("--- 11. Package protected constructors");
        printRainbowLn("==");
        printGreenGenericLn("Case: We are ordering a coffee in Olhão.");
        printGreenGenericLn("In good portuguese tradition we ask for a short coffee by calling it one \"garoto\".");
        printGreenGenericLn("If we want our coffee to be served in a tall glass cup with lots of milk on it, we call it one \"galão'\".");
        printGreenGenericLn("In our case we will try to order one \"Galão\" that is also a \"Garoto\".");
        printGreenGenericLn("Can we do it?");
        var garoto = Garoto.create();
        printMagentaGenericLn("For a starters we can create one %s", garoto);
        var galao = Galao.create();
        printMagentaGenericLn("We can also create one create one %s", galao);
        printGreenGenericLn("The point here is that if classes have package protected constructors, and belong to different packages, they can never be sub-classes of eacht other");
        printGreenGenericLn("This makes this:");
        printGreenGenericLn("        var garoto =new Garoto();");
        printGreenGenericLn("and this:");
        printGreenGenericLn("        var galao = new Galao();");
        printGreenGenericLn("an unaccomplishable possibility.");
    }

    private static void exercise10() {
        printBrightCyanGenericLn("--- 10. local `DateFormat` and `Locale`");
        printRainbowLn("==");
        printGreenGenericLn("Case: What is the day of the City of Olhão and on which year did it occur?");
        DateFormat dateTimeInstance = DateFormat.getDateTimeInstance();
        Locale locale = new Locale.Builder().setLanguage("pt").build();
        printYellowGenericLn(dateTimeInstance.format(new Date(-92, Calendar.JUNE, 16)));
        printYellowGenericLn(locale);
        printGreenGenericLn("The point here is that Locale and DateFormat are independent.");
        printGreenGenericLn("They can, however be bound together:");
        for (int i = 0; i < 4; i++) {
            DateFormat dateTimeInstance2 = DateFormat.getDateTimeInstance(i, 1, locale);
            printYellowGenericLn("DateFormat.getDateTimeInstance(i,%d, locale) -> %s", i, dateTimeInstance2.format(new Date(-92, Calendar.JUNE, 16)));
        }
        for (int i = 0; i < 4; i++) {
            DateFormat dateTimeInstance2 = DateFormat.getDateTimeInstance(0, i, locale);
            printYellowGenericLn("DateFormat.getDateTimeInstance(0,%d, locale) -> %s", i, dateTimeInstance2.format(new Date(-92, Calendar.JUNE, 16)));
        }
        printGreenGenericLn("We can change to different pre-defined styles");
    }

    private static void exercise9() {
        printBrightCyanGenericLn("--- 9. `RandomAccessFile` and `writeUTF`");
        printRainbowLn("==");
        printGreenGenericLn("Case: We want to cook \"Bacalhau à Brás\"");
        printGreenGenericLn("We went to the market and bought some pieces of raw, dried and salted cod fish");
        printGreenGenericLn("The rest of the ingredients are at home");
        printGreenGenericLn("We get home and read our recipe again:");
        try (var raf = new RandomAccessFile("/tmp/bacalhau.a.bras.txt", "rw")) {
            printYellowGenericLn(raf.readLine());
            long filePointer = raf.getFilePointer();
            printYellowGenericLn(raf.readLine());
            raf.writeUTF("I'm corrupting the recipe\n");
            raf.seek(filePointer);
            String line;
            while ((line = raf.readLine()) != null) {
                printYellowGenericLn(line);
            }
            printOrangeGenericLn("Wait! I forgot something!");
            raf.seek(filePointer);
            while ((line = raf.readLine()) != null) {
                printYellowGenericLn(line);
            }
        } catch (IOException e) {
            printRedGenericLn("Ooops! This shouldn't have happened! Check your runtime -> %s", e);
        }
        printGreenGenericLn("RandomAccessFile uses different interfaces than FileInputStream.");
        printGreenGenericLn("But they are all Closeable.");
        printGreenGenericLn("In RandomAccessFile a pointer is used that can be saved to go back and forth in the same file.");
    }

    private static void exercise8() {
        printBrightCyanGenericLn("--- 8. A case for `final` `var` in a `for` loop");
        printRainbowLn("==");
        printGreenGenericLn("Case: Let's get some veggies.");
        printGreenGenericLn("We'll go to the supermarket and get some final vegetables.");
        printGreenGenericLn("We'll do this according to our shopping list.");
        var vegetableToShopList = List.of("Tomatoes", "Potatoes", "Kale", "Lettuse", "1Kg Kidney Beans");
        for (final var vegetable : vegetableToShopList) {
            // This is not possible because var is marked as final
            // vegetable = "wow";
            printYellowGenericLn(vegetable);
        }
        for (var vegetable : vegetableToShopList) {
            vegetable += " with fungus";
            printYellowGenericLn(vegetable);
        }
        printGreenGenericLn("We can use the word final in combination with var to mark it effectively final");
        printGreenGenericLn("Vars are effectively final until they suffer some change.");
        printGreenGenericLn("A final before, makes that change impossible.");
        printGreenGenericLn("final, as a parameter, will not work becaue var isn't supposed to be used as a parameter type");
        printGreenGenericLn("Simple reason that we must remember. var needs to know its types. As a parameter, there is no way it can know that.");
    }

    private static void exercise7() {
        printBrightCyanGenericLn("--- 7. Base modules and the rest");
        printRainbowLn("==");
        printBlueGenericLn("Expected output:\n%s", "Cataplana dish is being served...\n" +
                "cataplana.jar -> java.base\n" +
                "   org.jesperancinha.console.consolerizer             -> java.io                                            java.base\n" +
                "   org.jesperancinha.console.consolerizer             -> java.lang                                          java.base\n" +
                "   org.jesperancinha.console.consolerizer             -> java.lang.invoke                                   java.base\n" +
                "   org.jesperancinha.console.consolerizer             -> java.util                                          java.base\n" +
                "   org.jesperancinha.console.consolerizer             -> java.util.function                                 java.base\n" +
                "   org.jesperancinha.console.consolerizer             -> java.util.stream                                   java.base\n" +
                "   org.jesperancinha.ocp11.mastery3dot2               -> java.lang                                          java.base\n" +
                "   org.jesperancinha.ocp11.mastery3dot2               -> org.jesperancinha.console.consolerizer             cataplana.jar");
        printGreenGenericLn("Please check module %s for more info...", "mastery-3-2-modularity");
    }

    private static void exercise6() {
        printBrightCyanGenericLn("--- 6. `Deque` and `offerLast`, and other methods.");
        printRainbowLn("==");
        printGreenGenericLn("Case: There is a list of clients waiting and the fish seller is registering everything");
        printGreenGenericLn("As we ask for the fish request, it goes to a Deque in order to be processed");
        printGreenGenericLn("What can happen?");
        var dequeQueue = new LinkedBlockingDeque<String>(5);
        dequeQueue.add("500gg Sardines");
        dequeQueue.add("1Kg Codfish");
        dequeQueue.add("800g Swordfish");
        dequeQueue.add("2Kg Octopus");
        dequeQueue.add("10Kg Clams");
        try {
            dequeQueue.add("5Kg Cockles");
        } catch (IllegalStateException e) {
            printRedGenericLn("Note that capacity limit does not show in ArrayDeque, because ArrayDeque grow automatically -> %s", e);
        }
        boolean offer = dequeQueue.offer("4Kg Gambas");
        printMagentaGenericLn("This Deque has now reached its limit of %d elemenst", dequeQueue.size());
        printMagentaGenericLn("With offer, it's essentially giving an offer to the Deque. %s", offer);
        boolean offer2 = dequeQueue.offerFirst("4Kg Shrimps");
        printMagentaGenericLn("With offerFirst, It's the same. %s", offer2);
        printMagentaGenericLn(offer2);
        boolean offer3 = dequeQueue.offerLast("2Kg Oysters");
        printMagentaGenericLn("With offerLast, It's also the same. %s", offer3);
        printMagentaGenericLn(dequeQueue);
        printGreenGenericLn("Deque is a collection");
        printGreenGenericLn("It's a circular collection and there are lots of implementations.");
        printGreenGenericLn("ArrayDeque -> Not Thread-Safe and automatically expands");
        printGreenGenericLn("LinkedBlockingDeque -> Thread-Safe and fixed capacity");
        printGreenGenericLn("Only on fixed capacity Deque's can we explore the full capacity of offer functions");
    }

    private static void exercise5() {
        printBrightCyanGenericLn("--- 5. `final` in `try` with resources");
        printRainbowLn("==");
        printGreenGenericLn("Case: We wanted to cook codfish (Bacalhau).");
        printGreenGenericLn("But we made a mistake when creating the input stream!");
        printGreenGenericLn("I think we can't change this, but let's see what happens!");
        try (var fis = Mastery3dot2Runner.class.getResourceAsStream("/castanhas.assadas.txt")) {
            // Unfortunately this is not possible!
            // variables created in a try clause are always immplicitly final
            // fis = Mastery3dot2Runner.class.getResourceAsStream("./bacalhau.assado.txt")
            printMagentaGenericLn(new String(fis.readAllBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        printGreenGenericLn("A try clause always creates implicitly final variables");
    }

    private static void exercise4() {
        printBrightCyanGenericLn("--- 4. Static method inheritance and overriding");
        printRainbowLn("==");
        printGreenGenericLn("Case: We have a stroll around the market and finally we come across some displays");
        printGreenGenericLn("There we can see how Space's are built across the city.");
        var construction = new Construction("Cement");
        var building = new Building(5f, 26f, 11.5f, "bricks");
        var market = new Market(5f, 26f, 11.5f, "bricks");
        Construction.getInfo();
        Building.getInfo();
        Market.getInfo();
        printYellowGenericLn(construction.getCurrentInfo());
        printYellowGenericLn(((Construction) building).getCurrentInfo());
        printYellowGenericLn(((Construction) market).getCurrentInfo());
        Construction.getInfo();
        Construction.getInfo();
        Construction.getInfo();
        printGreenGenericLn("Important takes from this exercise:");
        printGreenGenericLn("1. static methods are not really overriden. They are however shadowed by another");
        printGreenGenericLn("2. by upcasting, we can call other static  methods");
        printGreenGenericLn("3. Instance methods can be overriden");
        printGreenGenericLn("4. Upcasting will only call the resulting instance method");
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
        final String[][] cookedOysters4 = {{"CookedOyster", "CookedOyster"}, {"CookedOyster", "CookedOyster"}};
        final String[][] cookedOysters5 = {{"CookedOyster", "CookedOyster"}, {"CookedOyster", "CookedOyster"}};
        final String[][] rawOysters = new String[2][2];
        rawOysters[0][0] = "RawOyster";
        rawOysters[0][1] = "RawOyster";
        rawOysters[1][0] = "RawOyster";
        rawOysters[1][1] = "RawOyster";
        final String[][] mussels = new String[2][];
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
