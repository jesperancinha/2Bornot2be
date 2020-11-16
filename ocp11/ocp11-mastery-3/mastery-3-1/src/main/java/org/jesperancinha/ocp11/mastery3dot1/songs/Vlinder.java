package org.jesperancinha.ocp11.mastery3dot1.songs;

import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;

public class Vlinder extends RawVlinder{
    @Override
    public void playVlinder() {
        printOrangeGenericLn("Maaike Ouboter sang a cover version of `Verdronken Vlinder in dutch TV show `De Dereld Draait Door`");
    }

    @Override
    public void publicPoint() {
        printRedGenericLn("In this case you can just call the public method. Note that the abstraction is package protected.");
        printRedGenericLn("This means that it is the strictest next to `private`");
        printRedGenericLn("So we can implement it with `protected` and `public` only.");
    }

    // 'playVlinder()' in 'org.jesperancinha.ocp11.mastery3dot1.songs.Vlinder' clashes with 'playVlinder()' in 'org.jesperancinha.ocp11.mastery3dot1.songs.RawVlinder';
    // attempting to assign weaker access privileges ('private'); was 'packageLocal'
    // @Override
    // private void playVlinder() {
    //     printOrangeGenericLn("The original version of `Verdronken vlinder` came about in 1967 as a B-Side recording of Boudewijn de Groot's single `Onder ons`");
    // }
}
