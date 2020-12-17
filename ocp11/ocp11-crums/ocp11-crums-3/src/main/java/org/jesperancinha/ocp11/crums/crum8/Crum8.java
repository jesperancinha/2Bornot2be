package org.jesperancinha.ocp11.crums.crum8;

import java.nio.file.Path;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericTitleLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printGreenGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printMagentaGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;

public class Crum8 {
    public static void main(String[] args) {
        printBlueGenericTitleLn("Crum 8 - Relativizing Paths");
        var path1 = Path.of("/tmp/file1");
        var path2 = Path.of("/tmp/file2");

        printMagentaGenericLn("We can relativize path1 with path 2 and get this result:");
        printOrangeGenericLn(path1.relativize(path2));
        printMagentaGenericLn("The other way around:");
        printOrangeGenericLn(path2.relativize(path1));

        printMagentaGenericLn("What if one of the paths is just a file name without a root path?");

        var path3 = Path.of("filename3");
        try {
            printOrangeGenericLn(path1.relativize(path3));
            printOrangeGenericLn(path3.relativize(path1));
        } catch (IllegalArgumentException e) {
            printRedGenericLn(
                "This is expected! Relativizing a filename with a filename with a path does not make sense -> %s", e);

        }

        printMagentaGenericLn(
            "We can also resolve but in this case, since we are actually building and not referencing one path with the other, no exception occurs in any of the previous four cases");
        printOrangeGenericLn(path1.resolve(path2));
        printOrangeGenericLn(path2.resolve(path1));
        printOrangeGenericLn(path1.resolve(path3));
        printOrangeGenericLn(path3.resolve(path1));

        printGreenGenericLn("Relativize is a reference point from A to B");
        printGreenGenericLn(
            "Resolve is also a sort of reference point from A to B, but the resolution results in B itself with a full path");
        printGreenGenericLn(
            "Resolves always considers all elements of the path to have a directory form and if it needs to append, it will append the full name");

    }
}
