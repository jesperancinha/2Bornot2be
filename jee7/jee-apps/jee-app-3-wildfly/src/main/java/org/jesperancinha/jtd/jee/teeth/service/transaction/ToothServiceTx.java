package org.jesperancinha.jtd.jee.teeth.service.transaction;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.jtd.jee.teeth.domain.Tooth;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.TransactionSynchronizationRegistry;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ToothServiceTx {

    @PersistenceContext(unitName = "primary", type = PersistenceContextType.TRANSACTION)
    private EntityManager entityManager;

    @Resource
    TransactionSynchronizationRegistry tsr;

    //  WFLYEJB0034: EJB Invocation failed on component ToothService for method
    //  public org.jesperancinha.jtd.jee.teeth.domain.Tooth
    //  org.jesperancinha.jtd.jee.teeth.service.transaction.ToothService.addToothNone
    //  (org.jesperancinha.jtd.jee.teeth.domain.Tooth):
    //  javax.ejb.EJBException: javax.persistence.TransactionRequiredException:
    //  WFLYJPA0060: Transaction is required to perform this operation
    //  (either use a transaction or extended persistence context)
    public Tooth addToothNone(final Tooth tooth) {
        Consolerizer.printGreenGenericLn(tsr.getTransactionKey());
        final Tooth merge = entityManager.merge(tooth);
        Consolerizer.printGreenGenericLn(tsr.getTransactionKey());
        return merge;
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    public Tooth addToothSupports(final Tooth tooth) {
        final Tooth merge = entityManager.merge(tooth);
        Consolerizer.printGreenGenericLn(tsr.getTransactionKey());
        return merge;
    }

    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public Tooth addToothMandatory(final Tooth tooth) {
        Consolerizer.printGreenGenericLn(tsr.getTransactionKey());
        final Tooth merge = entityManager.merge(tooth);
        Consolerizer.printGreenGenericLn(tsr.getTransactionKey());
        return merge;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
    public Tooth addTootRequiresNew(final Tooth tooth) {
        Consolerizer.printGreenGenericLn(tsr.getTransactionKey());
        final Tooth merge = entityManager.merge(tooth);
        Consolerizer.printGreenGenericLn(tsr.getTransactionKey());
        return merge;
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public Tooth addToothNotSupported(final Tooth tooth) {
        final Tooth merge = entityManager.merge(tooth);
        Consolerizer.printGreenGenericLn(tsr.getTransactionKey());
        return merge;
    }

}
