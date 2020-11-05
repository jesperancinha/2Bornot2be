package org.jesperancinha.ocp11.mastery2dot2;

import org.jesperancinha.console.consolerizer.Consolerizer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.function.Function;

import static java.util.Arrays.compare;
import static java.util.Arrays.mismatch;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightCyanGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printUnicornsLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGeneric;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Master2Dot2Runner {
    public static void main(String[] args) {

        Consolerizer.typingWaitGlobal = 0;

        printBlueGenericLn("================== Master Module mastery-2-2 ==================");

        printRainbowTitleLn("1. Serializing `FileOutputStream` and `FileInputStream`");
        printRainbowLn("==");
        printYellowGeneric("### Creating Apollo 13 Mission but missing a few details\n");
        String fileName = "/tmp/destination";
        try (var fileOutputStream = new FileOutputStream(fileName);
             var objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            var missionData = new MissionData();
            missionData.destination = "The Moon";
            missionData.origin = "Earth";
            missionData.mission = "Apollo 13";
            objectOutputStream.writeObject(missionData);
            printGreenGenericLn("File has been created on this location -> %s", fileName);
            printGreenGenericLn("Data -> %s", missionData);
            printGreenGenericLn("Please run module %s to realize that default fields are read with Java default values and not the assigned ones,\nif they are not part of the serialized data", "mastery-2-2-deserializer");
        } catch (IOException e) {
            e.printStackTrace();
        }

        printRainbowTitleLn("2. `compare` and `mismatch` in arrays");
        printRainbowLn("==");
        printYellowGenericLn("### We compare two arrays defining the crew and test mismatch and compare");
        var astronauts1 = new String[]{"James A. Lovell", "John L. Swigert, Jr.", "Fred W. Haise, Jr."};
        var astronauts2 = new String[]{"Jim Lovell", "Jack Swigert", "Fred Haise"};
        var astronauts3 = new String[]{"James A. Lovell", "Jack Swigert", "Fred W. Haise, Jr."};
        printBrightCyanGenericLn("comparing %s with %s -> result is: %s", astronauts1, astronauts2, compare(astronauts1, astronauts2));
        printGreenGenericLn("comparing %s with %s -> result is: %s", astronauts1[0], astronauts2[0], astronauts1[0].compareTo(astronauts2[0]));
        printBrightCyanGenericLn("comparing %s with %s -> result is: %s", astronauts1, astronauts3, compare(astronauts1, astronauts3));
        printGreenGenericLn("comparing %s with %s -> result is: %s", astronauts1[1], astronauts3[1], astronauts1[1].compareTo(astronauts3[1]));
        printGreenGenericLn("comparing %s with %s -> result is: %s", astronauts3[1], astronauts1[1], astronauts3[1].compareTo(astronauts1[1]));
        printGreenGenericLn("comparing %s with %s -> result is: %s", astronauts1[2], astronauts3[2], astronauts1[2].compareTo(astronauts3[2]));
        printBrightCyanGenericLn("comparing %s with %s -> result is: %s", astronauts2, astronauts3, compare(astronauts2, astronauts3));
        printYellowGenericLn("### We mismatch two arrays defining the crew and test mismatch and compare");
        printBrightCyanGenericLn("mismatching %s with %s -> result is: %s", astronauts1, astronauts2, mismatch(astronauts1, astronauts2));
        printGreenGenericLn("mismatching %s with %s -> result is: %s", astronauts1[0], astronauts2[0], astronauts1[0].compareTo(astronauts2[0]));
        printBrightCyanGenericLn("mismatching %s with %s -> result is: %s", astronauts1, astronauts3, mismatch(astronauts1, astronauts3));
        printGreenGenericLn("comparing %s with %s -> result is: %s", astronauts1[1], astronauts3[1], astronauts1[1].compareTo(astronauts3[1]));
        printGreenGenericLn("comparing %s with %s -> result is: %s", astronauts3[1], astronauts1[1], astronauts3[1].compareTo(astronauts1[1]));
        printGreenGenericLn("comparing %s with %s -> result is: %s", astronauts1[2], astronauts3[2], astronauts1[2].compareTo(astronauts3[2]));
        printBrightCyanGenericLn("mismatching %s with %s -> result is: %s", astronauts2, astronauts3, mismatch(astronauts2, astronauts3));
        printYellowGenericLn("### Note that comparing is different with integers");
        var badCounting = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 1};
        var goodCounting = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        var badCounting2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 11};
        var badCounting2AndShort = new int[]{1, 2, 3};
        printGreenGenericLn("comparing %s with %s -> result is: %s", badCounting, goodCounting, Arrays.compare(badCounting, goodCounting));
        printGreenGenericLn("mismatching %s with %s -> result is: %s", badCounting, goodCounting, Arrays.mismatch(badCounting, goodCounting));
        printGreenGenericLn("comparing %s with %s -> result is: %s", badCounting2, goodCounting, Arrays.compare(badCounting2, goodCounting));
        printGreenGenericLn("comparing %s with %s -> result is: %s", badCounting2AndShort, goodCounting, Arrays.compare(badCounting2AndShort, goodCounting));

        printRainbowTitleLn("3. TYPE_USE and TYPE_PARAMETER");
        printRainbowLn("==");
        printYellowGenericLn("### A TYPE_USE case");
        printBlueGenericLn("@Rocket String rocket1 = \"Saturn V\";");
        @Rocket String rocket1 = "Saturn V";
        printBlueGenericLn("var rocket2 = (@Rocket String) \"Saturn V\";");
        var rocket2 = (@Rocket String) "Saturn V";
        printBlueGenericLn("Function<Integer, String> f = ( @Rocket Integer val ) -> Integer.toHexString(val);");
        Function<Integer, String> f = (@Rocket Integer val) -> Integer.toHexString(val);
        printYellowGenericLn("### A TYPE_PARAMETER case");
        var missionModified = new MissionDataTyped<String>();
        printBlueGenericLn("var missionModified = new MissionDataTyped<String>();");
        printYellowGenericLn("### Not that TYPE_PARAMETER is a part of TYPE_USE. If you have TYPE_USE, you don't need TYPE_PARAMETER");

        printRainbowTitleLn("4. Switch valid numeric types and their limits");
        printRainbowLn("==");
        printYellowGenericLn("### Permitted Values");
        printYellowGenericLn("### short");
        printGreenGenericLn("%s <= byte <= %s", Byte.MIN_VALUE, Byte.MAX_VALUE);
        printYellowGenericLn("### byte");
        printGreenGenericLn("%s <= short <= %s", Short.MIN_VALUE, Short.MAX_VALUE);
        printYellowGenericLn("### int");
        printGreenGenericLn("%s <= short <= %s", Integer.MIN_VALUE, Integer.MAX_VALUE);
        printYellowGenericLn("### char");
        printGreenGenericLn("%d <= char <= %d", (int) Character.MIN_VALUE, (int) Character.MAX_VALUE);
        printGreenGenericLn("%c <= char <= %c", Character.MIN_VALUE, Character.MAX_VALUE);
        printRedGenericLn("### Not permitted Values");
        printRedGenericLn("### bool");
        printRedGenericLn("%s <= bool <= %s", Boolean.FALSE, Boolean.TRUE);
        printRedGenericLn("### long");
        printRedGenericLn("%s <= long <= %s", Long.MIN_VALUE, Long.MAX_VALUE);
        printRedGenericLn("### float");
        printRedGenericLn("%s <= float <= %s", Float.MIN_VALUE, Float.MAX_VALUE);
        printRedGenericLn("### double");
        printRedGenericLn("%s <= double <= %s", Double.MIN_VALUE, Double.MAX_VALUE);

        printRainbowTitleLn("5. Float value declaration");
        printRainbowLn("==");
        printYellowGenericLn("### We try to assign an absolute number");
        float fNumber = 1000;
        printBlueGenericLn(fNumber);
        printYellowGenericLn("### We try to assign a number with decimals. Think that by default they are double");
        fNumber = 100.12345f;
        printBlueGenericLn(fNumber);
        printYellowGenericLn("### With a double, we do not need to cast");
        double dNumber = 100.45677;
        printBlueGenericLn(dNumber);

        printUnicornsLn(100);
    }
}
