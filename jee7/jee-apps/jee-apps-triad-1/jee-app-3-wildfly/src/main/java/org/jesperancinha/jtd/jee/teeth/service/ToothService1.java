package org.jesperancinha.jtd.jee.teeth.service;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.jtd.jee.teeth.domain1.Tooth;

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
import java.util.UUID;

import static org.jesperancinha.console.consolerizer.Consolerizer.printYellowGenericLn;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ToothService1 {

    @PersistenceContext(unitName = "primary")
    private EntityManager entityManager;


    // WFLYJPA0059: javax.persistence.PersistenceContext injection target is invalid.  Only setter methods are allowed:
    // @PersistenceContext(unitName = "primary")
    // from ResourceInjectionAnnotationParsingProcessor: https://stackoverflow.com/questions/18019947/resource-injection-target-is-invalid-only-setter-methods-are-allowed
    public Tooth findTooth(UUID uuid) {
        return entityManager.find(Tooth.class, uuid);
    }

    public Tooth updateItRight(final Tooth tooth)
        throws NamingException, HeuristicMixedException, HeuristicRollbackException,NotSupportedException, SystemException, RollbackException {
        var context = new InitialContext();


        printYellowGenericLn("Because we are using %s, this means we cannot perform UserTransaction code.");
        printYellowGenericLn("This get's done by the container itself");
        printYellowGenericLn("And so the code changes a bit to avoid the following error:");
        printYellowGenericLn("javax.naming.NameNotFoundException: UserTransaction\n"
            + "        at deployment.test.war//org.jesperancinha.jtd.jee.teeth.service.ToothService1Test.findTooth(ToothService1Test.java:53)\n"
            + "Caused by: java.lang.IllegalStateException: WFLYEJB0137: Only session and message-driven beans with bean-managed transaction demarcation are allowed to access UserTransaction\n"
            + "        at deployment.test.war//org.jesperancinha.jtd.jee.teeth.service.ToothService1Test.findTooth(ToothService1Test.java:53)");
        // javax.naming.NameNotFoundException: UserTransaction
        //        at deployment.test.war//org.jesperancinha.jtd.jee.teeth.service.ToothService1Test.findTooth(ToothService1Test.java:53)
        //Caused by: java.lang.IllegalStateException: WFLYEJB0137: Only session and message-driven beans with bean-managed transaction demarcation are allowed to access UserTransaction
        //        at deployment.test.war//org.jesperancinha.jtd.jee.teeth.service.ToothService1Test.findTooth(ToothService1Test.java:53)
        // var utx = (UserTransaction) context.lookup("java:comp/UserTransaction");
//        utx.begin();
        final Tooth merge = entityManager.merge(tooth);
        entityManager.lock(merge, LockModeType.NONE);
        final Tooth mergeResult2 = entityManager.merge(merge);
//        utx.commit();
        return mergeResult2;
    }

    public Tooth updateToothJustMerge(final Tooth tooth) {
       return entityManager.merge(tooth);
    }

    // WFLYEJB0034: EJB Invocation failed on component ToothService for method
    // public void org.jesperancinha.jtd.jee.teeth.service.ToothService.updateToothGetEntityManager(org.jesperancinha.jtd.jee.teeth.domain.Tooth):
    // javax.ejb.EJBException: java.lang.IllegalStateException:
    // A JTA EntityManager cannot use getTransaction()
    public void updateToothGetEntityManager(final Tooth tooth) {
        final var transaction1 = entityManager.getTransaction();
        Consolerizer.printBrightMagentaGenericLn(transaction1);
        transaction1
            .begin();
        entityManager.merge(tooth);
        final var transaction2 = entityManager.getTransaction();
        Consolerizer.printBrightMagentaGenericLn(transaction2);
        transaction2
            .commit();
    }
}
