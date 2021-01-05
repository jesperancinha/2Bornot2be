package org.jesperancinha.jtd.jee.lyrics.service;

import org.jesperancinha.console.consolerizer.Consolerizer;

import java.io.BufferedInputStream;
import java.io.IOException;

public class LyricsService {

    private final static String[] FILES = { "all.rise.txt", "boys.in.the.band.txt", "could.it.be.magic.txt",
        "the.one.txt" };

    public String getRandomLyric() {
        var i = (int) (Math.random() * FILES.length);

        final var resourceAsStream = getClass().getResourceAsStream("/" + FILES[i]);

        try (final var bis = new BufferedInputStream(resourceAsStream)) {
            return new String(bis.readAllBytes());
        } catch (IOException e) {
            Consolerizer.printRedThrowableAndExit(e);
        }

        return null;
    }
}
