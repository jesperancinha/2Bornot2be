package org.jesperancinha.ocp11.filepaths;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * If the number of elements exceeds the path elements then the call to getName will throw an IllegalArgumentException.
 */
public class FilePathsRunner {
    public static void main(String[] args) {

        System.out.println("Exercise-1");
        try {
            Path p1 = Paths.get("/code/java/pathTest.java");
            System.out.println(p1.getName(2).toString());
            System.out.println(p1.getName(3).toString());
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.toString());
        }

        System.out.println("\nExercise-2");
        Path p2 = Paths.get("/home/../temp/test.txt");
        System.out.println(p2.normalize().toUri());

        System.out.println("\nExercise-3");
        Path p3 = Paths.get("/home/test");
        System.out.println(p3.getName(0).toString());
    }

}
