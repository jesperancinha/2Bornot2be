package org.jesperancinha.jtd.jee.teeth.service.transaction;

import junit.framework.TestCase;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jesperancinha.console.consolerizer.ConColor;
import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.jtd.jee.teeth.Resources;
import org.jesperancinha.jtd.jee.teeth.domain.AbstractToothType;
import org.jesperancinha.jtd.jee.teeth.domain.FinalToothType;
import org.jesperancinha.jtd.jee.teeth.domain.Jaw;
import org.jesperancinha.jtd.jee.teeth.domain.Nerve;
import org.jesperancinha.jtd.jee.teeth.domain.Tooth;
import org.jesperancinha.jtd.jee.teeth.domain.ToothType;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

@RunWith(Arquillian.class)
public class ToothServiceTxTest extends TestCase {

    @EJB
    private ToothServiceTx toothService;

    @Resource
    private UserTransaction userTransaction;

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
            .addClasses(ToothServiceTx.class, Tooth.class, Jaw.class, Nerve.class, AbstractToothType.class,
                ToothType.class, FinalToothType.class, Resources.class, UserTransaction.class, EntityManager.class,
                Consolerizer.class, ConColor.class)
            .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
            .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
            .addAsWebInfResource("test-ds.xml");
    }

    @Test
    public void addToothNone() throws Exception {
        final Tooth tooth = new Tooth();
        tooth.setUuid(java.util.UUID.randomUUID());
        toothService.addToothNone(tooth);
    }

    @Test
    public void addToothMandatory() throws Exception {
        final Tooth tooth = new Tooth();
        tooth.setUuid(java.util.UUID.randomUUID());
        Consolerizer.printBrightMagentaGenericLn(tooth);
        userTransaction.begin();
        toothService.addToothMandatory(tooth);
        userTransaction.commit();
    }

}
