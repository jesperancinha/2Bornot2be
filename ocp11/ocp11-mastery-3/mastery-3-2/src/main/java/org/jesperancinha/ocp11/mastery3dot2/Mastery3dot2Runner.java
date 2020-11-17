package org.jesperancinha.ocp11.mastery3dot2;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.ocp11.mastery3dot2.mercado.Building;
import org.jesperancinha.ocp11.mastery3dot2.mercado.Construction;
import org.jesperancinha.ocp11.mastery3dot2.mercado.Market;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightCyanGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printUnicornsLn;

public class Mastery3dot2Runner {
    public static void main(String[] args) {
        Consolerizer.typingWaitGlobal = 0;

        printBlueGenericLn("================== Master Module mastery-3-2 ==================");

        exercise1();

        printUnicornsLn(100);
        printGreenGenericLn("Hope you enjoyed this mastery into Java 11 with the flavour, sounds, sexyness and lights of Olhão City!");
        printGreenGenericLn("Please keep coming back as I'll be creating more mastery modules.");
        printGreenGenericLn("Thank you!");
        printUnicornsLn(100);
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
        printGreenGenericLn("The constructors themselves are not called.");
    }
}
