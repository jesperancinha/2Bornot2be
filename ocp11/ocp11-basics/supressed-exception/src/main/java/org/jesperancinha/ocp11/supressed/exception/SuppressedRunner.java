package org.jesperancinha.ocp11.supressed.exception;

import java.io.IOException;

public class SuppressedRunner implements AutoCloseable {

    public void open() throws IOException {
        System.out.println("SupressedRunner Opened");
        throw new IOException("Unknown");
    }

    public String read() throws IOException {
        return "";
    }

    public void close() {
        System.out.println("Closing device");
        throw new RuntimeException("This one is the suppressed one!");
    }

    public static void main(String[] args) throws Exception {
        try (SuppressedRunner d = new SuppressedRunner()) {
            throw new Exception("Have a look to see what gets suppressed. In other words, just run.");
        }
    }
}

