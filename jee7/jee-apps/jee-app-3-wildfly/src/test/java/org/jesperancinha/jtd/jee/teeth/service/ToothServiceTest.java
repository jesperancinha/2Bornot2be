package org.jesperancinha.jtd.jee.teeth.service;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jesperancinha.console.consolerizer.ConColor;
import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.jtd.jee.teeth.Resources;
import org.jesperancinha.jtd.jee.teeth.domain.Jaw;
import org.jesperancinha.jtd.jee.teeth.domain.Nerve;
import org.jesperancinha.jtd.jee.teeth.domain.Tooth;
import org.jesperancinha.jtd.jee.teeth.domain.ToothType;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJBException;
import javax.inject.Inject;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class ToothServiceTest {

    @Inject
    ToothService toothService;

    @Inject
    JawService jawService;

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
            .addClasses(ToothType.class, Nerve.class, Jaw.class, JawService.class, ToothService.class, Tooth.class, Resources.class,
                UserTransaction.class, EntityManager.class, Consolerizer.class, ConColor.class)
            .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsWebInfResource("test-ds.xml");
    }

    @Test
    public void createTooth_whenGood_thenOk()
        throws HeuristicRollbackException, RollbackException, SystemException, NamingException, HeuristicMixedException,
        NotSupportedException {

        final var tooth = new Tooth();
        final var uuid = UUID.randomUUID();
        tooth.setUuid(uuid);

        final var jaw = new Jaw();
        jaw.setUuid(UUID.randomUUID());
        final Jaw jaw1 = jawService.updateItRight(jaw);

        tooth.setJaw(jaw);

        final Tooth tooth1 = toothService.updateItRight(tooth);
        Consolerizer.printOrangeGenericLn(tooth1);
        final Tooth toothResult = toothService.findTooth(uuid);

        Consolerizer.printOrangeGenericLn(toothResult);
        assertEquals(tooth1.getUuid(), toothResult.getUuid());
        assertEquals(jaw1.getUuid(), toothResult.getJaw().getUuid());
    }

    @Test(expected = EJBException.class)
    public void updateToothJustMerge() {
        final var tooth = new Tooth();
        final var uuid = UUID.randomUUID();
        tooth.setUuid(uuid);
        toothService.updateToothJustMerge(tooth);
    }

    @Test(expected = EJBException.class)
    public void updateToothGetEntityManager() {
        final var tooth = new Tooth();
        final var uuid = UUID.randomUUID();
        tooth.setUuid(uuid);
        toothService.updateToothGetEntityManager(tooth);
    }
}
