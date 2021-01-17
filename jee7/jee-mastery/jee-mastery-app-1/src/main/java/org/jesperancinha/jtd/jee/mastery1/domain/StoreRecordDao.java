package org.jesperancinha.jtd.jee.mastery1.domain;

import java.util.List;

public interface StoreRecordDao {
    StoreRecord getAlbumById(String name);

    void createAlbum(StoreRecord album);

    List<StoreRecord> getAllAlbums();
}
