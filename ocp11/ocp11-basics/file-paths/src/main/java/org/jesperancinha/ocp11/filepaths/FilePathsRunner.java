package org.jesperancinha.ocp11.filepaths;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * If the number of elements exceeds the path elements then the call to getName will throw an IllegalArgumentException.
 */
public class FilePathsRunner {
    public static void main(String[] args) throws IOException {

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

        testWritePaths();
    }

    private static void testWritePaths() throws IOException {
        Path p1 = Paths.get("/tmp/text1.txt");
        Path p2 = p1.resolveSibling("text2.txt");

        // Resolve just concatenates
        /// tmp/text1.txt/text2.txt
        p1.resolve("text2.txt");

        // Relativize never uses String as an input parameter
        // p1.relativize("/tmp/text2.txt");

        // This compiles but it will result in
        // Method threw 'java.lang.IllegalArgumentException' exception.
        // This is because text2.txt as a parameter results in a different kind of path which cannot be relativized to p1.
        // p1.relativize(Paths.get("text2.txt"));

        BufferedWriter bw = new BufferedWriter(new FileWriter(p2.toFile()));
        bw.write("hello");
        bw.close();
    }
}
