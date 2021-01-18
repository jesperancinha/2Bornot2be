package org.jesperancinha.jtd.jee.teeth.service;

import org.jesperancinha.jtd.jee.teeth.domain.Tooth;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.util.List;
import java.util.UUID;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BRIGHT_MAGENTA;

/**
 * Note that var utx = (UserTransaction) context.lookup("java:comp/UserTransaction") is only found because of:
 * @TransactionManagement(TransactionManagementType.BEAN)
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class ToothService {

    @PersistenceContext(unitName = "primary")
    private EntityManager entityManager;

    // WFLYJPA0059: javax.persistence.PersistenceContext injection target is invalid.  Only setter methods are allowed:
    // @PersistenceContext(unitName = "primary")
    // from ResourceInjectionAnnotationParsingProcessor: https://stackoverflow.com/questions/18019947/resource-injection-target-is-invalid-only-setter-methods-are-allowed
    public Tooth findTooth(UUID uuid) {
        return entityManager.find(Tooth.class, uuid);
    }

    public List<Tooth> findAll() {
        return entityManager.createQuery("from Tooth")
            .getResultList();
    }

    public Tooth updateItRight(final Tooth tooth)
        throws NamingException, HeuristicMixedException, HeuristicRollbackException, NotSupportedException,
        SystemException, RollbackException {
        var context = new InitialContext();
        var utx = (UserTransaction) context.lookup("java:comp/UserTransaction");
        utx.begin();
        final Tooth merge = entityManager.merge(tooth);
        entityManager.lock(merge, LockModeType.NONE);
        final Tooth mergeResult2 = entityManager.merge(merge);
        utx.commit();
        return mergeResult2;
    }

    // WFLYEJB0034: EJB Invocation failed on component ToothService for method
    // public void org.jesperancinha.jtd.jee.teeth.service.ToothService.updateToothJustMerge(org.jesperancinha.jtd.jee.teeth.domain.Tooth):
    // javax.ejb.EJBException: javax.persistence.TransactionRequiredException:
    // WFLYJPA0060: Transaction is required to perform this operation
    // (either use a transaction or extended persistence context)
    public void updateToothJustMerge(final Tooth tooth) {
        entityManager.merge(tooth);
    }

    // WFLYEJB0034: EJB Invocation failed on component ToothService for method
    // public void org.jesperancinha.jtd.jee.teeth.service.ToothService.updateToothGetEntityManager(org.jesperancinha.jtd.jee.teeth.domain.Tooth):
    // javax.ejb.EJBException: java.lang.IllegalStateException:
    // A JTA EntityManager cannot use getTransaction()
    public void updateToothGetEntityManager(final Tooth tooth) {
        final var transaction1 = entityManager.getTransaction();
        BRIGHT_MAGENTA.printGenericLn(transaction1);
        transaction1.begin();
        entityManager.merge(tooth);
        final var transaction2 = entityManager.getTransaction();
        BRIGHT_MAGENTA.printGenericLn(transaction2);
        transaction2.commit();
    }
}
