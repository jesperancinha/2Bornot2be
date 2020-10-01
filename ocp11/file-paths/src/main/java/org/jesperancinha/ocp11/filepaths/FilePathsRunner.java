package org.jesperancinha.ocp11.filepaths;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * If the number of elements exceeds the path elements then the call to getName will throw an IllegalArgumentException.
 */
public class FilePathsRunner {
    public static void main(String[] args) {
        Path p1 = Paths.get("/code/java/pathTest.java");
        System.out.println(p1.getName(2).toString());
        System.out.println(p1.getName(3).toString());
    }
}
