package org.jesperancinha.java11.mastery4dot3.community;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.java11.mastery4dot3.record.Album;

import java.util.Arrays;

public class Frenemy {
    private final String name;

    public Frenemy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void lendAlbum(Album album){
        Consolerizer.printBlueGenericLn("Thanks for the album!");
        Consolerizer.printBlueGenericLn(album);
        scratchAlbum(album);
    }

    private void scratchAlbum(Album album){
        album.getSongs().forEach(song-> Arrays.fill(song, (byte) 0));
    }

    @Override
    public String toString() {
        return "Frenemy{" + "name='" + name + '\'' + '}';
    }
}
