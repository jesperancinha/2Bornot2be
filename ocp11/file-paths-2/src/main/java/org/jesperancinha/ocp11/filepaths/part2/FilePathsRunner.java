package org.jesperancinha.ocp11.filepaths.part2;

import java.nio.file.Paths;

public class FilePathsRunner {
    public static void main(String[] args) {
        var file1 = Paths.get("/tmp/blueberries/acacias/goats");
        System.out.printf("For file %s, these are its properties:\n", file1.toString());
        System.out.printf("Root -> %s\n", file1.getRoot());
        System.out.printf("Number of names -> %d\n", file1.getNameCount());
        System.out.printf("Fist name-> %s\n", file1.getName(0).toString());
        System.out.printf("Second name-> %s\n", file1.getName(1).toString());
        System.out.printf("First to Third (remember its exclusive) name-> %s\n", file1.subpath(1, 3).toString());

    }
}
