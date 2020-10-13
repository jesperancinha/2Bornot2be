package org.jesperancinha.ocp11.file.move;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FileMoveRunner {

    public static void main(String[] args) throws IOException {
        testVanilla();
        testWorking();
    }

    private static void testWorking() throws IOException {
        System.out.println("Test 2 - Testing copying to the same already existing file..");
        Path p1 = Paths.get("/tmp/src/oepsie.so/precious2.txt");
        Path p2 = Paths.get("/tmp/src/oepsie.so/precious2.txt");
        Files.move(p1, p2);
        System.out.println("Test 2 - As you can see, no exception is thrown. We are moving the same file to the same place and so no action is needed");
    }

    private static void testVanilla() {
        try {
            System.out.println("Test 1 - Testing copying to an existing file..");
            Path p1 = Paths.get("/tmp/src/oepsie.so/precious.txt");
            Path p2 = Paths.get("/tmp/out/precious.txt");
            Files.move(p1, p2);

        } catch (IOException e) {
            System.out.printf("Test 1 - As you can see, an exception is thrown. This is because the file exists: %s\n",
                    Arrays.stream(e.getStackTrace()).map(StackTraceElement::toString).collect(Collectors.joining(",\n")));
        }
    }
}
