package org.jesperancinha.jtd.jee.app1.domain;

import javax.enterprise.inject.Model;
import java.util.List;

public interface AlbumDao {

    Album getAlbumForName(String name);

    void createAlbum(Album album);

    List<Album> getAllAlbums();
}
