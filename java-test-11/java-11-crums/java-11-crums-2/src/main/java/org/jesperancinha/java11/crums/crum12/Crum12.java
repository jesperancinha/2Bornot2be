package org.jesperancinha.java11.crums.crum12;

import static org.jesperancinha.console.consolerizer.ConColor.BLUE;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

public class Crum12 {
    public static void main(String[] args) {
        BLUE.printGenericTitleLn("Crum 12 - StringBuilder capacity and limitation");

        var sb1 = new StringBuilder(10);

        var sb2 = new StringBuilder(50);

        var sb3 = new StringBuilder(100);
        printMagentaGenericLn("Before assigning:");
        printMagentaGenericLn("These are the lyrics using sb1 -> %s", sb1);
        printMagentaGenericLn(sb1.length());
        printMagentaGenericLn(sb1.capacity());
        printMagentaGenericLn("These are the lyrics using sb2 -> %s", sb2);
        printMagentaGenericLn(sb2.length());
        printMagentaGenericLn(sb2.capacity());
        printMagentaGenericLn("These are the lyrics using sb3 -> %s", sb3);
        printMagentaGenericLn(sb3.length());
        printMagentaGenericLn(sb3.capacity());

        printMagentaGenericLn("https://www.lyrics.com/lyric/5234990/Romeo");
        sb1.append("You Keep on giving me the Hold up\nYou know I wish you'd make your mind up");
        sb2.append("You Keep on giving me the Hold up\nYou know I wish you'd make your mind up");
        sb3.append("You Keep on giving me the Hold up\nYou know I wish you'd make your mind up");

        printMagentaGenericLn("After  assigning:");
        printMagentaGenericLn("These are the lyrics using sb1 -> %s", sb1);
        printMagentaGenericLn(sb1.length());
        printMagentaGenericLn(sb1.capacity());
        printMagentaGenericLn("These are the lyrics using sb2 -> %s", sb2);
        printMagentaGenericLn(sb2.length());
        printMagentaGenericLn(sb2.capacity());
        printMagentaGenericLn("These are the lyrics using sb3 -> %s", sb3);
        printMagentaGenericLn(sb3.length());
        printMagentaGenericLn(sb3.capacity());

        printMagentaGenericLn("Now we want to make sure that our built string only holds 100 characters");

        sb1.setLength(50);
        sb2.setLength(50);
        sb3.setLength(50);

        printYellowGenericLn("This works in all 3 cases:\n%s\n%s\n%s", sb1, sb2, sb3);
        printYellowGenericLn("With the new capacities:  \n%d\n%d\n%d", sb1.capacity(), sb2.capacity(), sb3.capacity());

        sb1.ensureCapacity(80);
        sb2.ensureCapacity(100);
        sb2.ensureCapacity(150);
        printMagentaGenericLn("If we ensure other capacities:");
        printYellowGenericLn("With the new capacities: \n%d\n%d\n%d", sb1.capacity(), sb2.capacity(), sb3.capacity());
        printMagentaGenericLn(
            "See that sb2 went from 102 to 206? Ensuring capacity can lead to exponentially increase capacity");
        printMagentaGenericLn("We ensure 100 but it had 102, so it will calculate a new one = 102 * 2 + 2 = 206");

        printMagentaGenericLn("We can add the rest later:");

        sb1.append("you'd make your mind up");
        sb2.append("you'd make your mind up");
        sb3.append("you'd make your mind up");

        printYellowGenericLn("This works in all 3 cases:\n%s\n%s\n%s", sb1, sb2, sb3);
        printYellowGenericLn("With the new capacities:  \n%d\n%d\n%d", sb1.capacity(), sb2.capacity(), sb3.capacity());

        printMagentaGenericLn("Finally we make capacities negative.");
        sb1.ensureCapacity(-1);
        sb2.ensureCapacity(-1);
        sb3.ensureCapacity(-1);
        printMagentaGenericLn("No Error! But also no change:");
        printYellowGenericLn("With the new capacities:  \n%d\n%d\n%d", sb1.capacity(), sb2.capacity(), sb3.capacity());
        printMagentaGenericLn("How about a negative length?");
        try {
            sb1.setLength(-1);
            sb2.setLength(-1);
            sb3.setLength(-1);
        } catch (StringIndexOutOfBoundsException e) {
            printRedGenericLn("As you can see, this is not possible.");
            printRedGenericLn("And this makes sense because there is a check for length in the 'setLength' method.");
            printRedGenericLn(
                "Either way, always recommended to catch this exception with an IndexOutOfBoundsException -> %s", e);
        } printGreenGenericLn("Capacity is an optimization measure in place to build strings");
        printGreenGenericLn("There is no practical effect except when performance tests are done");
        printGreenGenericLn(
            "Capacity increases by 2x capacity factor + 2. If this is not enough to hold the new string, the new capacity is the length of the new String");

        printGreenGenericLn(
            "'setLength' can truncate the build, but no changes in capacity happen if it does. Expansion will of course change capacity as usual");
    }
}
