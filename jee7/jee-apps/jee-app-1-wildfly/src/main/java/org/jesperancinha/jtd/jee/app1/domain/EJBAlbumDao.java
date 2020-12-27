package org.jesperancinha.jtd.jee.app1.domain;

import javax.ejb.Stateful;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import static org.jesperancinha.console.consolerizer.Consolerizer.printRedGenericLn;

@Stateful
@Alternative
public class EJBAlbumDao {
    @Inject
    private EntityManager entityManager;

    public Album getForAlbumName(String username) {
        try {
            Query query = entityManager.createQuery("select a from Album a where a.albumName = ?");
            query.setParameter(1, username);
            return (Album) query.getSingleResult();
        } catch (NoResultException e) {
            printRedGenericLn(e);
            return null;
        }
    }

    public void createAlbum(Album album) {
        entityManager.persist(album);
    }
}
