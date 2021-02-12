package org.jesperancinha.jtd.jee.app1.domain;

import org.jesperancinha.console.consolerizer.Consolerizer;

import javax.enterprise.event.Event;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.util.List;

import static org.jesperancinha.console.consolerizer.Consolerizer.printBlueGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printOrangeGenericLn;
import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;

public class ManagedBeanAlbumDao implements AlbumDao {

    @Inject
    private EntityManager entityManager;

    @Inject
    private UserTransaction utx;

    @Inject
    private Event<Album> albumEvent;

    @Inject
    private FacesContext facesContext;

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
                Consolerizer.typingWaitGlobal = 0;
                final long newId = getNewId();
                printOrangeGenericLn("The highest id is %d", newId);
                utx.begin();
                entityManager.persist(album);
            } catch (IllegalStateException e) {
                printOrangeGenericLn(e);
            } finally {
                utx.commit();
                Consolerizer.printBrightMagentaGenericLn("Triggering Event for album %s", album);
                albumEvent.fire(album);
            }
        } catch (Exception e) {
            try {

                printBlueGenericLn(e);
                if (e instanceof IllegalStateException) {
                    throw e;
                }
                printOrangeGenericLn(
                        "You have been assigned id %d. This won't work because it matches an id already in the database",
                        album.getId());
                printOrangeGenericLn("We'll start a new transaction to merge this record.");
                printRedGenericLn(
                        "This failed now, and that is probably because the H2 database SEQUENCE hasn't passed the initial registries.");
                printRedGenericLn(
                        "Remember that a direct insert upon initialization does not affect the sequence counters.");
                printRedGenericLn(
                        "A better way to deal with ID's is with UUID's. This will be shown in further implementations.");
                utx.begin();
                entityManager.merge(album);
                utx.commit();
                albumEvent.fire(album);
                FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully created album!", "This album registration has been a success!");
                facesContext.addMessage(null, m);
            } catch (IllegalStateException illegalStateException) {
                throw illegalStateException;
            } catch (Exception se) {
                try {
                    utx.rollback();
                } catch (IllegalStateException illegalStateException) {
                    throw illegalStateException;
                } catch (Exception syse) {
                    throw new RuntimeException(syse);
                }
            }
        }
    }

    private long getNewId() {
        return getAllAlbums().stream()
                .max((x, y) -> Math.toIntExact(x.getId() - y.getId()))
                .map(Album::getId)
                .orElse(0L) + 1;
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
