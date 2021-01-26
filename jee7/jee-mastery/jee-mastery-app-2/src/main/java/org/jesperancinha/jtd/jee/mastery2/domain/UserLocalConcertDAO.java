package org.jesperancinha.jtd.jee.mastery2.domain;

import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import java.io.Serializable;

@Stateless
public class UserLocalConcertDAO implements Serializable {

    public void updateConcert2(final Concert concert) throws NamingException, SystemException, NotSupportedException, HeuristicRollbackException, HeuristicMixedException, RollbackException {
        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("secondary");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();
        final Concert concert1 = entityManager.find(Concert.class, concert.getUuid());
        entityManager.getTransaction().begin();
        entityManager.merge(concert1);
        entityManager.getTransaction().commit();
    }
}
