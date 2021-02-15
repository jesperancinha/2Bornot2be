package org.jesperancinha.jtd.jee.mastery2.domain;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.Serializable;

@Stateless
public class UserLocalConcertDAO implements Serializable {

    public void updateConcert2(final Concert concert) {
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("secondary");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final Concert concert1 = entityManager.find(Concert.class, concert.getUuid());
        entityManager.getTransaction().begin();
        entityManager.merge(concert1);
        entityManager.getTransaction().commit();
    }
}
