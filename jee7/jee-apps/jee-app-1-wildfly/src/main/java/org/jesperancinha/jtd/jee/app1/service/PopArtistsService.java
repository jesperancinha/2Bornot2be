package org.jesperancinha.jtd.jee.app1.service;

import javax.enterprise.inject.Model;
import java.util.Arrays;
import java.util.List;

@Model
public class PopArtistsService {

    public List<String> popArtists() {
        return Arrays.asList("Ariana Grande", "Lana del Rey", "Madonna", "M.I.A.", "Nicky Minaj", "Cardi B");
    }
}
