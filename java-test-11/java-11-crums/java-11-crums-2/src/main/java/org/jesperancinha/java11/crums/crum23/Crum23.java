package org.jesperancinha.java11.crums.crum23;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.Consolerizer.printBrightMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;

public class Crum23 {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 23 - Flash conversion exercises ⚡️");

        MAGENTA.printGenericLn("The value of 'a' is:");
        MAGENTA.printGenericLn((int) 'a');
        try {
            MAGENTA.printGenericLn("The value of `a` can also be %d", 'a');
        } catch (IllegalArgumentException e) {
            printRedGenericLn("This is expected. Formatting doesn't automatically convert from char to int. -> %s", e);
        }
        MAGENTA.printGenericLn("And also %c", 'a');

        byte ab = 97;
        char ac = (char) ab;

        MAGENTA.printGenericLn("A can be represent in it's byte form, '%d', or in its char form, '%c'", ab, ac);
        MAGENTA.printGenericLn("The value of an a cam also be a %c", 97);
        MAGENTA.printGenericLn("This is possible. An integer can be directly converted to a char via the formatter.");

        ab = (byte) ac;

        printBrightMagentaGenericLn("Interconversions between char and byte need casting always -> %d", ab);
        MAGENTA.printGeneric("Remember that:");
        printBrightMagentaGenericLn("char is a two byte 2^16 representation of a character. From %d to %d",
            (int) Character.MIN_VALUE, (int) Character.MAX_VALUE);
        printBrightMagentaGenericLn("byte is a one byte 2^8 representation of a number. From %d to %d", Byte.MIN_VALUE,
            Byte.MAX_VALUE);
        printBrightMagentaGenericLn(
            "Note that this happens not exactly because of the difference in size, but because the ranges do not match");

        short as = (short) ac;
        ac = (char) as;

        printBrightMagentaGenericLn("Interconversions between char and short need casting always -> %d", as);
        MAGENTA.printGenericLn("The new char can result from a conversion from short -> %c", ac);
        MAGENTA.printGeneric("Remember that:");
        printBrightMagentaGenericLn("char is a two byte 2^16 representation of a character. From %d to %d",
            (int) Character.MIN_VALUE, (int) Character.MAX_VALUE);
        printBrightMagentaGenericLn("short is a two byte 2^16 representation of a number. From %d to %d",
            Short.MIN_VALUE, Short.MAX_VALUE);
        printBrightMagentaGenericLn("Again the size isn't the issue. The ranges do not match");

        int ai = ac;
        ac = (char) ai;

        printBrightMagentaGenericLn(
            "Interconversions between char and int need casting from int to charm but not from char to int -> %d", ai);
        MAGENTA.printGenericLn("The new char can result from a conversion from int -> %c", ac);
        MAGENTA.printGeneric("Remember that:");
        printBrightMagentaGenericLn("char is a two byte 2^16 representation of a character. From %d to %d",
            (int) Character.MIN_VALUE, (int) Character.MAX_VALUE);
        printBrightMagentaGenericLn("int is a four byte 2^32 representation of a number. From %d to %d",
            Integer.MIN_VALUE, Integer.MAX_VALUE);
        printBrightMagentaGenericLn(
            "Since Integer encompasses the range of char, we can convert char to int without the need to cast it");
        printBrightMagentaGenericLn(
            "Character, however does not encompass the whole range of int and this is why we need to cast it");

        printGreenGenericLn(
            "Remember that for primitives, the casting rule is that if the range doesn't fit you need to cast it");
        printGreenGenericLn("If it fits, then casting is not needed");
    }
}
