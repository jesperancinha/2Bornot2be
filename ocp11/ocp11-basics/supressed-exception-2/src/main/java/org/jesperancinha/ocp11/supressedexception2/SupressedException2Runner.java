package org.jesperancinha.ocp11.supressedexception2;

import java.io.IOException;

public class SupressedException2Runner implements AutoCloseable{

    private final String name;

    public SupressedException2Runner(String name) throws IOException {
        this.name = name;
        if ("H3N2".equals(name))
            throw new IOException("No treatment found yet for virus " + name);
        System.out.println(name + " virus");
    }

    public void close() {
        System.out.println("Closing process on virus " + this.name);
        throw new RuntimeException("Failed to stop virus process! This is the suppressed exception for virus " + this.name);
    }

    public static void main(String[] args) throws Exception {
        try (SupressedException2Runner d1 = new SupressedException2Runner("H1N1");
             SupressedException2Runner d2 = new SupressedException2Runner("H3N2")) {
            throw new Exception("Process would be aborted here if no failure was to be found.");
        }
    }
}
