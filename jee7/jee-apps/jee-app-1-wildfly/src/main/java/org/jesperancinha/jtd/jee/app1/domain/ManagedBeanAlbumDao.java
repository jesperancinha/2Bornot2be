package org.jesperancinha.jtd.jee.app1.domain;

import org.jesperancinha.console.consolerizer.Consolerizer;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.util.List;

import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;

public class ManagedBeanAlbumDao implements AlbumDao {

    @Inject
    private EntityManager entityManager;

    @Inject
    private UserTransaction utx;

    @Override
    public Album getAlbumForName(String name) {
        try {
            Album album;
            try {
                utx.begin();
                Query query = entityManager.createQuery("select a from Album a where a.albumName = :albumName");
                query.setParameter("albumName", name);
                album = (Album) query.getSingleResult();
            } catch (NoResultException e) {
                printRedGenericLn(e);
                album = null;

            }
            utx.commit();
            return album;
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (SystemException se) {
                printRedGenericLn(se);
                throw new RuntimeException(se);
            }
            throw new RuntimeException(e);
        }
        // Unreachable statement
        // return null;
    }

    @Override
    public void createAlbum(Album album) {
        try {
            try {
                utx.begin();
                entityManager.persist(album);
            } finally {
                utx.commit();
            }
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (SystemException se) {
                printRedGenericLn(se);
                throw new RuntimeException(se);
            }
            printRedGenericLn(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Album> getAllAlbums() {
        Consolerizer.printRainbowTitleLn("Getting all albums via %s", ManagedBeanAlbumDao.class.getName());
        try {
            List<Album> albumList;
            try {
                utx.begin();
                Query query = entityManager.createQuery("select a from Album a");
                albumList = query.getResultList();
            } catch (NoResultException e) {
                printRedGenericLn(e);
                albumList = null;

            }
            utx.commit();
            return albumList;
        } catch (Exception e) {
            try {
                utx.rollback();
            } catch (SystemException se) {
                printRedGenericLn(se);
                throw new RuntimeException(se);
            }
            throw new RuntimeException(e);
        }
    }
}
