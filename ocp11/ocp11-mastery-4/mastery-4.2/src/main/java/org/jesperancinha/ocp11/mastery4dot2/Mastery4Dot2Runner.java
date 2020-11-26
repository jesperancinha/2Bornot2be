package org.jesperancinha.ocp11.mastery4dot2;

import org.jesperancinha.console.consolerizer.Consolerizer;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightCyanGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printUnicornsLn;

public class Mastery4Dot2Runner {
    private static boolean skipQuestions;

    public static void main(String[] args) {
        if (args.length > 0) {
            skipQuestions = "-skip".equals(args[0]);
        }
        Consolerizer.typingWaitGlobal = 0;
        printBlueGenericLn("==================== Master Module mastery-4-2 ====================");

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

        printUnicornsLn(100);
        printGreenGenericLn("Hope you enjoyed this mastery into Java 11 with some Spanish Indie/Pop flavor flavour to it.");
        printGreenGenericLn("Please keep coming back as I'll be creating more mastery modules.");
        printGreenGenericLn("Thank you!");
        printUnicornsLn(100);
    }

}
