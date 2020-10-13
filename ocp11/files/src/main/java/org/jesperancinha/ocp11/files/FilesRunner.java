package org.jesperancinha.ocp11.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class FilesRunner {
    public static void main(String[] args) throws IOException {
        final String fileName = "/tmp/test.txt";
        final Stream<String> lines = Files.lines(Paths.get(fileName));
        lines.forEach(System.out::println);

        final List<String> newLines = Files.readAllLines(Paths.get(fileName));
        newLines.forEach(System.out::println);
    }
}
