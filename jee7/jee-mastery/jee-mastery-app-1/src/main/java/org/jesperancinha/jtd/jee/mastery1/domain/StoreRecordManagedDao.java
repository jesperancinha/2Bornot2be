package org.jesperancinha.jtd.jee.mastery1.domain;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Transactional
public class StoreRecordManagedDao implements StoreRecordDao, Serializable {

    @Inject
    private EntityManager entityManager;

    @Override
    public StoreRecord getAlbumById(String id) {
        return entityManager.find(StoreRecord.class, id);
    }

    @Override
    public void createAlbum(StoreRecord album) {
        entityManager.persist(album);
    }

    @Override
    public List<StoreRecord> getAllAlbums() {
        Query query = entityManager.createQuery("select a from storeRecord a where a.albumName = :albumName");
        return (List<StoreRecord>) query.getResultList();
    }
}
