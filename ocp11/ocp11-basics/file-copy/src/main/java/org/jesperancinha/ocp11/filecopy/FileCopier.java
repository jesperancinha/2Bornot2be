package org.jesperancinha.ocp11.filecopy;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Please refer to Readme.md to understand the changes and the purpose of this exercise.
 */
public class FileCopier {
    public static void copy1(Path p1, Path p2) throws Exception {
        Files.copy(p1, p2, StandardCopyOption.COPY_ATTRIBUTES, StandardCopyOption.REPLACE_EXISTING);
    }

    public static void main(String[] args) throws Exception {
        Path p1 = Paths.get("/tmp/test1.txt");
        Path p2 = Paths.get("/tmp/test2.txt");
        copy1(p1, p2);
        if (Files.isSameFile(p1, p2)) {
            System.out.println("file copied");
        } else {
            System.out.println("unable to copy file");
        }
    }
}
