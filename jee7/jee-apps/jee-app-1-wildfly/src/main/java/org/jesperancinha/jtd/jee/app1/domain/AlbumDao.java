package org.jesperancinha.jtd.jee.app1.domain;

public interface AlbumDao {

    Album getAlbumForName(String name);

    void createAlbum(Album album);
}
