package org.jesperancinha.ocp11.relativize;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Remember that filenames, or what is seems to be filenames, actually count as folders.
 * Don't think about files and the results will be easy to understand.
 */
public class RelativizeRunner {

    public static void main(String[] args) {
        Path p1 = Paths.get("//personal//.//photos//..//readme.txt");
        System.out.println(p1);
        Path p2 = Paths.get("//personal//index.html");
        System.out.println(p2);
        Path p3 = p1.relativize(p2);
        System.out.println(p3);
    }

}
