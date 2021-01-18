package org.jesperancinha.jtd.jee.mastery1.domain;

import org.jesperancinha.console.consolerizer.ConsolerizerColor;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

@Stateless
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class StoreRecordManagedDao implements StoreRecordDao, Serializable {

    @Inject
    private EntityManager entityManager;

    @Override
    public StoreRecord getAlbumById(String id) {
        return entityManager.find(StoreRecord.class, id);
    }

    @Override
    public void createAlbum(StoreRecord album) {
        ConsolerizerColor.BRIGHT_BLUE.printGenericLn("We are using a new transaction bean per session %s because it is stateless -> %s", this.getClass(), this.hashCode());
        entityManager.persist(album);
    }

    @Override
    public List<StoreRecord> getAllAlbums() {
        Query query = entityManager.createQuery("select a from storeRecord a where a.albumName = :albumName");
        return (List<StoreRecord>) query.getResultList();
    }
}
