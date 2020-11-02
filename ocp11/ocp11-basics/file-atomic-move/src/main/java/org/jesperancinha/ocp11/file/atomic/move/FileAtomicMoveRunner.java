package org.jesperancinha.ocp11.file.atomic.move;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * ATOMIC_MOVE means that the file is moved in an atomic system operation.
 * This means no operation is possible until the move is complete.
 * Not the ATOMIC_MOVE creates an implementation dependant situation if the file exists. A successful move always removes the source file.
 * <p>
 * In this example, a  {@link java.nio.file.NoSuchFileException} is thrown given that {@link Path} p1 doesn't exist anymore after the move.
 */
public class FileAtomicMoveRunner {

    public static void main(String[] args) throws IOException {
        Path p1 = Paths.get("/tmp/atomic-file-1.txt");
        Path p2 = Paths.get("/tmp/new-folder/atomic-file-1.txt");
        Files.move(p1, p2, StandardCopyOption.ATOMIC_MOVE);
        Files.delete(p1);
        System.out.println(p1.toFile().exists() + " " + p2.toFile().exists());
    }
}
